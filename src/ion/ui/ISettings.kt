package ion.ui

import arc.Core
import arc.Core.app
import arc.util.*
import arc.math.Mathf
import mindustry.Vars.*
import mindustry.gen.*

object ISettings{
    fun load(){
        ui.settings.addCategory("Ion", Icon.right){
            it.textPref("Input", "..."){
                when(it){
                    "horny" -> app.exit()
                    
                    "amogus" -> ui.showInfo("sugosmu garitesu")
                    
                    "seq" -> {
                        var waitLength = Mathf.random(600f)
                        ui.loadfrag.show("""
                            seqs uwu
                            wait ${waitLength / 60f} seconds...
                        """.trimIndent())
                        Time.runTask(waitLength) { ui.loadfrag.hide() }
                    }
                    
                    "screw you 192.168.1.34" -> Sounds.wind3.play(Mathf.random(200f))
                    
                    "how do i pronounce mindustry" -> ui.showInfo(tree["texts/methods.txt"].readString())
                    
                    "plus one" -> Log.warn("angry cheesy-chan noises")
                    
                    "tantos" -> Threads.throwAppException(RuntimeException(tree["texts/tantos.txt"].readString()))
                    
                    "pet the cheesy-chan" -> ui.showConfirm("Question","have you gotten [accent]consent[]?") { ui.showInfo("the cheesy-chan has been pet.") }
                }
            }
            
            it.checkPref("Effect Reduction", false){
                Core.settings.put("effectreduction", it)
            }
            
            it.sliderPref("Xeus Line Count", 10, 0, 100, 1) : Int{
                Core.settings.put("xeuslinecount", it)
            }
        }
    }
}
