import java.util.*;
import java.lang.*;

class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private String[][] schedule;
    public Family family;
    static {
        System.out.println("Human class is loaded.");
    }

    {
        System.out.println("A new human object is created.");
    }
    public Human(String name, String surname, int year, int iq, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
    }
    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getYear() {
        return year;
    }
    public int getIq() {
        return iq;
    }
    public String[][] getSchedule() {
        return schedule;
    }
    public Family getFamily() {
        return family;
    }
    public void setFamily(Family family) {
        this.family = family;
    }
    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void greetPet() {
        System.out.println("Hello" + family.getPet().getNickname());
    }

    public void describePet() {
        String sly = "";
        if (family.getPet().getTrickLevel() > 50) {
            sly = "very sly";
        } else {
            sly = "almost not sly";
        }
        System.out.println("I have an " + family.getPet().getSpecies() + "is " + family.getPet().getAge() + " years old, he is " + sly);
    }
    public boolean feedPet(boolean isTimeToFeed) {
        if (isTimeToFeed) {
            System.out.println("Hm... I will feed " + name + "'s " + family.getPet().getSpecies());
            return true;
        } else {
            Random random = new Random();
            int randomNum = random.nextInt(101);
            if ( family.getPet().getTrickLevel() > randomNum) {
                System.out.println("Hm... I will feed " + name + "'s " + family.getPet().getSpecies());
                return true;
            } else {
                System.out.println("I think " + name + "'s " + family.getPet().getSpecies()  + " is not hungry.");
                return false;
            }
        }
    }
    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", schedule=" + Arrays.deepToString(schedule) +
                '}';
    }
    @Override
    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        Human human = (Human) a;
        return year == human.year && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Arrays.deepEquals(schedule, human.schedule);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, year, iq);
        result = 31 * result + Arrays.deepHashCode(schedule);
        return result;
    }
    @SuppressWarnings("removal")
    @Override
    protected void finalize () throws Throwable {
        System.out.println("object" + this.name + this.surname + this.year + this.iq + this.schedule + this.family + "is removed");
    }

}