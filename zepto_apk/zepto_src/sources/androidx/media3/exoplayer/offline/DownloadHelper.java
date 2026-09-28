package androidx.media3.exoplayer.offline;

import android.os.Handler;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.RendererCapabilitiesList;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.source.BaseMediaSource;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.trackselection.BaseTrackSelection;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import java.io.IOException;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class DownloadHelper {

    /* renamed from: androidx.media3.exoplayer.offline.DownloadHelper$1, reason: invalid class name */
    class AnonymousClass1 implements VideoRendererEventListener {
    }

    /* renamed from: androidx.media3.exoplayer.offline.DownloadHelper$2, reason: invalid class name */
    class AnonymousClass2 implements AudioRendererEventListener {
    }

    public interface Callback {
    }

    public static final class DownloadTrackSelection extends BaseTrackSelection {

        public static final class Factory implements ExoTrackSelection.Factory {
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final int d() {
            return 0;
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final void g(long j2, long j3, long j4, List list, MediaChunkIterator[] mediaChunkIteratorArr) {
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final Object j() {
            return null;
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final int s() {
            return 0;
        }
    }

    public static final class FakeBandwidthMeter implements BandwidthMeter {
        @Override // androidx.media3.exoplayer.upstream.BandwidthMeter
        public final void a(BandwidthMeter.EventListener eventListener) {
        }

        @Override // androidx.media3.exoplayer.upstream.BandwidthMeter
        public final void d(Handler handler, BandwidthMeter.EventListener eventListener) {
        }

        @Override // androidx.media3.exoplayer.upstream.BandwidthMeter
        public final TransferListener e() {
            return null;
        }

        @Override // androidx.media3.exoplayer.upstream.BandwidthMeter
        public final long f() {
            return 0L;
        }
    }

    public static class LiveContentUnsupportedException extends IOException {
    }

    public static final class MediaPreparer implements MediaSource.MediaSourceCaller, MediaPeriod.Callback, Handler.Callback {

        /* renamed from: a, reason: collision with root package name */
        public Timeline f7367a;

        /* renamed from: b, reason: collision with root package name */
        public MediaPeriod[] f7368b;

        @Override // androidx.media3.exoplayer.source.MediaSource.MediaSourceCaller
        public final void b(BaseMediaSource baseMediaSource, Timeline timeline) {
            if (this.f7367a != null) {
                return;
            }
            if (timeline.m(0, new Timeline.Window(), 0L).a()) {
                new LiveContentUnsupportedException();
                throw null;
            }
            this.f7367a = timeline;
            int iH = timeline.h();
            MediaPeriod[] mediaPeriodArr = new MediaPeriod[iH];
            this.f7368b = mediaPeriodArr;
            if (iH > 0) {
                timeline.l(0);
                throw null;
            }
            for (int i2 = 0; i2 < iH; i2++) {
                mediaPeriodArr[i2].o(this, 0L);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
        
            throw null;
         */
        @Override // android.os.Handler.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean handleMessage(android.os.Message r4) {
            /*
                r3 = this;
                int r0 = r4.what
                r1 = 1
                r2 = 0
                if (r0 == r1) goto L28
                r1 = 2
                if (r0 == r1) goto L21
                r1 = 3
                if (r0 == r1) goto L1c
                r4 = 4
                r1 = 0
                if (r0 == r4) goto L11
                return r1
            L11:
                androidx.media3.exoplayer.source.MediaPeriod[] r4 = r3.f7368b
                if (r4 == 0) goto L1b
                int r0 = r4.length
                if (r0 <= 0) goto L1b
                r4 = r4[r1]
                throw r2
            L1b:
                throw r2
            L1c:
                java.lang.Object r4 = r4.obj
                androidx.media3.exoplayer.source.MediaPeriod r4 = (androidx.media3.exoplayer.source.MediaPeriod) r4
                throw r2
            L21:
                androidx.media3.exoplayer.source.MediaPeriod[] r4 = r3.f7368b     // Catch: java.io.IOException -> L27
                if (r4 != 0) goto L26
                throw r2
            L26:
                throw r2
            L27:
                throw r2
            L28:
                int r4 = androidx.media3.exoplayer.analytics.PlayerId.f6436d
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.offline.DownloadHelper.MediaPreparer.handleMessage(android.os.Message):boolean");
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
        public final void j(MediaPeriod mediaPeriod) {
            throw null;
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
        public final void k(SequenceableLoader sequenceableLoader) {
            throw null;
        }
    }

    public static final class UnreleaseableRendererCapabilitiesList implements RendererCapabilitiesList {
    }

    static {
        DefaultTrackSelector.Parameters parameters = DefaultTrackSelector.Parameters.r0;
        parameters.getClass();
        DefaultTrackSelector.Parameters.Builder builder = new DefaultTrackSelector.Parameters.Builder(parameters);
        builder.z = true;
        builder.G = false;
        builder.l();
    }
}
