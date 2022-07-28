package ion

import arc.Events
import arc.struct.Seq
import ion.game.Achievement
import ion.game.PermVars
import ion.game.TempVars
import ion.misc.Utils
import ion.ui.dialogs.*
import mindustry.Vars
import mindustry.game.EventType.UnitDestroyEvent

@Suppress("MemberVisibilityCanBePrivate")
object IonVars{

    lateinit var achievementDisplay: AchievementDisplayDialog
    lateinit var achievementList: AchievementListDialog
    lateinit var achievementUnlocker: AchievementUnlockerDialog
    lateinit var secret: SecretDialog
    lateinit var stats: StatsDialog
    
    val achievements = Seq<Achievement>(Achievement::class.java)
    val achievementInfo = Seq<String>(String::class.java)
    
    fun load(){
        achievementDisplay = AchievementDisplayDialog()
        achievementList = AchievementListDialog()
        achievementUnlocker = AchievementUnlockerDialog()
        secret = SecretDialog()
        stats = StatsDialog()
        
        achievements.each{
            achievementInfo.add("${it.displayName} - ${it.description}")
            it.load()
        }
        
        Events.on(UnitDestroyEvent::class.java){
            if(it.unit.team != Vars.player.team() && !Vars.state.isCampaign){
                PermVars.killCountCustom += 1
                PermVars.killCountAll += 1
            }
            if(it.unit.team != Vars.player.team() && Vars.state.isCampaign){
                PermVars.killCountCampaign += 1
                PermVars.killCountAll += 1
                TempVars.kill5 += 1
            }
        }
        
        Utils.loop(5f){ TempVars.kill5 = 0 }
    }
}
