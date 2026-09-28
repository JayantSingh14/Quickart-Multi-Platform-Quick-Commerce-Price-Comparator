package androidx.media3.exoplayer.drm;

import androidx.media3.common.C;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import java.util.UUID;

@UnstableApi
/* loaded from: classes3.dex */
public final class ErrorStateDrmSession implements DrmSession {

    /* renamed from: a, reason: collision with root package name */
    public final DrmSession.DrmSessionException f6930a;

    public ErrorStateDrmSession(DrmSession.DrmSessionException drmSessionException) {
        this.f6930a = drmSessionException;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final UUID a() {
        return C.f5164a;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final boolean b() {
        return false;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final CryptoConfig d() {
        return null;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final void e(DrmSessionEventListener.EventDispatcher eventDispatcher) {
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final void f(DrmSessionEventListener.EventDispatcher eventDispatcher) {
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final boolean g(String str) {
        return false;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final DrmSession.DrmSessionException getError() {
        return this.f6930a;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final int getState() {
        return 1;
    }
}
