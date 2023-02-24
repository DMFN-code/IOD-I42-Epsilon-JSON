package pl.put.poznan.jsontools.logic;

public class MinifyJSON {
    private final String _input;

    public MinifyJSON(String input){this._input = input;}

    public String work(){
        return this._input
                .replace("\n","")
                .replace(" ","")
                .replace("\t","")
                .replace("\b","")
                .replace("\r","")
                .replaceAll("\n{2,}","\n");
    }
}
