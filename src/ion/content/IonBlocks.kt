package ion.content

import mindustry.content.Items
import mindustry.type.*
import mindustry.world.Block
import mindustry.world.blocks.units.*
import mindustry.world.blocks.environment.*
import mindustry.world.blocks.production.*
import mindustry.world.blocks.units.UnitFactory.UnitPlan

import ion.content.IonItems
import mindustry.graphics.Layer.plans

object IonBlocks{
    //floors
    lateinit var oreZinc: Block
    //unit-based blocks
    lateinit var advancedAirFactory: Block
    lateinit var gonicReconstructor: Block
    lateinit var alephReconstructor: Block
    //factories
    lateinit var brassSmelter: Block
    
    fun load(){
        
        oreZinc = object : OreBlock("ore-zinc", IonItems.zinc){
            init{
                oreDefault = true
                oreThreshold = 0.846f
                oreScale = 24.927461f
            }
        }
        
        advancedAirFactory = object : UnitFactory("advanced-air-factory"){
            init{
                requirements(
                    Category.units, ItemStack.with(
                        Items.copper, 235,
                        Items.lead, 150,
                        Items.silicon, 80,
                        IonItems.zinc, 30
                    )
                )
                health = 450
                size = 3
                consumePower(2f)
                plans.addAll(
                    UnitPlan(
                        IonUnitTypes.orion, 20f * 60f, ItemStack.with(
                            Items.silicon, 10,
                            Items.titanium, 25,
                            IonItems.zinc, 5
                        )
                    )
                )
            }
        }
        
        gonicReconstructor = object : Reconstructor("gonic-reconstructor"){
            init{
                requirements(
                    Category.units, ItemStack.with(
                        Items.copper, 320,
                        Items.lead, 290,
                        Items.silicon, 120,
                        Items.titanium, 80,
                        IonItems.zinc, 55
                    )
                )
                health = 670
                size = 3
                consumePower(2.4f)
                consumeItems(
                    *ItemStack.with(
                        Items.lead, 30,
                        Items.titanium, 25,
                        Items.silicon, 45,
                        IonItems.zinc, 20
                    )
                )
                constructTime = 15 * 60f
                upgrades.add(arrayOf(IonUnitTypes.orion, IonUnitTypes.xender))
            }
        }
        
        alephReconstructor = object : Reconstructor("aleph-reconstructor"){
            init{
                requirements(
                    Category.units, ItemStack.with(
                        Items.lead, 460,
                        Items.metaglass, 120,
                        Items.silicon, 190,
                        Items.titanium, 330,
                        Items.thorium, 180,
                        IonItems.zinc, 60
                    )
                )
                health = 840
                size = 5
                consumePower(3.2f)
                consumeItems(
                    *ItemStack.with(
                        Items.graphite, 75,
                        Items.silicon, 85,
                        Items.titanium, 30,
                        IonItems.zinc, 35
                    )
                )
                upgrades.add(arrayOf(IonUnitTypes.xender, IonUnitTypes.astro))
            }
        }
        
        brassSmelter = object : GenericCrafter("brass-smelter"){
            init{
                requirements(Category.crafting, ItemStack.with(
                    Items.copper, 40,
                    Items.lead, 38,
                    Items.silicon, 20,
                    IonItems.zinc, 15
                ))
                health = 350
                size = 2
                craftTime = 60f
                outputItem = ItemStack.with(IonItems.brass, 1)
                consumePower(1.4f)
                consumeItems(
                    *ItemStack.with(
                        Items.copper, 2,
                        IonItems.zinc, 1,
                        Items.coal, 2
                    )
                )
            }
        }
    }
}
