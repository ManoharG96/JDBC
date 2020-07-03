package com.dxctechnology.instituteproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentUtil {

	public int insertStudent (StudentInfo info) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.getConnection();
		try {
			String query = "insert into studentinfo values(?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, info.getStudId());
			statement.setString(2, info.getStudName());
			statement.setString(3, info.getStudAddress());
			statement.setString(4, info.getStudCity());
			statement.setString(5, info.getStudCountry());
			statement.setLong(6, info.getStudMobNo());

			int count= statement.executeUpdate();
			return count;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return 0;
	}

	public ArrayList<StudentInfo> getStudentInfo(String city) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getConnection();
		ArrayList<StudentInfo> infoList = new ArrayList<StudentInfo>();
		try {
			String query = "select * from studentinfo where studCity = ?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, city);
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				StudentInfo info = new StudentInfo();
				info.setStudId(set.getInt(1));
				info.setStudName(set.getString(2));
				info.setStudAddress(set.getString(3));
				info.setStudCity(set.getString(4));
				info.setStudCountry(set.getString(5));
				info.setStudMobNo(set.getLong(6));
				infoList.add(info);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return infoList;

	}

	public int updateStudentName(String name, int studentId) throws Exception {
		Connection con = DBUtil.getConnection();
		int count = 0;
		try {
			String query = "update studentinfo set studName = ? where studId = ?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, name);
			statement.setInt(2, studentId);
			count = statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return count;
	}

	public StudentInfo updateStudentMobileNo(int studId, String option, long mobile) throws Exception {
		Connection con = DBUtil.getConnection();
		Statement statement;
		StudentInfo info = new StudentInfo();
		try {
			statement = con.createStatement();
			statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			String query = "select * from studentinfo where studId = "+studId;
			ResultSet set = statement.executeQuery(query);
			if (set.next()) {
				info.setStudId(set.getInt("studId"));
				info.setStudName(set.getString("studName"));
				info.setStudAddress(set.getString("studAddress"));
				info.setStudCity(set.getString("studCity"));
				info.setStudCountry(set.getString("studCountry"));
				info.setStudMobNo(set.getLong("studMobNo"));
			}

			if(option.equalsIgnoreCase("yes")) {
				set.updateLong("studMobNo", mobile);
				set.updateRow();
			} 

		} catch (SQLException e) {
			e.printStackTrace();;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return info;
	}

}
