package pl.put.poznan.jsontools.logic;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MinifyJSONController implements IMinifyJSON {
    private String _input;
    private JSONObject _json;
    public MinifyJSONController(String input){
        this._input = input;
    }
    @Override
    public Boolean parse(){
        try {
            this._json = new JSONObject(this._input);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return true;
    }
    @Override
    public String minify(){
        MinifyJSON minifier = new MinifyJSON(this._input);
        return minifier.work();
    }

}
