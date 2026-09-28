package androidx.media3.exoplayer.source;

import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

@UnstableApi
/* loaded from: classes3.dex */
public final class MergingMediaSource extends CompositeMediaSource<Integer> {
    public static final MediaItem s;

    /* renamed from: k, reason: collision with root package name */
    public final MediaSource[] f7631k;

    /* renamed from: l, reason: collision with root package name */
    public final Timeline[] f7632l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f7633m;
    public final DefaultCompositeSequenceableLoaderFactory n;
    public final ListMultimap o;
    public int p;
    public long[][] q;
    public IllegalMergeException r;

    public static final class ClippedTimeline extends ForwardingTimeline {
        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public final Timeline.Period f(int i2, Timeline.Period period, boolean z) {
            super.f(i2, period, z);
            throw null;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public final Timeline.Window m(int i2, Timeline.Window window, long j2) {
            super.m(i2, window, j2);
            throw null;
        }
    }

    public static final class IllegalMergeException extends IOException {

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }
    }

    static {
        MediaItem.Builder builder = new MediaItem.Builder();
        builder.f5266a = "MergingMediaSource";
        s = builder.a();
    }

    public MergingMediaSource(MediaSource... mediaSourceArr) {
        DefaultCompositeSequenceableLoaderFactory defaultCompositeSequenceableLoaderFactory = new DefaultCompositeSequenceableLoaderFactory();
        this.f7631k = mediaSourceArr;
        this.n = defaultCompositeSequenceableLoaderFactory;
        this.f7633m = new ArrayList(Arrays.asList(mediaSourceArr));
        this.p = -1;
        this.f7632l = new Timeline[mediaSourceArr.length];
        this.q = new long[0][];
        new HashMap();
        this.o = MultimapBuilder.a().a().c();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final MediaPeriod C(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        MediaSource[] mediaSourceArr = this.f7631k;
        int length = mediaSourceArr.length;
        MediaPeriod[] mediaPeriodArr = new MediaPeriod[length];
        Timeline[] timelineArr = this.f7632l;
        int iB = timelineArr[0].b(mediaPeriodId.f7609a);
        for (int i2 = 0; i2 < length; i2++) {
            mediaPeriodArr[i2] = mediaSourceArr[i2].C(mediaPeriodId.a(timelineArr[i2].l(iB)), allocator, j2 - this.q[iB][i2]);
        }
        return new MergingMediaPeriod(this.n, this.q[iB], mediaPeriodArr);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final MediaItem D() {
        MediaSource[] mediaSourceArr = this.f7631k;
        return mediaSourceArr.length > 0 ? mediaSourceArr[0].D() : s;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void J(MediaPeriod mediaPeriod) {
        MergingMediaPeriod mergingMediaPeriod = (MergingMediaPeriod) mediaPeriod;
        int i2 = 0;
        while (true) {
            MediaSource[] mediaSourceArr = this.f7631k;
            if (i2 >= mediaSourceArr.length) {
                return;
            }
            MediaSource mediaSource = mediaSourceArr[i2];
            MediaPeriod mediaPeriod2 = mergingMediaPeriod.f7620a[i2];
            if (mediaPeriod2 instanceof TimeOffsetMediaPeriod) {
                mediaPeriod2 = ((TimeOffsetMediaPeriod) mediaPeriod2).f7763a;
            }
            mediaSource.J(mediaPeriod2);
            i2++;
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final void O(MediaItem mediaItem) {
        this.f7631k[0].O(mediaItem);
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.MediaSource
    public final void V() throws IllegalMergeException {
        IllegalMergeException illegalMergeException = this.r;
        if (illegalMergeException != null) {
            throw illegalMergeException;
        }
        super.V();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public final boolean c0(MediaItem mediaItem) {
        MediaSource[] mediaSourceArr = this.f7631k;
        return mediaSourceArr.length > 0 && mediaSourceArr[0].c0(mediaItem);
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final void j0(TransferListener transferListener) {
        super.j0(transferListener);
        int i2 = 0;
        while (true) {
            MediaSource[] mediaSourceArr = this.f7631k;
            if (i2 >= mediaSourceArr.length) {
                return;
            }
            q0(Integer.valueOf(i2), mediaSourceArr[i2]);
            i2++;
        }
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final void l0() {
        super.l0();
        Arrays.fill(this.f7632l, (Object) null);
        this.p = -1;
        this.r = null;
        ArrayList arrayList = this.f7633m;
        arrayList.clear();
        Collections.addAll(arrayList, this.f7631k);
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public final MediaSource.MediaPeriodId m0(Object obj, MediaSource.MediaPeriodId mediaPeriodId) {
        if (((Integer) obj).intValue() == 0) {
            return mediaPeriodId;
        }
        return null;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public final void p0(Object obj, BaseMediaSource baseMediaSource, Timeline timeline) {
        Integer num = (Integer) obj;
        if (this.r != null) {
            return;
        }
        if (this.p == -1) {
            this.p = timeline.h();
        } else if (timeline.h() != this.p) {
            this.r = new IllegalMergeException();
            return;
        }
        int length = this.q.length;
        Timeline[] timelineArr = this.f7632l;
        if (length == 0) {
            this.q = (long[][]) Array.newInstance((Class<?>) Long.TYPE, this.p, timelineArr.length);
        }
        ArrayList arrayList = this.f7633m;
        arrayList.remove(baseMediaSource);
        timelineArr[num.intValue()] = timeline;
        if (arrayList.isEmpty()) {
            k0(timelineArr[0]);
        }
    }
}
