package com.redittclone.redittclone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "post_tbl")
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "is_published")
    private Boolean isPublished;

    @Column(name = "published_at")
    private LocalDateTime publishedAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "is_community")
    private Boolean isCommunity;

    @ManyToOne(targetEntity = Community.class)
    @JoinColumn(name ="community_id")
    private Community community;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;
}