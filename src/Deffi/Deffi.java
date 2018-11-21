package Deffi;

import java.math.BigInteger;
import java.util.Random;
public class Deffi {

    private BigInteger y1, y2, x1, z1;
    private BigInteger p, a;
    public Deffi(BigInteger p, BigInteger a) {
        this.p = p;
        this.a = a;
        x1 = new BigInteger(32, new Random());
        while(x1.longValue()>p.longValue()){
            x1 = new BigInteger(32, new Random());
        }
        y1 = this.a.modPow(x1, this.p);
    }

    public void setZ1(BigInteger y2) {
        this.y2 = y2;
        z1 = this.y2.modPow(x1, p);
    }

    public BigInteger getX1() {
        return x1;
    }
    public BigInteger getY1() {
        return y1;
    }
    public BigInteger getZ1() {
        return z1;
    }

}
