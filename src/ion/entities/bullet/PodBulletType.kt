package ion.entities.bullet

import arc.Core
import arc.graphics.g2d.Draw
import mindustry.content.Fx
import mindustry.gen.Bullet
import mindustry.graphics.Drawf
import mindustry.graphics.Layer

open class PodBulletType(var sprite: String) : PartBulletType() {

    init{
        hitEffect = Fx.none
        despawnEffect = Fx.none
    }
    
    override fun draw(b: Bullet){
        super.draw(b)
        Draw.z(Layer.flyingUnitLow)
        Draw.rect(sprite, b.x, b.y, b.rotation())
        Draw.z(Layer.flyingUnitLow - 0.01f)
        Drawf.shadow(Core.atlas.find(sprite), b.x - 9f, b.y - 13f, b.rotation())
    }
}
