package ion.ui.dialogs

import arc.scene.ui.*
import arc.scene.ui.layout.*
import mindustry.ui.dialogs.*

import ion.ui.dialogs.*
import ion.game.*
import ion.defs.*
import ion.content.*

open class AchievementListDialog : BaseDialog{
    val ach = AchievementDisplayDialog()
    constructor() : super("Achievements"){
        addCloseButton()
        
        Utils.eachAchievement(IonAchievements.allTest){ a: Achievement ->
            cont.button(a.icon){
                ach.show(a)
            }
        }
    }
}
