package com.abzgroup.efoymedia.services;

import com.abzgroup.efoymedia.dal.dtos.entitiyDtos.CategoryDTO;
import com.abzgroup.efoymedia.dal.dtos.entitiyDtos.ChannelDTO;

import java.util.List;

public interface ChannelService {

    List<ChannelDTO> getAllChannels();
    List<ChannelDTO> addChannels(List<ChannelDTO> channelDTOList);
}
