package com.zeptoconsumerapp.AutoLogin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Keep;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata
/* loaded from: classes4.dex */
public final class SharedAuthenticatorService extends Service {

    @NotNull
    private final Lazy authenticator$delegate = LazyKt.b(new coil3.decode.a(this, 8));

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedAccountAuthenticator authenticator_delegate$lambda$0(SharedAuthenticatorService sharedAuthenticatorService) {
        return new SharedAccountAuthenticator(sharedAuthenticatorService);
    }

    private final SharedAccountAuthenticator getAuthenticator() {
        return (SharedAccountAuthenticator) this.authenticator$delegate.getValue();
    }

    @Override // android.app.Service
    public IBinder onBind(@Nullable Intent intent) {
        return getAuthenticator().getIBinder();
    }
}
