package ion

import arc.Events
import arc.util.Log
import ion.content.*
import ion.hiearchy.yellow.content.YellowBullets
import ion.hiearchy.yellow.content.YellowUnitTypes
import ion.hiearchy.yellow.content.YellowWeapons
import ion.hiearchy.yellow.ui.WeaponSwitchButton
import ion.misc.Utils
import ion.ui.ControlButton
import ion.ui.IonSettings
import mindustry.Vars
import mindustry.game.EventType.ClientLoadEvent
import mindustry.game.EventType.FileTreeInitEvent
import mindustry.mod.Mod

class Ion : Mod(){
    
    init{
        Log.info("Loaded main Ion class.")
        Events.on(ClientLoadEvent::class.java){
            IonAchievements.load()
            IonVars.load()
            IonSettings.load()
            
            val control = ControlButton()
            val wps = WeaponSwitchButton()
            control.build(Vars.ui.hudGroup)
            wps.build(Vars.ui.hudGroup)
            
            Vars.mods.scripts.runConsole(Vars.tree["scripts/http.js"].readString())
            Vars.mods.scripts.runConsole(Vars.tree["scripts/core.js"].readString())
            Vars.mods.scripts.runConsole(Vars.tree["scripts/core2.js"].readString())
        }
        
        Events.on(FileTreeInitEvent::class.java){
            Vars.mods.getMod("ion").meta.description = Vars.tree["texts/desc.txt"].readString()
        }
    }
    override fun loadContent(){
        IonItems.load()
        IonStatusEffects.load()
        IonBullets.load()
        IonUnitTypes.load()
        IonBlocks.load()
        IonTechTree.load()
        YellowBullets.load()
        YellowWeapons.load()
        YellowUnitTypes.load()

        Utils.mirrorWeapons(arrayOf(YellowWeapons.meltdownBurst, YellowWeapons.decimator, YellowWeapons.mothRepellant, YellowWeapons.airstrikeSummoner), YellowUnitTypes.yellow)
    }
}
