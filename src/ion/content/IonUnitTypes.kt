package ion.content

import arc.*
import arc.util.*
import arc.func.*
import arc.math.*
import arc.graphics.*
import arc.graphics.g2d.*
import arc.math.geom.Circle
import mindustry.gen.*
import mindustry.type.*
import mindustry.type.unit.*
import mindustry.type.weapons.*
import mindustry.game.*
import mindustry.content.*
import mindustry.graphics.*
import mindustry.entities.part.*
import mindustry.entities.bullet.*
import mindustry.entities.pattern.*

import ion.defs.*
import ion.type.weapons.*
import ion.content.*
import ion.entities.bullet.*
import ion.entities.abilities.*
import mindustry.entities.abilities.RepairFieldAbility
import mindustry.entities.abilities.UnitSpawnAbility
import mindustry.gen.Unit

object IonUnitTypes{

    //geom
    lateinit var orion: UnitType
    lateinit var xender: UnitType
    lateinit var astro: UnitType
    lateinit var geometry: UnitType
    lateinit var xeus: UnitType
    lateinit var erea: UnitType

    //caretakers
    lateinit var caretaker: UnitType
    lateinit var leader: UnitType
    lateinit var hive: UnitType
    lateinit var commander: UnitType

    fun load(){
        orion = object : UnitType("orion"){
            init{
                flying = true
                health = 290f
                speed = 3.62f
                accel = 0.15f
                drag = 0.05f
                engineOffset = 7f
                hitSize = 13f

                constructor = Prov<mindustry.gen.Unit> { UnitEntity.create() }


                weapons.add(
                    object : Weapon("orion-arc"){
                        init{
                            x = 0f
                            y = 0f
                            reload = 40f
                            mirror = false
                            shootSound = Sounds.spark
                            shoot.shots = 2
                            bullet = object : LightningBulletType(){
                                init{
                                    damage = 14f
                                    lightningColor = IColor.energy
                                    lightningLength = 19
                                }
                            }
                        }
                    }
                )
            }
        }

        xender = object : UnitType("xender"){
            init{
                flying = true
                health = 740f
                armor = 4.2f
                speed = 2.7f
                accel = 0.2f
                drag = 0.09f
                engineSize = 3.7f
                engineOffset = 9f
                hitSize = 16f

                constructor = Prov<mindustry.gen.Unit> { UnitEntity.create() }


                weapons.add(
                    object : Weapon("xender-lancer"){
                        init{
                            reload = 95f
                            x = 0f
                            y = -4.3f
                            mirror = false
                            shootStatusDuration = 5f;
                            shoot = ShootSpread(2, 2f)
                            bullet = object : LaserBulletType(34f){
                                init{
                                    length = 152f
                                    width = 5f
                                }
                            }
                        }
                    }
                )
            }
        }

        astro = object : UnitType("astro"){
            init{
                flying = true
                health = 1030f
                armor = 7.8f
                speed = 1.6f
                accel = 0.1f
                drag = 0.08f
                engineSize = 6f
                engineOffset = 17f
                hitSize = 27f
                rotateSpeed = 3f

                constructor = Prov<mindustry.gen.Unit> { UnitEntity.create() }


                weapons.add(
                    object : Weapon("electric-orb-launcher"){
                        init{
                            x = 0f
                            reload = 180f
                            mirror = false
                            shootSound = Sounds.laser
                            shoot.shots = 3
                            shoot.shotDelay = 20f
                            bullet = IonBullets.energyOrbBullet
                        }
                    }
                )
            }
        }

        geometry = object : UnitType("geometry"){
            init{
                flying = true
                health = 9850f
                armor = 13.5f
                speed = 0.9f
                accel = 0.4f
                drag = 0.07f
                engineSize = 7f
                engineOffset = 22f
                hitSize = 33f
                rotateSpeed = 2f

                constructor = Prov<mindustry.gen.Unit> { UnitEntity.create() }


                weapons.add(
                    object : Weapon("geo-launcher"){
                        init{
                            x = 0f
                            reload = 258f
                            mirror = false
                            shoot = ShootSpread(8, 2.3f)
                            shootSound = Sounds.laser
                            shoot.firstShotDelay = IonFx.geometryCharge.lifetime
                            shoot.shotDelay = 6f
                            bullet = IonBullets.geometricBullet
                        }
                    }
                )
            }
        }

        xeus = object : UnitType("xeus"){
            init{
                flying = true
                lowAltitude = true
                health = 25380f
                armor = 18f
                speed = 0.65f
                accel = 0.45f
                drag = 0.06f
                engineSize = 9f
                engineOffset = 26f
                hitSize = 47f
                rotateSpeed = 0.8f

                constructor = Prov<mindustry.gen.Unit> { UnitEntity.create() }

                parts.add(
                    object : HaloPart(){
                        init{
                            x = 15f
                            y = 0f
                            mirror = true
                            hollow = true
                            sides = 5
                            radius = 6.7f
                            stroke = 1.67f
                            haloRotateSpeed = 1.3f
                            colorTo = IColor.energy
                            layer = Layer.effect
                        }
                    }
                )

                weapons.add(
                    object : Weapon("energy-laser"){
                        init{
                            x = 0f
                            y = -7f
                            reload = 660f
                            mirror = false
                            continuous = true
                            shootSound = Sounds.beam
                            shoot.firstShotDelay = IonFx.chargeEffect.lifetime
                            bullet = IonBullets.xeusLaser
                            shootStatusDuration = 140f;
                            shootStatus = StatusEffects.unmoving
                        }
                    }, object : SpinnyWeapon("geo-caller"){
                        init{
                            x = 9f
                            y = 4f
                            reload = 10f
                            top = true
                            mirror = true
                            shootSound = Sounds.laser
                            shoot = ShootSpread(5, 72f)
                            bullet = IonBullets.miniGeometricBullet
                        }
                    }
                )
            }
            
            override fun draw(unit: mindustry.gen.Unit){
                super.draw(unit)
                /*
                var s = Mathf.absin(15f, 3f)
                var slowness = Core.settings.getFloat("xeuslineeffectslowness")
                var spacing = Core.settings.getFloat("xeuslineeffectspacing")
                var mul = Core.settings.getInt("xeuslineeffectmultiplier")
                
                Lines.stroke(2.3f)
                Draw.color(IColor.energy)
                Draw.z(Layer.effect)
                
                Fill.circle(unit.x, unit.y, 6f + s)
                
                for(sus in 1..Core.settings.getInt("xeuslinecount")){
                    var i = sus.toFloat()
                    Lines.spikes(unit.x, unit.y, i * spacing, 13f + s, mul, Time.time * i / slowness)
                    Lines.spikes(unit.x, unit.y, i * spacing, 13f + s, mul, 180f - -Time.time * i / slowness)
                }
                
                Lines.circle(unit.x, unit.y, 15f + s)
                if(!Core.settings.getBool("effectreduction")){
                    Fill.light(unit.x, unit.y, 4, 35f + Mathf.absin(20f, 25f), IColor.energy, Color.clear)
                }
                
                Draw.color()
                Lines.stroke(1f)
                */
                
                
            }
        }

        erea = object : UnitType("erea"){
            init{
                flying = true
                health = 42825f
                armor = 23f
                speed = 0.58f
                accel = 0.35f
                drag = 0.04f
                engineSize = 20f
                engineOffset = 47f
                hitSize = 76f
                rotateSpeed = 0.7f
                
                constructor = Prov<mindustry.gen.Unit> { UnitEntity.create() }
            }
        }

        caretaker = object : UnitType("caretaker"){
            init{
                flying = true
                health = 380f
                speed = 2.85f
                accel = 0.12f
                drag = 0.05f
                engineOffset = 7f
                hitSize = 13f

                constructor = Prov<mindustry.gen.Unit> { UnitEntity.create() }
                abilities.add(ControllableUnitSpawnAbility(UnitTypes.flare, 13f * 60f, 0f, 0f))

                weapons.add(
                    object : Weapon("caretaker-orb"){
                        init{
                            x = 0f
                            y = 4f
                            reload = 40f
                            mirror = false

                            shootSound = Sounds.lasershoot
                            shoot.shots = 2
                            bullet = object : BasicBulletType(){
                                init{
                                    damage = 3f
                                    lightRadius = 15f
                                    trailLength = 12
                                    lifetime = 60f
                                    range = 60f
                                    speed = 5f
                                    backColor = Color.valueOf("bf8c2e")
                                    frontColor = Color.valueOf("e6e153")
                                }
                            }
                        }
                    }
                )
            }
        }

        leader = object : UnitType("leader"){
            init{
                flying = true
                health = 560f
                speed = 2.56f
                accel = 0.14f
                drag = 0.02f
                engineOffset = 10f
                engineSize = 3f
                hitSize = 13f

                constructor = Prov<mindustry.gen.Unit> { UnitEntity.create() }
                abilities.add(ControllableUnitSpawnAbility(UnitTypes.flare, 7.8f * 60f, 0f, 2f))

                weapons.add(
                    object : Weapon("leader-bomb"){
                        init{
                            x = 0f
                            y = 0f
                            reload = 250f
                            mirror = false

                            shootSound = Sounds.plasmadrop
                            shoot.shots = 2
                            bullet = object : BasicBulletType(){
                                init{
                                    sprite = "ion-leader-drop-bomb"
                                    width = 120/4f
                                    height = 120/4f
                                    reload = 50f

                                    maxRange = 30f
                                    ignoreRotation = true

                                    backColor = IColor.mothershipGoldDark
                                    frontColor = IColor.mothershipGoldLight
                                    mixColorTo = IColor.mothershipGoldLight

                                    hitSound = Sounds.plasmaboom

                                    shootCone = 180f
                                    ejectEffect = Fx.none
                                    hitShake = 4f

                                    collidesAir = false

                                    lifetime = 70f

                                    keepVelocity = false
                                    spin = 2f

                                    shrinkX = 0.7f
                                    shrinkY = 0.7f

                                    speed = 0f
                                    collides = false

                                    healPercent = 15f
                                    splashDamage = 220f
                                    splashDamageRadius = 80f

                                    hitEffect = IonFx.bombHit
                                }
                            }
                        }
                    }
                )
            }
        }
        
        hive = object : UnitType("hive"){
            init{
                flying = true
                lowAltitude = true
                health = 1330f
                armor = 3.4f
                speed = 2.15f
                accel = 0.12f
                drag = 0.06f
                engineSize = 8f
                engineOffset = 20f
                hitSize = 29f
                abilities.add(ControllableUnitSpawnAbility(UnitTypes.flare, 30f * 60f, 0f, 0f))
                
                constructor = Prov<mindustry.gen.Unit> { UnitEntity.create() }
                
                weapons.add(
                    object : RepairBeamWeapon("healers-1"){
                        init{
                            x = 11f
                            y = 11f
                            shootY = 0f
                            mirror = true
                            targetBuildings = true
                            targetUnits = true
                            repairSpeed = 0.25f
                            laserColor = IColor.mothershipHeal
                            laserTopColor = Color.white.cpy()
                            healColor = IColor.mothershipHeal
                            
                            parts.add(
                                object : ShapePart(){
                                    init{
                                        hollow = true
                                        rotateSpeed = 1.7f
                                        radius = 5f
                                        color = IColor.mothershipGoldLight
                                        stroke = 3f
                                        layer = Layer.effect
                                    }
                                }
                            )
                        }
                    },
                    object : RepairBeamWeapon("healers-2"){
                        init{
                            x = 11f
                            y = -10f
                            shootY = 0f
                            mirror = true
                            targetBuildings = true
                            targetUnits = true
                            repairSpeed = 0.55f
                            laserColor = IColor.mothershipHeal
                            laserTopColor = Color.white.cpy()
                            healColor = IColor.mothershipHeal
                            
                            parts.add(
                                object : ShapePart(){
                                    init{
                                        hollow = true
                                        rotateSpeed = 1.7f
                                        radius = 5f
                                        stroke = 3f
                                        color = IColor.mothershipGoldLight
                                        layer = Layer.effect
                                    }
                                }
                            )
                        }
                    }
                )
            }
        }

        commander = object : UnitType("commander"){
            init{
                flying = true
                lowAltitude = true
                health = 2300f
                armor = 3.4f
                speed = 1.12f
                accel = 0.8f
                drag = 0.04f
                engineSize = 10f
                engineOffset = 23f
                hitSize = 45f
                rotateSpeed= 1.1f
                
                abilities.add(ControllableUnitSpawnAbility(UnitTypes.horizon, 20f * 60f, 0f, 0f))
                constructor = Prov<mindustry.gen.Unit> { UnitEntity.create() }
                
                weapons.add(
                    object : Weapon("interceptor"){
                        init{
                            x = 20f
                            y = 5f
                            mirror = true
                            rotate = false
                            reload = 180f
                            baseRotation = -60f
                            shootCone = 360f
                            inaccuracy = 25f
                            shoot.shots = 3
                            bullet.spawnUnit = object : MissileUnitType("distractor"){
                                init{
                                    health = 35f
                                    speed = 3.4f
                                    lifetime = 120f
                                    rotateSpeed = 3.4f
                                    engineSize = 1f
                                    engineOffset = 0f
                                }
                            }
                        }
                    },
                    object : Weapon("interceptor-2"){
                        init{
                            x = 20f
                            y = -5f
                            mirror = true
                            rotate = false
                            reload = 185f
                            baseRotation = -90f
                            shootCone = 360f
                            inaccuracy = 25f
                            shoot.shots = 3
                            bullet.spawnUnit = object : MissileUnitType("distractor-2"){
                                init{
                                    health = 35f
                                    speed = 3.4f
                                    lifetime = 120f
                                    rotateSpeed = 3.4f
                                    engineSize = 1f
                                    engineOffset = 0f
                                }
                            }
                        }
                    }
                )
            }
        }
    }
}
