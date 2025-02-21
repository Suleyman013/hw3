import java.util.*;
import java.lang.*;
class pet {
    private String species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;
    static {
        System.out.println("Pet class is loaded.");
    }
    {
        System.out.println("A new pet object is created.");
    }

    public pet(String name, String rex, int i, int i1) {
        this.nickname = nickname;
    }
    public pet (String species, String nickname) {
        this.species=species;
        this.nickname=nickname;
    }
    public pet (String species, String nickname, int age, int trickLevel, String[] habits) {
        this.species=species;
        this.nickname=nickname;
        this.age=age;
        this.trickLevel=trickLevel;
        this.habits=habits;
    }


    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getTrickLevel() {
        return trickLevel;
    }
    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }
    public String[] getHabits() {
        return habits;
    }
    public void setHabits(String[] habits) {
        this.habits = habits;
    }
    public void eat() {
        System.out.println("I am eating");
    }
    public void respond() {
        System.out.println("Hello owner. I am -" + nickname +" I miss you");
    }
    public void foul () {
        System.out.println("I need to cover it up");
    }

    @Override
    public String toString() {
        return species + "{nickname='" + nickname + "', age=" + age + ", trickLevel=" + trickLevel + ", habits=" + java.util.Arrays.toString(habits) + "}";
    }
    @Override
    public boolean equals(Object a) {
        if (this == a)
            return true;
        if (a == null || getClass() != a.getClass()) return false;
        pet pet = (pet) a;
        return age == pet.age && trickLevel == pet.trickLevel && Objects.equals(species, pet.species) && Objects.equals(nickname, pet.nickname) && Arrays.equals(habits, pet.habits);
    }


    @Override
    public int hashCode() {
        int result = Objects.hash(species, nickname, age, trickLevel);
        result = 31 * result + Arrays.hashCode(habits);
        return result;
    }
    @SuppressWarnings("removal")
    @Override
    protected void finalize() throws Throwable {
        System.out.println("object" + this.nickname + " is removed");
    }
}