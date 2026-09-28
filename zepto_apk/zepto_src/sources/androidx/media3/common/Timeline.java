package androidx.media3.common;

import android.net.Uri;
import android.util.Pair;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;

/* loaded from: classes3.dex */
public abstract class Timeline {

    /* renamed from: a, reason: collision with root package name */
    public static final Timeline f5466a = new AnonymousClass1();

    /* renamed from: b, reason: collision with root package name */
    public static final String f5467b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f5468c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f5469d;

    /* renamed from: androidx.media3.common.Timeline$1, reason: invalid class name */
    public class AnonymousClass1 extends Timeline {
        @Override // androidx.media3.common.Timeline
        public final int b(Object obj) {
            return -1;
        }

        @Override // androidx.media3.common.Timeline
        public final Period f(int i2, Period period, boolean z) {
            throw new IndexOutOfBoundsException();
        }

        @Override // androidx.media3.common.Timeline
        public final int h() {
            return 0;
        }

        @Override // androidx.media3.common.Timeline
        public final Object l(int i2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // androidx.media3.common.Timeline
        public final Window m(int i2, Window window, long j2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // androidx.media3.common.Timeline
        public final int o() {
            return 0;
        }
    }

    public static final class Period {

        /* renamed from: h, reason: collision with root package name */
        public static final String f5470h;

        /* renamed from: i, reason: collision with root package name */
        public static final String f5471i;

        /* renamed from: j, reason: collision with root package name */
        public static final String f5472j;

        /* renamed from: k, reason: collision with root package name */
        public static final String f5473k;

        /* renamed from: l, reason: collision with root package name */
        public static final String f5474l;

        /* renamed from: a, reason: collision with root package name */
        public Object f5475a;

        /* renamed from: b, reason: collision with root package name */
        public Object f5476b;

        /* renamed from: c, reason: collision with root package name */
        public int f5477c;

        /* renamed from: d, reason: collision with root package name */
        public long f5478d;

        /* renamed from: e, reason: collision with root package name */
        public long f5479e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f5480f;

        /* renamed from: g, reason: collision with root package name */
        public AdPlaybackState f5481g = AdPlaybackState.f5118g;

        static {
            int i2 = Util.f5744a;
            f5470h = Integer.toString(0, 36);
            f5471i = Integer.toString(1, 36);
            f5472j = Integer.toString(2, 36);
            f5473k = Integer.toString(3, 36);
            f5474l = Integer.toString(4, 36);
        }

        public final long a(int i2, int i3) {
            AdPlaybackState.AdGroup adGroupA = this.f5481g.a(i2);
            if (adGroupA.f5135b != -1) {
                return adGroupA.f5140g[i3];
            }
            return -9223372036854775807L;
        }

        public final long b(int i2) {
            return this.f5481g.a(i2).f5134a;
        }

        public final int c(int i2, int i3) {
            AdPlaybackState.AdGroup adGroupA = this.f5481g.a(i2);
            if (adGroupA.f5135b != -1) {
                return adGroupA.f5139f[i3];
            }
            return 0;
        }

        public final int d(int i2) {
            return this.f5481g.a(i2).b(-1);
        }

        public final boolean e(int i2) {
            AdPlaybackState adPlaybackState = this.f5481g;
            return i2 == adPlaybackState.f5125b - 1 && adPlaybackState.d(i2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Period.class.equals(obj.getClass())) {
                Period period = (Period) obj;
                if (Util.a(this.f5475a, period.f5475a) && Util.a(this.f5476b, period.f5476b) && this.f5477c == period.f5477c && this.f5478d == period.f5478d && this.f5479e == period.f5479e && this.f5480f == period.f5480f && Util.a(this.f5481g, period.f5481g)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean f(int i2) {
            return this.f5481g.a(i2).f5142i;
        }

        public final void g(Object obj, Object obj2, int i2, long j2, long j3, AdPlaybackState adPlaybackState, boolean z) {
            this.f5475a = obj;
            this.f5476b = obj2;
            this.f5477c = i2;
            this.f5478d = j2;
            this.f5479e = j3;
            this.f5481g = adPlaybackState;
            this.f5480f = z;
        }

        public final int hashCode() {
            Object obj = this.f5475a;
            int iHashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.f5476b;
            int iHashCode2 = (((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.f5477c) * 31;
            long j2 = this.f5478d;
            int i2 = (iHashCode2 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.f5479e;
            return this.f5481g.hashCode() + ((((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.f5480f ? 1 : 0)) * 31);
        }
    }

    @UnstableApi
    public static final class RemotableTimeline extends Timeline {

        /* renamed from: e, reason: collision with root package name */
        public final ImmutableList f5482e;

        /* renamed from: f, reason: collision with root package name */
        public final ImmutableList f5483f;

        /* renamed from: g, reason: collision with root package name */
        public final int[] f5484g;

        /* renamed from: h, reason: collision with root package name */
        public final int[] f5485h;

        public RemotableTimeline(ImmutableList immutableList, ImmutableList immutableList2, int[] iArr) {
            Assertions.a(immutableList.size() == iArr.length);
            this.f5482e = immutableList;
            this.f5483f = immutableList2;
            this.f5484g = iArr;
            this.f5485h = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                this.f5485h[iArr[i2]] = i2;
            }
        }

        @Override // androidx.media3.common.Timeline
        public final int a(boolean z) {
            if (p()) {
                return -1;
            }
            if (z) {
                return this.f5484g[0];
            }
            return 0;
        }

        @Override // androidx.media3.common.Timeline
        public final int b(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.media3.common.Timeline
        public final int c(boolean z) {
            if (p()) {
                return -1;
            }
            ImmutableList immutableList = this.f5482e;
            if (!z) {
                return immutableList.size() - 1;
            }
            return this.f5484g[immutableList.size() - 1];
        }

        @Override // androidx.media3.common.Timeline
        public final int e(int i2, int i3, boolean z) {
            if (i3 == 1) {
                return i2;
            }
            if (i2 == c(z)) {
                if (i3 == 2) {
                    return a(z);
                }
                return -1;
            }
            if (!z) {
                return i2 + 1;
            }
            return this.f5484g[this.f5485h[i2] + 1];
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.common.Timeline
        public final Period f(int i2, Period period, boolean z) {
            Period period2 = (Period) this.f5483f.get(i2);
            period.g(period2.f5475a, period2.f5476b, period2.f5477c, period2.f5478d, period2.f5479e, period2.f5481g, period2.f5480f);
            return period;
        }

        @Override // androidx.media3.common.Timeline
        public final int h() {
            return this.f5483f.size();
        }

        @Override // androidx.media3.common.Timeline
        public final int k(int i2, int i3, boolean z) {
            if (i3 == 1) {
                return i2;
            }
            if (i2 == a(z)) {
                if (i3 == 2) {
                    return c(z);
                }
                return -1;
            }
            if (!z) {
                return i2 - 1;
            }
            return this.f5484g[this.f5485h[i2] - 1];
        }

        @Override // androidx.media3.common.Timeline
        public final Object l(int i2) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.common.Timeline
        public final Window m(int i2, Window window, long j2) {
            Window window2 = (Window) this.f5482e.get(i2);
            window.b(window2.f5486a, window2.f5488c, window2.f5489d, window2.f5490e, window2.f5491f, window2.f5492g, window2.f5493h, window2.f5494i, window2.f5495j, window2.f5497l, window2.f5498m, window2.n, window2.o, window2.p);
            window.f5496k = window2.f5496k;
            return window;
        }

        @Override // androidx.media3.common.Timeline
        public final int o() {
            return this.f5482e.size();
        }
    }

    public static final class Window {
        public static final String A;
        public static final String B;
        public static final String C;
        public static final String D;
        public static final String E;
        public static final String F;
        public static final Object q = new Object();
        public static final Object r = new Object();
        public static final MediaItem s;
        public static final String t;
        public static final String u;
        public static final String v;
        public static final String w;
        public static final String x;
        public static final String y;
        public static final String z;

        /* renamed from: b, reason: collision with root package name */
        public Object f5487b;

        /* renamed from: d, reason: collision with root package name */
        public Object f5489d;

        /* renamed from: e, reason: collision with root package name */
        public long f5490e;

        /* renamed from: f, reason: collision with root package name */
        public long f5491f;

        /* renamed from: g, reason: collision with root package name */
        public long f5492g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f5493h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f5494i;

        /* renamed from: j, reason: collision with root package name */
        public MediaItem.LiveConfiguration f5495j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f5496k;

        /* renamed from: l, reason: collision with root package name */
        public long f5497l;

        /* renamed from: m, reason: collision with root package name */
        public long f5498m;
        public int n;
        public int o;
        public long p;

        /* renamed from: a, reason: collision with root package name */
        public Object f5486a = q;

        /* renamed from: c, reason: collision with root package name */
        public MediaItem f5488c = s;

        static {
            MediaItem.Builder builder = new MediaItem.Builder();
            builder.f5266a = "androidx.media3.common.Timeline";
            builder.f5267b = Uri.EMPTY;
            s = builder.a();
            t = Integer.toString(1, 36);
            u = Integer.toString(2, 36);
            v = Integer.toString(3, 36);
            w = Integer.toString(4, 36);
            x = Integer.toString(5, 36);
            y = Integer.toString(6, 36);
            z = Integer.toString(7, 36);
            A = Integer.toString(8, 36);
            B = Integer.toString(9, 36);
            C = Integer.toString(10, 36);
            D = Integer.toString(11, 36);
            E = Integer.toString(12, 36);
            F = Integer.toString(13, 36);
        }

        public final boolean a() {
            return this.f5495j != null;
        }

        public final void b(Object obj, MediaItem mediaItem, Object obj2, long j2, long j3, long j4, boolean z2, boolean z3, MediaItem.LiveConfiguration liveConfiguration, long j5, long j6, int i2, int i3, long j7) {
            this.f5486a = obj;
            this.f5488c = mediaItem != null ? mediaItem : s;
            if (mediaItem != null) {
                MediaItem.LocalConfiguration localConfiguration = mediaItem.f5258b;
            }
            this.f5487b = null;
            this.f5489d = obj2;
            this.f5490e = j2;
            this.f5491f = j3;
            this.f5492g = j4;
            this.f5493h = z2;
            this.f5494i = z3;
            this.f5495j = liveConfiguration;
            this.f5497l = j5;
            this.f5498m = j6;
            this.n = i2;
            this.o = i3;
            this.p = j7;
            this.f5496k = false;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Window.class.equals(obj.getClass())) {
                Window window = (Window) obj;
                if (Util.a(this.f5486a, window.f5486a) && Util.a(this.f5488c, window.f5488c) && Util.a(this.f5489d, window.f5489d) && Util.a(this.f5495j, window.f5495j) && this.f5490e == window.f5490e && this.f5491f == window.f5491f && this.f5492g == window.f5492g && this.f5493h == window.f5493h && this.f5494i == window.f5494i && this.f5496k == window.f5496k && this.f5497l == window.f5497l && this.f5498m == window.f5498m && this.n == window.n && this.o == window.o && this.p == window.p) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            int iHashCode = (this.f5488c.hashCode() + ((this.f5486a.hashCode() + 217) * 31)) * 31;
            Object obj = this.f5489d;
            int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            MediaItem.LiveConfiguration liveConfiguration = this.f5495j;
            int iHashCode3 = (iHashCode2 + (liveConfiguration != null ? liveConfiguration.hashCode() : 0)) * 31;
            long j2 = this.f5490e;
            int i2 = (iHashCode3 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.f5491f;
            int i3 = (i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            long j4 = this.f5492g;
            int i4 = (((((((i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (this.f5493h ? 1 : 0)) * 31) + (this.f5494i ? 1 : 0)) * 31) + (this.f5496k ? 1 : 0)) * 31;
            long j5 = this.f5497l;
            int i5 = (i4 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
            long j6 = this.f5498m;
            int i6 = (((((i5 + ((int) (j6 ^ (j6 >>> 32)))) * 31) + this.n) * 31) + this.o) * 31;
            long j7 = this.p;
            return i6 + ((int) (j7 ^ (j7 >>> 32)));
        }
    }

    static {
        int i2 = Util.f5744a;
        f5467b = Integer.toString(0, 36);
        f5468c = Integer.toString(1, 36);
        f5469d = Integer.toString(2, 36);
    }

    public int a(boolean z) {
        return p() ? -1 : 0;
    }

    public abstract int b(Object obj);

    public int c(boolean z) {
        if (p()) {
            return -1;
        }
        return o() - 1;
    }

    public final int d(int i2, Period period, Window window, int i3, boolean z) {
        int i4 = f(i2, period, false).f5477c;
        if (m(i4, window, 0L).o != i2) {
            return i2 + 1;
        }
        int iE = e(i4, i3, z);
        if (iE == -1) {
            return -1;
        }
        return m(iE, window, 0L).n;
    }

    public int e(int i2, int i3, boolean z) {
        if (i3 == 0) {
            if (i2 == c(z)) {
                return -1;
            }
            return i2 + 1;
        }
        if (i3 == 1) {
            return i2;
        }
        if (i3 == 2) {
            return i2 == c(z) ? a(z) : i2 + 1;
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        int iC;
        if (this != obj) {
            if (obj instanceof Timeline) {
                Timeline timeline = (Timeline) obj;
                if (timeline.o() == o() && timeline.h() == h()) {
                    Window window = new Window();
                    Period period = new Period();
                    Window window2 = new Window();
                    Period period2 = new Period();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= o()) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= h()) {
                                    int iA = a(true);
                                    if (iA == timeline.a(true) && (iC = c(true)) == timeline.c(true)) {
                                        while (iA != iC) {
                                            int iE = e(iA, 0, true);
                                            if (iE == timeline.e(iA, 0, true)) {
                                                iA = iE;
                                            }
                                        }
                                    }
                                } else {
                                    if (!f(i3, period, true).equals(timeline.f(i3, period2, true))) {
                                        break;
                                    }
                                    i3++;
                                }
                            }
                        } else {
                            if (!m(i2, window, 0L).equals(timeline.m(i2, window2, 0L))) {
                                break;
                            }
                            i2++;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public abstract Period f(int i2, Period period, boolean z);

    public Period g(Object obj, Period period) {
        return f(b(obj), period, true);
    }

    public abstract int h();

    public int hashCode() {
        Window window = new Window();
        Period period = new Period();
        int iO = o() + 217;
        for (int i2 = 0; i2 < o(); i2++) {
            iO = (iO * 31) + m(i2, window, 0L).hashCode();
        }
        int iH = h() + (iO * 31);
        for (int i3 = 0; i3 < h(); i3++) {
            iH = (iH * 31) + f(i3, period, true).hashCode();
        }
        int iA = a(true);
        while (iA != -1) {
            iH = (iH * 31) + iA;
            iA = e(iA, 0, true);
        }
        return iH;
    }

    public final Pair i(Window window, Period period, int i2, long j2) {
        Pair pairJ = j(window, period, i2, j2, 0L);
        pairJ.getClass();
        return pairJ;
    }

    public final Pair j(Window window, Period period, int i2, long j2, long j3) {
        Assertions.c(i2, o());
        m(i2, window, j3);
        if (j2 == -9223372036854775807L) {
            j2 = window.f5497l;
            if (j2 == -9223372036854775807L) {
                return null;
            }
        }
        int i3 = window.n;
        f(i3, period, false);
        while (i3 < window.o && period.f5479e != j2) {
            int i4 = i3 + 1;
            if (f(i4, period, false).f5479e > j2) {
                break;
            }
            i3 = i4;
        }
        f(i3, period, true);
        long jMin = j2 - period.f5479e;
        long j4 = period.f5478d;
        if (j4 != -9223372036854775807L) {
            jMin = Math.min(jMin, j4 - 1);
        }
        long jMax = Math.max(0L, jMin);
        Object obj = period.f5476b;
        obj.getClass();
        return Pair.create(obj, Long.valueOf(jMax));
    }

    public int k(int i2, int i3, boolean z) {
        if (i3 == 0) {
            if (i2 == a(z)) {
                return -1;
            }
            return i2 - 1;
        }
        if (i3 == 1) {
            return i2;
        }
        if (i3 == 2) {
            return i2 == a(z) ? c(z) : i2 - 1;
        }
        throw new IllegalStateException();
    }

    public abstract Object l(int i2);

    public abstract Window m(int i2, Window window, long j2);

    public final void n(int i2, Window window) {
        m(i2, window, 0L);
    }

    public abstract int o();

    public final boolean p() {
        return o() == 0;
    }
}
