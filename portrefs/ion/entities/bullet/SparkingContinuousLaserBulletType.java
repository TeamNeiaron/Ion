package ion.entities.bullet;

import arc.math.*;
import arc.graphics.*;
import mindustry.gen.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;

public class SparkingContinuousLaserBulletType extends ContinuousLaserBulletType{
    /** Lightning bolt spawn chance. See UnstableEnergyBulletType#lightningSpawnChance for extra info. */
    public float lightningSpawnChance = 0.3f;
    /** Total damage of each lightning bolt. */
    public float lightningDamage = 1f;
    /** Length of each lightning bolt. */
    public int lightningLength = 24;
    /** Lightning bolt draw color. */
    public Color lightningColor = Color.white;
    
    public SparkingContinuousLaserBulletType(float lSpawnChance){
        super();
        lightningSpawnChance = lSpawnChance;
    }
    
    @Override
    public void update(Bullet b){
        super.update(b);
        
        if(Mathf.chance(lightningSpawnChance)){
            Lightning.create(b.team, lightningColor, lightningDamage, b.x, b.y, b.rotation(), lightningLength);
        }
    }
}
