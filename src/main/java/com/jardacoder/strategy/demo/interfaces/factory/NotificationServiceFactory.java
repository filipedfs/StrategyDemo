package com.jardacoder.strategy.demo.interfaces.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.jardacoder.strategy.demo.enums.NotificationType;
import com.jardacoder.strategy.demo.interfaces.NotificationService;

@Component
public class NotificationServiceFactory {

	private Map<NotificationType, NotificationService> strategies;

	public NotificationServiceFactory(Set<NotificationService> strategySet) {
		createStrategy(strategySet);
	}

	public NotificationService findStrategy(NotificationType strategyName) {
		return strategies.get(strategyName);
	}

	private void createStrategy(Set<NotificationService> strategySet) {
		strategies = new HashMap<NotificationType, NotificationService>();
		strategySet.forEach(strategy -> 
			strategies.put(strategy.getStrategyName(), strategy)
		);
	}
}
