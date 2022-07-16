package ion.ui.dialogs

import arc.scene.ui.Dialog
import ion.IonVars
import ion.game.Achievement
import mindustry.Vars
import mindustry.ui.dialogs.BaseDialog

open class AchievementUnlockerDialog : BaseDialog("Achievement Unlocker") {
    init{
        addCloseButton()
    }
    
    override fun show(): Dialog{
        cont.clear()
        
        IonVars.achievements.each { a: Achievement ->
            cont.button(a.icon){
                if(a.isUnlocked()){
                    Vars.ui.showConfirm("This achievement (${a.displayName}) is already unlocked!\nDo you want to lock it?"){ a.lock() }
                } else { a.unlock() }
            }.size(65f)
            if(!a.isUnlocked()){
                cont.add("${a.displayName[0]}${a.displayName[1]}...").row()
            } else {
                cont.add(a.displayName).row()
            }
        }
        
        return super.show()
    }
}
