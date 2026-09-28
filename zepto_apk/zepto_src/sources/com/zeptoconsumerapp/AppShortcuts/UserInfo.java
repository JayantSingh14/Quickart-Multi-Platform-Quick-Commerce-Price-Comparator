package com.zeptoconsumerapp.AppShortcuts;

import android.os.PersistableBundle;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
class UserInfo {

    @SerializedName("url")
    private String url;

    public UserInfo() {
    }

    public static UserInfo a(PersistableBundle persistableBundle) {
        UserInfo userInfo = new UserInfo();
        userInfo.url = persistableBundle.getString("url");
        return userInfo;
    }

    public static UserInfo b(UserInfo userInfo) {
        UserInfo userInfo2 = new UserInfo();
        if (userInfo != null) {
            userInfo2.url = userInfo.url;
        }
        return userInfo2;
    }

    public final String c() {
        return this.url;
    }

    public final PersistableBundle d() {
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("url", this.url);
        return persistableBundle;
    }

    public final WritableMap e() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("url", this.url);
        return writableMapCreateMap;
    }

    public UserInfo(String str) {
        this.url = str;
    }
}
