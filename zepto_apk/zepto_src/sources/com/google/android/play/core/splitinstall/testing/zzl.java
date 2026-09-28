package com.google.android.play.core.splitinstall.testing;

import java.io.File;
import java.io.FileFilter;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzl implements FileFilter {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzl f42050a = new zzl();

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        int i2 = FakeSplitInstallManager.p;
        return file.getName().endsWith(".apk");
    }
}
