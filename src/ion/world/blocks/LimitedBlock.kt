package ion.world.blocks

import mindustry.game.Team
import mindustry.world.Block
import mindustry.world.Tile
import mindustry.world.blocks.environment.Floor

/** A Block that can only be placed on a specific floor. */
open class LimitedBlock(name: String, var floor: Floor) : Block(name) {

    override fun canPlaceOn(tile: Tile, team: Team, rotation: Int): Boolean{
        return tile.floor() == floor
    }
}
