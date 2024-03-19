package tech.kimari.sa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.kimari.sa.Enum.TypeSentiment;
import tech.kimari.sa.entities.Sentiment;
import tech.kimari.sa.service.SentimentService;
import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "sentiment", produces = APPLICATION_JSON_VALUE)
public class SentimentController {

    private SentimentService sentimentService;

    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Sentiment sentiment){
        this.sentimentService.create(sentiment);
    }

    @GetMapping
    public @ResponseBody List<Sentiment> search(@RequestParam(required = false) TypeSentiment type) {
        return this.sentimentService.search(type);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable int id){
        this.sentimentService.delete(id);

    }
}
