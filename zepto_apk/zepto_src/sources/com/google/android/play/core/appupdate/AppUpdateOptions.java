package com.google.android.play.core.appupdate;

/* loaded from: classes4.dex */
public abstract class AppUpdateOptions {

    public static abstract class Builder {
        public abstract AppUpdateOptions a();
    }

    public static AppUpdateOptions c(int i2) {
        return d(i2).a();
    }

    public static Builder d(int i2) {
        zzv zzvVar = new zzv();
        zzvVar.f41746a = i2;
        zzvVar.f41747b = (byte) (((byte) (zzvVar.f41747b | 1)) | 2);
        return zzvVar;
    }

    public abstract boolean a();

    public abstract int b();
}
