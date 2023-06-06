package com.example.atipera.gitHub.service;

import com.example.atipera.gitHub.dto.GitHubBranchDTO;
import com.example.atipera.gitHub.dto.GitHubRepositoryDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubService {

    private static final String BRANCHES_URL = "https://api.github.com/repos/{OWNER}/{REPO}/branches";
    private static final String REPOSITORIES_URL = "https://api.github.com/users/{USERNAME}/repos";

    private final RestTemplate restTemplate;

    public GitHubService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public GitHubRepositoryDTO[] getAllRepositoriesByUsername(String username) {
        return restTemplate.getForEntity(REPOSITORIES_URL, GitHubRepositoryDTO[].class, username).getBody();
    }

    public GitHubBranchDTO[] getAllBranchesByRepositoryNameAndUsername(String userName, String repositoryName) {
        return restTemplate.getForEntity(BRANCHES_URL, GitHubBranchDTO[].class, userName,repositoryName).getBody();
    }
}
