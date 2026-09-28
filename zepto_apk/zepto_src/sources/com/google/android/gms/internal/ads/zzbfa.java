package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.io.PushbackInputStream;

/* loaded from: classes4.dex */
final class zzbfa extends PushbackInputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbfd f24869a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbfa(zzbfd zzbfdVar, ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream) {
        super(autoCloseInputStream, 1);
        this.f24869a = zzbfdVar;
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f24869a.f24878c.a();
        super.close();
    }
}
