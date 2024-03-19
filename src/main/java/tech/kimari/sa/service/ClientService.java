package tech.kimari.sa.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import tech.kimari.sa.entities.Client;
import tech.kimari.sa.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void create(Client client) {
        Client clientInDB = this.clientRepository.findByEmail(client.getEmail());
        if (clientInDB == null) {
            this.clientRepository.save(client);
        }
    }

    public List<Client> search() {
        return this.clientRepository.findAll();
    }

    public Client read(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        return optionalClient.orElseThrow(
                () -> new EntityNotFoundException("Aucun client n'existe avec cet id !")
        );
    }

    public Client readOrCreate(Client clientToCreate){
        Client clientInDB = this.clientRepository.findByEmail(clientToCreate.getEmail());
        if (clientInDB == null) {
            clientInDB = this.clientRepository.save(clientToCreate);
        }
        return clientInDB;
    }

    public void modify(int id, Client client) {
        Client clientInDB = this.read(id);
        if (clientInDB.getId() == client.getId()) {
            clientInDB.setEmail(client.getEmail());
            clientInDB.setPhone(client.getPhone());
            this.clientRepository.save(clientInDB);
        }
    }
}
