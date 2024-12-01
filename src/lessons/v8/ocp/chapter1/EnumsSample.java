package lessons.v8.ocp.chapter1;

public class EnumsSample {


    enum Season{
        WINTER("Cold"){

         public void printAnother(){
             System.out.println("Print another");
         }
         @Override
         void printTemp(){
             printAnother();
             System.out.println(temp);
         }

        },
        SPRING("Warm"),
        SUMMER("Hot"),
        FALL("Cool");

        Season(String temp){
            this.temp = temp;
        }

        String temp;
        void printTemp(){
            System.out.println(temp);
        }
    }




    public static final void main(String[]args){

        for(Season s: Season.values()){
            s.printTemp();
        }

    }
}
