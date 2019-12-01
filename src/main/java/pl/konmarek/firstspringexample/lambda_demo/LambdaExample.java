package pl.konmarek.firstspringexample.lambda_demo;

interface MyLambda{
    String haha(int a, String b, float c);
    default String haha2(int a, String b, float c){
        return "";
    }
}

public class LambdaExample {
    public static void main(String[] args) {
        MyLambda myLambda = (d, e, f) ->e;

        myLambda.haha(1, "string", 2.0f);
    }
}
