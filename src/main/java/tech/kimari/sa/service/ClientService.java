package tech.kimari.sa.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import tech.kimari.sa.dto.ClientDTO;
import tech.kimari.sa.entities.Client;
import tech.kimari.sa.mapper.ClientDTOMapper;
import tech.kimari.sa.repository.ClientRepository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ClientService {

    private final ClientDTOMapper clientDTOMapper;
    private final ClientRepository clientRepository;

    public ClientService(ClientDTOMapper clientDTOMapper, ClientRepository clientRepository) {
        this.clientDTOMapper = clientDTOMapper;
        this.clientRepository = clientRepository;
    }

    public void create(Client client) {
        Client clientInDB = this.clientRepository.findByEmail(client.getEmail());
        if (clientInDB == null) {
            this.clientRepository.save(client);
        }
    }

    public Stream<ClientDTO> search() {
        return this.clientRepository.findAll()
        .stream().map(clientDTOMapper);
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
