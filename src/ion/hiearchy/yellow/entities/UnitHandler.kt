package ion.hiearchy.yellow.entities

import arc.func.Prov
import arc.struct.ObjectIntMap
import arc.struct.ObjectMap
import mindustry.gen.EntityMapping
import mindustry.gen.Entityc

object UnitHandler{
    val types = arrayOf<ObjectMap.Entry<Class<out Entityc>, Prov<out Entityc>>>()
    val idMap = ObjectIntMap<Class<out Entityc>>()

    fun <T : Entityc?> prov(type: Class<T>, prov: Prov<T>): ObjectMap.Entry<Class<T>, Prov<T>>{
        val entry = ObjectMap.Entry<Class<T>, Prov<T>>()
        entry.key = type
        entry.value = prov
        return entry
    }

    fun setupID(){
        var i = 0
        var j = 0
        val len = EntityMapping.idMap.size
        while (i < len){
            if (EntityMapping.idMap[i] == null){
                idMap.put(types[j].key, i)
                EntityMapping.idMap[i] = types[j].value
                if (++j >= types.size) break
            }
            i++
        }
    }

    fun <T : Entityc?> classID(type: Class<out Entityc>): Int{
        return idMap.get(type, -1)
    }
}