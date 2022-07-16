package ion.entities.bullet

import arc.graphics.Color
import arc.graphics.g2d.Draw
import arc.graphics.g2d.Fill
import arc.math.Mathf
import mindustry.entities.Lightning
import mindustry.entities.bullet.BulletType
import mindustry.gen.Bullet
import mindustry.graphics.Layer

open class UnstableEnergyBulletType(var lightningSpawnChance: Double) : BulletType() {

    var orb = true
    var color: Color? = Color.white

    override fun draw(b: Bullet){
        Draw.z(Layer.bullet)
        Draw.color(color)
        
        if(orb){
            Fill.circle(b.x, b.y, b.type.hitSize)
            return
        }
        super.draw(b)
    }
    
    override fun update(b: Bullet){
        super.update(b)

        if(Mathf.chanceDelta(lightningSpawnChance)){
            Lightning.create(b.team, lightningColor, lightningDamage, b.x, b.y, Mathf.random(-360f, 360f), lightningLength)
        }
    }
}
