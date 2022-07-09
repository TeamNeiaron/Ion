package ion.ui.dialogs

import arc.scene.ui.*
import arc.scene.ui.layout.*
import mindustry.*
import mindustry.ui.dialogs.*

import ion.*
import ion.game.*
import ion.defs.*
import ion.content.*

open class AchievementUnlockerDialog : BaseDialog{
    constructor() : super("Achievement Unlocker"){
        addCloseButton()
    }
    
    override fun show(): Dialog{
        cont.clear()
        
        IonVars.achievements.each(){ a: Achievement ->
            cont.button(a.icon){
                if(a.isUnlocked()){
                    Vars.ui.showConfirm("This achievement (${a.displayName}) is already unlocked!\nDo you want to lock it?"){ a.lock() }
                }
            }
            if(!a.isUnlocked()){
                cont.add("${a.displayName.get(0)}${a.displayName.get(1)}...").row()
            } else {
                cont.add(a.displayName).row()
            }
        }
        
        return super.show()
    }
}
