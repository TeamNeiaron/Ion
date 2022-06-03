package ion;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.ui.dialogs.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.game.EventType.*;

import ion.ui.*;
import ion.content.*;

import static mindustry.Vars.*;

public class Ion extends Mod{
    
    public Ion(){
        Log.infoTag("ILoad", "Main Ion constructor triggered.");
        Events.on(ClientLoadEvent.class, ev -> {
            ISettings.load();
        });
    }
    
    @Override
    public void loadContent(){
        IonBullets.load();
        IonUnitTypes.load();
        IonItems.load();
        IonBlocks.load();
    }
}
