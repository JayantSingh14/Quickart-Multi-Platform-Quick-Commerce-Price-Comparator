package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@SafeParcelable.Class(creator = "EventParamsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzbe extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzbe> CREATOR = new zzbf();

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f38768a;

    public zzbe(Bundle bundle) {
        this.f38768a = bundle;
    }

    public final Bundle A() {
        return new Bundle(this.f38768a);
    }

    public final Object b(String str) {
        return this.f38768a.get(str);
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzbd(this);
    }

    public final Double r() {
        return Double.valueOf(this.f38768a.getDouble(CLConstants.FIELD_PAY_INFO_VALUE));
    }

    public final String s() {
        return this.f38768a.getString("currency");
    }

    public final String toString() {
        return this.f38768a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, A(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
