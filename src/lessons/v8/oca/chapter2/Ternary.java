package lessons.v8.oca.chapter2;

public class Ternary {


    public static void main(String [] args){
        int y = 1;
        int z = 1;
        final int x = y<10 ? y++ : z++;
        System.out.println(x+ ","+y+","+z); // Outputs 1,2,1
    }
}
