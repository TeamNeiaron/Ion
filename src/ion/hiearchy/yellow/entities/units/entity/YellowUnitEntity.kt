package ion.hiearchy.yellow.entities.units.entity

import arc.util.io.Reads
import arc.util.io.Writes
import ion.game.PermVars
import mindustry.gen.EntityMapping
import mindustry.gen.UnitEntity

open class YellowUnitEntity : UnitEntity(){

    private var inited = false

    fun initVars(){
        inited = true
    }

    override fun kill(){
        remove()
    }

    override fun destroy(){
        remove()
    }

    override fun remove(){
        if(!PermVars.removeAllowed) return
        super.remove()
    }

    override fun update(){
        super.update()

        if(team.data().countType(type) > 1){
            PermVars.removeAllowed = true
            //clones must not exist
            kill()
            destroy()
            remove()
        }else{
            PermVars.removeAllowed = false
        }
    }


    override fun write(write: Writes){
        super.write(write)
        write.bool(inited)
        /*
        mounts.forEach{
            val e = it as DisableableWeaponMount
            write.bool(e.enabled)
        }
        */
    }

    override fun read(read: Reads){
        super.read(read)
        inited = read.bool()
        /*
        mounts.forEach{
            val e = it as DisableableWeaponMount
            e.enabled = read.bool()
        }
        */
    }

    override fun classId() = mappingId

    companion object{
        val mappingId = EntityMapping.register("ion-yellow-unit", ::YellowUnitEntity)
    }
}