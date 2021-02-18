import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class JsonUtil {
    public static ArrayList<Solver> readSolvers() throws FileNotFoundException {
        String jsonText = FileUtil.readTextFile("datasets/store.json");
        ArrayList<Solver> solvers = new ArrayList<>();

        JsonArray data = JsonParser.parseString(jsonText).getAsJsonArray();

        for(JsonElement jElement: data){
            JsonObject jsonObject = jElement.getAsJsonObject();
            String name = jsonObject.get("name").getAsString();
            int period = jsonObject.get("period").getAsInt();
            int price = jsonObject.get("price").getAsInt();

            Solver storeElement = new Solver(name, period, price);
            solvers.add(storeElement);
        }
        return solvers;
    }
}
