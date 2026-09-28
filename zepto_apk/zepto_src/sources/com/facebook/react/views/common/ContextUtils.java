package com.facebook.react.views.common;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ContextUtils {
    public static final Context a(Context context) {
        Context baseContext;
        Intrinsics.checkNotNullParameter(Activity.class, "clazz");
        while (!Activity.class.isInstance(context)) {
            if (!(context instanceof ContextWrapper) || context == (baseContext = ((ContextWrapper) context).getBaseContext())) {
                return null;
            }
            context = baseContext;
        }
        return context;
    }
}
