package pl.put.poznan.jsontools.logic;

import org.json.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CSVFromJSON {
    private String _input;
    private JSONArray _json;
    public CSVFromJSON(String input){
        this._input = input;
    }
    public Boolean parse(){
        try {
            this._json = new JSONArray(this._input);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return true;
    }
    public String csv(){
        return CDL.toString(_json);
    }
}