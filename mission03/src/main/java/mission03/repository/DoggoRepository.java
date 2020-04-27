package mission03.repository;

import mission03.model.Doggo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoggoRepository extends CrudRepository<Doggo, Integer> { }
