package ion.ui

import arc.Core.app
import mindustry.Vars.ui
import mindustry.gen.Icon

object ISettings{
    fun load(){
        ui.settings.addCategory("Ion", Icon.right){
            it.textPref("Input", "..."){
                when(it){
                    "horny" -> app.exit()
                    
                    "plus one" -> ui.showInfo("[red]angry cheesy-chan noises[]")
                    "pet the cheesy-chan" -> ui.showConfirm("Question", "Have you gotten [accent]consent[]?"){ ui.showInfo("the cheesy-chan has been pet.") }
                }
            }
        }
    }
}
