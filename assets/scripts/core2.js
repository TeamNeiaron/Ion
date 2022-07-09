function obtain(name){
    return Vars.mods.getMod("ion").loader.loadClass(name)
}

//classes
const GeometricBulletType = obtain("ion.entities.bullet.GeometricBulletType")
const PodBulletType = obtain("ion.entities.bullet.PodBulletType")
const SparkingContinuousLaserBulletType = obtain("ion.entities.bullet.SparkingContinuousLaserBulletType")
const UnstableEnergyBulletType = obtain("ion.entities.bullet.UnstableEnergyBulletType")
const LimitedBlock = obtain("ion.world.blocks.LimitedBlock")
