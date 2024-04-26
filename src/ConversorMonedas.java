import com.google.gson.annotations.SerializedName;

public class ConversorMonedas {

//    @SerializedName("result")
//    public String result;
//    @SerializedName("documentation")
//    public String documentation;
//    @SerializedName("terms_of_use")
//    public String terms_of_use;
//    @SerializedName("time_last_update_unix")
//    public Integer time_last_update_unix;
//    @SerializedName("time_last_update_utc")
//    public String time_last_update_utc;
//    @SerializedName("time_next_update_unix")
//    public Integer time_next_update_unix;
//    @SerializedName("time_next_update_utc")
//    public String time_next_update_utc;
//    @SerializedName("base_code")
//    public String base_code;
//    @SerializedName("target_code")
//    public String target_code;
//    @SerializedName("conversion_rate")
//    public Float conversion_rate;
//
//
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
