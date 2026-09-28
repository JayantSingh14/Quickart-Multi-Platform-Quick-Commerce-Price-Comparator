package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AccountType;

/* loaded from: classes4.dex */
final class zzai implements WorkAccountApi.AddAccountResult {

    /* renamed from: c, reason: collision with root package name */
    public static final Account f36282c = new Account("DUMMY_NAME", AccountType.GOOGLE);

    /* renamed from: a, reason: collision with root package name */
    public final Status f36283a;

    /* renamed from: b, reason: collision with root package name */
    public final Account f36284b;

    public zzai(Status status, Account account) {
        this.f36283a = status;
        this.f36284b = account == null ? f36282c : account;
    }

    @Override // com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult
    public final Account getAccount() {
        return this.f36284b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f36283a;
    }
}
