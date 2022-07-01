function getInstance(name){
    return Reflect.get(Class.forName(name, true, Vars.mods.mainLoader()), "INSTANCE")
}

function obtain(name){
    return Class.forName(name, true, Vars.mods.mainLoader())
}

//objects
const IonVars = getInstance("ion.IonVars")
const IonUnitTypes = getInstance("ion.content.IonUnitTypes")
const IonBlocks = getInstance("ion.content.IonBlocks")
const IonStatusEffects = getInstance("ion.content.IonStatusEffects")
const IonBullets = getInstance("ion.content.IonBullets")
const IonFx = getInstance("ion.content.IonFx")
const IonItems = getInstance("ion.content.IonItems")
const IonTechTree = getInstance("ion.content.IonTechTree")
const IColor = getInstance("ion.defs.IColor")
const IDraw = getInstance("ion.defs.IDraw")
const ISettings = getInstance("ion.ui.ISettings")
const Utils = getInstance("ion.defs.Utils")

//classes
const GeometricBulletType = obtain("ion.entities.bullet.GeometricBulletType")
const PodBulletType = obtain("ion.entities.bullet.PodBulletType")
const SparkingContinuousLaserBulletType = obtain("ion.entities.bullet.SparkingContinuousLaserBulletType")
const UnstableEnergyBulletType = obtain("ion.entities.bullet.UnstableEnergyBulletType")
