package com.abzgroup.efoymedia.dal.dtos.entitiyDtos;

import com.abzgroup.efoymedia.dal.model.Channel;
import com.abzgroup.efoymedia.dal.serializers.VideoDeserilizer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = VideoDeserilizer.class)
public class VideoDTO {

    private String id = "";
    private String title = "";
    private String channelTitle = "";
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishedAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastModified;
    private String thumbnailsLow;
    private String thumbnailsHigh;
    private String thumbnailsMedium;
    private String thumbnailsLocal;
    private String url;
    private String license;
    private String creator;
    private String description;
    private String subtitles;
    private String artist;
    private String track;
    private int width = 0;
    private int height = 0;
    private String resolution;
    private String ext;
    private int duration = 0;
    private int viewCount = 0;
    private int likeCount = 0;
    private int dislikeCount = 0;
    private float averageRating;
    private String status = "yes";
    private String video;
    private List<CategoryDTO> categories;
    private String channelId;
}
