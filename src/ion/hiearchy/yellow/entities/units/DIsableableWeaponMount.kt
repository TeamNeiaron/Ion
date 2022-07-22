package ion.hiearchy.yellow.entities.units

import mindustry.entities.units.WeaponMount
import mindustry.type.Weapon

open class DisableableWeaponMount(weapon: Weapon) : WeaponMount(weapon){
    var enabled = true
}