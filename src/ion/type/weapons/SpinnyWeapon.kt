package ion.type.weapons

import mindustry.type.Weapon
import mindustry.entities.units.WeaponMount

open class SpinnyWeapon : Weapon{
    
    var spinSpeed = 0.4f
    
    constructor(name: String) : super(name){
        rotate = false
        shootCone = 360f
        baseRotation = 1f
    }
    
    constructor(name: String, rSpeed: Float) : super(name){
        spinSpeed = rSpeed
        rotate = false
        shootCone = 360f
        baseRotation = 1f
    }
    
    override fun update(unit: mindustry.gen.Unit, mount: WeaponMount){
        super.update(unit, mount)
        
        var mRot = mount.weapon.baseRotation
        
        mRot += spinSpeed
    }
}
