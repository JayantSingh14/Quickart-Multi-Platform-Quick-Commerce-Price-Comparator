package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzdur {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f28606a = new HashMap();

    public final synchronized void a(String str, zzfji zzfjiVar) {
        zzfir zzfirVar;
        zzbvn zzbvnVarM;
        if (this.f28606a.containsKey(str)) {
            return;
        }
        zzbvn zzbvnVarU = null;
        if (zzfjiVar == null) {
            zzbvnVarM = null;
        } else {
            try {
                zzbvnVarM = zzfjiVar.f31270a.m();
            } finally {
                try {
                } catch (zzfir unused) {
                }
            }
        }
        if (zzfjiVar != null) {
            try {
                zzbvnVarU = zzfjiVar.f31270a.U();
            } finally {
                try {
                } catch (zzfir unused2) {
                }
            }
        }
        boolean z = true;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.xa)).booleanValue()) {
            if (zzfjiVar == null) {
                z = false;
            } else {
                try {
                    zzfjiVar.a();
                } catch (zzfir unused3) {
                }
            }
        }
        this.f28606a.put(str, new zzduq(str, zzbvnVarM, zzbvnVarU, z));
    }

    public final synchronized zzduq b(String str) {
        return (zzduq) this.f28606a.get(str);
    }
}
