package com.google.android.play.core.splitinstall.internal;

import java.io.File;
import java.util.HashSet;

/* loaded from: classes4.dex */
final class zzau implements zzan {
    @Override // com.google.android.play.core.splitinstall.internal.zzan
    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return zzat.d(classLoader, file, file2, z, new zzap(), "zip", new zzaq());
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzan
    public final void b(ClassLoader classLoader, HashSet hashSet) {
        zzat.c(classLoader, hashSet);
    }
}
