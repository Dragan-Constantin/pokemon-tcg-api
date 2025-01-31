package fr.efrei.pokemon_tcg.services;
import fr.efrei.pokemon_tcg.models.Attack;
import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.repositories.AttackRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import java.util.List;


@Service
public class AttackService {

    @Autowired
    private CardService cardService;
    
    @Autowired
    private AttackRepository attackRepository;

    public Page<Attack> getPage (int page) {
        Pageable pageable = PageRequest.of(page, 10);

        Page<Attack> attacks = attackRepository.findAll(pageable);

        return attacks;
    }

    public void add(Attack attack) {
        attackRepository.save(attack);
    }

    public List<Attack> getAll() {
        return attackRepository.findAll();
    }


    public Attack getAttack(String uuid) {
        return attackRepository.findByUuid(uuid);
    }

    public Card fight(Attack attack, Card to) {
        int hp = to.getHp() - attack.getDamage();

        if (hp < 0) {
            hp = 0;
        }

        to.setHp(hp);
        cardService.save(to);

        return to;
    }
}
