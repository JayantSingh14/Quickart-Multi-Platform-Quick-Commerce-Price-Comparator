package androidx.core.os;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.result.ActivityResult;
import androidx.annotation.RequiresApi;

/* loaded from: classes.dex */
public final class BundleCompat {

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api33Impl {
        public static Object a(Bundle bundle, String str) {
            return bundle.getParcelable(str, ActivityResult.class);
        }
    }

    public static Object a(Bundle bundle, String str) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.a(bundle, str);
        }
        Parcelable parcelable = bundle.getParcelable(str);
        if (ActivityResult.class.isInstance(parcelable)) {
            return parcelable;
        }
        return null;
    }
}
