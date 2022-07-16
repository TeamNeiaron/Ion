package ion.ui.dialogs

import arc.scene.ui.Dialog
import ion.game.PermaVars
import mindustry.ui.dialogs.BaseDialog

open class StatsDialog() : BaseDialog("Stats (Ion)") {
    init{
        addCloseButton()
    }
    
    override fun show(): Dialog{
        cont.clear()
        
        cont.add("Kill Count (Campaign): ${PermaVars.killCountCampaign}").row()
        cont.add("Kill Count (Custom): ${PermaVars.killCountCustom}").row()
        cont.add("Kill Count (Campaign + Custom): ${PermaVars.killCountAll}").row()
        //i ponder
        cont.add("Headpat Count (Cheesy-chan): ${PermaVars.petCount}").row()
        
        return super.show()
    }
}
