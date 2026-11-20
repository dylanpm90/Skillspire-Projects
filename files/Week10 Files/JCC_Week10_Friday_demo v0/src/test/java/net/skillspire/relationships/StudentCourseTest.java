package net.skillspire.relationships;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class StudentCourseTest {
    @Autowired
    private StudentRepository students;

    @Autowired
    private CourseRepository courses;

    @Autowired
    private EntityManager entityManager;

    @Test
    void joinTableConnectsBothSidesAfterReload() {
        Course spring = courses.save(new Course("Spring"));
        Course java = courses.save(new Course("Java"));

        Student ada = new Student("Ada");
        ada.addCourse(spring);
        ada.addCourse(java);
        Long adaId = students.save(ada).getId();

        Student grace = new Student("Grace");
        grace.addCourse(spring);
        students.saveAndFlush(grace);
        Long springId = spring.getId();
        entityManager.clear();

        Student reloadedStudent = students.findById(adaId).orElseThrow();
        assertThat(reloadedStudent.getCourses()).extracting(Course::getTitle)
                .containsExactlyInAnyOrder("Spring", "Java");

        Course reloadedCourse = courses.findById(springId).orElseThrow();
        assertThat(reloadedCourse.getStudents()).extracting(Student::getName)
                .containsExactlyInAnyOrder("Ada", "Grace");
    }

    @Test
    void deletingOneStudentLeavesSharedCourseAndOtherEnrollment() {
        Course spring = courses.save(new Course("Spring"));

        Student ada = new Student("Ada");
        ada.addCourse(spring);
        Long adaId = students.save(ada).getId();

        Student grace = new Student("Grace");
        grace.addCourse(spring);
        students.saveAndFlush(grace);
        Long springId = spring.getId();
        entityManager.clear();

        students.deleteById(adaId);
        students.flush();
        entityManager.clear();

        Course reloadedCourse = courses.findById(springId).orElseThrow();
        assertThat(reloadedCourse.getStudents()).extracting(Student::getName)
                .containsExactly("Grace");
    }
}
