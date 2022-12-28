package guru.springframework.springgururecipeapp.repositories;

import guru.springframework.springgururecipeapp.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UnitOfMeasureRepositoryTest {

   @Autowired
   UnitOfMeasureRepository unitOfMeasureRepository;

   @Test
   void findByDescription()  throws Exception {

      Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

      assertEquals("Teaspoon", uomOptional.orElseThrow().getDescription());
   }

   @Test
   public void findByDescriptionCup() throws Exception {

      Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");

      assertEquals("Cup", uomOptional.orElseThrow().getDescription());
   }
}