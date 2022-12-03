package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    private HashMap<String,Student> studentHashMap;
    private HashMap<String, Teacher> teacherHashMap;
    private HashMap<String, List<String>> teacherStudentMap;

    public StudentRepository() {
        this.studentHashMap = new HashMap<String , Student>();
        this.teacherHashMap =  new HashMap<String , Teacher>();
        this.teacherStudentMap =  new HashMap<String , List<String>>();
    }

    public void saveStudent(Student student)
    {
        studentHashMap.put(student.getName(),student);
    }

    public void saveTeacher(Teacher teacher)
    {
        teacherHashMap.put(teacher.getName(),teacher);
    }
    public void saveStudentTeacherPair(String student, String teacher)
    {
        if(studentHashMap.containsKey(student) && teacherStudentMap.containsKey(teacher))
        {
            studentHashMap.put(student, studentHashMap.get(student));
            teacherHashMap.put(teacher, teacherHashMap.get(teacher));

            List<String> studentpresent = new ArrayList<>();
            if(teacherStudentMap.containsKey(teacher))
                studentpresent=teacherStudentMap.get(teacher);
            studentpresent.add(student);
            teacherStudentMap.put(teacher,studentpresent);
        }
    }
    public Student findStudent(String student)
    {

        return studentHashMap.get(student);
    }
    public Teacher findTeacher(String teacher)
    {
        return teacherHashMap.get(teacher);
    }
    public List<String> getStudentsByTeacher(String teacher){
        List<String> allStudent = new ArrayList<String>();
        if(teacherStudentMap.containsKey(teacher))
            allStudent= teacherStudentMap.get(teacher);
        return allStudent;
    }
    public List<String> findAllStudents(){
        return new ArrayList<>(studentHashMap.keySet());
    }
    public void deleteteacher(String teacher){
        List<String> students = new ArrayList<String>();
        if(teacherStudentMap.containsKey(teacher)){
            students = teacherStudentMap.get(teacher);
            for(String student: students){
                if(studentHashMap.containsKey(student)){
                    studentHashMap.remove(student);
                }
            }

            teacherStudentMap.remove(teacher);
        }

        if(teacherHashMap.containsKey(teacher)){
            teacherHashMap.remove(teacher);
        }
    }
    public void deleteAllTeacher(){
        HashSet<String> set = new HashSet<String>();

        for(String teachers: teacherStudentMap.keySet()){
            for(String student: teacherStudentMap.get(teachers)){
                set.add(student);
            }
        }

        for(String student: set){
            if(studentHashMap.containsKey(student)){
                teacherHashMap.remove(student);
            }
        }
    }

}