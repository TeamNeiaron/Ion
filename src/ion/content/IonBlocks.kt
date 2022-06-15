package ion.content

import mindustry.content.*
import mindustry.gen.*
import mindustry.type.*
import mindustry.world.Block
import mindustry.world.draw.*
import mindustry.world.blocks.units.*
import mindustry.world.blocks.defense.turrets.*
import mindustry.world.blocks.environment.*
import mindustry.world.blocks.production.*
import mindustry.world.blocks.units.UnitFactory.UnitPlan
import mindustry.entities.bullet.*
import mindustry.entities.pattern.*

import mindustry.graphics.Layer.*

import ion.defs.*
import ion.content.*

object IonBlocks{
    
    //floors
    lateinit var oreZinc: Block
    //unit-based blocks
    lateinit var advancedAirFactory: Block
    lateinit var gonicReconstructor: Block
    lateinit var alephReconstructor: Block
    lateinit var titanReconstructor: Block
    lateinit var colossalReconstructor: Block

    //factories
    lateinit var brassSmelter: Block
    lateinit var slagSolidifier: Block

    //defense
    lateinit var eorphosia: Block
    
    
    fun load(){
        
        //region ores
        oreZinc = object : OreBlock("ore-zinc", IonItems.zinc){
            init{
                oreDefault = true
                oreThreshold = 0.846f
                oreScale = 24.927461f
            }
        }
        
        //endregion ores
        //region units
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
                size = 4
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
                size = 4
                consumePower(2.4f)
                consumeItems(
                    *ItemStack.with(
                        Items.thorium, 55,
                        Items.silicon, 80,
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
                size = 6
                consumePower(3.2f)
                consumeItems(
                    *ItemStack.with(
                        Items.graphite, 145,
                        Items.silicon, 250,
                        Items.plastanium, 250,
                        IonItems.zinc, 120
                    )
                )
                constructTime = 30 * 60f
                upgrades.add(arrayOf(IonUnitTypes.xender, IonUnitTypes.astro))
            }
        }

        titanReconstructor = object : Reconstructor("titan-reconstructor"){
            init{
                requirements(
                    Category.units, ItemStack.with(
                        Items.lead, 780,
                        Items.silicon, 850,
                        Items.thorium, 950,
                        IonItems.zinc, 850,
                        Items.graphite, 770,
                        Items.surgeAlloy, 350
                    )
                )
                health = 1520
                size = 8
                consumePower(3.2f)
                consumeItems(
                    *ItemStack.with(
                        Items.titanium, 850,
                        Items.silicon, 980,
                        Items.plastanium, 730,
                        IonItems.zinc, 730,
                        Items.thorium, 980
                    )
                )
                constructTime = 38 * 60f
                upgrades.add(arrayOf(IonUnitTypes.astro, IonUnitTypes.geometry))
            }
        }

        colossalReconstructor = object : Reconstructor("colossal-reconstructor"){
            init{
                requirements(
                    Category.units, ItemStack.with(
                        Items.graphite, 1200,
                        Items.silicon, 1800,
                        Items.thorium, 990,
                        IonItems.zinc, 1150,
                        Items.plastanium, 1200,
                        Items.surgeAlloy, 780
                    )
                )
                health = 2000
                size = 10
                consumePower(3.2f)
                consumeItems(
                    *ItemStack.with(
                        Items.silicon, 1800,
                        IonItems.zinc, 1100,
                        Items.surgeAlloy, 950,
                        Items.titanium, 850,
                        Items.plastanium, 1200
                    )
                )
                constructTime = 45 * 60f
                upgrades.add(arrayOf(IonUnitTypes.geometry, IonUnitTypes.xeus))
            }
        }
        
        //endregion units
        //region factories
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
                craftEffect = Fx.smeltsmoke
                outputItem = ItemStack(IonItems.brass, 1)
                consumePower(1.4f)
                consumeItems(
                    *ItemStack.with(
                        Items.copper, 2,
                        IonItems.zinc, 1,
                        Items.coal, 1
                    )
                )
            }
        }

        slagSolidifier = object : GenericCrafter("slag-solidifier"){
            init{
                requirements(Category.crafting, ItemStack.with(
                    Items.copper, 50,
                    Items.lead, 80,
                ))
                health = 450
                size = 3
                craftTime = 60f
                craftEffect = Fx.smeltsmoke
                outputItem = ItemStack(IonItems.stone, 4)
                consumePower(0.6f)
                consumeLiquid(Liquids.slag, 0.5f)
                
                drawer = DrawMulti(
                DrawRegion("-bottom"),
                DrawLiquidTile(Liquids.slag, 0f),
                DrawBubbles(Liquids.slag.color.cpy()),
                DrawDefault()
                )
            }
        }
        
        //endregion factories
        //region defense
        eorphosia = object : PowerTurret("eorphosia"){
            init{
                requirements(Category.turret, ItemStack.with(
                    Items.copper, 1 //todo
                ))
                health = 5550
                size = 5
                reload = 480f
                range = 440f
                rotateSpeed = 1.3f
                inaccuracy = 25f
                recoil = 5f
                shootSound = Sounds.artillery
                velocityRnd = 0.25f
                moveWhileCharging = false
                shoot.shots = 15
                shoot.firstShotDelay = IonFx.ptCharge.lifetime
                consumePower(16.5f)
                shootType = IonBullets.petrifierBullet
            }
        }
    }
}
