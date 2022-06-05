package ion.content

import mindustry.content.Blocks.*
import mindustry.content.TechTree.*

import ion.content.*

object IonTechTree{
    fun load(){
        nodeRoot("factories-1", siliconSmelter){
            node(IonBlocks.brassSmelter)
        }
    }
}
