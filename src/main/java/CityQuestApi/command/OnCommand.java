package CityQuestApi.command;

import CityQuestApi.service.LocationService;
import CityQuestApi.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class OnCommand implements Command
{
    private final SendBotMessageService sendBotMessageService;

    public static final String ON_MESSAGE = "Кнопка появилась\n\n";

    public OnCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        LocationService locationService = new LocationService();
        sendBotMessageService.addButton(update.getMessage().getChatId().toString(), locationService.getButton());
    }
}
