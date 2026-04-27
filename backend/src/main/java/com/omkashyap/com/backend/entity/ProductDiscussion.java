package com.omkashyap.com.backend.entity;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import com.omkashyap.com.backend.entity.Product;
import com.omkashyap.com.backend.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
    indexes = {
        @Index(name = "idx_discussion_userid", columnList = "user_id"),
        @Index(name = "idx_discussion_productid", columnList = "product_id"),
    }
)
public class ProductDiscussion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 255)
  private String message;

  @ManyToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "user_id",
      nullable = false,
      foreignKey = @ForeignKey(
          name = "fk_product_discussion_userid"
      )
  )
  private User user;

  @ManyToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "product_id",
      nullable = false,
      foreignKey = @ForeignKey(
          name = "fk_product_discussion_productid"
      )
  )
  private Product product;

  @ManyToOne
  @JoinColumn(
      name = "parent_id",
      foreignKey = @ForeignKey(
          name = "fk_prodcut_discussion_parentid"
      )
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