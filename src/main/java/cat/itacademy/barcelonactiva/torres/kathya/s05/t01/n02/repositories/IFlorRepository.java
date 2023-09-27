package cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n02.repositories;

import cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n02.models.FlorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFlorRepository extends JpaRepository<FlorModel, Long> {
}
