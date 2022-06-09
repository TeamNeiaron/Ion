package ion.game

import arc.*
import arc.graphics.*
import arc.graphics.g2d.*
import mindustry.gen.*
import mindustry.game.EventType.Trigger
import mindustry.graphics.Layer

import ion.defs.*

object Healthbars{
    var shown = true
    
    fun draw(bool: Boolean){
        shown = bool
    }
    
    fun load(){
        Events.run(Trigger.draw){
            if(!shown){} else {
                Groups.unit.each(){
                    var u = it
                    
                    if(u.health <= 0f){} else {
                        Draw.z(Layer.end)
                        Draw.color(Color.valueOf("ffaf00"))
                        Lines.stroke(3f)
                        Lines.line(u.x - u.hitSize, u.y - u.hitSize, u.x - u.hitSize + u.healthf() * u.hitSize * 2f, u.y - u.hitSize)
                    }
                    
                    if(u.shield <= 0f){} else {
                        Draw.z(Layer.end)
                        Draw.color(IColor.energy)
                        Lines.line(u.x - u.hitSize, u.y - u.hitSize - 5f, u.x - u.hitSize + u.shield / u.maxHealth * u.hitSize * 2f, u.y - u.hitSize - 5f)
                    }
                }
            }
        }
    }
}
