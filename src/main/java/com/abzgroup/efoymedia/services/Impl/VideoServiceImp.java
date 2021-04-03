package com.abzgroup.efoymedia.services.Impl;

import com.abzgroup.efoymedia.dal.dtos.entitiyDtos.CategoryDTO;
import com.abzgroup.efoymedia.dal.dtos.entitiyDtos.ChannelDTO;
import com.abzgroup.efoymedia.dal.dtos.entitiyDtos.VideoDTO;
import com.abzgroup.efoymedia.dal.model.Category;
import com.abzgroup.efoymedia.dal.model.Channel;
import com.abzgroup.efoymedia.dal.model.Video;
import com.abzgroup.efoymedia.dal.repositories.CategoryRepo;
import com.abzgroup.efoymedia.dal.repositories.ChannelRepo;
import com.abzgroup.efoymedia.dal.repositories.VideoRepo;
import com.abzgroup.efoymedia.services.VideoService;
import com.abzgroup.efoymedia.utilities.MultiMapper;
import com.abzgroup.efoymedia.utilities.SingleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VideoServiceImp implements VideoService {
    @Autowired
    private MultiMapper multiMapper;

    @Autowired
    private SingleMapper singleMapper;

    @Autowired
    private VideoRepo videoRepo;

    @Autowired
    private ChannelRepo channelRepo;

    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public List<VideoDTO> getAllVideos() {
        List<Video> videoList = videoRepo.findAll();
        return multiMapper.mapList(videoList, VideoDTO.class);
    }

    @Override
    public List<VideoDTO> addVideos(List<VideoDTO> videoDTOList) {

        List<Video> videolListToSave = multiMapper.mapList(videoDTOList, Video.class);

        List<VideoDTO> savedVideos = new ArrayList<>();

        for (VideoDTO videoDTO : videoDTOList) {
            String s = videoDTO.getChannelId();

            Set<Category> categories = new HashSet<>();
            Optional<Channel> opt = channelRepo.findById(videoDTO.getChannelId());
            for (CategoryDTO categoryDTO :  videoDTO.getCategories()){
                Optional<Category> optCategory = categoryRepo.findFirstByName(categoryDTO.getName());
                if(!optCategory.isPresent()) {
                    Category category = singleMapper.mapSingle(optCategory, Category.class);
                    categories.add(categoryRepo.save(category));
                }else {
                    categories.add(optCategory.get());
                }
            }

            if (opt.isPresent()) {
                Video video = singleMapper.mapSingle(videoDTO, Video.class);
                video.setCategories(categories);
                videoRepo.save(video);
                savedVideos.add(videoDTO);
            }
        }
        return  savedVideos;
//        System.out.println(videolListToSave);
//        try {
//            List<Video> videoListSaved = videoRepo.saveAll(videolListToSave);
//            List<VideoDTO> videoDTOListSaved = multiMapper.mapList(videoListSaved, VideoDTO.class);
//            return videoDTOListSaved;
//        }catch (Exception e) {
//            return new ArrayList<>();
//        }
    }
}
