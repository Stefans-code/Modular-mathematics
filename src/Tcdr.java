public class Tcdr {

    // Metodo che calcola il teorema cinese del resto
    public static String[] CalcoloTeoremaCinesedelResto(int[] a, int[] nI) {
        // Verifica se i moduli sono coprimi tra loro
        if (!checkCoprimi(nI)) {
            return new String[]{"Errore: I moduli non sono coprimi tra loro."};
        }

        // Array per memorizzare i valori di ci e di
        int[] cI = new int[nI.length];
        int[] dI = new int[nI.length];

        // Calcola il prodotto di tutti i moduli (n)
        int n = 1;
        for (int i = 0; i < nI.length; i++) {
            n *= nI[i];
        }

        // Calcola i valori di ci
        for (int i = 0; i < nI.length; i++) {
            int ci = n / nI[i];
            cI[i] = ci;
        }

        // Calcola i valori di di usando l'inverso moltiplicativo modulo ni
        for (int i = 0; i < cI.length; i++) {
            int di = inversi(cI[i], nI[i]);
            dI[i] = di;
        }

        // StringBuilder per costruire le soluzioni individuali
        StringBuilder individualSolutions = new StringBuilder("Soluzioni individuali:\n");
        for (int i = 0; i < nI.length; i++) {
            int xi = (cI[i] * a[i] * dI[i]) % nI[i];
            individualSolutions.append("x").append(i + 1).append(" = ").append(xi).append("\n");
        }

        // Calcola la soluzione totale x0
        int x0 = 0;
        for (int i = 0; i < cI.length; i++) {
            x0 += cI[i] * a[i] * dI[i];
        }

        // Calcola x come x0 modulo n
        int x = x0 % n;

        // StringBuilder per costruire la soluzione totale
        StringBuilder totalSolution = new StringBuilder("Soluzione totale:\n");
        totalSolution.append("x = ").append(x).append("\n");

        // Restituisce le soluzioni individuali e la soluzione totale come array di stringhe
        return new String[]{individualSolutions.toString(), totalSolution.toString()};
    }

    // Metodo per calcolare l'inverso moltiplicativo modulo n
    public static int inversi(int c, int n) {
        int d = 0;
        for (int i = 1; i < n; i++) {
            int x = (i * c) % n;
            if (x == 1) {
                d = i;
                break;
            }
        }
        return d;
    }

    // Metodo per verificare se gli elementi di un array sono coprimi tra loro
    public static boolean checkCoprimi(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (mcd(nums[i], nums[j]) != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    // Metodo per calcolare il massimo comune divisore (MCD) usando l'algoritmo di Euclide
    public static int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
