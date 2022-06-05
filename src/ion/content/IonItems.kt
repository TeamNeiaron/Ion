package ion.content

import arc.graphics.Color
import mindustry.type.Item

object IonItems{
    
    lateinit var zinc: Item
    
    fun load(){
        zinc = object : Item("zinc", Color.valueOf("9c9fa6")){
            init{
                explosiveness = 0.25f
                hardness = 4
                cost = 2f
            }
        }
    }
}
