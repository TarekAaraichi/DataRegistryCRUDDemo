import java.util.ArrayList;
import java.util.Scanner;

public class HockeyDataBase {
    private ArrayList<Player> players; // Use Player objects
    private Scanner scanner;

    public HockeyDataBase() {
        players = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nMenu: ");
            System.out.println("1. Create new player");
            System.out.println("2. Update player");
            System.out.println("3. Delete player");
            System.out.println("4. List all players");
            System.out.println("5. Exit");

            System.out.print("\nWhat would you like to do: ");
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
                    System.out.println("\nExiting the program...\n");
                    return;
                default:
                    System.out.println("\nInvalid choice, please try again.\n");
            }
        }
    }

    private void addPlayer() {
        System.out.println("\n***********");
        System.out.println("CREATE NEW PLAYER");
        System.out.println("***********\n");
        
        System.out.print("What is the player's name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Enter team: ");
        String team = scanner.nextLine();

        Player newPlayer = new Player(name, age, team);
        players.add(newPlayer);
        System.out.println("Player added: " + newPlayer);
    }

    private void listPlayers() {
        System.out.println("\n***********");
        System.out.println("PLAYERS LIST");
        System.out.println("***********\n");
        
        if (players.isEmpty()) {
            System.out.println("No players added.");
        } else {
            for (int i = 0; i < players.size(); i++) {
                System.out.println((i + 1) + ". " + players.get(i));
            }
        }
    }

    private void updatePlayer() {
        listPlayers();

        System.out.print("\nEnter the number of the player to update: ");
        int indexToUpdate = Integer.parseInt(scanner.nextLine()) - 1;

        if (indexToUpdate >= 0 && indexToUpdate < players.size()) {
            Player playerToUpdate = players.get(indexToUpdate);
            System.out.print("Change name (" + playerToUpdate.getName() + "): ");
            String newName = scanner.nextLine();
            System.out.print("Change age (" + playerToUpdate.getAge() + "): ");
            int newAge = Integer.parseInt(scanner.nextLine());
            System.out.print("Change team (" + playerToUpdate.getTeam() + "): ");
            String newTeam = scanner.nextLine();

            playerToUpdate.setName(newName);
            playerToUpdate.setAge(newAge);
            playerToUpdate.setTeam(newTeam);
            System.out.println("Player updated: " + playerToUpdate);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private void deletePlayer() {
        System.out.println("\n***********");
        System.out.println("PLAYERS LIST");
        System.out.println("***********\n");
        listPlayers();
        
        System.out.print("\nEnter the number of the player to delete: ");
        int indexToDelete = Integer.parseInt(scanner.nextLine()) - 1;

        if (indexToDelete >= 0 && indexToDelete < players.size()) {
            System.out.print("Are you sure you want to delete " + players.get(indexToDelete) + "? (Yes/No): ");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("Yes")) {
                players.remove(indexToDelete);
                System.out.println("Player deleted.");
            } else {
                System.out.println("Deletion canceled.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
