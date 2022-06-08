package ion.content

import arc.graphics.*
import arc.graphics.g2d.*
import mindustry.type.*

object IonStatusEffects{
    
    lateinit var petrified: StatusEffect
    
    fun load(){
        petrified = object : StatusEffect("petrified"){
            init{
                speedMultiplier = 0f
                healthMultiplier = 0.8f
                reloadMultiplier = 0f
            }
            
            override fun draw(unit: mindustry.gen.Unit){
                super.draw(unit)
                
                Draw.z(180)
                Draw.color(Color.gray)
                Draw.rect(unit.type.uiIcon, unit.x, unit.y, 270f + unit.rotation)
            }
        }
    }
}
