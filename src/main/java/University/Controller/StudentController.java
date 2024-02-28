package University.Controller;


import University.DTO.StudentDTO;
import University.Service.StudentService.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/groups/{groupName}")
public class StudentController {

    StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<?> getCourse(@PathVariable String groupName) {
        List<StudentDTO> students = service.findByGroupName(groupName);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addStudentToCourse(@PathVariable String groupName, @RequestBody StudentDTO studentDTO) {
        service.addStudent(groupName, studentDTO);
        return new ResponseEntity<>(studentDTO, HttpStatus.CREATED);
    }

}
