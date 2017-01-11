package bot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.telegram.telegrambots.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.api.objects.inlinequery.result.InlineQueryResult;
import org.telegram.telegrambots.api.objects.inlinequery.result.InlineQueryResultArticle;

public class OnQueryCat {
    List<InlineQueryResult> ilr = new ArrayList<>();
    List<String> random;
    String query;
    Pasta pasta;
    private static final int MAX=30;
    private int CAP;
    
    public OnQueryCat(Pasta pasta,String query){
        this.pasta = pasta;
        this.query=query;
    }
    
    public List<InlineQueryResult> getResult(){
        int pagenumber=0;
        
        if(query.contains("smile")){
            CAP=pasta.getSmileys().size();
            Pattern p = Pattern.compile("[0-9]+");
            Matcher m = p.matcher(query);
            while (m.find()){
                int n = Integer.parseInt(m.group());
                pagenumber=n;
                break;
            }
            setResponseByPage(pagenumber,Categories.SMILE);
        }else if(query.contains("copy")){
            CAP=pasta.getCopypasta().size();
            Pattern p = Pattern.compile("[0-9]+");
            Matcher m = p.matcher(query);
            while (m.find()){
                int n = Integer.parseInt(m.group());
                pagenumber=n;
                break;
            }
            setResponseByPage(pagenumber,Categories.COPYPASTA);
        }else if(query.contains("dong")){
            CAP=pasta.getCopypasta().size();
            Pattern p = Pattern.compile("[0-9]+");
            Matcher m = p.matcher(query);
            while (m.find()){
                int n = Integer.parseInt(m.group());
                pagenumber=n;
                break;
            }
            setResponseByPage(pagenumber,Categories.DONGERS);
        }else if(query.contains("jel")){
            CAP=pasta.getJelly().size();
            Pattern p = Pattern.compile("[0-9]+");
            Matcher m = p.matcher(query);
            while (m.find()){
                int n = Integer.parseInt(m.group());
                pagenumber=n;
                break;
            }
            setResponseByPage(pagenumber,Categories.JELLY);
        }else if(query.contains("rage")){
            CAP=pasta.getCopypasta().size();
            Pattern p = Pattern.compile("[0-9]+");
            Matcher m = p.matcher(query);
            while (m.find()){
                int n = Integer.parseInt(m.group());
                pagenumber=n;
                break;
            }
            setResponseByPage(pagenumber,Categories.RAGE);
        }else if(query.contains("flip")){
            CAP=pasta.getCopypasta().size();
            Pattern p = Pattern.compile("[0-9]+");
            Matcher m = p.matcher(query);
            while (m.find()){
                int n = Integer.parseInt(m.group());
                pagenumber=n;
                break;
            }
            setResponseByPage(pagenumber,Categories.FLIP);
        }
        else if(query.contains("len")){
            CAP=pasta.getCopypasta().size();
            Pattern p = Pattern.compile("[0-9]+");
            Matcher m = p.matcher(query);
            while (m.find()){
                int n = Integer.parseInt(m.group());
                pagenumber=n;
                break;
            }
            setResponseByPage(pagenumber,Categories.LENNY);
        }
        else if(query.contains("animal")){
            CAP=pasta.getCopypasta().size();
            Pattern p = Pattern.compile("[0-9]+");
            Matcher m = p.matcher(query);
            while (m.find()){
                int n = Integer.parseInt(m.group());
                pagenumber=n;
                break;
            }
            setResponseByPage(pagenumber,Categories.ANIMAL);
        }else if(query.contains("stuff")){
            CAP=pasta.getCopypasta().size();
            Pattern p = Pattern.compile("[0-9]+");
            Matcher m = p.matcher(query);
            while (m.find()){
                int n = Integer.parseInt(m.group());
                pagenumber=n;
                break;
            }
            setResponseByPage(pagenumber,Categories.STUFF);
        }else{
            random=pasta.getAll();
            Collections.shuffle(random);
            setResponseByPage(0,Categories.RANDOM);
        }
        return ilr;
    }

    private void setResponseByPage(int pagenumber,Categories cat){
        switch(pagenumber){
            case 1:
                insertResults(0,MAX*1,cat); //0-50
                break;
            case 2:
                insertResults(MAX,MAX*2,cat);   //50-100
                break;
            case 3:
                insertResults(MAX*2,MAX*3,cat); //100-150
                break;
            case 4:
                insertResults(MAX*3,MAX*4,cat); //150-200
                break;
            case 5:
                insertResults(MAX*4,MAX*5,cat); //150-200
                break;
            default:
                insertResults(0,MAX*1,cat);
        }
    }

    private void insertResults(int min, int max, Categories cat) {
        switch(cat){
            case SMILE:
                for (int i = min; i < max && i < pasta.getSmileys().size(); i++) {
                    InlineQueryResultArticle r = new InlineQueryResultArticle();
                    InputTextMessageContent messageContent = new InputTextMessageContent();
                    messageContent.disableWebPagePreview();
                    messageContent.enableMarkdown(false);
                    if (!(pasta.getSmileys().get(i).equals("") || pasta.getSmileys().get(i).equals(" "))) {
                        r.setDescription(pasta.getSmileys().get(i));
                        r.setId(String.valueOf(i + 1));
                        r.setTitle(String.valueOf(i + 1));
                        messageContent.setMessageText(pasta.getSmileys().get(i));
                        r.setInputMessageContent(messageContent);
                        ilr.add(r);
                    }
                }
            break;
            case COPYPASTA:
                for (int i = min; i < max && i < pasta.getCopypasta().size(); i++) {
                    InlineQueryResultArticle r = new InlineQueryResultArticle();
                    InputTextMessageContent messageContent = new InputTextMessageContent();
                    messageContent.disableWebPagePreview();
                    messageContent.enableMarkdown(false);
                    if (!(pasta.getCopypasta().get(i).equals("") || pasta.getCopypasta().get(i).equals(" "))) {
                        r.setDescription(pasta.getCopypasta().get(i));
                        r.setId(String.valueOf(i + 1));
                        r.setTitle(String.valueOf(i + 1));
                        messageContent.setMessageText(pasta.getCopypasta().get(i));
                        r.setInputMessageContent(messageContent);
                        ilr.add(r);
                    }
                }
            break;
                case JELLY:
                for (int i = min; i < max && i < pasta.getJelly().size(); i++) {
                    InlineQueryResultArticle r = new InlineQueryResultArticle();
                    InputTextMessageContent messageContent = new InputTextMessageContent();
                    messageContent.disableWebPagePreview();
                    messageContent.enableMarkdown(false);
                    if (!(pasta.getJelly().get(i).equals("") || pasta.getJelly().get(i).equals(" "))) {
                        r.setDescription(pasta.getJelly().get(i));
                        r.setId(String.valueOf(i + 1));
                        r.setTitle(String.valueOf(i + 1));
                        messageContent.setMessageText(pasta.getJelly().get(i));
                        r.setInputMessageContent(messageContent);
                        ilr.add(r);
                    }
                }
            break;
            case DONGERS:
                for (int i = min; i < max && i < pasta.getDongers().size(); i++) {
                    InlineQueryResultArticle r = new InlineQueryResultArticle();
                    InputTextMessageContent messageContent = new InputTextMessageContent();
                    messageContent.disableWebPagePreview();
                    messageContent.enableMarkdown(false);
                    if (!(pasta.getDongers().get(i).equals("") || pasta.getDongers().get(i).equals(" "))) {
                        r.setDescription(pasta.getDongers().get(i));
                        r.setId(String.valueOf(i + 1));
                        r.setTitle(String.valueOf(i + 1));
                        messageContent.setMessageText(pasta.getDongers().get(i));
                        r.setInputMessageContent(messageContent);
                        ilr.add(r);
                    }
                }
            break;
            case LENNY:
                for (int i = min; i < max && i < pasta.getLenny().size(); i++) {
                    InlineQueryResultArticle r = new InlineQueryResultArticle();
                    InputTextMessageContent messageContent = new InputTextMessageContent();
                    messageContent.disableWebPagePreview();
                    messageContent.enableMarkdown(false);
                    if (!(pasta.getLenny().get(i).equals("") || pasta.getLenny().get(i).equals(" "))) {
                        r.setDescription(pasta.getLenny().get(i));
                        r.setId(String.valueOf(i + 1));
                        r.setTitle(String.valueOf(i + 1));
                        messageContent.setMessageText(pasta.getLenny().get(i));
                        r.setInputMessageContent(messageContent);
                        ilr.add(r);
                    }
                }
            break;
            case RAGE:
                for (int i = min; i < max && i < pasta.getAnger().size(); i++) {
                    InlineQueryResultArticle r = new InlineQueryResultArticle();
                    InputTextMessageContent messageContent = new InputTextMessageContent();
                    messageContent.disableWebPagePreview();
                    messageContent.enableMarkdown(false);
                    if (!(pasta.getAnger().get(i).equals("") || pasta.getAnger().get(i).equals(" "))) {
                        r.setDescription(pasta.getAnger().get(i));
                        r.setId(String.valueOf(i + 1));
                        r.setTitle(String.valueOf(i + 1));
                        messageContent.setMessageText(pasta.getAnger().get(i));
                        r.setInputMessageContent(messageContent);
                        ilr.add(r);
                    }
                }
            break;
            case FLIP:
                for (int i = min; i < max && i < pasta.getTableflip().size(); i++) {
                    InlineQueryResultArticle r = new InlineQueryResultArticle();
                    InputTextMessageContent messageContent = new InputTextMessageContent();
                    messageContent.disableWebPagePreview();
                    messageContent.enableMarkdown(false);
                    if (!(pasta.getTableflip().get(i).equals("") || pasta.getTableflip().get(i).equals(" "))) {
                        r.setDescription(pasta.getTableflip().get(i));
                        r.setId(String.valueOf(i + 1));
                        r.setTitle(String.valueOf(i + 1));
                        messageContent.setMessageText(pasta.getTableflip().get(i));
                        r.setInputMessageContent(messageContent);
                        ilr.add(r);
                    }
                }
            break;
            case ANIMAL:
                for (int i = min; i < max && i < pasta.getAnimals().size(); i++) {
                    InlineQueryResultArticle r = new InlineQueryResultArticle();
                    InputTextMessageContent messageContent = new InputTextMessageContent();
                    messageContent.disableWebPagePreview();
                    messageContent.enableMarkdown(false);
                    if (!(pasta.getAnimals().get(i).equals("") || pasta.getAnimals().get(i).equals(" "))) {
                        r.setDescription(pasta.getAnimals().get(i));
                        r.setId(String.valueOf(i + 1));
                        r.setTitle(String.valueOf(i + 1));
                        messageContent.setMessageText(pasta.getAnimals().get(i));
                        r.setInputMessageContent(messageContent);
                        ilr.add(r);
                    }
                }
            break;
            case STUFF:
                for (int i = min; i < max && i < pasta.getStuff().size(); i++) {
                    InlineQueryResultArticle r = new InlineQueryResultArticle();
                    InputTextMessageContent messageContent = new InputTextMessageContent();
                    messageContent.disableWebPagePreview();
                    messageContent.enableMarkdown(false);
                    if (!(pasta.getStuff().get(i).equals("") || pasta.getStuff().get(i).equals(" "))) {
                        r.setDescription(pasta.getStuff().get(i));
                        r.setId(String.valueOf(i + 1));
                        r.setTitle(String.valueOf(i + 1));
                        messageContent.setMessageText(pasta.getStuff().get(i));
                        r.setInputMessageContent(messageContent);
                        ilr.add(r);
                    }
                }
            break;
            default:
                for (int i = min; i < max && i < random.size(); i++) {
                    InlineQueryResultArticle r = new InlineQueryResultArticle();
                    InputTextMessageContent messageContent = new InputTextMessageContent();
                    messageContent.disableWebPagePreview();
                    messageContent.enableMarkdown(false);
                    if (!(random.get(i).equals("") || random.get(i).equals(" "))) {
                        r.setDescription(random.get(i));
                        r.setId(String.valueOf(i + 1));
                        r.setTitle(String.valueOf(i + 1));
                        messageContent.setMessageText(random.get(i));
                        r.setInputMessageContent(messageContent);
                        ilr.add(r);
                    }
                }
            break;
        }
    }
}
