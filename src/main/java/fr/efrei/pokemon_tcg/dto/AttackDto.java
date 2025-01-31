package fr.efrei.pokemon_tcg.dto;

import fr.efrei.pokemon_tcg.models.Attack;

public class AttackDto {
    
    private String uuid;
    private String name;
    private int damage;

    public AttackDto(Attack attack) {
        this.uuid = attack.getUuid();
        this.name = attack.getName();
        this.damage = attack.getDamage();
    }

    public AttackDto() {
    }

    public AttackDto(String uuid, String name, int damage) {
        this.uuid = uuid;
        this.name = name;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }
}
