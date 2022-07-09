package ion.game

import arc.*
import arc.util.*
import arc.func.*
import mindustry.*
import mindustry.gen.*
import mindustry.game.EventType.*
import mindustry.ctype.*

import ion.*

import java.lang.*

open class Achievement{
    
    val front = "achievement"
    
    var name = "achievement"
    var displayName = "Achievement"
    var description = ""
    var icon = Icon.units
    /** Creates a new Achievement with no condition listener, making this impossible to obtain outside normal means. */
    constructor(name: String, displayName: String){
        this.name = name
        this.displayName = displayName
        
        IonVars.achievements.add(this)
    }
    
    /**
     * Creates a new Achievement with a condition listener.
     * A simple example of this is checking if another Achievement has already been unlocked.
     * See IonAchievements for more info.
     */
    constructor(name: String, displayName: String, conditions: Cons<Achievement>) : this(name, displayName){
        Timer.schedule({ if(!this.isUnlocked()) conditions.get(this) }, 1f, 1f, -1)
    }
    
    fun load(){
        if(!isUnlocked()){
            Core.settings.put("$front-$name", false)
        }
    }
    
    fun isUnlocked(): Boolean{
        return Core.settings.getBool("$front-$name")
    }
    
    fun unlock(){
        Core.settings.put("$front-$name", true)
        Vars.ui.hudfrag.showToast(icon, "Achievement $displayName complete!")
    }
    
    fun lock(){
        Core.settings.put("$front-$name", false)
    }
    
    fun data(excludeInternalName: Boolean): Array<String>{
        if(!excludeInternalName){
            return arrayOf("$front-$name", displayName, description)
        } else {
            return arrayOf(displayName, description)
        }
    }
}
