package ion.ui.dialogs

import arc.scene.ui.*
import mindustry.ui.*
import mindustry.ui.dialogs.*

import ion.defs.*

open class SilentDialog : BaseDialog{
    constructor(name: String) : super(name, Styles.fullDialog){}
    
    override fun show(): Dialog{
        Utils.haltSound()
        return super.show()
    }
}
