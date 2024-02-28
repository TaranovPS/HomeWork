package University.DTO;

import University.Entity.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@NoArgsConstructor
public class StudentDTO {

    private String name;
    private LocalDateTime date = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);

    public StudentDTO(Student student) {
        this.name = student.getName();
        this.date = student.getDateCreated();
    }
}
