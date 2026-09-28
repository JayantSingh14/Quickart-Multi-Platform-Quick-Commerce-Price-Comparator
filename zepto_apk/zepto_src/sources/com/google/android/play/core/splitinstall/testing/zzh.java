package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.internal.zzbx;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzh implements zzr {
    @Override // com.google.android.play.core.splitinstall.testing.zzr
    public final SplitInstallSessionState a(final SplitInstallSessionState splitInstallSessionState) {
        Callable callable = new Callable() { // from class: com.google.android.play.core.splitinstall.testing.zzo
            @Override // java.util.concurrent.Callable
            public final Object call() throws SplitInstallException {
                int iH;
                int i2 = FakeSplitInstallManager.p;
                SplitInstallSessionState splitInstallSessionState2 = splitInstallSessionState;
                if (splitInstallSessionState2 != null && splitInstallSessionState2.g() == 0 && ((iH = splitInstallSessionState2.h()) == 1 || iH == 2 || iH == 8 || iH == 9 || iH == 7)) {
                    return SplitInstallSessionState.b(0, 7, splitInstallSessionState2.c(), splitInstallSessionState2.a(), splitInstallSessionState2.i(), splitInstallSessionState2.e(), splitInstallSessionState2.d());
                }
                throw new SplitInstallException(-3);
            }
        };
        int i2 = zzbx.f41971a;
        try {
            return (SplitInstallSessionState) callable.call();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new zzbx("TunnelExceptions should always be unwrapped to deal with the checked exception underneath, this message should never be seen if TunnelException is used properly.", e3);
        }
    }
}
