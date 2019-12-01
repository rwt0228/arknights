package com.rwt.arknights.log.service;

import com.rwt.arknights.common.util.IpUtils;
import com.rwt.arknights.log.bean.Log;
import com.rwt.arknights.log.dao.LogMapper;
import com.rwt.arknights.videos.dto.NewVideoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
@Transactional
public class LogService {

    @Autowired
    private LogMapper logMapper;

    public int save(Log log) {
        return logMapper.save(log);
    }

    public void addNewVideo(NewVideoDTO dto, HttpServletRequest request) {
        Log log = new Log();
        log.setAddTime(new Date());
        log.setIp(IpUtils.getIpAddr(request));
        log.setContent("提交保存视频,AV号:" + dto.getAid());
        save(log);
    }
}
