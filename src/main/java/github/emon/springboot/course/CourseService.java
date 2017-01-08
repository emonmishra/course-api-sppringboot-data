package github.emon.springboot.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;


	public List<Course> getAllCourses() {

		List<Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);

		return courses;
	}

	public Course getCourse(String id) {

		return courseRepository.findOne(id);
	}

	public Course addCourse(Course course) {

		return courseRepository.save(course);
	}

	public Course updateCourse(Course course, String id) {

		return courseRepository.save(course);
	}

	public void deleteCourse(String id) {

		courseRepository.delete(id);
	}

}
