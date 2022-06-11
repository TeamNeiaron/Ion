package ion.defs

import arc.scene.ui.*
import arc.scene.ui.layout.*
import mindustry.type.*
import mindustry.type.ammo.*

//region units

/** Sets this unit's shield health to its max health. */
fun mindustry.gen.Unit.maxShield(){
    this.shield = this.maxHealth
}

/** Splits this unit's health to half, with the other half going down under. */
fun mindustry.gen.Unit.splitHealth(){
    this.health -= this.health / 2f
}

fun UnitType.powerCapacity(
    power: Float,
    range: Float = 85f
){
    val p = PowerAmmoType(power)
    p.range = range
    this.ammoType = p
}
