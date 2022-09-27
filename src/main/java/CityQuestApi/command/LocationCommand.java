package CityQuestApi.command;

import CityQuestApi.models.Position;
import CityQuestApi.service.PositionService;
import CityQuestApi.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class LocationCommand implements Command
{
    private final SendBotMessageService sendBotMessageService;
    private final PositionService positionService;


    public LocationCommand(SendBotMessageService sendBotMessageService, PositionService positionService) {
        this.sendBotMessageService = sendBotMessageService;
        this.positionService = positionService;
    }

    @Override
    public void execute(Update update) {
        Location location = update.getMessage().getLocation();
        List<Position> positionList = positionService.getAllPositions();
        if(location == null) {
            sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), "Ошибка определения локации");
        } else {
            sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),
                    "Longitude (Долгота) = " + location.getLongitude() + "\n" +
                            "Latitude (Широта) = " + location.getLatitude());

            boolean isFound = false;
            for(Position position : positionList) {
                if(checkingPosition(position, location.getLongitude(), location.getLatitude())) {
                    sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),
                            "Твое местоположение : '" + position.getName() + "'");
                    isFound = true;
                }
            }
            if(!isFound) {
                sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),
                        "Местоположение не определено");
            }
        }
    }

    private boolean checkingPosition(Position position, double longitude, double latitude) {
        double positionLong = position.getLongitude();
        double positionLat = position.getLatitude();
        double radius = position.getRadius();

        double result = Math.sqrt(Math.pow(longitude - positionLong, 2) + Math.pow(latitude - positionLat, 2));
        return result <= radius;
    }
}
