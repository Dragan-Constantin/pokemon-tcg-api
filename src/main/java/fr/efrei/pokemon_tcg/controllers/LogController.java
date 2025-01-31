package fr.efrei.pokemon_tcg.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.pokemon_tcg.services.TransfertLogService;
import fr.efrei.pokemon_tcg.dto.TransfertLogDto;
import fr.efrei.pokemon_tcg.models.log.TransfertLog;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private TransfertLogService transfertLogService;

    @GetMapping("/transfert")
    public ResponseEntity<?> transfertLog(@RequestParam(name = "page") int page) {
        final Page<TransfertLog> transfertLogs = transfertLogService.getByPage(page);

        final Page<TransfertLogDto> transfertLogDtos = transfertLogs.map(log -> new TransfertLogDto(log));


        return new ResponseEntity<>(transfertLogDtos, HttpStatus.ACCEPTED);
        
    }


    @GetMapping("/transfert/{uuid}")
    public ResponseEntity<?> transfertLog(@RequestParam(name = "page") int page, @PathVariable String uuid) {
        final Page<TransfertLog> transfertLogs = transfertLogService.getByPage(page);

        final Page<TransfertLogDto> transfertLogDtos = transfertLogs.map(log -> new TransfertLogDto(log));


        return new ResponseEntity<>(transfertLogDtos, HttpStatus.ACCEPTED);
        
    }
}
