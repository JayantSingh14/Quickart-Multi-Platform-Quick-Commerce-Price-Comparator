package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
final class zzkz extends zzks {

    /* renamed from: a, reason: collision with root package name */
    public final String f37906a;

    /* renamed from: b, reason: collision with root package name */
    public final int f37907b;

    public /* synthetic */ zzkz(String str, int i2) {
        this.f37906a = str;
        this.f37907b = i2;
    }

    public final String toString() {
        int i2 = this.f37907b - 2;
        return android.support.v4.media.a.n(new StringBuilder("(typeUrl="), this.f37906a, ", outputPrefixType=", i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "UNKNOWN" : "CRUNCHY" : "RAW" : "LEGACY" : "TINK", ")");
    }
}
