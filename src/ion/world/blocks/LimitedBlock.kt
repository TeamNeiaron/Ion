package ion.world.blocks

import mindustry.game.*
import mindustry.world.*
import mindustry.content.*

/** A Block that can only be placed on a specific tile. */
open class LimitedBlock : Block{
    
    var t = Blocks.air
    
    constructor(name: String, tile: Block) : super(name){
        t = tile
    }
    
    override fun canPlaceOn(tile: Tile, team: Team, rotation: Int): Boolean{
        return tile != t
    }
}
