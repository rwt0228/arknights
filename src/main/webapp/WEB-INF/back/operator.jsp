<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="../common/head.jsp"%>
</head>
<body>
<div class="container">
    <div id="toolbar" class="btn-group">
        <button id="btn_add" type="button" class="btn  btn-default"  onclick="oper('add')">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
        </button>
    </div>
    <table id="table"></table>
</div>

<script>
    $(function () {
        initTable();

    });

    function initTable() {
        $('#table').bootstrapTable({
            url:'/uploader/pagelist', //接口地址,注意:数据放在rows字段
            method: 'get',     //请求方式
            cache: false,      //是否使用缓存
//            toolbar:'#toolbar',//工具按钮用哪个容器
            height: 600,     //设置行高,没有设置的话,就默认取pageSize条数自适应
            striped: true,     //是否显示行间隔色
            strickSearch: true,
            sortOrder: "asc",   //排序方式
            sortable: true,   //是否启动排序
            queryParams:'',    //传递参数(*)
            jsonp: true,
            iconSize: 'outline',
            pagination: true,  //是否分页
            pageSize: 10,      //显示每页条数
            pageNumber:1,      //初始化加载第一页
            pageList: [10, 20, 50, 100, 200, 500],  //每页可显示的行数
            sidePagination:'client', //分页方式,采用  server  client
            search: true,      //是否搜索
            showColumns: true,  //是否显示所有的列
            showRefresh: true, //是否显示刷新按钮
            showExport: true,
            exportTypes: ['csv','txt','xml'],
            clickToSelect: true, //是否启动点击选中行
//            showToggle :true ,   //是否显示详细视图与列表视图
            uniqueId:"ID",       //每一行的唯一标识,一般为主键id
            cardView: false,      //是否显示详细视图
            columns: [
                {
                    field:"checked",
                    checkbox:true
                },
                {
                    field:"id",
                    title:"ID",
                    align:"center",
                    valign:"middle",
                    sortable:"true"
                },
                {
                    field:"name",
                    title:"名称",
                    align:"center",
                    valign:"middle",
                    sortable:"true"
                },
                {
                    field:"star",
                    title:"星级",
                    align:"center",
                    valign:"middle",
                    sortable:"true"
                },
                {
                    field:"avatar",
                    title:"头像",
                    align:"center",
                    valign:"middle",
                    sortable:"true",
                    formatter: imageFormatter
                },
                {
                    field: 'id',
                    title: '操作',
                    align: 'center',
                    events: operateEvents,
                    formatter: operateFormatter,
                    width: 100
                }
            ]
            //            data:datas,
        });
        var operateEvents = {
            'click .edit': function (e, value, row, index) {
                alert("编辑:"+row.id);
            },'click .remove': function (e, value, row, index) {
                alert("删除:"+row.id);
            },

        };
        function imageFormatter(value, row, index) {
            var str = '<img style="height:50px;width:50px;" src="'+value+'">';

            return str;
        };
        function operateFormatter(value, row, index) {
            return '' +
                '<a class="edit" href="javascript:void(0)" onclick="oper(\'edit\''+ ','+value+')" title="修改">' + '<i class="fa fa-edit">' + '</i></a>' + ' | ' +
                '<a class="edit" href="javascript:void(0)" onclick="goBili('+value+')" title="跳转b站">' + '<i class="fa fa-search">' + '</i></a>' + ' | ' +
                '<a class="remove" href="javascript:void(0)" onclick="del('+value+')" title="删除">' + '<i class="glyphicon glyphicon-remove-circle">' + '</i>' + '</a>'
                ;
        };
    }
</script>

</body>
</html>