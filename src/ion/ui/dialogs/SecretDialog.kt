package ion.ui.dialogs

import arc.flabel.FLabel
import arc.scene.style.Drawable
import arc.scene.ui.ScrollPane
import arc.scene.ui.layout.Table
import com.github.mnemotechnician.mkui.extensions.dsl.addImage
import mindustry.gen.Icon
import mindustry.ui.dialogs.BaseDialog

open class SecretDialog : BaseDialog("SECRETS"){
    init{
        addCloseButton()
    }
    
    
    fun show(icon: Drawable, secret: String, flabel: Boolean){
        cont.clear()
        val t = Table()
        
        t.table{ s: Table ->
            s.addImage(icon).row()
            if(flabel){
                s.add(FLabel(secret)).row()
            } else {
                s.add(secret).row()
            }
        }
        
        val s = ScrollPane(t)
        cont.add(s)
        show()
    }
    //real shit sherlock
    fun show(secret: String, flabel: Boolean){
        show(Icon.admin, secret, flabel)
    }
}
