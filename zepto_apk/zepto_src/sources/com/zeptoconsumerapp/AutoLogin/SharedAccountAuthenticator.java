package com.zeptoconsumerapp.AutoLogin;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import bridges.CommsModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata
/* loaded from: classes4.dex */
public final class SharedAccountAuthenticator extends AbstractAccountAuthenticator {

    @NotNull
    private static final String ACCOUNT_TYPE = "com.zepto.shared_account";

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private final Context context;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedAccountAuthenticator(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    @Keep
    @NotNull
    public Bundle addAccount(@Nullable AccountAuthenticatorResponse accountAuthenticatorResponse, @Nullable String str, @Nullable String str2, @Nullable String[] strArr, @Nullable Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("authAccount", CommsModule.SHARED_PREFERENCE_NAME);
        bundle2.putString("accountType", ACCOUNT_TYPE);
        return bundle2;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    @Nullable
    public Bundle confirmCredentials(@Nullable AccountAuthenticatorResponse accountAuthenticatorResponse, @Nullable Account account, @Nullable Bundle bundle) {
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    @Keep
    @NotNull
    public Bundle editProperties(@Nullable AccountAuthenticatorResponse accountAuthenticatorResponse, @Nullable String str) {
        throw new UnsupportedOperationException();
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    @NotNull
    public Bundle getAuthToken(@Nullable AccountAuthenticatorResponse accountAuthenticatorResponse, @Nullable Account account, @Nullable String str, @Nullable Bundle bundle) throws NetworkErrorException {
        throw new NetworkErrorException("Not implemented");
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    @Nullable
    public String getAuthTokenLabel(@Nullable String str) {
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    @NotNull
    public Bundle hasFeatures(@Nullable AccountAuthenticatorResponse accountAuthenticatorResponse, @Nullable Account account, @Nullable String[] strArr) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("booleanResult", false);
        return bundle;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    @NotNull
    public Bundle updateCredentials(@Nullable AccountAuthenticatorResponse accountAuthenticatorResponse, @Nullable Account account, @Nullable String str, @Nullable Bundle bundle) {
        throw new UnsupportedOperationException();
    }
}
