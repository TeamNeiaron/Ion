package ion.entities.abilities

import mindustry.type.*
import mindustry.entities.abilities.*

open class ControllableUnitSpawnAbility : UnitSpawnAbility{
    var enabled = true
    
    constructor(unit: UnitType, spawnTime: Float, spawnX: Float, spawnY: Float) : super(unit, spawnTime, spawnX, spawnY){}
    
    override fun update(unit: mindustry.gen.Unit){
        if(enabled) super.update(unit)
    }
}