package com.guru99.tests;

import java.sql.SQLException;

import org.testng.annotations.Test;

import commonLibs.utils.DatabaseUtils;

public class Demo {

	public static void main(String[] args) {
		try {
			DatabaseUtils dbUtils = new DatabaseUtils();

			dbUtils.openConnection("localhost", "Guru99TestData", "root", "admin@1234");

			Object[][] data = dbUtils.executeSqlSelectQuery("select * from Users");

			dbUtils.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
