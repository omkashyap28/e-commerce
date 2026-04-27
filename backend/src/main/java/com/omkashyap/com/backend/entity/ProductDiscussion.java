package com.omkashyap.com.backend.entity;

import com.omkashyap.com.backend.entity.Product;
import com.omkashyap.com.backend.entity.User;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class ProductDiscussion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 255)
  private String message;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  @ManyToOne
  @JoinColumn(
      name = "parent_id"
  )
  private ProductDiscussion parent;

  @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ProductDiscussion> replies;

  @OneToMany(
      mappedBy = "discussions",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<DiscussionLike> likes;

  private Boolean edited = false;

  @CreationTimestamp
  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}