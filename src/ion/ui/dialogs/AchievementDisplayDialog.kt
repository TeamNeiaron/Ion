package ion.ui.dialogs

import arc.scene.ui.*
import mindustry.ui.dialogs.*

import ion.game.*
import ion.defs.*
import ion.content.*

open class AchievementDisplayDialog : BaseDialog{
    constructor() : super("Achievements"){
        addCloseButton()
        margin(6f)
        
        Utils.eachAchievement(IonAchievements.all){
            val a = it.data(true)
            cont.add("Name: ${a[0]}").row()
            cont.add("Unlocked: ${it.isUnlocked()}").row()
            cont.add("Description: ${a[1]}\n\n").row()
        }
    }
}
