package cognizant.a471515.com.cfacts;


public class FactsUtils {

    public String getAppendedFactsPosition(int position, String title){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf(position)).append(" . ").append(title);
        return stringBuffer.toString();
    }
}
