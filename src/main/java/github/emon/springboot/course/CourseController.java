package github.emon.springboot.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import github.emon.springboot.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getCourses() {

		return courseService.getAllCourses();
	}

	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable("id") String id) {

		return courseService.getCourse(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public Course addCourse(@RequestBody Course course, @PathVariable("topicId") String topicId) {
		
		Topic topic = new Topic();
		course.setTopic(topic);
		
		return courseService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}")
	public Course updateCourse(@RequestBody Course course, @PathVariable("id") String id) {
		return courseService.updateCourse(course, id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}")
	public void deleteCourse(@PathVariable("id") String id) {
		courseService.deleteCourse(id);
	}

}
