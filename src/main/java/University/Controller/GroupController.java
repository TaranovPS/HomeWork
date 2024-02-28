package University.Controller;

import University.DTO.GroupDTO;
import University.Service.GroupService.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    GroupService service;

    public GroupController(GroupService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public ResponseEntity<?> getGroups() {
        List<GroupDTO> groups = service.showAll();
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @PostMapping(path = "")
    public ResponseEntity<?> createCourse(@RequestBody GroupDTO groupDTO) {
        service.save(groupDTO);
        return new ResponseEntity<>(groupDTO, HttpStatus.CREATED);
    }
}
