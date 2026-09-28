package com.google.android.tv.ads;

import android.os.Parcelable;

/* loaded from: classes4.dex */
public abstract class IconClickFallbackImage implements Parcelable {

    public static abstract class Builder {
        public abstract IconClickFallbackImage a();

        public abstract Builder b(String str);

        public abstract Builder c(String str);

        public abstract Builder d(int i2);

        public abstract Builder e(String str);

        public abstract Builder f(int i2);
    }

    public static Builder a() {
        zza zzaVar = new zza();
        zzaVar.f(0);
        zzaVar.d(0);
        zzaVar.f42217c = "";
        zzaVar.f42218d = "";
        zzaVar.f42219e = "";
        return zzaVar;
    }

    public abstract String b();

    public abstract String c();

    public abstract int d();

    public abstract String e();

    public abstract int f();
}
