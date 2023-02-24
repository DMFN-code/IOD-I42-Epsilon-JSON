package pl.put.poznan.jsontools.logic;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * This class finds differences in two jsons
 *
 * Input format is (in request body):
 * json1,json2 for example:
 *
 * {
 *     "foo":"foo1"
 * },
 * {
 *     "foo":"foo2"
 * }
 * @param input input data from API controller formatted as in example
 * @exception ResponseStatusException(HttpStatus.BAD_REQUEST)
 **/

public class CompareJSON {
    private final String _input;
    private JSONObject _json1;
    private JSONObject _json2;

    public CompareJSON(String input){
        this._input = input;
    }
    /**
     * This function parses two jsons given in input string, and validates them
     * @exception ResponseStatusException(HttpStatus.BAD_REQUEST)
     **/
    public Boolean parse(){
        String[] inputs = this._input.split("(},\n|},)");
        inputs[0] = inputs[0] + '}';

        if(inputs.length != 2) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        try {
            this._json1 = new JSONObject(inputs[0]);
            this._json2 = new JSONObject(inputs[1]);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return true;
    }
    /**
     * This function finds differences in two input jsons and returns differences in list
     * formatted as below:
     *
     * {key}:{value in json 1}:{value in json 2}
     *
     * for example:
     *
     * foo:foo1:foo2
     *
     * @return differences
     **/
    public String getDiff() {
        String differences = "";

        Iterator<String> keys1 = this._json1.keys();
        Iterator<String> keys2 = this._json2.keys();

        HashSet<String> keys = new HashSet<>();
        while(keys1.hasNext()){
            keys.add(keys1.next());
        }
        while(keys2.hasNext()){
            keys.add(keys2.next());
        }

        for(String key : keys){
            String val1,val2;

            try{
                val1 = this._json1.get(key).toString();
            }catch(Exception e){
                val1 = null;
            }
            try{
                val2 = this._json2.get(key).toString();
            }catch(Exception e){
                val2 = null;
            }

            if(!java.util.Objects.equals(val1,val2))
                differences += String.format("%s:%s:%s\n",key,val1,val2);
        }

        return differences.replace(".$","");
    }
}
