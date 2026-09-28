package com.facebook.react.views.imagehelper;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.content.res.ResourcesCompat;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import java.util.HashMap;
import java.util.Locale;
import javax.annotation.concurrent.ThreadSafe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@ThreadSafe
@Metadata
/* loaded from: classes3.dex */
public final class ResourceDrawableIdHelper {

    /* renamed from: b, reason: collision with root package name */
    public static final ResourceDrawableIdHelper f19970b = new ResourceDrawableIdHelper();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f19971a = new HashMap();

    @Metadata
    public static final class Companion {
        public static ResourceDrawableIdHelper a() {
            return ResourceDrawableIdHelper.f19970b;
        }
    }

    public static final ResourceDrawableIdHelper a() {
        return f19970b;
    }

    public final Drawable b(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        int iC = c(context, str);
        if (iC > 0) {
            return ResourcesCompat.c(context.getResources(), iC, null);
        }
        return null;
    }

    public final int c(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (str == null || str.length() == 0) {
            return 0;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String strK = StringsKt.K(lowerCase, "-", Attributes.PREDEFINED_ATTRIBUTE_PREFIX);
        try {
            return Integer.parseInt(strK);
        } catch (NumberFormatException unused) {
            synchronized (this) {
                try {
                    Integer num = (Integer) this.f19971a.get(strK);
                    if (num != null) {
                        return num.intValue();
                    }
                    int identifier = context.getResources().getIdentifier(strK, "drawable", context.getPackageName());
                    this.f19971a.put(strK, Integer.valueOf(identifier));
                    return identifier;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final Uri d(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        int iC = c(context, str);
        if (iC > 0) {
            Uri uriBuild = new Uri.Builder().scheme("res").path(String.valueOf(iC)).build();
            Intrinsics.c(uriBuild);
            return uriBuild;
        }
        Uri uri = Uri.EMPTY;
        Intrinsics.c(uri);
        return uri;
    }
}
