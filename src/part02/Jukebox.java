package part02;
import part01.Genre;
import part01.MP3Player;
import part01.Tune;

import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Jukebox extends MP3Player{
    private int credits, costPerCredit;
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCostPerCredit() {
        return costPerCredit;
    }

    public void setCostPerCredit(int costPerCredit) {
        this.costPerCredit = costPerCredit;
    }

    public Jukebox(){
        credits = 0; costPerCredit=0;
    }
    public String insertCoin(int amount){
        int[] allowedAmounts = {10,20,50,100,200};
        if(contains(allowedAmounts,amount)){
            if(costPerCredit>0){
                credits+=Math.ceil(amount/costPerCredit);
                return "Credit Updated!";
            }
            else{
                return "Free to play a tune!";
            }
        }
        return "Invalid coin value!";
    }
    public static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }

    public  String play(int tuneId){
        if(credits>0 || !(costPerCredit>0)){
            if(costPerCredit>0){
                credits-=1;
            }
            for (Tune tune : soundData) {
                if (tune.getSongId()==(tuneId)){
                    int plays = tune.getPlayCount();
                    tune.setPlayCount(++plays);
                    return tune.toString();
                }
            }
            return null;
        }else{
            return "Not enough credits to play the tune!";
        }
    }

    public boolean switchOff(){
        if(soundData==null){
            return false;
        }
        else{

            File file = new File("state.csv");
            try {
                file.createNewFile();
                FileWriter myWriter = new FileWriter("state.csv");
                myWriter.write("credits,costPerCredit\n");
                myWriter.write(credits+","+costPerCredit+"\n");
                for(Tune tune: soundData){
                    myWriter.write(tune+"\n");
                }
                myWriter.close();
                soundData=null;
                return true;
            }catch (IOException e){
                e.printStackTrace();
                return false;
            }
        }


    }
    public boolean switchOn() throws FileNotFoundException {
        if (soundData==null){
            new MP3Player();
            soundData = new ArrayList<Tune>();
            File myObj = new File("state.csv");
            Scanner myReader = new Scanner(myObj);
            int counter=0;
            String[] temp = null;
            int tuneCounter=0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(counter==1){
                    credits = Integer.parseInt(data.split(",")[0]);
                    costPerCredit = Integer.parseInt(data.split(",")[1]);
                }else if(counter>1){
                    temp = data.split(", ");
                    Genre currentGenre=null;
                    for(Genre g: Genre.values()){
                        if (g.toString().equals(temp[5])){
                            currentGenre=g;
                        }
                    }
                    addTune(temp[1], temp[2],Integer.parseInt(temp[3]), currentGenre);
                    soundData.get(tuneCounter).setPlayCount(Integer.parseInt(temp[4]));
                    tuneCounter++;
                }
                counter++;
            }
            myReader.close();
            return true;
        }
        return false;
    }


}
