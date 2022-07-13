package ion.ui

import arc.*
import arc.scene.*
import arc.scene.ui.ImageButton.*
import arc.scene.ui.layout.*
import arc.scene.style.*
import mindustry.*
import mindustry.ui.*
import mindustry.gen.*

import ion.ui.dialogs.*
import ion.content.*

open class ControlButton{
    val width = 160f
    val padding = 4f
    val size = 48f
    val types = arrayOf(IonUnitTypes.caretaker, IonUnitTypes.leader, IonUnitTypes.hive, IonUnitTypes.commander)
    
    fun build(parent: Group){
        var icon = Core.atlas.drawable("status-disarmed")
        var style = object : ImageButtonStyle(){
            init{
                up = Tex.pane
                down = Styles.flatDown
                over = Styles.flatOver
            }
        }
        
        var dialog = ControlDialog()
        
        parent.fill{ it: Table ->
            it.name = "control"
            it.defaults().size(width / 2f)
            
            it.top().right()
            it.marginRight(width - padding)
            
            it.button(icon, style, size){ dialog.show(Vars.player.unit().abilities) }
            
            it.visible{ Vars.player.unit().type in types }
        }
    }
}
