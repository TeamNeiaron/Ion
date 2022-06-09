package ion.ui

import arc.scene.ui.layout.*
import mindustry.Vars
import mindustry.ui.Styles
import mindustry.gen.Icon

import ion.*

object UtilityTable{
    var tpos = Vars.ui.hudGroup.find<Table>("minimap/position")
    
    fun load(){
        tpos.row()
        
        tpos.table{ s: Table ->
            s.setBackground(Styles.black8)
            s.button(Icon.unitsSmall){
                IonVars.ai.show()
            }
        }.size(130f, 150f).row()
    }
}
