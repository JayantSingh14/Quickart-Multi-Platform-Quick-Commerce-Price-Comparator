package com.google.android.gms.internal.pal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassResponseParcelCreator")
/* loaded from: classes4.dex */
public final class zzhk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzhk> CREATOR = new zzhl();

    /* renamed from: a, reason: collision with root package name */
    public final int f37796a;

    /* renamed from: b, reason: collision with root package name */
    public zzaf f37797b = null;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f37798c;

    public zzhk(int i2, byte[] bArr) {
        this.f37796a = i2;
        this.f37798c = bArr;
        b();
    }

    public final void b() {
        zzaf zzafVar = this.f37797b;
        if (zzafVar != null || this.f37798c == null) {
            if (zzafVar == null || this.f37798c != null) {
                if (zzafVar != null && this.f37798c != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
                if (zzafVar != null || this.f37798c != null) {
                    throw new IllegalStateException("Impossible");
                }
                throw new IllegalStateException("Invalid internal representation - empty");
            }
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f37796a);
        byte[] bArrF = this.f37798c;
        if (bArrF == null) {
            bArrF = this.f37797b.F();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArrF, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
