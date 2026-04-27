package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
    indexes = @Index(name = "fk_back_selleid", columnList = "seller_id"),
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_seller_bank_sellerid", columnNames = "seller_id"),
        @UniqueConstraint(name = "uk_seller_bank_accountno", columnNames = "account_no"),
    }
)
public class SellerBank {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "seller_id",
      foreignKey = @ForeignKey(name = "fk_bank_sellerid")
  )
  private Seller seller;

  @Column(
      nullable = false,
      unique = true,
      length = 20
  )
  private String accountNo;

  @Column(
      nullable = false
  )
  private String bankName;

  @Column(
      nullable = false
  )
  private String ifscCode;
}
