package androidx.core.view;

import android.os.Build;
import android.view.Menu;
import androidx.annotation.RequiresApi;
import androidx.core.internal.view.SupportMenu;

/* loaded from: classes3.dex */
public final class MenuCompat {

    @RequiresApi
    public static class Api28Impl {
        public static void a(Menu menu) {
            menu.setGroupDividerEnabled(true);
        }
    }

    public static void a(Menu menu) {
        if (menu instanceof SupportMenu) {
            ((SupportMenu) menu).setGroupDividerEnabled(true);
        } else if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.a(menu);
        }
    }
}
