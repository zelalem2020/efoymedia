package com.abzgroup.efoymedia.controller;

import com.abzgroup.efoymedia.dal.dtos.entitiyDtos.ChannelDTO;
import com.abzgroup.efoymedia.dal.dtos.entitiyDtos.VideoDTO;
import com.abzgroup.efoymedia.dal.dtos.responseDtos.ResponseDTO;
import com.abzgroup.efoymedia.services.VideoService;
import com.abzgroup.efoymedia.utilities.SingleMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class VideoController {
    @Autowired
    private VideoService videoService;

    @Autowired
    private SingleMapper singleMapper;

    @GetMapping(value = "/test")
    public void test() {
        JSONObject jsonObject = new JSONObject("{\"id\":789879}");
        HashMap<String, Object> stringHashMap = null;
        try {
            stringHashMap = new ObjectMapper().readValue(jsonObject.toString(), HashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//        stringHashMap.put("id", new ChannelDTO());

        ChannelDTO channelDTO = singleMapper.mapSingle(stringHashMap, ChannelDTO.class);
        System.out.println(channelDTO);
    }

    @PostMapping(value = "/video")
    public ResponseDTO addVideo(@RequestBody VideoDTO videoDTO) {

        return new ResponseDTO();
    }


    @GetMapping(value = "/videos")
    public ResponseDTO getAllVideos(@RequestParam(defaultValue = "100") int pageSize, @RequestParam(defaultValue = "1") int pageIndex) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            responseDTO.setStatus(true);
            responseDTO.setPayload(videoService.getAllVideos());
            responseDTO.setMessage("Successfully retrieved");
        } catch (Exception e) {
            responseDTO.setStatus(true);
            responseDTO.setMessage(" Error retrieving value " + e.getMessage());
        }
        return responseDTO;
    }

    @PostMapping(value = "/videos")
    public ResponseDTO addVideos(@RequestBody List<VideoDTO> videoDTOList) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            responseDTO.setStatus(true);
            responseDTO.setPayload(videoService.addVideos(videoDTOList));
            responseDTO.setMessage("Successfully inserted");
        } catch (Exception e) {

            responseDTO.setMessage(" Error inserted value " + e.getMessage());
        }
        return responseDTO;
    }
}
