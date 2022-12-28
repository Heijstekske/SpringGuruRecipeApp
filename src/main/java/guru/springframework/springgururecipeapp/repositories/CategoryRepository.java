package guru.springframework.springgururecipeapp.repositories;

import guru.springframework.springgururecipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
