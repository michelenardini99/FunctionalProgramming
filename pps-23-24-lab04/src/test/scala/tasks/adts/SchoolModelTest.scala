package tasks.adts

import u03.Sequences.Sequence.*
import org.junit.*
import org.junit.Assert.*
import tasks.adts.Ex2SchoolModel.BasicSchoolModel.*
import tasks.adts.Ex2SchoolModel.SchoolModel
import tasks.adts.Ex2SchoolModel.BasicSchoolModel.*
import tasks.adts.Ex2SchoolModel.BasicSchoolModel
import u03.Optionals.*
import u03.Optionals.Optional.*

class SchoolTest:

    val schoolModel: SchoolModel = BasicSchoolModel
    import schoolModel.*

    val school = School(
        Cons(Teacher("Paola", Nil()),
        Cons(Teacher("Michele", Nil()), Nil())),
        Nil()
    )
    val teacher = "Giovanni"
    val course = "Matematica"

    @Test def testAddTeacherAndCourse() = 
        assertEquals(School(
                        Cons(Teacher(teacher, Nil()),
                            Cons(Teacher("Paola", Nil()),
                                Cons(Teacher("Michele", Nil()), Nil()))), 
                        Cons(Course(course), Nil())),
                        school.addTeacher(teacher).addCourse(course)
                    )

    @Test def testFilterTeacherByName() =
        assertEquals(Teacher(teacher, Nil()),
            orElse(school.addTeacher(teacher).teacherByName(teacher), Empty()))

    @Test def testFilterCourseByName() =
        assertEquals(Course(course),
            orElse(school.addCourse(course).courseByName(course), Empty()))

    @Test def testSetCourseToTeacher() =
        assertEquals(School(
                        Cons(Teacher(teacher, Cons(Course(course), Nil())),
                            Cons(Teacher("Paola", Nil()),
                                Cons(Teacher("Michele", Nil()), Nil()))), 
                        Nil()),
                        school.addTeacher(teacher).setTeacherToCourse(Teacher(teacher, Nil()), Course(course)))
