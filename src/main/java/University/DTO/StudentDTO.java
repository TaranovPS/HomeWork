package University.DTO;

import University.Entity.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class StudentDTO {

    private String name;
    private LocalDateTime date = LocalDateTime.now();;

    public StudentDTO(Student student) {
        this.name = student.getName();
        this.date = student.getDateCreated();
    }
}
