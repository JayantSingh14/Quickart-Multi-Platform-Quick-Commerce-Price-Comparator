package com.facebook.soloader.recovery;

import android.util.Log;
import com.facebook.soloader.AsyncInitSoSource;
import com.facebook.soloader.SoSource;
import com.facebook.soloader.UnpackingSoSource;

/* loaded from: classes3.dex */
public class WaitForAsyncInit implements RecoveryStrategy {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.soloader.recovery.RecoveryStrategy
    public final boolean a(UnsatisfiedLinkError unsatisfiedLinkError, SoSource[] soSourceArr) {
        for (UnpackingSoSource unpackingSoSource : soSourceArr) {
            if (unpackingSoSource instanceof AsyncInitSoSource) {
                Log.e("SoLoader", "Waiting on SoSource ".concat(unpackingSoSource.c()));
                unpackingSoSource.a();
            }
        }
        return true;
    }
}
