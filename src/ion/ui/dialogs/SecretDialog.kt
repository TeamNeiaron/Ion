package ion.ui.dialogs

import arc.scene.ui.*
import arc.scene.ui.layout.*
import arc.scene.style.*
import arc.flabel.*
import mindustry.ui.dialogs.*
import mindustry.gen.*

import ion.ui.dialogs.*

import com.github.mnemotechnician.mkui.*

open class SecretDialog : BaseDialog{
    constructor() : super("SECRETS"){
        addCloseButton()
    }
    
    
    fun show(icon: Drawable, secret: String, flabel: Boolean){
        cont.clear()
        val t = Table()
        
        t.table{ s: Table ->
            s.addImage(icon).row()
            if(flabel){
                s.add(FLabel("{wave}$secret")).row()
            } else {
                s.add(secret).row()
            }
        }
        
        val s = ScrollPane(t)
        cont.add(s)
        show()
    }
    
    fun show(secret: String, flabel: Boolean){
        show(Icon.admin, secret, flabel)
    }
}
