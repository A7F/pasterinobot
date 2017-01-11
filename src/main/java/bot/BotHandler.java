package bot;

import configs.BotConfig;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import keyboards.MyKeyboard;
import static org.apache.commons.lang3.StringUtils.isNumeric;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.api.methods.AnswerInlineQuery;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.inlinequery.InlineQuery;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import utils.LocalisationService;

/**
 * class to handle incoming commands and inline queries
 * @author Luke
 */
public class BotHandler extends TelegramLongPollingBot{
    Pasta pasta = new Pasta();

    @Override
    public String getBotToken(){
        return BotConfig.BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update){
        
        if(update.hasMessage()){
            SendMessage message = new SendMessage();
            String text = update.getMessage().getText();
            text = text.toLowerCase();
            message.setChatId(update.getMessage().getChatId().toString());
            message.enableMarkdown(true);
            
            if(text.equals("/start") || text.equals("start")){
                message.setReplyMarkup(new MyKeyboard());
                message.setText(LocalisationService.getInstance().getString("start"));
            }
            
            if(text.equals("random")){
                Random rand = new Random();
                int randomNum = rand.nextInt((61 - 2) + 1) + 2;
                String selected = String.valueOf(randomNum);
                message.setText(LocalisationService.getInstance().getString(selected));
            }
            
            if(text.equals("/help") || text.equals("help")){
                message.setText(LocalisationService.getInstance().getString("help"));
            }
            
            if(isNumeric(text)){
                message.setText(LocalisationService.getInstance().getString(text));
            }
            
            try {
                sendMessage(message);
            } catch (TelegramApiException ex) {
                Logger.getLogger(BotHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(update.hasInlineQuery()){
            InlineQuery inlineQuery = update.getInlineQuery();
            AnswerInlineQuery answer = new AnswerInlineQuery();
            answer.setInlineQueryId(inlineQuery.getId());
            answer.setCacheTime(100);
            
            if(inlineQuery.getQuery().isEmpty()){
                OnEmptyQuery eq = new OnEmptyQuery(pasta);
                answer.setResults(eq.getResult());
                try {
                    answerInlineQuery(answer);
                } catch (TelegramApiException ex) {
                    ex.toString();
                }
            }else{
                OnQuery query = new OnQuery(pasta,inlineQuery.getQuery());
                answer.setResults(query.getResult());
                answer.toString();
                try {
                    answerInlineQuery(answer);
                } catch (TelegramApiException ex) {
                    ex.toString();
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return BotConfig.BOT_USERNAME;
    }
    
}
