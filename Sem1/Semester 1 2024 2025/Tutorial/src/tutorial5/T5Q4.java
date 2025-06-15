package tutorial5 ; 

public class T5Q4 {
    public static void main(String[] args) {
        String[] sentence = {
            "The quick brown fox jumps over the lazy dog.",
            "The rain in Spain stays mainly in the plain.",
            "In the end, the love you take is equal to the love you make."
        };

        int count = 0;
        for (String str : sentence) {
            String[] words = str.split(" ");
            for (String word : words) {
                if (word.equals("the")) {
                    count++;
                }
            }
        }

        System.out.println("The word 'the' occurs " + count + " times.");
    }
}

