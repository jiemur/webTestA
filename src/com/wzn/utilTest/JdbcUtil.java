package com.wzn.utilTest;

import com.mysql.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {
    private static final String URL= "jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&characterEncoding=utf8";
    private static final String USER="root";
    private static final String PWD="123456";
    static{
        try {
            new Driver();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection conn=null;
        try {
            conn= DriverManager.getConnection(URL,USER,PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void close(ResultSet rs, PreparedStatement pstm, Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pstm!=null){
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static int executUpdate(String sql,Object...obj){
        int a=0;
        Connection conn=null;
        PreparedStatement pstm=null;
        conn=getConnection();
        try {
            pstm= conn.prepareStatement(sql);
            if(obj!=null){
                for(int i=0;i<obj.length;i++){
                    pstm.setObject(i+1,obj[i]);
                }
            }
            a=pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(null,pstm,conn);
        }
        return a;
    }
    public static <T> List<T> executQuete(String sql,RowMap<T> rm,Object...obj){
        List<T> lists=new ArrayList();
        Connection conn=null;
        PreparedStatement pstm=null;
        conn=getConnection();
        try {
            pstm=conn.prepareStatement(sql);
            if(obj!=null){
                for(int i=0;i<obj.length;i++){
                    pstm.setObject(i+1,obj[i]);
                }
            }

            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                T t=rm.RowMapping(rs);
                lists.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  lists;
    }




    public static <T> T queteOne(String sql,RowMap<T> rm,Object...obj){
        T t=null;
        Connection conn=null;
        PreparedStatement pstm=null;
        conn=getConnection();
        try {
            pstm=conn.prepareStatement(sql);
            if(obj!=null){
                for(int i=0;i<obj.length;i++){
                    pstm.setObject(i+1,obj[i]);
                }
            }

            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                 t=rm.RowMapping(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  t;
    }
}
