package androidx.media3.exoplayer;

import androidx.media3.common.Timeline;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.ShuffleOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
final class PlaylistTimeline extends AbstractConcatenatedTimeline {

    /* renamed from: h, reason: collision with root package name */
    public final int f6349h;

    /* renamed from: i, reason: collision with root package name */
    public final int f6350i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f6351j;

    /* renamed from: k, reason: collision with root package name */
    public final int[] f6352k;

    /* renamed from: l, reason: collision with root package name */
    public final Timeline[] f6353l;

    /* renamed from: m, reason: collision with root package name */
    public final Object[] f6354m;
    public final HashMap n;

    public PlaylistTimeline(Timeline[] timelineArr, Object[] objArr, ShuffleOrder shuffleOrder) {
        super(shuffleOrder);
        int length = timelineArr.length;
        this.f6353l = timelineArr;
        this.f6351j = new int[length];
        this.f6352k = new int[length];
        this.f6354m = objArr;
        this.n = new HashMap();
        int length2 = timelineArr.length;
        int i2 = 0;
        int iO = 0;
        int iH = 0;
        int i3 = 0;
        while (i2 < length2) {
            Timeline timeline = timelineArr[i2];
            this.f6353l[i3] = timeline;
            this.f6352k[i3] = iO;
            this.f6351j[i3] = iH;
            iO += timeline.o();
            iH += this.f6353l[i3].h();
            this.n.put(objArr[i3], Integer.valueOf(i3));
            i2++;
            i3++;
        }
        this.f6349h = iO;
        this.f6350i = iH;
    }

    @Override // androidx.media3.common.Timeline
    public final int h() {
        return this.f6350i;
    }

    @Override // androidx.media3.common.Timeline
    public final int o() {
        return this.f6349h;
    }

    @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
    public final int q(Object obj) {
        Integer num = (Integer) this.n.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
    public final int r(int i2) {
        return Util.e(this.f6351j, i2 + 1, false, false);
    }

    @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
    public final int s(int i2) {
        return Util.e(this.f6352k, i2 + 1, false, false);
    }

    @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
    public final Object t(int i2) {
        return this.f6354m[i2];
    }

    @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
    public final int u(int i2) {
        return this.f6351j[i2];
    }

    @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
    public final int v(int i2) {
        return this.f6352k[i2];
    }

    @Override // androidx.media3.exoplayer.AbstractConcatenatedTimeline
    public final Timeline x(int i2) {
        return this.f6353l[i2];
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PlaylistTimeline(ArrayList arrayList, ShuffleOrder shuffleOrder) {
        Timeline[] timelineArr = new Timeline[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            timelineArr[i3] = ((MediaSourceInfoHolder) it.next()).b();
            i3++;
        }
        Object[] objArr = new Object[arrayList.size()];
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            objArr[i2] = ((MediaSourceInfoHolder) it2.next()).a();
            i2++;
        }
        this(timelineArr, objArr, shuffleOrder);
    }
}
