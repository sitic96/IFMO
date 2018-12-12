package fs_classes.DAO;

import DBWorker.DBWorkMethods;
import DBWorker.HibernateUtil;
import DBWorker.Table;
import fs_classes.classes.Country;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by sitora on 08.11.16.
 */
public class CountryDAO implements DBWorkMethods {
    HashSet<String> actions = new HashSet<>();

    {
        actions.add("add");
        actions.add("update");
        actions.add("getelementbyid");
        actions.add("show");
        actions.add("remove");
    }

    @Override
    public void add(Table country) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(country);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
    }

    @Override
    public void update(Integer id, Table country) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(country);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Country getElementById(Integer id) throws SQLException {
        Session session = null;
        Country country = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            country = (Country) session.load(Country.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return country;
    }

    @Override
    public Collection getAllElements() throws SQLException {
        Session session = null;
        List countries = new ArrayList<Country>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            countries = session.createCriteria(Country.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return countries;
    }

    @Override
    public void removeElement(Table country) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(country);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public HashSet<String> getAllAvailableActions() {
        return actions;
    }
}
