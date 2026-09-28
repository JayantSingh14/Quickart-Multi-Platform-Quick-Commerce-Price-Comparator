package com.google.android.play.core.review;

import android.content.Context;

/* loaded from: classes4.dex */
public class ReviewManagerFactory {
    public static zzd a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return new zzd(new zzi(context));
    }
}
