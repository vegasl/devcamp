package mission02.doggo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doggo")
public class DoggoController {

    @Autowired
    private DoggoService doggoService;

    @GetMapping()
    public List<Doggo> getDoggo() {
        return doggoService.retrieveDoggo();
    }

    @PostMapping()
    public ResponseEntity<?> postDoggo(@Valid @RequestBody Doggo body) {
        Doggo doggo = doggoService.createDoggo(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(doggo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDoggo(@RequestBody Doggo body, @PathVariable Integer id) {
        Optional<Doggo> doggo = doggoService.updateDoggo(id, body);
        if (doggo.isPresent()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDoggo(@PathVariable Integer id) {
        if(!doggoService.deleteDoggo(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}