package com.facebook.soloader;

import android.content.Context;
import android.os.StrictMode;
import java.io.File;

/* loaded from: classes.dex */
public class ApplicationSoSource extends SoSource implements RecoverableSoSource {

    /* renamed from: a, reason: collision with root package name */
    public final int f20243a;

    /* renamed from: b, reason: collision with root package name */
    public DirectorySoSource f20244b;

    public ApplicationSoSource(Context context, int i2) {
        this.f20243a = i2;
        this.f20244b = new DirectorySoSource(new File(context.getApplicationInfo().nativeLibraryDir), i2);
    }

    @Override // com.facebook.soloader.RecoverableSoSource
    public final SoSource b(Context context) {
        this.f20244b = new DirectorySoSource(new File(context.getApplicationInfo().nativeLibraryDir), this.f20243a | 1);
        return this;
    }

    @Override // com.facebook.soloader.SoSource
    public final String c() {
        return "ApplicationSoSource";
    }

    @Override // com.facebook.soloader.SoSource
    public final int d(String str, int i2, StrictMode.ThreadPolicy threadPolicy) {
        return this.f20244b.d(str, i2, threadPolicy);
    }

    @Override // com.facebook.soloader.SoSource
    public final void e(int i2) {
        this.f20244b.getClass();
    }

    @Override // com.facebook.soloader.SoSource
    public final String toString() {
        return "ApplicationSoSource[" + this.f20244b.toString() + "]";
    }
}
