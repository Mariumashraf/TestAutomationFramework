package levelset.Wrappers;



import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.json.JsonException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class JsonReader {
    public static String jsonFile = "Configurations.json";
    private JSONObject jsonObject;

    public JsonReader(String file){
        parseJson(file);
    }
    public void parseJson(String file){
        String jsonData = readFile(file);
        try{
            jsonObject = new JSONObject(jsonData);
        }catch(JsonException jsonException)
        {
            jsonException.printStackTrace();
        }
    }


    public static String readFile(String fileName){
        String result = "";
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line!=null){
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }
            result = stringBuilder.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public String getValueOfNode(String parent){

        String [] tree= parent.split("/");
        if (tree.length == 1){
            return jsonObject.getString(tree[0]);
        }
        int i = 1;
        JSONObject parentNode;
        parentNode = (JSONObject) jsonObject.get(tree[0]);
        while (i < tree.length-1){
            parentNode = (JSONObject)parentNode.get(tree[i]);
            i++;
        }

        return parentNode.getString(tree[i]);
    }

    public List<String> getValueOf(String parent, String child){
        JSONArray value = null;
        boolean isArray = false;
        String singleValue = null;
        Object obj = null;
        if(child == null){
            try{
                obj = jsonObject.get(parent);
                if(obj instanceof JSONArray){
                    value = new JSONArray(jsonObject.getJSONArray(parent).toString());
                    isArray = true;
                }
                else {
                    singleValue = jsonObject.getString(parent);
                }
            }catch (JsonException e){
                e.printStackTrace();
            }

        }else {
            JSONObject parentNode;
            try {
                parentNode = (JSONObject) jsonObject.get(parent);
                obj = parentNode.get(child);
                if (obj instanceof JSONArray){
                    value = new JSONArray(parentNode.getJSONArray(child).toString());
                    isArray = true;
                }else {
                    singleValue = parentNode.getString(child);
                }

            }catch (JsonException e){
                e.printStackTrace();
                return null;
            }
        }
        List<String> list = new ArrayList<>();
        if (isArray){
            for (int i = 0; i < value.length(); i++){
                try {
                    list.add(value.getString(i));
                }catch (JsonException e){
                    e.printStackTrace();
                    return null;
                }
            }
        }
        else {
            if(singleValue != null){
            list.add(singleValue.toString());}
        }
        return list;

    }



   /* public static String value;
    public static List<String> listOfValues;


    public static String readData(String key) throws Exception {
        JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(jsonFile);
        //System.out.println(jsonObject);
        return value = jsonObject.get(key).toString();
    }


    public static List readDataList(String key) throws Exception {
        JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(jsonFile);
        //System.out.println(jsonObject);
        return listOfValues= (List<String> ) jsonObject.get(key);
    }



    public static Object readJsonSimpleDemo(String filename) throws Exception {
        FileReader reader = new FileReader(filename);
        JSONParser jsonParser = new JSONParser();
        return jsonParser.parse(reader);
    }*/
    /*String value;
    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
    public String getData(String key){
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON file to map
            //Map<?, ?> map = mapper.readValue(Paths.get(jsonFile).toFile(), Map.class);
            String json = readFileAsString(jsonFile);
            ObjectNode node = mapper.readValue(json, ObjectNode.class);
            if(node.has(key)) {
                value= node.get(key).textValue();
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return value;

    }*/



    
}
