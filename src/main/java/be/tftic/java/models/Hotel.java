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

    @Column(name = "hotel_address", nullable = false)
    private String address;

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
    @JoinColumn(name = "director_id", nullable = false)
    private Employe director;

}
