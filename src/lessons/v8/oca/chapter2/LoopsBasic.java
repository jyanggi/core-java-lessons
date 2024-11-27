package lessons.v8.oca.chapter2;

public class LoopsBasic {



    public static void main(String [] args){

        int i = 5;

        while(i>0){
            System.out.println(String.format("%d > 0",i--));
        }

        do{
            System.out.println(String.format("do once before condition %d!=0",i));
        }while(i!=0);


        int j = 0;
        for(;;){
            System.out.println(String.format("Infinite for loop with j=%d",j));
            if(j++>=3){
                break;
            }
        }

        int x = 0;
        for(long y = 0, z = 4; x < 5 && y < 10; x++, y++) {
            System.out.println(String.format("y=%d, x=%d, z=%d",y,x,z));
        }

        for(int b = 0b0000;b < 010;b+=0b1){
            System.out.print(b + " ");
        }
        final String[] names = new String[3];
        names[0] = "Lisa";
        names[1] = "Kevin";
        names[2] = "Roger";
        for(String name : names) {
            System.out.print(name + ", ");
        }

        System.out.println();

        int[][] myComplexArray = {{5,2,1,3},{3,9,8,9},{5,7,12,7}};
        for(int[] mySimpleArray : myComplexArray) {
            for(i=0; i<mySimpleArray.length; i++) {
                System.out.print(mySimpleArray[i]+"\t");
            }
            System.out.println();
        }
    }
}
