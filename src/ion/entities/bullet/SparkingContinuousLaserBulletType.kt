package ion.entities.bullet

import arc.math.*
import arc.graphics.*
import mindustry.gen.*
import mindustry.entities.*
import mindustry.entities.bullet.*

open class SparkingContinuousLaserBulletType : ContinuousLaserBulletType{
    
    var lightningSpawnChance = 0.3
    @JvmField var LightningDamage = 1f
    @JvmField var LightningLength = 24
    @JvmField var LightningColor = Color.white;
    
    constructor(lSpawnChance: Double) : super(){
        lightningSpawnChance = lSpawnChance
    }
    
    override fun update(b: Bullet){
        super.update(b)
        
        if(Mathf.chance(lightningSpawnChance)){
            Lightning.create(b.team, lightningColor, lightningDamage, b.x, b.y, b.rotation(), lightningLength)
        }
    }
}
