package ion.type.weapons

import arc.util.Time
import mindustry.entities.units.WeaponMount
import mindustry.type.Weapon

/** An extension of Weapon that rotates indefinitely. */
open class SpinnyWeapon(name: String, var spinSpeed: Float = 0.8f) : Weapon(name) {

    init{
        rotate = false
        shootCone = 360f
        baseRotation = 1f
    }

    override fun update(unit: mindustry.gen.Unit, mount: WeaponMount){
        super.update(unit, mount)
        
        mount.weapon.baseRotation += Time.delta * spinSpeed
        mount.rotation += Time.delta * spinSpeed
        mount.targetRotation += Time.delta * spinSpeed
    }
}
