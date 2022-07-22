package ion.misc

import arc.Core
import arc.files.Fi
import arc.graphics.g2d.TextureRegion
import arc.scene.style.TextureRegionDrawable
import arc.util.Http
import arc.util.Timer
import arc.util.io.Streams
import ion.IonVars
import ion.content.IonItems
import ion.hiearchy.yellow.type.weapons.NameableWeapon
import mindustry.Vars
import mindustry.type.UnitType
import mindustry.type.Weapon


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
        cons: (Fi) -> Unit
    ){
        try{
            Http.get(link){
                Streams.copyProgress(it.resultAsStream, file.write(!overwrite), it.contentLength, 4096){1f}
                
                cons(file)
            }
        }catch(e: Exception){
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

    /** Creates a mirrored copy of the inputted weapon array and adds them all to an inputted unit. */
    fun mirrorWeapons(input: Array<Weapon>, nameable: Boolean, alternate: Boolean, unit: UnitType) {
        for (i in input.indices) {
            val mog = input[i].copy()
            mog.x = input[i].x - input[i].x * 2f
            if(alternate){
                mog.reload = input[i].reload * 2f
            }
            mog.name = input[i].name + "-m"
            mog.load()
            if(nameable){
                (mog as NameableWeapon).displayName = (input[i] as NameableWeapon).displayName + " (Inv)"
            }
            unit.weapons.add(mog)
        }
    }

}
