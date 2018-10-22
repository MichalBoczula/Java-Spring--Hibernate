package com.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "item_id")
    private long id;

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_price")
    private BigDecimal price;

    @Column(name = "item_quantity")
    private int quantity;

    @Column(name = "item_value")
    private BigDecimal value;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    public Item() {
    }

    public Item(String name, BigDecimal price, int quantity, BigDecimal value) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
