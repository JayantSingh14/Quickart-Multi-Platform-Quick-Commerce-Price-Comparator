package com.google.android.gms.tasks;

import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes4.dex */
public class NativeOnCompleteListener implements OnCompleteListener<Object> {
    @KeepForSdk
    public native void nativeOnComplete(long j2, @Nullable Object obj, boolean z, boolean z2, @Nullable String str);

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        Object objL;
        String message;
        Exception excK;
        if (task.p()) {
            objL = task.l();
            message = null;
        } else if (task.n() || (excK = task.k()) == null) {
            objL = null;
            message = null;
        } else {
            message = excK.getMessage();
            objL = null;
        }
        nativeOnComplete(0L, objL, task.p(), task.n(), message);
    }
}
