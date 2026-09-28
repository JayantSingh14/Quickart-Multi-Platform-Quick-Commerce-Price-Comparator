package com.google.android.play.core.integrity;

import android.content.Context;

/* loaded from: classes4.dex */
final class z {

    /* renamed from: a, reason: collision with root package name */
    public static s f41847a;

    public static synchronized s a(Context context) {
        try {
            if (f41847a == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
                f41847a = new s(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f41847a;
    }
}
