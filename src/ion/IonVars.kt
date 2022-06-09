package ion

import arc.*
import mindustry.*
import mindustry.ui.dialogs.*
import mindustry.game.EventType.Trigger

import ion.ui.dialogs.*

object IonVars{

    val ai = AISwitcherDialog()
    
    fun load(){
        Events.run(Trigger.update){
            if(ai.active){
                Core.camera.position.set(Vars.player.unit().x, Vars.player.unit().y)
            }
        }
    }
}
