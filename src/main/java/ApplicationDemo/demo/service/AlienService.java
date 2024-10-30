package ApplicationDemo.demo.service;

import ApplicationDemo.demo.model.Alien;
import ApplicationDemo.demo.repo.AlienRepo;
import com.mysql.cj.xdevapi.StreamingSqlResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlienService {

    @Lazy
    @Autowired
    private final AlienRepo alienRepo;

    @Autowired
    public AlienService(AlienRepo alienRepo) {
        this.alienRepo = alienRepo;
    }

    public Alien save(Alien alien) {
        return alienRepo.save(alien);
    }

    public List<Alien> findAll() {
        return alienRepo.findAll();
    }

    public Alien findById(int id) {
        return alienRepo.findById(id);
    }

    public Alien update(int id, Alien alien){
        return alienRepo.update(id, alien);
    }

    public Alien updates(int id, Alien alien) {
        Alien existingAlien = findById(id);
        existingAlien.setName(alien.getName());
        existingAlien.setTech(alien.getTech());
        return save(existingAlien);
    }

    public Alien updateby(int id, String name) {
        Alien existingAlien = findById(id);
        if (existingAlien == null) {
            throw new IllegalArgumentException("Alien with ID " + id + " does not exist.");
        }
        existingAlien.setName(name);
        alienRepo.update(id, existingAlien);
        return existingAlien;
    }

    public Alien deleteBy(int id) {
        Alien existingAlien = findById(id);
        alienRepo.deleteBy(id, existingAlien);
        return existingAlien;
    }


}
