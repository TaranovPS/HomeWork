package University.DTO;


import University.Entity.Group;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@NoArgsConstructor
public class GroupDTO {

    private String name;
    private int groupSize;
    private LocalDateTime date = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);

    public GroupDTO(Group group) {
        this.name = group.getName();
        this.groupSize = group.getStudents().size();
        this.date = group.getDateCreated();
    }
}
