package ion.content

import arc.math.*
import arc.graphics.*
import arc.graphics.g2d.*
import mindustry.entities.*
import mindustry.entities.Effect.EffectContainer
import mindustry.entities.effect.*

import ion.defs.IColor
import mindustry.content.Fx

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
    
    val xeusCharge = MultiEffect(geometryCharge, chargeEffect)

    val slagCompact = Effect(60f){
        val e = it

        Draw.color(IColor.slagHeat)
        Lines.stroke(e.fout() * 3f)
        Lines.circle(e.x, e.y, e.fin(Interp.pow5In) * 30f)
    }
    
    val dissipate = Effect(60f){
        val e = it
        
        Draw.color(Color.gray)
        Lines.stroke(e.fout() * 3f)
        
        Lines.circle(e.x, e.y, e.fin() * 15f)
    }
    
    /*
    val ptCharge = Effect(80f){
        val e = it
        
        Draw.color(Color.gray)
        Lines.stroke(e.fin() * 8f)
        
        Lines.square(e.x, e.y, e.fout(Interp.pow3Out) * 35f, e.fout(Interp.pow3Out) * 180f)
        Lines.square(e.x, e.y, e.fout(Interp.pow3Out) * 35f, e.fin(Interp.pow3Out) * 180f)
        Lines.circle(e.x, e.y, e.fout(Interp.pow5Out) * 40f)
    }
    */
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
}
