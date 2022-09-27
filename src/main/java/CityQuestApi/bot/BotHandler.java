package CityQuestApi.bot;

import CityQuestApi.command.CommandContainer;
import CityQuestApi.command.CommandName;
import CityQuestApi.service.PositionService;
import CityQuestApi.service.SendBotMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class BotHandler {

    private static final String COMMAND_PREFIX = "/";
    private static CommandContainer commandContainer;


    @Autowired
    public BotHandler(Bot bot, PositionService positionService) {
        BotHandler.commandContainer = new CommandContainer(new SendBotMessageService(bot), positionService);
    }

    public static void distribution(Update update) {
        System.out.println("Пришло: " + update.getMessage().getLocation());
        if(update.getMessage().hasLocation()) {
            commandContainer.retrieveCommand(CommandName.LOCATION.getCommandName()).execute(update);
        }
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                commandContainer.retrieveCommand(message).execute(update);
            } else {
                commandContainer.retrieveCommand(CommandName.NO.getCommandName()).execute(update);
            }
        }
    }
}
