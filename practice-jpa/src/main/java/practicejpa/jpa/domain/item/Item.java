package practicejpa.jpa.domain.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import practicejpa.jpa.domain.Category;
import practicejpa.jpa.domain.OrderItem;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

//    @OneToMany(mappedBy = "item")
//    private List<OrderItem> orderItems = new ArrayList<>();

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();
}
