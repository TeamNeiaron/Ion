package ion.ui.dialogs

import arc.func.*
import mindustry.*
import mindustry.ui.dialogs.*
import mindustry.ai.types.*
import mindustry.entities.units.*

open class AISwitcherDialog : BaseDialog{
    var active = false
    var list = arrayOf<UnitController>(
        <UnitController> { FlyingAI() },
        <UnitController> { GroundAI() },
        <UnitController> { BuilderAI() },
        <UnitController> { RepairAI() }
    )
    
    constructor() : super("AI Switcher"){
        addCloseButton()
        
        for(li in list){
            cont.button("Switch"){
                val sus = li
                active = true
                Vars.player.unit().controller(sus)
            }.row()
        }
        cont.button("Reset AI"){
            active = false
            Vars.player.unit().resetController()
        }
    }
}
