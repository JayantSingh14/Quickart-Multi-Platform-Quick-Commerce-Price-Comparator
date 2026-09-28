package com.zeptoconsumerapp.AppShortcuts;

import android.os.PersistableBundle;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
class ShortcutItem {

    @SerializedName("icon")
    String icon;

    @SerializedName("localPath")
    public String localPath;

    @SerializedName("title")
    String title;

    @SerializedName("type")
    String type;

    @SerializedName("userInfo")
    UserInfo userInfo;

    public ShortcutItem() {
    }

    public static ShortcutItem a(PersistableBundle persistableBundle) {
        ShortcutItem shortcutItem = new ShortcutItem();
        shortcutItem.type = persistableBundle.getString("type");
        shortcutItem.title = persistableBundle.getString("title");
        shortcutItem.icon = persistableBundle.getString("icon");
        shortcutItem.userInfo = UserInfo.a(persistableBundle.getPersistableBundle("userInfo"));
        return shortcutItem;
    }

    public static ShortcutItem b(ShortcutItem shortcutItem) {
        ShortcutItem shortcutItem2 = new ShortcutItem();
        shortcutItem2.type = shortcutItem.type;
        shortcutItem2.title = shortcutItem.title;
        shortcutItem2.icon = shortcutItem.icon;
        shortcutItem2.localPath = shortcutItem.localPath;
        UserInfo userInfo = shortcutItem.userInfo;
        if (userInfo != null) {
            shortcutItem2.userInfo = UserInfo.b(userInfo);
        }
        return shortcutItem2;
    }

    public final PersistableBundle c() {
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("type", this.type);
        persistableBundle.putString("title", this.title);
        persistableBundle.putString("icon", this.icon);
        persistableBundle.putPersistableBundle("userInfo", this.userInfo.d());
        return persistableBundle;
    }

    public final WritableMap d() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("type", this.type);
        writableMapCreateMap.putString("title", this.title);
        writableMapCreateMap.putString("icon", this.icon);
        writableMapCreateMap.putMap("userInfo", this.userInfo.e());
        return writableMapCreateMap;
    }

    public ShortcutItem(String str, String str2, String str3, String str4, UserInfo userInfo) {
        this.localPath = str;
        this.type = str2;
        this.title = str3;
        this.icon = str4;
        this.userInfo = userInfo;
    }
}
