package pl.put.poznan.jsontools.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import pl.put.poznan.jsontools.logic.*;


@RestController

public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);


    @CrossOrigin
    @RequestMapping(value = "/minify", method = RequestMethod.POST, produces = "application/json")
    public String minify(@RequestBody String input) {
        MinifyJSONController incoming = new MinifyJSONController(input);
        if(!incoming.parse()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return incoming.minify();
    }
    @CrossOrigin
    @RequestMapping(value = "/prettyprint", method = RequestMethod.POST, produces = "application/json")
    public String prettyPrint(@RequestBody String input){

        PrettyPrintJSON incoming = new PrettyPrintJSON(input);
        if(!incoming.parse()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return incoming.prettyPrint();
    }
    @CrossOrigin
    @RequestMapping(value = "/xml", method = RequestMethod.POST, produces = "application/json")
    public String xml(@RequestBody String input){

        XmlFromJSON incoming = new XmlFromJSON(input);
        if(!incoming.parse()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return incoming.xml();
    }
    @CrossOrigin
    @RequestMapping(value = "/withoutfields", method = RequestMethod.POST, produces = "application/json")
    public String withoutFields(@RequestBody String input, @RequestParam String items){

        WithoutFieldsJSON incoming = new WithoutFieldsJSON(input, items);
        if(!incoming.parse()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return incoming.withoutFields();
    }
    @CrossOrigin
    @RequestMapping(value = "/csv", method = RequestMethod.POST, produces = "application/json")
    public String csv(@RequestBody String input) {

        CSVFromJSON incoming = new CSVFromJSON(input);
        if (!incoming.parse()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return incoming.csv();
    }
    @CrossOrigin
    @RequestMapping(value = "/compare", method = RequestMethod.POST, produces = "application/json")
    public String compare(@RequestBody String input){

        CompareJSON incoming = new CompareJSON(input);
        if(!incoming.parse()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return incoming.getDiff();
    }
    @CrossOrigin
    @RequestMapping(value = "/withselected", method = RequestMethod.POST, produces = "application/json")
    public String withSelected(@RequestBody String input, @RequestParam String items){

        WithSelectedJSON incoming = new WithSelectedJSON(input,items);
        if(!incoming.parse()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return incoming.withSelected();
    }
}


