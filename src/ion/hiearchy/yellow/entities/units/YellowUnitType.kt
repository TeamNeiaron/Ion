package ion.hiearchy.yellow.entities.units

import arc.graphics.Color
import arc.graphics.g2d.Draw
import arc.graphics.g2d.Fill
import arc.graphics.g2d.Lines
import arc.math.Mathf
import arc.util.Time
import arc.util.Tmp
import mindustry.graphics.Layer
import mindustry.type.UnitType
import mindustry.gen.Unit as MUnit

open class YellowUnitType(name: String) : UnitType(name){

    override fun draw(unit: MUnit){
        super.draw(unit)

        var s = Mathf.absin(Time.time, 16f, 1f)
        var r1 = s * 25f
        var r2 = s * 20f

        Draw.z(Layer.effect)
        Draw.color(Color.yellow)

        Lines.circle(unit.x, unit.y, 20f + r1)
        Lines.square(unit.x, unit.y, 20f + r1, Time.time)
        Lines.square(unit.x, unit.y, 20f + r1, -Time.time)

        Tmp.v1.trns(Time.time, r2, r2)

        Fill.circle(unit.x + Tmp.v1.x, unit.y + Tmp.v1.y, 2f + s * 8f)
        Tmp.v1.trns(Time.time, -r2, -r2)
        Fill.circle(unit.x + Tmp.v1.x, unit.y + Tmp.v1.y, 2f + s * 8f)
        Tmp.c1.set(Color.white)
        Tmp.c1.a = 0f
        Fill.light(unit.x, unit.y, 5, 50f - r1, Color.yellow, Tmp.c1)
    }
}