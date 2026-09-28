package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;

/* loaded from: classes4.dex */
public final class zzbsv extends zzbsy {
    @Override // com.google.android.gms.internal.ads.zzbsz
    public final boolean Y(String str) {
        try {
            return Adapter.class.isAssignableFrom(Class.forName(str, false, zzbsv.class.getClassLoader()));
        } catch (Throwable unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 104);
            sb.append("Could not load custom event implementation class as Adapter: ");
            sb.append(str);
            sb.append(", assuming old custom event implementation.");
            com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final zzbtc b(String str) throws RemoteException {
        try {
            try {
                Class<?> cls = Class.forName(str, false, zzbsv.class.getClassLoader());
                if (MediationAdapter.class.isAssignableFrom(cls)) {
                    return new zzbua((MediationAdapter) cls.getDeclaredConstructor(null).newInstance(null));
                }
                if (Adapter.class.isAssignableFrom(cls)) {
                    return new zzbua((Adapter) cls.getDeclaredConstructor(null).newInstance(null));
                }
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 64);
                sb.append("Could not instantiate mediation adapter: ");
                sb.append(str);
                sb.append(" (not a valid adapter).");
                com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
                throw new RemoteException();
            } catch (Throwable unused) {
                com.google.android.gms.ads.internal.util.client.zzo.a("Reflection failed, retrying using direct instantiation");
                if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                    return new zzbua(new AdMobAdapter());
                }
                if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                    return new zzbua(new CustomEventAdapter());
                }
                throw new RemoteException();
            }
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 43);
            sb2.append("Could not instantiate mediation adapter: ");
            sb2.append(str);
            sb2.append(". ");
            com.google.android.gms.ads.internal.util.client.zzo.g(sb2.toString(), th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final boolean o(String str) {
        try {
            return CustomEvent.class.isAssignableFrom(Class.forName(str, false, zzbsv.class.getClassLoader()));
        } catch (Throwable unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 88);
            sb.append("Could not load custom event implementation class: ");
            sb.append(str);
            sb.append(", trying Adapter implementation class.");
            com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final zzbuy q(String str) {
        return new zzbvl((RtbAdapter) Class.forName(str, false, zzbvc.class.getClassLoader()).getDeclaredConstructor(null).newInstance(null));
    }
}
