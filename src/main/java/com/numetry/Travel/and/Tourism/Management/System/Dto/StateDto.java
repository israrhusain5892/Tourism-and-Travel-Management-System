package com.numetry.Travel.and.Tourism.Management.System.Dto;

import jakarta.annotation.sql.DataSourceDefinitions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateDto {
    private UUID stateId;
    private String stateName;
}
