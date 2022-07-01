package ion.entities.bullet

import arc.*
import arc.graphics.g2d.*
import arc.graphics.g2d.TextureAtlas.*
import mindustry.gen.*
import mindustry.graphics.*
import mindustry.entities.bullet.*

//TODO test run
open class PodBulletType : BulletType{
    
    var sprite = Core.atlas.find("launchpod")
    
    constructor(sprite: AtlasRegion) : super(){
        this.sprite = sprite
    }
    
    override fun draw(b: Bullet){
        super.draw(b)
        Draw.rect(sprite as TextureRegion, b.x, b.y, b.rotation())
        Drawf.shadow(sprite as TextureRegion, b.x, b.y, b.rotation())
    }
}
