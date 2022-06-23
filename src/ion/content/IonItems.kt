package ion.content

import arc.graphics.Color
import mindustry.type.Item

object IonItems{
    
    lateinit var zinc: Item
    lateinit var brass: Item
    lateinit var stone: Item
    
    fun load(){
        zinc = object : Item("zinc", Color.valueOf("9c9fa6")){
            init{
                explosiveness = 0.25f
                hardness = 2
                cost = 2f
            }
        }
        
        brass = object : Item("brass", Color.valueOf("e1c16e")){
            init{
                hardness = 3
                cost = 2.8f
            }
        }

        stone = object : Item("stone", Color.valueOf("474c54")){
            init{
                hardness = 1
            }
        }
    }
}
