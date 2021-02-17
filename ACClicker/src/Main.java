import com.google.gson.JsonElement;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<StoreElement> storeElements = null;
        try {
            storeElements = JsonUtil.readStoreElements();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("a");
    }
}
