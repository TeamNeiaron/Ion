package ion.type.weapons;

import mindustry.gen.Unit;
import mindustry.type.Weapon;
import mindustry.entities.units.WeaponMount;

public class SpinnyWeapon extends Weapon{
    /** Rotate speed in degrees/tick. */
    public float rotateSpeed = 0.08f;
    /** Whether or not the weapon should spin only while shooting. */
    public boolean spinOnShoot = false;
    
    public SpinnyWeapon(String name, float rSpeed){
        super(name);
        rotateSpeed = rSpeed;
        rotate = false;
    }
    
    public SpinnyWeapon(String name, boolean shootSpin){
        super(name);
        spinOnShoot = shootSpin;
    }
    
    public SpinnyWeapon(String name, float rSpeed, boolean shootSpin){
        super(name);
        rotateSpeed = rSpeed;
        spinOnShoot = shootSpin;
        rotate = false;
    }
    
    public SpinnyWeapon(String name, boolean shootSpin, float rSpeed){
        super(name);
        rotateSpeed = rSpeed;
        spinOnShoot = shootSpin;
        rotate = false;
    }
    
    public SpinnyWeapon(String name){
        super(name);
        rotate = false;
    }
    
    @Override
    public void update(Unit unit, WeaponMount mount){
        super.update(unit, mount);
        if(spinOnShoot){
            if(!mount.shoot) return;
            mount.rotation = mount.rotation + rotateSpeed;
            return;
        };
        mount.rotation = mount.rotation + rotateSpeed;
    }
}
