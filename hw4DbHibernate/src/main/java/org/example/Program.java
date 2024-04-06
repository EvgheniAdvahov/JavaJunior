package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        // Создание фабрики сессий
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Scanner scanner = new Scanner(System.in);
        int choise;
        while (true) {
            System.out.println("1: Для вывода всей таблицы Courses");
            System.out.println("2: Для добавления в таблицу Courses");
            System.out.println("3: Для изменения объекта в таблице Courses");
            System.out.println("4: Для удаления объекта в таблице Courses");
            System.out.println("5: Для выхода");
            choise = scanner.nextInt();
            if (choise == 1) {
                getAllFromCourses(sessionFactory);
            } else if (choise == 2) {
                addtoCourses(sessionFactory);
            } else if (choise == 3) {
                updateCourseById(sessionFactory);
            } else if (choise == 4) {
                deleteById(sessionFactory);
            } else if (choise == 5) {
                break;
            } else {
                System.out.println("Неправильный выбор");
            }
        }


    }

    public static void deleteById(SessionFactory sessionFactory) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id курса");
        int numberId = scanner.nextInt();
        //Сессия
        try (Session session = sessionFactory.getCurrentSession()) {
            //начало транзакции
            session.beginTransaction();

            List<Course> courses = session.createQuery("FROM Course", Course.class).getResultList();
            for (Course course : courses) {
                if (course.getId() == numberId) {
                    session.delete(course);
                    break;
                }
            }
            System.out.println("Такого id не существует");

            session.getTransaction().commit();
            System.out.println("Transaction delete successfully");
        }
    }

    public static void updateCourseById(SessionFactory sessionFactory) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id курса");
        int numberId = scanner.nextInt();
        //Сессия
        try (Session session = sessionFactory.getCurrentSession()) {
            //начало транзакции
            session.beginTransaction();

            List<Course> courses = session.createQuery("FROM Course", Course.class).getResultList();
            for (Course course : courses) {
                if (course.getId() == numberId) {
                    course.updateTitle();
                    course.updateDuration();
                    session.update(course);
                    break;
                }
            }
            System.out.println("Такого id не существует");

            session.getTransaction().commit();
            System.out.println("Transaction update successfully");
        }
    }

    public static void getAllFromCourses(SessionFactory sessionFactory) {
        //Сессия
        try (Session session = sessionFactory.getCurrentSession()) {
            //начало транзакции
            session.beginTransaction();

            List<Course> courses = session.createQuery("FROM Course", Course.class).getResultList();
            for (Course cours : courses) {
                System.out.println(cours);
            }

            session.getTransaction().commit();
            System.out.println("Transaction getAll successfully");
        }

    }


    public static void addtoCourses(SessionFactory sessionFactory) {
        //Сессия
        try (Session session = sessionFactory.getCurrentSession()) {
            //начало транзакции
            session.beginTransaction();

            Course course = Course.create();
            session.save(course);
            System.out.println("Object course is saved");

            session.getTransaction().commit();
            System.out.println("Transaction add successfully");
        }
    }
}