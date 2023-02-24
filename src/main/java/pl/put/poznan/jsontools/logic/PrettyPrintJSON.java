package pl.put.poznan.jsontools.logic;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


/**
 * This class pretty prints JSON
 *
 * @param input is JSON given from API controller
 * @exception ResponseStatusException(HttpStatus.BAD_REQUEST)
 **/
public class PrettyPrintJSON {
    private String _input;
    private JSONObject _json;
    public PrettyPrintJSON(String input){
        this._input = input;
    }
    /**
     * This function parses and validates JSON at input
     * @exception ResponseStatusException(HttpStatus.BAD_REQUEST)
     **/
    public Boolean parse(){
        try {
            this._json = new JSONObject(this._input);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return true;
    }
    /**
     * This function converts json to xml and returns it
     * @return str pretty printed JSON
     **/
    public String prettyPrint(){
        String str = _json.toString(4);
        str = new StringBuilder(str)
                .insert(str.length()-1, "\n")
                .insert(1, "\n")
                .toString()
                .replace("\n","\n    ")
                .replaceAll("\n    }$","\n}");
        return str;
    }

}
