package com.google.firebase.installations;

import com.google.firebase.installations.local.PersistedInstallationEntry;

/* loaded from: classes.dex */
interface StateListener {
    boolean a(Exception exc);

    boolean b(PersistedInstallationEntry persistedInstallationEntry);
}
