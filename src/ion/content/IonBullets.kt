package ion.content

import arc.graphics.Color
import mindustry.content.Fx
import mindustry.entities.bullet.BulletType

import ion.defs.IColor
import ion.entities.bullet.*

object IonBullets{
    
    lateinit var geometricBullet: BulletType
    lateinit var energyOrbBullet: BulletType
    lateinit var xeusLaser: BulletType
    
    fun load() {
        geometricBullet = GeometricBulletType(3, 10).apply{
            damage = 370f
            speed = 3.4f
            lifetime = 72f
            hitSize = 15f
            spinSpeed = 3.4f
            pierce = true
            pierceBuilding = true
            pierceCap = 3
            chargeEffect = IonFx.geometryCharge
            color = IColor.energy
            trailEffect = Fx.trailFade
            trailWidth = 7.5f
            trailLength = 17
            trailColor = IColor.energy
        }
        
        energyOrbBullet = UnstableEnergyBulletType(0.2f).apply{
            damage = 67f
            speed = 2.7f
            lifetime = 120f
            hitSize = 4.8f
            pierce = true
            pierceBuilding = true
            pierceCap = 2
            lightningLength = 7
            lightningDamage = 8f
            lightningColor = IColor.energy
            color = IColor.energy
        }
        
        xeusLaser = SparkingContinuousLaserBulletType(0.4f).apply{
            lifetime = 360f
            length = 388f
            width = 4f
            damage = 85f
            colors = arrayOf(
                IColor.energy,
                IColor.lightEnergy,
                Color.white
            )
            despawnEffect = Fx.smokeCloud
            shootEffect = IonFx.xeusCharge
            lightningDamage = 760f
            lightningLength = 45
            lightningColor = IColor.lightEnergy
        }
    }
}
