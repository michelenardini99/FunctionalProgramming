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

    val school = School(Nil(), Nil())
        val teacher = "Paola"
        val course = "Matematica"

    @Test def testAddTeacherAndCourse() = 
        assertEquals(School(
            Cons(Teacher(teacher, Nil()), Nil()), Cons(Course(course), Nil())),
            school addTeacher teacher addCourse course)

    @Test def testFilterTeacherByName() =
        assertEquals(Teacher(teacher, Nil()),
            orElse(school.addTeacher(teacher).teacherByName(teacher), Empty()))

    
