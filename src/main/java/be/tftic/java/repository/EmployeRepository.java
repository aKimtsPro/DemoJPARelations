package be.tftic.java.repository;

import be.tftic.java.models.Employe;
import be.tftic.java.models.Hotel;
import be.tftic.java.models.Work;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.*;

import java.util.ArrayList;
import java.util.List;

public class EmployeRepository {

    private final EntityManager em;

    public EmployeRepository(EntityManagerFactory emf) {
        this.em = emf.createEntityManager();
    }

    public List<Employe> findByWorksInCity(String city){
        String query = """
                SELECT employe_id, user_created_at, user_last_update_at, user_name, user_password, employe_salary
                FROM employe as emp
                    JOIN "user" as us ON emp.employe_id = us.user_id
                    JOIN work as wo ON emp.employe_id = wo.employe_employe_id
                    JOIN hotel as ho ON ho.hotel_id = wo.hotel_hotel_id
                WHERE ho.hotel_city = ?
                """;

        return em.createNativeQuery(query, Employe.class)
                .setParameter(1, city)
                .getResultList();
    }

    public List<Employe> findByWorksInCity_JPQL(String city){
        String query = """
                SELECT emp
                FROM Employe emp
                    JOIN Work wo ON wo.employe = emp
                    JOIN Hotel ho ON wo.hotel = ho
                WHERE ho.address.countryAdd.city = :city
                """;

        return em.createQuery(query, Employe.class)
//                .setParameter(1, city)// <|==       WHERE ho.address.countryAdd.city = ?1 AND ?1 = 'salut'
                .setParameter("city", city)
                .getResultList();
    }

    public List<Employe> findByWorksInCity_Criteria(String city){
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Employe> query = cb.createQuery(Employe.class); // ce que je récupère

        Root<Employe> root = query.from(Employe.class);
        Join<Employe, Work> workJoin = root.join("works");
        Join<Work, Hotel> hotelJoin = workJoin.join("hotel");

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(
                cb.equal(
                        hotelJoin.get("address").get("countryAdd").get("city"),
                        cb.parameter(String.class, "city")
                )
        );
        if( city.startsWith("G") ){
            predicates.add(  cb.ge( workJoin.get("hours"), 15 ) );
        }


        query = query.select(root)
                .where(
                        cb.and( predicates.toArray(new Predicate[0]) )
                );

        return em.createQuery(query)
                .setParameter("city", city)
                .getResultList();
    }
}
