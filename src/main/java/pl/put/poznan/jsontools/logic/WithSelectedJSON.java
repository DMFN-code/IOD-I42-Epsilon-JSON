package pl.put.poznan.jsontools.logic;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class WithSelectedJSON {
    private final String _items;
    private String _input;
    private JSONObject _json;

    public WithSelectedJSON(String input, String items){  this._input = input; this._items = items;}
    public Boolean parse(){
        try {
            this._json = new JSONObject(this._input);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return true;
    }
    public String withSelected(){
        return selectFields(_input).toString();
    }

    public JSONObject selectFields(String string){
        JSONObject jsonObject = new JSONObject();
        String[] fields = getFields(string);
        for (String field : fields){
            jsonObject.put(field.trim(), _json.get(field.trim()));
        }
        return jsonObject;
    }
    public String[] getFields(String string){
        return this._items.split(",");
    }

}
