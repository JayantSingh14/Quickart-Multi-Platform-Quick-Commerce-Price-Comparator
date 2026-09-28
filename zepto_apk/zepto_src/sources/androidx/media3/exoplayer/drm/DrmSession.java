package androidx.media3.exoplayer.drm;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.UUID;

@UnstableApi
/* loaded from: classes3.dex */
public interface DrmSession {

    public static class DrmSessionException extends IOException {

        /* renamed from: a, reason: collision with root package name */
        public final int f6923a;

        public DrmSessionException(int i2, Throwable th) {
            super(th);
            this.f6923a = i2;
        }
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    static void c(DrmSession drmSession, DrmSession drmSession2) {
        if (drmSession == drmSession2) {
            return;
        }
        if (drmSession2 != null) {
            drmSession2.e(null);
        }
        if (drmSession != null) {
            drmSession.f(null);
        }
    }

    UUID a();

    default boolean b() {
        return false;
    }

    CryptoConfig d();

    void e(DrmSessionEventListener.EventDispatcher eventDispatcher);

    void f(DrmSessionEventListener.EventDispatcher eventDispatcher);

    boolean g(String str);

    DrmSessionException getError();

    int getState();
}
