package tasks.adts

import u03.Sequences.Sequence.*
import org.junit.*
import org.junit.Assert.*
import tasks.adts.Ex2SchoolModel.BasicSchoolModel.*
import tasks.adts.Ex2SchoolModel.SchoolModel
import tasks.adts.Ex2SchoolModel.BasicSchoolModel.*
import tasks.adts.Ex2SchoolModel.BasicSchoolModel

class SchoolTest:

    val schoolModel: SchoolModel = BasicSchoolModel
    import schoolModel.*

    @Test def testAddTeacherAndCourse() = 
        val school = School(Nil(), Nil())
        val teacher = "Paola"
        val course = "Matematica"

        assertEquals(School(
            Cons(Teacher(teacher, Nil()), Nil()), Cons(Course(course), Nil())),
            school addTeacher teacher addCourse course)
    
