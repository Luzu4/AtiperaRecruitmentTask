package com.example.atipera.client.service;

import com.example.atipera.client.dto.ClientResponseRepositoryDTO;
import com.example.atipera.gitHub.dto.GitHubBranchDTO;
import com.example.atipera.gitHub.dto.GitHubRepositoryDTO;
import com.example.atipera.gitHub.service.GitHubService;
import com.example.atipera.mapper.MapStructMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientService {

    private final GitHubService gitHubService;
    private final MapStructMapper mapStructMapper;

    public ResponseEntity<?> getAllOwnRepositoriesByUsername(String userName) {
        List<GitHubRepositoryDTO> gitHubRepositories = getAllRepositoriesByUsername(userName);
        List<GitHubRepositoryDTO> filteredRepositories = removeForksFromRepositories(gitHubRepositories);

        List<ClientResponseRepositoryDTO> repositories = filteredRepositories.stream()
                .map(gitHubRepositoryDTO -> {
                    List<GitHubBranchDTO> gitHubBranches = getAllBranchesByRepositoryNameAndUsername(userName, gitHubRepositoryDTO.name());
                    return mapStructMapper.gitHubRepositoryAndBranchesToClientResponseRepository(gitHubRepositoryDTO, gitHubBranches);
                }).collect(Collectors.toList());
        return ResponseEntity.ok(repositories);
    }

    private List<GitHubRepositoryDTO> removeForksFromRepositories(List<GitHubRepositoryDTO> repositories) {
        return repositories.stream().filter(gitHubRepositoryDTO -> !gitHubRepositoryDTO.fork()).collect(Collectors.toList());
    }

    private List<GitHubRepositoryDTO> getAllRepositoriesByUsername(String userName) {
        return Arrays.stream(gitHubService.getAllRepositoriesByUsername(userName)).toList();
    }

    private List<GitHubBranchDTO> getAllBranchesByRepositoryNameAndUsername(String userName, String repositoryName) {
        return Arrays.stream(gitHubService.getAllBranchesByRepositoryNameAndUsername(userName, repositoryName)).toList();
    }
}
