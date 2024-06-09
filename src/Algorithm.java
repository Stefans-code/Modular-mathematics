public class Algorithm {

    // Funzione per calcolare il GCD di due numeri
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Funzione per calcorare il modulo inverso di 'a' modulo 'm'
    public static int modInverso(int a, int m) {
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        return -1; // Se è inverso è inesistente
    }

    // Funzione per calcolare la phi di Eulero
    public static int eulerPhi(int p, int q) {
        return (p - 1) * (q - 1);
    }

    // Funzione per calcolare d usando la phi di eulero e 'e'
    public static int calcolarePrivateKey(int p, int q, int e) {
        int phi = eulerPhi(p, q);
        int d = modInverso(e, phi);
        return d;
    }





}
