package ion.ui

import arc.Core
import arc.Core.app
import arc.util.*
import arc.util.io.*
import arc.files.*
import arc.math.Mathf
import mindustry.Vars.*
import mindustry.ui.*
import mindustry.gen.*

import ion.content.*

object IonSettings{
    
    val tmpDir = Fi("/storage/emulated/0/IonTmp/Ion.jar")
    
    fun load(){
        ui.settings.addCategory("Ion: Global", Icon.right){
            
            it.checkPref("Effect Reduction", false){
                Core.settings.put("effectreduction", it)
            }
            
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
            
            it.button("Update"){
                ui.loadfrag.show("Updating Ion...")
                Http.get("https://github.com/TeamNeiaron/IonBuilds/releases/latest/download/Ion.jar"){
                    Streams.copyProgress(it.getResultAsStream(), tmpDir.write(false), it.getContentLength(), 4096){69f}
                    mods.importMod(tmpDir)
                
                    ui.loadfrag.hide()
                    ui.showInfo("Ion mod file updated. You may restart the game now.")
                }
            }.margin(14).width(240f).pad(6)
        }
        
        ui.settings.addCategory("Ion: Units", Icon.right){
            
            it.sliderPref("Xeus Line Effect Count", 10, 0, 100, 1){
                Core.settings.put("xeuslinecount", it)
                
                "$it"
            }
            
            it.sliderPref("Xeus Line Effect Slowness", 10, 1, 150, 1){
                Core.settings.put("xeuslineeffectslowness", it.toFloat())
                
                "$it"
            }
            
            it.sliderPref("Xeus Line Effect Count Multiplier", 1, 1, 30, 1){
                Core.settings.put("xeuslineeffectmultiplier", it)
                
                "x$it"
            }
            
            it.sliderPref("Xeus Line Effect Spacing Multiplier", 1, 1, 120, 1){
                Core.settings.put("xeuslineeffectspacing", it.toFloat())
                
                "x$it"
            }
        }
    }
}
