package ion.hiearchy.yellow.ui.dialogs

import ion.hiearchy.yellow.entities.units.DisableableWeaponMount
import ion.hiearchy.yellow.type.weapons.NameableWeapon
import mindustry.entities.units.WeaponMount
import mindustry.ui.dialogs.BaseDialog


open class WeaponSwitchDialog : BaseDialog("Weapon Switch"){
    init{
        addCloseButton()
    }

    fun show(weapon: Array<WeaponMount>){
        cont.clear()

        weapon.forEach{
            if(it !is DisableableWeaponMount) return
            cont.check("${(it.weapon as NameableWeapon).displayName}", it.enabled){ a: Boolean ->
                it.enabled = a
            }
        }

        super.show()
    }
}