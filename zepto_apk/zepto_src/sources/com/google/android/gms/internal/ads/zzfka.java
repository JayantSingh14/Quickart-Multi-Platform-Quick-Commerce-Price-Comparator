package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.ads.zzbfp;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
final class zzfka implements zzfjz {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f31292a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfkg f31293b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfkc f31294c = new zzfkc();

    public zzfka(zzfkg zzfkgVar) {
        this.f31292a = new ConcurrentHashMap(zzfkgVar.f31311e);
        this.f31293b = zzfkgVar;
    }

    public final synchronized boolean a(zzfkj zzfkjVar, zzfki zzfkiVar) {
        boolean z;
        try {
            ConcurrentHashMap concurrentHashMap = this.f31292a;
            zzfjy zzfjyVar = (zzfjy) concurrentHashMap.get(zzfkjVar);
            zzfkiVar.f31320d = com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis();
            if (zzfjyVar == null) {
                zzfkg zzfkgVar = this.f31293b;
                zzfjy zzfjyVar2 = new zzfjy(zzfkgVar.f31311e, zzfkgVar.f31312f * 1000);
                if (concurrentHashMap.size() == zzfkgVar.f31310d) {
                    int i2 = zzfkgVar.f31316j;
                    int i3 = i2 - 1;
                    zzfkj zzfkjVar2 = null;
                    if (i2 == 0) {
                        throw null;
                    }
                    long j2 = Long.MAX_VALUE;
                    if (i3 == 0) {
                        for (Map.Entry entry : concurrentHashMap.entrySet()) {
                            if (((zzfjy) entry.getValue()).f31290d.f31339a < j2) {
                                j2 = ((zzfjy) entry.getValue()).f31290d.f31339a;
                                zzfkjVar2 = (zzfkj) entry.getKey();
                            }
                        }
                        if (zzfkjVar2 != null) {
                            concurrentHashMap.remove(zzfkjVar2);
                        }
                    } else if (i3 == 1) {
                        for (Map.Entry entry2 : concurrentHashMap.entrySet()) {
                            if (((zzfjy) entry2.getValue()).f31290d.f31341c < j2) {
                                j2 = ((zzfjy) entry2.getValue()).f31290d.f31341c;
                                zzfkjVar2 = (zzfkj) entry2.getKey();
                            }
                        }
                        if (zzfkjVar2 != null) {
                            concurrentHashMap.remove(zzfkjVar2);
                        }
                    } else if (i3 == 2) {
                        int i4 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        for (Map.Entry entry3 : concurrentHashMap.entrySet()) {
                            if (((zzfjy) entry3.getValue()).f31290d.f31342d < i4) {
                                i4 = ((zzfjy) entry3.getValue()).f31290d.f31342d;
                                zzfkjVar2 = (zzfkj) entry3.getKey();
                            }
                        }
                        if (zzfkjVar2 != null) {
                            concurrentHashMap.remove(zzfkjVar2);
                        }
                    }
                    zzfkc zzfkcVar = this.f31294c;
                    zzfkcVar.f31299c++;
                    zzfkcVar.f31297a.f31296b = true;
                }
                concurrentHashMap.put(zzfkjVar, zzfjyVar2);
                zzfkc zzfkcVar2 = this.f31294c;
                zzfkcVar2.f31298b++;
                zzfkcVar2.f31297a.f31295a = true;
                zzfjyVar = zzfjyVar2;
            }
            zzfkx zzfkxVar = zzfjyVar.f31290d;
            zzfkxVar.getClass();
            zzfkxVar.f31341c = com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis();
            zzfkxVar.f31342d++;
            zzfjyVar.a();
            LinkedList linkedList = zzfjyVar.f31287a;
            if (linkedList.size() == zzfjyVar.f31288b) {
                z = false;
            } else {
                linkedList.add(zzfkiVar);
                z = true;
            }
            zzfkc zzfkcVar3 = this.f31294c;
            zzfkcVar3.f31302f++;
            zzfkb zzfkbVar = zzfkcVar3.f31297a;
            zzfkb zzfkbVarClone = zzfkbVar.clone();
            zzfkbVar.f31295a = false;
            zzfkbVar.f31296b = false;
            zzfkw zzfkwVar = zzfjyVar.f31290d.f31340b;
            zzfkw zzfkwVarClone = zzfkwVar.clone();
            zzfkwVar.f31337a = false;
            zzfkwVar.f31338b = 0;
            zzbfp.zzb.zzc zzcVarD = zzbfp.zzb.D();
            zzbfp.zzb.zza.C0026zza c0026zzaE = zzbfp.zzb.zza.E();
            c0026zzaE.j();
            ((zzbfp.zzb.zza) c0026zzaE.f34638b).F();
            zzbfp.zzb.zzg.zza zzaVarE = zzbfp.zzb.zzg.E();
            boolean z2 = zzfkbVarClone.f31295a;
            zzaVarE.j();
            ((zzbfp.zzb.zzg) zzaVarE.f34638b).F(z2);
            boolean z3 = zzfkbVarClone.f31296b;
            zzaVarE.j();
            ((zzbfp.zzb.zzg) zzaVarE.f34638b).G(z3);
            int i5 = zzfkwVarClone.f31338b;
            zzaVarE.j();
            ((zzbfp.zzb.zzg) zzaVarE.f34638b).C(i5);
            c0026zzaE.j();
            ((zzbfp.zzb.zza) c0026zzaE.f34638b).C((zzbfp.zzb.zzg) zzaVarE.l());
            zzcVarD.j();
            ((zzbfp.zzb) zzcVarD.f34638b).E((zzbfp.zzb.zza) c0026zzaE.l());
            zzfkiVar.f31317a.zza().f27293f.m((zzbfp.zzb) zzcVarD.l());
            b();
        } catch (Throwable th) {
            throw th;
        }
        return z;
    }

    public final void b() {
        Parcelable.Creator<zzfkg> creator = zzfkg.CREATOR;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.X6)).booleanValue()) {
            StringBuilder sb = new StringBuilder();
            zzfkg zzfkgVar = this.f31293b;
            sb.append(zzfkgVar.f31309c);
            sb.append(" PoolCollection");
            StringBuilder sb2 = new StringBuilder("\n\tPool does not exist: ");
            zzfkc zzfkcVar = this.f31294c;
            sb2.append(zzfkcVar.f31300d);
            sb2.append("\n\tNew pools created: ");
            sb2.append(zzfkcVar.f31298b);
            sb2.append("\n\tPools removed: ");
            sb2.append(zzfkcVar.f31299c);
            sb2.append("\n\tEntries added: ");
            sb2.append(zzfkcVar.f31302f);
            sb2.append("\n\tNo entries retrieved: ");
            sb2.append(zzfkcVar.f31301e);
            sb2.append(StringUtils.LF);
            sb.append(sb2.toString());
            int i2 = 0;
            for (Map.Entry entry : this.f31292a.entrySet()) {
                i2++;
                sb.append(i2);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(((zzfkj) entry.getKey()).hashCode());
                sb.append("    ");
                int i3 = 0;
                while (true) {
                    zzfjy zzfjyVar = (zzfjy) entry.getValue();
                    zzfjyVar.a();
                    if (i3 >= zzfjyVar.f31287a.size()) {
                        break;
                    }
                    sb.append("[O]");
                    i3++;
                }
                zzfjy zzfjyVar2 = (zzfjy) entry.getValue();
                zzfjyVar2.a();
                for (int size = zzfjyVar2.f31287a.size(); size < zzfkgVar.f31311e; size++) {
                    sb.append("[ ]");
                }
                sb.append(StringUtils.LF);
                zzfjy zzfjyVar3 = (zzfjy) entry.getValue();
                StringBuilder sb3 = new StringBuilder("Created: ");
                zzfkx zzfkxVar = zzfjyVar3.f31290d;
                sb3.append(zzfkxVar.f31339a);
                sb3.append(" Last accessed: ");
                sb3.append(zzfkxVar.f31341c);
                sb3.append(" Accesses: ");
                sb3.append(zzfkxVar.f31342d);
                sb3.append("\nEntries retrieved: Valid: ");
                sb3.append(zzfkxVar.f31343e);
                sb3.append(" Stale: ");
                sb3.append(zzfkxVar.f31344f);
                sb.append(sb3.toString());
                sb.append(StringUtils.LF);
            }
            while (i2 < zzfkgVar.f31310d) {
                i2++;
                sb.append(i2);
                sb.append(".\n");
            }
            String string = sb.toString();
            int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.a(string);
        }
    }
}
