package ion.game

import arc.Core.settings

import com.github.mnemotechnician.mkui.delegates.*

/** Variable sets that are saved to your save file. Does not reset when the game is closed. */
object PermaVars{
    val syn = "ion-"
    
    var testInt by setting(5, syn)
    var testFloat by setting(7f, syn)
    var killCountCampaign by setting(0, syn)
    var killCountCustom by setting(0, syn)
    var killCountAll by setting(0, syn)
    var petCount by setting(0, syn)
    var messyHair by setting(false, syn)
    var suspensive by setting(false, syn)
}
