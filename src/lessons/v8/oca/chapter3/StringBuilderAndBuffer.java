package lessons.v8.oca.chapter3;

public class StringBuilderAndBuffer {

public static void main(String [] args){
    StringBuilder alpha = new StringBuilder();
    for(char current = 'a'; current <= 'z'; current++)
     alpha.append(current);
    System.out.println(alpha);
    alpha.append("ASD");
}

}
