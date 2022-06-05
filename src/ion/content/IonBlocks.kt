package ion.content

import mindustry.content.Items
import mindustry.type.*
import mindustry.world.Block
import mindustry.world.blocks.units.*
import mindustry.world.blocks.units.UnitFactory.UnitPlan

import ion.content.IonItems
import mindustry.graphics.Layer.plans

object IonBlocks{

    lateinit var geoEnergeticAirFactory: Block
    lateinit var gonicReconstructor: Block
    lateinit var alephReconstructor: Block
    
    fun load(){
        geoEnergeticAirFactory = object : UnitFactory("geo-energetic-air-factory"){
            init{
                requirements(
                    Category.units, ItemStack.with(
                        Items.lead, 550,
                        Items.silicon, 80,
                        Items.metaglass, 80,
                        Items.titanium, 250,
                        IonItems.zinc, 30
                    )
                )
                health = 450
                size = 3
                consumePower(2f)
                plans.addAll(
                    UnitPlan(
                        IonUnitTypes.orion, 20f * 60, ItemStack.with(
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
                        Items.copper, 570,
                        Items.lead, 480,
                        Items.silicon, 95,
                        Items.titanium, 300,
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
                        Items.lead, 520,
                        Items.metaglass, 100,
                        Items.silicon, 230,
                        Items.titanium, 430,
                        Items.thorium, 240,
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
    }
}
