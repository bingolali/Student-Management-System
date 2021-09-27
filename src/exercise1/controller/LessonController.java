package exercise1.controller;

import exercise1.models.Lesson;
import exercise1.models.Student;
import exercise1.models.Teacher;
import exercise1.service.LessonService;

import java.util.List;

public class LessonController {

    private LessonService lessonService = new LessonService();

    public Lesson findLesson(int lessonId){

        return lessonService.findById(lessonId);
    }

    public List<Lesson> findAllLessons(){

        return lessonService.finAll();

    }
    public void saveLesson(Lesson lesson){

        lessonService.saveToDatabase(lesson);

    }

    public List<Teacher> findTeacherofLesson(long phoneNumber){

        return null;

    }

    public void deleteLesson(long courseCode){
        lessonService.deleteLessonFromDatabase(courseCode);
    }

}
