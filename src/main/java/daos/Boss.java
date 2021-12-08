package daos;

public class Boss {
    private int id;
    private String name;
    private String location;
    private int hp;
    private String weakness;
    private String resistances;
    private int number_of_souls;

    public Boss(int id, String name,
                String location, int hp,
                String weakness, String resistances,
                int number_of_souls) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.hp = hp;
        this.weakness = weakness;
        this.resistances = resistances;
        this.number_of_souls = number_of_souls;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public String getResistances() {
        return resistances;
    }

    public void setResistances(String resistances) {
        this.resistances = resistances;
    }

    public int getNumber_of_souls() {
        return number_of_souls;
    }

    public void setNumber_of_souls(int number_of_souls) {
        this.number_of_souls = number_of_souls;
    }
}
