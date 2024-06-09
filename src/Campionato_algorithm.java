import java.util.ArrayList;
import java.util.List;

public class Campionato_algorithm {
    private StringBuilder outputBuilder;

    public Campionato_algorithm(Integer numSquadra) {
        outputBuilder = new StringBuilder();

        List<Integer> squadra = new ArrayList<>();
        for (int i = 1; i <= numSquadra; i++) {
            squadra.add(i);
        }

        if (numSquadra == 2) {
            // Gestione speciale per 2 squadre
            outputBuilder.append("Giornata 1: Squadra 1 vs Squadra 2\n");
            return;
        }

        boolean isOdd = numSquadra % 2 != 0;

        if (isOdd) {
            squadra.add(-1);  // Aggiungi una squadra fittizia per avere un numero pari di squadre
            numSquadra++;
        }

        int numGiorni = numSquadra - 1;
        int numPartite = numSquadra / 2;

        for (int giornata = 0; giornata < numGiorni; giornata++) {
            outputBuilder.append("Giornata ").append(giornata + 1).append(":\n");
            for (int i = 0; i < numPartite; i++) {
                int squadra1 = squadra.get(i);
                int squadra2 = squadra.get(numSquadra - 1 - i);

                if (squadra1 != -1 && squadra2 != -1) {  // Evita incontri con la squadra fittizia
                    outputBuilder.append(String.format("  Squadra %d vs Squadra %d\n", squadra1, squadra2));
                } else if (squadra1 == -1) {
                    outputBuilder.append(String.format("  Riposa squadra %d\n", squadra2));
                } else {
                    outputBuilder.append(String.format("  Riposa squadra %d\n", squadra1));
                }
            }
            rotateList(squadra);
        }
    }

    private void rotateList(List<Integer> list) {
        if (list.size() > 1) {
            Integer last = list.remove(list.size() - 1);
            list.add(1, last);
        }
    }

    public String getOutput() {
        return outputBuilder.toString();
    }


}
