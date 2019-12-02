const VideoInfo = {
    template: '#videoInfo',
    data() {
        return {
            visible: false,
            info: {
                aid: 1,
                upName: '',
                title: '',
                desc: '',
                pic: '',
            }
        }
    },
    methods: {
        async show(aid) {
            var res = await axios.post('/video/getInfo?aid=' + aid);
            if(!res.data.status) {
                this.$message.error(res.data.message);
                return;
            }
            this.info = res.data.data;
            this.visible = true;
        }
    }
};
const SelectOperator = {
    template: '#selectOperator',
    data() {
        return {
            filterText: '',
            visible: false,
            data: operators,
            defaultProps: {
                children: 'children',
                label: 'name',
            }
        }
    },
    methods: {
        show() {
            this.visible = true;
        },
        filterNode(value, data) {
            if (!value) return true;
            return data.name.indexOf(value) !== -1;
        },
        confirm() {
            var arr = this.$refs.tree.getCheckedNodes();
            for (var i = 0; i < arr.length; i++) {
                if (!arr[i].id) {
                    arr.splice(i, 1); // 将使后面的元素依次前移，数组长度减1
                    i--; // 如果不减，将漏掉一个元素
                }
            }
            if(arr.length > 13) {
                this.$message.error('最多加入13名干员');
                return;
            }
            this.$emit('confirm',arr);
            this.visible = false;
        }
    },
    watch: {
        filterText(val) {
            this.$refs.tree.filter(val);
        }
    }
};
const Share = {
    data() {
        var checkAid = (rule, value, callback) => {
            if (!value) {
                return callback(new Error('请输入av号'));
            }
            if (value %1 !== 0) {
                callback(new Error('请输入数字值'));
            } else {
                callback();
            }
        };
        return {
            share_form: {
                aid: null,
                type: "1",
                stage_id: 5,
                total_tag: 1,
                is_tag: false,
            },
            rules: {
                aid: [
                    { required: true, message: '请输入av号', trigger: 'blur' },
                    { validator: checkAid, trigger: 'blur' }
                ],
                type: [
                    { required: true, message: '请选择视频类型', trigger: 'blur' },
                ],
                stage_id: [
                    { required: true, message: '请选择关卡代号', trigger: 'blur' },
                ]
            },
            operators:[],
            stage_type_list: stageTypeList,
            stage_map: stageMap,
            stage_type: '主线剧情',
        }
    },
    methods: {
        async onSubmit() {
            var arr = this.operators;
            this.$refs['share_form'].validate((valid) => {
                if (!valid) {
                    return false;
                }
            });
            var res = await axios.post('/video/getInfo?aid=' + this.share_form.aid);
            if(!res.data.status) {
                this.$message.error(res.data.message);
                return;
            }
            if(arr.length == 0) {
                this.$message.error('至少选择一名干员');
                return;
            }
            for(var i = 0; i < arr.length; i++) {
                var o = arr[i];
                if(!o.jingying) {
                    this.$message.error(o.name + '的精英化不能为空');
                    return;
                }
                if(!o.level) {
                    this.$message.error(o.name + '的干员等级不能为空');
                    return;
                }
            }
            this.executeSubmit();
        },
        executeSubmit() {
            var data = this.getSubmitJson();
            var _this = this;
            const loading = this.$loading({
                lock: true,
                text: '正在提交数据',
                spinner: 'el-icon-loading',
                background: 'rgba(0, 0, 0, 0.7)'
            });
            axios({
                url:'/video/save',
                method: 'post',
                data: data,
                headers:{
                    'Content-Type':'application/json'
                }
            }).then(function(res){
                var res = res.data;
                if(res.status) {
                    _this.$message({
                        message: '保存成功',
                        type: 'success'
                    });
                    setTimeout(function(){history.go(0) }, 2000);
                } else {
                    _this.$message.error(res.message);
                }
                loading.close();

            }).catch(function (error) {
                console.info(error);
                _this.$message.error("出现未知异常，请联系管理员");
                loading.close();
            });
        },
        getSubmitJson() {
            var obj = {};
            obj.aid = this.share_form.aid;
            obj.type = this.share_form.type;
            obj.stageId = this.share_form.stage_id;
            if(this.share_form.is_tag) {
                obj.totalTag = this.share_form.total_tag;
            }
            var arr = [];
            for(var i = 0; i < this.operators.length; i++) {
                var o = this.operators[i];
                var newO = {};
                newO.operatorId = o.id;
                newO.star = o.star;
                newO.jingying = o.jingying;
                newO.level = o.level;
                newO.skill = o.skill ? o.skill : 0;
                newO.skillLevel = o.skill_level ? o.skill_level : 0;
                newO.qianneng = o.qianneng ? o.qianneng : 0;
                arr.push(newO);
            }
            obj.operatorList = arr;
            return JSON.stringify(obj);
        },
        clickOperator() {
            this.$refs.select_operator.show();
        },
        clickVideoInfo() {
            if (!this.share_form.aid) {
                this.$message({
                    message: '请先输入AV号',
                    type: 'warning'
                });
                return;
            }
            this.$refs.video_info.show(this.share_form.aid);
        },
        changeType() {
            this.share_form.stage_id = this.stage_map[this.stage_type][0].id;
            var list = this.stage_type_list;
            var type = this.stage_type;
            for (var i = 0; i < list.length; i++) {
                if (list[i].description == type) {
                    this.share_form.is_tag = list[i].isTag;
                    break;
                }
            }
        },
        confirmOperators(arr) {
            this.operators = arr;
        }
    },
    computed: {
        stages: function () {
            return stageMap[this.stage_type];
        }
    },
    template: '#share',
    components: {
        'select-operator': SelectOperator,
        'video_info': VideoInfo,
    }
};
