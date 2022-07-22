package ion.hiearchy.yellow.type.weapons

import arc.func.Func
import ion.hiearchy.yellow.entities.units.DisableableWeaponMount
import mindustry.entities.units.WeaponMount
import mindustry.gen.Unit as MUnit


open class DisableableWeapon(name: String, displayName: String) : NameableWeapon(name, displayName){
    init{
        mountType = Func { DisableableWeaponMount(this) }
    }
    override fun draw(unit: MUnit?, mount: WeaponMount?){
        if(!(mount as DisableableWeaponMount).enabled) return
        super.draw(unit, mount)
    }

    override fun update(unit: MUnit?, mount: WeaponMount?){
        if(!(mount as DisableableWeaponMount).enabled) return
        super.update(unit, mount)
    }
}