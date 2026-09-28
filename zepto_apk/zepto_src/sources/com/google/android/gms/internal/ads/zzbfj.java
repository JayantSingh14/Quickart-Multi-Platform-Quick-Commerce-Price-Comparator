package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.os.RemoteException;
import android.util.Base64;
import com.google.android.gms.internal.ads.zzbfp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public final class zzbfj {

    /* renamed from: a, reason: collision with root package name */
    public final zzbfo f24889a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbfp.zzt.zza f24890b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f24891c;

    public zzbfj() {
        this.f24890b = zzbfp.zzt.O();
        this.f24891c = false;
        this.f24889a = new zzbfo();
    }

    public final synchronized void a(zzbfi zzbfiVar) {
        if (this.f24891c) {
            try {
                zzbfiVar.a(this.f24890b);
            } catch (NullPointerException e2) {
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("AdMobClearcutLogger.modify", e2);
            }
        }
    }

    public final synchronized void b(int i2) {
        if (this.f24891c) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Q5)).booleanValue()) {
                d(i2);
            } else {
                c(i2);
            }
        }
    }

    public final synchronized void c(int i2) {
        zzbfp.zzt.zza zzaVar = this.f24890b;
        zzaVar.j();
        ((zzbfp.zzt) zzaVar.f34638b).I();
        ArrayList arrayListJ = com.google.android.gms.ads.internal.util.zzs.J();
        zzaVar.j();
        ((zzbfp.zzt) zzaVar.f34638b).H(arrayListJ);
        final zzbfn zzbfnVar = new zzbfn(this.f24889a, ((zzbfp.zzt) zzaVar.l()).g());
        int i3 = i2 - 1;
        zzbfnVar.f24897b = i3;
        synchronized (zzbfnVar) {
            zzbfnVar.f24898c.f24901c.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbfm
                @Override // java.lang.Runnable
                public final void run() {
                    zzbfn zzbfnVar2 = zzbfnVar;
                    synchronized (zzbfnVar2) {
                        try {
                            zzbfo zzbfoVar = zzbfnVar2.f24898c;
                            if (zzbfoVar.f24900b) {
                                zzbfoVar.f24899a.S4(zzbfnVar2.f24896a);
                                zzbfoVar.f24899a.zzi(0);
                                zzbfoVar.f24899a.A(zzbfnVar2.f24897b);
                                zzbfoVar.f24899a.g2();
                                zzbfoVar.f24899a.zzf();
                            }
                        } catch (RemoteException e2) {
                            com.google.android.gms.ads.internal.util.client.zzo.b("Clearcut log failed", e2);
                        }
                    }
                }
            });
        }
        com.google.android.gms.ads.internal.util.zze.k("Logging Event with event code : ".concat(String.valueOf(Integer.toString(i3, 10))));
    }

    public final synchronized void d(int i2) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(zzfwk.a(externalStorageDirectory, "clearcut_events.txt")), true);
            try {
                try {
                    fileOutputStream.write(e(i2).getBytes());
                } catch (IOException unused) {
                    com.google.android.gms.ads.internal.util.zze.k("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                        com.google.android.gms.ads.internal.util.zze.k("Could not close Clearcut output stream.");
                    }
                }
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException unused3) {
                    com.google.android.gms.ads.internal.util.zze.k("Could not close Clearcut output stream.");
                }
            }
        } catch (FileNotFoundException unused4) {
            com.google.android.gms.ads.internal.util.zze.k("Could not find file for Clearcut");
        }
    }

    public final synchronized String e(int i2) {
        StringBuilder sb;
        zzbfp.zzt.zza zzaVar = this.f24890b;
        String strN = ((zzbfp.zzt) zzaVar.f34638b).N();
        long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime();
        String strEncodeToString = Base64.encodeToString(((zzbfp.zzt) zzaVar.l()).g(), 3);
        sb = new StringBuilder("id=");
        sb.append(strN);
        sb.append(",timestamp=");
        sb.append(jElapsedRealtime);
        sb.append(",event=");
        sb.append(i2 - 1);
        sb.append(",data=");
        sb.append(strEncodeToString);
        sb.append(StringUtils.LF);
        return sb.toString();
    }

    public zzbfj(zzbfo zzbfoVar) {
        this.f24890b = zzbfp.zzt.O();
        this.f24889a = zzbfoVar;
        this.f24891c = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.P5)).booleanValue();
    }
}
