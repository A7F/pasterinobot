package keyboards;

import java.util.ArrayList;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

/**
 *
 * @author Luke
 */
public class MyKeyboard extends ReplyKeyboardMarkup{
    
    public MyKeyboard(){
        this.setResizeKeyboard(true);
        this.setSelective(Boolean.TRUE);
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow firstRow = new KeyboardRow();
            firstRow.add("help");
            firstRow.add("random");
        keyboard.add(firstRow);
        this.setKeyboard(keyboard);
    }
}
