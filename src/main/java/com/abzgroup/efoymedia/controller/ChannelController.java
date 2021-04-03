package com.abzgroup.efoymedia.controller;

import com.abzgroup.efoymedia.dal.dtos.entitiyDtos.CategoryDTO;
import com.abzgroup.efoymedia.dal.dtos.entitiyDtos.ChannelDTO;
import com.abzgroup.efoymedia.dal.dtos.requestDtos.RequestDTO;
import com.abzgroup.efoymedia.dal.dtos.responseDtos.ResponseDTO;
import com.abzgroup.efoymedia.services.CategoryService;
import com.abzgroup.efoymedia.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChannelController {

    @Autowired
    private ChannelService channelService;


    @PostMapping(value = "/channel")
    public ResponseDTO addChannel(@RequestBody ChannelDTO channelDTO) {
        return new ResponseDTO();
    }

    @GetMapping(value = "/channels")
    public ResponseDTO getAllChannels(@RequestParam(defaultValue = "100") int pageSize, @RequestParam(defaultValue = "1") int pageIndex) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            responseDTO.setStatus(true);
            responseDTO.setPayload(channelService.getAllChannels());
            responseDTO.setMessage("Successfully inserted");
        } catch (Exception e) {
            responseDTO.setStatus(true);
            responseDTO.setMessage(" Error inserted value " + e.getMessage());
        }
        return responseDTO;
    }

    @PostMapping(value = "/channels")
    public ResponseDTO addChannels(@RequestBody List<ChannelDTO> channelDTOList) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setPayload(channelService.addChannels(channelDTOList));
        return responseDTO;
    }
}
