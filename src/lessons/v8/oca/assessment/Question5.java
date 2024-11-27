package lessons.v8.oca.assessment;
import static java.lang.System.out;
public class Question5 {

    static class Deer{
        Deer(){
            out.print("Deer");
        }

        Deer(int age){
            out.print("DeerAge");
        }

        private boolean hasHorns(){
            return false;
        }
    }

    static class Reindeer extends  Deer{
        Reindeer(int age){
            out.print("Reindeer");
        }

        public boolean hasHorns(){
            return true;
        }
    }
    /**
     * What is the output
     */
    public static void main(String[] args) {
       Deer d = new Reindeer(3);
       out.print(","+ d.hasHorns());
    }


}
