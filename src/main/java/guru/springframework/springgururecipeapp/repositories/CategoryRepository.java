package guru.springframework.springgururecipeapp.repositories;

import guru.springframework.springgururecipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

   Optional<Category> findByDescription(String description);
}
