package lessons.v8.oca.chapter1;

import java.util.Arrays;

public class Primitives {


    static class Primitive {
        int i;
        boolean bool;
        byte by;
        short sh;
        long l;
        float fl;
        double d;
        char ch;

        {
            System.out.println("Printing default values for primitives");
            Arrays.stream(this.getClass().getDeclaredFields())
              .map(f -> {
                  try {
                      return String.format("name=%s type = %s default value = %s",
                        f.getName(), f.getType(), f.get(this)
                      );


                  } catch (IllegalAccessException e) {
                      throw new RuntimeException(e);
                  }
              })
              .forEach(System.out::println);
        }

    }


    public static void main(String[] args) {
       var prim = new Primitive();
       prim.i = Integer.MAX_VALUE + 1;
       System.out.println(prim.i);
       prim.i = Integer.MIN_VALUE - 1;
        System.out.println(prim.i);
        prim.l = Integer.MAX_VALUE + 1L;
        System.out.println(prim.l);
        prim.bool = true;
        System.out.println(prim.bool);
        prim.by = Byte.MAX_VALUE;
        prim.by+=1;
        System.out.println(prim.by);
        prim.by = Byte.MIN_VALUE;
        prim.by-=1;
        System.out.println(prim.by);
        prim.l = Long.MAX_VALUE;
        System.out.println(prim.l);
        prim.sh = 01_0;//octal
        System.out.println(prim.sh);
        prim.fl = 0xF_F;//hex
        System.out.println(prim.fl);
        prim.by = 0b010101;//binary
        System.out.println(prim.by);
        prim.ch = 'a';
        System.out.println(prim.ch);
        prim.ch = 98;
        System.out.println(prim.ch);
        prim.ch = '\u0040';
        System.out.println(prim.ch);
        prim.d = 1_000_000.50;
        System.out.println(prim.d);

    }

}
