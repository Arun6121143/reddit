package com.redittclone.redittclone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user_tbl")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name="username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "up_vote")
    private Integer upVote;

    @Column(name = "down_vote")
    private Integer downVote;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "karma_value")
    private Long karma;

    @OneToMany(mappedBy = "ownerId",cascade = CascadeType.ALL)
    private Set<Community> ownedCommunities;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Post> userPosts;

    @ManyToMany(mappedBy = "communityMembers")
    private Set<Community> communityMembers;
    
    @ManyToMany(mappedBy = "communityModerators")
    private Set<Community> communityModerators;
}