package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class zzgni extends zzbcc implements zzgnj {
    public zzgni() {
        super("com.google.android.play.core.lmd.protocol.ILmdOverlayServiceListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        final zzgpd zzgpdVar;
        if (i2 != 1) {
            return false;
        }
        Bundle bundle = (Bundle) zzbcd.b(parcel, Bundle.CREATOR);
        zzbcd.f(parcel);
        zzgok zzgokVar = (zzgok) this;
        int i3 = bundle.getInt("statusCode", 8150);
        String string = bundle.getString("sessionToken");
        int i4 = bundle.getInt("uiMode", 0);
        zzgno zzgnoVar = new zzgno();
        byte b2 = (byte) (zzgnoVar.f32993d | 1);
        zzgnoVar.f32990a = i3;
        byte b3 = (byte) (b2 | 1);
        zzgnoVar.f32993d = b3;
        if (string != null) {
            zzgnoVar.f32991b = string;
        }
        zzgnoVar.f32992c = i4;
        zzgnoVar.f32993d = (byte) (b3 | 2);
        zzgokVar.f33023a.a(zzgnoVar.a());
        if (i3 == 8157 && (zzgpdVar = zzgokVar.f33024b.f33027a) != null) {
            zzgom.f33025c.a("unbind LMD display overlay service", new Object[0]);
            zzgpdVar.a(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgpa
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzgpd zzgpdVar2 = zzgpdVar;
                    if (zzgpdVar2.f33048j != null) {
                        zzgpdVar2.f33041c.a("Unbind from service.", new Object[0]);
                        Context context = zzgpdVar2.f33040b;
                        ServiceConnection serviceConnection = zzgpdVar2.f33047i;
                        serviceConnection.getClass();
                        context.unbindService(serviceConnection);
                        zzgpdVar2.f33044f = false;
                        zzgpdVar2.f33048j = null;
                        zzgpdVar2.f33047i = null;
                        ArrayList arrayList = zzgpdVar2.f33043e;
                        synchronized (arrayList) {
                            arrayList.clear();
                        }
                    }
                }
            });
        }
        return true;
    }
}
