package ion.ui

import arc.scene.ui.layout.*
import mindustry.Vars
import mindustry.ui.Styles
import mindustry.gen.Icon

import ion.*
import ion.defs.*
import ion.game.*

object UtilityTable{
    var tpos = Vars.ui.hudGroup.find<Table>("minimap/position")
    
    fun load(){
        tpos.row()
        
        tpos.table{ s: Table ->

            s.name = "utilitytable"
            
            s.setBackground(Styles.none)
            s.button(Icon.unitsSmall){
                IonVars.ai.show()
            }.size(50f, 50f)
            
            s.button(IIcon.hp){
                Healthbars.shown = !Healthbars.shown
            }.size(50f, 50f).tooltip("Enables/disables healthbars.")
        }.size(130f, 240f).row()
    }
}
