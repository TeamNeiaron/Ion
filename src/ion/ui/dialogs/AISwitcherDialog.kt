package ion.ui.dialogs

import arc.func.*
import mindustry.*
import mindustry.ui.dialogs.*
import mindustry.ai.types.*
import mindustry.entities.units.*

open class AISwitcherDialog : BaseDialog{
    var active = false
    var list = arrayOf(
        { FlyingAI() },
        { GroundAI() },
        { BuilderAI() },
        { RepairAI() },
        { MinerAI() },
        { DefenderAI() },
        { HugAI() },
        { SuicideAI() }
    )
    var names = arrayOf("Flying", "Ground", "Builder", "Repair", "Miner", "Defender", "Hug", "Suicide")
    
    constructor() : super("AI Switcher"){
        addCloseButton()
        
        for(i in 0..list.size - 1){
            val sus = list[i]
            cont.button("${names[i]}"){
                active = true
                Vars.player.unit().controller(sus())
            }.size(130f, 40f).row()
        }
        cont.button("Reset AI"){
            active = false
            Vars.player.unit().resetController()
        }.size(130f, 40f).row()
    }
}
