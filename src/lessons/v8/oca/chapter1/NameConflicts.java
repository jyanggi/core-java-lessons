package lessons.v8.oca.chapter1;

import java.time.Instant;
//wild chard named conflicts

//Adding this fixes the name conflict, which one is explicitly imported will be used.
import java.util.Date;
// uncommenting this will cause the same issue as wild chard import java.sql.Date;


public class NameConflicts {



    public static void main(String...args){
 //ambiguouse name conflict if no specific import and named conflict
        new Date();
      //alternatively add fully qualified name
      java.sql.Date.from(Instant.now());
    }
}
