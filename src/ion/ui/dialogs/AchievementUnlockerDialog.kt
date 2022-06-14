package ion.ui.dialogs

import arc.scene.ui.*
import arc.scene.ui.layout.*
import mindustry.*
import mindustry.ui.dialogs.*

import ion.game.*
import ion.defs.*
import ion.content.*

open class AchievementUnlockerDialog : BaseDialog{
    constructor() : super("Achievement Unlocker"){
        addCloseButton()
        
        Utils.eachAchievement(IonAchievements.allTest){ a: Achievement ->
            cont.button(a.icon){
                if(!a.isUnlocked()){
                    a.unlock()
                } else {
                    Vars.ui.showConfirm("This achievement (${a.displayName}) has already been unlocked!\nDo you want to lock it?"){ a.lock() }
                }
            }
        }
    }
}
