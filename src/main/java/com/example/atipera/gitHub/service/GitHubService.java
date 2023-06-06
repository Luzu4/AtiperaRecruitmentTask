package com.example.atipera.gitHub.service;

import com.example.atipera.gitHub.dto.GitHubBranchDTO;
import com.example.atipera.gitHub.dto.GitHubRepositoryDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubService {

    private final RestTemplate restTemplate;

    public GitHubService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public GitHubRepositoryDTO[] getAllRepositoriesByUsername(String username) {
        return restTemplate.getForEntity("https://api.github.com/users/" + username + "/repos", GitHubRepositoryDTO[].class).getBody();
    }

    public GitHubBranchDTO[] getAllBranchesByRepositoryNameAndUsername(String userName, String repositoryName) {
        return restTemplate.getForEntity("https://api.github.com/repos/" + userName + "/" + repositoryName + "/branches", GitHubBranchDTO[].class).getBody();
    }
}
