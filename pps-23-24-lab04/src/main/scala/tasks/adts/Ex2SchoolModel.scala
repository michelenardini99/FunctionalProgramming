package tasks.adts
import u03.Sequences.Sequence.*
import u03.Sequences.*
import u03.Optionals.*
import u03.Optionals.Optional.*
import u02.AlgebraicDataTypes.Person
import u03.Sequences.Sequence.map

/*  Exercise 2: 
 *  Implement the below trait, and write a meaningful test.
 *  Suggestion: 
 *  - reuse Sequences and Optionals as imported above
 *  - Course is a simple case classes with just the name
 *  - Teacher is a case class with name and sequence of courses
 *  - School is a case class with (sequences of) teachers and courses
 *  - add/set methods below create the new school 
 */

object Ex2SchoolModel:

  trait SchoolModel:
    type School
    type Teacher
    type Course
    extension (school: School)
      def addTeacher(name: String): School
      def addCourse(name: String): School
      def teacherByName(name: String): Optional[Teacher]
      def courseByName(name: String): Optional[Course]
      def nameOfTeacher(teacher: Teacher): String
      def nameOfCourse(course: Course): String
      def setTeacherToCourse(teacher: Teacher, course: Course): School
      def coursesOfATeacher(teacher: Teacher): Sequence[Course]

  object BasicSchoolModel extends SchoolModel:

    case class Course(course: String)
    case class Teacher(name: String, courses: Sequence[Course])
    case class School(teachers: Sequence[Teacher], courses: Sequence[Course])

    extension (school: School)
      def addTeacher(name: String): School = school match
        case School(teachers, courses) => School(Cons(Teacher(name, Nil()), teachers), courses)
      
      def addCourse(name: String): School = school match
        case School(teachers, courses) => School(teachers, Cons(Course(name), courses))
      
      def teacherByName(name: String): Optional[Teacher] = school match
        case School(teachers, _) => {
          val teacherFiltered = filter(teachers)(t => nameOfTeacher(t) == name)
          teacherFiltered match
            case Cons(teacher, _) => Just(teacher)
            case _ => Empty()
        }
      def courseByName(name: String): Optional[Course] = school match
        case School(_, courses) => {
          val courseFiltered = filter(courses)(c => nameOfCourse(c) == name)
          courseFiltered match
            case Cons(course, _) => Just(course)
            case _ => Empty()
        }
      def nameOfTeacher(teacher: Teacher): String = teacher match
        case Teacher(name, _) => name
      
      def nameOfCourse(course: Course): String = course match
        case Course(name) => name
      def setTeacherToCourse(teacher: Teacher, course: Course): School = school match
        case School(teachers, _) => {
          val updatedTeacher = Teacher(nameOfTeacher(teacher), Cons(course, coursesOfATeacher(teacher)))
          val updatedTeachers = map(teachers)(t => if nameOfTeacher(t) == nameOfTeacher(updatedTeacher) then updatedTeacher else t)
          school.copy(teachers = updatedTeachers)
        }
      
      def coursesOfATeacher(teacher: Teacher): Sequence[Course] = teacher match
        case Teacher(_, courses) => courses
      
      