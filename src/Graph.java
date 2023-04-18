public class Graph {
    private final int anzahl = 5;
    private char[] knoten = new char[anzahl];
    private boolean[][] adjazenzMatrix = new boolean[anzahl][anzahl];
    private int anzahlKnoten = 0;

    public Graph() {
        for (int i = 0; i<anzahl; i++){
            knoten[i] = ' ';
        }
        for (int i = 0; i<anzahl; i++){
            for (int j = 0; j < anzahl; j++){
                adjazenzMatrix[i][j] = false;
            }
        }
    }

    public void knotenHinzu(char k){
        knoten[anzahlKnoten] = k;
        anzahlKnoten++;
    }


    public int sucheKnotenIndex(char zeichen){
        int kIndex = -1;
        int zaehler = 0;
        while (kIndex == -1 && zaehler < anzahl){
            if (knoten[zaehler] == zeichen){
                kIndex = zaehler;
            } else {
                zaehler++;
            }
        }
        return kIndex;
    }

    public void kanteHinzu(char k1, char k2){
        int indexK1 = sucheKnotenIndex(k1);
        int indexK2 = sucheKnotenIndex(k2);
        if (indexK1 != -1 && indexK2 != -1) {
            adjazenzMatrix[indexK1][indexK2] = true;
            adjazenzMatrix[indexK2][indexK1] = true;
        }
    }

    public boolean hatKante(char k1, char k2){
        int indexK1 = sucheKnotenIndex(k1);
        int indexK2 = sucheKnotenIndex(k2);
        if (indexK1 != -1 && indexK2 != -1) {
            return adjazenzMatrix[indexK1][indexK2];
        } else {
            return false;
        }
    }

    public boolean istRundWeg(String  weg){

        boolean[][] besucht = new boolean[anzahl][anzahl];
        for (int i = 0; i<anzahl; i++){
            for (int j = 0; j < anzahl; j++){
                besucht[i][j] = false;
            }
        }

        int laenge = weg.length();

        for (int i = 0; i<laenge-1; i++){
            char eins = weg.charAt(0);
            weg = weg.substring(1);
            char zwei = weg.charAt(0);
            if (!this.hatKante(eins,zwei)){
                return false;
            }
            else {
                int ind1 = sucheKnotenIndex(eins);
                int ind2 = sucheKnotenIndex(zwei);

                if (besucht[ind1][ind2]==true){
                    return false;
                } else {
                    besucht[ind1][ind2]=true;
                    besucht[ind2][ind1]=true;
                }
            }
        }
        for (int i = 0; i<anzahl; i++){
            for (int j = 0; j < anzahl; j++){
                if(adjazenzMatrix[i][j] != besucht[i][j]){
                    return false;
                }
            }
        }
        return true;

    }
}

