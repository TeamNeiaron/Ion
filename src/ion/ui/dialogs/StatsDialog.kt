package ion.ui.dialogs

import arc.scene.ui.Dialog
import ion.game.PermVars
import mindustry.ui.dialogs.BaseDialog

open class StatsDialog() : BaseDialog("Stats (Ion)") {
    init{
        addCloseButton()
    }
    
    override fun show(): Dialog{
        cont.clear()
        
        cont.add("Kill Count (Campaign): ${PermVars.killCountCampaign}").row()
        cont.add("Kill Count (Custom): ${PermVars.killCountCustom}").row()
        cont.add("Kill Count (Campaign + Custom): ${PermVars.killCountAll}").row()
        //i ponder
        cont.add("Headpat Count (Cheesy-chan): ${PermVars.petCount}").row()
        
        return super.show()
    }
}
