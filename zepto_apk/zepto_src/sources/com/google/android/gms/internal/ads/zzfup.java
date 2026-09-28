package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
/* loaded from: classes4.dex */
public final class zzfup {

    /* renamed from: a, reason: collision with root package name */
    public final Context f31901a;

    /* renamed from: b, reason: collision with root package name */
    public final Looper f31902b;

    public zzfup(Context context, Looper looper) {
        this.f31901a = context;
        this.f31902b = looper;
    }

    public final void a(String str) {
        zzfuz zzfuzVarC = zzfvb.C();
        Context context = this.f31901a;
        String packageName = context.getPackageName();
        zzfuzVarC.j();
        ((zzfvb) zzfuzVarC.f34638b).D(packageName);
        zzfuzVarC.j();
        ((zzfvb) zzfuzVarC.f34638b).F(2);
        zzfux zzfuxVarC = zzfuy.C();
        zzfuxVarC.j();
        ((zzfuy) zzfuxVarC.f34638b).D(str);
        zzfuxVarC.j();
        ((zzfuy) zzfuxVarC.f34638b).E(2);
        zzfuzVarC.j();
        ((zzfvb) zzfuzVarC.f34638b).E((zzfuy) zzfuxVarC.l());
        zzfuq zzfuqVar = new zzfuq(context, this.f31902b, (zzfvb) zzfuzVarC.l());
        synchronized (zzfuqVar.f31905c) {
            try {
                if (!zzfuqVar.f31906d) {
                    zzfuqVar.f31906d = true;
                    zzfuqVar.f31903a.checkAvailabilityAndConnect();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
