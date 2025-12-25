package com.codegnan.service;

import java.util.List;

import com.codegnan.Exceptions.TeacherNotFoundException;
import com.codegnan.dao.TeacherDaoImp;
import com.codegnan.dao.TeacherDao;
import com.codegnan.model.Teacher;

public class TeacherServiceImp implements TeacherService{
	TeacherDao dao = new TeacherDaoImp();
	@Override
	public void addTeacher(Teacher teacher) {
		dao.save(teacher);
	}

	@Override
	public List<Teacher> getAllTeachers() {
		return dao.findAll();
	}

	@Override
	public Teacher getTeacherByTno(int tno) throws TeacherNotFoundException {
		return dao.findBy(tno);
	}

	@Override
	public void updateTeacher(Teacher teacher) throws TeacherNotFoundException {
		dao.update(teacher);
	}

	@Override
	public void deleteTeacher(int tno) throws TeacherNotFoundException {
		dao.deleteByTno(tno);
	}

	
}
