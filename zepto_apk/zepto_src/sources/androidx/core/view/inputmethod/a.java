package androidx.core.view.inputmethod;

import android.content.Context;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import com.facebook.react.bridge.ReactApplicationContext;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ ShortcutInfo.Builder a(Context context) {
        return new ShortcutInfo.Builder(context, "chuckerShortcutId");
    }

    public static /* synthetic */ ShortcutInfo.Builder e(ReactApplicationContext reactApplicationContext, String str) {
        return new ShortcutInfo.Builder(reactApplicationContext, str);
    }

    public static /* bridge */ /* synthetic */ ShortcutInfo g(Object obj) {
        return (ShortcutInfo) obj;
    }

    public static /* bridge */ /* synthetic */ ShortcutManager h(Object obj) {
        return (ShortcutManager) obj;
    }

    public static /* bridge */ /* synthetic */ Class i() {
        return ShortcutManager.class;
    }

    public static /* synthetic */ void l() {
    }
}
