package ion.hiearchy.yellow.content

import arc.Core
import arc.func.Prov
import ion.hiearchy.yellow.entities.units.GhostUnitType
import ion.hiearchy.yellow.entities.units.YellowUnitType
import ion.hiearchy.yellow.entities.units.entity.YellowUnitEntity
import mindustry.ai.types.FlyingAI
import mindustry.entities.units.AIController
import mindustry.type.UnitType
import mindustry.gen.Unit as MUnit

object YellowUnitTypes{
    lateinit var yellow: UnitType
    lateinit var ghostFlare: UnitType

    fun load(){

        yellow = object : YellowUnitType("yellow"){
            init{
                flying = true
                hideDetails = false
                health = 25000f
                armor = 7f
                speed = 3f
                accel = 0.08f
                drag = 0.01f
                range = 1250f
                maxRange = 1250f
                mineSpeed = 1000f
                mineTier = 4000
                itemCapacity = Int.MAX_VALUE
                buildSpeed = Float.MAX_VALUE
                deathExplosionEffect = YellowFx.yellowDeath

                constructor = Prov<MUnit> { YellowUnitEntity() }
                aiController = Prov<AIController> { FlyingAI() }

                weapons.addAll(YellowWeapons.meltdownBurst, YellowWeapons.flareStorm, YellowWeapons.decimator, YellowWeapons.mothRepellant, YellowWeapons.airstrikeSummoner)
            }
        }

        ghostFlare = object : GhostUnitType("ghost-flare"){
            init{
                flying = true
                health = 40f
                armor = 5f
                speed = 3f
                accel = 0.08f
                drag = 0.01f

                aiController = Prov<AIController> { FlyingAI() }
                region = Core.atlas.find("flare")
            }
        }
    }
}