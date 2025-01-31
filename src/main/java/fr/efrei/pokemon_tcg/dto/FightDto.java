package fr.efrei.pokemon_tcg.dto;



public class FightDto {
    
    
    public String to;
    public int attack;


    public FightDto() {
    }

    public FightDto(String to, int attack) {
        this.to = to;
        this.attack = attack;
    }

    public String getTo() {
        return to;
    }

    public int getAttack() {
        return attack;
    }
}
