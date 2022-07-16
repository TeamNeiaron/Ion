package ion.type.weapons

import arc.util.Time
import mindustry.entities.units.WeaponMount
import mindustry.type.Weapon

open class SpinnyWeapon(name: String) : Weapon(name) {
    
    var spinSpeed = 0.8f

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
