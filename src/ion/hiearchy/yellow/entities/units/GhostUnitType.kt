package ion.hiearchy.yellow.entities.units

import arc.func.Prov
import arc.math.geom.Vec2
import ion.hiearchy.yellow.content.YellowFx
import ion.hiearchy.yellow.entities.units.entity.GhostUnitEntity
import mindustry.type.UnitType
import mindustry.gen.Unit as MUnit

open class GhostUnitType(name: String, var ghostLifetime: Float = 900f) : UnitType(name){
    init{
        constructor = Prov<MUnit> { GhostUnitEntity() }
    }

    var despawnEffect = YellowFx.ghostDespawn
    var despawnEffectOffset = Vec2(0f, 0f)
}
