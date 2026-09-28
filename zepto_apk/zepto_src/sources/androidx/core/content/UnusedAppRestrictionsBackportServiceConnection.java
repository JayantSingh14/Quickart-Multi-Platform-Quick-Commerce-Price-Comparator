package androidx.core.content;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

/* loaded from: classes3.dex */
class UnusedAppRestrictionsBackportServiceConnection implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public IUnusedAppRestrictionsBackportService f2734a;

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IUnusedAppRestrictionsBackportService iUnusedAppRestrictionsBackportServiceG = IUnusedAppRestrictionsBackportService.Stub.g(iBinder);
        this.f2734a = iUnusedAppRestrictionsBackportServiceG;
        try {
            iUnusedAppRestrictionsBackportServiceG.g8(new IUnusedAppRestrictionsBackportCallback.Stub() { // from class: androidx.core.content.UnusedAppRestrictionsBackportServiceConnection.1
                @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
                public final void N5(boolean z, boolean z2) {
                    UnusedAppRestrictionsBackportServiceConnection unusedAppRestrictionsBackportServiceConnection = UnusedAppRestrictionsBackportServiceConnection.this;
                    if (!z) {
                        unusedAppRestrictionsBackportServiceConnection.getClass();
                        throw null;
                    }
                    if (z2) {
                        unusedAppRestrictionsBackportServiceConnection.getClass();
                        throw null;
                    }
                    unusedAppRestrictionsBackportServiceConnection.getClass();
                    throw null;
                }
            });
        } catch (RemoteException unused) {
            throw null;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f2734a = null;
    }
}
