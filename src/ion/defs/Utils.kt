package ion.defs

import arc.func.*
import arc.util.*
import arc.util.io.*
import arc.files.*
import arc.scene.ui.*
import arc.scene.ui.layout.*
import mindustry.*
import mindustry.type.*
import mindustry.type.ammo.*

import ion.game.*

//region units

/** Sets this unit's shield health to its max health. */
fun mindustry.gen.Unit.maxShield(){
    this.shield = this.maxHealth
}

/** Splits this unit's health to half, with the other half going down under. */
fun mindustry.gen.Unit.splitHealth(){
    this.health -= this.health / 2f
}

fun UnitType.powerCapacity(
    power: Float,
    range: Float = 85f
){
    val p = PowerAmmoType(power)
    p.range = range
    this.ammoType = p
}

object Utils{
    /**
     Gets the result of a link and writes it to a file.
     link: the link to get from
     file: the file to write to
     overwrite (default true): whether or not to overwrite the contents of the specified file
     cons: script to run with the file
    */
    fun getAndWrite(
        link: String,
        file: Fi,
        overwrite: Boolean = true,
        cons: Cons<Fi>
    ){
        try{
            Http.get(link){
                Streams.copyProgress(it.getResultAsStream(), file.write(!overwrite), it.getContentLength(), 4096){69f}
                
                cons.get(file)
            }
        } catch (e: Exception) {
            Vars.ui.showException("@error.http-get-error", e)
        }
    }
    
    /** Iterates through an array of Achievements. */
    fun eachAchievement(achievements: Array<Achievement>, cons: Cons<Achievement>){
        for(i in 0..achievements.size - 1){
            cons.get(achievements[i])
        }
    }
}
