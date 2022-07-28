package ion.game

import arc.Core
import arc.Events
import arc.util.Log
import ion.IonVars
import ion.game.Achievement.DuplicateAchievementException
import ion.misc.Utils
import mindustry.Vars
import mindustry.gen.Icon

/**
 * A class for creating achievements obtainable in-game. An achievement's completed state is saved inside the game's settings binary file which makes it persist even when the game is reloaded.
 * All instances of Achievements are added into a list located in [IonVars] that you can iterate through or check for debugging.
 *
 * Attempting to create an Achievement with an empty/blank internal name will throw an [IllegalArgumentException] as Achievements with an empty internal name will not save properly and attempting to make 2 Achievements with the same internal name will throw a [DuplicateAchievementException].
 *
 * This class cannot be imported inside a console or in javascript as it will conflict with [mindustry.service.Achievement].
 *
 * `TODO`: move this class into a separate library for other java mods to use?
 */
open class Achievement{

    /** The achievement string head. DO NOT MODIFY, EVER! */
    val front = "achievement"
    
    var name = "achievement"
    var displayName = "Achievement"
    var description = ""
    var icon = Icon.units!!

    /**
     * Creates a new Achievement with no condition listener, making this impossible to obtain outside normal means.
     * @throws IllegalArgumentException thrown if the achievement's internal name is empty/blank.
     */
    constructor(name: String, displayName: String){
        if(name.isBlank()) throw IllegalArgumentException("Cannot have an Achievement with an empty/blank name!")
        if(displayName.isBlank()) Log.warn("Achievement \"$name\" has an empty/blank display name.")

        IonVars.achievements.each{
            if(it.name == this.name) throw DuplicateAchievementException("Cannot have two Achievements with the same internal name!")
        }

        this.name = name
        this.displayName = displayName
        
        IonVars.achievements.add(this)
    }
    
    /**
     * Creates a new Achievement with a condition listener.
     * A simple example of this is checking if another Achievement has already been unlocked.
     * @throws IllegalArgumentException thrown if the achievement's internal name is empty/blank.
     */
    constructor(name: String, displayName: String, conditions: (Achievement) -> Unit) : this(name, displayName){
        Utils.loop(0.5f){ if(!this.isUnlocked()) conditions(this) }
    }

    /**
     * Creates a new Achievement that gets unlocked if the inputted event class is fired.
     * @throws IllegalArgumentException thrown if the achievement's internal name is empty/blank.
     */
    constructor(name: String, displayName: String, event: Class<*>) : this(name, displayName){
        Events.on(event){ this.unlock() }
    }

    /** Loads this achievement into the settings binary file, preventing null output. Will not do anything if this achievement is already loaded into the file. */
    fun load(){
        if(!Core.settings.keys().contains("$front-$name")){
            Core.settings.put("$front-$name", false)
        }
    }

    /** Returns true if this achievement has already been completed. */
    fun isUnlocked(): Boolean{
        return Core.settings.getBool("$front-$name")
    }

    /** Unlocks this achievement and shows a toast popup on top of the screen, subsequently including the achievement icon too. */
    fun unlock(){
        Core.settings.put("$front-$name", true)
        Vars.ui.hudfrag.showToast(icon, "Achievement $displayName complete!")
    }

    /** Locks this achievement. */
    fun lock(){
        Core.settings.put("$front-$name", false)
    }

    /**
     * @param excludeInternalName whether to make the return value not contain the internal name of this achievement.
     * @return Array<String> containing the display name and description of this achievement (and the internal name of this achievement if excludeInternalName is false).
     */
    fun data(excludeInternalName: Boolean): Array<String>{
        if(!excludeInternalName) return arrayOf("$front-$name", displayName, description) else return arrayOf(displayName, description)
    }

    /** An [Exception] subclass that gets thrown if 2 [Achievement]s are made with the same internal name. */
    inner class DuplicateAchievementException(message: String? = null, cause: Throwable? = null) : Exception(message, cause){
        constructor(cause: Throwable) : this(null, cause)
    }
}
