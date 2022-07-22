package ion.content

import ion.defs.Utils
import ion.game.Achievement
import ion.game.PermVars
import mindustry.Vars
import mindustry.gen.Groups

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
    lateinit var cheesyPet2: Achievement
    lateinit var cheesyPet3: Achievement
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
            if(PermVars.killCountCampaign >= 150) it.unlock()
        }){
            init{
                description = "Kill 150 units."
            }
        }
        
        killingSpree = object : Achievement("killing-spree", "Killing Spree", {
            if(PermVars.killCountCampaign >= 500) it.unlock()
        }){
            init{
                description = "Kill 500 units."
            }
        }
        
        unhinged = object : Achievement("unhinged", "Unhinged", {
            if(PermVars.killCountCampaign >= 2000) it.unlock()
        }){
            init{
                description = "Kill 2000 units."
            }
        }
        
        genocide = object : Achievement("genocide", "Genocide", {
            if(PermVars.killCountCampaign >= 10000){
                it.unlock()
                Vars.ui.showInfo("You're kind of a freak, you know that?")
                Groups.unit.each{ it.kill() }
                Groups.build.each{ it.kill() }
            }
        }){
            init{
                description = "Kill 10000 units."
            }
        }
        
        cheesyPet = object : Achievement("cheesy-pet", "Cheesy Pet", {
            if(PermVars.petCount >= 1) it.unlock()
        }){
            init{
                description = "Pet Cheesy-chan. [pink]qwq[]"
                icon = Utils.draw("ion-cheesy-chan", 1.3f)
            }
        }
        
        cheesyPet2 = object : Achievement("cheesy-pet-2", "Cheesy Pet 2", {
            if(PermVars.petCount >= 10){
                it.unlock()
                PermVars.messyHair = true
            }
        }){
            init{
                description = "Pet Cheesy-chan 10 times. [cyan]T~T[]"
                icon = Utils.draw("ion-cheesy-chan-sad", 1.3f)
            }
        }
        
        cheesyPet3 = object : Achievement("cheesy-pet-3", "Cheesy Pet 3", {
            if(PermVars.petCount >= 50) it.unlock()
        }){
            init{
                description = "Pet Cheesy-chan 50 times. [scarlet]>_<[]"
                icon = Utils.draw("ion-cheesy-chan", 1.3f)
            }
        }
        
        sk = object : Achievement("sk", "Sk", {
            if(Utils.checkMod("betamindy")) it.unlock()
        }){
            init{
                description = "[pink]Do the SK."
                icon = Utils.draw("ion-sk7725", 1.3f)
            }
        }
    }
}
