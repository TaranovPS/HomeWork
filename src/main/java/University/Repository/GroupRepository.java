package University.Repository;

import University.Entity.Group;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

    public Group findByName(String groupName);

    public List<Group> findAll(Sort Sort);
}
