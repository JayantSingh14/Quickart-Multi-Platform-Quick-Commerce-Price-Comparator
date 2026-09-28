package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.AccountType;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AccountChangeEventsRequestCreator")
/* loaded from: classes4.dex */
public class AccountChangeEventsRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    public final int f22008a;

    /* renamed from: b, reason: collision with root package name */
    public final int f22009b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22010c;

    /* renamed from: d, reason: collision with root package name */
    public final Account f22011d;

    public AccountChangeEventsRequest() {
        this.f22008a = 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22008a);
        SafeParcelWriter.writeInt(parcel, 2, this.f22009b);
        SafeParcelWriter.writeString(parcel, 3, this.f22010c, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f22011d, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public AccountChangeEventsRequest(int i2, int i3, String str, Account account) {
        this.f22008a = i2;
        this.f22009b = i3;
        this.f22010c = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.f22011d = account;
        } else {
            this.f22011d = new Account(str, AccountType.GOOGLE);
        }
    }
}
