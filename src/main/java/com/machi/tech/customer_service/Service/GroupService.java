package com.machi.tech.customer_service.Service;

import com.machi.tech.customer_service.Repository.ClientRepository;
import com.machi.tech.customer_service.Repository.GroupRepository;
import com.machi.tech.customer_service.model.Client;
import com.machi.tech.customer_service.model.Group;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GroupService {

    private final GroupRepository groupRepository;
    private final ClientRepository clientRepository;

    public GroupService(GroupRepository groupRepository, ClientRepository clientRepository) {
        this.groupRepository = groupRepository;
        this.clientRepository = clientRepository;
    }

    public Group createGroup(Group group) {
        if (groupRepository.existsByName(group.getName())) {
            throw new RuntimeException("Group name already exists");
        }
        return groupRepository.save(group);
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupById(Long id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found with ID: " + id));
    }

    public Group addClientToGroup(Long groupId, String clientId) {
        Group group = getGroupById(groupId);
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + clientId));

        group.getClients().add(client);
        return groupRepository.save(group);
    }

    public Group removeClientFromGroup(Long groupId, String clientId) {
        Group group = getGroupById(groupId);
        group.setClients(
                group.getClients().stream()
                        .filter(client -> !client.getId().equals(clientId))
                        .toList()
        );
        return groupRepository.save(group);
    }

    public void deleteGroup(Long id) {
        if (!groupRepository.existsById(id)) {
            throw new RuntimeException("Group not found");
        }
        groupRepository.deleteById(id);
    }
}
