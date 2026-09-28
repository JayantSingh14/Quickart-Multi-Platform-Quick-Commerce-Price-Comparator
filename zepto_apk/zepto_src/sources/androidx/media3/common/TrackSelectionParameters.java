package androidx.media3.common;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.android.gms.common.api.Api;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableListIterator;
import com.google.common.primitives.Ints;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class TrackSelectionParameters {
    public static final TrackSelectionParameters C = new TrackSelectionParameters(new Builder());
    public static final String D;
    public static final String E;
    public static final String F;
    public static final String G;
    public static final String H;
    public static final String I;
    public static final String J;
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
    public final ImmutableMap A;
    public final ImmutableSet B;

    /* renamed from: a, reason: collision with root package name */
    public final int f5510a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5511b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5512c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5513d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5514e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5515f;

    /* renamed from: g, reason: collision with root package name */
    public final int f5516g;

    /* renamed from: h, reason: collision with root package name */
    public final int f5517h;

    /* renamed from: i, reason: collision with root package name */
    public final int f5518i;

    /* renamed from: j, reason: collision with root package name */
    public final int f5519j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f5520k;

    /* renamed from: l, reason: collision with root package name */
    public final ImmutableList f5521l;

    /* renamed from: m, reason: collision with root package name */
    public final int f5522m;
    public final ImmutableList n;
    public final int o;
    public final int p;
    public final int q;
    public final ImmutableList r;
    public final AudioOffloadPreferences s;
    public final ImmutableList t;
    public final int u;
    public final int v;
    public final boolean w;
    public final boolean x;
    public final boolean y;
    public final boolean z;

    @UnstableApi
    public static final class AudioOffloadPreferences {

        /* renamed from: d, reason: collision with root package name */
        public static final AudioOffloadPreferences f5523d = new AudioOffloadPreferences(new Builder());

        /* renamed from: e, reason: collision with root package name */
        public static final String f5524e;

        /* renamed from: f, reason: collision with root package name */
        public static final String f5525f;

        /* renamed from: g, reason: collision with root package name */
        public static final String f5526g;

        /* renamed from: a, reason: collision with root package name */
        public final int f5527a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f5528b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f5529c;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface AudioOffloadMode {
        }

        public static final class Builder {

            /* renamed from: a, reason: collision with root package name */
            public int f5530a = 0;

            /* renamed from: b, reason: collision with root package name */
            public boolean f5531b = false;

            /* renamed from: c, reason: collision with root package name */
            public boolean f5532c = false;
        }

        static {
            int i2 = Util.f5744a;
            f5524e = Integer.toString(1, 36);
            f5525f = Integer.toString(2, 36);
            f5526g = Integer.toString(3, 36);
        }

        public AudioOffloadPreferences(Builder builder) {
            this.f5527a = builder.f5530a;
            this.f5528b = builder.f5531b;
            this.f5529c = builder.f5532c;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && AudioOffloadPreferences.class == obj.getClass()) {
                AudioOffloadPreferences audioOffloadPreferences = (AudioOffloadPreferences) obj;
                if (this.f5527a == audioOffloadPreferences.f5527a && this.f5528b == audioOffloadPreferences.f5528b && this.f5529c == audioOffloadPreferences.f5529c) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return ((((this.f5527a + 31) * 31) + (this.f5528b ? 1 : 0)) * 31) + (this.f5529c ? 1 : 0);
        }
    }

    public static class Builder {

        /* renamed from: e, reason: collision with root package name */
        public int f5537e;

        /* renamed from: f, reason: collision with root package name */
        public int f5538f;

        /* renamed from: g, reason: collision with root package name */
        public int f5539g;

        /* renamed from: h, reason: collision with root package name */
        public int f5540h;

        /* renamed from: a, reason: collision with root package name */
        public int f5533a = Api.BaseClientBuilder.API_PRIORITY_OTHER;

        /* renamed from: b, reason: collision with root package name */
        public int f5534b = Api.BaseClientBuilder.API_PRIORITY_OTHER;

        /* renamed from: c, reason: collision with root package name */
        public int f5535c = Api.BaseClientBuilder.API_PRIORITY_OTHER;

        /* renamed from: d, reason: collision with root package name */
        public int f5536d = Api.BaseClientBuilder.API_PRIORITY_OTHER;

        /* renamed from: i, reason: collision with root package name */
        public int f5541i = Api.BaseClientBuilder.API_PRIORITY_OTHER;

        /* renamed from: j, reason: collision with root package name */
        public int f5542j = Api.BaseClientBuilder.API_PRIORITY_OTHER;

        /* renamed from: k, reason: collision with root package name */
        public boolean f5543k = true;

        /* renamed from: l, reason: collision with root package name */
        public ImmutableList f5544l = ImmutableList.r();

        /* renamed from: m, reason: collision with root package name */
        public int f5545m = 0;
        public ImmutableList n = ImmutableList.r();
        public int o = 0;
        public int p = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        public int q = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        public ImmutableList r = ImmutableList.r();
        public AudioOffloadPreferences s = AudioOffloadPreferences.f5523d;
        public ImmutableList t = ImmutableList.r();
        public int u = 0;
        public int v = 0;
        public boolean w = false;
        public boolean x = false;
        public boolean y = false;
        public boolean z = false;
        public HashMap A = new HashMap();
        public HashSet B = new HashSet();

        @UnstableApi
        @Deprecated
        public Builder() {
        }

        public static ImmutableList f(String[] strArr) {
            UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
            ImmutableList.Builder builder = new ImmutableList.Builder();
            for (String str : strArr) {
                str.getClass();
                builder.h(Util.U(str));
            }
            return builder.j();
        }

        public void a(TrackSelectionOverride trackSelectionOverride) {
            this.A.put(trackSelectionOverride.f5508a, trackSelectionOverride);
        }

        public TrackSelectionParameters b() {
            return new TrackSelectionParameters(this);
        }

        public Builder c() {
            this.A.clear();
            return this;
        }

        public Builder d(int i2) {
            Iterator it = this.A.values().iterator();
            while (it.hasNext()) {
                if (((TrackSelectionOverride) it.next()).f5508a.f5503c == i2) {
                    it.remove();
                }
            }
            return this;
        }

        public final void e(TrackSelectionParameters trackSelectionParameters) {
            this.f5533a = trackSelectionParameters.f5510a;
            this.f5534b = trackSelectionParameters.f5511b;
            this.f5535c = trackSelectionParameters.f5512c;
            this.f5536d = trackSelectionParameters.f5513d;
            this.f5537e = trackSelectionParameters.f5514e;
            this.f5538f = trackSelectionParameters.f5515f;
            this.f5539g = trackSelectionParameters.f5516g;
            this.f5540h = trackSelectionParameters.f5517h;
            this.f5541i = trackSelectionParameters.f5518i;
            this.f5542j = trackSelectionParameters.f5519j;
            this.f5543k = trackSelectionParameters.f5520k;
            this.f5544l = trackSelectionParameters.f5521l;
            this.f5545m = trackSelectionParameters.f5522m;
            this.n = trackSelectionParameters.n;
            this.o = trackSelectionParameters.o;
            this.p = trackSelectionParameters.p;
            this.q = trackSelectionParameters.q;
            this.r = trackSelectionParameters.r;
            this.s = trackSelectionParameters.s;
            this.t = trackSelectionParameters.t;
            this.u = trackSelectionParameters.u;
            this.v = trackSelectionParameters.v;
            this.w = trackSelectionParameters.w;
            this.x = trackSelectionParameters.x;
            this.y = trackSelectionParameters.y;
            this.z = trackSelectionParameters.z;
            this.B = new HashSet(trackSelectionParameters.B);
            this.A = new HashMap(trackSelectionParameters.A);
        }

        public Builder g() {
            this.v = -3;
            return this;
        }

        public Builder h(TrackSelectionOverride trackSelectionOverride) {
            TrackGroup trackGroup = trackSelectionOverride.f5508a;
            d(trackGroup.f5503c);
            this.A.put(trackGroup, trackSelectionOverride);
            return this;
        }

        public Builder i(int i2) {
            this.B.remove(Integer.valueOf(i2));
            return this;
        }

        public Builder j(int i2, int i3) {
            this.f5541i = i2;
            this.f5542j = i3;
            this.f5543k = true;
            return this;
        }
    }

    static {
        int i2 = Util.f5744a;
        D = Integer.toString(1, 36);
        E = Integer.toString(2, 36);
        F = Integer.toString(3, 36);
        G = Integer.toString(4, 36);
        H = Integer.toString(5, 36);
        I = Integer.toString(6, 36);
        J = Integer.toString(7, 36);
        K = Integer.toString(8, 36);
        L = Integer.toString(9, 36);
        M = Integer.toString(10, 36);
        N = Integer.toString(11, 36);
        O = Integer.toString(12, 36);
        P = Integer.toString(13, 36);
        Q = Integer.toString(14, 36);
        R = Integer.toString(15, 36);
        S = Integer.toString(16, 36);
        T = Integer.toString(17, 36);
        U = Integer.toString(18, 36);
        V = Integer.toString(19, 36);
        W = Integer.toString(20, 36);
        X = Integer.toString(21, 36);
        Y = Integer.toString(22, 36);
        Z = Integer.toString(23, 36);
        a0 = Integer.toString(24, 36);
        b0 = Integer.toString(25, 36);
        c0 = Integer.toString(26, 36);
        d0 = Integer.toString(27, 36);
        e0 = Integer.toString(28, 36);
        f0 = Integer.toString(29, 36);
        g0 = Integer.toString(30, 36);
        h0 = Integer.toString(31, 36);
    }

    public TrackSelectionParameters(Builder builder) {
        this.f5510a = builder.f5533a;
        this.f5511b = builder.f5534b;
        this.f5512c = builder.f5535c;
        this.f5513d = builder.f5536d;
        this.f5514e = builder.f5537e;
        this.f5515f = builder.f5538f;
        this.f5516g = builder.f5539g;
        this.f5517h = builder.f5540h;
        this.f5518i = builder.f5541i;
        this.f5519j = builder.f5542j;
        this.f5520k = builder.f5543k;
        this.f5521l = builder.f5544l;
        this.f5522m = builder.f5545m;
        this.n = builder.n;
        this.o = builder.o;
        this.p = builder.p;
        this.q = builder.q;
        this.r = builder.r;
        this.s = builder.s;
        this.t = builder.t;
        this.u = builder.u;
        this.v = builder.v;
        this.w = builder.w;
        this.x = builder.x;
        this.y = builder.y;
        this.z = builder.z;
        this.A = ImmutableMap.a(builder.A);
        this.B = ImmutableSet.o(builder.B);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static TrackSelectionParameters b(Bundle bundle) {
        AudioOffloadPreferences audioOffloadPreferences;
        ImmutableList immutableListJ;
        Builder builder = new Builder();
        TrackSelectionParameters trackSelectionParameters = C;
        builder.f5533a = bundle.getInt(I, trackSelectionParameters.f5510a);
        builder.f5534b = bundle.getInt(J, trackSelectionParameters.f5511b);
        builder.f5535c = bundle.getInt(K, trackSelectionParameters.f5512c);
        builder.f5536d = bundle.getInt(L, trackSelectionParameters.f5513d);
        builder.f5537e = bundle.getInt(M, trackSelectionParameters.f5514e);
        builder.f5538f = bundle.getInt(N, trackSelectionParameters.f5515f);
        builder.f5539g = bundle.getInt(O, trackSelectionParameters.f5516g);
        builder.f5540h = bundle.getInt(P, trackSelectionParameters.f5517h);
        builder.f5541i = bundle.getInt(Q, trackSelectionParameters.f5518i);
        builder.f5542j = bundle.getInt(R, trackSelectionParameters.f5519j);
        builder.f5543k = bundle.getBoolean(S, trackSelectionParameters.f5520k);
        builder.f5544l = ImmutableList.p((String[]) MoreObjects.a(bundle.getStringArray(T), new String[0]));
        builder.f5545m = bundle.getInt(b0, trackSelectionParameters.f5522m);
        builder.n = Builder.f((String[]) MoreObjects.a(bundle.getStringArray(D), new String[0]));
        builder.o = bundle.getInt(E, trackSelectionParameters.o);
        builder.p = bundle.getInt(U, trackSelectionParameters.p);
        builder.q = bundle.getInt(V, trackSelectionParameters.q);
        builder.r = ImmutableList.p((String[]) MoreObjects.a(bundle.getStringArray(W), new String[0]));
        Bundle bundle2 = bundle.getBundle(g0);
        if (bundle2 != null) {
            AudioOffloadPreferences audioOffloadPreferences2 = AudioOffloadPreferences.f5523d;
            AudioOffloadPreferences.Builder builder2 = new AudioOffloadPreferences.Builder();
            AudioOffloadPreferences audioOffloadPreferences3 = AudioOffloadPreferences.f5523d;
            builder2.f5530a = bundle2.getInt(AudioOffloadPreferences.f5524e, audioOffloadPreferences3.f5527a);
            builder2.f5531b = bundle2.getBoolean(AudioOffloadPreferences.f5525f, audioOffloadPreferences3.f5528b);
            builder2.f5532c = bundle2.getBoolean(AudioOffloadPreferences.f5526g, audioOffloadPreferences3.f5529c);
            audioOffloadPreferences = new AudioOffloadPreferences(builder2);
        } else {
            AudioOffloadPreferences.Builder builder3 = new AudioOffloadPreferences.Builder();
            AudioOffloadPreferences audioOffloadPreferences4 = AudioOffloadPreferences.f5523d;
            builder3.f5530a = bundle.getInt(d0, audioOffloadPreferences4.f5527a);
            builder3.f5531b = bundle.getBoolean(e0, audioOffloadPreferences4.f5528b);
            builder3.f5532c = bundle.getBoolean(f0, audioOffloadPreferences4.f5529c);
            audioOffloadPreferences = new AudioOffloadPreferences(builder3);
        }
        builder.s = audioOffloadPreferences;
        builder.t = Builder.f((String[]) MoreObjects.a(bundle.getStringArray(F), new String[0]));
        builder.u = bundle.getInt(G, trackSelectionParameters.u);
        builder.v = bundle.getInt(c0, trackSelectionParameters.v);
        builder.w = bundle.getBoolean(H, trackSelectionParameters.w);
        builder.x = bundle.getBoolean(h0, trackSelectionParameters.x);
        builder.y = bundle.getBoolean(X, trackSelectionParameters.y);
        builder.z = bundle.getBoolean(Y, trackSelectionParameters.z);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(Z);
        if (parcelableArrayList == null) {
            immutableListJ = ImmutableList.r();
        } else {
            ImmutableList.Builder builder4 = new ImmutableList.Builder();
            for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
                Bundle bundle3 = (Bundle) parcelableArrayList.get(i2);
                bundle3.getClass();
                Bundle bundle4 = bundle3.getBundle(TrackSelectionOverride.f5506c);
                bundle4.getClass();
                TrackGroup trackGroupA = TrackGroup.a(bundle4);
                int[] intArray = bundle3.getIntArray(TrackSelectionOverride.f5507d);
                intArray.getClass();
                builder4.h(new TrackSelectionOverride(trackGroupA, Ints.a(intArray)));
            }
            immutableListJ = builder4.j();
        }
        builder.A = new HashMap();
        for (int i3 = 0; i3 < immutableListJ.size(); i3++) {
            TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) immutableListJ.get(i3);
            builder.A.put(trackSelectionOverride.f5508a, trackSelectionOverride);
        }
        int[] iArr = (int[]) MoreObjects.a(bundle.getIntArray(a0), new int[0]);
        builder.B = new HashSet();
        for (int i4 : iArr) {
            builder.B.add(Integer.valueOf(i4));
        }
        return new TrackSelectionParameters(builder);
    }

    public Builder a() {
        Builder builder = new Builder();
        builder.e(this);
        return builder;
    }

    public Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt(I, this.f5510a);
        bundle.putInt(J, this.f5511b);
        bundle.putInt(K, this.f5512c);
        bundle.putInt(L, this.f5513d);
        bundle.putInt(M, this.f5514e);
        bundle.putInt(N, this.f5515f);
        bundle.putInt(O, this.f5516g);
        bundle.putInt(P, this.f5517h);
        bundle.putInt(Q, this.f5518i);
        bundle.putInt(R, this.f5519j);
        bundle.putBoolean(S, this.f5520k);
        bundle.putStringArray(T, (String[]) this.f5521l.toArray(new String[0]));
        bundle.putInt(b0, this.f5522m);
        bundle.putStringArray(D, (String[]) this.n.toArray(new String[0]));
        bundle.putInt(E, this.o);
        bundle.putInt(U, this.p);
        bundle.putInt(V, this.q);
        bundle.putStringArray(W, (String[]) this.r.toArray(new String[0]));
        bundle.putStringArray(F, (String[]) this.t.toArray(new String[0]));
        bundle.putInt(G, this.u);
        bundle.putInt(c0, this.v);
        bundle.putBoolean(H, this.w);
        AudioOffloadPreferences audioOffloadPreferences = this.s;
        bundle.putInt(d0, audioOffloadPreferences.f5527a);
        bundle.putBoolean(e0, audioOffloadPreferences.f5528b);
        bundle.putBoolean(f0, audioOffloadPreferences.f5529c);
        audioOffloadPreferences.getClass();
        Bundle bundle2 = new Bundle();
        bundle2.putInt(AudioOffloadPreferences.f5524e, audioOffloadPreferences.f5527a);
        bundle2.putBoolean(AudioOffloadPreferences.f5525f, audioOffloadPreferences.f5528b);
        bundle2.putBoolean(AudioOffloadPreferences.f5526g, audioOffloadPreferences.f5529c);
        bundle.putBundle(g0, bundle2);
        bundle.putBoolean(h0, this.x);
        bundle.putBoolean(X, this.y);
        bundle.putBoolean(Y, this.z);
        ImmutableCollection<TrackSelectionOverride> immutableCollectionValues = this.A.values();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(immutableCollectionValues.size());
        for (TrackSelectionOverride trackSelectionOverride : immutableCollectionValues) {
            trackSelectionOverride.getClass();
            Bundle bundle3 = new Bundle();
            bundle3.putBundle(TrackSelectionOverride.f5506c, trackSelectionOverride.f5508a.e());
            bundle3.putIntArray(TrackSelectionOverride.f5507d, Ints.g(trackSelectionOverride.f5509b));
            arrayList.add(bundle3);
        }
        bundle.putParcelableArrayList(Z, arrayList);
        bundle.putIntArray(a0, Ints.g(this.B));
        return bundle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
            if (this.f5510a == trackSelectionParameters.f5510a && this.f5511b == trackSelectionParameters.f5511b && this.f5512c == trackSelectionParameters.f5512c && this.f5513d == trackSelectionParameters.f5513d && this.f5514e == trackSelectionParameters.f5514e && this.f5515f == trackSelectionParameters.f5515f && this.f5516g == trackSelectionParameters.f5516g && this.f5517h == trackSelectionParameters.f5517h && this.f5520k == trackSelectionParameters.f5520k && this.f5518i == trackSelectionParameters.f5518i && this.f5519j == trackSelectionParameters.f5519j && this.f5521l.equals(trackSelectionParameters.f5521l) && this.f5522m == trackSelectionParameters.f5522m && this.n.equals(trackSelectionParameters.n) && this.o == trackSelectionParameters.o && this.p == trackSelectionParameters.p && this.q == trackSelectionParameters.q && this.r.equals(trackSelectionParameters.r) && this.s.equals(trackSelectionParameters.s) && this.t.equals(trackSelectionParameters.t) && this.u == trackSelectionParameters.u && this.v == trackSelectionParameters.v && this.w == trackSelectionParameters.w && this.x == trackSelectionParameters.x && this.y == trackSelectionParameters.y && this.z == trackSelectionParameters.z && this.A.equals(trackSelectionParameters.A) && this.B.equals(trackSelectionParameters.B)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.B.hashCode() + ((this.A.hashCode() + ((((((((((((((this.t.hashCode() + ((this.s.hashCode() + ((this.r.hashCode() + ((((((((this.n.hashCode() + ((((this.f5521l.hashCode() + ((((((((((((((((((((((this.f5510a + 31) * 31) + this.f5511b) * 31) + this.f5512c) * 31) + this.f5513d) * 31) + this.f5514e) * 31) + this.f5515f) * 31) + this.f5516g) * 31) + this.f5517h) * 31) + (this.f5520k ? 1 : 0)) * 31) + this.f5518i) * 31) + this.f5519j) * 31)) * 31) + this.f5522m) * 31)) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31)) * 31)) * 31)) * 31) + this.u) * 31) + this.v) * 31) + (this.w ? 1 : 0)) * 31) + (this.x ? 1 : 0)) * 31) + (this.y ? 1 : 0)) * 31) + (this.z ? 1 : 0)) * 31)) * 31);
    }
}
