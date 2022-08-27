package work;

import java.io.*;

public class SimpleDotComGame {
    public static void main(String[] args) {
        simpleDotCom dc = new simpleDotCom();
        gameHelper helper = new gameHelper();
        int startPoint = (int) (Math.random() * 98);
        int[] place = {startPoint, startPoint + 1, startPoint + 2};
        dc.setPosition(place);
        System.out.println("*************Disapearence DotCom**************");
        System.out.println("let's use DDoS to attack DotCom that is a mess");
        System.out.println("!!! please input a number bettween 0 and 99 to locate the position of DotCom !!!");
        System.out.println("______________________________________________");

        boolean isAlive = true;
        int chance = 0;
        while(isAlive == true) {
            String answer = helper.getPlayerInput("Please input you guess");
            int guess = Integer.parseInt(answer);
            dc.checkSelf(guess);
            if(dc.times == dc.position.length){
                isAlive = false;
            }
            chance ++;
        }
        int score = 103 - chance;

        System.out.println("you get " + score + " points!(FULL GRADES: 100)");
    }
}

class simpleDotCom {
    int[] position;
    int times = 0;

    void setPosition(int[] position) {
        this.position = position;
    }

    public void checkSelf(int guessNum) {//make a metheod to check number
        boolean isContinue = true;
        for( int cell : position ){
            if (guessNum == cell){
                isContinue = false;
                times ++;
                if(times == position.length){
                    System.out.println("kill");
                }else{
                    System.out.println("hit");
                }
                System.out.println("______________________________________________");
                break;
            }
            }
        if(isContinue == true){
            System.out.println("miss");
            System.out.println("______________________________________________");
        }
        }
    }


class gameHelper{
    String getPlayerInput(String remind){
        String inputLine = null;
        System.out.println(remind + " ");
        try {
            BufferedReader is = new BufferedReader( new InputStreamReader(System.in));
            inputLine = is.readLine();
            if(inputLine.length() == 0) return null;
        } catch (IOException e){
            System.out.println("IOException: " + e );
        }
        return inputLine;
    }
}











