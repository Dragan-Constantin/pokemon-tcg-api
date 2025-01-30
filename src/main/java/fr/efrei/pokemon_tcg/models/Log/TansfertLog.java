package fr.efrei.pokemon_tcg.models.Log;

import java.sql.Date;

import fr.efrei.pokemon_tcg.models.Trainer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class TansfertLog implements Log {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date date;

    @OneToMany
    private Trainer sender;

    @OneToMany
    private Trainer receiver;


    public TansfertLog() {
        this.date = new Date(System.currentTimeMillis());
    }

    public TansfertLog(String uuid,Date date, Trainer sender, Trainer receiver) {
        this.date = date;
        this.sender = sender;
        this.receiver = receiver;
    }


    public String getUuid() {
        return uuid;
    }

    public Date getDate() {
        return date;
    }

    public Trainer getSender() {
        return sender;
    }

    public Trainer getReceiver() {
        return receiver;
    }

    
}
