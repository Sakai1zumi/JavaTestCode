package com.th1024.dao;

import com.th1024.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

/**
 * @author TuHong
 * @create 2021-03-23 20:42
 */
public abstract class BaseDAO {

    //使用DbUtils实现对数据库的操作
    QueryRunner queryRunner = new QueryRunner();

    /**
     * update()方法用来执行对数据库的增删改操作
     * @param sql
     * @param args
     * @return 返回-1表示执行失败；返回其它数字表示受影响的行数
     */
    public int update(String sql,Object... args){
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            return queryRunner.update(conn,sql,args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(conn);
        }
        return -1;
    }

    /**
     * queryForOne()方法返回表中的一条记录对应的JavaBean对象
     * @param tClass
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> T queryForOne(Class<T> tClass,String sql,Object... args){
        Connection conn = null;

        try {
            conn = JdbcUtils.getConnection();
            return queryRunner.query(conn,sql,new BeanHandler<T>(tClass),args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(conn);
        }
        return null;
    }

    /**
     * queryForList()方法返回表中多个记录对应的JavaBean所构成的集合
     * @param tClass
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T>List<T> queryForList(Class<T> tClass,String sql,Object... args){
        Connection conn = null;

        try {
            conn = JdbcUtils.getConnection();
            return queryRunner.query(conn,sql, new BeanListHandler<T>(tClass),args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(conn);
        }
        return null;
    }

    public Object queryForSingleValue(String sql,Object... args){
        Connection conn = null;

        try {
            conn = JdbcUtils.getConnection();
            return queryRunner.query(conn,sql, new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(conn);
        }
        return null;
    }
}
