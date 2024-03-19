package tech.kimari.sa.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String email;
    private String phone;

    private Date creating;

    @Column(name = "UPDATING")
    private Date updating;

    public Client() {

    }

    public Client(int id, String email, String phone, Date creating, Date updating) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.creating = creating;
        this.updating = updating;
    }

    public Client(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public Date getCreating() {
        return creating;
    }

    public void setCreating(Date creating) {
        this.creating = creating;
    }

    public Date getUpdating() {
        return updating;
    }

    public void setUpdating(Date updating) {
        this.updating = updating;
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
