package androidx.browser.trusted;

import android.os.Bundle;
import android.support.customtabs.trusted.ITrustedWebActivityCallback;

/* loaded from: classes3.dex */
public final class TrustedWebActivityServiceConnection {

    /* renamed from: androidx.browser.trusted.TrustedWebActivityServiceConnection$1, reason: invalid class name */
    class AnonymousClass1 extends ITrustedWebActivityCallback.Stub {
        @Override // android.support.customtabs.trusted.ITrustedWebActivityCallback
        public final void f7() {
            throw null;
        }
    }

    public static class ActiveNotificationsArgs {
    }

    public static class CancelNotificationArgs {
    }

    public static class NotificationsEnabledArgs {
    }

    public static class NotifyNotificationArgs {
    }

    public static class ResultArgs {
    }

    public static void a(Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            throw new IllegalArgumentException("Bundle must contain ".concat(str));
        }
    }
}
