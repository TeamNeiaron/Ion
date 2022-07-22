package ion.hiearchy.yellow.type.weapons

import mindustry.type.Weapon

/** A weapon with a configurable display name. Does not add anything new. */
open class NameableWeapon(name: String, var displayName: String) : Weapon(name){
}