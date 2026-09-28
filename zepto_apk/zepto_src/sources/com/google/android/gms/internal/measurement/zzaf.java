package com.google.android.gms.internal.measurement;

import androidx.fragment.app.e;
import java.util.ArrayList;
import java.util.Iterator;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzaf implements zzao {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f36758a;

    public zzaf(Boolean bool) {
        this.f36758a = bool == null ? false : bool.booleanValue();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzaf) && this.f36758a == ((zzaf) obj).f36758a;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao f() {
        return new zzaf(Boolean.valueOf(this.f36758a));
    }

    public final int hashCode() {
        return Boolean.valueOf(this.f36758a).hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao i(String str, zzg zzgVar, ArrayList arrayList) {
        boolean zEquals = "toString".equals(str);
        boolean z = this.f36758a;
        if (zEquals) {
            return new zzas(Boolean.toString(z));
        }
        throw new IllegalArgumentException(e.D(Boolean.toString(z), CLConstants.DOT_SALT_DELIMETER, str, " is not a function."));
    }

    public final String toString() {
        return String.valueOf(this.f36758a);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        return Boolean.toString(this.f36758a);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        return Double.valueOf(true != this.f36758a ? 0.0d : 1.0d);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        return Boolean.valueOf(this.f36758a);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return null;
    }
}
