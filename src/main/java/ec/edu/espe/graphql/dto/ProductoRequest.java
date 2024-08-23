package ec.edu.espe.graphql.dto;

public record ProductoRequest(
        Long id,
        String nombre,
        double precio,
        int stock,
        Long categoriaId
) {

}


