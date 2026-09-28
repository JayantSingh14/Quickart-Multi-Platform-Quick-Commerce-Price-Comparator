package com.google.android.play.core.splitinstall.internal;

import java.io.File;

/* loaded from: classes4.dex */
final class zzaq implements zzar {
    @Override // com.google.android.play.core.splitinstall.internal.zzar
    public final boolean a(Object obj, File file, File file2) {
        Class<?> cls = obj.getClass();
        try {
            return new File((String) String.class.cast(zzbk.f(cls, "optimizedPathFor", File.class, File.class).invoke(null, file, file2))).exists();
        } catch (Exception e2) {
            throw new zzbl("Failed to invoke static method optimizedPathFor on type " + cls, e2);
        }
    }
}
