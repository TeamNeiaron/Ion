package ion.hiearchy.yellow.entities.units

import arc.func.Prov
import arc.math.geom.Vec2
import arc.util.Time
import ion.hiearchy.yellow.content.YellowFx
import ion.hiearchy.yellow.entities.units.entity.GhostUnitEntity
import mindustry.game.Team
import mindustry.type.UnitType
import mindustry.gen.Unit as MUnit

open class GhostUnitType(name: String, var lifetime: Float = 900f) : UnitType(name){
    init{
        constructor = Prov<MUnit> { GhostUnitEntity() }
    }

    var despawnEffect = YellowFx.ghostDespawn
    var despawnEffectOffset = Vec2(0f, 0f)

    override fun update(unit: MUnit){

        val ghost = unit as GhostUnitEntity
        ghost.lifetime -= Time.delta
        ghost.clampLifetime()

        if(ghost.lifetime <= 0f){
            ghost.remove()
            despawnEffect.at(unit.x + despawnEffectOffset.x, unit.y + despawnEffectOffset.y)
        }

        super.update(unit)
    }

    override fun create(team: Team): MUnit{
        var unit = super.create(team)
        unit.health = unit.maxHealth
        (unit as GhostUnitEntity).lifetime = lifetime
        return unit
    }
}