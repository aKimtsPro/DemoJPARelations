package be.tftic.java.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "employe")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employe_id")
    private Long id;

    @Column(name = "employe_username", nullable = false)
    private String username;
    @Column(name = "employe_password", nullable = false)
    private String password;

    @ManyToMany(mappedBy = "employes")
    private List<Hotel> hotels;

    @OneToOne(mappedBy = "director")
    private Hotel directedHotel;

}
