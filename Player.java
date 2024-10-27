public class Player {
    private String name;
    private int age;
    private String team;

    // Constructor
    public Player(String name, int age, String team) {
        this.name = name;
        this.age = age;
        this.team = team;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d, Team: %s", name, age, team);
    }
}