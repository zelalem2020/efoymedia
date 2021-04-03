package com.abzgroup.efoymedia.dal.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "channel")
public class Channel {

    @Id
    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "channel_seq_gen")
//    @SequenceGenerator(name = "channel_seq_gen", sequenceName = "channel_seq", allocationSize = 1)
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private String status;

    @Column(name = "url")
    private String url;

    @Column(name = "view_count")
    private String viewCount;

    @Column(name = "comment_count")
    private String commentCount;

    @Column(name = "subscriber_count")
    private String subscriberCount;

    @Column(name = "video_count")
    private String videoCount;

    @Column(name = "published_at")
    private LocalDateTime publishedAt;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "channelCategories",
            joinColumns = {
                    @JoinColumn(name = "channel_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "category_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<Category> categories = new HashSet<>();

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "channel")
    List<Video> videos;
}
