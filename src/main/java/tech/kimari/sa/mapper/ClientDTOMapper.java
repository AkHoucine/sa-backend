package tech.kimari.sa.mapper;

import org.springframework.stereotype.Component;
import tech.kimari.sa.dto.ClientDTO;
import tech.kimari.sa.entities.Client;

import java.util.function.Function;

@Component
public class ClientDTOMapper implements Function<Client, ClientDTO> {
    @Override
    public ClientDTO apply(Client client) {
        return new ClientDTO(client.getId(), client.getEmail(), client.getPhone());
    }
}
