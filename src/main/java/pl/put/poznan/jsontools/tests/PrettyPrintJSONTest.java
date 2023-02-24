package pl.put.poznan.jsontools.tests;

import org.junit.jupiter.api.Test;
import pl.put.poznan.jsontools.logic.PrettyPrintJSON;

import static org.junit.jupiter.api.Assertions.*;

class PrettyPrintJSONTest {
    @Test
    void pprintTest1(){
        PrettyPrintJSON test = new PrettyPrintJSON("{\"duzo\":\"testow\",\n" +
                "\"interpolacja\":555555,\n" +
                "\"negatywna\":-4,\n" +
                "\"json\":{\"hej\":\"siema\",\"wiele\":\"elementow\",\"nakoniec\":5555},\n" +
                "\"malo\":\"pączków\"}");
        assertTrue(test.parse());
    }
    @Test
    void pprintTest2(){
        PrettyPrintJSON test = new PrettyPrintJSON("{\"duzo\":\"testow\",\n" +
                "\"interpolacja\":555555,\n" +
                "\"negatywna\":-4,\n" +
                "\"json\":{\"hej\":\"siema\",\"wiele\":\"elementow\",\"nakoniec\":5555},\n" +
                "\"malo\":\"pączków\"}");
        assertTrue(test.parse());
        assertEquals("{\n" +
                "    \n" +
                "        \"malo\": \"pączków\",\n" +
                "        \"negatywna\": -4,\n" +
                "        \"interpolacja\": 555555,\n" +
                "        \"duzo\": \"testow\",\n" +
                "        \"json\": {\n" +
                "            \"wiele\": \"elementow\",\n" +
                "            \"nakoniec\": 5555,\n" +
                "            \"hej\": \"siema\"\n" +
                "        }\n" +
                "    \n" +
                "}",test.prettyPrint());
    }
    @Test
    void pprintTest3(){
        PrettyPrintJSON test = new PrettyPrintJSON("{\"duzo\":\"testow\",\"interpolacja\":555555,\"negatywna\":-4,\"json\":{\"hej\":\"siema\",\"wiele\":\"elementow\",\"nakoniec\":5555},\"malo\":\"pączków\"}");
        assertTrue(test.parse());
        assertEquals("{\n" +
                "    \n" +
                "        \"malo\": \"pączków\",\n" +
                "        \"negatywna\": -4,\n" +
                "        \"interpolacja\": 555555,\n" +
                "        \"duzo\": \"testow\",\n" +
                "        \"json\": {\n" +
                "            \"wiele\": \"elementow\",\n" +
                "            \"nakoniec\": 5555,\n" +
                "            \"hej\": \"siema\"\n" +
                "        }\n" +
                "    \n" +
                "}",test.prettyPrint());
    }
    @Test
    void pprintTest4(){
        PrettyPrintJSON test = new PrettyPrintJSON("{\"hej\":1}");
        assertTrue(test.parse());
        assertEquals("{\n" +
                "    \n" +
                "        \"hej\": 1\n" +
                "    \n" +
                "}",test.prettyPrint());
    }
    @Test
    void pprintTest5(){
        PrettyPrintJSON test = new PrettyPrintJSON("{\"hej\":\"string\"}");
        assertTrue(test.parse());
        assertEquals("{\n" +
                "    \n" +
                "        \"hej\": \"string\"\n" +
                "    \n" +
                "}",test.prettyPrint());
    }
    @Test
    void pprintTest6(){
        PrettyPrintJSON test = new PrettyPrintJSON("{\"hej\":\"string\",\n" +
                "\"twoval\":2}");
        assertTrue(test.parse());
        assertEquals("{\n" +
                "    \n" +
                "        \"twoval\": 2,\n" +
                "        \"hej\": \"string\"\n" +
                "    \n" +
                "}",test.prettyPrint());
    }
    @Test
    void pprintTest7(){
        PrettyPrintJSON test = new PrettyPrintJSON("{\"hej\":\"string\",\n" +
                "\"twoval\":\"stringi2\"}");
        assertTrue(test.parse());
        assertEquals("{\n" +
                "    \n" +
                "        \"twoval\": \"stringi2\",\n" +
                "        \"hej\": \"string\"\n" +
                "    \n" +
                "}",test.prettyPrint());
    }
    @Test
    void pprintTest8(){
        PrettyPrintJSON test = new PrettyPrintJSON("{\"hej\":\"string\",\n" +
                "\"twoval\":\"stringi2\",\n" +
                "\"jsonik\":{\"witaj\":\"witam\"}}");
        assertTrue(test.parse());
        assertEquals("{\n" +
                "    \n" +
                "        \"jsonik\": {\n" +
                "            \"witaj\": \"witam\"\n" +
                "        },\n" +
                "        \"twoval\": \"stringi2\",\n" +
                "        \"hej\": \"string\"\n" +
                "    \n" +
                "}",test.prettyPrint());
    }
    @Test
    void pprintTest9(){
        PrettyPrintJSON test = new PrettyPrintJSON("{\"hej\":\"string\",\n" +
                "\"twoval\":\"stringi2\",\n" +
                "\"jsonik\":{\"witaj\":\"witam\",\"next\":2}}");
        assertTrue(test.parse());
        assertEquals("{\n" +
                "    \n" +
                "        \"jsonik\": {\n" +
                "            \"next\": 2,\n" +
                "            \"witaj\": \"witam\"\n" +
                "        },\n" +
                "        \"twoval\": \"stringi2\",\n" +
                "        \"hej\": \"string\"\n" +
                "    \n" +
                "}",test.prettyPrint());
    }
    @Test
    void pprintTest10(){
        PrettyPrintJSON test = new PrettyPrintJSON("{\"hej\":\"string\",\n" +
                "\"twoval\":\"stringi2\",\n" +
                "\"jsonik\":{\"witaj\":\"witam\",\"next\":2},\n" +
                "\"lastval\":5}");
        assertTrue(test.parse());
        assertEquals("{\n" +
                "    \n" +
                "        \"jsonik\": {\n" +
                "            \"next\": 2,\n" +
                "            \"witaj\": \"witam\"\n" +
                "        },\n" +
                "        \"twoval\": \"stringi2\",\n" +
                "        \"lastval\": 5,\n" +
                "        \"hej\": \"string\"\n" +
                "    \n" +
                "}",test.prettyPrint());
    }
}