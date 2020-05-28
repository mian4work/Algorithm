import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception{
	    getRecordsByAgeGroup(10, 20, 30);
    }


    /*
     * Complete the 'getRecordsByAgeGroup' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER ageStart
     *  2. INTEGER ageEnd
     *  3. INTEGER bpDiff
     *
     *  https://jsonmock.hackerrank.com/api/medical_records
     */

    public static List<Integer> getRecordsByAgeGroup(int ageStart, int ageEnd, int bpDiff) throws Exception{
        //first make http calls
        int totalPage = 10;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i <= totalPage; i++) {
            URL url = new URL("https://jsonmock.hackerrank.com/api/medical_records?&page=" + i);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            StringBuffer res = new StringBuffer();
            while((line = in.readLine()) != null) {
                res.append(line);
            }
            in.close();

            //second, convert the string into json object
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("javascript");
            String script = "Java.asJSONCompatible(" + res.toString() + ")";
            Map map = (Map)engine.eval(script);

            //third, start analyze the json object
            totalPage = Integer.valueOf((String)map.get("total_pages"));
            String age = (String)map.get("data").get("userDob");
            Integer year = Integer.valueOf(s.split("-")[2]);

            Integer diastole = Integer.valueOf((String)map.get(data).get("vitals").get("bloodPressureDiastole"));
            Integer systole = Integer.valueOf((String)map.get(data).get("vitals").get("bloodPressureSystole"));

            if(year <= ageEnd && year >= ageStart && (diastole - systole) > bpDiff) {
                Integer id = Integer.valueOf(map.get(data).get(id));
                result.add(id);
            }
        }
        return result;
    }
}
