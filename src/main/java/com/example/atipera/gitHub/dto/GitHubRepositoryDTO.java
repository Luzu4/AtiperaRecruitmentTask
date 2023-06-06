package com.example.atipera.gitHub.dto;

import lombok.Builder;

@Builder
public record GitHubRepositoryDTO(String name, OwnerDTO owner, Boolean fork) {
}