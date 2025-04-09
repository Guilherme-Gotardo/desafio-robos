package repository;
import model.Robo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoboRepository extends JpaRepository<Robo, Long> {
    // Podemos adicionar filtros depois, como buscar por nome
}
