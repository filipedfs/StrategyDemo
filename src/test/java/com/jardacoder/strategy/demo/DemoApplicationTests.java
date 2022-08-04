package com.jardacoder.strategy.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jardacoder.strategy.demo.enums.NotificationType;
import com.jardacoder.strategy.demo.interfaces.factory.NotificationServiceFactory;

@SpringBootTest
@RunWith(SpringRunner.class)
class  NotificationServiceTests {
	
	@Autowired
	private NotificationServiceFactory notificationServiceFactory;

	@Test
	void testNotificationEmail() {
		NotificationType notification = notificationServiceFactory.
				findStrategy(NotificationType.EMAIL).sendNotification();
		
		assertEquals(notification, NotificationType.EMAIL);
	}
	
	@Test
	void testNotificationWhatsApp() {
		NotificationType notification = notificationServiceFactory.
				findStrategy(NotificationType.WHATSAPP).sendNotification();
		
		assertEquals(notification, NotificationType.WHATSAPP);
	}

}
