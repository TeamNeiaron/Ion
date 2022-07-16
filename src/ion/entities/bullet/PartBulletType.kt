package ion.entities.bullet

import arc.struct.Seq
import arc.util.Time
import mindustry.entities.bullet.BulletType
import mindustry.entities.part.DrawPart
import mindustry.gen.Bullet

open class PartBulletType : BulletType(){
    
    val parts = Seq<DrawPart>(DrawPart::class.java)
    
    override fun init(b: Bullet){
        super.init(b)
        b.data(floatArrayOf(0f, 0f))
        val data = b.data() as FloatArray
        data[1] = b.lifetime
    }
    
    override fun update(b: Bullet){
        super.update(b)
        val data = b.data() as FloatArray
        data[0] = (data[0] + Time.delta).coerceAtMost(data[1])
    }
    
    override fun draw(b: Bullet){
        super.draw(b)
        val data = b.data() as FloatArray
        
        if(parts.size > 0){
            
            DrawPart.params.set(0f, 0f, 0f, 0f, 0f, 0f, b.x, b.y, b.rotation())
            DrawPart.params.life = data[0] / data[1]

            for (i in 0..parts.size - 1) {
                val part = parts[i]

                part.draw(DrawPart.params)
            }
        }
    }
}
