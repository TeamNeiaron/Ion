package ion.entities.bullet;

import arc.math.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import mindustry.gen.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.graphics.*;

import ion.defs.*;

public class UnstableEnergyBulletType extends BulletType{
    /** Lightning bolt spawn chance. 
     * 0 = No lightning bolts at all.
     * 1 = Lightning bolts every tick. Hell for basically everything.
     */
    public float lightningSpawnChance = 0.1f;
    /** Total damage of each lightning bolt. */
    public float lightningDamage = 1f;
    /** Length of each lightning bolt. */
    public int lightningLength = 17;
    /** Whether or not the bullet is an orb. */
    public boolean orb = true;
    /** Draw color of bullet. Only functions if orb is set to true. */
    public Color color = Color.white;
    /** Lightning bolt draw color. */
    public Color lightningColor = Color.white;
    
    public UnstableEnergyBulletType(float lSpawnChance){
        super();
        lightningSpawnChance = lSpawnChance;
    }
    
    @Override
    public void draw(Bullet b){
        Draw.z(Layer.bullet);
        Draw.color(color);
        if(orb){
            Fill.circle(b.x, b.y, b.type.hitSize);
        } else {
            super.draw(b);
        }
    }
    
    @Override
    public void update(Bullet b){
        super.update(b);
        
        if(Mathf.chance(lightningSpawnChance)){
            Lightning.create(b.team, lightningColor, lightningDamage, b.x, b.y, Mathf.random(-360f, 360f), lightningLength);
        }
    }
}
