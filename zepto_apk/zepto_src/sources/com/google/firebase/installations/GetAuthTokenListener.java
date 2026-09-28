package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.AutoValue_InstallationTokenResult;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;

/* loaded from: classes.dex */
class GetAuthTokenListener implements StateListener {

    /* renamed from: a, reason: collision with root package name */
    public final Utils f44585a;

    /* renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f44586b;

    public GetAuthTokenListener(Utils utils, TaskCompletionSource taskCompletionSource) {
        this.f44585a = utils;
        this.f44586b = taskCompletionSource;
    }

    @Override // com.google.firebase.installations.StateListener
    public final boolean a(Exception exc) {
        this.f44586b.c(exc);
        return true;
    }

    @Override // com.google.firebase.installations.StateListener
    public final boolean b(PersistedInstallationEntry persistedInstallationEntry) {
        if (persistedInstallationEntry.f() != PersistedInstallation.RegistrationStatus.f44619d || this.f44585a.a(persistedInstallationEntry)) {
            return false;
        }
        AutoValue_InstallationTokenResult.Builder builder = new AutoValue_InstallationTokenResult.Builder();
        String strA = persistedInstallationEntry.a();
        if (strA == null) {
            throw new NullPointerException("Null token");
        }
        builder.f44563a = strA;
        builder.f44564b = Long.valueOf(persistedInstallationEntry.b());
        builder.f44565c = Long.valueOf(persistedInstallationEntry.g());
        String strK = builder.f44563a == null ? " token" : "";
        if (builder.f44564b == null) {
            strK = strK.concat(" tokenExpirationTimestamp");
        }
        if (builder.f44565c == null) {
            strK = android.support.v4.media.b.k(strK, " tokenCreationTimestamp");
        }
        if (!strK.isEmpty()) {
            throw new IllegalStateException("Missing required properties:".concat(strK));
        }
        this.f44586b.b(new AutoValue_InstallationTokenResult(builder.f44564b.longValue(), builder.f44565c.longValue(), builder.f44563a));
        return true;
    }
}
