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

object Utils{
    /** Gets the result of a link and writes it to a file. */
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
