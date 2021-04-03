package com.abzgroup.efoymedia.services;

import com.abzgroup.efoymedia.dal.dtos.entitiyDtos.ChannelDTO;
import com.abzgroup.efoymedia.dal.dtos.entitiyDtos.VideoDTO;

import java.util.List;

public interface VideoService {
    List<VideoDTO> getAllVideos();
    List<VideoDTO> addVideos(List<VideoDTO> videoDTOList);
}
