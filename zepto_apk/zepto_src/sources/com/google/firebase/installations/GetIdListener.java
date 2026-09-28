package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;

/* loaded from: classes.dex */
class GetIdListener implements StateListener {

    /* renamed from: a, reason: collision with root package name */
    public final TaskCompletionSource f44587a;

    public GetIdListener(TaskCompletionSource taskCompletionSource) {
        this.f44587a = taskCompletionSource;
    }

    @Override // com.google.firebase.installations.StateListener
    public final boolean a(Exception exc) {
        return false;
    }

    @Override // com.google.firebase.installations.StateListener
    public final boolean b(PersistedInstallationEntry persistedInstallationEntry) {
        if (persistedInstallationEntry.f() != PersistedInstallation.RegistrationStatus.f44618c && persistedInstallationEntry.f() != PersistedInstallation.RegistrationStatus.f44619d && persistedInstallationEntry.f() != PersistedInstallation.RegistrationStatus.f44620e) {
            return false;
        }
        this.f44587a.d(persistedInstallationEntry.c());
        return true;
    }
}
