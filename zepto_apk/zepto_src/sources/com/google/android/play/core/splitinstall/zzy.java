package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import java.util.ArrayList;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
final class zzy implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SplitInstallRequest f42148a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzaa f42149b;

    public zzy(zzaa zzaaVar, SplitInstallRequest splitInstallRequest) {
        this.f42149b = zzaaVar;
        this.f42148a = splitInstallRequest;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzx zzxVar = this.f42149b.f42082b;
        SplitInstallRequest splitInstallRequest = this.f42148a;
        ArrayList arrayList = splitInstallRequest.f41931a;
        ArrayList arrayListE = zzaa.e(splitInstallRequest.f41932b);
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", 0);
        bundle.putInt(CLConstants.OTP_STATUS, 5);
        bundle.putInt("error_code", 0);
        if (!arrayList.isEmpty()) {
            bundle.putStringArrayList("module_names", new ArrayList<>(arrayList));
        }
        if (!arrayListE.isEmpty()) {
            bundle.putStringArrayList("languages", new ArrayList<>(arrayListE));
        }
        bundle.putLong("total_bytes_to_download", 0L);
        bundle.putLong("bytes_downloaded", 0L);
        zzxVar.d(SplitInstallSessionState.m(bundle));
    }
}
