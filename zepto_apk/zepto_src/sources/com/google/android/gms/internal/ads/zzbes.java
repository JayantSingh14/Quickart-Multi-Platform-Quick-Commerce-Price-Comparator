package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "CacheEntryParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class zzbes extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbes> CREATOR = new zzbet();

    /* renamed from: a, reason: collision with root package name */
    public ParcelFileDescriptor f24852a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f24853b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f24854c;

    /* renamed from: d, reason: collision with root package name */
    public final long f24855d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f24856e;

    public zzbes() {
        this(null, false, false, 0L, false);
    }

    public final synchronized ParcelFileDescriptor.AutoCloseInputStream b() {
        if (this.f24852a == null) {
            return null;
        }
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.f24852a);
        this.f24852a = null;
        return autoCloseInputStream;
    }

    public final synchronized boolean r() {
        return this.f24854c;
    }

    public final synchronized boolean s() {
        return this.f24856e;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        ParcelFileDescriptor parcelFileDescriptor;
        boolean z;
        long j2;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        synchronized (this) {
            parcelFileDescriptor = this.f24852a;
        }
        SafeParcelWriter.writeParcelable(parcel, 2, parcelFileDescriptor, i2, false);
        synchronized (this) {
            z = this.f24853b;
        }
        SafeParcelWriter.writeBoolean(parcel, 3, z);
        SafeParcelWriter.writeBoolean(parcel, 4, r());
        synchronized (this) {
            j2 = this.f24855d;
        }
        SafeParcelWriter.writeLong(parcel, 5, j2);
        SafeParcelWriter.writeBoolean(parcel, 6, s());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final synchronized boolean zza() {
        return this.f24852a != null;
    }

    public zzbes(ParcelFileDescriptor parcelFileDescriptor, boolean z, boolean z2, long j2, boolean z3) {
        this.f24852a = parcelFileDescriptor;
        this.f24853b = z;
        this.f24854c = z2;
        this.f24855d = j2;
        this.f24856e = z3;
    }
}
