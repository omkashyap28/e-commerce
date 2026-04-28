package com.omkashyap.com.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(
      nullable = false,
      length = 100
  )
  private String name;

  @ManyToOne(
      fetch = FetchType.LAZY
  )
  @JoinColumn(
      name = "parent_id",
      foreignKey = @ForeignKey(
          name = "fk_category_parentid"
      )
  )
  private Category parent;

  @OneToMany(
      mappedBy = "parent",
      cascade = CascadeType.ALL
  )
  private List<Category> children = new ArrayList<>();

  @OneToMany(mappedBy = "category")
  private List<Product> products = new ArrayList<>();

  public Category(String name, Category parent) {
    this.name = name;
    this.parent = parent;
  }

  public void addChildren(Category child) {
    children.add(child);
    child.assignParent(this);
  }

  public void assignParent(Category parent) {
    this.parent = parent;
  }
}
