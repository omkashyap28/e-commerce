package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
    uniqueConstraints = @UniqueConstraint(
        name = "uk_product_image_producturl", columnNames = "product_url"
    )
)
public class ProductImage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(
      fetch = FetchType.EAGER
  )
  @JoinColumn(
      name = "product_id",
      foreignKey = @ForeignKey(name = "fk_product_image_productid")
  )
  private Product product;

  @Column(
      nullable = false
  )
  private String productUrl;

}
