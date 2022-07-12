package ion.ui.dialogs

import arc.scene.ui.*
import arc.scene.ui.layout.*
import arc.scene.style.*
import mindustry.ui.dialogs.*
import mindustry.gen.*

import ion.game.*
import ion.defs.*

open class StatsDialog : BaseDialog{
    constructor() : super("Stats (Ion)"){
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
