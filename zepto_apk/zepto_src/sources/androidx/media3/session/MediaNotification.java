package androidx.media3.session;

import android.app.Notification;
import androidx.media3.common.util.UnstableApi;

/* loaded from: classes3.dex */
public final class MediaNotification {

    /* renamed from: a, reason: collision with root package name */
    public final int f10043a;

    /* renamed from: b, reason: collision with root package name */
    public final Notification f10044b;

    @UnstableApi
    public interface ActionFactory {
    }

    @UnstableApi
    public interface Provider {

        public interface Callback {
        }
    }

    public MediaNotification(int i2, Notification notification) {
        this.f10043a = i2;
        notification.getClass();
        this.f10044b = notification;
    }
}
