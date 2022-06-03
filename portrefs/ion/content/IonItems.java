package ion.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class IonItems {
    public static Item
    
    zinc;
    
    public static void load() {
        zinc = new Item("zinc", Color.valueOf("9C9FA6")) {{
            explosiveness = 0.25f;
            hardness = 4;
            cost = 2;
        }};
    }
}
