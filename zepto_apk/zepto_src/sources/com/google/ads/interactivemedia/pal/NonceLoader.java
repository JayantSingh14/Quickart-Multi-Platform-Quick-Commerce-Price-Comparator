package com.google.ads.interactivemedia.pal;

import android.content.Context;
import android.support.v4.media.b;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.pal.zzagb;
import com.google.android.gms.internal.pal.zzagc;
import com.google.android.gms.internal.pal.zzba;
import com.google.android.gms.internal.pal.zzbc;
import com.google.android.gms.internal.pal.zzbg;
import com.google.android.gms.internal.pal.zzii;
import com.google.android.gms.internal.pal.zzil;
import com.google.android.gms.internal.pal.zzjb;
import com.google.android.gms.internal.pal.zzjc;
import com.google.android.gms.internal.pal.zzjd;
import com.google.android.gms.internal.pal.zzjl;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public final class NonceLoader {
    public static final /* synthetic */ int zza = 0;
    private static final Random zzb = new Random();
    private final Context zzc;
    private final zzagb zzd;
    private final zzagb zze;
    private final Task zzf;
    private final com.google.android.gms.internal.pal.zzav zzg;
    private final zzbg zzh;
    private final zzbg zzi;
    private final zzbg zzj;
    private final zzbc zzk;
    private final zzx zzl;
    private final long zzm;
    private long zzn;
    private final String zzo;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public NonceLoader(@androidx.annotation.NonNull final android.content.Context r14, @androidx.annotation.NonNull com.google.ads.interactivemedia.pal.ConsentSettings r15) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.pal.NonceLoader.<init>(android.content.Context, com.google.ads.interactivemedia.pal.ConsentSettings):void");
    }

    public static /* synthetic */ Map zzb(zzjb zzjbVar, Task task, Task task2, Task task3, Task task4, Task task5) throws Exception {
        zzjbVar.b((Map) zze(task).a(new zzii() { // from class: com.google.ads.interactivemedia.pal.zzaf
            @Override // com.google.android.gms.internal.pal.zzii
            public final Object zza(Object obj) {
                com.google.android.gms.internal.pal.zzaw zzawVar = (com.google.android.gms.internal.pal.zzaw) obj;
                int i2 = NonceLoader.zza;
                return zzjc.e(zzak.ADVERTISING_ID.zza(), zzawVar.a(), zzak.ID_TYPE.zza(), zzawVar.b(), zzak.LIMIT_AD_TRACKING.zza(), true != zzawVar.c() ? "0" : "1");
            }
        }).c(zzjc.b()));
        zzjbVar.b(((Boolean) zze(task).a(new zzii() { // from class: com.google.ads.interactivemedia.pal.zzab
            /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
            @Override // com.google.android.gms.internal.pal.zzii
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object zza(java.lang.Object r9) {
                /*
                    r8 = this;
                    r0 = 1
                    com.google.android.gms.internal.pal.zzaw r9 = (com.google.android.gms.internal.pal.zzaw) r9
                    int r1 = com.google.ads.interactivemedia.pal.NonceLoader.zza
                    boolean r1 = r9.c()
                    r2 = 0
                    if (r1 != 0) goto L3e
                    java.lang.String r9 = r9.a()
                    int r1 = r9.length()
                    java.lang.String r3 = "00000000-0000-0000-0000-000000000000"
                    if (r9 != r3) goto L19
                    goto L3e
                L19:
                    r4 = 36
                    if (r1 != r4) goto L3f
                    r4 = r2
                L1e:
                    if (r4 >= r1) goto L3e
                    char r5 = r9.charAt(r4)
                    char r6 = r3.charAt(r4)
                    if (r5 != r6) goto L2b
                    goto L3c
                L2b:
                    r5 = r5 | 32
                    int r5 = r5 + (-97)
                    char r5 = (char) r5
                    r7 = 26
                    if (r5 >= r7) goto L3f
                    r6 = r6 | 32
                    int r6 = r6 + (-97)
                    char r6 = (char) r6
                    if (r5 == r6) goto L3c
                    goto L3f
                L3c:
                    int r4 = r4 + r0
                    goto L1e
                L3e:
                    r0 = r2
                L3f:
                    java.lang.Boolean r9 = java.lang.Boolean.valueOf(r0)
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.pal.zzab.zza(java.lang.Object):java.lang.Object");
            }
        }).c(Boolean.FALSE)).booleanValue() ? zzjc.b() : (zzjc) zze(task2).a(new zzii() { // from class: com.google.ads.interactivemedia.pal.zzac
            @Override // com.google.android.gms.internal.pal.zzii
            public final Object zza(Object obj) {
                AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
                int i2 = NonceLoader.zza;
                return zzjc.d(zzak.PER_VENDOR_ID.zza(), appSetIdInfo.f21994a, zzak.PER_VENDOR_ID_SCOPE.zza(), String.valueOf(appSetIdInfo.f21995b));
            }
        }).c(zzjc.b()));
        zzjbVar.b((Map) zze(task3).a(new zzii() { // from class: com.google.ads.interactivemedia.pal.zzag
            @Override // com.google.android.gms.internal.pal.zzii
            public final Object zza(Object obj) {
                int i2 = NonceLoader.zza;
                return zzjc.c((String) obj, zzak.MOBILE_SPAM.zza());
            }
        }).c(zzjc.b()));
        zzjbVar.b((Map) zze(task4).a(new zzii() { // from class: com.google.ads.interactivemedia.pal.zzah
            @Override // com.google.android.gms.internal.pal.zzii
            public final Object zza(Object obj) {
                int i2 = NonceLoader.zza;
                return zzjc.c((String) obj, zzak.ADS_IDENTITY_TOKEN.zza());
            }
        }).c(zzjc.b()));
        return zzjbVar.c();
    }

    private static zzil zze(Task task) {
        return !task.p() ? zzil.e() : (zzil) task.l();
    }

    private static String zzf() {
        return Integer.toString(zzb.nextInt(Api.BaseClientBuilder.API_PRIORITY_OTHER));
    }

    private static String zzg(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            Log.e("NonceGenerator", "Failed to encode the input string.");
            return "";
        }
    }

    private static String zzh(Context context) {
        return "h.3.2.2/n.android.3.2.2/".concat(String.valueOf(context.getApplicationContext().getPackageName()));
    }

    @NonNull
    public Task<NonceManager> loadNonceManager(@Nullable final NonceRequest nonceRequest) {
        if (nonceRequest == null) {
            this.zzl.zza(103);
            return Tasks.d(NonceLoaderException.zzb(103));
        }
        final String strZzf = zzf();
        final zzjb zzjbVar = new zzjb();
        if (nonceRequest.zzi().length() <= 500) {
            zzjbVar.a(zzak.DESCRIPTION_URL.zza(), zzg(nonceRequest.zzi()));
        }
        if (nonceRequest.zzo().length() <= 200) {
            zzjbVar.a(zzak.PPID.zza(), zzg(nonceRequest.zzo()));
        }
        if (nonceRequest.zzl().length() > 0 && nonceRequest.zzl().length() <= 200) {
            zzjbVar.a(zzak.OMID_VERSION.zza(), zzg(nonceRequest.zzl()));
        }
        if (nonceRequest.zzm().length() <= 200) {
            zzjbVar.a(zzak.PLAYER_TYPE.zza(), zzg(nonceRequest.zzm()));
        }
        if (nonceRequest.zzn().length() <= 200) {
            zzjbVar.a(zzak.PLAYER_VERSION.zza(), zzg(nonceRequest.zzn()));
        }
        String strL = (nonceRequest.zzj().length() == 0 || nonceRequest.zzj().length() > 200 || nonceRequest.zzk().length() == 0 || nonceRequest.zzk().length() > 200) ? "" : b.l(nonceRequest.zzj(), "/", nonceRequest.zzk());
        zzjbVar.a(zzak.OMID_PARTNER.zza(), zzg(strL));
        TreeSet treeSet = new TreeSet(nonceRequest.zzq());
        if (!strL.isEmpty()) {
            treeSet.add(7);
        }
        String strZza = zzak.API_FRAMEWORKS.zza();
        Iterator it = treeSet.iterator();
        StringBuilder sb = new StringBuilder();
        try {
            if (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                sb.append(next instanceof CharSequence ? (CharSequence) next : next.toString());
                while (it.hasNext()) {
                    sb.append((CharSequence) ",");
                    Object next2 = it.next();
                    next2.getClass();
                    sb.append(next2 instanceof CharSequence ? (CharSequence) next2 : next2.toString());
                }
            }
            zzjbVar.a(strZza, sb.toString());
            Integer numZzg = nonceRequest.zzg();
            if (numZzg != null) {
                String strZza2 = zzak.PLAYER_HEIGHT.zza();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(numZzg);
                zzjbVar.a(strZza2, sb2.toString());
            }
            Integer numZzh = nonceRequest.zzh();
            if (numZzh != null) {
                String strZza3 = zzak.PLAYER_WIDTH.zza();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(numZzh);
                zzjbVar.a(strZza3, sb3.toString());
            }
            if (numZzg != null && numZzh != null) {
                zzjbVar.a(zzak.ORIENTATION.zza(), numZzg.intValue() <= numZzh.intValue() ? "l" : "p");
            }
            Boolean boolZzd = nonceRequest.zzd();
            if (boolZzd != null) {
                zzjbVar.a(zzak.PLAY_ACTIVATION.zza(), true != boolZzd.booleanValue() ? "click" : "auto");
            }
            zzjbVar.a(zzak.WTA_SUPPORTED.zza(), true != nonceRequest.zzc().booleanValue() ? "0" : "1");
            Boolean boolZze = nonceRequest.zze();
            if (boolZze != null) {
                zzjbVar.a(zzak.PLAY_MUTED.zza(), true == boolZze.booleanValue() ? "1" : "0");
            }
            Boolean boolZzb = nonceRequest.zzb();
            if (boolZzb != null) {
                zzjbVar.a(zzak.CONTINUOUS_PLAYBACK.zza(), true == boolZzb.booleanValue() ? "2" : "1");
            }
            zzjbVar.a(zzak.SESSION_ID.zza(), nonceRequest.zzp());
            final zzjb zzjbVar2 = new zzjb();
            zzjbVar2.a(zzak.PAL_VERSION.zza(), zzat.zza);
            zzjbVar2.a(zzak.SDK_VERSION.zza(), zzh(this.zzc));
            zzjbVar2.a(zzak.APP_NAME.zza(), this.zzc.getApplicationContext().getPackageName());
            zzjbVar2.a(zzak.PAGE_CORRELATOR.zza(), this.zzo);
            zzjbVar2.a(zzak.AD_SPAM_CAPABILITIES.zza(), "3");
            zzjbVar2.a(zzak.SPAM_CORRELATOR.zza(), strZzf);
            final Task taskB = this.zzi.b();
            final Task taskB2 = this.zzj.b();
            final Task taskB3 = this.zzg.b();
            final Task taskB4 = this.zzh.b();
            final Task taskG = Tasks.h(taskB, taskB2, taskB3, taskB4).g(new Continuation() { // from class: com.google.ads.interactivemedia.pal.zzae
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return NonceLoader.zzb(zzjbVar2, taskB, taskB2, taskB3, taskB4, task);
                }
            });
            PlatformSignalCollector platformSignalCollectorZza = nonceRequest.zza();
            final Task<Map<String, String>> taskE = platformSignalCollectorZza == null ? Tasks.e(zzjc.b()) : platformSignalCollectorZza.collectSignals(this.zzc, Executors.newSingleThreadExecutor());
            final Task taskB5 = this.zzk.b();
            final long jCurrentTimeMillis = DefaultClock.getInstance().currentTimeMillis();
            return Tasks.h(taskG, taskB5, taskE).h(Executors.newSingleThreadExecutor(), new Continuation() { // from class: com.google.ads.interactivemedia.pal.zzz
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return this.zza.zza(zzjbVar, taskG, taskE, taskB5, nonceRequest, strZzf, jCurrentTimeMillis, task);
                }
            }).c(new OnFailureListener() { // from class: com.google.ads.interactivemedia.pal.zzaa
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    this.zza.zzc(exc);
                }
            });
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public void release() {
        this.zzg.f37538c.removeCallbacksAndMessages(null);
        this.zzh.f37538c.removeCallbacksAndMessages(null);
        this.zzi.f37538c.removeCallbacksAndMessages(null);
        this.zzj.f37538c.removeCallbacksAndMessages(null);
        this.zzk.f37538c.removeCallbacksAndMessages(null);
    }

    public final NonceManager zza(zzjb zzjbVar, Task task, Task task2, Task task3, NonceRequest nonceRequest, String str, long j2, Task task4) throws Exception {
        zzjbVar.b((Map) task.l());
        if (task2.p()) {
            zzjbVar.b((Map) task2.l());
        }
        zzba zzbaVar = (zzba) ((zzil) task3.l()).b();
        zzjc zzjcVarC = zzjbVar.c();
        StringBuilder sb = new StringBuilder();
        zzjd zzjdVarF = zzjcVarC.f37828a;
        if (zzjdVarF == null) {
            zzjdVarF = zzjcVarC.f();
            zzjcVarC.f37828a = zzjdVarF;
        }
        zzjl it = zzjdVarF.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry.getValue() != null && ((String) entry.getValue()).length() != 0) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append((String) entry.getKey());
                sb.append("=");
                sb.append((String) entry.getValue());
            }
        }
        String strA = zzbaVar.a(sb.toString());
        Integer numZzf = nonceRequest.zzf();
        if (numZzf != null && strA.length() > numZzf.intValue()) {
            Log.e("NonceGenerator", "Nonce length limit crossed.");
            throw NonceLoaderException.zzb(104);
        }
        String strZzh = zzh(this.zzc);
        String str2 = this.zzo;
        zze zzeVar = new zze();
        zzeVar.zzb(zzat.zza);
        zzeVar.zzc(strZzh);
        zzeVar.zza(str2);
        zzax zzaxVar = new zzax(new zzs(zzeVar.zzd()), str);
        int length = strA.length();
        zzh zzhVar = new zzh();
        zzagc zzagcVar = zzagc.f37519b;
        zzhVar.zzc(zzagcVar);
        zzhVar.zzd(zzagc.a(j2 - this.zzm));
        zzhVar.zzb(zzagc.a(DefaultClock.getInstance().currentTimeMillis() - this.zzm));
        zzhVar.zzf(zzagcVar);
        zzhVar.zze(zzagc.a(this.zzn - this.zzm));
        zzhVar.zza(length);
        this.zzl.zzb(zzhVar.zzg());
        return new NonceManager(this.zzc, zzaj.zza(), Executors.newSingleThreadExecutor(), this.zzf, zzaxVar, strA);
    }

    public final /* synthetic */ void zzc(Exception exc) {
        if (exc instanceof NonceLoaderException) {
            this.zzl.zza(((NonceLoaderException) exc).zza());
        } else {
            this.zzl.zza(100);
        }
    }

    public final /* synthetic */ void zzd(Task task) {
        this.zzn = DefaultClock.getInstance().currentTimeMillis();
    }
}
