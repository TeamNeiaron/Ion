package ion

import arc.*
import arc.util.*
import arc.func.*
import mindustry.*
import mindustry.content.*
import mindustry.game.EventType.*
import mindustry.mod.*
import mindustry.ui.dialogs.*

import ion.ui.*
import ion.content.*


class Ion : Mod(){
    
    init{
        Log.info("Loaded main Ion class.")
        Events.on(ClientLoadEvent::class.java){
            IonSettings.load()
            Vars.mods.getMod("ion").meta.description = Vars.tree["texts/desc.txt"].readString()
            
            Vars.mods.getScripts().runConsole(Vars.tree["scripts/http.js"].readString())
        }
    }
    
    
    override fun loadContent(){
        IonItems.load()
        IonStatusEffects.load()
        IonBullets.load()
        IonUnitTypes.load()
        IonBlocks.load()
        IonTechTree.load()
    }
}
