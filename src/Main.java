import java.util.ArrayList;

/*public class Main {
   public static void main (String []args){

        ArrayList<String> hangman = new ArrayList<>();
            hangman.add("tree");
            hangman.add("rain");
            hangman.add("bear");
            hangman.add("chess");
            hangman.add("insurance");
            hangman.add("pancakes");
            hangman.add("stream");










    }
}*/
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String guesses[] = {
                "tree", "rain", "bear", "encourage",
                "promise", "soup", "chess", "insurance", "pancakes", "stream"};

        boolean weArePlaying = true;
        while(weArePlaying){
            System.out.println("Let's Start Playing Hangman!");
            int randomNumber = random.nextInt(guesses.length); //random.nextInt(10);
            char randomWordToGuess[] = guesses[randomNumber].toCharArray(); // java -> j,a,v,a
            int ammountOfGuesses = randomWordToGuess.length; //total tries to guess a word.
            char playerGuess[] = new char[ammountOfGuesses]; // "_ _ _ _ _ _ _ _"

            for(int i=0; i<playerGuess.length; i++){ // Assign empty dashes at start "_ _ _ _ _ _ _ _"
                playerGuess[i] =  '_';
            }

            boolean wordIsGuessed = false;
            int tries = 0;

            while(!wordIsGuessed && tries != ammountOfGuesses){
                System.out.println("Current Guesses: ");
                print(playerGuess);
                System.out.printf("You have %d amount of tries left.\n", ammountOfGuesses-tries);
                System.out.println("Enter a single character: ");
                char input = scanner.nextLine().charAt(0);
                tries++;

                if(input == '-'){
                    wordIsGuessed = true;
                    weArePlaying = false;
                } else{
                    for(int i=0; i<randomWordToGuess.length; i++){
                        if(randomWordToGuess[i] == input){
                            playerGuess[i] = input;
                        }
                    }

                    if(isTheWordGuessed(playerGuess)){
                        wordIsGuessed = true;
                        System.out.println("Congratulations");
                    }
                }
            } /* End of wordIsGuessed */
            if(!wordIsGuessed){
                System.out.println("You ran out of guesses.");
            }

            System.out.println("Would you like to play again? (yes/no) ");
            String choice = scanner.nextLine();
            if(choice.equals("no")){
                weArePlaying = false;
            }

        }/*End of We Are Playing*/

        System.out.println("Game Over!");
    }

    public static void print(char array[]){
        for(int i=0; i<array.length; i++){ // Assign empty dashes at start "_ _ _ _ _ _ _ _"
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static boolean isTheWordGuessed(char[] array){
        boolean condition = true;
        for(int i=0; i<array.length; i++){
            if(array[i] == '_'){
                condition = false;
            }
        }
        return condition;
    }
}





/*
    You are going to write a word guessing game app in Java. This game is a simpler version of Hangman.

        Requirements:

        Initialize your array list with the following words:
        tree
        rain
        bear
        encourage
        promise
        soup
        chess
        insurance
        pancakes
        stream
        When you run the application, randomly choose a word from that list for the user to guess.
        For each letter the user guesses wrong, let them know along with how many wrong guesses they have left.
        The user is allowed up to 5 wrong guesses. On the 6th wrong guess, they lose the game.
        If the user guesses correctly, output the word with the letters they have guessed correctly so far and blanks for letters they have not guessed yet.
        The user can input either a letter or a word for their guess.
        If the user guesses the word correctly, output "You've won!" and end the game.
        Sample output:

        Welcome, let's play hangman!

        Here is the word I am thinking of: _ _ _ _ _ _ _ _ _

        Enter your guess: a
        Your guess so far: a _ _ a _ _ _ _ _

        Enter your guess: e
        You have guessed incorrectly 1/6 times.
        Your guess so far: a _ _ a _ _ _ _ _

        Enter your guess: arraylist

        You've won! The word was arraylist.

        Thank you for playing!

        =======================================

        Welcome, let's play hangman!

        Here is the word I am thinking of: _ _ _ _

        Enter letter or word guess: a
        Your guess so far: _ a _ _

        Enter letter or word guess: e
        You have guessed incorrectly 1/6 times.
        Your guess so far: _ a _ _

        Enter letter or word guess: y
        You have guessed incorrectly 2/6 times.
        Your guess so far: _ a _ _

        Enter letter or word guess: i
        Your guess so far: _ a i _

        Enter letter or word guess: n
        Your guess so far: _ a i n

        Enter letter or word guess: v
        You have guessed incorrectly 3/6 times.
        Your guess so far: _ a i n

        Enter letter or word guess: j
        You have guessed incorrectly 4/6 times.
        Your guess so far: _ a i n

        Enter letter or word guess: k
        You have guessed incorrectly 5/6 times.
        Your guess so far: _ a i n

        Enter letter or word guess: l
        You have guessed incorrectly 6/6 times.
        Sorry, you have no more guesses left. The word was rain.

        Thank you for playing!

*/
