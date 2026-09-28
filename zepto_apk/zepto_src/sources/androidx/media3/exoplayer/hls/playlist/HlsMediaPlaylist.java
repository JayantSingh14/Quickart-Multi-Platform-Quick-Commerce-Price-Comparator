package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;

@UnstableApi
/* loaded from: classes3.dex */
public final class HlsMediaPlaylist extends HlsPlaylist {

    /* renamed from: d, reason: collision with root package name */
    public final int f7121d;

    /* renamed from: e, reason: collision with root package name */
    public final long f7122e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f7123f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f7124g;

    /* renamed from: h, reason: collision with root package name */
    public final long f7125h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f7126i;

    /* renamed from: j, reason: collision with root package name */
    public final int f7127j;

    /* renamed from: k, reason: collision with root package name */
    public final long f7128k;

    /* renamed from: l, reason: collision with root package name */
    public final int f7129l;

    /* renamed from: m, reason: collision with root package name */
    public final long f7130m;
    public final long n;
    public final boolean o;
    public final boolean p;
    public final DrmInitData q;
    public final ImmutableList r;
    public final ImmutableList s;
    public final ImmutableMap t;
    public final long u;
    public final ServerControl v;

    public static final class Part extends SegmentBase {

        /* renamed from: l, reason: collision with root package name */
        public final boolean f7131l;

        /* renamed from: m, reason: collision with root package name */
        public final boolean f7132m;

        public Part(String str, Segment segment, long j2, int i2, long j3, DrmInitData drmInitData, String str2, String str3, long j4, long j5, boolean z, boolean z2, boolean z3) {
            super(str, segment, j2, i2, j3, drmInitData, str2, str3, j4, j5, z);
            this.f7131l = z2;
            this.f7132m = z3;
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaylistType {
    }

    public static final class RenditionReport {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f7133a;

        /* renamed from: b, reason: collision with root package name */
        public final long f7134b;

        /* renamed from: c, reason: collision with root package name */
        public final int f7135c;

        public RenditionReport(Uri uri, long j2, int i2) {
            this.f7133a = uri;
            this.f7134b = j2;
            this.f7135c = i2;
        }
    }

    public static class SegmentBase implements Comparable<Long> {

        /* renamed from: a, reason: collision with root package name */
        public final String f7138a;

        /* renamed from: b, reason: collision with root package name */
        public final Segment f7139b;

        /* renamed from: c, reason: collision with root package name */
        public final long f7140c;

        /* renamed from: d, reason: collision with root package name */
        public final int f7141d;

        /* renamed from: e, reason: collision with root package name */
        public final long f7142e;

        /* renamed from: f, reason: collision with root package name */
        public final DrmInitData f7143f;

        /* renamed from: g, reason: collision with root package name */
        public final String f7144g;

        /* renamed from: h, reason: collision with root package name */
        public final String f7145h;

        /* renamed from: i, reason: collision with root package name */
        public final long f7146i;

        /* renamed from: j, reason: collision with root package name */
        public final long f7147j;

        /* renamed from: k, reason: collision with root package name */
        public final boolean f7148k;

        public SegmentBase(String str, Segment segment, long j2, int i2, long j3, DrmInitData drmInitData, String str2, String str3, long j4, long j5, boolean z) {
            this.f7138a = str;
            this.f7139b = segment;
            this.f7140c = j2;
            this.f7141d = i2;
            this.f7142e = j3;
            this.f7143f = drmInitData;
            this.f7144g = str2;
            this.f7145h = str3;
            this.f7146i = j4;
            this.f7147j = j5;
            this.f7148k = z;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Long l2) {
            Long l3 = l2;
            long jLongValue = l3.longValue();
            long j2 = this.f7142e;
            if (j2 > jLongValue) {
                return 1;
            }
            return j2 < l3.longValue() ? -1 : 0;
        }
    }

    public static final class ServerControl {

        /* renamed from: a, reason: collision with root package name */
        public final long f7149a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f7150b;

        /* renamed from: c, reason: collision with root package name */
        public final long f7151c;

        /* renamed from: d, reason: collision with root package name */
        public final long f7152d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f7153e;

        public ServerControl(long j2, boolean z, long j3, long j4, boolean z2) {
            this.f7149a = j2;
            this.f7150b = z;
            this.f7151c = j3;
            this.f7152d = j4;
            this.f7153e = z2;
        }
    }

    public HlsMediaPlaylist(int i2, String str, List list, long j2, boolean z, long j3, boolean z2, int i3, long j4, int i4, long j5, long j6, boolean z3, boolean z4, boolean z5, DrmInitData drmInitData, List list2, List list3, ServerControl serverControl, Map map) {
        super(str, list, z3);
        this.f7121d = i2;
        this.f7125h = j3;
        this.f7124g = z;
        this.f7126i = z2;
        this.f7127j = i3;
        this.f7128k = j4;
        this.f7129l = i4;
        this.f7130m = j5;
        this.n = j6;
        this.o = z4;
        this.p = z5;
        this.q = drmInitData;
        this.r = ImmutableList.o(list2);
        this.s = ImmutableList.o(list3);
        this.t = ImmutableMap.a(map);
        if (!list3.isEmpty()) {
            Part part = (Part) Iterables.c(list3);
            this.u = part.f7142e + part.f7140c;
        } else if (list2.isEmpty()) {
            this.u = 0L;
        } else {
            Segment segment = (Segment) Iterables.c(list2);
            this.u = segment.f7142e + segment.f7140c;
        }
        this.f7122e = j2 != -9223372036854775807L ? j2 >= 0 ? Math.min(this.u, j2) : Math.max(0L, this.u + j2) : -9223372036854775807L;
        this.f7123f = j2 >= 0;
        this.v = serverControl;
    }

    @Override // androidx.media3.exoplayer.offline.FilterableManifest
    public final Object a(List list) {
        return this;
    }

    public static final class Segment extends SegmentBase {

        /* renamed from: l, reason: collision with root package name */
        public final String f7136l;

        /* renamed from: m, reason: collision with root package name */
        public final ImmutableList f7137m;

        public Segment(String str, long j2, long j3, String str2, String str3) {
            this(str, null, "", 0L, -1, -9223372036854775807L, null, str2, str3, j2, j3, false, ImmutableList.r());
        }

        public Segment(String str, Segment segment, String str2, long j2, int i2, long j3, DrmInitData drmInitData, String str3, String str4, long j4, long j5, boolean z, List list) {
            super(str, segment, j2, i2, j3, drmInitData, str3, str4, j4, j5, z);
            this.f7136l = str2;
            this.f7137m = ImmutableList.o(list);
        }
    }
}
