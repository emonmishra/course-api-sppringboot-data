package github.emon.springboot.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("java", "Core Java", "Core Java Course"),
			new Topic("angular", "Angular 2", "Angular 2 Course Quickstart"),
			new Topic("django", " django frawemwork", "Django Frame Work in Detail")));

	public List<Topic> getAllTopics() {

		return topics;
	}

	public Topic getTopic(String id) {

		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public boolean addTopic(Topic topic) {

		return topics.add(topic);
	}

	public Topic updateTopic(Topic topic, String id) {

		for (int i = 0; i < topics.size(); i++) {

			if (topics.get(i).getId().equals(id)) {
				return topics.set(i, topic);
			}
		}

		return null;
	}

	public boolean deleteTopic(String id) {

		return topics.removeIf(t -> t.getId().equals(id));
	}

}
