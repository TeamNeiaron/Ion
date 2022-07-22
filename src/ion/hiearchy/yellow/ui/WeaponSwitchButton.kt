package ion.hiearchy.yellow.ui

import arc.Core
import arc.scene.Group
import arc.scene.ui.ImageButton.ImageButtonStyle
import arc.scene.ui.layout.Table
import ion.hiearchy.yellow.content.YellowUnitTypes
import ion.hiearchy.yellow.ui.dialogs.WeaponSwitchDialog
import mindustry.Vars
import mindustry.gen.Tex
import mindustry.ui.Styles

open class WeaponSwitchButton{
    val width = 160f
    val padding = 4f
    val size = 48f

    fun build(parent: Group){
        val icon = Core.atlas.drawable("status-disarmed")
        val style = object : ImageButtonStyle(){
            init{
                up = Tex.pane
                down = Styles.flatDown
                over = Styles.flatOver
            }
        }
        
        val dialog = WeaponSwitchDialog()
        
        parent.fill{ it: Table ->
            it.name = "control"
            it.defaults().size(width / 2f)
            
            it.top().right()
            it.marginRight(width - padding)
            
            it.button(icon, style, size){ dialog.show(Vars.player.unit().mounts) }
            
            it.visible{ Vars.player.unit().type == YellowUnitTypes.yellow }
        }
    }
}
