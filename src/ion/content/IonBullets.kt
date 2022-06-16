package ion.content

import arc.graphics.Color
import mindustry.content.Fx
import mindustry.entities.bullet.*

import ion.content.*
import ion.defs.IColor
import ion.entities.bullet.*
import mindustry.entities.effect.MultiEffect

object IonBullets{
    
    lateinit var geometricBullet: BulletType
    lateinit var miniGeometricBullet: BulletType
    lateinit var energyOrbBullet: BulletType
    lateinit var xeusLaser: BulletType
    lateinit var petrifierBullet: BulletType
    
    fun load(){
        geometricBullet = object : GeometricBulletType(3, 10){
            init{
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
        }
        
        miniGeometricBullet = object : GeometricBulletType(3, 10){
            init{
                damage = 75f
                speed = 12f
                drag = 0.05f
                lifetime = 86f
                hitSize = 5f
                spinSpeed = 3.4f
                color = IColor.energy
                trailEffect = Fx.trailFade
                trailWidth = 3f
                trailLength = 4
                trailColor = IColor.energy
            }
        }
        
        energyOrbBullet = object : UnstableEnergyBulletType(0.2){
            init{
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
        }
        
        xeusLaser = object : SparkingContinuousLaserBulletType(0.4){
            init{
                lifetime = 300f
                length = 388f
                width = 4f
                damage = 52f
                colors = arrayOf(
                    IColor.energy,
                    IColor.lightEnergy,
                    Color.white
                )
                despawnEffect = Fx.smokeCloud
                chargeEffect = IonFx.xeusCharge
                lightningDamage = 64f
                lightningLength = 45
                lightningColor = IColor.lightEnergy
            }
        }
        
        petrifierBullet = object : BasicBulletType(){
            init{
                damage = 50f
                speed = 3.7f
                lifetime = 132f
                width = 21.6f
                height = 21.6f
                chargeEffect = IonFx.ptChargeRenewed
                shootEffect = IonFx.ptFire
                status = IonStatusEffects.petrified
                statusDuration = 258f
                trailEffect = IonFx.ptBulletTrail
                trailChance = 0.4f
                backColor = Color.gray
                frontColor = Color.darkGray
                despawnEffect = IonFx.dissipate
                hitEffect = IonFx.dissipate
            }
        }
    }
}
