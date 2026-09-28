package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassResponseParcelCreator")
/* loaded from: classes4.dex */
public final class zzfvk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfvk> CREATOR = new zzfvl();

    /* renamed from: a, reason: collision with root package name */
    public final int f31924a;

    /* renamed from: b, reason: collision with root package name */
    public zzawp f31925b = null;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f31926c;

    public zzfvk(int i2, byte[] bArr) {
        this.f31924a = i2;
        this.f31926c = bArr;
        zzb();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f31924a);
        byte[] bArrG = this.f31926c;
        if (bArrG == null) {
            bArrG = this.f31925b.g();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArrG, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final void zzb() {
        zzawp zzawpVar = this.f31925b;
        if (zzawpVar != null || this.f31926c == null) {
            if (zzawpVar == null || this.f31926c != null) {
                if (zzawpVar != null && this.f31926c != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
                if (zzawpVar != null || this.f31926c != null) {
                    throw new IllegalStateException("Impossible");
                }
                throw new IllegalStateException("Invalid internal representation - empty");
            }
        }
    }
}
