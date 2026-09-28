package androidx.appcompat.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;

/* loaded from: classes3.dex */
public final class AppCompatResources {
    public static ColorStateList a(int i2, Context context) {
        return ContextCompat.b(i2, context);
    }

    public static Drawable b(int i2, Context context) {
        return ResourceManagerInternal.b().d(i2, context);
    }
}
