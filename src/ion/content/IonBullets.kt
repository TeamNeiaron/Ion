package ion.content

import arc.graphics.Color
import mindustry.content.Fx
import mindustry.entities.bullet.BulletType

import ion.defs.IColor
import ion.entities.bullet.*

object IonBullets{
    
    lateinit var geometricBullet: BulletType
    lateinit var miniGeometricBullet: BulletType
    lateinit var energyOrbBullet: BulletType
    lateinit var xeusLaser: BulletType
    
    fun load(){
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
        
        miniGeometricBullet = GeometricBulletType(3, 10).apply{
            damage = 50f
            speed = 3.3f
            lifetime = 86f
            hitSize = 5f
            spinSpeed = 3.4f
            color = IColor.energy
            trailEffect = Fx.trailFade
            trailWidth = 3f
            trailLength = 4
            trailColor = IColor.energy
        }
        
        energyOrbBullet = UnstableEnergyBulletType(0.2).apply{
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
        
        xeusLaser = SparkingContinuousLaserBulletType(0.4).apply{
            lifetime = 360f
            length = 800f
            width = 4f
            damage = 8f
            colors = arrayOf(
                IColor.energy,
                IColor.lightEnergy,
                Color.white
            )
            despawnEffect = Fx.smokeCloud
            shootEffect = IonFx.xeusCharge
            lightningDamage = 40f
            lightningLength = 40
            lightningColor = IColor.lightEnergy
        }
    }
}
