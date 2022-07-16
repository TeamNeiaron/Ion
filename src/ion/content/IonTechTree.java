package ion.content;

import arc.struct.Seq;
import mindustry.ctype.UnlockableContent;
import mindustry.game.Objectives.Objective;
import mindustry.game.Objectives.Produce;
import mindustry.game.Objectives.Research;
import mindustry.type.ItemStack;

import static mindustry.content.Blocks.*;
import static mindustry.content.Items.copper;
import static mindustry.content.TechTree.TechNode;
import static mindustry.content.TechTree.all;
import static mindustry.content.UnitTypes.flare;

public class IonTechTree{
    static TechNode context = null;
    
    public static void load(){
        margeNode(siliconSmelter, () -> {
            node(IonBlocks.brassSmelter, Seq.with(new Research(IonItems.zinc)), () -> {});
            node(IonBlocks.zincCondenser);
        });
        
        margeNode(copper, () -> {
            node(IonItems.zinc, Seq.with(new Produce(IonItems.zinc)), () -> {});
            node(IonItems.stone, Seq.with(new Produce(IonItems.stone)), () -> {
                node(IonItems.petrifiedCore, Seq.with(new Produce(IonItems.petrifiedCore)), () -> {
                });
            });
        });

        margeNode(pneumaticDrill, () -> {
            node(IonBlocks.stoneDrill, Seq.with(new Research(pneumaticDrill)), () -> {
                node(IonBlocks.slagSolidifier, Seq.with(new Produce(IonItems.stone)), () -> {
                    node(IonBlocks.petrifiedCoreConstructor, Seq.with(new Research(IonBlocks.stoneDrill)), () -> {});
                });
            });
        });

        margeNode(cyclone, () -> {
            node(IonBlocks.defunction, Seq.with(new Produce(IonItems.stone)), () -> {
                node(IonBlocks.eorphosia, Seq.with(new Produce(IonItems.petrifiedCore)), () -> {
                });
            });
        });

        margeNode(airFactory, () -> {
            node(IonBlocks.advancedAirFactory, () -> {
                node(IonBlocks.gonicReconstructor, Seq.with(new Research(additiveReconstructor), new Research(IonItems.zinc)), () -> {
                    node(IonBlocks.alephReconstructor, Seq.with(new Research(IonBlocks.gonicReconstructor)), () -> {
                        node(IonBlocks.titanReconstructor, Seq.with(new Research(IonBlocks.alephReconstructor)), () -> {
                            node(IonBlocks.colossalReconstructor, Seq.with(new Research(IonBlocks.titanReconstructor)), () -> {});
                        });
                    });
                });
            });
        });

        margeNode(flare, () -> {
            node(IonUnitTypes.orion, Seq.with(new Research(IonItems.zinc)), () -> {
                node(IonUnitTypes.xender, Seq.with(new Research(IonUnitTypes.orion)),() -> {
                    node(IonUnitTypes.astro, Seq.with(new Research(IonUnitTypes.xender)),() -> {
                        node(IonUnitTypes.geometry, Seq.with(new Research(IonUnitTypes.astro)),() -> {
                            node(IonUnitTypes.xeus, Seq.with(new Research(IonUnitTypes.geometry)));
                        });
                    });
                });
            });
        });

        margeNode(flare, () -> {
            node(IonUnitTypes.caretaker, Seq.with(new Research(IonItems.zinc)), () -> {
                node(IonUnitTypes.leader, Seq.with(new Research(IonUnitTypes.caretaker)),() -> {
                    node(IonUnitTypes.hive, Seq.with(new Research(IonUnitTypes.leader)),() -> {});
                });
            });
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

    private static void node(UnlockableContent content, Seq<Objective> objectives){
        node(content, objectives, () -> {});
    }

    private static void node(UnlockableContent content, Runnable children){
        node(content, content.researchRequirements(), children);
    }

    private static void node(UnlockableContent block){
        node(block, () -> {});
    }
}
