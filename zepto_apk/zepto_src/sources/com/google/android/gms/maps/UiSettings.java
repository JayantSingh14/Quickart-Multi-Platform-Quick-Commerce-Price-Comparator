package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* loaded from: classes4.dex */
public final class UiSettings {

    /* renamed from: a, reason: collision with root package name */
    public final IUiSettingsDelegate f38430a;

    public UiSettings(IUiSettingsDelegate iUiSettingsDelegate) {
        this.f38430a = iUiSettingsDelegate;
    }

    public final boolean a() {
        try {
            return this.f38430a.Ya();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void b(boolean z) {
        try {
            this.f38430a.u7(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void c(boolean z) {
        try {
            this.f38430a.L6(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void d(boolean z) {
        try {
            this.f38430a.K4(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void e(boolean z) {
        try {
            this.f38430a.W1(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void f(boolean z) {
        try {
            this.f38430a.n9(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void g(boolean z) {
        try {
            this.f38430a.ta(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void h(boolean z) {
        try {
            this.f38430a.v7(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void i(boolean z) {
        try {
            this.f38430a.J8(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void j(boolean z) {
        try {
            this.f38430a.f9(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void k(boolean z) {
        try {
            this.f38430a.L8(z);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
