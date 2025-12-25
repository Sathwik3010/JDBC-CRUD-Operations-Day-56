package com.codegnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.Exceptions.TeacherNotFoundException;
import com.codegnan.factory.ConnectionFactory;
import com.codegnan.model.Teacher;

public class TeacherDaoImp implements TeacherDao{

	@Override
	public void save(Teacher teacher) {
		String Insertsql = "INSERT INTO TEACHER (TNO, TNAME, TSAL, TADDR) VALUES(?,?,?,?)";
		try(Connection con = ConnectionFactory.getConnection();
				PreparedStatement ps = con.prepareStatement(Insertsql)){
			
			ps.setInt(1, teacher.getTno());
			ps.setString(2, teacher.getTname());
			ps.setDouble(3, teacher.getTsal());
			ps.setString(4, teacher.getTaddr());

			int rowsAffected = ps.executeUpdate();
			if(rowsAffected == 1) {
				System.out.println("rows inserted sucessfully");
			} else {
				System.out.println("row insertion did not happen");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	} 

	@Override
	public List<Teacher> findAll() {
		List<Teacher> list = new ArrayList<>();
		String Selectsql = "SELECT * FROM TEACHER";
		try(Connection con = ConnectionFactory.getConnection();
				PreparedStatement ps = con.prepareStatement(Selectsql)){
			
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			list.add(new Teacher(rs.getInt(1), 
								rs.getString(2),
								rs.getDouble(3),
								rs.getString(4)));
		}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Teacher findBy(int tno) throws TeacherNotFoundException {
		String sql = "select * from teacher where tno=?";
		try(Connection con = ConnectionFactory.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, tno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new Teacher(rs.getInt(1),
								   rs.getString(2),
								   rs.getDouble(3),
								   rs.getString(4));
			} else {
				throw new TeacherNotFoundException("Id not Found : "+tno);
			}
		} catch(SQLException e) {
			throw new TeacherNotFoundException("Data base Error "+e.getMessage());
		}
	}

	@Override
	public void update(Teacher teacher) throws TeacherNotFoundException {
		String UpdateSql = "UPDATE TEACHER SET TNAME=?, TSAL=?, TADDR=? WHERE TNO=?";
		try(Connection con = ConnectionFactory.getConnection();
				PreparedStatement ps = con.prepareStatement(UpdateSql)){
			ps.setString(1, teacher.getTname());
			ps.setDouble(2, teacher.getTsal());
			ps.setString(3, teacher.getTaddr());
			ps.setInt(4, teacher.getTno());

			int rowsAffected = ps.executeUpdate();
			if(rowsAffected == 0) {
				throw new TeacherNotFoundException("Id not Found : "+teacher.getTno());
			} else {
				System.out.println("Updated teacher: "+teacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteByTno(int tno) throws TeacherNotFoundException {
		String deleteSql = "DELETE FROM TEACHER WHERE TNO=?";
		try(Connection con = ConnectionFactory.getConnection();
				PreparedStatement ps = con.prepareStatement(deleteSql)){
			ps.setInt(1, tno);
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected == 0) {
				throw new TeacherNotFoundException("Id not Found : "+tno);
			} else {
				System.out.println("Deleted teacher: "+tno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
