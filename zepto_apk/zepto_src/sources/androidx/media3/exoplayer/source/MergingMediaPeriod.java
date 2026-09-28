package androidx.media3.exoplayer.source;

import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import com.google.common.collect.Lists;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;

/* loaded from: classes3.dex */
final class MergingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final MediaPeriod[] f7620a;

    /* renamed from: c, reason: collision with root package name */
    public final DefaultCompositeSequenceableLoaderFactory f7622c;

    /* renamed from: f, reason: collision with root package name */
    public MediaPeriod.Callback f7625f;

    /* renamed from: g, reason: collision with root package name */
    public TrackGroupArray f7626g;

    /* renamed from: i, reason: collision with root package name */
    public SequenceableLoader f7628i;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f7623d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f7624e = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final IdentityHashMap f7621b = new IdentityHashMap();

    /* renamed from: h, reason: collision with root package name */
    public MediaPeriod[] f7627h = new MediaPeriod[0];

    public static final class ForwardingTrackSelection implements ExoTrackSelection {

        /* renamed from: a, reason: collision with root package name */
        public final ExoTrackSelection f7629a;

        /* renamed from: b, reason: collision with root package name */
        public final TrackGroup f7630b;

        public ForwardingTrackSelection(ExoTrackSelection exoTrackSelection, TrackGroup trackGroup) {
            this.f7629a = exoTrackSelection;
            this.f7630b = trackGroup;
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final long a() {
            return this.f7629a.a();
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final boolean b(int i2, long j2) {
            return this.f7629a.b(i2, j2);
        }

        @Override // androidx.media3.exoplayer.trackselection.TrackSelection
        public final int c(Format format) {
            return this.f7629a.l(this.f7630b.c(format));
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final int d() {
            return this.f7629a.d();
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final void disable() {
            this.f7629a.disable();
        }

        @Override // androidx.media3.exoplayer.trackselection.TrackSelection
        public final Format e(int i2) {
            return this.f7630b.f5504d[this.f7629a.f(i2)];
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final void enable() {
            this.f7629a.enable();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForwardingTrackSelection)) {
                return false;
            }
            ForwardingTrackSelection forwardingTrackSelection = (ForwardingTrackSelection) obj;
            return this.f7629a.equals(forwardingTrackSelection.f7629a) && this.f7630b.equals(forwardingTrackSelection.f7630b);
        }

        @Override // androidx.media3.exoplayer.trackselection.TrackSelection
        public final int f(int i2) {
            return this.f7629a.f(i2);
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final void g(long j2, long j3, long j4, List list, MediaChunkIterator[] mediaChunkIteratorArr) {
            this.f7629a.g(j2, j3, j4, list, mediaChunkIteratorArr);
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final boolean h(int i2, long j2) {
            return this.f7629a.h(i2, j2);
        }

        public final int hashCode() {
            return this.f7629a.hashCode() + ((this.f7630b.hashCode() + 527) * 31);
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final void i(float f2) {
            this.f7629a.i(f2);
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final Object j() {
            return this.f7629a.j();
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final void k() {
            this.f7629a.k();
        }

        @Override // androidx.media3.exoplayer.trackselection.TrackSelection
        public final int l(int i2) {
            return this.f7629a.l(i2);
        }

        @Override // androidx.media3.exoplayer.trackselection.TrackSelection
        public final int length() {
            return this.f7629a.length();
        }

        @Override // androidx.media3.exoplayer.trackselection.TrackSelection
        public final TrackGroup m() {
            return this.f7630b;
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final boolean n(long j2, Chunk chunk, List list) {
            return this.f7629a.n(j2, chunk, list);
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final void o(boolean z) {
            this.f7629a.o(z);
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final int p(long j2, List list) {
            return this.f7629a.p(j2, list);
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final int q() {
            return this.f7629a.q();
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final Format r() {
            return this.f7630b.f5504d[this.f7629a.q()];
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final int s() {
            return this.f7629a.s();
        }

        @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
        public final void t() {
            this.f7629a.t();
        }
    }

    public MergingMediaPeriod(DefaultCompositeSequenceableLoaderFactory defaultCompositeSequenceableLoaderFactory, long[] jArr, MediaPeriod... mediaPeriodArr) {
        this.f7622c = defaultCompositeSequenceableLoaderFactory;
        this.f7620a = mediaPeriodArr;
        this.f7628i = defaultCompositeSequenceableLoaderFactory.a();
        for (int i2 = 0; i2 < mediaPeriodArr.length; i2++) {
            long j2 = jArr[i2];
            if (j2 != 0) {
                this.f7620a[i2] = new TimeOffsetMediaPeriod(mediaPeriodArr[i2], j2);
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean b() {
        return this.f7628i.b();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long d(long j2, SeekParameters seekParameters) {
        MediaPeriod[] mediaPeriodArr = this.f7627h;
        return (mediaPeriodArr.length > 0 ? mediaPeriodArr[0] : this.f7620a[0]).d(j2, seekParameters);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final boolean e(LoadingInfo loadingInfo) {
        ArrayList arrayList = this.f7623d;
        if (arrayList.isEmpty()) {
            return this.f7628i.e(loadingInfo);
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((MediaPeriod) arrayList.get(i2)).e(loadingInfo);
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long f() {
        return this.f7628i.f();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long g(long j2) {
        long jG = this.f7627h[0].g(j2);
        int i2 = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.f7627h;
            if (i2 >= mediaPeriodArr.length) {
                return jG;
            }
            if (mediaPeriodArr[i2].g(jG) != jG) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i2++;
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long h(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        IdentityHashMap identityHashMap;
        int[] iArr;
        int[] iArr2 = new int[exoTrackSelectionArr.length];
        int[] iArr3 = new int[exoTrackSelectionArr.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int length = exoTrackSelectionArr.length;
            identityHashMap = this.f7621b;
            if (i3 >= length) {
                break;
            }
            SampleStream sampleStream = sampleStreamArr[i3];
            Integer num = sampleStream == null ? null : (Integer) identityHashMap.get(sampleStream);
            iArr2[i3] = num == null ? -1 : num.intValue();
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i3];
            if (exoTrackSelection != null) {
                String str = exoTrackSelection.m().f5502b;
                iArr3[i3] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr3[i3] = -1;
            }
            i3++;
        }
        identityHashMap.clear();
        int length2 = exoTrackSelectionArr.length;
        SampleStream[] sampleStreamArr2 = new SampleStream[length2];
        SampleStream[] sampleStreamArr3 = new SampleStream[exoTrackSelectionArr.length];
        ExoTrackSelection[] exoTrackSelectionArr2 = new ExoTrackSelection[exoTrackSelectionArr.length];
        MediaPeriod[] mediaPeriodArr = this.f7620a;
        ArrayList arrayList = new ArrayList(mediaPeriodArr.length);
        long j3 = j2;
        int i4 = 0;
        while (i4 < mediaPeriodArr.length) {
            int i5 = i2;
            while (i5 < exoTrackSelectionArr.length) {
                sampleStreamArr3[i5] = iArr2[i5] == i4 ? sampleStreamArr[i5] : null;
                if (iArr3[i5] == i4) {
                    ExoTrackSelection exoTrackSelection2 = exoTrackSelectionArr[i5];
                    exoTrackSelection2.getClass();
                    iArr = iArr2;
                    TrackGroup trackGroup = (TrackGroup) this.f7624e.get(exoTrackSelection2.m());
                    trackGroup.getClass();
                    exoTrackSelectionArr2[i5] = new ForwardingTrackSelection(exoTrackSelection2, trackGroup);
                } else {
                    iArr = iArr2;
                    exoTrackSelectionArr2[i5] = null;
                }
                i5++;
                iArr2 = iArr;
            }
            int[] iArr4 = iArr2;
            MediaPeriod[] mediaPeriodArr2 = mediaPeriodArr;
            int i6 = i4;
            long jH = mediaPeriodArr2[i4].h(exoTrackSelectionArr2, zArr, sampleStreamArr3, zArr2, j3);
            if (i6 == 0) {
                j3 = jH;
            } else if (jH != j3) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z = false;
            for (int i7 = 0; i7 < exoTrackSelectionArr.length; i7++) {
                if (iArr3[i7] == i6) {
                    SampleStream sampleStream2 = sampleStreamArr3[i7];
                    sampleStream2.getClass();
                    sampleStreamArr2[i7] = sampleStreamArr3[i7];
                    identityHashMap.put(sampleStream2, Integer.valueOf(i6));
                    z = true;
                } else if (iArr4[i7] == i6) {
                    Assertions.g(sampleStreamArr3[i7] == null);
                }
            }
            if (z) {
                arrayList.add(mediaPeriodArr2[i6]);
            }
            i4 = i6 + 1;
            mediaPeriodArr = mediaPeriodArr2;
            iArr2 = iArr4;
            i2 = 0;
        }
        int i8 = i2;
        System.arraycopy(sampleStreamArr2, i8, sampleStreamArr, i8, length2);
        this.f7627h = (MediaPeriod[]) arrayList.toArray(new MediaPeriod[i8]);
        AbstractList abstractListD = Lists.d(new l(2), arrayList);
        this.f7622c.getClass();
        this.f7628i = new CompositeSequenceableLoader(arrayList, abstractListD);
        return j3;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final long i() {
        long j2 = -9223372036854775807L;
        for (MediaPeriod mediaPeriod : this.f7627h) {
            long jI = mediaPeriod.i();
            if (jI == -9223372036854775807L) {
                if (j2 != -9223372036854775807L && mediaPeriod.g(j2) != j2) {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else if (j2 == -9223372036854775807L) {
                for (MediaPeriod mediaPeriod2 : this.f7627h) {
                    if (mediaPeriod2 == mediaPeriod) {
                        break;
                    }
                    if (mediaPeriod2.g(jI) != jI) {
                        throw new IllegalStateException("Unexpected child seekToUs result.");
                    }
                }
                j2 = jI;
            } else if (jI != j2) {
                throw new IllegalStateException("Conflicting discontinuities.");
            }
        }
        return j2;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
    public final void j(MediaPeriod mediaPeriod) {
        ArrayList arrayList = this.f7623d;
        arrayList.remove(mediaPeriod);
        if (arrayList.isEmpty()) {
            MediaPeriod[] mediaPeriodArr = this.f7620a;
            int i2 = 0;
            for (MediaPeriod mediaPeriod2 : mediaPeriodArr) {
                i2 += mediaPeriod2.p().f7771a;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < mediaPeriodArr.length; i4++) {
                TrackGroupArray trackGroupArrayP = mediaPeriodArr[i4].p();
                int i5 = trackGroupArrayP.f7771a;
                int i6 = 0;
                while (i6 < i5) {
                    TrackGroup trackGroupA = trackGroupArrayP.a(i6);
                    Format[] formatArr = new Format[trackGroupA.f5501a];
                    for (int i7 = 0; i7 < trackGroupA.f5501a; i7++) {
                        Format format = trackGroupA.f5504d[i7];
                        Format.Builder builderA = format.a();
                        StringBuilder sb = new StringBuilder();
                        sb.append(i4);
                        sb.append(":");
                        String str = format.f5213a;
                        if (str == null) {
                            str = "";
                        }
                        sb.append(str);
                        builderA.f5226a = sb.toString();
                        formatArr[i7] = new Format(builderA);
                    }
                    TrackGroup trackGroup = new TrackGroup(i4 + ":" + trackGroupA.f5502b, formatArr);
                    this.f7624e.put(trackGroup, trackGroupA);
                    trackGroupArr[i3] = trackGroup;
                    i6++;
                    i3++;
                }
            }
            this.f7626g = new TrackGroupArray(trackGroupArr);
            MediaPeriod.Callback callback = this.f7625f;
            callback.getClass();
            callback.j(this);
        }
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
    public final void k(SequenceableLoader sequenceableLoader) {
        MediaPeriod.Callback callback = this.f7625f;
        callback.getClass();
        callback.k(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void l() {
        for (MediaPeriod mediaPeriod : this.f7620a) {
            mediaPeriod.l();
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void o(MediaPeriod.Callback callback, long j2) {
        this.f7625f = callback;
        ArrayList arrayList = this.f7623d;
        MediaPeriod[] mediaPeriodArr = this.f7620a;
        Collections.addAll(arrayList, mediaPeriodArr);
        for (MediaPeriod mediaPeriod : mediaPeriodArr) {
            mediaPeriod.o(this, j2);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final TrackGroupArray p() {
        TrackGroupArray trackGroupArray = this.f7626g;
        trackGroupArray.getClass();
        return trackGroupArray;
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final long q() {
        return this.f7628i.q();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public final void r(long j2, boolean z) {
        for (MediaPeriod mediaPeriod : this.f7627h) {
            mediaPeriod.r(j2, z);
        }
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public final void s(long j2) {
        this.f7628i.s(j2);
    }
}
