package ion.type.weapons

import mindustry.type.Weapon
import mindustry.entities.units.WeaponMount

open class SpinnyWeapon : Weapon{
    
    lateinit var rotateSpeed = 0.08f
    lateinit var spinOnShoot = false
    
    constructor(name: String) : super(name){
        rotate = false
    }
    
    constructor(name: String, rSpeed: Float) : super(name){
        rotateSpeed = rSpeed
        rotate = false
    }
    
    constructor(name: String, spinShoot: Boolean) : super(name){
        spinOnShoot = spinShoot
        rotate = false
    }
    
    constructor(name: String, rSpeed: Float, spinShoot: Boolean) : super(name){
        rotateSpeed = rSpeed
        spinOnShoot = spinShoot
        rotate = false
    }
    
    constructor(name: String, spinShoot: Boolean, rSpeed: Float) : super(name){
        rotateSpeed = rSpeed
        spinOnShoot = spinShoot
        rotate = false
    }
    
    override fun update(unit: mindustry.gen.Unit, mount: WeaponMount){
        super.update(unit, mount)
        if(spinOnShoot){
            if(!mount.shoot) return
            mount.rotation = mount.rotation + rotateSpeed
            return
        }
        mount.rotation = mount.rotation + rotateSpeed
    }
}
