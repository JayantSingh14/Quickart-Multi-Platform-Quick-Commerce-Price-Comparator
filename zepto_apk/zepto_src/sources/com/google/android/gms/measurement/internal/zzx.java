package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class zzx {

    /* renamed from: a, reason: collision with root package name */
    public final zzib f39665a;

    public zzx(zzib zzibVar) {
        this.f39665a = zzibVar;
    }

    public final void a(Bundle bundle, String str) {
        String string;
        zzib zzibVar = this.f39665a;
        zzhy zzhyVar = zzibVar.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        if (zzibVar.a()) {
            return;
        }
        if (bundle.isEmpty()) {
            string = null;
        } else {
            if (true == str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            string = builder.build().toString();
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        zzhg zzhgVar = zzibVar.f39088e;
        zzib.j(zzhgVar);
        zzhgVar.w.b(string);
        zzhgVar.x.b(zzibVar.f39094k.currentTimeMillis());
    }

    public final boolean b() {
        if (!c()) {
            return false;
        }
        zzib zzibVar = this.f39665a;
        long jCurrentTimeMillis = zzibVar.f39094k.currentTimeMillis();
        zzhg zzhgVar = zzibVar.f39088e;
        zzib.j(zzhgVar);
        return jCurrentTimeMillis - zzhgVar.x.a() > zzibVar.f39087d.n(null, zzfx.j0);
    }

    public final boolean c() {
        zzhg zzhgVar = this.f39665a.f39088e;
        zzib.j(zzhgVar);
        return zzhgVar.x.a() > 0;
    }
}
