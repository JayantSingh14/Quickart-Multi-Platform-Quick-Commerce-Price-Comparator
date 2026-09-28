package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import in.juspay.hypersdk.analytics.LogConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.UUID;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes4.dex */
public final class zzv {
    public static final /* synthetic */ int N = 0;
    public final byte[] A;
    public final int B;
    public final zzi C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public final int K;
    public final int L;
    public int M;

    /* renamed from: a, reason: collision with root package name */
    public final String f35679a;

    /* renamed from: b, reason: collision with root package name */
    public final String f35680b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgtd f35681c;

    /* renamed from: d, reason: collision with root package name */
    public final String f35682d;

    /* renamed from: e, reason: collision with root package name */
    public final int f35683e;

    /* renamed from: f, reason: collision with root package name */
    public final int f35684f;

    /* renamed from: g, reason: collision with root package name */
    public final int f35685g;

    /* renamed from: h, reason: collision with root package name */
    public final int f35686h;

    /* renamed from: i, reason: collision with root package name */
    public final int f35687i;

    /* renamed from: j, reason: collision with root package name */
    public final String f35688j;

    /* renamed from: k, reason: collision with root package name */
    public final zzap f35689k;

    /* renamed from: l, reason: collision with root package name */
    public final String f35690l;

    /* renamed from: m, reason: collision with root package name */
    public final String f35691m;
    public final int n;
    public final int o;
    public final List p;
    public final zzq q;
    public final long r;
    public final boolean s;
    public final int t;
    public final int u;
    public final int v;
    public final int w;
    public final float x;
    public final int y;
    public final float z;

    static {
        new zzv(new zzt());
        String str = zzfj.f31254a;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
        Integer.toString(8, 36);
        Integer.toString(9, 36);
        Integer.toString(10, 36);
        Integer.toString(11, 36);
        Integer.toString(12, 36);
        Integer.toString(13, 36);
        Integer.toString(14, 36);
        Integer.toString(15, 36);
        Integer.toString(16, 36);
        Integer.toString(17, 36);
        Integer.toString(18, 36);
        Integer.toString(19, 36);
        Integer.toString(20, 36);
        Integer.toString(21, 36);
        Integer.toString(22, 36);
        Integer.toString(23, 36);
        Integer.toString(24, 36);
        Integer.toString(25, 36);
        Integer.toString(26, 36);
        Integer.toString(27, 36);
        Integer.toString(28, 36);
        Integer.toString(29, 36);
        Integer.toString(30, 36);
        Integer.toString(31, 36);
        Integer.toString(32, 36);
        Integer.toString(33, 36);
        Integer.toString(34, 36);
        Integer.toString(35, 36);
        Integer.toString(36, 36);
    }

    public zzv(zzt zztVar) throws MissingResourceException {
        boolean z;
        String str;
        this.f35679a = zztVar.f35564a;
        String strO = zzfj.o(zztVar.f35567d);
        this.f35682d = strO;
        if (zztVar.f35566c.isEmpty() && zztVar.f35565b != null) {
            this.f35681c = zzgtd.n(new zzx(strO, zztVar.f35565b));
            this.f35680b = zztVar.f35565b;
        } else if (!zztVar.f35566c.isEmpty() && zztVar.f35565b == null) {
            zzgtd zzgtdVar = zztVar.f35566c;
            this.f35681c = zzgtdVar;
            Iterator it = zzgtdVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = ((zzx) zzgtdVar.get(0)).f35803b;
                    break;
                }
                zzx zzxVar = (zzx) it.next();
                if (TextUtils.equals(zzxVar.f35802a, strO)) {
                    str = zzxVar.f35803b;
                    break;
                }
            }
            this.f35680b = str;
        } else if (zztVar.f35566c.isEmpty() && zztVar.f35565b == null) {
            z = true;
            zzgqa.f(z);
            this.f35681c = zztVar.f35566c;
            this.f35680b = zztVar.f35565b;
        } else {
            for (int i2 = 0; i2 < zztVar.f35566c.size(); i2++) {
                if (((zzx) zztVar.f35566c.get(i2)).f35803b.equals(zztVar.f35565b)) {
                    z = true;
                    break;
                }
            }
            z = false;
            zzgqa.f(z);
            this.f35681c = zztVar.f35566c;
            this.f35680b = zztVar.f35565b;
        }
        this.f35683e = zztVar.f35568e;
        this.f35684f = zztVar.f35569f;
        int i3 = zztVar.f35570g;
        this.f35685g = i3;
        int i4 = zztVar.f35571h;
        this.f35686h = i4;
        this.f35687i = i4 != -1 ? i4 : i3;
        this.f35688j = zztVar.f35572i;
        this.f35689k = zztVar.f35573j;
        this.f35690l = zztVar.f35574k;
        this.f35691m = zztVar.f35575l;
        this.n = zztVar.f35576m;
        this.o = zztVar.n;
        List list = zztVar.o;
        this.p = list == null ? Collections.EMPTY_LIST : list;
        zzq zzqVar = zztVar.p;
        this.q = zzqVar;
        this.r = zztVar.q;
        this.s = zztVar.r;
        this.t = zztVar.s;
        this.u = zztVar.t;
        this.v = zztVar.u;
        this.w = zztVar.v;
        this.x = zztVar.w;
        int i5 = zztVar.x;
        this.y = i5 == -1 ? 0 : i5;
        float f2 = zztVar.y;
        this.z = f2 == -1.0f ? 1.0f : f2;
        this.A = zztVar.z;
        this.B = zztVar.A;
        this.C = zztVar.B;
        this.D = zztVar.C;
        this.E = zztVar.D;
        this.F = zztVar.E;
        this.G = zztVar.F;
        int i6 = zztVar.G;
        this.H = i6 == -1 ? 0 : i6;
        int i7 = zztVar.H;
        this.I = i7 != -1 ? i7 : 0;
        this.J = zztVar.I;
        this.K = zztVar.J;
        int i8 = zztVar.K;
        if (i8 != 0 || zzqVar == null) {
            this.L = i8;
        } else {
            this.L = 1;
        }
    }

    public static String c(zzv zzvVar) {
        String str;
        String string;
        int i2;
        int i3;
        StringBuilder sbW = android.support.v4.media.b.w("id=");
        sbW.append(zzvVar.f35679a);
        sbW.append(", mimeType=");
        sbW.append(zzvVar.f35691m);
        String str2 = zzvVar.f35690l;
        if (str2 != null) {
            sbW.append(", container=");
            sbW.append(str2);
        }
        int i4 = zzvVar.f35687i;
        if (i4 != -1) {
            sbW.append(", bitrate=");
            sbW.append(i4);
        }
        String str3 = zzvVar.f35688j;
        if (str3 != null) {
            sbW.append(", codecs=");
            sbW.append(str3);
        }
        boolean z = false;
        zzq zzqVar = zzvVar.q;
        if (zzqVar != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (int i5 = 0; i5 < zzqVar.f35364d; i5++) {
                UUID uuid = zzqVar.f35361a[i5].f35278b;
                if (uuid.equals(zzg.f32143b)) {
                    linkedHashSet.add("cenc");
                } else if (uuid.equals(zzg.f32144c)) {
                    linkedHashSet.add("clearkey");
                } else if (uuid.equals(zzg.f32146e)) {
                    linkedHashSet.add("playready");
                } else if (uuid.equals(zzg.f32145d)) {
                    linkedHashSet.add("widevine");
                } else if (uuid.equals(zzg.f32142a)) {
                    linkedHashSet.add("universal");
                } else {
                    String string2 = uuid.toString();
                    StringBuilder sb = new StringBuilder(string2.length() + 10);
                    sb.append("unknown (");
                    sb.append(string2);
                    sb.append(")");
                    linkedHashSet.add(sb.toString());
                }
            }
            sbW.append(", drm=[");
            zzgpu.a(sbW, linkedHashSet.iterator(), ",");
            sbW.append(']');
        }
        int i6 = zzvVar.t;
        if (i6 != -1 && (i3 = zzvVar.u) != -1) {
            androidx.fragment.app.e.w(i6, i3, ", res=", "x", sbW);
        }
        int i7 = zzvVar.v;
        if (i7 != -1 && (i2 = zzvVar.w) != -1) {
            androidx.fragment.app.e.w(i7, i2, ", decRes=", "x", sbW);
        }
        int i8 = zzgwn.f33294a;
        float f2 = zzvVar.z;
        double d2 = f2;
        if (Math.copySign((-1.0d) + d2, 1.0d) > 0.001d && d2 != 1.0d && (!Double.isNaN(d2) || !Double.isNaN(1.0d))) {
            sbW.append(", par=");
            Object[] objArr = {Float.valueOf(f2)};
            String str4 = zzfj.f31254a;
            sbW.append(String.format(Locale.US, "%.3f", objArr));
        }
        zzi zziVar = zzvVar.C;
        if (zziVar != null) {
            int i9 = zziVar.f34615e;
            int i10 = zziVar.f34616f;
            if ((i9 != -1 && i10 != -1) || zziVar.d()) {
                sbW.append(", color=");
                if (zziVar.d()) {
                    String strE = zzi.e(zziVar.f34611a);
                    String strG = zzi.g(zziVar.f34612b);
                    String strF = zzi.f(zziVar.f34613c);
                    String str5 = zzfj.f31254a;
                    Locale locale = Locale.US;
                    str = strE + "/" + strG + "/" + strF;
                } else {
                    str = "NA/NA/NA";
                }
                if (i9 != -1 && i10 != -1) {
                    z = true;
                }
                if (z) {
                    StringBuilder sb2 = new StringBuilder(androidx.fragment.app.e.a(i9, 1) + String.valueOf(i10).length());
                    sb2.append(i9);
                    sb2.append("/");
                    sb2.append(i10);
                    string = sb2.toString();
                } else {
                    string = "NA/NA";
                }
                StringBuilder sb3 = new StringBuilder(string.length() + str.length() + 1);
                sb3.append(str);
                sb3.append("/");
                sb3.append(string);
                sbW.append(sb3.toString());
            }
        }
        float f3 = zzvVar.x;
        if (f3 != -1.0f) {
            sbW.append(", fps=");
            sbW.append(f3);
        }
        int i11 = zzvVar.D;
        if (i11 != -1) {
            sbW.append(", maxSubLayers=");
            sbW.append(i11);
        }
        int i12 = zzvVar.E;
        if (i12 != -1) {
            sbW.append(", channels=");
            sbW.append(i12);
        }
        int i13 = zzvVar.F;
        if (i13 != -1) {
            sbW.append(", sample_rate=");
            sbW.append(i13);
        }
        String str6 = zzvVar.f35682d;
        if (str6 != null) {
            sbW.append(", language=");
            sbW.append(str6);
        }
        zzgtd zzgtdVar = zzvVar.f35681c;
        if (!zzgtdVar.isEmpty()) {
            sbW.append(", labels=[");
            zzgpu.a(sbW, zzgud.b(zzgtdVar, zzu.f35634a).iterator(), ",");
            sbW.append("]");
        }
        int i14 = zzvVar.f35683e;
        if (i14 != 0) {
            sbW.append(", selectionFlags=[");
            String str7 = zzfj.f31254a;
            ArrayList arrayList = new ArrayList();
            if ((i14 & 1) != 0) {
                arrayList.add(LogConstants.DEFAULT_CHANNEL);
            }
            if ((i14 & 2) != 0) {
                arrayList.add("forced");
            }
            zzgpu.a(sbW, arrayList.iterator(), ",");
            sbW.append("]");
        }
        int i15 = zzvVar.f35684f;
        if (i15 != 0) {
            sbW.append(", roleFlags=[");
            int i16 = i15 & 32768;
            String str8 = zzfj.f31254a;
            ArrayList arrayList2 = new ArrayList();
            if ((1 & i15) != 0) {
                arrayList2.add("main");
            }
            if ((i15 & 2) != 0) {
                arrayList2.add("alt");
            }
            if ((i15 & 4) != 0) {
                arrayList2.add("supplementary");
            }
            if ((i15 & 8) != 0) {
                arrayList2.add("commentary");
            }
            if ((i15 & 16) != 0) {
                arrayList2.add("dub");
            }
            if ((i15 & 32) != 0) {
                arrayList2.add("emergency");
            }
            if ((i15 & 64) != 0) {
                arrayList2.add("caption");
            }
            if ((i15 & 128) != 0) {
                arrayList2.add("subtitle");
            }
            if ((i15 & 256) != 0) {
                arrayList2.add("sign");
            }
            if ((i15 & 512) != 0) {
                arrayList2.add("describes-video");
            }
            if ((i15 & 1024) != 0) {
                arrayList2.add("describes-music");
            }
            if ((i15 & 2048) != 0) {
                arrayList2.add("enhanced-intelligibility");
            }
            if ((i15 & 4096) != 0) {
                arrayList2.add("transcribes-dialog");
            }
            if ((i15 & KEYRecord.Flags.FLAG2) != 0) {
                arrayList2.add("easy-read");
            }
            if ((i15 & 16384) != 0) {
                arrayList2.add("trick-play");
            }
            if (i16 != 0) {
                arrayList2.add("auxiliary");
            }
            zzgpu.a(sbW, arrayList2.iterator(), ",");
            sbW.append("]");
        }
        if ((i15 & 32768) != 0) {
            sbW.append(", auxiliaryTrackType=");
            String str9 = zzfj.f31254a;
            sbW.append("undefined");
        }
        return sbW.toString();
    }

    public final zzt a() {
        return new zzt(this);
    }

    public final boolean b(zzv zzvVar) {
        List list = this.p;
        int size = list.size();
        List list2 = zzvVar.p;
        if (size != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!Arrays.equals((byte[]) list.get(i2), (byte[]) list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        int i2;
        if (this == obj) {
            return true;
        }
        if (obj == null || zzv.class != obj.getClass()) {
            return false;
        }
        zzv zzvVar = (zzv) obj;
        int i3 = this.M;
        return (i3 == 0 || (i2 = zzvVar.M) == 0 || i3 == i2) && this.f35683e == zzvVar.f35683e && this.f35684f == zzvVar.f35684f && this.f35685g == zzvVar.f35685g && this.f35686h == zzvVar.f35686h && this.n == zzvVar.n && this.r == zzvVar.r && this.t == zzvVar.t && this.u == zzvVar.u && this.v == zzvVar.v && this.w == zzvVar.w && this.y == zzvVar.y && this.B == zzvVar.B && this.D == zzvVar.D && this.E == zzvVar.E && this.F == zzvVar.F && this.G == zzvVar.G && this.H == zzvVar.H && this.I == zzvVar.I && this.J == zzvVar.J && this.L == zzvVar.L && Float.compare(this.x, zzvVar.x) == 0 && Float.compare(this.z, zzvVar.z) == 0 && Objects.equals(this.f35679a, zzvVar.f35679a) && Objects.equals(this.f35680b, zzvVar.f35680b) && this.f35681c.equals(zzvVar.f35681c) && Objects.equals(this.f35688j, zzvVar.f35688j) && Objects.equals(this.f35690l, zzvVar.f35690l) && Objects.equals(this.f35691m, zzvVar.f35691m) && Objects.equals(this.f35682d, zzvVar.f35682d) && Arrays.equals(this.A, zzvVar.A) && Objects.equals(this.f35689k, zzvVar.f35689k) && Objects.equals(this.C, zzvVar.C) && Objects.equals(this.q, zzvVar.q) && b(zzvVar);
    }

    public final int hashCode() {
        int i2 = this.M;
        if (i2 != 0) {
            return i2;
        }
        String str = this.f35679a;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.f35680b;
        int iHashCode2 = this.f35681c.hashCode() + ((((iHashCode + 527) * 31) + (str2 == null ? 0 : str2.hashCode())) * 31);
        String str3 = this.f35682d;
        int iHashCode3 = ((((((((((iHashCode2 * 31) + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f35683e) * 31) + this.f35684f) * 961) + this.f35685g) * 31) + this.f35686h) * 31;
        String str4 = this.f35688j;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        zzap zzapVar = this.f35689k;
        int iHashCode5 = iHashCode4 + (zzapVar == null ? 0 : zzapVar.hashCode());
        String str5 = this.f35690l;
        int iHashCode6 = ((iHashCode5 * 961) + (str5 == null ? 0 : str5.hashCode())) * 31;
        int iFloatToIntBits = ((((((((((((((((((((((Float.floatToIntBits(this.z) + ((((Float.floatToIntBits(this.x) + ((((((((((((((iHashCode6 + (this.f35691m != null ? r1.hashCode() : 0)) * 31) + this.n) * 31) + ((int) this.r)) * 31) + this.t) * 31) + this.u) * 31) + this.v) * 31) + this.w) * 31)) * 31) + this.y) * 31)) * 31) + this.B) * 31) + this.D) * 31) + this.E) * 31) + this.F) * 31) + this.G) * 31) + this.H) * 31) + this.I) * 31) + this.J) * 31) - 1) * 31) - 1) * 31) + this.L;
        this.M = iFloatToIntBits;
        return iFloatToIntBits;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.C);
        String str = this.f35679a;
        int length = String.valueOf(str).length();
        String str2 = this.f35680b;
        int length2 = String.valueOf(str2).length();
        String str3 = this.f35690l;
        int length3 = String.valueOf(str3).length();
        String str4 = this.f35691m;
        int length4 = String.valueOf(str4).length();
        String str5 = this.f35688j;
        int length5 = String.valueOf(str5).length();
        int i2 = this.f35687i;
        int length6 = String.valueOf(i2).length();
        String str6 = this.f35682d;
        int length7 = String.valueOf(str6).length();
        int i3 = this.t;
        int length8 = String.valueOf(i3).length();
        int i4 = this.u;
        int length9 = String.valueOf(i4).length();
        float f2 = this.x;
        int length10 = String.valueOf(f2).length();
        int length11 = strValueOf.length();
        int i5 = this.E;
        int length12 = String.valueOf(i5).length();
        int i6 = this.F;
        StringBuilder sb = new StringBuilder(length + 9 + length2 + 2 + length3 + 2 + length4 + 2 + length5 + 2 + length6 + 2 + length7 + 3 + length8 + 2 + length9 + 2 + length10 + 2 + length11 + 4 + length12 + 2 + String.valueOf(i6).length() + 2);
        android.support.v4.media.b.B(sb, "Format(", str, ", ", str2);
        android.support.v4.media.b.B(sb, ", ", str3, ", ", str4);
        sb.append(", ");
        sb.append(str5);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(str6);
        sb.append(", [");
        sb.append(i3);
        sb.append(", ");
        sb.append(i4);
        sb.append(", ");
        sb.append(f2);
        sb.append(", ");
        sb.append(strValueOf);
        sb.append("], [");
        sb.append(i5);
        return androidx.fragment.app.e.u(sb, ", ", i6, "])");
    }
}
