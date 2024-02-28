package University.Service.GroupService;

import University.DTO.GroupDTO;
import University.Entity.Group;
import University.Exceptions.GroupNotFoundException;
import University.Repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService{

    GroupRepository repository;

    public GroupServiceImpl(GroupRepository repository) {
        this.repository = repository;
    }

    public List<GroupDTO> showAll() {
        return repository.findAll()
                .stream()
                .map(x -> new GroupDTO(x))
                .collect(Collectors.toList());
    }

    public GroupDTO findById(Integer id) {
        Optional<Group> group = repository.findById(id);
        return group.map(GroupDTO::new)
                .orElseThrow(() -> new GroupNotFoundException("Group not found"));
    }

    public void save(GroupDTO group) {
        Group newGroup = new Group();
        newGroup.setName(group.getName());
        repository.save(newGroup);
    }
}
