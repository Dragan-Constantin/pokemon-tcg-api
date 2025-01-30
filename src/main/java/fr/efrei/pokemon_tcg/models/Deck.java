package fr.efrei.pokemon_tcg.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Deck {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @OneToMany
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setSlot(int slot, Card card) {
        // card allready in deck
        for (Card c : cards) {
            if (c.getUuid().equals(card.getUuid())) {
                return;
            }
        }

        if (slot < 0 || slot > 5) {
            return;
        }

        if (slot >= cards.size()) {
            cards.add(card);
            return;
        }

        cards.set(slot, card);
    }


    public void removeCard(Card card) {
        cards.remove(card);
    }
}