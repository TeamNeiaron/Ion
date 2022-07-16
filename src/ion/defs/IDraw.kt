package ion.defs

import arc.math.*
import arc.graphics.*
import arc.graphics.g2d.*
import mindustry.gen.*
import mindustry.type.*
import mindustry.world.*

object IDraw{
    fun unit(unit: mindustry.gen.Unit){
        Draw.rect(unit.type.fullIcon, unit.x, unit.y, unit.hitSize * 1.5f, unit.hitSize * 1.5f, 270f + unit.rotation)
    }

}
