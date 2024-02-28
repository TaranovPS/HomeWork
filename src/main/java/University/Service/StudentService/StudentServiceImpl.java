package University.Service.StudentService;

import University.DTO.StudentDTO;
import University.Entity.Group;
import University.Entity.Student;
import University.Exceptions.GroupNotFoundException;
import University.Exceptions.StudentNotFoundException;
import University.Repository.GroupRepository;
import University.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    StudentRepository repository;
    GroupRepository groupRepository;

    public StudentServiceImpl(StudentRepository repository, GroupRepository groupRepository) {
        this.repository = repository;
        this.groupRepository = groupRepository;
    }

    public List<StudentDTO> findAll() {
        return repository.findAll()
                .stream()
                .sorted(Comparator.comparing(Student::getName))
                .map(StudentDTO::new)
                .collect(Collectors.toList());
    }

    public StudentDTO findById(Integer id) {
        Optional<Student> student = repository.findById(id);
        StudentDTO studentDTO;

        if (student.isPresent()) {
            studentDTO = new StudentDTO(student.get());
        }
        else {
            throw new StudentNotFoundException("Student not found");
        }
        return studentDTO;

    }

    public List<StudentDTO> findByGroupName(String groupNumber) {
        return repository.findByGroupName(groupNumber)
                .stream()
                .map(StudentDTO::new)
                .collect(Collectors.toList());
    }

    public void addStudent(String groupName, StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());

        Group group = groupRepository.findByName(groupName);

        student.setGroup(group);
        repository.save(student);
    }

}
