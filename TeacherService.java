package com.codegnan.service;

import java.util.List;

import com.codegnan.Exceptions.TeacherNotFoundException;
import com.codegnan.model.Teacher;

public interface TeacherService {

	public void addTeacher(Teacher teacher);
	
	public List<Teacher> getAllTeachers();
	
	public Teacher getTeacherByTno(int tno) throws TeacherNotFoundException;

	public void updateTeacher(Teacher teacher) throws TeacherNotFoundException;

	public void deleteTeacher(int tno) throws TeacherNotFoundException;

}
