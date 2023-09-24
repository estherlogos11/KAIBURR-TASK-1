import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servers")
public class ServerController {
    @Autowired
    private ServerRepository serverRepository;

    @GetMapping
    public ResponseEntity<List<Server>> getServers(@RequestParam(required = false) String id) {
        if (id != null) {
            return serverRepository.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } else {
            return ResponseEntity.ok(serverRepository.findAll());
        }
    }

    @PutMapping
    public ResponseEntity<Server> createServer(@RequestBody Server server) {
        Server createdServer = serverRepository.save(server);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdServer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServer(@PathVariable String id) {
        serverRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Server>> searchServers(@RequestParam String name) {
        Server foundServer = serverRepository.findByNameContaining(name);
        if (foundServer != null) {
            return ResponseEntity.ok(serverRepository.findByNameContaining(name));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}