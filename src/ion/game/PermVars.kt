package ion.game

import com.github.mnemotechnician.mkui.delegates.setting

/** Variables that are saved to your save file. Does not reset even when the game is reloaded. */
@Suppress("SpellCheckingInspection")
object PermVars{
    /** The setting string head. DO NOT MODIFY, EVER! */
    val syn = "ion-"

    var testInt by setting(5, syn)
    var testFloat by setting(7f, syn)
    /** Units killed in campaign sessions. */
    var killCountCampaign by setting(0, syn)
    /** Units killed in custom game sessions. */
    var killCountCustom by setting(0, syn)
    /** Units killed in ALL sessions. */
    var killCountAll by setting(0, syn)
    /**
     * Total amount of headpats given to Cheesy-chan.
     * Don't ask why this exists.
     */
    var petCount by setting(0, syn)
    /**
     * Returns true if Cheesy-chan is headpatted 10 times.
     * You can make a game out of this!
     */
    var messyHair by setting(false, syn)
    /** Do you want to know? */
    var suspensive by setting(false, syn)
    var removeAllowed by setting(false, syn)
}
