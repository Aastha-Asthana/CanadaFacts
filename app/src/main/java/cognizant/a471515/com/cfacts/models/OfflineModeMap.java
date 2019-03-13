package cognizant.a471515.com.cfacts.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;


/**
 * Bean class created to support offline API call mode with static response
 */
public class OfflineModeMap implements Serializable {

    @SerializedName("offlinemodemap")
    private HashMap<String,String> offlinemodemap;

    public HashMap<String, String> getOfflinemodemap() {
        return offlinemodemap;
    }

    public void setOfflinemodemap(HashMap<String, String> offlinemodemap) {
        this.offlinemodemap = offlinemodemap;
    }
}
