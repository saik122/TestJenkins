package ApplicationDemo.demo.controller;

import ApplicationDemo.demo.model.Alien;
import ApplicationDemo.demo.service.AlienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aliens")
public class AlienController {
    @Lazy
    @Autowired
    private final AlienService alienService;

    @Autowired
    public AlienController(AlienService alienService) {
        this.alienService = alienService;
    }

    @PostMapping(value =  "/alienid")
    public void createAlien(@RequestBody Alien alien) {
        alienService.save(alien);
    }

    @GetMapping("/alienAll")
    public List<Alien> getAllAliens() {
        return alienService.findAll();
    }

    @GetMapping("/alienid/{id}")
    public Alien getAlienById(@PathVariable int id) {
        return alienService.findById(id);
    }

//    @PutMapping("/alienid/{updateid}")
//    public ResponseEntity<Alien> updateAlien(@PathVariable("updateid") int id, @RequestBody Alien alien) {
//        Alien updatedAlien = alienService.update(id, alien);
//
//        if (updatedAlien == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        return ResponseEntity.ok(updatedAlien);
//    }

    @PutMapping("/alienid/{updateid}/{name}")
    public ResponseEntity<Alien> updateAlienName(@PathVariable("updateid") int id, @PathVariable("name") String name) {
        Alien updatedAlien = alienService.updateby(id, name);

        if (updatedAlien == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedAlien);
    }

    @DeleteMapping("/deleteby/{deleteid}")
    public List<Alien> deleteAlien(@PathVariable("deleteid") int id){
        return (List<Alien>) alienService.deleteBy(id);
    }

}