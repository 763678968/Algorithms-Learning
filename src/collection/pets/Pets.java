//: typeinfo/pets/Pets.java
// Facade to produce a default PetCreator.
package collection.pets;
import java.util.*;

public class Pets {
  public static final typeinfo.pets.PetCreator creator =
    new typeinfo.pets.LiteralPetCreator();
  public static typeinfo.pets.Pet randomPet() {
    return creator.randomPet();
  }
  public static typeinfo.pets.Pet[] createArray(int size) {
    return creator.createArray(size);
  }
  public static ArrayList<typeinfo.pets.Pet> arrayList(int size) {
    return creator.arrayList(size);
  }
} ///:~
