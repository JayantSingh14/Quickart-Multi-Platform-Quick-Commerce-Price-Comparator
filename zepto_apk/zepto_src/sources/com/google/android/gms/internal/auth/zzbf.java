package com.google.android.gms.internal.auth;

import android.os.Parcel;
import com.google.android.gms.auth.api.proxy.ProxyResponse;

/* loaded from: classes4.dex */
public abstract class zzbf extends zzb implements zzbg {
    public zzbf() {
        super("com.google.android.gms.auth.api.internal.IAuthCallbacks");
    }

    @Override // com.google.android.gms.internal.auth.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            ProxyResponse proxyResponse = (ProxyResponse) zzc.a(parcel, ProxyResponse.CREATOR);
            zzc.b(parcel);
            x1(proxyResponse);
        } else {
            if (i2 != 2) {
                return false;
            }
            String string = parcel.readString();
            zzc.b(parcel);
            o(string);
        }
        parcel2.writeNoException();
        return true;
    }
}
