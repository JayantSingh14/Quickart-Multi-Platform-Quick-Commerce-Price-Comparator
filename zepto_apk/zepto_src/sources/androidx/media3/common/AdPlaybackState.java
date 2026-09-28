package androidx.media3.common;

import android.net.Uri;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class AdPlaybackState {

    /* renamed from: g, reason: collision with root package name */
    public static final AdPlaybackState f5118g = new AdPlaybackState(null, new AdGroup[0], 0, -9223372036854775807L, 0);

    /* renamed from: h, reason: collision with root package name */
    public static final AdGroup f5119h = new AdGroup(0).c(0);

    /* renamed from: i, reason: collision with root package name */
    public static final String f5120i;

    /* renamed from: j, reason: collision with root package name */
    public static final String f5121j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f5122k;

    /* renamed from: l, reason: collision with root package name */
    public static final String f5123l;

    /* renamed from: a, reason: collision with root package name */
    public final Object f5124a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5125b;

    /* renamed from: c, reason: collision with root package name */
    public final long f5126c;

    /* renamed from: d, reason: collision with root package name */
    public final long f5127d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5128e;

    /* renamed from: f, reason: collision with root package name */
    public final AdGroup[] f5129f;

    public static final class AdGroup {

        /* renamed from: j, reason: collision with root package name */
        public static final String f5130j;

        /* renamed from: k, reason: collision with root package name */
        public static final String f5131k;

        /* renamed from: l, reason: collision with root package name */
        public static final String f5132l;

        /* renamed from: m, reason: collision with root package name */
        public static final String f5133m;
        public static final String n;
        public static final String o;
        public static final String p;
        public static final String q;
        public static final String r;

        /* renamed from: a, reason: collision with root package name */
        public final long f5134a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5135b;

        /* renamed from: c, reason: collision with root package name */
        public final int f5136c;

        /* renamed from: d, reason: collision with root package name */
        public final Uri[] f5137d;

        /* renamed from: e, reason: collision with root package name */
        public final MediaItem[] f5138e;

        /* renamed from: f, reason: collision with root package name */
        public final int[] f5139f;

        /* renamed from: g, reason: collision with root package name */
        public final long[] f5140g;

        /* renamed from: h, reason: collision with root package name */
        public final long f5141h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f5142i;

        static {
            int i2 = Util.f5744a;
            f5130j = Integer.toString(0, 36);
            f5131k = Integer.toString(1, 36);
            f5132l = Integer.toString(2, 36);
            f5133m = Integer.toString(3, 36);
            n = Integer.toString(4, 36);
            o = Integer.toString(5, 36);
            p = Integer.toString(6, 36);
            q = Integer.toString(7, 36);
            r = Integer.toString(8, 36);
        }

        public AdGroup(long j2) {
            this(j2, -1, -1, new int[0], new MediaItem[0], new long[0], 0L, false);
        }

        public static long[] a(long[] jArr, int i2) {
            int length = jArr.length;
            int iMax = Math.max(i2, length);
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            Arrays.fill(jArrCopyOf, length, iMax, -9223372036854775807L);
            return jArrCopyOf;
        }

        public final int b(int i2) {
            int i3;
            int i4 = i2 + 1;
            while (true) {
                int[] iArr = this.f5139f;
                if (i4 >= iArr.length || this.f5142i || (i3 = iArr[i4]) == 0 || i3 == 1) {
                    break;
                }
                i4++;
            }
            return i4;
        }

        public final AdGroup c(int i2) {
            int[] iArr = this.f5139f;
            int length = iArr.length;
            int iMax = Math.max(i2, length);
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            Arrays.fill(iArrCopyOf, length, iMax, 0);
            long[] jArrA = a(this.f5140g, i2);
            return new AdGroup(this.f5134a, i2, this.f5136c, iArrCopyOf, (MediaItem[]) Arrays.copyOf(this.f5138e, i2), jArrA, this.f5141h, this.f5142i);
        }

        public final AdGroup d(int i2, int i3) {
            int i4 = this.f5135b;
            Assertions.a(i4 == -1 || i3 < i4);
            int[] iArr = this.f5139f;
            int length = iArr.length;
            int iMax = Math.max(i3 + 1, length);
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            Arrays.fill(iArrCopyOf, length, iMax, 0);
            int i5 = iArrCopyOf[i3];
            Assertions.a(i5 == 0 || i5 == 1 || i5 == i2);
            long[] jArrA = this.f5140g;
            if (jArrA.length != iArrCopyOf.length) {
                jArrA = a(jArrA, iArrCopyOf.length);
            }
            long[] jArr = jArrA;
            MediaItem[] mediaItemArr = this.f5138e;
            if (mediaItemArr.length != iArrCopyOf.length) {
                mediaItemArr = (MediaItem[]) Arrays.copyOf(mediaItemArr, iArrCopyOf.length);
            }
            MediaItem[] mediaItemArr2 = mediaItemArr;
            iArrCopyOf[i3] = i2;
            return new AdGroup(this.f5134a, this.f5135b, this.f5136c, iArrCopyOf, mediaItemArr2, jArr, this.f5141h, this.f5142i);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && AdGroup.class == obj.getClass()) {
                AdGroup adGroup = (AdGroup) obj;
                if (this.f5134a == adGroup.f5134a && this.f5135b == adGroup.f5135b && this.f5136c == adGroup.f5136c && Arrays.equals(this.f5138e, adGroup.f5138e) && Arrays.equals(this.f5139f, adGroup.f5139f) && Arrays.equals(this.f5140g, adGroup.f5140g) && this.f5141h == adGroup.f5141h && this.f5142i == adGroup.f5142i) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            int i2 = ((this.f5135b * 31) + this.f5136c) * 31;
            long j2 = this.f5134a;
            int iHashCode = (Arrays.hashCode(this.f5140g) + ((Arrays.hashCode(this.f5139f) + ((Arrays.hashCode(this.f5138e) + ((i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31)) * 31)) * 31)) * 31;
            long j3 = this.f5141h;
            return ((iHashCode + ((int) ((j3 >>> 32) ^ j3))) * 31) + (this.f5142i ? 1 : 0);
        }

        public AdGroup(long j2, int i2, int i3, int[] iArr, MediaItem[] mediaItemArr, long[] jArr, long j3, boolean z) {
            Uri uri;
            int i4 = 0;
            Assertions.a(iArr.length == mediaItemArr.length);
            this.f5134a = j2;
            this.f5135b = i2;
            this.f5136c = i3;
            this.f5139f = iArr;
            this.f5138e = mediaItemArr;
            this.f5140g = jArr;
            this.f5141h = j3;
            this.f5142i = z;
            this.f5137d = new Uri[mediaItemArr.length];
            while (true) {
                Uri[] uriArr = this.f5137d;
                if (i4 >= uriArr.length) {
                    return;
                }
                MediaItem mediaItem = mediaItemArr[i4];
                if (mediaItem == null) {
                    uri = null;
                } else {
                    MediaItem.LocalConfiguration localConfiguration = mediaItem.f5258b;
                    localConfiguration.getClass();
                    uri = localConfiguration.f5339a;
                }
                uriArr[i4] = uri;
                i4++;
            }
        }
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdState {
    }

    static {
        int i2 = Util.f5744a;
        f5120i = Integer.toString(1, 36);
        f5121j = Integer.toString(2, 36);
        f5122k = Integer.toString(3, 36);
        f5123l = Integer.toString(4, 36);
    }

    public AdPlaybackState(Object obj, AdGroup[] adGroupArr, long j2, long j3, int i2) {
        this.f5124a = obj;
        this.f5126c = j2;
        this.f5127d = j3;
        this.f5125b = adGroupArr.length + i2;
        this.f5129f = adGroupArr;
        this.f5128e = i2;
    }

    public final AdGroup a(int i2) {
        int i3 = this.f5128e;
        return i2 < i3 ? f5119h : this.f5129f[i2 - i3];
    }

    public final int b(long j2, long j3) {
        int i2;
        AdGroup adGroupA;
        int i3;
        if (j2 != Long.MIN_VALUE && (j3 == -9223372036854775807L || j2 < j3)) {
            int i4 = this.f5128e;
            while (true) {
                i2 = this.f5125b;
                if (i4 >= i2 || ((a(i4).f5134a == Long.MIN_VALUE || a(i4).f5134a > j2) && ((i3 = (adGroupA = a(i4)).f5135b) == -1 || adGroupA.b(-1) < i3))) {
                    break;
                }
                i4++;
            }
            if (i4 < i2) {
                return i4;
            }
        }
        return -1;
    }

    public final int c(long j2, long j3) {
        int i2 = this.f5125b - 1;
        int i3 = i2 - (d(i2) ? 1 : 0);
        while (i3 >= 0 && j2 != Long.MIN_VALUE) {
            AdGroup adGroupA = a(i3);
            long j4 = adGroupA.f5134a;
            if (j4 != Long.MIN_VALUE) {
                if (j2 >= j4) {
                    break;
                }
                i3--;
            } else {
                if (j3 != -9223372036854775807L && ((!adGroupA.f5142i || adGroupA.f5135b != -1) && j2 >= j3)) {
                    break;
                }
                i3--;
            }
        }
        if (i3 >= 0) {
            AdGroup adGroupA2 = a(i3);
            int i4 = adGroupA2.f5135b;
            if (i4 != -1) {
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = adGroupA2.f5139f[i5];
                    if (i6 != 0 && i6 != 1) {
                    }
                }
            }
            return i3;
        }
        return -1;
    }

    public final boolean d(int i2) {
        if (i2 != this.f5125b - 1) {
            return false;
        }
        AdGroup adGroupA = a(i2);
        return adGroupA.f5142i && adGroupA.f5134a == Long.MIN_VALUE && adGroupA.f5135b == -1;
    }

    public final AdPlaybackState e(int i2, int i3) {
        Assertions.a(i3 > 0);
        int i4 = i2 - this.f5128e;
        AdGroup[] adGroupArr = this.f5129f;
        if (adGroupArr[i4].f5135b == i3) {
            return this;
        }
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.V(adGroupArr.length, adGroupArr);
        adGroupArr2[i4] = adGroupArr[i4].c(i3);
        return new AdPlaybackState(this.f5124a, adGroupArr2, this.f5126c, this.f5127d, this.f5128e);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AdPlaybackState.class == obj.getClass()) {
            AdPlaybackState adPlaybackState = (AdPlaybackState) obj;
            if (Util.a(this.f5124a, adPlaybackState.f5124a) && this.f5125b == adPlaybackState.f5125b && this.f5126c == adPlaybackState.f5126c && this.f5127d == adPlaybackState.f5127d && this.f5128e == adPlaybackState.f5128e && Arrays.equals(this.f5129f, adPlaybackState.f5129f)) {
                return true;
            }
        }
        return false;
    }

    public final AdPlaybackState f(int i2, int i3) {
        int i4 = i2 - this.f5128e;
        AdGroup[] adGroupArr = this.f5129f;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.V(adGroupArr.length, adGroupArr);
        adGroupArr2[i4] = adGroupArr2[i4].d(4, i3);
        return new AdPlaybackState(this.f5124a, adGroupArr2, this.f5126c, this.f5127d, this.f5128e);
    }

    public final AdPlaybackState g(int i2) {
        AdGroup adGroup;
        int i3 = i2 - this.f5128e;
        AdGroup[] adGroupArr = this.f5129f;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.V(adGroupArr.length, adGroupArr);
        AdGroup adGroup2 = adGroupArr2[i3];
        if (adGroup2.f5135b == -1) {
            int i4 = adGroup2.f5136c;
            adGroup = new AdGroup(adGroup2.f5134a, 0, i4, new int[0], new MediaItem[0], new long[0], adGroup2.f5141h, adGroup2.f5142i);
        } else {
            int[] iArr = adGroup2.f5139f;
            int length = iArr.length;
            int[] iArrCopyOf = Arrays.copyOf(iArr, length);
            for (int i5 = 0; i5 < length; i5++) {
                int i6 = iArrCopyOf[i5];
                if (i6 == 1 || i6 == 0) {
                    iArrCopyOf[i5] = 2;
                }
            }
            adGroup = new AdGroup(adGroup2.f5134a, length, adGroup2.f5136c, iArrCopyOf, adGroup2.f5138e, adGroup2.f5140g, adGroup2.f5141h, adGroup2.f5142i);
        }
        adGroupArr2[i3] = adGroup;
        return new AdPlaybackState(this.f5124a, adGroupArr2, this.f5126c, this.f5127d, this.f5128e);
    }

    public final int hashCode() {
        int i2 = this.f5125b * 31;
        Object obj = this.f5124a;
        return Arrays.hashCode(this.f5129f) + ((((((((i2 + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.f5126c)) * 31) + ((int) this.f5127d)) * 31) + this.f5128e) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AdPlaybackState(adsId=");
        sb.append(this.f5124a);
        sb.append(", adResumePositionUs=");
        sb.append(this.f5126c);
        sb.append(", adGroups=[");
        int i2 = 0;
        while (true) {
            AdGroup[] adGroupArr = this.f5129f;
            if (i2 >= adGroupArr.length) {
                sb.append("])");
                return sb.toString();
            }
            sb.append("adGroup(timeUs=");
            sb.append(adGroupArr[i2].f5134a);
            sb.append(", ads=[");
            for (int i3 = 0; i3 < adGroupArr[i2].f5139f.length; i3++) {
                sb.append("ad(state=");
                int i4 = adGroupArr[i2].f5139f[i3];
                if (i4 == 0) {
                    sb.append('_');
                } else if (i4 == 1) {
                    sb.append('R');
                } else if (i4 == 2) {
                    sb.append('S');
                } else if (i4 == 3) {
                    sb.append('P');
                } else if (i4 != 4) {
                    sb.append('?');
                } else {
                    sb.append('!');
                }
                sb.append(", durationUs=");
                sb.append(adGroupArr[i2].f5140g[i3]);
                sb.append(')');
                if (i3 < adGroupArr[i2].f5139f.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i2 < adGroupArr.length - 1) {
                sb.append(", ");
            }
            i2++;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AdPlaybackState(Object obj, long... jArr) {
        int length = jArr.length;
        AdGroup[] adGroupArr = new AdGroup[length];
        for (int i2 = 0; i2 < length; i2++) {
            adGroupArr[i2] = new AdGroup(jArr[i2]);
        }
        this(obj, adGroupArr, 0L, -9223372036854775807L, 0);
    }
}
