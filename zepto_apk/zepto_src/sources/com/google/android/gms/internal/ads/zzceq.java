package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.TextureView;

/* loaded from: classes4.dex */
public abstract class zzceq extends TextureView implements zzcfn {

    /* renamed from: a, reason: collision with root package name */
    public final zzcfe f26028a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcfo f26029b;

    public zzceq(Context context) {
        super(context);
        this.f26028a = new zzcfe();
        this.f26029b = new zzcfo(context, this);
    }

    public void A(int i2) {
    }

    public void B(int i2) {
    }

    public void e(int i2) {
    }

    public void f(int i2) {
    }

    public void g(int i2) {
    }

    public abstract String h();

    public abstract void i(zzcey zzceyVar);

    public abstract void j(String str);

    public abstract void l();

    public abstract void m();

    public abstract void n();

    public abstract int o();

    public abstract int p();

    public abstract void q(int i2);

    public abstract void r(float f2, float f3);

    public abstract int s();

    public abstract int t();

    public abstract long u();

    public abstract long v();

    public abstract long w();

    public abstract int x();

    public Integer y() {
        return null;
    }

    public void z(String str, String[] strArr, Integer num) {
        j(str);
    }
}
