package exercise1.clients;

import exercise1.controller.LessonController;
import exercise1.models.*;
import exercise1.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class InsuranceApiClient {

    public static void main(String[] args) {

//        saveTestData();

        LessonController lessonController = new LessonController();

        List<Lesson> returnedList = lessonController.findAllLessons();

        for (Lesson lesson : returnedList) {

            System.out.println(lesson);

        }

        System.out.println(lessonController.findLesson(1));

//        Lesson lesson4 = new Lesson("Tarih",23321172,4);
//        lessonController.saveLesson(lesson4);

//        lessonController.deleteLesson(23321172);


    }

    private static void saveTestData() {

        Teacher teacher1 = new ConstantTeacher("Yusuf", "Eskişehir", 176800907, 5000);
        Teacher teacher2 = new ConstantTeacher("Mahmut", "Ankara", 193606795, 4500);
        Teacher teacher3 = new GuestTeacher("Hüseyin", "Bilecik", 210388107, 25);

        Lesson lesson1 = new Lesson("Matematik", 23321143, 7.5);
        Lesson lesson2 = new Lesson("Türkçe", 14333143, 5.0);
        Lesson lesson3 = new Lesson("Fizik", 45361143, 6.5);

        Student student1 = new Student("Ali", LocalDate.parse("1997-01-13"), "Eskişehir", StudentGender.MALE);
        Student student2 = new Student("Mehmet", LocalDate.parse("1998-03-23"), "Ankara", StudentGender.MALE);
        Student student3 = new Student("Özlem", LocalDate.parse("2001-05-19"), "Bursa", StudentGender.FEMALE);

        lesson1.setTeacher(teacher1);
        lesson2.setTeacher(teacher2);
        lesson3.setTeacher(teacher3);

        lesson1.getStudents().add(student1);
        lesson1.getStudents().add(student2);
        lesson2.getStudents().add(student3);


        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            em.getTransaction().begin();

            em.persist(teacher1);
            em.persist(teacher2);
            em.persist(teacher3);

            em.persist(lesson1);
            em.persist(lesson2);
            em.persist(lesson3);

            em.persist(student1);
            em.persist(student2);
            em.persist(student3);


            em.getTransaction().commit();

            System.out.println("All data persisted ....");

        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);

        }


    }


}


