package com.example.Teacherweb.Service;

import com.example.Teacherweb.Entity.Teacher;
import com.example.Teacherweb.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher addteacher(Teacher teacher){
        teacherRepository.save(teacher);
        return teacher;
    }
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }
    public List<Teacher> getAllTeacher(){
        return teacherRepository.findAll();
    }
    public List<Teacher> findByDepartment(String department) {
        return teacherRepository.findByDepartment(department);
    }
    public  Teacher updateTeacher(Long id, Teacher teacher) {
        Teacher existingTeacher = teacherRepository.findById(id).orElse(null);
        if (existingTeacher != null) {
            existingTeacher.setName(teacher.getName());
            existingTeacher.setSubject(teacher.getSubject());
            existingTeacher.setDepartment(teacher.getDepartment());
            existingTeacher.setSection(teacher.getSection());
            return teacherRepository.save(existingTeacher);
        }
        return null;
    }
}
