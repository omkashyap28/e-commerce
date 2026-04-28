package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;

@Entity
public class DiscussionLike {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(
      name = "user_id",
      nullable = false,
      foreignKey = @ForeignKey(name = "fk_discussion_like_userid")
  )
  private User user;

  @OneToOne
  @JoinColumn(
      name = "discussion_id",
      foreignKey = @ForeignKey(name = "fk_discussion_like_discussionid")
  )
  private ProductDiscussion discussions;


}
