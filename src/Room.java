import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room implements Describable{
    private String name;
    private String description;
    private Map<String, Interactable> interactables;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.interactables = new HashMap<>();
    }

    // lägg till ett interactable objekt i hash mapen
    public void addInteractable(String name, Interactable interactable) {
        interactables.put(name.toLowerCase(), interactable);
    }

    // hämta ett interactable objekt baserat på namnet
    public Interactable getInteractable(String name) {
        return interactables.get(name.toLowerCase());
    }

    public Interactable getInteractableByNumber(String number) {
        try {
            int index = Integer.parseInt(number) -1;
            List<String> keys = new ArrayList<>(interactables.keySet());
            if (index >= 0 && index < keys.size()) {
                String key = keys.get(index);
                return interactables.get(key);
            }
        } catch (NumberFormatException e) {
            System.out.println("Ogiltigt nummer. Ange ett giltigt heltal.");
        }
        return null;
    }

    public void removeInteractable(String name) {
        interactables.remove(name.toLowerCase());
    }

    // metod som kollar om rummet har några interaktiva objekt, alltså finns det objekt i listan
    public boolean hasInteractables() {
        return !interactables.isEmpty();
        // !true = false
        // !false = true
    }

    // visar lista med alla interaktiva objekt utan nummer
    public void showInteractables() {
        if(interactables.isEmpty()) {
            System.out.println("Det finns inga objekt här att interagera med.");
        } else {
            System.out.println("Du ser följande saker: ");
            for (String itemName: interactables.keySet()) {
                System.out.println("- " + itemName);
            }
        }
    }

    // visar en numrerad lista av alla objekt i rummet
    public void showInteractablesWithNumbers() {
        int i = 1;
        for (String itemName: interactables.keySet()) {
            System.out.println(i + ". " + itemName);
            i++;
        }
    }

    public String getName() {
        return name;
    }


    @Override
    public String getDescription() {
        return description;
    }
}




















