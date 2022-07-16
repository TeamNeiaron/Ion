package ion.entities.bullet

import arc.graphics.Color
import arc.graphics.g2d.Draw
import arc.graphics.g2d.Fill
import arc.graphics.g2d.Lines
import arc.math.Mathf
import arc.util.Time
import mindustry.entities.Mover
import mindustry.entities.bullet.BulletType
import mindustry.game.Team
import mindustry.gen.Bullet
import mindustry.gen.Entityc
import mindustry.graphics.Layer

open class GeometricBulletType(min: Int, max: Int) : BulletType() {
    
    var minSides = min
    var maxSides = max
    var spinSpeed = 0.08f
    var color = Color.white
    var hollow = false

    override fun draw(b: Bullet){
        super.draw(b)
        Draw.z(Layer.bullet)
        Draw.color(color)
        //Bullet#data is public but i dont feel like taking risks
        val data = b.data()
        
        if(data is Int){
            if(hollow){
                Lines.poly(b.x, b.y, data, b.type.hitSize, b.rotation() + (Time.time * spinSpeed))
                return
            }
            Fill.poly(b.x, b.y, data, b.type.hitSize, b.rotation() + (Time.time * spinSpeed))
        }
    }
    
    override fun create(
    owner: Entityc?,
    team: Team?,
    x: Float, y: Float,
    angle: Float,
    damage: Float,
    velocityScl: Float,
    lifetimeScl: Float,
    data: Any?,
    mover: Mover?,
    aimX: Float, aimY: Float
    ) = super.create(owner, team, x, y, angle, damage, velocityScl, lifetimeScl, data, mover, aimX, aimY).also{
        it.data(Mathf.random(minSides, maxSides))
    }
}