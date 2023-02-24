package pl.put.poznan.jsontools.logic;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class WithoutFieldsJSON {
    private final String _items;
    private String _input;
    private JSONObject _json;

    public WithoutFieldsJSON(String input, String items){ this._input = input; this._items = items; }
    public Boolean parse(){
        try {
            this._json = new JSONObject(this._input);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return true;
    }
    public String withoutFields(){
        return removeFields(_input).toString();
    }
    public JSONObject removeFields(String string){
        JSONObject jsonObject = this._json;
        String[] fields = getFields(string);
        for (String field : fields){
            jsonObject.remove(field.trim());
        }
        return jsonObject;
    }
    public String[] getFields(String string){
        return this._items.split(",");
    }
}
