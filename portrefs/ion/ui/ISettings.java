package ion.ui;

import arc.*;
import arc.util.*;
import arc.math.*;
import mindustry.*;
import mindustry.gen.*;

import static arc.Core.*;
import static mindustry.Vars.*;

public class ISettings{
    private static float waitLength;
    
    public static void load(){
        ui.settings.addCategory("Ion", stable -> {
            stable.textPref("Input", "...", s1 -> {
                switch(s1){
                    case "horny":
                        app.exit();
                    break;
                    
                    case "amogus":
                        ui.showInfo("sugosmu garitesu");
                    break;
                    
                    case "seq":
                        waitLength = Mathf.random(600f);
                        ui.loadfrag.show("seqs uwu\nwait " + (waitLength / 60f) + " seconds...");
                        Time.runTask(waitLength, () -> ui.loadfrag.hide());
                    break;
                    
                    case "screw you 192.168.1.34":
                        Sounds.wind3.play(Mathf.random(200f));
                    break;
                    
                    case "how do i pronounce mindustry":
                        ui.showInfo(tree.get("texts/methods.txt").readString());
                    break;
                    
                    case "plus one":
                        Log.warn("angry cheesy-chan noises");
                    break;
                    
                    case "tantos":
                        Threads.throwAppException(new RuntimeException(tree.get("texts/tantos.txt").readString()));
                    break;
                    
                    case "pet the cheesy-chan":
                        ui.showConfirm("Question", "have you gotten [accent]consent[]?", () -> ui.showInfo("the cheesy-chan has been pet."));
                    break;
                }
            });
        });
    }
}
