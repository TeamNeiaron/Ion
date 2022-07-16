package ion.ui

import arc.Core
import arc.scene.Group
import arc.scene.ui.ImageButton.ImageButtonStyle
import arc.scene.ui.layout.Table
import ion.content.IonUnitTypes
import ion.ui.dialogs.ControlDialog
import mindustry.Vars
import mindustry.gen.Tex
import mindustry.ui.Styles

open class ControlButton{
    val width = 160f
    val padding = 4f
    val size = 48f
    val types = arrayOf(IonUnitTypes.caretaker, IonUnitTypes.leader, IonUnitTypes.hive, IonUnitTypes.commander)
    
    fun build(parent: Group){
        val icon = Core.atlas.drawable("status-disarmed")
        val style = object : ImageButtonStyle(){
            init{
                up = Tex.pane
                down = Styles.flatDown
                over = Styles.flatOver
            }
        }
        
        val dialog = ControlDialog()
        
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
