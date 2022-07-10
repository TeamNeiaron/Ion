package ion.content

import arc.*
import mindustry.*
import mindustry.gen.*
import mindustry.game.EventType.*

import ion.defs.*
import ion.game.*

object IonAchievements{
    lateinit var test: Achievement
    lateinit var test2: Achievement
    lateinit var makingEndsMeet: Achievement
    lateinit var reunited: Achievement
    lateinit var malice: Achievement
    lateinit var killingSpree: Achievement
    lateinit var unhinged: Achievement
    lateinit var genocide: Achievement
    lateinit var cheesyPet: Achievement
    lateinit var sk: Achievement
    
    fun load(){
        test = object : Achievement("test", "Test Achievement", {
            if(test2.isUnlocked()) it.unlock()
        }){
            init{
                description = "A test achievement."
            }
        }

        test2 = object : Achievement("test-2", "Another Test Achievement"){
            init{
                description = "\"How does one obtain me?\" - The achievement curiously asks."
            }
        }
        
        makingEndsMeet = object : Achievement("making-ends-meet", "Making Ends Meet"){
            init{
                description = "Obtain 100 of every single item."
            }
        }
        
        reunited = object : Achievement("reunited", "Reunited"){
            init{
                description = "[lightgray]...Smol?[]\nFind Yellow-chan."
            }
        }
        
        malice = object : Achievement("malice", "Malice", {
            if(PermaVars.killCountCampaign >= 150) it.unlock()
        }){
            init{
                description = "Kill 150 units."
            }
        }
        
        killingSpree = object : Achievement("killing-spree", "Killing Spree", {
            if(PermaVars.killCountCampaign >= 500) it.unlock()
        }){
            init{
                description = "Kill 500 units."
            }
        }
        
        unhinged = object : Achievement("unhinged", "Unhinged", {
            if(PermaVars.killCountCampaign >= 2000) it.unlock()
        }){
            init{
                description = "Kill 2000 units."
            }
        }
        
        genocide = object : Achievement("genocide", "Genocide", {
            if(PermaVars.killCountCampaign >= 10000){
                Vars.ui.showInfo("You're kind of a freak, you know that?")
                Groups.unit.each(){ it.kill() }
                Groups.build.each(){ it.kill() }
            }
        }){
            init{
                description = "Kill 10000 units."
            }
        }
        
        cheesyPet = object : Achievement("cheesy-pet", "Cheesy Pet", {
            if(PermaVars.petCount > 0) it.unlock()
        }){
            init{
                description = "Pet the Cheesy-chan. [pink]qwq[]"
                icon = Utils.draw("ion-cheesy-chan")
            }
        }
        
        sk = object : Achievement("sk", "Sk", {
            if(Utils.checkMod("betamindy")) it.unlock()
        }){
            init{
                description = "[pink]Do the SK."
                icon = Utils.draw("ion-sk7725")
            }
        }
    }
}
