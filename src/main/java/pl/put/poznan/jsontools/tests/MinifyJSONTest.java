package pl.put.poznan.jsontools.tests;

import org.junit.jupiter.api.Test;
import pl.put.poznan.jsontools.logic.MinifyJSON;

import static org.junit.jupiter.api.Assertions.*;

class MinifyJSONTest {
    @Test
    void minifyTest1(){
        MinifyJSON test = new MinifyJSON("{\"name\":\"John\", \"age\":30, \"car\":null}");
        assertEquals("{\"name\":\"John\",\"age\":30,\"car\":null}",test.work());
    }
    @Test
    void minifyTest2(){
        MinifyJSON test = new MinifyJSON("{\n" +
                "    \"title\": \"walka\"\n" +
                "}");
        assertEquals("{\"title\":\"walka\"}",test.work());
    }
    @Test
    void minifyTest3(){
        MinifyJSON test = new MinifyJSON("{\n" +
                "    \"pole\": 1\n" +
                "}");
        assertEquals("{\"pole\":1}",test.work());
    }
    @Test
    void minifyTest4(){
        MinifyJSON test = new MinifyJSON("{\n" +
                "    \"duzo\": \"testow\"\n" +
                "}");
        assertEquals("{\"duzo\":\"testow\"}",test.work());
    }
    @Test
    void minifyTest5(){
        MinifyJSON test = new MinifyJSON("{\n" +
                "    \"duzo\": \"testow\",\n" +
                "    \"malo\": \"pączków\"\n" +
                "}");
        assertEquals("{\"duzo\":\"testow\",\"malo\":\"pączków\"}",test.work());
    }
    @Test
    void minifyTest6(){
        MinifyJSON test = new MinifyJSON("{\n" +
                "    \"duzo\": \"testow\",\n" +
                "    \"interpolacja\": 5,\n" +
                "    \"malo\": \"pączków\"\n" +
                "}");
        assertEquals("{\"duzo\":\"testow\",\"interpolacja\":5,\"malo\":\"pączków\"}",test.work());
    }
    @Test
    void minifyTest7(){
        MinifyJSON test = new MinifyJSON("{\n" +
                "    \"duzo\": \"testow\",\n" +
                "    \"interpolacja\": 555555,\n" +
                "    \"negatywna\": -4,\n" +
                "    \"malo\": \"pączków\"\n" +
                "}");
        assertEquals("{\"duzo\":\"testow\",\"interpolacja\":555555,\"negatywna\":-4,\"malo\":\"pączków\"}",test.work());
    }
    @Test
    void minifyTest8(){
        MinifyJSON test = new MinifyJSON("{\n" +
                "    \"duzo\": \"testow\",\n" +
                "    \"interpolacja\": 555555,\n" +
                "    \"negatywna\": -4,\n" +
                "    \"json\": {\n" +
                "        \"hej\": \"siema\"\n" +
                "    },\n" +
                "    \"malo\": \"pączków\"\n" +
                "}");
        assertEquals("{\"duzo\":\"testow\",\"interpolacja\":555555,\"negatywna\":-4,\"json\":{\"hej\":\"siema\"},\"malo\":\"pączków\"}",test.work());
    }
    @Test
    void minifyTest9(){
        MinifyJSON test = new MinifyJSON("{\n" +
                "    \"duzo\": \"testow\",\n" +
                "    \"interpolacja\": 555555,\n" +
                "    \"negatywna\": -4,\n" +
                "    \"json\": {\n" +
                "        \"hej\": \"siema\",\n" +
                "        \"wiele\": \"elementow\"\n" +
                "    },\n" +
                "    \"malo\": \"pączków\"\n" +
                "}");
        assertEquals("{\"duzo\":\"testow\",\"interpolacja\":555555,\"negatywna\":-4,\"json\":{\"hej\":\"siema\",\"wiele\":\"elementow\"},\"malo\":\"pączków\"}",test.work());
    }
    @Test
    void minifyTest10(){
        MinifyJSON test = new MinifyJSON("{\n" +
                "    \"duzo\": \"testow\",\n" +
                "    \"interpolacja\": 555555,\n" +
                "    \"negatywna\": -4,\n" +
                "    \"json\": {\n" +
                "        \"hej\": \"siema\",\n" +
                "        \"wiele\": \"elementow\",\n" +
                "        \"nakoniec\": 5555\n" +
                "    },\n" +
                "    \"malo\": \"pączków\"\n" +
                "}");
        assertEquals("{\"duzo\":\"testow\",\"interpolacja\":555555,\"negatywna\":-4,\"json\":{\"hej\":\"siema\",\"wiele\":\"elementow\",\"nakoniec\":5555},\"malo\":\"pączków\"}",test.work());
    }
}