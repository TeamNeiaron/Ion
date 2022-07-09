package ion.game

import arc.Core.settings

import com.github.mnemotechnician.mkui.delegates.*

/** Variable sets that are saved to your save file. Does not reset when the game is closed. */
object PermaVars{
    var testInt by setting(5, "ion-")
    var testFloat by setting(7f, "ion-")
    var killCountCampaign by setting(0, "ion-")
    var killCountCustom by setting(0, "ion-")
    var killCountAll by setting(0, "ion-")
}
