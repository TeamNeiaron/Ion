package ion.ui.dialogs

import arc.scene.ui.Dialog
import com.github.mnemotechnician.mkui.extensions.dsl.textButton
import ion.entities.abilities.ControllableUnitSpawnAbility
import mindustry.entities.abilities.Ability
import mindustry.ui.dialogs.BaseDialog

open class ControlDialog : BaseDialog("Unit Spawn Control") {
    init{
        addCloseButton()
    }
    
    fun show(abilityList: Array<Ability>): Dialog{
        cont.clear()
        
        abilityList.forEach{ a: Ability ->
            if(a is ControllableUnitSpawnAbility){
                cont.textButton("Toggle Ability", wrap = false){
                    a.enabled = !a.enabled
                }
            }
        }
        
        return super.show()
    }
}
