package com.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Invoices")
public class Invoice {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "invoice_id")
    private long id;

    @NotNull
    @Column(name = "invoice_number")
    private String number;

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "invoice",
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    private List<Item> items = new ArrayList<>();

    public Invoice() {
    }

    public Invoice(String number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }
}
