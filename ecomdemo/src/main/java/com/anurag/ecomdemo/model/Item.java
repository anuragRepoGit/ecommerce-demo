package com.anurag.ecomdemo.model;

@Entity
@Data
@Build
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
}
