package com.anurag.ecomdemo.entity;

@Entity
@Data
@Build
public class Inventory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;

    private int totalQuantity;
    private int reservedQuantity;

    @Version
    private Integer version;
}

