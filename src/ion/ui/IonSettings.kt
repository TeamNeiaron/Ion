package ion.ui

import arc.Core
import arc.Core.app
import arc.files.Fi
import arc.math.Mathf
import arc.util.Log
import arc.util.Threads
import arc.util.Time
import com.github.mnemotechnician.mkui.extensions.dsl.textButton
import ion.IonVars
import ion.defs.Utils
import ion.game.PermaVars
import mindustry.Vars.*
import mindustry.gen.Icon
import mindustry.gen.Sounds

@Suppress("SpellCheckingInspection")
object IonSettings{
    
    val tmpDir: Fi = Core.settings.dataDirectory.child("ion.jar")

    fun load(){
        
        ui.settings.addCategory("Ion", Icon.right){ it ->

            it.sliderPref("Updater Timeout Threshold", 30, 1, 120, 5){
                Core.settings.put("updatertimeout", it.toFloat())
                
                "$it seconds"
            }
            /*
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
            */
            it.checkPref("Effect Reduction", false){
                Core.settings.put("effectreduction", it)
            }
            
            it.textPref("Input", "..."){
                when(it){
                    "horny" -> app.exit()
                    
                    "amogus" -> ui.showInfo("sugosmu garitesu")
                    
                    "seq" -> {
                        val waitLength = Mathf.random(600f)
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
                    
                    "pet the cheesy-chan" -> ui.showConfirm("Question","Do so?"){
                        if(PermaVars.messyHair){
                            if(PermaVars.suspensive){
                                ui.showInfo("Cheesy-chan has been pet.\nHer hair is all messy now.\n\nI'll be more than just a mere \"pet\"...")
                                PermaVars.messyHair = false
                                PermaVars.petCount += 1
                            } else {
                                ui.showInfo("Cheesy-chan has been pet.\nHer hair is all messy now.\nShe is now sad. Do something about it.")
                                PermaVars.messyHair = false
                                PermaVars.petCount += 1
                            }
                        } else {
                            ui.showInfo("Cheesy-chan has been pet.")
                            PermaVars.petCount += 1
                        }
                    }
                    
                    "smiler" -> Utils.getAndWrite("https://cdn.discordapp.com/emojis/935868190012092466.png", Core.settings.dataDirectory.child("sussmiler.png"), true){}
                    
                    "test unlocker" -> IonVars.achievementUnlocker.show()
                    
                    "darkness" -> IonVars.secret.show(tree["texts/darkness.txt"].readString(), false)
                    
                    "cheesy" -> Utils.cheese()
                    
                    "smorekeys" -> Threads.throwAppException(RuntimeException("to hell with you"))
                    
                    "explosion" -> Sounds.explosionbig.play(1984f) //well time to delete my ears
                    
                    "reset" -> IonVars.secret.show(tree["texts/change.txt"].readString(), true)
                    
                    "time to be sussy" -> PermaVars.suspensive = true
                }
            }
            
            it.row()
            
            it.textButton("Update\n(Do not spam!)", wrap = false){
                Utils.getAndWrite("https://github.com/TeamNeiaron/IonBuilds/releases/latest/download/Ion.jar", tmpDir, true){
                    mods.importMod(it)
                    it.delete()
                    ui.showInfoOnHidden("@info.mod-imported"){ app.exit() }
                }
            }.row()
            
            it.textButton("Achievements", wrap = false){
                IonVars.achievementList.show()
            }.row()
            
            it.textButton("Stats", wrap = false){
                IonVars.stats.show()
            }.row()
        }
    }
}
