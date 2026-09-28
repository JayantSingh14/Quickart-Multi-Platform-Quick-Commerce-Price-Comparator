package com.google.android.play.integrity.internal;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes4.dex */
public final class g extends a implements i {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.play.integrity.internal.i
    public final void ka(Bundle bundle, k kVar) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f42151b);
        int i2 = c.f42189a;
        parcelObtain.writeInt(1);
        bundle.writeToParcel(parcelObtain, 0);
        parcelObtain.writeStrongBinder(kVar);
        g(3, parcelObtain);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.play.integrity.internal.i
    public final void w9(Bundle bundle, k kVar) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f42151b);
        int i2 = c.f42189a;
        parcelObtain.writeInt(1);
        bundle.writeToParcel(parcelObtain, 0);
        parcelObtain.writeStrongBinder(kVar);
        g(2, parcelObtain);
    }
}
