package ion.defs

import arc.*
import arc.func.*
import arc.util.*
import arc.util.io.*
import arc.files.*
import arc.scene.ui.*
import arc.scene.style.*
import arc.scene.ui.layout.*
import arc.graphics.g2d.*
import mindustry.*
import mindustry.type.*
import mindustry.type.ammo.*

import ion.*
import ion.game.*
import ion.content.*

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
        Core.app.setClipboardText(IonVars.achievementInfo.toString().replace(", ", "\n"))
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
    
    fun draw(sprite: String, scale: Float): TextureRegionDrawable{
        var a = TextureRegionDrawable(Core.atlas.find(sprite) as TextureRegion, scale)
        
        return a
    }
}
