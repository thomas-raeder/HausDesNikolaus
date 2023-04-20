import abiturklassen.*;

public class Main {
    public static void main(String[] args) {
        Graph hdn = new Graph();
        hdn.knotenHinzu('A');
        hdn.knotenHinzu('B');
        hdn.knotenHinzu('C');
        hdn.knotenHinzu('D');
        hdn.knotenHinzu('E');

        hdn.kanteHinzu('A', 'B');
        hdn.kanteHinzu('B', 'C');
        hdn.kanteHinzu('C', 'D');
        hdn.kanteHinzu('D', 'E');
        hdn.kanteHinzu('E', 'A');
        hdn.kanteHinzu('E', 'B');
        hdn.kanteHinzu('A', 'C');
        hdn.kanteHinzu('E', 'C');

        //Erstellen aller Wege:
        List<String> wege = new LetterCombinations(9).getCombinations();
        List<String> gueltigeWege = new List<>();

        wege.toFirst();
        while(wege.hasAccess()){
            if(hdn.istRundWeg(wege.getContent())){
                gueltigeWege.append(wege.getContent());
            }
            wege.next();
        }

        gueltigeWege.toFirst();
        int zaehler = 0;
        while(gueltigeWege.hasAccess()){
            System.out.println(zaehler+1 +". " + gueltigeWege.getContent());
            gueltigeWege.next();
            zaehler++;
        }

        System.out.println("Es gibt "+ zaehler + " gültige Wege für das Haus des Nikolaus.");

        //System.out.println(hdn.istRundWeg("AEDCBACEB"));





    }
}