package contest01.Test;

import java.util.Objects;

/**
 * @Author: ZhanLiao
 * @Description: 测试重写
 * @Date: 2021/6/19 11:08
 * @Version: 1.0
 */
public class Main extends A{


    public static void main(String[] args) {

        /*int a = 10;
        long b = 10L;
        double c = 10.0;
        System.out.println(a==c);
        System.out.println(a==b);
        System.out.println(Objects.equals(a, b));*/
        char ch = '3';
        int chInt = ch;
        System.out.println(ch);
        System.out.println(chInt);
    }
}

class A{
    private final void getName(){

    }
}

