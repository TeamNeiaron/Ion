package ion.ui

import arc.scene.ui.layout.*
import mindustry.Vars
import mindustry.ui.Styles
import mindustry.gen.Icon

import ion.*

object UtilityTable{
    val tpos = Vars.ui.hudGroup.find("minimap/position")
    
    fun load(){
        tpos.table{ s: Table ->
            s.setBackground(Styles.black8)
            s.button(Icon.unitsSmall){
                IonVars.ai.show()
            }
        }.row().size(130f, 150f)
    }
}
