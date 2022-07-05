package ru.cbr.demorestservice.domain.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class DomainEventListener {

    @EventListener
    public void handleEvent(DomainEvent event) {
        log.info(">>> handle received domain event: " + event);
    }
}
