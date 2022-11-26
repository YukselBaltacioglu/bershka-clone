package pure.bershka.entities.concretes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "categories")
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    @JoinTable(name="typologies_for_category", joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name="typology_id"))
    private List<Category> typologies;

    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    @ManyToMany
    @JoinTable(name="colors_for_category", joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name="color_id"))
    private List<Color> colors;

    @ManyToMany
    @JoinTable(name="sizes_for_category", joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name="size_id"))
    private List<Size> sizes;

}
