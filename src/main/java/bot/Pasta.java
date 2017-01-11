package bot;

import java.util.ArrayList;
import utils.LocalisationService;

/**
 * this class loads everything from properties file, this way the bot loads ascii strings just one time
 * @author Luke
 */
public class Pasta {
    private ArrayList<String> lenny = new ArrayList<>();
    private ArrayList<String> dongers = new ArrayList<>();
    private ArrayList<String> jelly = new ArrayList<>();
    private ArrayList<String> badass = new ArrayList<>();
    private ArrayList<String> copypasta = new ArrayList<>();
    private ArrayList<String> moreface = new ArrayList<>();
    private ArrayList<String> cuteface = new ArrayList<>();
    private ArrayList<String> llsmileys = new ArrayList<>();
    private ArrayList<String> tableflip = new ArrayList<>();
    private ArrayList<String> animals = new ArrayList<>();
    private ArrayList<String> finger = new ArrayList<>();
    private ArrayList<String> fwdangry = new ArrayList<>();
    private ArrayList<String> aranger = new ArrayList<>();
    private ArrayList<String> franger = new ArrayList<>();
    private ArrayList<String> miscsmileys = new ArrayList<>();
    private ArrayList<String> stuff = new ArrayList<>();
    
    private ArrayList<String> all = new ArrayList<>();
    private ArrayList<String> smileys = new ArrayList<>();
    private ArrayList<String> anger = new ArrayList<>();
    
    public Pasta(){
        populateDongers();
        populateLenny();
        populateJelly();
        populateBadass();
        populateCopypasta();
        populateMoreSmileys();
        populateCute();
        populateLongLine();
        populateTableFlip();
        populateAnimals();
        populateFinger();
        populateFwdAngry();
        populateArAnger();
        populateFrAnger();
        populateMisc();
        populateStuff();
        populateAll();
        populateSmileys();
        populateAnger();
        fixAll();
    }
    
    private void populateDongers(){
        for(int i=1;i<60;i++){
            dongers.add(LocalisationService.getInstance().getString(String.valueOf(i)));
        }
    }
    
    public void populateLenny(){
        for(int i=288;i<307;i++){
            lenny.add(LocalisationService.getInstance().getString(String.valueOf(i)));
        }
    }
    
    public void populateJelly(){
        for(int i=61;i<95;i++){
            jelly.add(LocalisationService.getInstance().getString(String.valueOf(i)));
        }
    }
    
    public void populateBadass(){
        for(int i=95;i<99;i++){
            badass.add(LocalisationService.getInstance().getString(String.valueOf(i)));
        }
    }
    
    public void populateCopypasta(){
        for(int i=99;i<126;i++){
            copypasta.add(LocalisationService.getInstance().getString(String.valueOf(i)));
        }
    }
    
    public void populateMoreSmileys(){
        for(int i=126;i<145;i++){
            moreface.add(LocalisationService.getInstance().getString(String.valueOf(i)));
        }
        for(int i=161;i<206;i++){
            moreface.add(LocalisationService.getInstance().getString(String.valueOf(i)));
        }
    }
    
    public void populateCute(){
        for(int i=145;i<161;i++){
            cuteface.add(LocalisationService.getInstance().getString(String.valueOf(i)));
        }
    }
    
    public void populateLongLine(){
        for(int i=206;i<217;i++){
            llsmileys.add(LocalisationService.getInstance().getString(String.valueOf(i)));
        }
    }
    
    public void populateTableFlip(){
        for(int i=217;i<224;i++){
            tableflip.add(LocalisationService.getInstance().getString(String.valueOf(i)));
        }
    }
    
    public void populateAnimals(){
        for(int i=224;i<235;i++){
            animals.add(LocalisationService.getInstance().getString(String.valueOf(i)));
        }
    }
    
    public void populateFinger(){
        for(int i=236;i<241;i++){
            finger.add(LocalisationService.getInstance().getString(String.valueOf(i)));
        }
    }
    
    public void populateFwdAngry(){
        for(int i=241;i<255;i++){
            fwdangry.add(LocalisationService.getInstance().getString(String.valueOf(i)));
        }
    }
    
    public void populateArAnger(){
        for(int i=255;i<261;i++){
            aranger.add(LocalisationService.getInstance().getString(String.valueOf(i)));
        }
    }
    
    public void populateFrAnger(){
        for(int i=261;i<268;i++){
            franger.add(LocalisationService.getInstance().getString(String.valueOf(i)));
        }
    }
    
    public void populateMisc(){
        for(int i=268;i<276;i++){
            miscsmileys.add(LocalisationService.getInstance().getString(String.valueOf(i)));
        }
    }
    
    public void populateStuff(){
        for(int i=276;i<288;i++){
            stuff.add(LocalisationService.getInstance().getString(String.valueOf(i)));
        }
    }
    
    public void populateAll(){
        for(int i=1;i<307;i++){
            all.add(LocalisationService.getInstance().getString(String.valueOf(i)));
        }
    }
    
    public void populateSmileys(){
        smileys.addAll(lenny);
        smileys.addAll(cuteface);
        smileys.addAll(moreface);
        smileys.addAll(miscsmileys);
    }
    
    public void populateAnger(){
        anger.addAll(finger);
        anger.addAll(tableflip);
        anger.addAll(fwdangry);
        anger.addAll(aranger);
        anger.addAll(franger);
    }

    public ArrayList<String> getLenny() {
        return lenny;
    }

    public ArrayList<String> getDongers() {
        return dongers;
    }

    public ArrayList<String> getJelly() {
        return jelly;
    }

    public ArrayList<String> getBadass() {
        return badass;
    }

    public ArrayList<String> getCopypasta() {
        return copypasta;
    }

    public ArrayList<String> getMoreface() {
        return moreface;
    }

    public ArrayList<String> getCuteface() {
        return cuteface;
    }

    public ArrayList<String> getLlsmileys() {
        return llsmileys;
    }

    public ArrayList<String> getTableflip() {
        return tableflip;
    }

    public ArrayList<String> getAnimals() {
        return animals;
    }

    public ArrayList<String> getFinger() {
        return finger;
    }

    public ArrayList<String> getFwdangry() {
        return fwdangry;
    }

    public ArrayList<String> getAranger() {
        return aranger;
    }

    public ArrayList<String> getFranger() {
        return franger;
    }

    public ArrayList<String> getMiscsmileys() {
        return miscsmileys;
    }

    public ArrayList<String> getStuff() {
        return stuff;
    }

    public ArrayList<String> getAll() {
        return all;
    }

    public ArrayList<String> getSmileys() {
        return smileys;
    }

    public ArrayList<String> getAnger() {
        return anger;
    }

    private void fixAll(){
        
    }
    
}
