package com.google.android.play.core.splitinstall.internal;

import android.util.Log;
import java.io.File;

/* loaded from: classes4.dex */
final class zzbc implements zzar {
    @Override // com.google.android.play.core.splitinstall.internal.zzar
    public final boolean a(Object obj, File file, File file2) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("dalvik.system.DexFile");
            try {
                return !((Boolean) Boolean.class.cast(zzbk.f(cls, "isDexOptNeeded", String.class).invoke(null, file.getPath()))).booleanValue();
            } catch (Exception e2) {
                throw new zzbl("Failed to invoke static method isDexOptNeeded on type " + cls, e2);
            }
        } catch (ClassNotFoundException unused) {
            Log.e("SplitCompat", "Unexpected missing dalvik.system.DexFile.");
            return false;
        }
    }
}
