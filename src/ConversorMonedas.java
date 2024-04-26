import com.google.gson.annotations.SerializedName;

public class ConversorMonedas {


//    @Override
//    public String toString() {
//        return "{Respuesta='" + result + '\'' +
//                ", Conversion='" + conversion_rate + '\''+"}"
//                ;
//    }


    public String result;
    public String documentation;
    public String terms_of_use;
    public int time_last_update_unix;
    public String time_last_update_utc;
    public int time_next_update_unix;
    public String time_next_update_utc;
    public String base_code;
    public String target_code;
    public float conversion_rate;
}
