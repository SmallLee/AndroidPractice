import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 描述：
 */
public class DateFormatTest {
    private static SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd", Locale.getDefault());
    private static String[] date = {"2018-07-17","2018-07-18","2018-07-19"};
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            final int finalI = i;
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    Date s = null;
                    try {
                        s = sdf.parse(date[finalI]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    System.out.println(s);
                }
            }.start();
        }
    }
}

