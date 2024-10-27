import java.util.ArrayList;
import java.util.Scanner;

public class HockeyDataBase {
    private ArrayList<String> players;
    private Scanner scanner;

    public HockeyDataBase() {
        players = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nMenu: ");
            System.out.println("1. Skapa ny player");
            System.out.println("2. Uppdatera player");
            System.out.println("3. Ta bort player");
            System.out.println("4. Lista alla");
            System.out.println("5. Avsluta");

            System.out.print("\nVad vill du göra: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    addPlayer();
                    break;
                case "2":
                    updatePlayer();
                    break;
                case "3":
                    deletePlayer();
                    break;
                case "4":
                    listPlayers();
                    break;
                case "5":
                    System.out.println("\nAvslutar programmet...\n");
                    return;
                default:
                    System.out.println("\nOgiltigt val, vänligen försök igen.\n");
            }
        }
    }

    private void addPlayer() {
        System.out.println("\n***********");
        System.out.println("SKAPA NY PLAYER");
        System.out.println("***********\n");
        System.out.print("Vad heter spelaren: ");
        String newPlayerName = scanner.nextLine();
        players.add(newPlayerName);
        System.out.println("Spelare tillagd: " + newPlayerName);
    }

    private void listPlayers() {
        System.out.println("\n***********");
        System.out.println("PLAYERS LISTA");
        System.out.println("***********\n");
        if (players.isEmpty()) {
            System.out.println("Inga spelare tillagda.");
        } else {
            for (int i = 0; i < players.size(); i++) {
                System.out.println((i + 1) + ". " + players.get(i));
            }
        }
    }

    private void updatePlayer() {
        // System.out.println("\n***********");
        // System.out.println("PLAYERS LISTA");
        // System.out.println("***********\n");
        listPlayers();
        
        System.out.print("\nAnge numret för spelaren att uppdatera: ");
        int indexToUpdate = Integer.parseInt(scanner.nextLine()) - 1;

        if (indexToUpdate >= 0 && indexToUpdate < players.size()) {
            System.out.print("Ändra " + players.get(indexToUpdate) + " till: ");
            String newValue = scanner.nextLine();
            players.set(indexToUpdate, newValue);
            System.out.println("Spelare uppdaterad.");
        } else {
            System.out.println("Ogiltigt val.");
        }
    }

    private void deletePlayer() {
        System.out.println("\n***********");
        System.out.println("PLAYERS LISTA");
        System.out.println("***********\n");
        listPlayers();
        
        System.out.print("\nAnge numret för spelaren att ta bort: ");
        int indexToDelete = Integer.parseInt(scanner.nextLine()) - 1;

        if (indexToDelete >= 0 && indexToDelete < players.size()) {
            System.out.print("Är du säker att du vill ta bort " + players.get(indexToDelete) + "? (Yes/No): ");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("Yes")) {
                players.remove(indexToDelete);
                System.out.println("Spelare borttagen.");
            } else {
                System.out.println("Radering avbröts.");
            }
        } else {
            System.out.println("Ogiltigt val.");
        }
    }
}
