package cognizant.a471515.com.cfacts;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class FactsUtils {

    public static boolean isOfflineMode = true;

    public String getAppendedFactsPosition(int position, String title){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf(position)).append(" . ").append(title);
        return stringBuffer.toString();
    }

    public String loadJsonFromRaw(String filename){
        Writer writer = new StringWriter();
            try {
                InputStream is = Facts.context.getResources().getAssets().open(filename);

                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                String line = reader.readLine();
                while (line != null) {
                    writer.write(line);
                    line = reader.readLine();
                }
            } catch (Exception e) {
                Log.e("Exception", "Unhandled exception while using JSONResourceReader", e);
            }

           return writer.toString();
        }

    public <T> T constructUsingGson(String jsonString,Class<T> type) {
       Gson gson = new GsonBuilder().create();
       return gson.fromJson(jsonString,type);

    }
}
