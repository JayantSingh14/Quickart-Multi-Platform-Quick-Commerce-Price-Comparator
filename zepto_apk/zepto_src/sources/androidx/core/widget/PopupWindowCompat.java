package androidx.core.widget;

import android.widget.PopupWindow;
import androidx.annotation.RequiresApi;

/* loaded from: classes3.dex */
public final class PopupWindowCompat {

    @RequiresApi
    public static class Api23Impl {
    }

    public static void a(PopupWindow popupWindow) {
        popupWindow.setWindowLayoutType(2);
    }
}
