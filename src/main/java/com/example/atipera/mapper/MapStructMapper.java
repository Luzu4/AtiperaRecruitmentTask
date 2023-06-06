package com.example.atipera.mapper;

import com.example.atipera.client.dto.ClientResponseBranchDTO;
import com.example.atipera.client.dto.ClientResponseRepositoryDTO;
import com.example.atipera.gitHub.dto.GitHubBranchDTO;
import com.example.atipera.gitHub.dto.GitHubRepositoryDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Component
public class MapStructMapper {

    public ClientResponseRepositoryDTO gitHubRepositoryAndBranchesToClientResponseRepository(GitHubRepositoryDTO gitHubRepositoryDTO, List<GitHubBranchDTO> gitHubBranchDTOList) {
        ClientResponseRepositoryDTO clientResponseRepositoryDTO = new ClientResponseRepositoryDTO();
        List<ClientResponseBranchDTO> clientResponseBranchDTOList = new ArrayList<>();
        for (GitHubBranchDTO gitHubBranchDTO : gitHubBranchDTOList) {
            ClientResponseBranchDTO clientResponseBranchDTO = new ClientResponseBranchDTO();
            clientResponseBranchDTO.setSha(gitHubBranchDTO.commit().getSha());
            clientResponseBranchDTO.setName(gitHubBranchDTO.name());
            clientResponseBranchDTOList.add(clientResponseBranchDTO);
        }
        clientResponseRepositoryDTO.setBranches(clientResponseBranchDTOList);
        clientResponseRepositoryDTO.setOwnerLogin(gitHubRepositoryDTO.owner().getLogin());
        clientResponseRepositoryDTO.setName(gitHubRepositoryDTO.name());
        return clientResponseRepositoryDTO;
    }
}
