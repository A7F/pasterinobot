package bot;

import java.util.ArrayList;
import java.util.List;
import static org.apache.commons.lang3.StringUtils.isNumeric;
import org.telegram.telegrambots.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.api.objects.inlinequery.result.InlineQueryResult;
import org.telegram.telegrambots.api.objects.inlinequery.result.InlineQueryResultArticle;

public class OnQuery {
    List<InlineQueryResult> ilr = new ArrayList<>();
    String query;
    Pasta pasta;
    private static final int MAX=40;
    private int CAP;
    OnQueryCat qcat;
    
    public OnQuery(Pasta pasta,String query){
        this.pasta = pasta;
        this.query=query;
        this.qcat=new OnQueryCat(pasta,query);
        CAP=pasta.getAll().size();
    }
    
    public List<InlineQueryResult> getResult(){
        int pagenumber;
        
        if(isNumeric(query)){
            pagenumber = Integer.valueOf(query);
            setResponseByPage(pagenumber);
        }else{
            ilr=qcat.getResult();
        }
        
        return ilr;
    }

    private void setResponseByPage(int pagenumber){
        switch(pagenumber){
            case 1:
                insertResults(0,MAX*1); //0-50
                break;
            case 2:
                insertResults(MAX,MAX*2);   //50-100
                break;
            case 3:
                insertResults(MAX*2,MAX*3); //100-150
                break;
            case 4:
                insertResults(MAX*3,MAX*4); //150-200
                break;
            case 5:
                insertResults(MAX*5,MAX*6); //200-250
                break;
            case 6:
                insertResults(MAX*6,MAX*7);
                break;
            case 7:
                insertResults(MAX*7,CAP);
                break;
            default:
                insertResults(0,MAX*1);
        }
    }

    private void insertResults(int min, int max) {
        for(int i=min; i<max && i<pasta.getAll().size();i++){
            InlineQueryResultArticle r = new InlineQueryResultArticle();
            InputTextMessageContent messageContent = new InputTextMessageContent();
            messageContent.disableWebPagePreview();
            messageContent.enableMarkdown(false);
            if(!(pasta.getAll().get(i).equals("") || pasta.getAll().get(i).equals(" "))){
                r.setDescription(pasta.getAll().get(i));
                r.setId(String.valueOf(i+1));
                r.setTitle(String.valueOf(i+1));
                messageContent.setMessageText(pasta.getAll().get(i));
                r.setInputMessageContent(messageContent);
                ilr.add(r);
            }
        }
    }
}
