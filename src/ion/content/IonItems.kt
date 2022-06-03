package ion.content

import arc.graphics.Color
import mindustry.type.Item

object IonItems{
    
    lateinit val zinc: Item
    
    fun load(){
        zinc = Item("zinc").apply{
            explosiveness = 0.25f
            hardness = 4
            cost = 2
        }
    }
}
