package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import java.util.ArrayList;

@UnstableApi
/* loaded from: classes3.dex */
public final class SilenceMediaSource extends BaseMediaSource {

    /* renamed from: i, reason: collision with root package name */
    public static final Format f7714i;

    /* renamed from: j, reason: collision with root package name */
    public static final byte[] f7715j;

    /* renamed from: h, reason: collision with root package name */
    public MediaItem f7716h;

    public static final class Factory {
    }

    public static final class SilenceMediaPeriod implements MediaPeriod {

        /* renamed from: b, reason: collision with root package name */
        public static final TrackGroupArray f7717b = new TrackGroupArray(new TrackGroup("", SilenceMediaSource.f7714i));

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f7718a = new ArrayList();

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final boolean b() {
            return false;
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final long d(long j2, SeekParameters seekParameters) {
            return Util.l(j2, 0L, 0L);
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final boolean e(LoadingInfo loadingInfo) {
            return false;
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final long f() {
            return Long.MIN_VALUE;
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final long g(long j2) {
            long jL = Util.l(j2, 0L, 0L);
            int i2 = 0;
            while (true) {
                ArrayList arrayList = this.f7718a;
                if (i2 >= arrayList.size()) {
                    return jL;
                }
                ((SilenceSampleStream) arrayList.get(i2)).b(jL);
                i2++;
            }
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final long h(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
            long jL = Util.l(j2, 0L, 0L);
            for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
                SampleStream sampleStream = sampleStreamArr[i2];
                ArrayList arrayList = this.f7718a;
                if (sampleStream != null && (exoTrackSelectionArr[i2] == null || !zArr[i2])) {
                    arrayList.remove(sampleStream);
                    sampleStreamArr[i2] = null;
                }
                if (sampleStreamArr[i2] == null && exoTrackSelectionArr[i2] != null) {
                    SilenceSampleStream silenceSampleStream = new SilenceSampleStream();
                    silenceSampleStream.b(jL);
                    arrayList.add(silenceSampleStream);
                    sampleStreamArr[i2] = silenceSampleStream;
                    zArr2[i2] = true;
                }
            }
            return jL;
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final long i() {
            return -9223372036854775807L;
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final void l() {
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final void o(MediaPeriod.Callback callback, long j2) {
            callback.j(this);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final TrackGroupArray p() {
            return f7717b;
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final long q() {
            return Long.MIN_VALUE;
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public final void r(long j2, boolean z) {
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public final void s(long j2) {
        }
    }

    public static final class SilenceSampleStream implements SampleStream {

        /* renamed from: a, reason: collision with root package name */
        public final long f7719a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f7720b;

        /* renamed from: c, reason: collision with root package name */
        public long f7721c;

        public SilenceSampleStream() {
            Format format = SilenceMediaSource.f7714i;
            int i2 = Util.f5744a;
            this.f7719a = 0L;
            b(0L);
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final boolean a() {
            return true;
        }

        public final void b(long j2) {
            Format format = SilenceMediaSource.f7714i;
            int i2 = Util.f5744a;
            this.f7721c = Util.l(4 * ((j2 * 44100) / 1000000), 0L, this.f7719a);
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final void c() {
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final int m(long j2) {
            long j3 = this.f7721c;
            b(j2);
            return (int) ((this.f7721c - j3) / SilenceMediaSource.f7715j.length);
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            if (!this.f7720b || (i2 & 2) != 0) {
                formatHolder.f6254b = SilenceMediaSource.f7714i;
                this.f7720b = true;
                return -5;
            }
            long j2 = this.f7721c;
            long j3 = this.f7719a - j2;
            if (j3 == 0) {
                decoderInputBuffer.e(4);
                return -4;
            }
            Format format = SilenceMediaSource.f7714i;
            int i3 = Util.f5744a;
            decoderInputBuffer.f6073f = ((j2 / 4) * 1000000) / 44100;
            decoderInputBuffer.e(1);
            byte[] bArr = SilenceMediaSource.f7715j;
            int iMin = (int) Math.min(bArr.length, j3);
            if ((4 & i2) == 0) {
                decoderInputBuffer.l(iMin);
                decoderInputBuffer.f6071d.put(bArr, 0, iMin);
            }
            if ((i2 & 1) == 0) {
                this.f7721c += iMin;
            }
            return -4;
        }
    }

    static {
        Format.Builder builder = new Format.Builder();
        builder.f5237l = MimeTypes.p("audio/raw");
        builder.z = 2;
        builder.A = 44100;
        builder.B = 2;
        Format format = new Format(builder);
        f7714i = format;
        MediaItem.Builder builder2 = new MediaItem.Builder();
        builder2.f5266a = "SilenceMediaSource";
        builder2.f5267b = Uri.EMPTY;
        builder2.f5268c = format.f5225m;
        builder2.a();
        f7715j = new byte[4096];
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final MediaPeriod C(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        return new SilenceMediaPeriod();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final synchronized MediaItem D() {
        return this.f7716h;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void J(MediaPeriod mediaPeriod) {
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final synchronized void O(MediaItem mediaItem) {
        this.f7716h = mediaItem;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void V() {
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final boolean c0(MediaItem mediaItem) {
        return true;
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void j0(TransferListener transferListener) {
        k0(new SinglePeriodTimeline(0L, true, false, D()));
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void l0() {
    }
}
