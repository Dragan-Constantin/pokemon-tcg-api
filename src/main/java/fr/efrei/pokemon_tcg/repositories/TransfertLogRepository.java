package fr.efrei.pokemon_tcg.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.efrei.pokemon_tcg.models.log.TransfertLog;

@Repository
public interface TransfertLogRepository extends JpaRepository<TransfertLog, String> {

    public Page<TransfertLog> findBySenderUuidAndReceiverUuid(String senderUuid, String receiverUuid, Pageable pageable);

}
