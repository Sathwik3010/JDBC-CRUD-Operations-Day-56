package com.codegnan.controller;

import com.codegnan.service.TeacherServiceImp;

import java.util.ArrayList;
import java.util.List;

import com.codegnan.Exceptions.TeacherNotFoundException;
import com.codegnan.model.Teacher;
import com.codegnan.service.TeacherService;

public class TeacherApp {

	public static void main(String[] args) {
		// inserting the records
		TeacherService service= new TeacherServiceImp();
	//		service.addTeacher(new Teacher(101,"Dev",850000, "HYD"));
	//		service.addTeacher(new Teacher(102,"Ruthwik",900000, "BLR"));
	//		service.addTeacher(new Teacher(103,"Raghu",600000, "CHN"));
	//		System.out.println("teachers are inserted successfully");
	//		
		//fetching all the records
//		System.out.println("ID\tNAME\tDEPARTMENT\tSalary");
//		System.out.println("-----------------------------");
//		List<Teacher> teachers = service.getAllTeachers();
//		for(Teacher t: teachers) {
//			System.out.println(t);
//		}
		
		//find by id 2
//		try {
//			Teacher t = service.getTeacherByTno(102);
//			System.out.println("Found: "+t);
//		}catch(TeacherNotFoundException e) {
//			e.printStackTrace();
//		}
		
		//update the record 101
//		try {
//			service.updateTeacher(new Teacher(101,"nandini",90000,"KOL"));
//		}catch(TeacherNotFoundException e) {
//			e.printStackTrace();
//		}
		
		//delete the record 103
		try {
			service.deleteTeacher(103);
		} catch(TeacherNotFoundException e) {
			e.printStackTrace();
		}
	}

}
