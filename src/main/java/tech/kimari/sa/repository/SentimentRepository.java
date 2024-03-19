package tech.kimari.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.kimari.sa.Enum.TypeSentiment;
import tech.kimari.sa.entities.Client;
import tech.kimari.sa.entities.Sentiment;

import java.util.List;

public interface SentimentRepository extends JpaRepository<Sentiment,Integer> {
    List<Sentiment> findByType(TypeSentiment type);
}
