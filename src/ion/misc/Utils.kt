package ion.misc

import arc.Core
import arc.files.Fi
import arc.func.Cons
import arc.graphics.g2d.TextureRegion
import arc.scene.style.TextureRegionDrawable
import arc.util.Http
import arc.util.Log
import arc.util.Timer
import arc.util.io.Streams
import ion.IonVars
import ion.content.IonItems
import ion.hiearchy.yellow.type.weapons.DisableableWeapon
import ion.hiearchy.yellow.type.weapons.NameableWeapon
import mindustry.Vars
import mindustry.type.UnitType

/** Returns true if the integer this function is used on is a multiple of the inputted argument. */
fun Int.multipleOf(int: Int): Boolean{
    return (this % int) == 0
}

/** Returns true if the float this function is used on is a multiple of the inputted argument. */
fun Float.multipleOf(float: Float): Boolean{
    return (this % float) == 0f
}

@Suppress("unused", "SpellCheckingInspection", "UNUSED_EXPRESSION")
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
                Streams.copyProgress(it.resultAsStream, file.write(!overwrite), it.contentLength, 4096){1f}
                
                cons.get(file)
            }
        } catch (e: Exception) {
            Vars.ui.showException("@error.http-get-error", e)
        }
    }
    
    fun writeFile(name: String, file: String){
        Core.settings.put("file-$name", Fi(file).readBytes())
    }
    
    fun writeFile(name: String, file: Fi){
        Core.settings.put("file-$name", file.readBytes())
    }
    
    fun readFile(name: String): ByteArray{
        return Core.settings.getBytes("file-$name")
    }
    
    fun readFile(name: String, file: String): Fi{
        val f = Fi(file)
        f.writeBytes(Core.settings.getBytes("file-$name"))
        return f
    }
    
    fun readFile(name: String, file: Fi): Fi{
        file.writeBytes(Core.settings.getBytes("file-$name"))
        return file
    }
    
    fun clipboardAchievements(){
        Core.app.clipboardText = IonVars.achievementInfo.toString().replace(", ", "\n")
    }
    
    fun haltSound(){
        Core.settings.put("musicvol", 0)
        Core.settings.put("sfxvol", 0)
        Core.settings.put("ambientvol", 0)
    }
    
    fun restoreSound(){
        Core.settings.put("musicvol", 100)
        Core.settings.put("sfxvol", 100)
        Core.settings.put("ambientvol", 100)
    }
    
    fun cheese(){
        IonItems.brass.localizedName = "Cheesestick"
        IonItems.brass.description = "Delicious!"
    }
    
    fun checkMod(name: String): Boolean{
        return Core.settings.getBool("mod-$name-enabled")
    }

    fun draw(sprite: String): TextureRegionDrawable {

        return TextureRegionDrawable(Core.atlas.find(sprite) as TextureRegion)
    }

    fun draw(sprite: String, scale: Float): TextureRegionDrawable {

        return TextureRegionDrawable(Core.atlas.find(sprite) as TextureRegion, scale)
    }
    
    fun loop(delay: Float, runnable: () -> Unit){
        Timer.schedule(runnable, delay, delay, -1)
    }

    /** Creates a mirrored copy of the inputted disableable weapon array and adds them all to the inputted unit. */
    fun mirrorWeapons(inputUnit: UnitType, weapons: Array<DisableableWeapon>){
        weapons.forEach{
            val sus = it.copy()

            sus.x = it.x - it.x * 2f
            sus.reload = it.reload * 2f
            sus.name = "${it.name}-mirror"
            (sus as NameableWeapon).displayName = "${(it as NameableWeapon).displayName} (Mirror)"
            sus.load()

            Log.info("origin x: @, new x: @, origin reload: @, new reload: @, origin name: @, mirror name: @", it.x, sus.x, it.reload, sus.reload, it.name, sus.name)

            inputUnit.weapons.add(sus)
        }

    }

}
