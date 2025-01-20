package com.example.layeredarchitecture;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlUtil {

    public static <T> T execute(String sql,Object... obj) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        for (int i = 0; i < obj.length; i++) {
            pstm.setObject(i+1, obj[i]);
        }

        if (sql.startsWith("SELECT")){
            ResultSet rst = pstm.executeQuery();
            return (T) rst;
        }else {
            return  (T) (Boolean) (pstm.executeUpdate()>0);
        }

    }
}
