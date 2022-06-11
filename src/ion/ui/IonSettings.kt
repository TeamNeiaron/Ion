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

import ion.game.*
import ion.content.*

import com.github.mnemotechnician.mkui.*

object IonSettings{
    
    val tmpDir = Core.settings.getDataDirectory().child("IonT.jar")
    var importing = false
    var errored = false
    
    fun load(){
        ui.settings.addCategory("Ion: Global", Icon.right){
            
            it.sliderPref("Updater Timeout Threshold", 30, 1, 120, 5){
                Core.settings.put("updatertimeout", it.toFloat())
                
                "$it seconds"
            }
            
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
            
            it.row()
            
            it.textButton("Update", wrap = false){
                importing = true
                errored = false
                ui.loadfrag.show("Updating Ion...\n(Automatic timeout after ${Core.settings.getFloat("updatertimeout")} seconds)")
                Http.get("https://github.com/TeamNeiaron/IonBuilds/releases/latest/download/Ion.jar"){
                    Streams.copyProgress(it.getResultAsStream(), tmpDir.write(false), it.getContentLength(), 4096){69f}
                    
                    if(!errored){
                        try{
                            mods.importMod(tmpDir)
                        } catch (e: Throwable){
                            ui.showException(e)
                            importing = false
                            ui.loadfrag.hide()
                            errored = true
                        }
                        importing = false
                        ui.loadfrag.hide()
                        ui.showInfo("Ion mod file updated. You may restart the game now.")
                    }
                }
                
                Time.runTask(Core.settings.getFloat("updatertimeout") * 60f){
                    if(importing){
                        ui.loadfrag.hide()
                        ui.showErrorMessage("Download failed. Check your internet connection or download from the IonBuilds repo directly.")
                        importing = false
                        errored = true
                    }
                }
            }.row()
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
