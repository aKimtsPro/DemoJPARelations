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
@PrimaryKeyJoinColumn(name = "employe_id")
//@DiscriminatorValue("EMPLOYE")
public class Employe extends User {

    @Column(name = "employe_salary")
    private double salary;

    @OneToMany(mappedBy = "employe")
    private List<Work> works;

    @OneToOne(mappedBy = "director")
    private Hotel directedHotel;


}
