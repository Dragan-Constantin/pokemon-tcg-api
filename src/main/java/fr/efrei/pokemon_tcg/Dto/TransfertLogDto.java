package fr.efrei.pokemon_tcg.dto;


import java.util.Date;

import fr.efrei.pokemon_tcg.dto.storage.CardDto;
import fr.efrei.pokemon_tcg.dto.trainer.TrainerDto;
import fr.efrei.pokemon_tcg.models.log.TransfertLog;

public class TransfertLogDto {


    private CardDto card;
    private TrainerDto sender;
    private TrainerDto receiver;
    private Date date;


    public TransfertLogDto(TransfertLog transfertLog) {
        this.card = new CardDto(transfertLog.getCard());
        this.sender = new TrainerDto(transfertLog.getSender());
        this.receiver = new TrainerDto(transfertLog.getReceiver());
        this.date = transfertLog.getDate();
    }

    public TransfertLogDto(CardDto card, TrainerDto sender, TrainerDto receiver, Date date) {
        this.card = card;
        this.sender = sender;
        this.receiver = receiver;
        this.date = date;
    }


    public CardDto getCard() {
        return card;
    }

    public TrainerDto getReceiver() {
        return receiver;
    }

    public TrainerDto getSender() {
        return sender;
    }

    public Date getDate() {
        return date;
    }
}
