package ion.content

import arc.graphics.Color
import arc.graphics.g2d.Draw
import arc.graphics.g2d.Lines
import arc.math.Angles
import arc.math.Interp
import ion.misc.IColor
import mindustry.content.Fx
import mindustry.entities.Effect
import mindustry.entities.effect.MultiEffect

object IonFx{
    
    val geometryCharge = Effect(120f){
        val e = it
        
        Draw.color(IColor.energy)
        Lines.stroke(e.fin() * 5f)
        
        Lines.square(e.x, e.y, e.fout(Interp.pow3In) * 30f, e.fin(Interp.smooth) * 180f)
        Lines.square(e.x, e.y, e.fout(Interp.pow3Out) * 30f, e.fin(Interp.smooth) * -180f)
        Lines.square(e.x, e.y, e.fout(Interp.pow10In) * 50f, e.fin(Interp.smooth) * -180f)
        Lines.square(e.x, e.y, e.fout(Interp.pow10Out) * 50f, e.fin(Interp.smooth) * 180f)
    }

    /*
    val chargeEffect = Effect(140f){
        val e = it
        
        Draw.color(IColor.energy)
        Lines.stroke(e.fin(Interp.smoother) * 9f)
        
        Lines.line(e.x, e.y, e.x + e.fout(Interp.pow3Out) * 50f, e.y)
        Lines.line(e.x, e.y, e.x + e.fout(Interp.pow3Out) * -50f, e.y)
        Lines.line(e.x, e.y, e.x + e.fout(Interp.pow5In) * 40f, e.y + e.fout(Interp.pow5Out) * 50f)
        Lines.line(e.x, e.y, e.x + e.fout(Interp.pow5In) * -40f, e.y + e.fout(Interp.pow5Out) * 50f)
        Lines.line(e.x, e.y, e.x + e.fout(Interp.pow5In) * 40f, e.y + e.fout(Interp.pow5Out) * -50f)
        Lines.line(e.x, e.y, e.x + e.fout(Interp.pow5In) * -40f, e.y + e.fout(Interp.pow5Out) * -50f)
    }
    */

    val chargeEffect = Effect(140f){
        val e = it

        Draw.color(IColor.energy)
        Lines.stroke(e.fin(Interp.smoother) * 7f)

        Lines.circle(e.x, e.y, e.fout(Interp.pow5Out) * 50f)
        Lines.circle(e.x, e.y, e.fout(Interp.pow3Out) * 30f)
    }

    
    val xeusCharge = MultiEffect(geometryCharge, chargeEffect)

    val bombHit = Effect(70f){
        val e = it

        Draw.color(IColor.mothershipGoldLight)
        Lines.stroke(e.fout() * 20f)
        Lines.square(e.x, e.y, e.fin(Interp.sineOut) * 35f, e.fin(Interp.smooth) * 180f)
        Lines.square(e.x, e.y, e.fin(Interp.sineIn) * 10f, e.fout(Interp.smooth) * 180f)
    }

    val slagCompact = Effect(60f){
        val e = it

        Draw.color(IColor.slagHeat)
        Lines.stroke(e.fout() * 3f)
        Lines.circle(e.x, e.y, e.fin(Interp.pow5Out) * 30f)
    }
    
    val dissipate = Effect(60f){
        val e = it
        
        Draw.color(Color.gray)
        Lines.stroke(e.fout() * 3f)
        
        Lines.circle(e.x, e.y, e.fin() * 15f)
    }

    val ptFire = Effect(115f){
        val e = it

        Draw.color(Color.gray)
        Lines.stroke(e.fout(Interp.pow5In) * 15f)

        Lines.circle(e.x, e.y, e.fin(Interp.pow5Out) * 50f)
        Lines.square(e.x, e.y, e.fin(Interp.pow5Out) * 45f, e.fin(Interp.smooth) * 180f)
        Lines.square(e.x, e.y, e.fin(Interp.pow5Out) * 45f, e.fout(Interp.smooth) * 180f)
    }

    val ptChargeRenewed = MultiEffect(Fx.smoke, Fx.shockwave, Fx.smokeCloud)
    
    val ptBulletTrail = Effect(40f){
        val e = it
        
        Draw.color(Color.gray)
        Lines.stroke(e.fout() * 3f)
        
        Angles.randLenVectors(e.id.toLong(), 1, e.fin() * 70f, e.rotation, e.fout(Interp.pow3Out) * 60f){ x: Float, y: Float ->
            Lines.line(e.x, e.y, e.x + x, e.y + y)
        }
    }
    
    val ereaFire = Effect(120f){
        val e = it
        val ln = e.fin(Interp.pow3Out) * 120f
        
        Draw.color(IColor.energy)
        Lines.stroke(e.fout(Interp.pow5Out) * 2f)
        
        Lines.circle(e.x, e.y, ln)
        Lines.square(e.x, e.y, ln, e.fin(Interp.pow3Out) * 180f)
        Lines.square(e.x, e.y, ln, e.fout(Interp.pow3In) * 180f)
        
        Angles.randLenVectors(e.id.toLong(), 40, e.fin(Interp.pow3Out) * 250f, e.rotation, e.fin() * 25f){ x: Float, y: Float ->
            Lines.line(e.x, e.y, e.x + x, e.y + y)
        }
    }
}
