package ion.content

import arc.struct.Seq
import mindustry.content.Blocks
import mindustry.content.Items
import mindustry.content.TechTree
import mindustry.content.TechTree.TechNode
import mindustry.content.UnitTypes
import mindustry.ctype.UnlockableContent
import mindustry.game.Objectives.*
import mindustry.type.ItemStack

object IonTechTree {
    var context: TechNode? = null
    fun load() {
        margeNode(Blocks.siliconSmelter){
            node(IonBlocks.brassSmelter, Seq.with(Research(IonItems.zinc))){}
            node(IonBlocks.zincCondenser)
        }
        margeNode(Items.copper){
            node(IonItems.zinc, Seq.with(Produce(IonItems.zinc))){}
            node(IonItems.stone, Seq.with(Produce(IonItems.stone))){
                node(
                    IonItems.petrifiedCore,
                    Seq.with(Produce(IonItems.petrifiedCore))
                ){}
            }
        }
        margeNode(Blocks.pneumaticDrill){
            node(IonBlocks.stoneDrill, Seq.with(Research(Blocks.pneumaticDrill))){
                node(
                    IonBlocks.slagSolidifier,
                    Seq.with(Produce(IonItems.stone))
                ){ node(IonBlocks.petrifiedCoreConstructor, Seq.with(Research(IonBlocks.stoneDrill))){} }
            }
        }
        margeNode(Blocks.cyclone){
            node(
                IonBlocks.defunction,
                Seq.with(Produce(IonItems.stone))
            ){ node(IonBlocks.eorphosia, Seq.with(Produce(IonItems.petrifiedCore))){} }
        }
        margeNode(Blocks.airFactory){
            node(IonBlocks.advancedAirFactory){
                node(
                    IonBlocks.gonicReconstructor,
                    Seq.with(Research(Blocks.additiveReconstructor), Research(IonItems.zinc))
                ){
                    node(
                        IonBlocks.alephReconstructor,
                        Seq.with(Research(IonBlocks.gonicReconstructor))
                    ){
                        node(
                            IonBlocks.titanReconstructor,
                            Seq.with(Research(IonBlocks.alephReconstructor))
                        ){ node(IonBlocks.colossalReconstructor, Seq.with(Research(IonBlocks.titanReconstructor))){} }
                    }
                }
            }
        }
        margeNode(UnitTypes.flare){
            node(
                IonUnitTypes.orion,
                Seq.with(Research(IonItems.zinc))
            ){
                node(IonUnitTypes.xender, Seq.with(Research(IonUnitTypes.orion))){
                    node(
                        IonUnitTypes.astro,
                        Seq.with(Research(IonUnitTypes.xender))
                    ){
                        node(IonUnitTypes.geometry, Seq.with(Research(IonUnitTypes.astro))){
                            node(
                                IonUnitTypes.xeus,
                                Seq.with(Research(IonUnitTypes.geometry))
                            )
                        }
                    }
                }
            }
        }
        margeNode(UnitTypes.flare){
            node(
                IonUnitTypes.caretaker,
                Seq.with(Research(IonItems.zinc))
            ){
                node(IonUnitTypes.leader, Seq.with(Research(IonUnitTypes.caretaker))) {
                    node(
                        IonUnitTypes.hive,
                        Seq.with(Research(IonUnitTypes.leader))
                    ){}
                }
            }
        }
    }

    private fun margeNode(parent: UnlockableContent, orphan: Runnable){
        context = TechTree.all.find { t: TechNode -> t.content === parent }
        orphan.run() /* kill() */
    }

    private fun node(
        content: UnlockableContent,
        requirements: Array<ItemStack>,
        objectives: Seq<Objective>?,
        children: Runnable
    ){
        val node = TechNode(context, content, requirements)
        if (objectives != null) node.objectives = objectives
        val prev = context
        context = node
        children.run()
        context = prev
    }

    private fun node(content: UnlockableContent, requirements: Array<ItemStack>, children: Runnable){
        node(content, requirements, null, children)
    }

    private fun node(content: UnlockableContent, objectives: Seq<Objective>, children: Runnable = Runnable {}){
        node(content, content.researchRequirements(), objectives, children)
    }

    private fun node(content: UnlockableContent, children: Runnable){
        node(content, content.researchRequirements(), children)
    }

    private fun node(block: UnlockableContent){
        node(block){}
    }
}