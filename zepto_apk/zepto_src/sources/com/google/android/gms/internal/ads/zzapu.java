package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzapu {

    /* renamed from: a, reason: collision with root package name */
    public final String f24108a;

    /* renamed from: b, reason: collision with root package name */
    public final int f24109b;

    /* renamed from: c, reason: collision with root package name */
    public final int f24110c;

    /* renamed from: d, reason: collision with root package name */
    public int f24111d;

    /* renamed from: e, reason: collision with root package name */
    public String f24112e;

    public zzapu(int i2, int i3, int i4) {
        this.f24108a = i2 != Integer.MIN_VALUE ? android.support.v4.media.b.o(new StringBuilder(String.valueOf(i2).length() + 1), i2, "/") : "";
        this.f24109b = i3;
        this.f24110c = i4;
        this.f24111d = Integer.MIN_VALUE;
        this.f24112e = "";
    }

    public final void a() {
        int i2 = this.f24111d;
        int i3 = i2 == Integer.MIN_VALUE ? this.f24109b : i2 + this.f24110c;
        this.f24111d = i3;
        int length = String.valueOf(i3).length();
        String str = this.f24108a;
        this.f24112e = androidx.fragment.app.e.r(new StringBuilder(str.length() + length), i3, str);
    }

    public final void b() {
        if (this.f24111d == Integer.MIN_VALUE) {
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }
    }
}
