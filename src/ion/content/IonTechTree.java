package ion.content;

import arc.struct.*;
import mindustry.type.*;
import mindustry.game.Objectives.*;
import mindustry.ctype.*;
import ion.content.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.TechTree.*;

public class IonTechTree{
    static TechNode context = null;
    
    public static void load(){
        margeNode(siliconSmelter, () -> {
            node(IonBlocks.brassSmelter);
        });


    }
    
    private static void margeNode(UnlockableContent parent, Runnable orphan){
        context = all.find(t -> t.content == parent);
        orphan.run(); /* kill() */
    }
    
    private static void node(UnlockableContent content, ItemStack[] requirements, Seq<Objective> objectives, Runnable children){
        TechNode node = new TechNode(context, content, requirements);
        if(objectives != null) node.objectives = objectives;

        TechNode prev = context;
        context = node;
        children.run();
        context = prev;
    }

    private static void node(UnlockableContent content, ItemStack[] requirements, Runnable children){
        node(content, requirements, null, children);
    }

    private static void node(UnlockableContent content, Seq<Objective> objectives, Runnable children){
        node(content, content.researchRequirements(), objectives, children);
    }

    private static void node(UnlockableContent content, Runnable children){
        node(content, content.researchRequirements(), children);
    }

    private static void node(UnlockableContent block){
        node(block, () -> {});
    }
}
