package ion

import arc.*
import arc.util.*
import arc.func.*
import mindustry.*
import mindustry.game.EventType.*
import mindustry.mod.*
import mindustry.ui.dialogs.*

import ion.ui.*
import ion.content.*


fun Vars.amogus(sus: String) = {
    Log.info(sus)
}

class Ion : Mod(){
    
    init{
        Log.infoTag("ILoad", "Loaded main Ion class.")
        Events.on(ClientLoadEvent::class.java){
            ISettings.load()
        }
    }
    
    
    override fun loadContent(){
        IonItems.load()
        IonBullets.load()
        IonUnitTypes.load()
        IonBlocks.load()
        Vars.amogus("load")
    }
}
