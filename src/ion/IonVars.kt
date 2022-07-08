package ion

import arc.struct.*

import ion.ui.dialogs.*
import ion.game.*
import ion.content.*

object IonVars{

    lateinit var achievementDisplay: AchievementDisplayDialog
    lateinit var achievementList: AchievementListDialog
    lateinit var achievementUnlocker: AchievementUnlockerDialog
    lateinit var secret: SecretDialog
    
    val achievements = Seq<Achievement>(Achievement::class.java)
    
    fun load(){
        achievementDisplay = AchievementDisplayDialog()
        achievementList = AchievementListDialog()
        achievementUnlocker = AchievementUnlockerDialog()
        secret = SecretDialog()
    }
}
