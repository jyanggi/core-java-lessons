package lessons.v8.ocp.chapter6;

public class AssertExample {

    @SuppressWarnings("all")
    public static void main(String[] args) {

        assert (100000 == 100_000.00) : "100000 == 100_000.00";
        assert (4.64
                - 2.0 == 2.6399999999999997) : "4.64 - 2.0 == 2.6399999999999997";
        assert 'A' == 65 : "'A' == 65";
        assert 'Z' == 90 : "'Z' == 90";
        assert "String" == "String" : "\"String\"==\"String\"";
        assert (2 == 1.0) : "2 == 1.0";

    }

}
