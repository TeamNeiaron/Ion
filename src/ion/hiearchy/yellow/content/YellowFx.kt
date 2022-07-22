package ion.hiearchy.yellow.content

import arc.graphics.Color
import arc.graphics.g2d.Draw
import arc.graphics.g2d.Fill
import arc.graphics.g2d.Lines
import arc.math.Angles
import arc.util.Time
import mindustry.entities.Effect
import mindustry.graphics.Layer

object YellowFx{
    val ghostDespawn = Effect(10f){
        Draw.z(Layer.effect)
        Draw.alpha(it.fout() * 3f)

        Lines.stroke(it.fout() * 7f)
        Lines.circle(it.x, it.y, it.fin() * 10f)
    }

    val flareStormShootEffect = Effect(60f){
        Draw.z(Layer.effect + 0.001f)
        Draw.color(Color.white)
        Draw.alpha(it.fout())

        Lines.square(it.x, it.y, 40f, Time.time * 6f)
        Lines.square(it.x, it.y, 40f, -Time.time * 6f)
        Lines.square(it.x, it.y, 80f, Time.time * 6f)
        Lines.square(it.x, it.y, 80f, -Time.time * 6f)

        Lines.stroke(10f)
        Lines.poly(it.x, it.y, 3, 130f, Time.time * 6f)
        Lines.poly(it.x, it.y, 3, 130f, Time.time * 6f - 180f)
    }

    val decimatorExplosion = Effect(120f){
        Draw.color(Color.yellow)

        Lines.stroke(it.fout() * 15f)
        Lines.circle(it.x, it.y, it.fin() * 25f)
        Lines.square(it.x, it.y, it.fin() * 50f, it.fin() * 180f)
        Lines.circle(it.x, it.y, it.fin() * 50f)
        Lines.square(it.x, it.y, it.fin() * 100f, it.fin() * 180f)
        Lines.circle(it.x, it.y, it.fin() * 25f)
        Lines.square(it.x, it.y, it.fin() * 50f, it.fout() * 180f)
        Lines.circle(it.x, it.y, it.fin() * 50f)
        Lines.square(it.x, it.y, it.fin() * 100f, it.fout() * 180f)
    }

    val bigSmoke = Effect(60f){
        Draw.color(Color.gray)
        Draw.alpha(it.fout())
        Fill.circle(it.x, it.y, it.fout() * 8f)
    }

    val yellowDeath = Effect(210f){
        Draw.color(Color.yellow, Color.orange, it.finpow())

        Lines.stroke(it.fout() * 5f)
        Lines.square(it.x, it.y, it.finpow() * 90f, it.finpow() * 180f)
        Lines.square(it.x, it.y, it.finpow() * 90f, it.foutpow() * 180f)
        Lines.circle(it.x, it.y, it.finpow() * 130f)
        Lines.circle(it.x, it.y, it.finpow() * 120f)
        Lines.circle(it.x, it.y, it.finpow() * 110f)

        Angles.randLenVectors(it.id.toLong(), 50, it.finpow() * 100){ x: Float, y: Float ->
            Lines.stroke(1f)
            Draw.color(Color.yellow, Color.orange, it.finpow())
            Fill.circle(it.x + x, it.y + y, it.fout() * 10)
        }

        Draw.alpha(it.fout() * 4f)
        Draw.rect("ion-yellow", it.x, it.y, it.finpow() * 200f, it.finpow() * 200f)
    }
}