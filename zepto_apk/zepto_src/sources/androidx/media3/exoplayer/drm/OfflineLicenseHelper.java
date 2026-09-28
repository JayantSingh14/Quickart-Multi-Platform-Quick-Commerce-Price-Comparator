package androidx.media3.exoplayer.drm;

import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.MediaSource;

@UnstableApi
/* loaded from: classes3.dex */
public final class OfflineLicenseHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f6947a = 0;

    /* renamed from: androidx.media3.exoplayer.drm.OfflineLicenseHelper$1, reason: invalid class name */
    class AnonymousClass1 implements DrmSessionEventListener {
        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void E(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            int i3 = OfflineLicenseHelper.f6947a;
            throw null;
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void K(int i2, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
            int i3 = OfflineLicenseHelper.f6947a;
            throw null;
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public final void S(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            int i3 = OfflineLicenseHelper.f6947a;
            throw null;
        }
    }

    static {
        Format.Builder builder = new Format.Builder();
        builder.p = new DrmInitData(new DrmInitData.SchemeData[0]);
        builder.a();
    }
}
