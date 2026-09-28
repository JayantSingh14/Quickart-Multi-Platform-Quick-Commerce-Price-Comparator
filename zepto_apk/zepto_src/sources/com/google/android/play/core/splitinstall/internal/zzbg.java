package com.google.android.play.core.splitinstall.internal;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;

/* loaded from: classes.dex */
final class zzbg implements zzan {
    @Override // com.google.android.play.core.splitinstall.internal.zzan
    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return zzat.d(classLoader, file, file2, z, new zzav(), "path", new zzbf());
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzan
    public final void b(ClassLoader classLoader, HashSet hashSet) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        zzbd.c(classLoader, hashSet);
    }
}
