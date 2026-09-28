package com.google.android.play.core.integrity;

import android.content.Context;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class IntegrityManagerFactory {
    public static StandardIntegrityManager a(Context context) {
        return ((w) ax.a(context)).a();
    }

    @NonNull
    public static IntegrityManager create(Context context) {
        return z.a(context).a();
    }
}
