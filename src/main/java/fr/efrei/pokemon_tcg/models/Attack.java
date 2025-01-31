package fr.efrei.pokemon_tcg.models;
import fr.efrei.pokemon_tcg.dto.AttackDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Attack {
       
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int damage;

    public Attack() {
    }

    public Attack(String uuid, String name, int damage) {
        this.uuid = uuid;
        this.name = name;
        this.damage = damage;
    }

    public Attack(AttackDto attackDto) {
        this.name = attackDto.getName();
        this.damage = attackDto.getDamage();
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
