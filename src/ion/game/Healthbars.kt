package ion.game

import arc.*
import arc.graphics.*
import arc.graphics.g2d.*
import mindustry.gen.*
import mindustry.game.EventType.Trigger

import ion.defs.*

object Healthbars{
    var shown = true
    
    fun draw(bool: Boolean){
        shown = bool
    }
    
    fun load(){
        Events.run(Trigger.draw){
            if(!shown) return
            Groups.unit.each(){
                var u = it
                
                Draw.color(Color.valueOf("ffaf00"))
                Lines.stroke(3f)
                Lines.line(u.x - u.hitSize, u.y - u.hitSize, u.x - u.hitSize + u.healthf() * u.hitSize * 2f, u.y - u.hitSize - 6f)
                
                if(u.shield == 0) return
                Draw.color(IColor.energy)
                Lines.line(u.x - u.hitSize, u.y - u.hitSize, u.x - u.hitSize + u.health / u.shield * u.hitSize * 2f, u.y - u.hitSize - 6f)
            }
        }
    }
}
