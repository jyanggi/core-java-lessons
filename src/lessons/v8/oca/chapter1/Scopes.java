package lessons.v8.oca.chapter1;

public class Scopes {

    static int classInt;

    public static void main(String[] args) {
        int classInt = 1;
        System.out.println(classInt);
        int methodInt = 2;
        System.out.println(Scopes.classInt);
        {
            System.out.println(methodInt);
            int blockedInt = 1;
            System.out.println(blockedInt);
        }
//not visible    System.out.println(blockedInt);


    }

}
