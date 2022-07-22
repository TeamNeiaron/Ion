package ion.misc

import arc.graphics.g2d.Draw

object IDraw{
    fun unit(unit: mindustry.gen.Unit){
        Draw.rect(unit.type.fullIcon, unit.x, unit.y, unit.hitSize * 1.5f, unit.hitSize * 1.5f, 270f + unit.rotation)
    }

}
