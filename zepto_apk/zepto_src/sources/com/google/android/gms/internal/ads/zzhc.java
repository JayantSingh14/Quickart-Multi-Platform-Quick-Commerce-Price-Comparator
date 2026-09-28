package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes4.dex */
public class zzhc extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public final int f33505a;

    public zzhc() {
        this.f33505a = 2008;
    }

    public zzhc(String str, int i2) {
        super(str);
        this.f33505a = i2;
    }

    public zzhc(String str, Exception exc, int i2) {
        super(str, exc);
        this.f33505a = i2;
    }

    public zzhc(int i2, Exception exc) {
        super(exc);
        this.f33505a = i2;
    }
}
