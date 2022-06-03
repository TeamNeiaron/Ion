package ion.content

import arc.*
import arc.func.*
import arc.graphics.*
import mindustry.gen.*
import mindustry.type.*
import mindustry.game.*
import mindustry.content.*
import mindustry.entities.bullet.*
import mindustry.entities.pattern.*

import ion.defs.*
import ion.content.*
import ion.entities.bullet.*

object IonUnitTypes{
    
    lateinit var orion: UnitType
    lateinit var xender: UnitType
    lateinit var astro: UnitType
    lateinit var geometry: UnitType
    lateinit var xeus: UnitType
    
    fun load(){
        orion = UnitType("orion").apply{
            flying = true
            health = 290f
            speed = 3.62f
            accel = 0.15f
            drag = 0.05f
            engineOffset = 7f
            hitSize = 13f
            
            constructor = Prov{ UnitEntity() }
            
            
            weapons.add(Weapon("orion-arc").apply{
                x = 0f
                y = 0f
                reload = 40f
                mirror = false
                shootSound = Sounds.spark
                shoot.shots = 2
                bullet = LightningBulletType().apply{
                    damage = 14f
                    lightningColor = IColor.energy
                    lightningLength = 19
                }
            })
        }
    }
}
