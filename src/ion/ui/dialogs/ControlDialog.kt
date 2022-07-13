package ion.ui.dialogs

import arc.scene.ui.*
import mindustry.ui.dialogs.*
import mindustry.entities.abilities.*

import ion.entities.abilities.*

import com.github.mnemotechnician.mkui.extensions.dsl.*

open class ControlDialog : BaseDialog{
    constructor() : super("Unit Spawn Control"){
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
