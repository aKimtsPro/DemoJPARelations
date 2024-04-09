package be.tftic.java.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import java.util.List;

@Entity
@Table(name = "hotel")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long id;

    @Column(name = "hotel_name", nullable = false)
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "countryAdd.zipcode", column = @Column(name = "hotel_zipcode")),
            @AttributeOverride(name = "countryAdd.city", column = @Column(name = "hotel_city")),
            @AttributeOverride(name = "countryAdd.street", column = @Column(name = "hotel_street")),
            @AttributeOverride(name = "countryAdd.number", column = @Column(name = "hotel_number")),
            @AttributeOverride(name = "country", column = @Column(name = "hotel_country"))
    })
    private Address address;

    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;

    @ManyToMany
    @JoinTable(
            name = "hotel_employes",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "employe_id")
    )
    private List<Employe> employes;

    @OneToOne
    @JoinColumn(name = "hotel_director_id", nullable = false)
    private Employe director;

}
