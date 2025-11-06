package com.machi.tech.customer_service.Controller;

import com.machi.tech.customer_service.Service.GroupService;
import com.machi.tech.customer_service.model.Group;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        return ResponseEntity.ok(groupService.createGroup(group));
    }

    @GetMapping
    public ResponseEntity<List<Group>> getAllGroups() {
        return ResponseEntity.ok(groupService.getAllGroups());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable Long id) {
        return ResponseEntity.ok(groupService.getGroupById(id));
    }

    @PutMapping("/{groupId}/add-client/{clientId}")
    public ResponseEntity<Group> addClientToGroup(
            @PathVariable Long groupId,
            @PathVariable String clientId
    ) {
        return ResponseEntity.ok(groupService.addClientToGroup(groupId, clientId));
    }

    @PutMapping("/{groupId}/remove-client/{clientId}")
    public ResponseEntity<Group> removeClientFromGroup(
            @PathVariable Long groupId,
            @PathVariable String clientId
    ) {
        return ResponseEntity.ok(groupService.removeClientFromGroup(groupId, clientId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id);
        return ResponseEntity.ok("Group deleted successfully");
    }
}
