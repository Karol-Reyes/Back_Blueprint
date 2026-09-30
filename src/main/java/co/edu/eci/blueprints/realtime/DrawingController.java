package co.edu.eci.blueprints.realtime;

import co.edu.eci.blueprints.persistence.BlueprintNotFoundException;
import co.edu.eci.blueprints.services.BlueprintsServices;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller 
public class DrawingController {
    
    private final BlueprintsServices services;
    private final SimpMessagingTemplate messagingTemplate;

    public DrawingController(BlueprintsServices services, SimpMessagingTemplate messagingTemplate) {
        this.services = services;
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping ("/draw")
    public void handleDrawing(DrawEvent event) {
        try {
            services.addPoint(event.author(), event.name(), event.point().x(), event.point().y());
            String topic = "/topic/blueprints.%s.%s".formatted(event.author(), event.name());
            messagingTemplate.convertAndSend(topic, event);
        } catch (BlueprintNotFoundException e) {
            
        }
        
    }
}
