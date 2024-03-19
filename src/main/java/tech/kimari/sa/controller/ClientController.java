package tech.kimari.sa.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.kimari.sa.dto.ErrorEntity;
import tech.kimari.sa.entities.Client;
import tech.kimari.sa.service.ClientService;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "client")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Client client) {
        this.clientService.create(client);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Client> search(){
        return this.clientService.search();
    }

//    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
//    public ResponseEntity read(@PathVariable int id){
//        try {
//            Client client = this.clientService.read(id);
//            return ResponseEntity.ok(client);
//        } catch (EntityNotFoundException exception) {
//           return ResponseEntity.status(BAD_REQUEST).body(new ErrorEntity(null, exception.getMessage()));
//        }
//    }

    @ResponseStatus(FOUND)
    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    public Client read(@PathVariable int id){
            return this.clientService.read(id);
    }

    @ResponseStatus(NO_CONTENT)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void modify(@PathVariable int id, @RequestBody Client client) {
        this.clientService.modify(id, client);
    }

}
