package ion.hiearchy.yellow.entities.units.entity

import arc.math.Mathf
import arc.util.io.Reads
import arc.util.io.Writes
import ion.hiearchy.yellow.entities.UnitHandler
import ion.hiearchy.yellow.entities.units.GhostUnitType
import mindustry.gen.UnitEntity

open class GhostUnitEntity : UnitEntity(){
    var lifetime = 0.0f

    fun lifetimef(): Float{
        return lifetime / (type as GhostUnitType).lifetime
    }

    fun clampLifetime(){
        lifetime = Mathf.clamp(lifetime, 0f, (type as GhostUnitType).lifetime)
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

    override fun classId(): Int{
        return UnitHandler.classID<GhostUnitEntity>(GhostUnitEntity::class.java)
    }
}