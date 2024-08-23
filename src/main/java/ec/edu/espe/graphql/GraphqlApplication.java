package ec.edu.espe.graphql;

import ec.edu.espe.graphql.entities.Categoria;
import ec.edu.espe.graphql.entities.Producto;
import ec.edu.espe.graphql.repositories.CategoriaRepository;
import ec.edu.espe.graphql.repositories.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class GraphqlApplication {
    Random random = new Random();

    public static void main(String[] args) {
        SpringApplication.run(GraphqlApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CategoriaRepository categoriaRepository, ProductoRepository productoRepository) {
        return args -> {
            List.of("Computadoras", "Impresoras", "Celulares").forEach(cat -> {
                Categoria categoria = Categoria.builder().name(cat).build();
                categoriaRepository.save(categoria);
            });

            categoriaRepository.findAll().forEach(categoria -> {
                System.out.println(categoria.getName());
                for (int i = 0; i < 10; i++) {
                    Producto producto = Producto.builder()
                            .nombre(categoria.getName() + " " + i)
                            .precio(100 + Math.random() * 1000)
                            .stock(random.nextInt())
                            .categoria(categoria)
                            .build();
                    productoRepository.save(producto);
                }
            });
        };
    }
}
