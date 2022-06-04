package ion.type.weapons

import mindustry.type.Weapon
import mindustry.entities.units.WeaponMount

open class SpinnyWeapon : Weapon{
    
    var spinSpeed = 0.4f
    var spinOnShoot = false
    
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
    
    constructor(name: String, spinShoot: Boolean) : super(name){
        spinOnShoot = spinShoot
        rotate = false
        shootCone = 360f
        baseRotation = 1f
    }
    
    constructor(name: String, rSpeed: Float, spinShoot: Boolean) : super(name){
        spinSpeed = rSpeed
        spinOnShoot = spinShoot
        rotate = false
        shootCone = 360f
        baseRotation = 1f
    }
    
    constructor(name: String, spinShoot: Boolean, rSpeed: Float) : super(name){
        spinSpeed = rSpeed
        spinOnShoot = spinShoot
        rotate = false
        shootCone = 360f
        baseRotation = 1f
    }
    
    override fun update(unit: mindustry.gen.Unit, mount: WeaponMount){
        super.update(unit, mount)
        
        var mRot = mount.weapon.baseRotation
        
        if(spinOnShoot && !mount.shoot) return
        
        mRot += spinSpeed
    }
}
