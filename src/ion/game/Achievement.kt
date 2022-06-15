package ion.game

import arc.*
import mindustry.*
import mindustry.gen.*
import mindustry.ctype.*

open class Achievement{
    
    val front = "achievement"
    
    var name = "achievement"
    var displayName = "Achievement"
    var description = ""
    var icon = Icon.units
    
    constructor(name: String, displayName: String){
        this.name = name
        this.displayName = displayName
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
