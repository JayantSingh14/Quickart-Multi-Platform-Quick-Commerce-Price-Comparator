package androidx.media3.exoplayer.source;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.ClippingMediaSource;
import androidx.media3.exoplayer.source.MediaPeriod;

@UnstableApi
/* loaded from: classes3.dex */
public final class ClippingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final MediaPeriod f7505a;

    /* renamed from: b, reason: collision with root package name */
    public MediaPeriod.Callback f7506b;

    /* renamed from: c, reason: collision with root package name */
    public ClippingSampleStream[] f7507c = new ClippingSampleStream[0];

    /* renamed from: d, reason: collision with root package name */
    public long f7508d;

    /* renamed from: e, reason: collision with root package name */
    public long f7509e;

    /* renamed from: f, reason: collision with root package name */
    public long f7510f;

    /* renamed from: g, reason: collision with root package name */
    public ClippingMediaSource.IllegalClippingException f7511g;

    public final class ClippingSampleStream implements SampleStream {

        /* renamed from: a, reason: collision with root package name */
        public final SampleStream f7512a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f7513b;

        public ClippingSampleStream(SampleStream sampleStream) {
            this.f7512a = sampleStream;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final boolean a() {
            return !ClippingMediaPeriod.this.a() && this.f7512a.a();
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final void c() {
            this.f7512a.c();
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final int m(long j2) {
            if (ClippingMediaPeriod.this.a()) {
                return -3;
            }
            return this.f7512a.m(j2);
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public final int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            ClippingMediaPeriod clippingMediaPeriod = ClippingMediaPeriod.this;
            if (clippingMediaPeriod.a()) {
                return -3;
            }
            if (this.f7513b) {
                decoderInputBuffer.f6056a = 4;
                return -4;
            }
            long jQ = clippingMediaPeriod.q();
            int iN = this.f7512a.n(formatHolder, decoderInputBuffer, i2);
            if (iN != -5) {
                long j2 = clippingMediaPeriod.f7510f;
                if (j2 == Long.MIN_VALUE || ((iN != -4 || decoderInputBuffer.f6073f < j2) && !(iN == -3 && jQ == Long.MIN_VALUE && !decoderInputBuffer.f6072e))) {
                    return iN;
                }
                decoderInputBuffer.h();
                decoderInputBuffer.f6056a = 4;
                this.f7513b = true;
                return -4;
            }
            Format format = formatHolder.f6254b;
            format.getClass();
            int i3 = format.E;
            int i4 = format.D;
            if (i4 == 0 && i3 == 0) {
                return -5;
            }
            if (clippingMediaPeriod.f7509e != 0) {
                i4 = 0;
            }
            if (clippingMediaPeriod.f7510f != Long.MIN_VALUE) {
                i3 = 0;
            }
            Format.Builder builderA = format.a();
            builderA.C = i4;
            builderA.D = i3;
            formatHolder.f6254b = new Format(builderA);
            return -5;
        }
    }

    public ClippingMediaPeriod(MediaPeriod mediaPeriod, boolean z, long j2, long j3) {
        this.f7505a = mediaPeriod;
        this.f7508d = z ? j2 : -9223372036854775807L;
        this.f7509e = j2;
        this.f7510f = j3;
    }

    public final boolean a() {
        return this.f7508d != -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean b() {
        return this.f7505a.b();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long d(long j2, SeekParameters seekParameters) {
        long j3 = this.f7509e;
        if (j2 == j3) {
            return j3;
        }
        long jL = Util.l(seekParameters.f6360a, 0L, j2 - j3);
        long j4 = this.f7510f;
        long jL2 = Util.l(seekParameters.f6361b, 0L, j4 == Long.MIN_VALUE ? Long.MAX_VALUE : j4 - j2);
        if (jL != seekParameters.f6360a || jL2 != seekParameters.f6361b) {
            seekParameters = new SeekParameters(jL, jL2);
        }
        return this.f7505a.d(j2, seekParameters);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean e(LoadingInfo loadingInfo) {
        return this.f7505a.e(loadingInfo);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long f() {
        long jF = this.f7505a.f();
        if (jF != Long.MIN_VALUE) {
            long j2 = this.f7510f;
            if (j2 == Long.MIN_VALUE || jF < j2) {
                return jF;
            }
        }
        return Long.MIN_VALUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    @Override // androidx.media3.exoplayer.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long g(long r6) {
        /*
            r5 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5.f7508d = r0
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r0 = r5.f7507c
            int r1 = r0.length
            r2 = 0
            r3 = r2
        Lc:
            if (r3 >= r1) goto L17
            r4 = r0[r3]
            if (r4 == 0) goto L14
            r4.f7513b = r2
        L14:
            int r3 = r3 + 1
            goto Lc
        L17:
            androidx.media3.exoplayer.source.MediaPeriod r0 = r5.f7505a
            long r0 = r0.g(r6)
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 == 0) goto L33
            long r6 = r5.f7509e
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 < 0) goto L34
            long r6 = r5.f7510f
            r3 = -9223372036854775808
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 == 0) goto L33
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 > 0) goto L34
        L33:
            r2 = 1
        L34:
            androidx.media3.common.util.Assertions.g(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.ClippingMediaPeriod.g(long):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007b  */
    @Override // androidx.media3.exoplayer.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long h(androidx.media3.exoplayer.trackselection.ExoTrackSelection[] r15, boolean[] r16, androidx.media3.exoplayer.source.SampleStream[] r17, boolean[] r18, long r19) {
        /*
            r14 = this;
            r0 = r17
            int r1 = r0.length
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r1 = new androidx.media3.exoplayer.source.ClippingMediaPeriod.ClippingSampleStream[r1]
            r14.f7507c = r1
            int r1 = r0.length
            androidx.media3.exoplayer.source.SampleStream[] r5 = new androidx.media3.exoplayer.source.SampleStream[r1]
            r1 = 0
            r2 = r1
        Lc:
            int r3 = r0.length
            r9 = 0
            if (r2 >= r3) goto L21
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r3 = r14.f7507c
            r4 = r0[r2]
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream r4 = (androidx.media3.exoplayer.source.ClippingMediaPeriod.ClippingSampleStream) r4
            r3[r2] = r4
            if (r4 == 0) goto L1c
            androidx.media3.exoplayer.source.SampleStream r9 = r4.f7512a
        L1c:
            r5[r2] = r9
            int r2 = r2 + 1
            goto Lc
        L21:
            androidx.media3.exoplayer.source.MediaPeriod r2 = r14.f7505a
            r3 = r15
            r4 = r16
            r6 = r18
            r7 = r19
            long r10 = r2.h(r3, r4, r5, r6, r7)
            boolean r2 = r14.a()
            if (r2 == 0) goto L5b
            long r6 = r14.f7509e
            int r2 = (r19 > r6 ? 1 : (r19 == r6 ? 0 : -1))
            if (r2 != 0) goto L5b
            r12 = 0
            int r2 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r2 == 0) goto L5b
            int r2 = r15.length
            r4 = r1
        L42:
            if (r4 >= r2) goto L5b
            r6 = r15[r4]
            if (r6 == 0) goto L58
            androidx.media3.common.Format r6 = r6.r()
            java.lang.String r7 = r6.f5225m
            java.lang.String r6 = r6.f5222j
            boolean r6 = androidx.media3.common.MimeTypes.a(r7, r6)
            if (r6 != 0) goto L58
            r2 = r10
            goto L60
        L58:
            int r4 = r4 + 1
            goto L42
        L5b:
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L60:
            r14.f7508d = r2
            int r15 = (r10 > r19 ? 1 : (r10 == r19 ? 0 : -1))
            if (r15 == 0) goto L7b
            long r2 = r14.f7509e
            int r15 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r15 < 0) goto L79
            long r2 = r14.f7510f
            r6 = -9223372036854775808
            int r15 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r15 == 0) goto L7b
            int r15 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r15 > 0) goto L79
            goto L7b
        L79:
            r15 = r1
            goto L7c
        L7b:
            r15 = 1
        L7c:
            androidx.media3.common.util.Assertions.g(r15)
        L7f:
            int r15 = r0.length
            if (r1 >= r15) goto La5
            r15 = r5[r1]
            if (r15 != 0) goto L8b
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r15 = r14.f7507c
            r15[r1] = r9
            goto L9c
        L8b:
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r2 = r14.f7507c
            r3 = r2[r1]
            if (r3 == 0) goto L95
            androidx.media3.exoplayer.source.SampleStream r3 = r3.f7512a
            if (r3 == r15) goto L9c
        L95:
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream r3 = new androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream
            r3.<init>(r15)
            r2[r1] = r3
        L9c:
            androidx.media3.exoplayer.source.ClippingMediaPeriod$ClippingSampleStream[] r15 = r14.f7507c
            r15 = r15[r1]
            r0[r1] = r15
            int r1 = r1 + 1
            goto L7f
        La5:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.ClippingMediaPeriod.h(androidx.media3.exoplayer.trackselection.ExoTrackSelection[], boolean[], androidx.media3.exoplayer.source.SampleStream[], boolean[], long):long");
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long i() {
        if (a()) {
            long j2 = this.f7508d;
            this.f7508d = -9223372036854775807L;
            long jI = i();
            return jI != -9223372036854775807L ? jI : j2;
        }
        long jI2 = this.f7505a.i();
        if (jI2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        Assertions.g(jI2 >= this.f7509e);
        long j3 = this.f7510f;
        Assertions.g(j3 == Long.MIN_VALUE || jI2 <= j3);
        return jI2;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
    public final void j(MediaPeriod mediaPeriod) {
        if (this.f7511g != null) {
            return;
        }
        MediaPeriod.Callback callback = this.f7506b;
        callback.getClass();
        callback.j(this);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
    public final void k(SequenceableLoader sequenceableLoader) {
        MediaPeriod.Callback callback = this.f7506b;
        callback.getClass();
        callback.k(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void l() throws ClippingMediaSource.IllegalClippingException {
        ClippingMediaSource.IllegalClippingException illegalClippingException = this.f7511g;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        this.f7505a.l();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void o(MediaPeriod.Callback callback, long j2) {
        this.f7506b = callback;
        this.f7505a.o(this, j2);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final TrackGroupArray p() {
        return this.f7505a.p();
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long q() {
        long jQ = this.f7505a.q();
        if (jQ != Long.MIN_VALUE) {
            long j2 = this.f7510f;
            if (j2 == Long.MIN_VALUE || jQ < j2) {
                return jQ;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void r(long j2, boolean z) {
        this.f7505a.r(j2, z);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final void s(long j2) {
        this.f7505a.s(j2);
    }
}
