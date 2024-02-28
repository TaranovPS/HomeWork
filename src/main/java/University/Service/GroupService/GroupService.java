package University.Service.GroupService;

import University.DTO.GroupDTO;

import java.util.List;

public interface GroupService {

    public GroupDTO findById(Integer id);

    public List<GroupDTO> showAll();

    public void save(GroupDTO group);
}
