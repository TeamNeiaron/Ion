package ion.content

import ion.game.*

object IonAchievements{
    lateinit var test: Achievement
    lateinit var test2: Achievement
    lateinit var makingEndsMeet: Achievement
    lateinit var reunited: Achievement
    
    lateinit var all: Array<Achievement>
    
    fun load(){
        test = object : Achievement("test", "Test Achievement"){
            init{
                description = "A test achievement."
            }
        }

        test2 = object : Achievement("test-2", "Another Test Achievement"){
            init{
                description = "\"How does one obtain me?\" - The achievement curiously asks."
            }
        }
        
        makingEndsMeet = object : Achievement("making-ends-meet", "Making Ends Meet"){
            init{
                description = "Obtain 100 of every single item."
            }
        }
        
        reunited = object : Achievement("reunited", "Reunited"){
            init{
                description = "[lightgray]...Smol?[]\nFind Yellow-chan."
            }
        }
        
        all = arrayOf(test, test2, makingEndsMeet, reunited)
    }
}
