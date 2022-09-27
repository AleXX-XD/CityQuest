package CityQuestApi.command;

import CityQuestApi.service.LocationService;
import CityQuestApi.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class OffCommand implements Command
{
    private final SendBotMessageService sendBotMessageService;

    public static final String Off_MESSAGE = "Кнопка исчезла";

    public OffCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        LocationService locationService = new LocationService();
        sendBotMessageService.hideButton(update.getMessage().getChatId().toString(), locationService.hideButton());
    }
}
