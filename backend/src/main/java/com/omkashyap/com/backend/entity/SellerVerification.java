package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
    indexes = @Index(name = "idx_verification_sellerid", columnList = "seller_id"),
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_verification_sellerid", columnNames = "seller_id"),
        @UniqueConstraint(name = "uk_verification_panno", columnNames = "pan_no"),
        @UniqueConstraint(name = "uk_verification_gstno", columnNames = "gst_no")
    }
)
public class SellerVerification {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "seller_id",
      foreignKey = @ForeignKey(name = "fk_verification_sellerid")
  )
  private Seller seller;

  @Column(
      length = 15,
      nullable = false
  )
  private String gstNo;

  @Column(
      length = 10,
      nullable = false
  )
  private String panNo;

  @Column(
      updatable = false
  )
  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
