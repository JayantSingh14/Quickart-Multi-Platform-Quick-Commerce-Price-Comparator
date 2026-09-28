package com.google.android.play.core.integrity;

import android.content.Context;

/* loaded from: classes4.dex */
final class ax {

    /* renamed from: a, reason: collision with root package name */
    public static w f41792a;

    public static synchronized aw a(Context context) {
        if (f41792a == null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            f41792a = new w(context);
        }
        return f41792a;
    }
}
