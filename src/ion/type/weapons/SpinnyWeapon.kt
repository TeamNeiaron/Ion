package ion.type.weapons

import mindustry.type.Weapon
import mindustry.entities.units.WeaponMount

open class SpinnyWeapon : Weapon{
    
    var spinSpeed = 0.8f
    
    constructor(name: String) : super(name){
        rotate = true
        shootCone = 360f
        baseRotation = 1f
    }
    
    constructor(name: String, rSpeed: Float) : super(name){
        spinSpeed = rSpeed
        rotate = true
        shootCone = 360f
        baseRotation = 1f
    }
    
    override fun update(unit: mindustry.gen.Unit, mount: WeaponMount){
        super.update(unit, mount)
        
        mount.weapon.baseRotation += spinSpeed
    }
}
