package com.google.firebase.installations;

import android.text.TextUtils;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.internal.FidListener;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import java.io.IOException;
import java.util.Iterator;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f44595a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FirebaseInstallations f44596b;

    public /* synthetic */ b(FirebaseInstallations firebaseInstallations, int i2) {
        this.f44595a = i2;
        this.f44596b = firebaseInstallations;
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public final void run() {
        PersistedInstallationEntry persistedInstallationEntryC;
        PersistedInstallationEntry persistedInstallationEntryF;
        switch (this.f44595a) {
            case 0:
                FirebaseInstallations firebaseInstallations = this.f44596b;
                Object obj = FirebaseInstallations.f44568m;
                firebaseInstallations.getClass();
                Object obj2 = FirebaseInstallations.f44568m;
                synchronized (obj2) {
                    try {
                        FirebaseApp firebaseApp = firebaseInstallations.f44569a;
                        firebaseApp.a();
                        CrossProcessLock crossProcessLockA = CrossProcessLock.a(firebaseApp.f43489a);
                        try {
                            persistedInstallationEntryC = firebaseInstallations.f44571c.c();
                            if (crossProcessLockA != null) {
                                crossProcessLockA.b();
                            }
                        } catch (Throwable th) {
                            if (crossProcessLockA != null) {
                                crossProcessLockA.b();
                            }
                            throw th;
                        }
                    } finally {
                    }
                }
                try {
                    if (persistedInstallationEntryC.f() == PersistedInstallation.RegistrationStatus.f44620e) {
                        persistedInstallationEntryF = firebaseInstallations.f(persistedInstallationEntryC);
                    } else {
                        if (persistedInstallationEntryC.f() == PersistedInstallation.RegistrationStatus.f44618c) {
                            persistedInstallationEntryF = firebaseInstallations.f(persistedInstallationEntryC);
                        } else if (!firebaseInstallations.f44572d.a(persistedInstallationEntryC)) {
                            return;
                        } else {
                            persistedInstallationEntryF = firebaseInstallations.c(persistedInstallationEntryC);
                        }
                    }
                    synchronized (obj2) {
                        try {
                            FirebaseApp firebaseApp2 = firebaseInstallations.f44569a;
                            firebaseApp2.a();
                            CrossProcessLock crossProcessLockA2 = CrossProcessLock.a(firebaseApp2.f43489a);
                            try {
                                firebaseInstallations.f44571c.b(persistedInstallationEntryF);
                                if (crossProcessLockA2 != null) {
                                    crossProcessLockA2.b();
                                }
                            } catch (Throwable th2) {
                                if (crossProcessLockA2 != null) {
                                    crossProcessLockA2.b();
                                }
                                throw th2;
                            }
                        } finally {
                        }
                    }
                    synchronized (firebaseInstallations) {
                        if (firebaseInstallations.f44579k.size() != 0 && !TextUtils.equals(persistedInstallationEntryC.c(), persistedInstallationEntryF.c())) {
                            Iterator it = firebaseInstallations.f44579k.iterator();
                            while (it.hasNext()) {
                                ((FidListener) it.next()).a();
                            }
                        }
                    }
                    if (persistedInstallationEntryF.f() == PersistedInstallation.RegistrationStatus.f44619d) {
                        String strC = persistedInstallationEntryF.c();
                        synchronized (firebaseInstallations) {
                            firebaseInstallations.f44578j = strC;
                        }
                    }
                    if (persistedInstallationEntryF.f() == PersistedInstallation.RegistrationStatus.f44620e) {
                        firebaseInstallations.g(new FirebaseInstallationsException());
                        return;
                    } else if (persistedInstallationEntryF.f() == PersistedInstallation.RegistrationStatus.f44617b || persistedInstallationEntryF.f() == PersistedInstallation.RegistrationStatus.f44616a) {
                        firebaseInstallations.g(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
                        return;
                    } else {
                        firebaseInstallations.h(persistedInstallationEntryF);
                        return;
                    }
                } catch (FirebaseInstallationsException e2) {
                    firebaseInstallations.g(e2);
                    return;
                }
            case 1:
                Object obj3 = FirebaseInstallations.f44568m;
                this.f44596b.b();
                return;
            default:
                Object obj4 = FirebaseInstallations.f44568m;
                this.f44596b.b();
                return;
        }
    }
}
