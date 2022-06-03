package ion.content

import mindustry.content.Items
import mindustry.type.*
import mindustry.world.Block
import mindustry.world.blocks.units.*
import mindustry.world.blocks.units.UnitFactory.UnitPlan

import ion.content.IonItems

object IonBlocks {

    lateinit var geoEnergeticAirFactory: Block
    lateinit var gonicReconstructor: Block
    
    fun load() {
        geoEnergeticAirFactory = UnitFactory("geo-energetic-air-factory").apply{
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
        
        gonicReconstructor = Reconstructor("gonic-reconstructor").apply{
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
            upgrades.add(arrayOf(IonUnitTypes.orion, IonUnitTypes.xender))
        }
        
    }
}
