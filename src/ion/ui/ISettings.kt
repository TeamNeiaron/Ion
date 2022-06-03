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
                }
            }
        }
    }
}
