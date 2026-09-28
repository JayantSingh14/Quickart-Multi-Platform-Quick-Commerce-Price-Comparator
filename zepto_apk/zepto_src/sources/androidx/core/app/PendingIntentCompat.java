package androidx.core.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public final class PendingIntentCompat {

    @RequiresApi
    public static class Api23Impl {
    }

    @RequiresApi
    public static class Api26Impl {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface Flags {
    }

    public static class GatedCallback implements Closeable, AutoCloseable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            throw null;
        }
    }

    public static PendingIntent a(Context context, int i2, Intent intent) {
        return PendingIntent.getActivity(context, i2, intent, 201326592);
    }
}
