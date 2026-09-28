package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbfp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public abstract class zzclg implements zzcpn {

    /* renamed from: a, reason: collision with root package name */
    public static zzclg f26504a;

    public static zzclg f(Context context, zzbsz zzbszVar, int i2) {
        zzgyw zzgywVar;
        SharedPreferences sharedPreferences;
        new zzcmr();
        synchronized (zzclg.class) {
            try {
                zzclg zzclgVar = f26504a;
                if (zzclgVar != null) {
                    return zzclgVar;
                }
                com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
                long jCurrentTimeMillis = zztVar.f21687k.currentTimeMillis();
                zzbgk.a(context);
                if (((Boolean) zzbic.f25125e.c()).booleanValue() && (sharedPreferences = context.getSharedPreferences("admob", 0)) != null) {
                    sharedPreferences.edit().putInt("init_without_write", zzbfv.b(context, "init_without_write") + 1).commit();
                }
                zzfjg zzfjgVarA = zzfjg.a(context);
                boolean zF = com.google.android.gms.ads.internal.util.zzs.f(zzfjgVarA.f31267a);
                VersionInfoParcel versionInfoParcel = new VersionInfoParcel(ModuleDescriptor.MODULE_VERSION, i2, true, zF);
                if (((Boolean) zzbil.f25190c.c()).booleanValue()) {
                    com.google.android.gms.ads.internal.client.zzcy zzcyVar = zzfjgVarA.f31268b;
                    com.google.android.gms.ads.internal.client.zzfc liteSdkVersion = null;
                    if (zzcyVar != null) {
                        try {
                            liteSdkVersion = zzcyVar.getLiteSdkVersion();
                        } catch (RemoteException unused) {
                        }
                    }
                    if (liteSdkVersion != null) {
                        versionInfoParcel = new VersionInfoParcel(ModuleDescriptor.MODULE_VERSION, liteSdkVersion.f21228b, true, zF);
                    }
                }
                zzfjgVarA.b(zzbszVar);
                zzcng zzcngVar = new zzcng();
                zzclh zzclhVar = new zzclh();
                zzclhVar.f26505a = versionInfoParcel;
                zzclhVar.f26508d = new WeakReference(context);
                zzclhVar.f26506b = context.getApplicationContext() != null ? context.getApplicationContext() : context;
                zzclhVar.f26507c = jCurrentTimeMillis;
                zzcngVar.f26670a = new zzcli(zzclhVar);
                zzcngVar.f26671b = new zzcod();
                zzclg zzclgVarA = zzcngVar.a();
                zzbgb zzbgbVar = zzbgk.Te;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                    zzcdj zzcdjVar = zztVar.f21681e;
                    zzgyw zzgywVar2 = zzcdo.f25982a;
                    zzijo.a(zzgywVar2);
                    zzcdjVar.a(zzgywVar2, zzclgVarA.d(), context);
                    final zzcdj zzcdjVar2 = zztVar.f21681e;
                    if (zzcdjVar2.f25974d.get() && zzcdjVar2.f25976f >= 0 && zzcdjVar2.f25977g >= 0 && zzcdjVar2.f25975e.compareAndSet(false, true) && (zzgywVar = zzcdjVar2.f25971a) != null) {
                        ((zzgxi) zzgywVar).submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdh
                            @Override // java.lang.Runnable
                            public final void run() throws InterruptedException {
                                zzdxe zzdxeVar;
                                ActivityManager.MemoryInfo memoryInfoJ;
                                while (true) {
                                    zzcdj zzcdjVar3 = zzcdjVar2;
                                    if (!zzcdjVar3.f25975e.get()) {
                                        return;
                                    }
                                    final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                                    com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdg
                                        @Override // java.lang.Runnable
                                        public final /* synthetic */ void run() {
                                            atomicBoolean.getAndSet(true);
                                        }
                                    });
                                    try {
                                        Thread.sleep(zzcdjVar3.f25976f);
                                        if (!atomicBoolean.get()) {
                                            zzbgb zzbgbVar2 = zzbgk.We;
                                            com.google.android.gms.ads.internal.client.zzbd zzbdVar2 = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                                            boolean zBooleanValue = ((Boolean) zzbdVar2.f21153c.a(zzbgbVar2)).booleanValue();
                                            zzbgi zzbgiVar = zzbdVar2.f21153c;
                                            if (zBooleanValue && (zzdxeVar = zzcdjVar3.f25972b) != null) {
                                                zzdxd zzdxdVarA = zzdxeVar.a();
                                                zzdxdVarA.b("action", "panr");
                                                if (((Boolean) zzbgiVar.a(zzbgk.yf)).booleanValue() && (memoryInfoJ = com.google.android.gms.ads.internal.util.client.zzf.j(zzcdjVar3.f25973c)) != null) {
                                                    zzdxdVarA.b("mem_avl", String.valueOf(memoryInfoJ.availMem));
                                                    zzdxdVarA.b("mem_tt", String.valueOf(memoryInfoJ.totalMem));
                                                    zzdxdVarA.b("low_m", true != memoryInfoJ.lowMemory ? "0" : "1");
                                                }
                                                zzdxdVarA.e();
                                            }
                                            if (((Boolean) zzbgiVar.a(zzbgk.Xe)).booleanValue()) {
                                                StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
                                                zzcdi zzcdiVar = new zzcdi("Potential ANR detected");
                                                zzcdiVar.setStackTrace(stackTrace);
                                                if (((Boolean) zzbgiVar.a(zzbgk.Ye)).booleanValue()) {
                                                    zzbxv.e(zzcdjVar3.f25973c).b(zzcdiVar, "AnrWatchdog", ((Integer) zzbgiVar.a(zzbgk.Ze)).intValue() / 100.0f);
                                                } else {
                                                    com.google.android.gms.ads.internal.zzt.C.f21684h.d("AnrWatchdog", zzcdiVar);
                                                }
                                            }
                                        }
                                        do {
                                            try {
                                                Thread.sleep(zzcdjVar3.f25977g);
                                            } catch (InterruptedException unused2) {
                                                Thread.currentThread().interrupt();
                                            }
                                        } while (!atomicBoolean.get());
                                    } catch (InterruptedException unused3) {
                                        Thread.currentThread().interrupt();
                                        return;
                                    }
                                }
                            }
                        });
                    }
                }
                ((zzebp) ((zzcmv) zzclgVarA).o.zzb()).a();
                ((zzckz) ((zzcmv) zzclgVarA).n.zzb()).a(context, versionInfoParcel);
                zztVar.f21684h.b(context, versionInfoParcel, zzclgVarA.d());
                zztVar.f21686j.a(context);
                zztVar.f21679c.C(context);
                zztVar.f21679c.D(context);
                com.google.android.gms.ads.internal.util.zzd.a(context);
                zztVar.f21683g.a(context);
                zztVar.z.a(context);
                if (((Boolean) zzbdVar.f21153c.a(zzbgk.pf)).booleanValue()) {
                    String str = (String) zzbdVar.f21153c.a(zzbgk.qf);
                    if (!str.isEmpty()) {
                        if (Arrays.asList(str.split(",")).contains(context.getPackageName())) {
                            ((zzdum) ((zzcmv) zzclgVarA).U.zzb()).a(zztVar.f21683g);
                        }
                    }
                } else if (((Boolean) zzbdVar.f21153c.a(zzbgk.of)).booleanValue()) {
                    ((zzdum) ((zzcmv) zzclgVarA).U.zzb()).a(zztVar.f21683g);
                }
                ((com.google.android.gms.ads.internal.util.zzbz) ((zzcmv) zzclgVarA).T.zzb()).a();
                zzcbx.b(context);
                if (((Boolean) zzbdVar.f21153c.a(zzbgk.R6)).booleanValue()) {
                    if (!((Boolean) zzbdVar.f21153c.a(zzbgk.T0)).booleanValue()) {
                        zzbfj zzbfjVar = new zzbfj(new zzbfo(context));
                        zzegn zzegnVar = new zzegn(new zzegj(context), (zzgyw) ((zzcmv) zzclgVarA).f26581f.zzb());
                        final zzehi zzehiVar = new zzehi(context, versionInfoParcel, zzbfjVar, zzegnVar);
                        final boolean zQ = zztVar.f21684h.g().q();
                        try {
                            zzegnVar.a(new zzflu() { // from class: com.google.android.gms.internal.ads.zzehh
                                @Override // com.google.android.gms.internal.ads.zzflu
                                public final Object zza(Object obj) {
                                    long j2;
                                    SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                                    zzehi zzehiVar2 = zzehiVar;
                                    boolean z = zQ;
                                    Context context2 = zzehiVar2.f29340b;
                                    if (z) {
                                        context2.deleteDatabase("OfflineUpload.db");
                                        return null;
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    Cursor cursorQuery = sQLiteDatabase.query("offline_signal_contents", new String[]{"serialized_proto_data"}, null, null, null, null, null);
                                    while (cursorQuery.moveToNext()) {
                                        try {
                                            arrayList.add(zzbfp.zzaf.zza.S(cursorQuery.getBlob(cursorQuery.getColumnIndexOrThrow("serialized_proto_data"))));
                                        } catch (zzibg e2) {
                                            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                                            com.google.android.gms.ads.internal.util.client.zzo.c("Unable to deserialize proto from offline signals database:");
                                            com.google.android.gms.ads.internal.util.client.zzo.c(e2.getMessage());
                                        }
                                    }
                                    cursorQuery.close();
                                    zzbfp.zzaf.zzc zzcVarC = zzbfp.zzaf.C();
                                    String packageName = context2.getPackageName();
                                    zzcVarC.j();
                                    ((zzbfp.zzaf) zzcVarC.f34638b).H(packageName);
                                    String str2 = Build.MODEL;
                                    zzcVarC.j();
                                    ((zzbfp.zzaf) zzcVarC.f34638b).I();
                                    int iA = zzehc.a(sQLiteDatabase, 0);
                                    zzcVarC.j();
                                    ((zzbfp.zzaf) zzcVarC.f34638b).E(iA);
                                    zzcVarC.j();
                                    ((zzbfp.zzaf) zzcVarC.f34638b).D(arrayList);
                                    int iA2 = zzehc.a(sQLiteDatabase, 1);
                                    zzcVarC.j();
                                    ((zzbfp.zzaf) zzcVarC.f34638b).F(iA2);
                                    int iA3 = zzehc.a(sQLiteDatabase, 3);
                                    zzcVarC.j();
                                    ((zzbfp.zzaf) zzcVarC.f34638b).K(iA3);
                                    long jCurrentTimeMillis2 = com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis();
                                    zzcVarC.j();
                                    ((zzbfp.zzaf) zzcVarC.f34638b).G(jCurrentTimeMillis2);
                                    Cursor cursorC = zzehc.c(sQLiteDatabase, 2);
                                    if (cursorC.getCount() > 0) {
                                        cursorC.moveToNext();
                                        j2 = cursorC.getLong(cursorC.getColumnIndexOrThrow(CLConstants.FIELD_PAY_INFO_VALUE));
                                    } else {
                                        j2 = 0;
                                    }
                                    cursorC.close();
                                    zzcVarC.j();
                                    ((zzbfp.zzaf) zzcVarC.f34638b).J(j2);
                                    final zzbfp.zzaf zzafVar = (zzbfp.zzaf) zzcVarC.l();
                                    int size = arrayList.size();
                                    long jQ = 0;
                                    for (int i4 = 0; i4 < size; i4++) {
                                        zzbfp.zzaf.zza zzaVar = (zzbfp.zzaf.zza) arrayList.get(i4);
                                        if (zzaVar.R() == zzbfp.zzq.ENUM_TRUE && zzaVar.Q() > jQ) {
                                            jQ = zzaVar.Q();
                                        }
                                    }
                                    if (jQ != 0) {
                                        ContentValues contentValues = new ContentValues();
                                        contentValues.put(CLConstants.FIELD_PAY_INFO_VALUE, Long.valueOf(jQ));
                                        sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", null);
                                    }
                                    zzbfi zzbfiVar = new zzbfi() { // from class: com.google.android.gms.internal.ads.zzehf
                                        @Override // com.google.android.gms.internal.ads.zzbfi
                                        public final void a(zzbfp.zzt.zza zzaVar2) {
                                            zzaVar2.j();
                                            ((zzbfp.zzt) zzaVar2.f34638b).L(zzafVar);
                                        }
                                    };
                                    zzbfj zzbfjVar2 = zzehiVar2.f29339a;
                                    zzbfjVar2.a(zzbfiVar);
                                    zzbfp.zzar.zza zzaVarE = zzbfp.zzar.E();
                                    VersionInfoParcel versionInfoParcel2 = zzehiVar2.f29341c;
                                    int i5 = versionInfoParcel2.f21401b;
                                    zzaVarE.j();
                                    ((zzbfp.zzar) zzaVarE.f34638b).F(i5);
                                    int i6 = versionInfoParcel2.f21402c;
                                    zzaVarE.j();
                                    ((zzbfp.zzar) zzaVarE.f34638b).G(i6);
                                    int i7 = true != versionInfoParcel2.f21403d ? 2 : 0;
                                    zzaVarE.j();
                                    ((zzbfp.zzar) zzaVarE.f34638b).C(i7);
                                    final zzbfp.zzar zzarVar = (zzbfp.zzar) zzaVarE.l();
                                    zzbfjVar2.a(new zzbfi() { // from class: com.google.android.gms.internal.ads.zzehg
                                        @Override // com.google.android.gms.internal.ads.zzbfi
                                        public final void a(zzbfp.zzt.zza zzaVar2) {
                                            zzbfp.zzm.zza zzaVar3 = (zzbfp.zzm.zza) ((zzbfp.zzt) zzaVar2.f34638b).C().v();
                                            zzbfp.zzar zzarVar2 = zzarVar;
                                            zzaVar3.j();
                                            ((zzbfp.zzm) zzaVar3.f34638b).E(zzarVar2);
                                            zzaVar2.j();
                                            ((zzbfp.zzt) zzaVar2.f34638b).J((zzbfp.zzm) zzaVar3.l());
                                        }
                                    });
                                    zzbfjVar2.b(10004);
                                    sQLiteDatabase.delete("offline_signal_contents", null, null);
                                    zzehc.d(sQLiteDatabase, "failed_requests");
                                    zzehc.d(sQLiteDatabase, "total_requests");
                                    zzehc.d(sQLiteDatabase, "completed_requests");
                                    return null;
                                }
                            });
                        } catch (Exception e2) {
                            String strValueOf = String.valueOf(e2.getMessage());
                            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                            com.google.android.gms.ads.internal.util.client.zzo.c("Error in offline signals database startup: ".concat(strValueOf));
                        }
                    }
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.f1if)).booleanValue()) {
                    zzcmv zzcmvVar = (zzcmv) zzclgVarA;
                    Context context2 = zzcmvVar.f26577b.f26510b;
                    zzijo.a(context2);
                    zzgyw zzgywVar3 = zzcdo.f25982a;
                    zzijo.a(zzgywVar3);
                    final zzeeu zzeeuVar = new zzeeu(zzcmvVar, context2, zzgywVar3);
                    ((zzcdn) zzgywVar3).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeet
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzeeu zzeeuVar2 = zzeeuVar;
                            zzcmv zzcmvVar2 = (zzcmv) zzeeuVar2.f29196a;
                            zzijo.b(Context.class, zzeeuVar2.f29197b);
                            zzcmv zzcmvVar3 = zzcmvVar2.f26578c;
                            zzcns zzcnsVar = new zzcns(zzcmvVar3);
                            zzijf zzijfVar = zzcmvVar3.f26587l;
                            zzcli zzcliVar = zzcmvVar3.f26577b;
                            Context context3 = zzcliVar.f26510b;
                            zzijo.a(context3);
                            zzgyw zzgywVar4 = zzcdo.f25983b;
                            zzijo.a(zzgywVar4);
                            zzgyw zzgywVar5 = zzcdo.f25982a;
                            zzijo.a(zzgywVar5);
                            zzija zzijaVarB = zzijf.b(zzcnsVar.f26743c);
                            VersionInfoParcel versionInfoParcel2 = zzcliVar.f26509a;
                            zzijo.a(versionInfoParcel2);
                            final zzefb zzefbVar = new zzefb(context3, zzgywVar4, zzgywVar5, zzijaVarB, versionInfoParcel2, zzcnsVar, (zzdxe) zzijfVar.zzb());
                            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
                            if (com.google.android.gms.ads.internal.util.zzs.e(context3.getPackageName())) {
                                ((zzcdn) zzgywVar5).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeez
                                    @Override // java.lang.Runnable
                                    public final /* synthetic */ void run() {
                                        zzefbVar.a();
                                    }
                                });
                                return;
                            }
                            zzeey zzeeyVar = new zzeey(zzefbVar);
                            zzcmv zzcmvVar4 = zzcnsVar.f26741a;
                            zzcnt zzcntVar = new zzcnt();
                            zzcntVar.f26744a = zzeeyVar;
                            zzedk zzedkVar = zzcntVar.f26744a;
                            zzcli zzcliVar2 = zzcmvVar4.f26577b;
                            Context context4 = zzcliVar2.f26510b;
                            zzijo.a(context4);
                            VersionInfoParcel versionInfoParcel3 = zzcliVar2.f26509a;
                            zzijo.a(versionInfoParcel3);
                            final zzedl zzedlVar = new zzedl(context4, versionInfoParcel3, zzedkVar);
                            ((zzcdn) zzgywVar4).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzefa
                                @Override // java.lang.Runnable
                                public final void run() {
                                    zzedl zzedlVar2 = zzedlVar;
                                    synchronized (zzedlVar2.f29149b) {
                                        try {
                                            if (zzedlVar2.f29150c) {
                                                return;
                                            }
                                            zzedlVar2.f29150c = true;
                                            zzbyc zzbycVar = new zzbyc(zzedlVar2.f29141g, com.google.android.gms.ads.internal.zzt.C.t.a(), zzedlVar2, zzedlVar2);
                                            zzedlVar2.f29153f = zzbycVar;
                                            zzbycVar.checkAvailabilityAndConnect();
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    }
                                }
                            });
                        }
                    });
                }
                f26504a = zzclgVarA;
                return zzclgVarA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzfaz A(zzbza zzbzaVar, int i2) {
        return B(new zzfcc(zzbzaVar, i2));
    }

    public abstract zzfaz B(zzfcc zzfccVar);

    public abstract zzdyv a();

    public abstract zzfja b();

    public abstract zzebh c();

    public abstract zzdxe d();

    public abstract zzccq e();

    public abstract Executor g();

    public abstract ScheduledExecutorService h();

    public abstract zzddl i();

    public abstract zzcoo j();

    public abstract zzfqb k();

    public abstract zzcug l();

    public abstract zzfeh m();

    public abstract zzcsp n();

    public abstract zzfcu o();

    public abstract zzdky p();

    public abstract zzffx q();

    public abstract zzdlu r();

    public abstract zzdti s();

    public abstract zzfhk t();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzab u();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzau v();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzv w();

    public abstract zzeif x();

    public abstract zzeak y();

    public abstract zzfnr z();
}
