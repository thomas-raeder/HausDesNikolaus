import abiturklassen.*;
public class LetterCombinations {
    public List<String> getCombinations() {
        return combinations;
    }

    private List<String> combinations;

    public LetterCombinations(int pLaenge){
        combinations = generateCombinations(pLaenge);
    }

    public static List<String> generateCombinations(int length) {
        List<String> combinations = new List<>();

        generate("", length, combinations);

        return combinations;
    }

    private static void generate(String prefix, int length, List<String> combinations) {
        if (length == 0) {
            combinations.append(prefix);
            return;
        }

        for (char c = 'A'; c <= 'E'; c++) {
            generate(prefix + c, length - 1, combinations);
        }
    }
}
