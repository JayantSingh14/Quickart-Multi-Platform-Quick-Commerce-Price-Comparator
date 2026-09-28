package com.brentvatne.common.api;

import android.net.Uri;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

@kotlin.Metadata
/* loaded from: classes3.dex */
public final class Source {

    /* renamed from: a, reason: collision with root package name */
    public String f15391a;

    /* renamed from: b, reason: collision with root package name */
    public Uri f15392b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15393c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15394d;

    /* renamed from: i, reason: collision with root package name */
    public String f15399i;

    /* renamed from: j, reason: collision with root package name */
    public Metadata f15400j;

    /* renamed from: m, reason: collision with root package name */
    public DRMProps f15403m;
    public boolean n;
    public CMCDProps o;
    public AdsProps p;
    public SideLoadedTextTrackList r;

    /* renamed from: e, reason: collision with root package name */
    public int f15395e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f15396f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f15397g = -1;

    /* renamed from: h, reason: collision with root package name */
    public int f15398h = -1;

    /* renamed from: k, reason: collision with root package name */
    public int f15401k = 3;

    /* renamed from: l, reason: collision with root package name */
    public final HashMap f15402l = new HashMap();
    public BufferConfig q = new BufferConfig();

    @kotlin.Metadata
    public static final class Companion {
        /* JADX WARN: Removed duplicated region for block: B:103:0x0370  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0171  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x017d  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x017f  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x01c1  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x01f8  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x01fa  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0265  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x0303  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0310  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x0338  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static com.brentvatne.common.api.Source a(android.content.Context r19, com.facebook.react.bridge.ReadableMap r20) {
            /*
                Method dump skipped, instructions count: 903
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.brentvatne.common.api.Source.Companion.a(android.content.Context, com.facebook.react.bridge.ReadableMap):com.brentvatne.common.api.Source");
        }
    }

    @kotlin.Metadata
    public static final class Metadata {

        /* renamed from: a, reason: collision with root package name */
        public String f15404a;

        /* renamed from: b, reason: collision with root package name */
        public String f15405b;

        /* renamed from: c, reason: collision with root package name */
        public String f15406c;

        /* renamed from: d, reason: collision with root package name */
        public String f15407d;

        /* renamed from: e, reason: collision with root package name */
        public Uri f15408e;

        @kotlin.Metadata
        public static final class Companion {
        }
    }

    public final AdsProps a() {
        return this.p;
    }

    public final BufferConfig b() {
        return this.q;
    }

    public final CMCDProps c() {
        return this.o;
    }

    public final int d() {
        return this.f15398h;
    }

    public final int e() {
        return this.f15397g;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof Source)) {
            Source source = (Source) obj;
            if (Intrinsics.b(this.f15392b, source.f15392b) && this.f15396f == source.f15396f && this.f15397g == source.f15397g && this.f15395e == source.f15395e && Intrinsics.b(this.f15399i, source.f15399i) && Intrinsics.b(this.f15403m, source.f15403m) && this.f15398h == source.f15398h && Intrinsics.b(this.o, source.o) && Intrinsics.b(this.r, source.r) && Intrinsics.b(this.p, source.p) && this.f15401k == source.f15401k && this.f15393c == source.f15393c && this.f15394d == source.f15394d && Intrinsics.b(this.q, source.q)) {
                return true;
            }
        }
        return false;
    }

    public final int f() {
        return this.f15396f;
    }

    public final DRMProps g() {
        return this.f15403m;
    }

    public final String h() {
        return this.f15399i;
    }

    public final int hashCode() {
        return Objects.hash(this.f15391a, this.f15392b, Integer.valueOf(this.f15395e), Integer.valueOf(this.f15396f), Integer.valueOf(this.f15397g), this.f15399i, this.f15400j, this.f15402l);
    }

    public final HashMap i() {
        return this.f15402l;
    }

    public final Metadata j() {
        return this.f15400j;
    }

    public final int k() {
        return this.f15401k;
    }

    public final SideLoadedTextTrackList l() {
        return this.r;
    }

    public final int m() {
        return this.f15395e;
    }

    public final boolean n() {
        return this.n;
    }

    public final Uri o() {
        return this.f15392b;
    }

    public final boolean p(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return equals(source);
    }
}
