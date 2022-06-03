package ion.entities.bullet

import arc.math.Mathf
import arc.graphics.Color
import arc.graphics.g2d.*
import mindustry.gen.*
import mindustry.game.Team
import mindustry.graphics.Layer
import mindustry.entities.*
import mindustry.entities.bullet.BulletType

open class GeometricBulletType : BulletType{
    
    var minSides = 3
    var maxSides = 7
    var color = Color.white
    var hollow = false
    
    constructor(min: Int, max: Int) : super(){
        minSides = min
        maxSides = max
    }
    
    constructor() : super(){}
    
    override fun draw(b: Bullet){
        super.draw(b)
        Draw.z(Layer.bullet)
        Draw.color(color)
        //Bullet#data is public but i dont feel like taking risks
        val data = b.data()
        
        if(data is Int){
            if(hollow){
                Lines.poly(b.x, b.y, data, b.type.hitSize, b.rotation())
                return
            }
            Fill.poly(b.x, b.y, data, b.type.hitSize, b.rotation())
        }
    }
    
    override fun create(
    owner: Entityc,
    team: Team,
    x: Float, y: Float,
    angle: Float,
    damage: Float,
    velocityScl: Float,
    lifetimeScl: Float,
    data: Any,
    mover: Mover,
    aimX: Float, aimY: Float
    ) = super.create(owner, team, x, y, angle, damage, velocityScl, lifetimeScl, data, mover, aimX, aimY).also{
        it.data(Mathf.random(minSides, maxSides))
    }
}
