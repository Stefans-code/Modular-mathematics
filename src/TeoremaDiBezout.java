import java.math.BigInteger;
import java.util.Scanner;

public class TeoremaDiBezout {
    private Integer a;
    private Integer b;
    private Integer c;
    private Integer[] r;
    private Integer[] q;
    public boolean change;
    private Integer[] soluzioneFinale;

    public TeoremaDiBezout(Integer a, Integer b, Integer c){
        this.a = a;
        this.b = b;
        this.c = c;
        r = new Integer[25];
        q = new Integer[25];
        if(a >= b) {
            r[0] = a;
            r[1] = b;
            change = false;
        }else{
            r[1] = a;
            r[0] = b;
            change = true;
        }
        soluzioneFinale = new Integer[2];
    }

    public Integer[] algoritmoDiBezout(){
        Integer[] soluzionex = new Integer[200];
        Integer[] soluzioney = new Integer[200];

        BigInteger bigA = BigInteger.valueOf(a);
        BigInteger bigB = BigInteger.valueOf(b);
        BigInteger bigC = BigInteger.valueOf(c);
        BigInteger mcd = bigA.gcd(bigB);

        if(c%r[1] == 0){
            if(change) {
                soluzioneFinale[1] = 0;
                soluzioneFinale[0] = c / r[1];
            }else{
                soluzioneFinale[0] = 0;
                soluzioneFinale[1] = c / r[1];
            }

        }else if(!bigC.mod(mcd).equals(BigInteger.ZERO)){
            return soluzioneFinale = null;
        }else{
            if(a >= b) {
                soluzionex[1] = 0;
                soluzioney[1] = 1;
            }else{
                soluzionex[1] = 1;
                soluzioney[1] = 0;
            }

            int j = 2;
            while(r[j - 1] != 0){
                r[j] = r[j-2] % r[j-1];
                q[j] = r[j-2] / r[j-1];

                if(j-1 == 1){
                    if(a >= b) {
                        soluzionex[j] = 1;
                        soluzioney[j] = 0 - q[j];
                    }else{
                        soluzionex[j] = 0 - q[j];
                        soluzioney[j] = 1;
                    }

                }else{
                    soluzionex[j] = soluzionex[j-2] - q[j] * soluzionex[j-1];
                    soluzioney[j] = soluzioney[j-2] - q[j] * soluzioney[j-1];
                }
                j++;
            }
            soluzioneFinale[0] = soluzionex[j-2];
            soluzioneFinale[1] = soluzioney[j-2];

            if(c/r[j-2] > 1){
                soluzioneFinale[0] *= c / r[j - 2];
                soluzioneFinale[1] *= c / r[j - 2];
            }
        }

        if(soluzioneFinale[0] > 0 && soluzioneFinale[0] < b) {
            return soluzioneFinale;
        }else{
            if(Math.abs(soluzioneFinale[0]) < b && soluzioneFinale[0] < 0){
                soluzioneFinale[0] += b;
                return soluzioneFinale;
            }else if(Math.abs(soluzioneFinale[0]) > b && soluzioneFinale[0] < 0){
                soluzioneFinale[0] = b - (Math.abs(soluzioneFinale[0]) % b);
                return soluzioneFinale;
            }
            soluzioneFinale[0] =  soluzioneFinale[0] % b;
            return soluzioneFinale;
        }
    }
}