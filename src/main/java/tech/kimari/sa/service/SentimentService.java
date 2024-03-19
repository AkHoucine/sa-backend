package tech.kimari.sa.service;

import org.springframework.stereotype.Service;
import tech.kimari.sa.Enum.TypeSentiment;
import tech.kimari.sa.entities.Client;
import tech.kimari.sa.entities.Sentiment;
import tech.kimari.sa.repository.SentimentRepository;

import java.util.List;

@Service
public class SentimentService {

    private ClientService clientService;
    private SentimentRepository sentimentRepository;

    public SentimentService(ClientService clientService, SentimentRepository sentimentRepository) {
        this.clientService = clientService;
        this.sentimentRepository = sentimentRepository;
    }

    public void create(Sentiment sentiment) {
        Client client = this.clientService.readOrCreate(sentiment.getClient());
        sentiment.setClient(client);

        if(sentiment.getText().contains("pas")){
            sentiment.setType(TypeSentiment.NEGATIVE);
        }
        else {
            sentiment.setType(TypeSentiment.POSITIVE);
        }
        this.sentimentRepository.save(sentiment);

    }

    public List<Sentiment> search(TypeSentiment type) {
        if (type == null) {
            return this.sentimentRepository.findAll();
        }
        else {
            return this.sentimentRepository.findByType(type);
        }
    }

    public void delete(int id) {
        this.sentimentRepository.deleteById(id);
    }
}
