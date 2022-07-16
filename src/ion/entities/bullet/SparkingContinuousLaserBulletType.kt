package ion.entities.bullet

import arc.math.Mathf
import mindustry.entities.Lightning
import mindustry.entities.bullet.ContinuousLaserBulletType
import mindustry.gen.Bullet

open class SparkingContinuousLaserBulletType(var lightningSpawnChance: Double) : ContinuousLaserBulletType() {

    override fun update(b: Bullet){
        super.update(b)
        
        if(Mathf.chanceDelta(lightningSpawnChance)){
            Lightning.create(b.team, lightningColor, lightningDamage, b.x, b.y, b.rotation(), lightningLength)
        }
    }
}
