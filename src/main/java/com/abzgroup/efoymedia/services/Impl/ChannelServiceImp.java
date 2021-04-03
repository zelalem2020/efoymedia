package com.abzgroup.efoymedia.services.Impl;

import com.abzgroup.efoymedia.dal.dtos.entitiyDtos.CategoryDTO;
import com.abzgroup.efoymedia.dal.dtos.entitiyDtos.ChannelDTO;
import com.abzgroup.efoymedia.dal.model.Category;
import com.abzgroup.efoymedia.dal.model.Channel;
import com.abzgroup.efoymedia.dal.repositories.CategoryRepo;
import com.abzgroup.efoymedia.dal.repositories.ChannelRepo;
import com.abzgroup.efoymedia.services.ChannelService;
import com.abzgroup.efoymedia.utilities.MultiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelServiceImp implements ChannelService {

    @Autowired
    private ChannelRepo channelRepo;

    @Autowired
    private MultiMapper multiMapper;

    @Override
    public List<ChannelDTO> getAllChannels() {
        List<Channel> channelList = channelRepo.findAll();

        return multiMapper.mapList(channelList, ChannelDTO.class);
    }

    @Override
    public List<ChannelDTO> addChannels(List<ChannelDTO> channelDTOList) {

        List<Channel> channelListToSave = multiMapper.mapList(channelDTOList, Channel.class);
        try {
             List<Channel> channelListSaved = channelRepo.saveAll(channelListToSave);
             List<ChannelDTO> channelDTOListSaved = multiMapper.mapList(channelListSaved, ChannelDTO.class);

            return channelDTOListSaved;
        }catch (Exception e) {
            return new ArrayList<>();
        }

    }
}
