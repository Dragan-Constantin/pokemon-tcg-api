package fr.efrei.pokemon_tcg.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @OneToMany
    private List<Card> cards;


    public Inventory() {
        this.cards = new ArrayList<>();
    }

    public Inventory(List<Card> cards) {
        this.cards = cards;
    }

    public String getUuid() {
        return uuid;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }


    public void addCard(Card card) {
        cards.add(card);
    }


    public Card findCard(String uuid) {
        for (Card card : cards) {
            if (card.getUuid().equals(uuid)) {
                return card;
            }
        }
        return null;
    }

}
