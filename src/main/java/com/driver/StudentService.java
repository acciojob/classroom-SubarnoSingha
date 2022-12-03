package com.driver;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student)
    {

        studentRepository.saveStudent(student);
    }
    public void addTeacher(Teacher teacher)
    {
        studentRepository.saveTeacher(teacher);

    }
    public void addStudentTeacherPair(String student, String teacher )
    {
        studentRepository.saveStudentTeacherPair(student,teacher);
    }
    public Student getStudentByName(String studentname)
    {
        return studentRepository.findStudent(studentname);
    }
    public Student getTeacherByName(String Teachername)
    {
        return studentRepository.findTeacher(Teachername);
    }
    public List<String> getStudentsByTeacherName(String teacher)
    {
        return studentRepository.getStudentsByTeacherName(teacher)
    }
    public List<String> getAllStudents()
    {
        return studentRepository.findAllStudent();
    }
    public void deleteTeacherByName(String teacher)
    {
        studentRepository.deleteAllTeacher(teacher);
    }
    public void deleteAllTeachers()
    {
        studentRepository.deleteAllTeachers();
    }


}
