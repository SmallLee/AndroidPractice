package practice.lxn.cn.androidpractice.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import practice.lxn.cn.androidpractice.R;
import practice.lxn.cn.androidpractice.pojo.Book;

public class GsonActivity extends AppCompatActivity {
    private static final String TAG = "GsonActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
        Gson gson = new GsonBuilder().
                // 序列化时导出null值
                serializeNulls().
                        // 默认输入一行json字符串，此时输出格式化的json字符串
                setPrettyPrinting().
                        // 设置日期格式
                        setDateFormat("yyyy-MM-dd HH:mm:ss").
                        // 禁止序列化内部类
                        disableInnerClassSerialization()
                // 生成不可执行的Json（多了 )]}' 这4个字符）
                .generateNonExecutableJson()
                // 禁止转义HTml标签
                .disableHtmlEscaping().
                        create();
//        double json = gson.fromJson("\"99.99\"",double.class);
//        double json2 = gson.fromJson("99.90",double.class);
//        Log.d(TAG, "json: " +json );
//        Log.d(TAG, "json2: " +json2 );
        Book book = new Book(1,"疯狂Java");
        String bookJson = gson.toJson(book);
        Log.d(TAG, "bookJson: " + bookJson);
        String json = " {\n" +
                "      \"bookId\": 1,\n" +
                "      \"bookName\": \"疯狂Java\",\n" +
                "      \"time\": \"Aug 19, 2010 4:13:57 PM\"\n" +
                "    }";
        Book bookInfo = gson.fromJson(json, Book.class);
        Log.d(TAG, "bookInfo: " + bookInfo.toString());
    }
}
