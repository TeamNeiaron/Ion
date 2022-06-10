package ion.defs

import arc.graphics.*
import arc.graphics.g2d.*
import mindustry.type.*

object IDraw{
    fun unit(unit: mindustry.gen.Unit){
        Draw.rect(unit.type.fullIcon, unit.x, unit.y, unit.hitSize * 1.5f, unit.hitSize * 1.5f, 270f + unit.rotation)
    }
}
