package ion.ui.dialogs

import arc.func.*
import mindustry.*
import mindustry.ui.dialogs.*
import mindustry.ai.types.*
import mindustry.entities.units.*

object AISwitcherDialog : BaseDialog("AI Switcher"){
    var active = false
    var list = arrayOf(
        Prov<AIController> { FlyingAI() },
        Prov<AIController> { GroundAI() },
        Prov<AIController> { BuilderAI() },
        Prov<AIController> { RepairAI() }
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
