package com.abzgroup.efoymedia.dal.dtos.entitiyDtos;

import com.abzgroup.efoymedia.dal.model.Category;
import com.abzgroup.efoymedia.dal.serializers.ChannelSerializer;
import com.abzgroup.efoymedia.dal.serializers.VideoDeserilizer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = ChannelSerializer.class)
public class ChannelDTO {
    private String id="";

    private String title="";

    private String status;

    private String url="";

    private int viewCount;

    private int commentCount;

    private int subscriberCount;

    private int videoCount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishedAt;

    private List<CategoryDTO> categories=new ArrayList<>();

}
