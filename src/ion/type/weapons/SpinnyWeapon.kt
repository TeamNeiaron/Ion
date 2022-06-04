package ion.type.weapons

import mindustry.type.Weapon
import mindustry.entities.units.WeaponMount

open class SpinnyWeapon : Weapon{
    
    var spinSpeed = 0.4f
    var spinOnShoot = false
    
    constructor(name: String) : super(name){
        rotate = false
    }
    
    constructor(name: String, rSpeed: Float) : super(name){
        spinSpeed = rSpeed
        rotate = false
    }
    
    constructor(name: String, spinShoot: Boolean) : super(name){
        spinOnShoot = spinShoot
        rotate = false
    }
    
    constructor(name: String, rSpeed: Float, spinShoot: Boolean) : super(name){
        spinSpeed = rSpeed
        spinOnShoot = spinShoot
        rotate = false
    }
    
    constructor(name: String, spinShoot: Boolean, rSpeed: Float) : super(name){
        spinSpeed = rSpeed
        spinOnShoot = spinShoot
        rotate = false
    }
    
    override fun update(unit: mindustry.gen.Unit, mount: WeaponMount){
        super.update(unit, mount)
        
        var mRot = mount.weapon.baseRotation
        
        if(spinOnShoot){
            if(!mount.shoot) return
            mRot += spinSpeed
            return
        }
        mRot += spinSpeed
    }
}
