package Deffi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args){
        int number;
        int n = 3;
        int st = 0;
        int q;
        int a=0;
        int x1;
        int x2;
        int y1;
        int y2;
        List<Integer> numbers = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        number = random.nextInt(90000) + 10000;
        numbers.add(2);
        while (a==0) {
            for (int i = 0; i < numbers.size(); i++) {
                if (n % numbers.get(i) == 0) {
                    break;
                }
                if (numbers.get(i) >= Math.sqrt(n)) {
                    st++;
                    numbers.add(n);
                    break;
                }
            }
            if (st > number-1) {
                q = (n - 1) / 2;
                if (numbers.contains(q)) {
                    for (int i = 3; i < numbers.size(); i++) {
                        a = numbers.get(random.nextInt(number - 2));
                        if ((a ^ q) % numbers.get(st) != 1) {
                            break;
                        } else {
                            a = 0;
                        }
                    }
                }
            }
            n += 2;
        }
        System.out.println(a*numbers.get(st));

        System.out.println("Число P =  " + numbers.get(st));
        System.out.println("Число A =  " + a);
        System.out.println("Алиса придумала число X1(X1<" + numbers.get(st) + ") : ");
        x1 = in.nextInt();
        System.out.println("Боб придумал число X2(X2<" + numbers.get(st) + ") : ");
        x2 = in.nextInt();
        y1 = (a^x1)%numbers.get(st);
        y2 = (a^x2)%numbers.get(st);
        System.out.println("Алиса отправила Бобу свой открытый ключ - " + y1);
        System.out.println("Боб отправил Алисе свой открытый ключ - " + y2);
        System.out.println("Алиса сгенерировала закрытый ключ - " + (y2^x1)%numbers.get(st));
        System.out.println("Боб сгенерировал закрытый ключ - " + (y1^x2)%numbers.get(st));
        if((y2^x1)%numbers.get(st)==(y1^x2)%numbers.get(st)){
            System.out.println("Симметричный сенас шифрования установлен");
        }
        else{
            System.out.println("Ошибка");
        }
    }
}
