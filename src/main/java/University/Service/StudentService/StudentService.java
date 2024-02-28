package University.Service.StudentService;

import University.DTO.StudentDTO;
import University.Entity.Student;

import java.util.List;

public interface StudentService {

    public List<StudentDTO> findAll();

    public StudentDTO findById(Integer id);

    public List<StudentDTO> findByGroupName(String groupNumber);

    public void addStudent(String groupName, StudentDTO studentDTO);
}
