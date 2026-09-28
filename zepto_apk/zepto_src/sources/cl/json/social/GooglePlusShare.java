package cl.json.social;

import android.content.pm.PackageManager;
import com.facebook.react.bridge.ReadableMap;
import java.io.IOException;

/* loaded from: classes3.dex */
public class GooglePlusShare extends SingleShareIntent {
    @Override // cl.json.social.ShareIntent
    public final String b() {
        return "https://plus.google.com/share?url={url}";
    }

    @Override // cl.json.social.ShareIntent
    public final String c() {
        return "com.google.android.apps.plus";
    }

    @Override // cl.json.social.ShareIntent
    public final String d() {
        return "market://details?id=com.google.android.apps.plus";
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public final void f(ReadableMap readableMap) throws PackageManager.NameNotFoundException, IOException {
        super.f(readableMap);
        g(null);
    }
}
