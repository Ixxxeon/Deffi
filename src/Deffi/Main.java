package Deffi;

import java.math.BigInteger;
import java.util.Random;

public class Main {
    private static BigInteger p;
    private static BigInteger a;
    public static void main(String[] args) {
        p = BigInteger.probablePrime(48, new Random());
        a = BigInteger.probablePrime(48, new Random());
        while(p.longValue()<a.longValue()){
            a = BigInteger.probablePrime(48, new Random());
        }
        Deffi client = new Deffi(p, a);
        Deffi server = new Deffi(p, a);
        client.setZ1(server.getY1());
        server.setZ1(client.getY1());
        System.out.println("p - " + p);
        System.out.println("a - " + a);
        System.out.println("Клиент получил - " + client.getZ1());
        System.out.println("Клиент получил  X1 - " + client.getX1());
        System.out.println("Сервер получил - " + server.getZ1());
        System.out.println("Сервер получил  X2 - " + server.getX1());
    }

}
