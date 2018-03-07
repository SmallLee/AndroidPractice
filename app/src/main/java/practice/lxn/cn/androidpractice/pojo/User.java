package practice.lxn.cn.androidpractice.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lixiaoniu on 2017/12/29.
 */

class User implements Parcelable{
        private int userId;
        private String userName;
//        private Book book;

        public User(int userId,String userName) {
            this.userId = userId;
            this.userName = userName;
        }

        private User(Parcel in) {
            userId = in.readInt();
            userName = in.readString();
            //book是一个对象，所以要传入上下文的类加载器
//            book = in.readParcelable(Thread.currentThread().getContextClassLoader());
        }

        public static final Creator<User> CREATOR = new Creator<User>() {
            @Override
            //从序列化的对象中恢复原始对象
            public User createFromParcel(Parcel in) {
                return new User(in);
            }

            @Override
            //创建指定长度的原始对象数组
            public User[] newArray(int size) {
                return new User[size];
            }
        };

        @Override
        //返回当前对象的内容描述
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(userId);
            dest.writeString(userName);
//            dest.writeParcelable(book,0);
        }
}
