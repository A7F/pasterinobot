package bot;

import java.util.ArrayList;
import java.util.List;
import org.telegram.telegrambots.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.api.objects.inlinequery.result.InlineQueryResult;
import org.telegram.telegrambots.api.objects.inlinequery.result.InlineQueryResultArticle;

public class OnEmptyQuery {
    List<InlineQueryResult> ilr = new ArrayList<>();
    
    Pasta pasta;
    
    public OnEmptyQuery(Pasta pasta){
        this.pasta = pasta;
    }
    
    public List<InlineQueryResult> getResult(){
        ArrayList<String> selected = pasta.getSmileys();
        
        for(int i=0; i<50;i++){
            InlineQueryResultArticle r = new InlineQueryResultArticle();
            InputTextMessageContent messageContent = new InputTextMessageContent();
            messageContent.disableWebPagePreview();
            messageContent.enableMarkdown(false);
            r.setDescription(pasta.getSmileys().get(i));
            r.setId(String.valueOf(i+1));
            r.setTitle(String.valueOf(i+1));
            messageContent.setMessageText(pasta.getSmileys().get(i));
            r.setInputMessageContent(messageContent);
            ilr.add(r);
        }
        
        return ilr;
    }
}
