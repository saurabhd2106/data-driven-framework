package com.guru99.utils;

import org.testng.annotations.DataProvider;

import commonLibs.utils.DatabaseUtils;

public class TestDataSource {

	@DataProvider
	public Object[][] getDataFromDb() throws Exception {
		
		String server = "localhost";
		String database = "Guru99TestData";
		String username = "root";
		String password = "admin@1234";

		return readDataFromDatabase(server, database, username, password);

	}

	private Object[][] readDataFromDatabase(String server, String database, String username, String password)
			throws Exception {
		DatabaseUtils databaseUtils = new DatabaseUtils();
		
		databaseUtils.openConnection(server, database, username, password);
		
		Object[][] data;

		String sqlQuery = "select * from Users";
		
		data = databaseUtils.executeSqlSelectQuery(sqlQuery);
		
		databaseUtils.closeConnection();

		return data;
		
		
	}

}
