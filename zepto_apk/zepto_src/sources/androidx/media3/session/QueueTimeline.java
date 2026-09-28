package androidx.media3.session;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Util;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
final class QueueTimeline extends Timeline {

    /* renamed from: g, reason: collision with root package name */
    public static final QueueTimeline f10213g = new QueueTimeline(ImmutableList.r(), null);

    /* renamed from: h, reason: collision with root package name */
    public static final Object f10214h = new Object();

    /* renamed from: e, reason: collision with root package name */
    public final ImmutableList f10215e;

    /* renamed from: f, reason: collision with root package name */
    public final QueuedMediaItem f10216f;

    public static final class QueuedMediaItem {

        /* renamed from: a, reason: collision with root package name */
        public final MediaItem f10217a;

        /* renamed from: b, reason: collision with root package name */
        public final long f10218b;

        /* renamed from: c, reason: collision with root package name */
        public final long f10219c;

        public QueuedMediaItem(MediaItem mediaItem, long j2, long j3) {
            this.f10217a = mediaItem;
            this.f10218b = j2;
            this.f10219c = j3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof QueuedMediaItem)) {
                return false;
            }
            QueuedMediaItem queuedMediaItem = (QueuedMediaItem) obj;
            return this.f10218b == queuedMediaItem.f10218b && this.f10217a.equals(queuedMediaItem.f10217a) && this.f10219c == queuedMediaItem.f10219c;
        }

        public final int hashCode() {
            long j2 = this.f10218b;
            int iHashCode = (this.f10217a.hashCode() + ((217 + ((int) (j2 ^ (j2 >>> 32)))) * 31)) * 31;
            long j3 = this.f10219c;
            return iHashCode + ((int) ((j3 >>> 32) ^ j3));
        }
    }

    public QueueTimeline(ImmutableList immutableList, QueuedMediaItem queuedMediaItem) {
        this.f10215e = immutableList;
        this.f10216f = queuedMediaItem;
    }

    @Override // androidx.media3.common.Timeline
    public final int b(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.common.Timeline
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueueTimeline)) {
            return false;
        }
        QueueTimeline queueTimeline = (QueueTimeline) obj;
        return Objects.a(this.f10215e, queueTimeline.f10215e) && Objects.a(this.f10216f, queueTimeline.f10216f);
    }

    @Override // androidx.media3.common.Timeline
    public final Timeline.Period f(int i2, Timeline.Period period, boolean z) {
        QueuedMediaItem queuedMediaItemS = s(i2);
        Long lValueOf = Long.valueOf(queuedMediaItemS.f10218b);
        long jT = Util.T(queuedMediaItemS.f10219c);
        period.getClass();
        period.g(lValueOf, null, i2, jT, 0L, AdPlaybackState.f5118g, false);
        return period;
    }

    @Override // androidx.media3.common.Timeline
    public final int h() {
        return o();
    }

    @Override // androidx.media3.common.Timeline
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10215e, this.f10216f});
    }

    @Override // androidx.media3.common.Timeline
    public final Object l(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.common.Timeline
    public final Timeline.Window m(int i2, Timeline.Window window, long j2) {
        QueuedMediaItem queuedMediaItemS = s(i2);
        window.b(f10214h, queuedMediaItemS.f10217a, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, true, false, null, 0L, Util.T(queuedMediaItemS.f10219c), i2, i2, 0L);
        return window;
    }

    @Override // androidx.media3.common.Timeline
    public final int o() {
        return this.f10215e.size() + (this.f10216f == null ? 0 : 1);
    }

    public final QueueTimeline q(int i2, List list) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList immutableList = this.f10215e;
        builder.f(immutableList.subList(0, i2));
        for (int i3 = 0; i3 < list.size(); i3++) {
            builder.h(new QueuedMediaItem((MediaItem) list.get(i3), -1L, -9223372036854775807L));
        }
        builder.f(immutableList.subList(i2, immutableList.size()));
        return new QueueTimeline(builder.j(), this.f10216f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long r(int i2) {
        if (i2 < 0) {
            return -1L;
        }
        ImmutableList immutableList = this.f10215e;
        if (i2 < immutableList.size()) {
            return ((QueuedMediaItem) immutableList.get(i2)).f10218b;
        }
        return -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final QueuedMediaItem s(int i2) {
        QueuedMediaItem queuedMediaItem;
        ImmutableList immutableList = this.f10215e;
        return (i2 != immutableList.size() || (queuedMediaItem = this.f10216f) == null) ? (QueuedMediaItem) immutableList.get(i2) : queuedMediaItem;
    }
}
