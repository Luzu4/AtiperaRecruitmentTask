package com.example.atipera.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ClientResponseRepositoryDTO {
    private String name;
    private String ownerLogin;
    private List<ClientResponseBranchDTO> branches;

}
