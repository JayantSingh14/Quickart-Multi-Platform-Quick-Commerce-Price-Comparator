package com.google.android.play.core.appupdate;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.install.InstallException;

/* loaded from: classes4.dex */
final class zzp extends zzo {
    @Override // com.google.android.play.core.appupdate.zzo, com.google.android.play.core.appupdate.internal.zzh
    public final void b0(Bundle bundle) {
        super.b0(bundle);
        int i2 = bundle.getInt("error.code", -2);
        TaskCompletionSource taskCompletionSource = this.f41732b;
        if (i2 != 0) {
            taskCompletionSource.c(new InstallException(bundle.getInt("error.code", -2)));
        } else {
            taskCompletionSource.d(null);
        }
    }
}
