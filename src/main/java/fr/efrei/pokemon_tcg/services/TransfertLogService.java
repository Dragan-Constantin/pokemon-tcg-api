package fr.efrei.pokemon_tcg.services;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.efrei.pokemon_tcg.models.Trainer;
import fr.efrei.pokemon_tcg.models.log.TransfertLog;
import fr.efrei.pokemon_tcg.repositories.TransfertLogRepository;

@Service
public class TransfertLogService {
    
    @Autowired
    private TransfertLogRepository transfertLogRepository;

    public void save(TransfertLog transfertLog) {
        transfertLogRepository.save(transfertLog);
    }

    public Page<TransfertLog> getByPage(int page) {
        Pageable pageable = PageRequest.of(page, 10);

        Page<TransfertLog> transfertLogs = transfertLogRepository.findAll(pageable);

        return transfertLogs;
    }


    public Page<TransfertLog> getByUsers(Trainer from, Trainer to, int page) {
        Pageable pageable = PageRequest.of(page, 10);

        Page<TransfertLog> transfertLogs = 
            transfertLogRepository.findBySenderUuidAndReceiverUuid(from.getUuid(), to.getUuid(), pageable);



        return transfertLogs;
    }

    
}
