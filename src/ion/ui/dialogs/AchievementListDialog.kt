package ion.ui.dialogs

import arc.scene.ui.*
import arc.scene.ui.layout.*
import mindustry.ui.dialogs.*

import ion.*
import ion.ui.dialogs.*
import ion.game.*
import ion.defs.*
import ion.content.*

open class AchievementListDialog : BaseDialog{
    val ach = AchievementDisplayDialog()
    constructor() : super("Achievements"){
        addCloseButton()
    }
    
    override fun show(): Dialog{
        cont.clear()
        
        IonVars.achievements.each(){ a: Achievement ->
            cont.button(a.icon){
                ach.show(a)
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
