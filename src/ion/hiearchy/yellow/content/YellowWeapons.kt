package ion.hiearchy.yellow.content

import arc.Core
import arc.graphics.Color
import arc.graphics.g2d.Draw
import arc.graphics.g2d.Fill
import arc.graphics.g2d.Lines
import arc.math.Angles
import arc.math.Mathf
import arc.util.Time
import ion.hiearchy.yellow.entities.units.DisableableWeaponMount
import ion.hiearchy.yellow.type.weapons.DisableableWeapon
import mindustry.content.Fx
import mindustry.entities.bullet.BasicBulletType
import mindustry.entities.bullet.ContinuousLaserBulletType
import mindustry.entities.pattern.ShootSpread
import mindustry.entities.units.WeaponMount
import mindustry.gen.Bullet
import mindustry.gen.Sounds
import mindustry.graphics.Layer
import mindustry.gen.Unit as MUnit

object YellowWeapons{
    lateinit var meltdownBurst: DisableableWeapon
    lateinit var flareStorm: DisableableWeapon
    lateinit var mothRepellant: DisableableWeapon
    lateinit var decimator: DisableableWeapon
    lateinit var airstrikeSummoner: DisableableWeapon

    fun load(){
        meltdownBurst = object : DisableableWeapon("meltdown-burst", "Meltdown Burst"){
            init{
                reload = 60f
                x = 56f
                mirror = false
                shootSound = Sounds.explosionbig
                minWarmup = 0.99f

                shoot = object : ShootSpread(15, 5f){
                    init{
                        shotDelay = 5f
                    }
                }

                bullet = object : ContinuousLaserBulletType(){
                    init{
                        damage = 150f
                        width = 8f
                        length = 240f
                        lifetime = 60f
                        lightColor = Color.yellow
                    }
                }
            }

            override fun draw(unit: MUnit?, mount: WeaponMount?){
                super.draw(unit, mount)

                if((mount as DisableableWeaponMount).enabled) return

                var rotation = unit!!.rotation - 90f

                Draw.color(Color.yellow)
                Draw.z(Layer.effect)
                Lines.stroke(1f)
                Lines.square(unit.x + Angles.trnsx(rotation, mount.weapon.x, mount.weapon.y), unit.y + Angles.trnsy(rotation, mount.weapon.x, mount.weapon.y), 30f, Time.time)
                Lines.square(unit.x + Angles.trnsx(rotation, mount.weapon.x, mount.weapon.y), unit.y + Angles.trnsy(rotation, mount.weapon.x, mount.weapon.y), 30f, -Time.time)
            }
        }

        flareStorm = object : DisableableWeapon("flare-storm", "Flare Storm"){
            init{
                reload = 900f
                ejectEffect = YellowFx.flareStormShootEffect
                x = 0f
                y = 0f
                mirror = false
                minWarmup = 0.99f

                shoot = object : ShootSpread(690, 60f){
                    init{
                        shotDelay = 1f
                    }
                }

                bullet = object : BasicBulletType(){
                    init{
                        damage = 70f
                        width = 16f
                        height = 16f
                        lifetime = 300f
                        speed = 6f
                        hitEffect = YellowFx.ghostDespawn
                        despawnEffect = YellowFx.ghostDespawn
                        backRegion = Core.atlas.find("flare")
                        frontRegion = Core.atlas.find("flare")
                        sprite = "flare"
                        trailEffect = Fx.trailFade
                        shrinkX = 0f
                        shrinkY = 0f
                        weaveMag = 1.205f
                        weaveScale = 4000f
                        pierce = true
                        pierceBuilding = true
                        pierceCap = 15
                    }
                }
            }

            override fun draw(unit: MUnit?, mount: WeaponMount?){
                super.draw(unit, mount)

                if(!(mount as DisableableWeaponMount).enabled) return

                Draw.color(Color.yellow)
                Draw.z(Layer.effect)
                Draw.alpha(mount.reload / this.reload)

                Lines.square(unit!!.x, unit.y, 40f, Time.time * 6f)
                Lines.square(unit.x, unit.y, 40f, -Time.time * 6f)
                Lines.square(unit.x, unit.y, 80f, Time.time * 6f)
                Lines.square(unit.x, unit.y, 80f, -Time.time * 6f)

                Lines.stroke(10f)
                Lines.poly(unit.x, unit.y, 3, 130f, Time.time * 6f)
                Lines.poly(unit.x, unit.y, 3, 130f, Time.time * 6f - 180f)
            }
        }

        mothRepellant = object : DisableableWeapon("moth-repellant", "Moth Repellant"){
            init{
                reload = 2f
                x = 3f
                mirror = false
                shoot.shots = 25
                inaccuracy = 15f
                minWarmup = 0.99f

                bullet = object : BasicBulletType(){
                    init{
                        damage = 20f
                        lifetime = 60f
                        speed = 4f
                        width = 8f
                        height = 8f
                        knockback = 5f
                    }
                }
            }
        }

        decimator = object : DisableableWeapon("decimator", "Decimator"){
            init{
                reload = 120f
                x = 48f
                mirror = false

                shoot = ShootSpread(9, 6.5f)

                bullet = object : BasicBulletType(){
                    init{
                        damage = 5000f
                        splashDamage = 3000f
                        splashDamageRadius = 146f
                        lifetime = 420f
                        speed = 2f
                        width = 8f
                        height = 8f
                        hitEffect = YellowFx.decimatorExplosion
                        despawnEffect = YellowFx.decimatorExplosion
                    }

                    override fun draw(b: Bullet){
                        super.draw(b)

                        Draw.z(Layer.effect)
                        Draw.color(Color.yellow)
                        Lines.square(b.x, b.y, 15f, Time.time * 2f)
                        Lines.square(b.x, b.y, 15f, -Time.time * 2f)
                        Fill.circle(b.x, b.y, Mathf.sin(Time.time * 0.1f) * 1f + 4f)
                    }
                }
            }
        }

        airstrikeSummoner = object : DisableableWeapon("airstrike-summoner", "Airstrike Summoner"){
            init{
                reload = 300f
                x = 0f
                y = 0f
                mirror = false
                minWarmup = 0.99f

                bullet = YellowBullets.basicAirstrikeFlare
            }
        }
    }
}