package ec.edu.espe.graphql.repositories;

import ec.edu.espe.graphql.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
