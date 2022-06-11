function getAndWrite(link, file, overwrite, fcons){
    try{
        Http.get(link, res => {
            Streams.copyProgress(res.getResultAsStream(), file.write(!overwrite), res.getContentLength(), 4096, f => 96)
            
           cons(fcons).get(file)
        })
    } catch(e) {
        Vars.ui.showException("Http GET error", e)
    }
}
