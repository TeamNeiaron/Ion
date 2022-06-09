package ion.ui.dialogs

import mindustry.*
import mindustry.ui.dialogs.*
import mindustry.ai.types.*
import mindustry.entities.units.*

object AISwitcherDialog : BaseDialog("AI Switcher"){
    var active = false
    val list = arrayOf<Prov<AIController>>(
        { FlyingAI() },
        { GroundAI() },
        { BuilderAI() },
        { RepairAI() }
    )
    init{
        addCloseButton()
        
        for(li in list){
            cont.button("Switch"){
                active = true
                Vars.player.unit().controller(list[li])
            }.row()
        }
        cont.button("Reset AI"){
            active = false
            Vars.player.unit().resetController()
        }
    }
}