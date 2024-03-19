package tech.kimari.sa.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String email;
    private String phone;

    public Client(int id, String email, String phone) {
        this.id = id;
        this.email = email;
        this.phone = phone;
    }

    public Client() {

    }
    public Client(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
