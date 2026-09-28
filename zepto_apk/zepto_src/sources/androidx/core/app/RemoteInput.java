package androidx.core.app;

import android.app.RemoteInput;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public final class RemoteInput {

    @RequiresApi
    public static class Api20Impl {
    }

    @RequiresApi
    public static class Api26Impl {
    }

    @RequiresApi
    public static class Api28Impl {
    }

    @RequiresApi
    public static class Api29Impl {
        public static void a(RemoteInput.Builder builder) {
            builder.setEditChoicesBeforeSending(0);
        }
    }

    public static final class Builder {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface EditChoicesBeforeSending {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface Source {
    }
}
