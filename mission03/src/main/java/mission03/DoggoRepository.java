package mission03;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoggoRepository extends CrudRepository<Doggo, Integer> { }
