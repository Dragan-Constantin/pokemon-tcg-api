package fr.efrei.pokemon_tcg.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InventoryUuidDto {
    
    private String uuid;

    public InventoryUuidDto() {
    }

    public InventoryUuidDto(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
