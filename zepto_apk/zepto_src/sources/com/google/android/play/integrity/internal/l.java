package com.google.android.play.integrity.internal;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes4.dex */
public final class l extends a implements n {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.play.integrity.internal.n
    public final void U1(Bundle bundle, p pVar) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f42151b);
        int i2 = c.f42189a;
        parcelObtain.writeInt(1);
        bundle.writeToParcel(parcelObtain, 0);
        parcelObtain.writeStrongBinder(pVar);
        g(2, parcelObtain);
    }
}
