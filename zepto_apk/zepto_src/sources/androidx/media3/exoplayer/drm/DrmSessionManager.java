package androidx.media3.exoplayer.drm;

import android.os.Looper;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.analytics.p;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;

@UnstableApi
/* loaded from: classes3.dex */
public interface DrmSessionManager {

    /* renamed from: a, reason: collision with root package name */
    public static final DrmSessionManager f6929a = new AnonymousClass1();

    /* renamed from: androidx.media3.exoplayer.drm.DrmSessionManager$1, reason: invalid class name */
    public class AnonymousClass1 implements DrmSessionManager {
        @Override // androidx.media3.exoplayer.drm.DrmSessionManager
        public final void a(Looper looper, PlayerId playerId) {
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionManager
        public final DrmSession b(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
            if (format.q == null) {
                return null;
            }
            return new ErrorStateDrmSession(new DrmSession.DrmSessionException(6001, new UnsupportedDrmException()));
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionManager
        public final int c(Format format) {
            return format.q != null ? 1 : 0;
        }
    }

    public interface DrmSessionReference {
        public static final p e0 = new p(3);

        void release();
    }

    void a(Looper looper, PlayerId playerId);

    DrmSession b(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format);

    int c(Format format);

    default DrmSessionReference d(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        return DrmSessionReference.e0;
    }

    default void p() {
    }

    default void release() {
    }
}
