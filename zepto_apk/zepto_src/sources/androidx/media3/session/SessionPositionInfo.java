package androidx.media3.session;

import android.os.Bundle;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class SessionPositionInfo {

    /* renamed from: k, reason: collision with root package name */
    public static final Player.PositionInfo f10246k;

    /* renamed from: l, reason: collision with root package name */
    public static final SessionPositionInfo f10247l;

    /* renamed from: m, reason: collision with root package name */
    public static final String f10248m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;
    public static final String s;
    public static final String t;
    public static final String u;
    public static final String v;

    /* renamed from: a, reason: collision with root package name */
    public final Player.PositionInfo f10249a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10250b;

    /* renamed from: c, reason: collision with root package name */
    public final long f10251c;

    /* renamed from: d, reason: collision with root package name */
    public final long f10252d;

    /* renamed from: e, reason: collision with root package name */
    public final long f10253e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10254f;

    /* renamed from: g, reason: collision with root package name */
    public final long f10255g;

    /* renamed from: h, reason: collision with root package name */
    public final long f10256h;

    /* renamed from: i, reason: collision with root package name */
    public final long f10257i;

    /* renamed from: j, reason: collision with root package name */
    public final long f10258j;

    static {
        Player.PositionInfo positionInfo = new Player.PositionInfo(null, 0, null, null, 0, 0L, 0L, -1, -1);
        f10246k = positionInfo;
        f10247l = new SessionPositionInfo(positionInfo, false, -9223372036854775807L, -9223372036854775807L, 0L, 0, 0L, -9223372036854775807L, -9223372036854775807L, 0L);
        int i2 = Util.f5744a;
        f10248m = Integer.toString(0, 36);
        n = Integer.toString(1, 36);
        o = Integer.toString(2, 36);
        p = Integer.toString(3, 36);
        q = Integer.toString(4, 36);
        r = Integer.toString(5, 36);
        s = Integer.toString(6, 36);
        t = Integer.toString(7, 36);
        u = Integer.toString(8, 36);
        v = Integer.toString(9, 36);
    }

    public SessionPositionInfo(Player.PositionInfo positionInfo, boolean z, long j2, long j3, long j4, int i2, long j5, long j6, long j7, long j8) {
        Assertions.a(z == (positionInfo.f5447h != -1));
        this.f10249a = positionInfo;
        this.f10250b = z;
        this.f10251c = j2;
        this.f10252d = j3;
        this.f10253e = j4;
        this.f10254f = i2;
        this.f10255g = j5;
        this.f10256h = j6;
        this.f10257i = j7;
        this.f10258j = j8;
    }

    public static SessionPositionInfo b(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(f10248m);
        return new SessionPositionInfo(bundle2 == null ? f10246k : Player.PositionInfo.c(bundle2), bundle.getBoolean(n, false), bundle.getLong(o, -9223372036854775807L), bundle.getLong(p, -9223372036854775807L), bundle.getLong(q, 0L), bundle.getInt(r, 0), bundle.getLong(s, 0L), bundle.getLong(t, -9223372036854775807L), bundle.getLong(u, -9223372036854775807L), bundle.getLong(v, 0L));
    }

    public final SessionPositionInfo a(boolean z, boolean z2) {
        if (z && z2) {
            return this;
        }
        return new SessionPositionInfo(this.f10249a.b(z, z2), z && this.f10250b, this.f10251c, z ? this.f10252d : -9223372036854775807L, z ? this.f10253e : 0L, z ? this.f10254f : 0, z ? this.f10255g : 0L, z ? this.f10256h : -9223372036854775807L, z ? this.f10257i : -9223372036854775807L, z ? this.f10258j : 0L);
    }

    public final Bundle c(int i2) {
        Bundle bundle = new Bundle();
        Player.PositionInfo positionInfo = this.f10249a;
        if (i2 < 3 || !f10246k.a(positionInfo)) {
            bundle.putBundle(f10248m, positionInfo.d(i2));
        }
        boolean z = this.f10250b;
        if (z) {
            bundle.putBoolean(n, z);
        }
        long j2 = this.f10251c;
        if (j2 != -9223372036854775807L) {
            bundle.putLong(o, j2);
        }
        long j3 = this.f10252d;
        if (j3 != -9223372036854775807L) {
            bundle.putLong(p, j3);
        }
        long j4 = this.f10253e;
        if (i2 < 3 || j4 != 0) {
            bundle.putLong(q, j4);
        }
        int i3 = this.f10254f;
        if (i3 != 0) {
            bundle.putInt(r, i3);
        }
        long j5 = this.f10255g;
        if (j5 != 0) {
            bundle.putLong(s, j5);
        }
        long j6 = this.f10256h;
        if (j6 != -9223372036854775807L) {
            bundle.putLong(t, j6);
        }
        long j7 = this.f10257i;
        if (j7 != -9223372036854775807L) {
            bundle.putLong(u, j7);
        }
        long j8 = this.f10258j;
        if (i2 >= 3 && j8 == 0) {
            return bundle;
        }
        bundle.putLong(v, j8);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SessionPositionInfo.class == obj.getClass()) {
            SessionPositionInfo sessionPositionInfo = (SessionPositionInfo) obj;
            if (this.f10251c == sessionPositionInfo.f10251c && this.f10249a.equals(sessionPositionInfo.f10249a) && this.f10250b == sessionPositionInfo.f10250b && this.f10252d == sessionPositionInfo.f10252d && this.f10253e == sessionPositionInfo.f10253e && this.f10254f == sessionPositionInfo.f10254f && this.f10255g == sessionPositionInfo.f10255g && this.f10256h == sessionPositionInfo.f10256h && this.f10257i == sessionPositionInfo.f10257i && this.f10258j == sessionPositionInfo.f10258j) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10249a, Boolean.valueOf(this.f10250b)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SessionPositionInfo {PositionInfo {mediaItemIndex=");
        Player.PositionInfo positionInfo = this.f10249a;
        sb.append(positionInfo.f5441b);
        sb.append(", periodIndex=");
        sb.append(positionInfo.f5444e);
        sb.append(", positionMs=");
        sb.append(positionInfo.f5445f);
        sb.append(", contentPositionMs=");
        sb.append(positionInfo.f5446g);
        sb.append(", adGroupIndex=");
        sb.append(positionInfo.f5447h);
        sb.append(", adIndexInAdGroup=");
        sb.append(positionInfo.f5448i);
        sb.append("}, isPlayingAd=");
        sb.append(this.f10250b);
        sb.append(", eventTimeMs=");
        sb.append(this.f10251c);
        sb.append(", durationMs=");
        sb.append(this.f10252d);
        sb.append(", bufferedPositionMs=");
        sb.append(this.f10253e);
        sb.append(", bufferedPercentage=");
        sb.append(this.f10254f);
        sb.append(", totalBufferedDurationMs=");
        sb.append(this.f10255g);
        sb.append(", currentLiveOffsetMs=");
        sb.append(this.f10256h);
        sb.append(", contentDurationMs=");
        sb.append(this.f10257i);
        sb.append(", contentBufferedPositionMs=");
        return android.support.v4.media.b.p(sb, this.f10258j, "}");
    }
}
