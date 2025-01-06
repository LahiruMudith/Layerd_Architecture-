package com.example.layeredarchitecture;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlUtil {

    public SqlUtil(String sql) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        if (sql.startsWith("SELECT")){
            pstm.executeQuery();
        }else {
            pstm.executeUpdate()
        }

    }
}
