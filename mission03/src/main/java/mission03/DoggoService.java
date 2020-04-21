package mission03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoggoService {
    private DoggoRepository doggoRepository;

    @Autowired
    public DoggoService(DoggoRepository repository) {
        this.doggoRepository = repository;
    }

    public List<Doggo> retrieveDoggo() {
        return (List<Doggo>) doggoRepository.findAll();
    }

    public Doggo createDoggo(Doggo doggo) {
        doggo.setId(null);
        return doggoRepository.save(doggo);
    }

    public Optional<Doggo> updateDoggo(Integer id, Doggo doggo) {
        Optional<Doggo> doggoOptional = doggoRepository.findById(id);
        if(doggoOptional.isEmpty()) {
            return doggoOptional;
        }
        doggo.setId(id);
        return Optional.of(doggoRepository.save(doggo));
    }

    public boolean deleteDoggo(Integer id) {
        try {
            doggoRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}
