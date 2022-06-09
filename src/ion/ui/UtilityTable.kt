package ion.ui

import mindustry.Vars
import mindustry.ui.Styles
import mindustry.gen.Icon

import ion.*

object UtilityTable{
    val tpos = Vars.ui.hudGroup.find("minimap/position")
    
    fun load(){
        tpos.table(){
            it.setBackground(Styles.black7)
            it.button(Icon.unitsSmall){
                IonVars.ai.show()
            }
        }.size(130f, 150f)
    }
}
