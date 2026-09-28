package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* loaded from: classes4.dex */
public class zzhq extends zzhc {

    /* renamed from: b, reason: collision with root package name */
    public final int f34073b;

    public zzhq() {
        this.f34073b = 1;
    }

    public static zzhq a(IOException iOException, int i2) {
        String message = iOException.getMessage();
        int i3 = iOException instanceof SocketTimeoutException ? 2002 : iOException instanceof InterruptedIOException ? 1004 : (message == null || !zzgpj.a(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        return i3 == 2007 ? new zzhp("Cleartext HTTP traffic not permitted. See https://developer.android.com/guide/topics/media/issues/cleartext-not-permitted", iOException, 2007, 1) : new zzhq(i3, i2, iOException);
    }

    public zzhq(int i2, int i3, IOException iOException) {
        super(i2 == 2000 ? i3 != 1 ? 2000 : 2001 : i2, iOException);
        this.f34073b = i3;
    }

    public zzhq(String str, int i2, int i3) {
        super(str, i2 == 2000 ? i3 != 1 ? 2000 : 2001 : i2);
        this.f34073b = i3;
    }

    public zzhq(String str, IOException iOException, int i2, int i3) {
        super(str, iOException, i2 == 2000 ? i3 != 1 ? 2000 : 2001 : i2);
        this.f34073b = i3;
    }
}
