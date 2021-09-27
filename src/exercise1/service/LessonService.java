package exercise1.service;


import exercise1.models.Lesson;
import exercise1.repository.CrudRepository;
import exercise1.repository.LessonRepository;
import exercise1.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class LessonService implements CrudRepository<Lesson>, LessonRepository {

    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Lesson> finAll() {

        return em.createQuery("select l from Lesson l", Lesson.class).getResultList();
    }

    @Override
    public Lesson findById(int id) {
        return em.find(Lesson.class, id);
    }

    @Override
    public void saveToDatabase(Lesson lesson) {
        em.getTransaction().begin();
        em.persist(lesson);
        em.getTransaction().commit();
    }
    @Override
    public void deleteFromDatabase(Lesson lesson) {
        em.getTransaction().begin();
        em.remove(lesson);
        em.getTransaction().commit();
    }


    @Override
    public void updateOnDatabase(Lesson object) {

        Lesson lesson = em.find(Lesson.class, 1);
        em.getTransaction().begin();
        lesson.setCourseName("İngilizce");
        em.getTransaction().commit();
    }
    @Override
    public void deleteLessonFromDatabase(long courseCode) {
        em.getTransaction().begin();
        Lesson lessons = em.createQuery("from Lesson l WHERE l.courseCode =:coursecode",Lesson.class).setParameter("coursecode",courseCode).getSingleResult();
        em.remove(lessons);
        em.getTransaction().commit();
    }
}
