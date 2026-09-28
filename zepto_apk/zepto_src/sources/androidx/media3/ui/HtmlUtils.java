package androidx.media3.ui;

import android.graphics.Color;
import androidx.media3.common.util.Util;
import java.util.Locale;

/* loaded from: classes3.dex */
final class HtmlUtils {
    public static String a(int i2) {
        Object[] objArr = {Integer.valueOf(Color.red(i2)), Integer.valueOf(Color.green(i2)), Integer.valueOf(Color.blue(i2)), Double.valueOf(Color.alpha(i2) / 255.0d)};
        int i3 = Util.f5744a;
        return String.format(Locale.US, "rgba(%d,%d,%d,%.3f)", objArr);
    }
}
