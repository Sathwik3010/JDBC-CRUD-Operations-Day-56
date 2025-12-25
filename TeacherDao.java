package com.codegnan.dao;

import java.util.List;

import com.codegnan.Exceptions.TeacherNotFoundException;
import com.codegnan.model.Teacher;

public interface TeacherDao {

	public void save(Teacher teacher);

	public List<Teacher> findAll();

	public Teacher findBy(int tno) throws TeacherNotFoundException;

	public void update(Teacher teacher) throws TeacherNotFoundException;

	public void deleteByTno(int tno) throws TeacherNotFoundException;
}
