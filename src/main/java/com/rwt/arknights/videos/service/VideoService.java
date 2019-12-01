package com.rwt.arknights.videos.service;

import com.rwt.arknights.common.bilibili.BiliClient;
import com.rwt.arknights.common.bilibili.VideoInfoDTO;
import com.rwt.arknights.common.util.OperatorUtils;
import com.rwt.arknights.videos.bean.ListOperatorRel;
import com.rwt.arknights.videos.bean.Video;
import com.rwt.arknights.videos.bean.VideoListRel;
import com.rwt.arknights.videos.dao.ListOperatorRelMapper;
import com.rwt.arknights.videos.dao.VideoListRelMapper;
import com.rwt.arknights.videos.dao.VideoMapper;
import com.rwt.arknights.videos.dto.NewVideoDTO;
import com.rwt.arknights.videos.dto.OperatorInfoDTO;
import com.rwt.arknights.videos.dto.QueryDTO;
import com.rwt.arknights.videos.vo.VideoVO;
import com.rwt.arknights.web.exceptionHandler.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VideoService {

    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private VideoListRelMapper videoListRelMapper;
    @Autowired
    private ListOperatorRelMapper listOperatorRelMapper;

    public void saveNewVideo(NewVideoDTO dto) {
        // 需要保存的表： video video_list_rel list_operator_rel
        int aid = dto.getAid();
        Video old = videoMapper.selectByAid(aid);
        if(old != null) throw new CustomException("该视频已经有人提交过，请勿重复提交");

        VideoInfoDTO videoInfoDTO = BiliClient.getVideoInfoDTO(aid);
        Video video = new Video();
        video.setAid(dto.getAid());
        video.setDesc(videoInfoDTO.getDesc());
        video.setImgUrl(videoInfoDTO.getPic());
        video.setStageId(dto.getStageId());
        video.setTitle(videoInfoDTO.getTitle());
        video.setTotalTag(dto.getTotalTag());
        video.setType(dto.getType());
        video.setUpName(videoInfoDTO.getUpName());
        videoMapper.save(video);

        VideoListRel listRel = new VideoListRel();
        List<OperatorInfoDTO> operatorList = dto.getOperatorList();
        listRel.setAid(aid);
        listRel.setOperatorNum(operatorList.size());
        int minJingying = 2;
        int minLevel = 90;
        int starCount = 0;
        int sumLevel = 0;
        for(OperatorInfoDTO o: operatorList) {
            starCount += o.getStar();
            sumLevel += OperatorUtils.calLevel(o.getStar(), o.getJingying(), o.getLevel());
            if(o.getJingying() < minJingying) {
                minJingying = o.getJingying();
                minLevel = o.getLevel();
            } else if(o.getJingying() == minJingying) {
                minLevel = Math.min(minLevel, o.getLevel());
            }
        }
        listRel.setAvgLevel(sumLevel / operatorList.size());
        listRel.setAvgStar( ((double)starCount / operatorList.size())); //精一50级
        String[] arr = {"零","一","二"};
        listRel.setMinLevel("精" + arr[minJingying] + minLevel + "级");
        videoListRelMapper.save(listRel);

        int listId = listRel.getId();
        List<ListOperatorRel> listOperatorRelList = new ArrayList<>();
        for(OperatorInfoDTO o: operatorList) {
            ListOperatorRel rel = new ListOperatorRel();
            rel.setListId(listId);
            rel.setJingying(o.getJingying());
            rel.setLevel(o.getLevel());
            rel.setOperatorId(o.getOperatorId());
            rel.setQianneng(o.getQianneng());
            rel.setSkill(o.getSkill() + "");
            rel.setSkillLevel(o.getSkillLevel());
            listOperatorRelList.add(rel);
        }
        listOperatorRelMapper.saveList(listOperatorRelList);
    }

    public List<VideoVO> selectPageVO(QueryDTO dto) {
        List<Integer> list = videoMapper.selectPageId(dto);
        return null;
    }
}
