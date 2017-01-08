package github.emon.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("java", "Core Java", "Core Java Course"),
			new Topic("angular", "Angular 2", "Angular 2 Course Quickstart"),
			new Topic("django", " django frawemwork", "Django Frame Work in Detail")));

	public List<Topic> getAllTopics() {

		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);

		return topics;
	}

	public Topic getTopic(String id) {

		return topicRepository.findOne(id);
	}

	public Topic addTopic(Topic topic) {

		return topicRepository.save(topic);
	}

	public Topic updateTopic(Topic topic, String id) {

		return topicRepository.save(topic);
	}

	public void deleteTopic(String id) {

		topicRepository.delete(id);
	}

}
