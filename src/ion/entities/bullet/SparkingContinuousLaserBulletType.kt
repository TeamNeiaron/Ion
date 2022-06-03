package ion.entities.bullet

import arc.math.*
import arc.graphics.*
import mindustry.gen.*
import mindustry.entities.*
import mindustry.entities.bullet.*

open class SparkingContinuousLaserBulletType : ContinuousLaserBulletType{
    
    var lightningSpawnChance = 0.3;
    var lightningDamage = 1f;
    var lightningLength = 24;
    var lightningColor = Color.white;
    
    constructor(lSpawnChance: Float) : super(){
        lightningSpawnChance = lSpawnChance;
    }
    
    override fun update(b: Bullet){
        super.update(b)
        
        if(Mathf.chance(lightningSpawnChance)){
            Lightning.create(b.team, lightningColor, lightningDamage, b.x, b.y, b.rotation(), lightningLength)
        }
    }
}
