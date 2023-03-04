package chapter01.item07.listener;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.ref.WeakReference;
import java.util.List;

import org.junit.jupiter.api.Test;

class ChatRoomTest {

	@Test
	void charRoom() throws InterruptedException {
		ChatRoom chatRoom = new ChatRoom();
		User user1 = new User();
		User user2 = new User();

		chatRoom.addUser(user1);
		chatRoom.addUser(user2);

		chatRoom.sendMessage("hello");

		// user1 참조 제거
		user1 = null;

		System.gc();

		Thread.sleep(5000L);

		List<WeakReference<User>> users = chatRoom.getUsers();

		// gc 되면서 해당 더이상 참조 되지 않는 요소 자동 제거
		assertTrue(users.size() == 1);
	}

}