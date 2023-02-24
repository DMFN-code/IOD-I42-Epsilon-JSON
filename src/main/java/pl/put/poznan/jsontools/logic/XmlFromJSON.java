package pl.put.poznan.jsontools.logic;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
/**
 * This class converts json to xml
 *
 * @param input is JSON given from API controller
 * @exception ResponseStatusException(HttpStatus.BAD_REQUEST)
 **/
public class XmlFromJSON {
    private String _input;
    private JSONObject _json;
    public XmlFromJSON(String input){
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
     * @return xml
     **/
    public String xml(){
        return XML.toString(_json);
    }
}
