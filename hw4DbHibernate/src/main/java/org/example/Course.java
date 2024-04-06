package org.example;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "Courses")
public class Course {

    private static final Random random = new Random();
    private static final String[] courses = new String[]{"Java Junior", "Python", "JavaScript", "Java Spring", "SQL"};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int duration;

    public Course(Long id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public Course() {
    }

    public static Course create() {
        return new Course(courses[random.nextInt(courses.length)], random.nextInt(30, 60));
    }

    public Long getId() {
        return id;
    }

    public void updateTitle() {
        this.title = courses[random.nextInt(courses.length)];
    }

    public void updateDuration() {
        this.duration = random.nextInt(30, 60);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
