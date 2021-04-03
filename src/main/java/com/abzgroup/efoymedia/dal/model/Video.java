package com.abzgroup.efoymedia.dal.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "video")
public class Video {
    @Id
    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "video_seq_gen")
//    @SequenceGenerator(name = "video_seq_gen", sequenceName = "video_seq", allocationSize = 1)
    private String id;

    @Column(name = "title",columnDefinition="text")
    private String title;

    @Column(name = "channel_title")
    private String channelTitle;

    @Column(name = "published_at")
    private LocalDateTime publishedAt;

    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    @Column(name = "thumbnails_low")
    private String thumbnailsLow;

    @Column(name = "thumbnails_high")
    private String thumbnailsHigh;

    @Column(name = "thumbnails_medium")
    private String thumbnailsMedium;

    @Column(name = "url")
    private String url;

    @Column(name = "license")
    private String license;

    @Column(name = "creator")
    private String creator;

    @Column(name = "description",columnDefinition="text")
    private String description;

    @Column(name = "subtitles")
    private String subtitles;

    @Column(name = "artist")
    private String artist;

    @Column(name = "track")
    private String track;

    @Column(name = "width")
    private int width;

    @Column(name = "height")
    private int height;

    @Column(name = "resolution")
    private String resolution;

    @Column(name = "ext")
    private String ext;

    @Column(name = "duration")
    private Long duration;

    @Column(name = "view_count")
    private Long viewCount;

    @Column(name = "like_count")
    private Long likeCount;

    @Column(name = "dislike_count")
    private Long dislikeCount;

    @Column(name = "average_rating")
    private double averageRating;

    @Column(name = "status")
    private String status;

    @Column(name = "video")
    private String video;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "videos",cascade = CascadeType.MERGE)
    @JoinTable(name = "videoCategories",
            joinColumns = {
                    @JoinColumn(name = "video_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "category_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<Category> categories = new HashSet<>();

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "channel_id",referencedColumnName = "id",insertable = false, updatable = false)
    private Channel channel;

    @Column(name = "thumbnails_local")
    private String thumbnailsLocal;

    @Column(name = "channel_id")
    private String channelId;
}
