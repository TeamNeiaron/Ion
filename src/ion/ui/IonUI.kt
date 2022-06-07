package ion.ui

import mindustry.Vars
import mindustry.ui.*
import mindustry.gen.*

object IonUI{
    
    fun load(){
        var pos = Vars.ui.hudGroup.find("minimap/position")
        
        pos.row().table(){
            it.setBackground(Styles.accentDrawable)
            it.button(Icon.admin){
            }.size(50f, 50f)
        }.size(130f, 150f)
    }
}
