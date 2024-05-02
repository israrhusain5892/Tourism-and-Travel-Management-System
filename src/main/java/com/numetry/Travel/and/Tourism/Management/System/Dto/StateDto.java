package com.numetry.Travel.and.Tourism.Management.System.Dto;

import jakarta.annotation.sql.DataSourceDefinitions;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateDto {
    private UUID stateId;
    @Column(unique=true)
    private String stateName;
}
