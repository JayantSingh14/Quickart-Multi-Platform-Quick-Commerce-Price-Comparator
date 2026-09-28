package com.google.android.material.appbar;

import android.app.NotificationChannel;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import java.nio.file.attribute.AclEntryPermission;

/* loaded from: classes4.dex */
public abstract /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ boolean C(Drawable drawable) {
        return drawable instanceof AdaptiveIconDrawable;
    }

    public static /* synthetic */ NotificationChannel b(String str) {
        return new NotificationChannel("fcm_fallback_notification_channel", str, 3);
    }

    public static /* bridge */ /* synthetic */ Class d() {
        return AclEntryPermission.class;
    }
}
