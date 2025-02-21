import java.util.*;
class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private pet pet;
    static {
        System.out.println("Family class is loaded.");
    }
    {
        System.out.println("A new family object is created.");
    }
    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
        this.pet = new pet(Species.DOG.name(), "Rex", 3, 60);
        this.father.setFamily(this);
        this.mother.setFamily(this);
    }
    public Human getMother() {
        return mother;
    }
    public Human getFather() {
        return father;
    }
    public Human[] getChildren() {
        return children;
    }
    public void setChildren(Human[] children) {
        this.children = children;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public pet getPet(){
        return pet;
    }
    public void setPet(pet pet){
        this.pet = pet;
    }
    public void addchild(Human child){
        Human [] child1 = new Human[children.length + 1];
        for (int i = 0; i < children.length; i++) {
            child1[i] = children[i];
        }
        child1[children.length] = child;
        children = child1;
        child.setFamily(this);
    }
    public void removeChild(Human child){
        int counter = 0;
        Human [] child1 = new Human[children.length - 1];
        for (int j = 0; j < children.length; j++) {
            if (!children[j].equals(child)) {
                child1[counter] = children[j];
                counter++;
            }
        }
        children = child1;
        child.setFamily(null);
    }
    public void removeChildrenWithIndex(int index) {
        if (index < 0 || index >= children.length) {
            System.out.println("Invalid index");
            return;
        }
        Human[] newChildren = new Human[children.length - 1];

        for (int i = 0, j = 0; i < children.length; i++) {
            if (i != index) {
                newChildren[j] = children[i];
                j++;
            }
        }

        children = newChildren; // Update the children array
    }
    public int Memmebersoffamily(){
        return children.length +2;
    }

    @Override
    public String toString() {
        return "Family = mother:"+ mother.toString() +"\nfather:"+ father.toString() + "\nchildren:" + Arrays.toString(children) + "\npet:" + pet.toString();
    }
    @Override
    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        Family family = (Family) a;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father) && Arrays.equals(children, family.children) && Objects.equals(pet, family.pet);
    }
    @Override
    public int hashCode() {
        int result = Objects.hash(mother, father, pet);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }
        @SuppressWarnings("removal")
        @Override
        protected void finalize() throws Throwable {
            System.out.println("family class is REMOVED.");
        }
}