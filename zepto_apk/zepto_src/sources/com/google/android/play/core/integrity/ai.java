package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
final class ai extends com.google.android.play.integrity.internal.o {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.play.integrity.internal.s f41772a = new com.google.android.play.integrity.internal.s("OnRequestIntegrityTokenCallback");

    /* renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f41773b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ aj f41774c;

    public ai(aj ajVar, TaskCompletionSource taskCompletionSource) {
        this.f41774c = ajVar;
        this.f41773b = taskCompletionSource;
    }

    @Override // com.google.android.play.integrity.internal.p
    public final void M(Bundle bundle) {
        aj ajVar = this.f41774c;
        com.google.android.play.integrity.internal.ae aeVar = ajVar.f41779e;
        TaskCompletionSource taskCompletionSource = this.f41773b;
        aeVar.d(taskCompletionSource);
        this.f41772a.b("onRequestIntegrityToken", new Object[0]);
        ajVar.f41778d.getClass();
        int i2 = bundle.getInt("error");
        IntegrityServiceException integrityServiceException = i2 != 0 ? new IntegrityServiceException(i2, null) : null;
        if (integrityServiceException != null) {
            taskCompletionSource.c(integrityServiceException);
            return;
        }
        String string = bundle.getString(CLConstants.SHARED_PREFERENCE_ITEM_TOKEN);
        if (string == null) {
            taskCompletionSource.c(new IntegrityServiceException(-100, null));
            return;
        }
        bundle.getLong("request.token.sid");
        new ah();
        taskCompletionSource.d(new aq(string));
    }
}
