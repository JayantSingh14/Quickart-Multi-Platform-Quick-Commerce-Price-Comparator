package androidx.media3.common;

import android.net.Uri;
import android.os.Bundle;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class MediaMetadata {
    public static final MediaMetadata J = new MediaMetadata(new Builder());
    public static final String K;
    public static final String L;
    public static final String M;
    public static final String N;
    public static final String O;
    public static final String P;
    public static final String Q;
    public static final String R;
    public static final String S;
    public static final String T;
    public static final String U;
    public static final String V;
    public static final String W;
    public static final String X;
    public static final String Y;
    public static final String Z;
    public static final String a0;
    public static final String b0;
    public static final String c0;
    public static final String d0;
    public static final String e0;
    public static final String f0;
    public static final String g0;
    public static final String h0;
    public static final String i0;
    public static final String j0;
    public static final String k0;
    public static final String l0;
    public static final String m0;
    public static final String n0;
    public static final String o0;
    public static final String p0;
    public static final String q0;
    public static final String r0;
    public final CharSequence A;
    public final CharSequence B;
    public final Integer C;
    public final Integer D;
    public final CharSequence E;
    public final CharSequence F;
    public final CharSequence G;
    public final Integer H;
    public final Bundle I;

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f5379a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f5380b;

    /* renamed from: c, reason: collision with root package name */
    public final CharSequence f5381c;

    /* renamed from: d, reason: collision with root package name */
    public final CharSequence f5382d;

    /* renamed from: e, reason: collision with root package name */
    public final CharSequence f5383e;

    /* renamed from: f, reason: collision with root package name */
    public final CharSequence f5384f;

    /* renamed from: g, reason: collision with root package name */
    public final CharSequence f5385g;

    /* renamed from: h, reason: collision with root package name */
    public final Long f5386h;

    /* renamed from: i, reason: collision with root package name */
    public final Rating f5387i;

    /* renamed from: j, reason: collision with root package name */
    public final Rating f5388j;

    /* renamed from: k, reason: collision with root package name */
    public final byte[] f5389k;

    /* renamed from: l, reason: collision with root package name */
    public final Integer f5390l;

    /* renamed from: m, reason: collision with root package name */
    public final Uri f5391m;
    public final Integer n;
    public final Integer o;
    public final Integer p;
    public final Boolean q;
    public final Boolean r;
    public final Integer s;
    public final Integer t;
    public final Integer u;
    public final Integer v;
    public final Integer w;
    public final Integer x;
    public final Integer y;
    public final CharSequence z;

    public static final class Builder {
        public CharSequence A;
        public Integer B;
        public Integer C;
        public CharSequence D;
        public CharSequence E;
        public CharSequence F;
        public Integer G;
        public Bundle H;

        /* renamed from: a, reason: collision with root package name */
        public CharSequence f5392a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f5393b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f5394c;

        /* renamed from: d, reason: collision with root package name */
        public CharSequence f5395d;

        /* renamed from: e, reason: collision with root package name */
        public CharSequence f5396e;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f5397f;

        /* renamed from: g, reason: collision with root package name */
        public CharSequence f5398g;

        /* renamed from: h, reason: collision with root package name */
        public Long f5399h;

        /* renamed from: i, reason: collision with root package name */
        public Rating f5400i;

        /* renamed from: j, reason: collision with root package name */
        public Rating f5401j;

        /* renamed from: k, reason: collision with root package name */
        public byte[] f5402k;

        /* renamed from: l, reason: collision with root package name */
        public Integer f5403l;

        /* renamed from: m, reason: collision with root package name */
        public Uri f5404m;
        public Integer n;
        public Integer o;
        public Integer p;
        public Boolean q;
        public Boolean r;
        public Integer s;
        public Integer t;
        public Integer u;
        public Integer v;
        public Integer w;
        public Integer x;
        public CharSequence y;
        public CharSequence z;

        public final void a(int i2, byte[] bArr) {
            if (this.f5402k != null) {
                Integer numValueOf = Integer.valueOf(i2);
                int i3 = Util.f5744a;
                if (!numValueOf.equals(3) && Util.a(this.f5403l, 3)) {
                    return;
                }
            }
            this.f5402k = (byte[]) bArr.clone();
            this.f5403l = Integer.valueOf(i2);
        }

        public final void b(byte[] bArr, Integer num) {
            this.f5402k = bArr == null ? null : (byte[]) bArr.clone();
            this.f5403l = num;
        }

        public final void c(Long l2) {
            Assertions.a(l2 == null || l2.longValue() >= 0);
            this.f5399h = l2;
        }
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Deprecated
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FolderType {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaType {
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PictureType {
    }

    static {
        int i2 = Util.f5744a;
        K = Integer.toString(0, 36);
        L = Integer.toString(1, 36);
        M = Integer.toString(2, 36);
        N = Integer.toString(3, 36);
        O = Integer.toString(4, 36);
        P = Integer.toString(5, 36);
        Q = Integer.toString(6, 36);
        R = Integer.toString(8, 36);
        S = Integer.toString(9, 36);
        T = Integer.toString(10, 36);
        U = Integer.toString(11, 36);
        V = Integer.toString(12, 36);
        W = Integer.toString(13, 36);
        X = Integer.toString(14, 36);
        Y = Integer.toString(15, 36);
        Z = Integer.toString(16, 36);
        a0 = Integer.toString(17, 36);
        b0 = Integer.toString(18, 36);
        c0 = Integer.toString(19, 36);
        d0 = Integer.toString(20, 36);
        e0 = Integer.toString(21, 36);
        f0 = Integer.toString(22, 36);
        g0 = Integer.toString(23, 36);
        h0 = Integer.toString(24, 36);
        i0 = Integer.toString(25, 36);
        j0 = Integer.toString(26, 36);
        k0 = Integer.toString(27, 36);
        l0 = Integer.toString(28, 36);
        m0 = Integer.toString(29, 36);
        n0 = Integer.toString(30, 36);
        o0 = Integer.toString(31, 36);
        p0 = Integer.toString(32, 36);
        q0 = Integer.toString(33, 36);
        r0 = Integer.toString(1000, 36);
    }

    public MediaMetadata(Builder builder) {
        Boolean boolValueOf = builder.q;
        Integer numValueOf = builder.p;
        Integer numValueOf2 = builder.G;
        int i2 = 1;
        int i3 = 0;
        if (boolValueOf != null) {
            if (!boolValueOf.booleanValue()) {
                numValueOf = -1;
            } else if (numValueOf == null || numValueOf.intValue() == -1) {
                if (numValueOf2 != null) {
                    switch (numValueOf2.intValue()) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                            break;
                        case 20:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        default:
                            i2 = 0;
                            break;
                        case 21:
                            i2 = 2;
                            break;
                        case 22:
                            i2 = 3;
                            break;
                        case 23:
                            i2 = 4;
                            break;
                        case 24:
                            i2 = 5;
                            break;
                        case 25:
                            i2 = 6;
                            break;
                    }
                    i3 = i2;
                }
                numValueOf = Integer.valueOf(i3);
            }
        } else if (numValueOf != null) {
            boolean z = numValueOf.intValue() != -1;
            boolValueOf = Boolean.valueOf(z);
            if (z && numValueOf2 == null) {
                switch (numValueOf.intValue()) {
                    case 1:
                        break;
                    case 2:
                        i3 = 21;
                        break;
                    case 3:
                        i3 = 22;
                        break;
                    case 4:
                        i3 = 23;
                        break;
                    case 5:
                        i3 = 24;
                        break;
                    case 6:
                        i3 = 25;
                        break;
                    default:
                        i3 = 20;
                        break;
                }
                numValueOf2 = Integer.valueOf(i3);
            }
        }
        this.f5379a = builder.f5392a;
        this.f5380b = builder.f5393b;
        this.f5381c = builder.f5394c;
        this.f5382d = builder.f5395d;
        this.f5383e = builder.f5396e;
        this.f5384f = builder.f5397f;
        this.f5385g = builder.f5398g;
        this.f5386h = builder.f5399h;
        this.f5387i = builder.f5400i;
        this.f5388j = builder.f5401j;
        this.f5389k = builder.f5402k;
        this.f5390l = builder.f5403l;
        this.f5391m = builder.f5404m;
        this.n = builder.n;
        this.o = builder.o;
        this.p = numValueOf;
        this.q = boolValueOf;
        this.r = builder.r;
        Integer num = builder.s;
        this.s = num;
        this.t = num;
        this.u = builder.t;
        this.v = builder.u;
        this.w = builder.v;
        this.x = builder.w;
        this.y = builder.x;
        this.z = builder.y;
        this.A = builder.z;
        this.B = builder.A;
        this.C = builder.B;
        this.D = builder.C;
        this.E = builder.D;
        this.F = builder.E;
        this.G = builder.F;
        this.H = numValueOf2;
        this.I = builder.H;
    }

    public static MediaMetadata b(Bundle bundle) {
        Bundle bundle2;
        Bundle bundle3;
        Builder builder = new Builder();
        builder.f5392a = bundle.getCharSequence(K);
        builder.f5393b = bundle.getCharSequence(L);
        builder.f5394c = bundle.getCharSequence(M);
        builder.f5395d = bundle.getCharSequence(N);
        builder.f5396e = bundle.getCharSequence(O);
        builder.f5397f = bundle.getCharSequence(P);
        builder.f5398g = bundle.getCharSequence(Q);
        byte[] byteArray = bundle.getByteArray(T);
        String str = m0;
        builder.b(byteArray, bundle.containsKey(str) ? Integer.valueOf(bundle.getInt(str)) : null);
        builder.f5404m = (Uri) bundle.getParcelable(U);
        builder.y = bundle.getCharSequence(f0);
        builder.z = bundle.getCharSequence(g0);
        builder.A = bundle.getCharSequence(h0);
        builder.D = bundle.getCharSequence(k0);
        builder.E = bundle.getCharSequence(l0);
        builder.F = bundle.getCharSequence(n0);
        builder.H = bundle.getBundle(r0);
        String str2 = R;
        if (bundle.containsKey(str2) && (bundle3 = bundle.getBundle(str2)) != null) {
            builder.f5400i = Rating.a(bundle3);
        }
        String str3 = S;
        if (bundle.containsKey(str3) && (bundle2 = bundle.getBundle(str3)) != null) {
            builder.f5401j = Rating.a(bundle2);
        }
        String str4 = q0;
        if (bundle.containsKey(str4)) {
            builder.c(Long.valueOf(bundle.getLong(str4)));
        }
        String str5 = V;
        if (bundle.containsKey(str5)) {
            builder.n = Integer.valueOf(bundle.getInt(str5));
        }
        String str6 = W;
        if (bundle.containsKey(str6)) {
            builder.o = Integer.valueOf(bundle.getInt(str6));
        }
        String str7 = X;
        if (bundle.containsKey(str7)) {
            builder.p = Integer.valueOf(bundle.getInt(str7));
        }
        String str8 = p0;
        if (bundle.containsKey(str8)) {
            builder.q = Boolean.valueOf(bundle.getBoolean(str8));
        }
        String str9 = Y;
        if (bundle.containsKey(str9)) {
            builder.r = Boolean.valueOf(bundle.getBoolean(str9));
        }
        String str10 = Z;
        if (bundle.containsKey(str10)) {
            builder.s = Integer.valueOf(bundle.getInt(str10));
        }
        String str11 = a0;
        if (bundle.containsKey(str11)) {
            builder.t = Integer.valueOf(bundle.getInt(str11));
        }
        String str12 = b0;
        if (bundle.containsKey(str12)) {
            builder.u = Integer.valueOf(bundle.getInt(str12));
        }
        String str13 = c0;
        if (bundle.containsKey(str13)) {
            builder.v = Integer.valueOf(bundle.getInt(str13));
        }
        String str14 = d0;
        if (bundle.containsKey(str14)) {
            builder.w = Integer.valueOf(bundle.getInt(str14));
        }
        String str15 = e0;
        if (bundle.containsKey(str15)) {
            builder.x = Integer.valueOf(bundle.getInt(str15));
        }
        String str16 = i0;
        if (bundle.containsKey(str16)) {
            builder.B = Integer.valueOf(bundle.getInt(str16));
        }
        String str17 = j0;
        if (bundle.containsKey(str17)) {
            builder.C = Integer.valueOf(bundle.getInt(str17));
        }
        String str18 = o0;
        if (bundle.containsKey(str18)) {
            builder.G = Integer.valueOf(bundle.getInt(str18));
        }
        return new MediaMetadata(builder);
    }

    public final Builder a() {
        Builder builder = new Builder();
        builder.f5392a = this.f5379a;
        builder.f5393b = this.f5380b;
        builder.f5394c = this.f5381c;
        builder.f5395d = this.f5382d;
        builder.f5396e = this.f5383e;
        builder.f5397f = this.f5384f;
        builder.f5398g = this.f5385g;
        builder.f5399h = this.f5386h;
        builder.f5400i = this.f5387i;
        builder.f5401j = this.f5388j;
        builder.f5402k = this.f5389k;
        builder.f5403l = this.f5390l;
        builder.f5404m = this.f5391m;
        builder.n = this.n;
        builder.o = this.o;
        builder.p = this.p;
        builder.q = this.q;
        builder.r = this.r;
        builder.s = this.t;
        builder.t = this.u;
        builder.u = this.v;
        builder.v = this.w;
        builder.w = this.x;
        builder.x = this.y;
        builder.y = this.z;
        builder.z = this.A;
        builder.A = this.B;
        builder.B = this.C;
        builder.C = this.D;
        builder.D = this.E;
        builder.E = this.F;
        builder.F = this.G;
        builder.G = this.H;
        builder.H = this.I;
        return builder;
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.f5379a;
        if (charSequence != null) {
            bundle.putCharSequence(K, charSequence);
        }
        CharSequence charSequence2 = this.f5380b;
        if (charSequence2 != null) {
            bundle.putCharSequence(L, charSequence2);
        }
        CharSequence charSequence3 = this.f5381c;
        if (charSequence3 != null) {
            bundle.putCharSequence(M, charSequence3);
        }
        CharSequence charSequence4 = this.f5382d;
        if (charSequence4 != null) {
            bundle.putCharSequence(N, charSequence4);
        }
        CharSequence charSequence5 = this.f5383e;
        if (charSequence5 != null) {
            bundle.putCharSequence(O, charSequence5);
        }
        CharSequence charSequence6 = this.f5384f;
        if (charSequence6 != null) {
            bundle.putCharSequence(P, charSequence6);
        }
        CharSequence charSequence7 = this.f5385g;
        if (charSequence7 != null) {
            bundle.putCharSequence(Q, charSequence7);
        }
        Long l2 = this.f5386h;
        if (l2 != null) {
            bundle.putLong(q0, l2.longValue());
        }
        byte[] bArr = this.f5389k;
        if (bArr != null) {
            bundle.putByteArray(T, bArr);
        }
        Uri uri = this.f5391m;
        if (uri != null) {
            bundle.putParcelable(U, uri);
        }
        CharSequence charSequence8 = this.z;
        if (charSequence8 != null) {
            bundle.putCharSequence(f0, charSequence8);
        }
        CharSequence charSequence9 = this.A;
        if (charSequence9 != null) {
            bundle.putCharSequence(g0, charSequence9);
        }
        CharSequence charSequence10 = this.B;
        if (charSequence10 != null) {
            bundle.putCharSequence(h0, charSequence10);
        }
        CharSequence charSequence11 = this.E;
        if (charSequence11 != null) {
            bundle.putCharSequence(k0, charSequence11);
        }
        CharSequence charSequence12 = this.F;
        if (charSequence12 != null) {
            bundle.putCharSequence(l0, charSequence12);
        }
        CharSequence charSequence13 = this.G;
        if (charSequence13 != null) {
            bundle.putCharSequence(n0, charSequence13);
        }
        Rating rating = this.f5387i;
        if (rating != null) {
            bundle.putBundle(R, rating.c());
        }
        Rating rating2 = this.f5388j;
        if (rating2 != null) {
            bundle.putBundle(S, rating2.c());
        }
        Integer num = this.n;
        if (num != null) {
            bundle.putInt(V, num.intValue());
        }
        Integer num2 = this.o;
        if (num2 != null) {
            bundle.putInt(W, num2.intValue());
        }
        Integer num3 = this.p;
        if (num3 != null) {
            bundle.putInt(X, num3.intValue());
        }
        Boolean bool = this.q;
        if (bool != null) {
            bundle.putBoolean(p0, bool.booleanValue());
        }
        Boolean bool2 = this.r;
        if (bool2 != null) {
            bundle.putBoolean(Y, bool2.booleanValue());
        }
        Integer num4 = this.t;
        if (num4 != null) {
            bundle.putInt(Z, num4.intValue());
        }
        Integer num5 = this.u;
        if (num5 != null) {
            bundle.putInt(a0, num5.intValue());
        }
        Integer num6 = this.v;
        if (num6 != null) {
            bundle.putInt(b0, num6.intValue());
        }
        Integer num7 = this.w;
        if (num7 != null) {
            bundle.putInt(c0, num7.intValue());
        }
        Integer num8 = this.x;
        if (num8 != null) {
            bundle.putInt(d0, num8.intValue());
        }
        Integer num9 = this.y;
        if (num9 != null) {
            bundle.putInt(e0, num9.intValue());
        }
        Integer num10 = this.C;
        if (num10 != null) {
            bundle.putInt(i0, num10.intValue());
        }
        Integer num11 = this.D;
        if (num11 != null) {
            bundle.putInt(j0, num11.intValue());
        }
        Integer num12 = this.f5390l;
        if (num12 != null) {
            bundle.putInt(m0, num12.intValue());
        }
        Integer num13 = this.H;
        if (num13 != null) {
            bundle.putInt(o0, num13.intValue());
        }
        Bundle bundle2 = this.I;
        if (bundle2 != null) {
            bundle.putBundle(r0, bundle2);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && MediaMetadata.class == obj.getClass()) {
            MediaMetadata mediaMetadata = (MediaMetadata) obj;
            if (Util.a(this.f5379a, mediaMetadata.f5379a) && Util.a(this.f5380b, mediaMetadata.f5380b) && Util.a(this.f5381c, mediaMetadata.f5381c) && Util.a(this.f5382d, mediaMetadata.f5382d) && Util.a(this.f5383e, mediaMetadata.f5383e) && Util.a(this.f5384f, mediaMetadata.f5384f) && Util.a(this.f5385g, mediaMetadata.f5385g) && Util.a(this.f5386h, mediaMetadata.f5386h) && Util.a(this.f5387i, mediaMetadata.f5387i) && Util.a(this.f5388j, mediaMetadata.f5388j) && Arrays.equals(this.f5389k, mediaMetadata.f5389k) && Util.a(this.f5390l, mediaMetadata.f5390l) && Util.a(this.f5391m, mediaMetadata.f5391m) && Util.a(this.n, mediaMetadata.n) && Util.a(this.o, mediaMetadata.o) && Util.a(this.p, mediaMetadata.p) && Util.a(this.q, mediaMetadata.q) && Util.a(this.r, mediaMetadata.r) && Util.a(this.t, mediaMetadata.t) && Util.a(this.u, mediaMetadata.u) && Util.a(this.v, mediaMetadata.v) && Util.a(this.w, mediaMetadata.w) && Util.a(this.x, mediaMetadata.x) && Util.a(this.y, mediaMetadata.y) && Util.a(this.z, mediaMetadata.z) && Util.a(this.A, mediaMetadata.A) && Util.a(this.B, mediaMetadata.B) && Util.a(this.C, mediaMetadata.C) && Util.a(this.D, mediaMetadata.D) && Util.a(this.E, mediaMetadata.E) && Util.a(this.F, mediaMetadata.F) && Util.a(this.G, mediaMetadata.G) && Util.a(this.H, mediaMetadata.H)) {
                if ((this.I == null) == (mediaMetadata.I == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5379a, this.f5380b, this.f5381c, this.f5382d, this.f5383e, this.f5384f, this.f5385g, this.f5386h, this.f5387i, this.f5388j, Integer.valueOf(Arrays.hashCode(this.f5389k)), this.f5390l, this.f5391m, this.n, this.o, this.p, this.q, this.r, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E, this.F, this.G, this.H, Boolean.valueOf(this.I == null)});
    }
}
