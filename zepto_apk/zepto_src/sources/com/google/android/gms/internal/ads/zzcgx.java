package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.api.Releasable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class zzcgx implements Releasable {

    /* renamed from: a, reason: collision with root package name */
    public final Context f26215a;

    /* renamed from: b, reason: collision with root package name */
    public final String f26216b;

    /* renamed from: c, reason: collision with root package name */
    public final WeakReference f26217c;

    public zzcgx(zzcfk zzcfkVar) {
        Context context = zzcfkVar.getContext();
        this.f26215a = context;
        this.f26216b = com.google.android.gms.ads.internal.zzt.C.f21679c.E(context, zzcfkVar.zzs().f21400a);
        this.f26217c = new WeakReference(zzcfkVar);
    }

    public abstract boolean e(String str);

    public boolean f(String str, String[] strArr) {
        return e(str);
    }

    public boolean h(String str, String[] strArr, zzcgp zzcgpVar) {
        return e(str);
    }

    public void i(int i2) {
    }

    public void j(int i2) {
    }

    public void n(int i2) {
    }

    public void o(int i2) {
    }

    public abstract void p();

    public final void q(String str, String str2, String str3, String str4) {
        com.google.android.gms.ads.internal.util.client.zzf.f21413b.post(new zzcgw(this, str, str2, str3, str4));
    }

    public final /* synthetic */ void r(HashMap map) {
        zzcfk zzcfkVar = (zzcfk) this.f26217c.get();
        if (zzcfkVar != null) {
            zzcfkVar.g("onPrecacheEvent", map);
        }
    }

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
    }
}
