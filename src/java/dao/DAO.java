/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Person;
import entity.Position;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bunny
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Person> getAll() {
        String query = "select pe.*,po.name from person pe join position po\n"
                + "on pe.pid = po.id";
        List<Person> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Person(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<Person> search(String txt) {
        String query = "select pe.*,po.name from person pe join position po\n"
                + "on pe.pid = po.id where pe.name like ?";
        List<Person> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txt + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Person(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<Person> filter(String txt) {
        String query = "select pe.*,po.name from person pe join position po\n"
                + "                on pe.pid = po.id where pe.pid = ?";
        List<Person> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, txt);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Person(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public Person getPersonByid(String id) {
        String query = "select pe.*,po.name from person pe join position po\n"
                + "on pe.pid = po.id where pe.personid = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Person(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Position> getAllPosition() {
        String query = "select * from position";
        List<Position> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Position(rs.getInt(1),
                        rs.getString(2)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public void delete(String id) {
        String query = "delete from person \n"
                + "where personid = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void add(String name, String dob, String address, String join, String gender, String pid) {
        String query = "insert into person\n"
                + "values(?,?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, dob);
            ps.setString(3, gender);
            ps.setString(4, address);
            ps.setString(5, join);
            ps.setString(6, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void edit(String name, String dob, String address, String join, String gender, String pid, String id) {
        String query = "update person \n"
                + "set [name] = ?,\n"
                + "dob = ?,\n"
                + "gender = ?,\n"
                + "[address] = ?,\n"
                + "joindate = ?,\n"
                + "pid = ?\n"
                + "where personid = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, dob);
            ps.setString(3, gender);
            ps.setString(4, address);
            ps.setString(5, join);
            ps.setString(6, pid);
            ps.setString(7, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        List<Person> list = dao.getAll();
        for (Person o : list) {
            System.out.println(o);
        }
    }
}
