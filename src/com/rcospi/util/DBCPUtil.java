package com.rcospi.util;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 根據配置文件初始化设置数据源，获取连接的工具类
 */
public class DBCPUtil {

    private static DataSource dataSource;

    static {
        try {
            InputStream in = DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");  // 前面不能加斜线！！！
            Properties props = new Properties();
            props.load(in);
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
//            e.printStackTrace();    // 控制台打印异常信息
//            throw new ExceptionInInitializerError("初始化数据库配置文件失败");  // 快速定位错误
            throw new ExceptionInInitializerError(e);   // 异常链，提点前面两句
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("从数据源获取连接失败");
        }
    }
}

