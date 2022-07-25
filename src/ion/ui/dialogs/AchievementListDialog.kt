package ion.ui.dialogs

import arc.scene.ui.Dialog
import ion.IonVars
import ion.game.Achievement
import mindustry.ui.dialogs.BaseDialog

open class AchievementListDialog() : BaseDialog("Achievements"){
    val ach = AchievementDisplayDialog()

    init{
        addCloseButton()
    }
    
    override fun show(): Dialog{
        cont.clear()
        
        IonVars.achievements.each{ a: Achievement ->
            cont.button(a.icon){
                ach.show(a)
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
