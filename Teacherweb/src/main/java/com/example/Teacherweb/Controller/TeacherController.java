package com.example.Teacherweb.Controller;

import com.example.Teacherweb.Entity.Teacher;
import com.example.Teacherweb.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@Controller
@RestController
@RequestMapping("api/teachers")
@CrossOrigin(origins = "/")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeacher(){
        List<Teacher> teachers = teacherService.getAllTeacher();
        return ResponseEntity.ok(teachers);
    }
    @GetMapping("/{id}")
    public ResponseEntity <Teacher> getTeacherById(@PathVariable Long id){
        Teacher teacher = teacherService.getTeacherById(id);
        return teacher != null ? ResponseEntity.ok(teacher) : ResponseEntity.notFound().build();

    }
    @PostMapping
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher){
        teacher.setId(null);
        Teacher createdTeacher = teacherService.addteacher(teacher);
        return ResponseEntity.ok(createdTeacher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id,@RequestBody Teacher teacher){
        Teacher updatedTeacher = teacherService.updateTeacher(id,teacher);
        return updatedTeacher != null ? ResponseEntity.ok(updatedTeacher) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok("Teacher Deleted Successfully");
    }

    @GetMapping("/search")
    public ResponseEntity<List<Teacher>> findTeacherByDepartment(
            @RequestParam(value = "department", required = false) String department){
        List<Teacher> teachers = teacherService.findByDepartment(department);
        return ResponseEntity.ok(teachers);
    }

}

