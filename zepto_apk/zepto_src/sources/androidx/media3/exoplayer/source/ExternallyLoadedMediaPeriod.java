package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.TrackGroup;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import com.google.common.base.Charsets;
import com.google.common.util.concurrent.FutureCallback;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
final class ExternallyLoadedMediaPeriod implements MediaPeriod {

    /* renamed from: a, reason: collision with root package name */
    public final TrackGroupArray f7562a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f7563b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f7564c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference f7565d;

    /* renamed from: androidx.media3.exoplayer.source.ExternallyLoadedMediaPeriod$1, reason: invalid class name */
    class AnonymousClass1 implements FutureCallback<Object> {
        @Override // com.google.common.util.concurrent.FutureCallback
        public final void onFailure(Throwable th) {
            throw null;
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public final void onSuccess(Object obj) {
            throw null;
        }
    }

    public final class SampleStreamImpl implements SampleStream {

        /* renamed from: a, reason: collision with root package name */
        public int f7566a = 0;

        public SampleStreamImpl() {
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final boolean a() {
            return ExternallyLoadedMediaPeriod.this.f7564c.get();
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final void c() throws IOException {
            Throwable th = (Throwable) ExternallyLoadedMediaPeriod.this.f7565d.get();
            if (th != null) {
                throw new IOException(th);
            }
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final int m(long j2) {
            return 0;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            int i3 = this.f7566a;
            if (i3 == 2) {
                decoderInputBuffer.e(4);
                return -4;
            }
            int i4 = i2 & 2;
            ExternallyLoadedMediaPeriod externallyLoadedMediaPeriod = ExternallyLoadedMediaPeriod.this;
            if (i4 != 0 || i3 == 0) {
                formatHolder.f6254b = externallyLoadedMediaPeriod.f7562a.a(0).f5504d[0];
                this.f7566a = 1;
                return -5;
            }
            if (!externallyLoadedMediaPeriod.f7564c.get()) {
                return -3;
            }
            byte[] bArr = externallyLoadedMediaPeriod.f7563b;
            int length = bArr.length;
            decoderInputBuffer.e(1);
            decoderInputBuffer.f6073f = 0L;
            if ((i2 & 4) == 0) {
                decoderInputBuffer.l(length);
                decoderInputBuffer.f6071d.put(bArr, 0, length);
            }
            if ((i2 & 1) == 0) {
                this.f7566a = 2;
            }
            return -4;
        }
    }

    public ExternallyLoadedMediaPeriod(Uri uri, String str) {
        Format.Builder builder = new Format.Builder();
        builder.f5237l = MimeTypes.p(str);
        this.f7562a = new TrackGroupArray(new TrackGroup("", new Format(builder)));
        this.f7563b = uri.toString().getBytes(Charsets.f42260c);
        this.f7564c = new AtomicBoolean();
        this.f7565d = new AtomicReference();
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean b() {
        return !this.f7564c.get();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long d(long j2, SeekParameters seekParameters) {
        return j2;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean e(LoadingInfo loadingInfo) {
        return !this.f7564c.get();
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long f() {
        return this.f7564c.get() ? Long.MIN_VALUE : 0L;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long g(long j2) {
        return j2;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long h(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            if (sampleStreamArr[i2] != null && (exoTrackSelectionArr[i2] == null || !zArr[i2])) {
                sampleStreamArr[i2] = null;
            }
            if (sampleStreamArr[i2] == null && exoTrackSelectionArr[i2] != null) {
                sampleStreamArr[i2] = new SampleStreamImpl();
                zArr2[i2] = true;
            }
        }
        return j2;
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
        throw null;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final TrackGroupArray p() {
        return this.f7562a;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long q() {
        return this.f7564c.get() ? Long.MIN_VALUE : 0L;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void r(long j2, boolean z) {
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final void s(long j2) {
    }
}
