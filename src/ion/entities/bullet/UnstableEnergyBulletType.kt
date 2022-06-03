package ion.entities.bullet

import arc.math.*
import arc.graphics.*
import arc.graphics.g2d.*
import mindustry.gen.*
import mindustry.entities.*
import mindustry.entities.bullet.*
import mindustry.graphics.*

import ion.defs.*

open class UnstableEnergyBulletType : BulletType{
    
    var lightningSpawnChance = 0.1;
    var lightningDamage = 1f;
    var lightningLength = 17;
    var orb = true;
    var color = Color.white;
    var ightningColor = Color.white;
    
    constructor(lSpawnChance: Double) : super(){
        lightningSpawnChance = lSpawnChance;
    }
    
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
        super.update(b);
        
        if(Mathf.chance(lightningSpawnChance)){
            Lightning.create(b.team, lightningColor, lightningDamage, b.x, b.y, Mathf.random(-360f, 360f), lightningLength);
        }
    }
}
