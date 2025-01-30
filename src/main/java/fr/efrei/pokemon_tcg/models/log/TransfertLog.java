package fr.efrei.pokemon_tcg.models.log;


import java.util.Date;

import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.models.Trainer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class TransfertLog implements Log {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date date;


    @ManyToOne
    private Card card;

    @ManyToOne
    private Trainer sender;

    @ManyToOne
    private Trainer receiver;


    public TransfertLog(Trainer sender, Trainer receiver, Card card) {
        this.date = new Date(System.currentTimeMillis());
        this.sender = sender;
        this.receiver = receiver;
        this.card = card;
    }

    public TransfertLog() {
    }

    public TransfertLog(String uuid,Card card, Date date, Trainer sender, Trainer receiver) {
        this.uuid = uuid;
        this.date = date;
        this.sender = sender;
        this.receiver = receiver;
        this.card = card;
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

    public Card getCard() {
        return card;
    }

    
}
