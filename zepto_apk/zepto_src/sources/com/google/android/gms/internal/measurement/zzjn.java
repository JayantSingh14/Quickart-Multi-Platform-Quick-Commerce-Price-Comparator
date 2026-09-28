package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.support.v4.media.b;
import com.google.common.base.Supplier;

/* loaded from: classes.dex */
final class zzjn extends zzkg {

    /* renamed from: a, reason: collision with root package name */
    public final Context f37000a;

    /* renamed from: b, reason: collision with root package name */
    public final Supplier f37001b;

    public zzjn(Context context, Supplier supplier) {
        this.f37000a = context;
        this.f37001b = supplier;
    }

    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Context a() {
        return this.f37000a;
    }

    @Override // com.google.android.gms.internal.measurement.zzkg
    public final Supplier b() {
        return this.f37001b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkg)) {
            return false;
        }
        zzkg zzkgVar = (zzkg) obj;
        if (!this.f37000a.equals(zzkgVar.a())) {
            return false;
        }
        Supplier supplier = this.f37001b;
        return supplier == null ? zzkgVar.b() == null : supplier.equals(zzkgVar.b());
    }

    public final int hashCode() {
        int iHashCode = this.f37000a.hashCode() ^ 1000003;
        Supplier supplier = this.f37001b;
        return (iHashCode * 1000003) ^ (supplier == null ? 0 : supplier.hashCode());
    }

    public final String toString() {
        String string = this.f37000a.toString();
        int length = string.length();
        String strValueOf = String.valueOf(this.f37001b);
        StringBuilder sb = new StringBuilder(length + 45 + strValueOf.length() + 1);
        b.B(sb, "FlagsContext{context=", string, ", hermeticFileOverrides=", strValueOf);
        sb.append("}");
        return sb.toString();
    }
}
