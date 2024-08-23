package ec.edu.espe.graphql.repositories;

import ec.edu.espe.graphql.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
