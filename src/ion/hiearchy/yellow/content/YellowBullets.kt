package ion.hiearchy.yellow.content

import ion.hiearchy.yellow.entities.bullet.AirstrikeFlare
import mindustry.content.Fx
import mindustry.entities.bullet.BombBulletType
import mindustry.entities.bullet.BulletType

object YellowBullets{
    lateinit var basicMissile: BulletType
    lateinit var basicAirstrikeFlare: BulletType

    fun load(){
        basicMissile = object : BombBulletType(){
            init{
                lifetime = 25f
                speed = 0f
                width = 32f
                height = 32f
                shrinkX = 0.6f
                shrinkY = 0.6f
                damage = 350f
                splashDamage = 270f
                splashDamageRadius = 88f
                spin = 1f

                trailEffect = YellowFx.bigSmoke
                trailChance = 0.1f

                hitEffect = Fx.explosion
                despawnEffect = Fx.explosion

                sprite = "ion-basic-missile"
            }
        }

        basicAirstrikeFlare = AirstrikeFlare(basicMissile)
    }
}