package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zza extends com.google.android.gms.internal.auth.zzb implements zzb {
    public zza() {
        super("com.google.android.gms.auth.account.IWorkAccountCallback");
    }

    @Override // com.google.android.gms.internal.auth.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            Account account = (Account) com.google.android.gms.internal.auth.zzc.a(parcel, Account.CREATOR);
            com.google.android.gms.internal.auth.zzc.b(parcel);
            X5(account);
            return true;
        }
        if (i2 != 2) {
            return false;
        }
        int i3 = com.google.android.gms.internal.auth.zzc.f36312a;
        int i4 = parcel.readInt();
        com.google.android.gms.internal.auth.zzc.b(parcel);
        zzc(i4 != 0);
        return true;
    }
}
