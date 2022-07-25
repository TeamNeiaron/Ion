package ion.hiearchy.yellow.entities.units.entity

import arc.math.Mathf
import arc.util.Time
import arc.util.io.Reads
import arc.util.io.Writes
import ion.hiearchy.yellow.entities.units.GhostUnitType
import mindustry.content.Fx
import mindustry.gen.EntityMapping
import mindustry.gen.UnitEntity

open class GhostUnitEntity : UnitEntity(){
    var lifetime = 0f
    var despawnEffect = Fx.none

    private var inited = false

    fun lifetimef(): Float{
        return lifetime / (type as GhostUnitType).lifetime
    }

    fun clampLifetime(){
        lifetime = Mathf.clamp(lifetime, 0f, (type as GhostUnitType).lifetime)
    }

    fun initVars(){
        lifetime = (type as GhostUnitType).lifetime
        despawnEffect = (type as GhostUnitType).despawnEffect
    }

    override fun update(){
        super.update()

        if(!inited){
            initVars()
            inited = true
        }

        lifetime -= Time.delta
        clampLifetime()

        if(lifetime <= 0f){
            val ty = (type as GhostUnitType)
            remove()
            ty.despawnEffect.at(x + ty.despawnEffectOffset.x, y + ty.despawnEffectOffset.y)
        }
    }

    override fun cap(): Int{
        return count() + 1
    }

    override fun write(write: Writes) {
        super.write(write)
        write.f(lifetime)
    }

    override fun read(read: Reads){
        super.read(read)
        lifetime = read.f()
    }

    override fun classId() = mappingId

    companion object{
        val mappingId = EntityMapping.register("ion-ghost-unit", ::GhostUnitEntity)
    }
}