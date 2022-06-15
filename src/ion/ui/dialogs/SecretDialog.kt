package ion.ui.dialogs

import arc.scene.ui.*
import arc.scene.ui.layout.*
import arc.scene.style.*
import mindustry.ui.dialogs.*
import mindustry.gen.*

import ion.ui.dialogs.*

import com.github.mnemotechnician.mkui.*

open class SecretDialog : BaseDialog{
    constructor() : super("SECRETS"){
        addCloseButton()
    }
    
    
    fun show(icon: Drawable, secret: String){
        cont.clear()
        val t = Table()
        
        t.table{ s: Table ->
            s.addImage(icon).row()
            s.add(secret).row()
        }
        
        val s = ScrollPane(t)
        cont.add(s)
        show()
    }
    
    fun show(secret: String){
        show(Icon.admin, secret)
    }
}
