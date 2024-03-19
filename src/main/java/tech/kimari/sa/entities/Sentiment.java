package tech.kimari.sa.entities;

import jakarta.persistence.*;
import tech.kimari.sa.Enum.TypeSentiment;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "SENTIMENT")
public class Sentiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Text;
    private TypeSentiment type;
    @ManyToOne(cascade = {PERSIST, MERGE})
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    public Sentiment() {
    }

    public Sentiment(int id, String text, TypeSentiment type, Client client) {
        this.id = id;
        Text = text;
        this.type = type;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public TypeSentiment getType() {
        return type;
    }

    public void setType(TypeSentiment type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
