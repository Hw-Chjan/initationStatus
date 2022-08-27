package work;
import java.io.*;

public class CompareNumber {
    public static void main(String[] args) {
        CompareCalc calc = new CompareCalc();
        InputGetter getr = new InputGetter();
        boolean isContinue = true;
        int x = 0;
        while(isContinue){
            String command = getr.getInput("please input a number or o/i if you want to check the sequence:");
            if(command.equals("o") || command.equals("i") || command.equals("e")){
                if(command.equals("o")){
                    for(int i = 0; i < x; i++){
                        System.out.print(calc.seq[i] + " "); 
                    }
                    System.out.println("||");
                }
                if(command.equals("i")){
                    for(int i = x - 1; i > -1; i--){
                        System.out.print(calc.seq[i] + " "); 
                    }
                    System.out.println("||");
                }
                if(command.equals("e")){
                    isContinue = false;
                }
                System.out.println("———————————————————————————————————————————————————————————————");
            }else{
                int currentNum = Integer.parseInt(command);
                calc.compare(currentNum, x);
                System.out.println("THIS IS THE " + (x+1) + "th NUMBER!");
                System.out.println("———————————————————————————————————————————————————————————————");
                x++;
            }
        }     
    }
}

class CompareCalc{
    int[] seq = new int[100];

    void compare(int num, int x){
       int temp;
       if(x == 0){
        seq[0] = num;
       }else{
        for(int i = 0; i < x; i++){
            int before = x - (i+1);
            if(num < seq[before]){
                temp = seq[before];
                seq[before] = num;
                seq[x - i] = temp;
            }else{
                seq[x - i] = num;
                break;
            }
        }
       }
    }
}

class InputGetter{
    String getInput(String topic){
        String input = null;
        System.out.println(topic + " ");
        try{
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            input = is.readLine();
            if(input.length() == 0){
                return null;
            }
        }catch (IOException e){
            System.out.println("WRONG IOExpection:" + e);
        }
        return input;
    }
}