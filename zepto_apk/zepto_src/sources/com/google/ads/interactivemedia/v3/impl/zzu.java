package com.google.ads.interactivemedia.v3.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.webkit.WebView;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.e;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdsLoader;
import com.google.ads.interactivemedia.v3.api.AdsManagerLoadedEvent;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.BaseDisplayContainer;
import com.google.ads.interactivemedia.v3.api.BaseRequest;
import com.google.ads.interactivemedia.v3.api.ImaSdkFactory;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.StreamRequest;
import com.google.ads.interactivemedia.v3.api.signals.SecureSignals;
import com.google.ads.interactivemedia.v3.impl.JavaScriptMessage;
import com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration;
import com.google.ads.interactivemedia.v3.impl.data.zzby;
import com.google.ads.interactivemedia.v3.impl.data.zzcf;
import com.google.ads.interactivemedia.v3.impl.data.zzcq;
import com.google.ads.interactivemedia.v3.impl.data.zzcy;
import com.google.ads.interactivemedia.v3.internal.zzdt;
import com.google.ads.interactivemedia.v3.internal.zzdx;
import com.google.ads.interactivemedia.v3.internal.zzdy;
import com.google.ads.interactivemedia.v3.internal.zzec;
import com.google.ads.interactivemedia.v3.internal.zzee;
import com.google.ads.interactivemedia.v3.internal.zzeh;
import com.google.ads.interactivemedia.v3.internal.zzel;
import com.google.ads.interactivemedia.v3.internal.zzeo;
import com.google.ads.interactivemedia.v3.internal.zzer;
import com.google.ads.interactivemedia.v3.internal.zzff;
import com.google.ads.interactivemedia.v3.internal.zzfi;
import com.google.ads.interactivemedia.v3.internal.zzon;
import com.google.ads.interactivemedia.v3.internal.zzoy;
import com.google.ads.interactivemedia.v3.internal.zzpg;
import com.google.ads.interactivemedia.v3.internal.zzqf;
import com.google.ads.interactivemedia.v3.internal.zzqi;
import com.google.ads.interactivemedia.v3.internal.zzsr;
import com.google.ads.interactivemedia.v3.internal.zzta;
import com.google.ads.interactivemedia.v3.internal.zztb;
import com.google.ads.interactivemedia.v3.internal.zztg;
import com.google.ads.interactivemedia.v3.internal.zzth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import in.juspay.hyper.constants.LogSubCategory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes3.dex */
public final class zzu implements AdsLoader {
    private final Context zza;
    private final zzth zzb;
    private final zzav zzc;
    private final zzar zzd;
    private final zzak zze;
    private final List zzf;
    private final Map zzg;
    private final Map zzh;
    private final zzbm zzi;
    private final ImaSdkSettings zzj;
    private final BaseDisplayContainer zzk;
    private final zzer zzl;
    private final zzff zzm;
    private final zzfi zzn;
    private final zztb zzo;
    private final zzel zzp;
    private final TestingConfiguration zzq;
    private zzdy zzr;

    @UiThread
    public zzu(Context context, Uri uri, ImaSdkSettings imaSdkSettings, BaseDisplayContainer baseDisplayContainer, zzec zzecVar, ExecutorService executorService) {
        Handler handler = new Handler(Looper.getMainLooper());
        zzecVar.zze(zzby.EVENT_NATIVE_WEBVIEW_CONSTRUCTOR_START);
        WebView webView = new WebView(context);
        zzecVar.zze(zzby.EVENT_NATIVE_WEBVIEW_CONSTRUCTOR_END);
        zzav zzavVar = new zzav(zzbc.zzb(handler, webView, uri), context, uri, imaSdkSettings, executorService);
        this.zzb = zzth.zzp();
        this.zzd = new zzr(this);
        this.zzf = Collections.synchronizedList(new ArrayList(1));
        this.zzg = new HashMap();
        this.zzh = new HashMap();
        this.zzc = zzavVar;
        this.zza = context;
        this.zzj = imaSdkSettings == null ? ImaSdkFactory.getInstance().createImaSdkSettings() : imaSdkSettings;
        this.zzk = baseDisplayContainer;
        zztb zztbVarZza = zztg.zza(executorService);
        this.zzo = zztbVarZza;
        TestingConfiguration testingConfig = imaSdkSettings.getTestingConfig();
        this.zzq = testingConfig;
        zzbm zzbmVar = new zzbm(zzavVar, context);
        this.zzi = zzbmVar;
        zzel zzelVar = new zzel(zzavVar, zzecVar);
        this.zzp = zzelVar;
        this.zze = new zzak(zzelVar);
        zzavVar.zzh(zzbmVar);
        baseDisplayContainer.claim();
        this.zzl = new zzer(context, zztbVarZza, zzelVar, testingConfig);
        this.zzm = new zzff(context, zztbVarZza, zzelVar);
        this.zzn = new zzfi(context, zztbVarZza, zzelVar);
    }

    public static /* bridge */ /* synthetic */ void zzl(zzu zzuVar, AdsManagerLoadedEvent adsManagerLoadedEvent) {
        Iterator it = zzuVar.zzf.iterator();
        while (it.hasNext()) {
            ((AdsLoader.AdsLoadedListener) it.next()).onAdsManagerLoaded(adsManagerLoadedEvent);
        }
    }

    public static final Object zzr(Future future) {
        if (future == null) {
            return null;
        }
        try {
            return zzsr.zzb(future);
        } catch (Exception e2) {
            zzeo.zzb("Error during initialization", e2);
            return null;
        } catch (Throwable th) {
            zzeo.zzb("Error during initialization", new Exception(th));
            return null;
        }
    }

    public static final Object zzs(Future future, Object obj) {
        return zzoy.zzf(zzr(future)).zzb(obj);
    }

    private final zzs zzt() throws PackageManager.NameNotFoundException {
        ActivityInfo activityInfo;
        PackageManager packageManager = this.zza.getPackageManager();
        ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.ads.interactivemedia.v3")), 65536);
        if (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo != null) {
                return zzs.create(packageInfo.versionCode, activityInfo.packageName);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final zzcy zzu() {
        NetworkCapabilities networkCapabilities;
        Integer numValueOf;
        Map<String, String> featureFlags;
        boolean z;
        if (this.zza.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.zza.getSystemService("connectivity");
            if (connectivityManager != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) != null) {
                numValueOf = Integer.valueOf(networkCapabilities.getLinkDownstreamBandwidthKbps());
            }
            featureFlags = this.zzj.getFeatureFlags();
            z = false;
            if (featureFlags != null && featureFlags.get("NATIVE_UI") != null) {
                z = true;
            }
            if (numValueOf == null || z) {
                return zzcy.create(numValueOf, z);
            }
            return null;
        }
        zzeo.zzd("Host application doesn't have ACCESS_NETWORK_STATE permission");
        numValueOf = null;
        featureFlags = this.zzj.getFeatureFlags();
        z = false;
        if (featureFlags != null) {
            z = true;
        }
        if (numValueOf == null) {
        }
        return zzcy.create(numValueOf, z);
    }

    private final zzta zzv(final BaseRequest baseRequest, final zzcf zzcfVar, final String str) {
        this.zzp.zzg(zzby.EVENT_NATIVE_SIGNAL_COLLECTION_START, str);
        final zzeh zzehVar = new zzeh(this.zza, new zzee(zzcfVar), this.zzp, this.zzj.getFeatureFlags(), this.zzq);
        final zzta zztaVarZza = this.zzo.zza(new Callable() { // from class: com.google.ads.interactivemedia.v3.impl.zzn
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzehVar.zza(baseRequest, str);
            }
        });
        this.zzp.zze(zztaVarZza, zzby.EVENT_NATIVE_SIGNAL_COLLECTION_ADID_READY, this.zzo, str);
        final zzta zztaVarZza2 = this.zzo.zza(new Callable() { // from class: com.google.ads.interactivemedia.v3.impl.zzo
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzh(zzcfVar);
            }
        });
        this.zzp.zze(zztaVarZza2, zzby.EVENT_NATIVE_SIGNAL_COLLECTION_ADSHIELD_READY, this.zzo, str);
        final zzff zzffVar = this.zzm;
        Objects.requireNonNull(zzffVar);
        final zzta zztaVarZza3 = this.zzo.zza(new Callable() { // from class: com.google.ads.interactivemedia.v3.impl.zzp
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzffVar.zze();
            }
        });
        this.zzp.zze(zztaVarZza3, zzby.EVENT_NATIVE_SIGNAL_COLLECTION_ESP_READY, this.zzo, str);
        final zzta zztaVarZza4 = zzon.zza(this.zzl.zza(), null);
        this.zzp.zze(zztaVarZza4, zzby.EVENT_NATIVE_SIGNAL_COLLECTION_PLATFORM_SIGNAL_READY, this.zzo, str);
        return zzsr.zza(zztaVarZza, zztaVarZza2, zztaVarZza3, zztaVarZza4).zza(new Callable() { // from class: com.google.ads.interactivemedia.v3.impl.zzq
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc(baseRequest, zztaVarZza3, str, zztaVarZza, zztaVarZza2, zztaVarZza4);
            }
        }, this.zzo);
    }

    private final String zzw() {
        TestingConfiguration testingConfiguration = this.zzq;
        if (testingConfiguration == null || !testingConfiguration.ignoreStrictModeFalsePositives()) {
            return UUID.randomUUID().toString();
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().build());
        String string = UUID.randomUUID().toString();
        StrictMode.setThreadPolicy(threadPolicy);
        return string;
    }

    private final String zzx() {
        return e.p(LogSubCategory.LifeCycle.ANDROID, Build.VERSION.RELEASE, ":3.33.0:", this.zza.getPackageName());
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsLoader
    public final void addAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener) {
        this.zze.zza(adErrorListener);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsLoader
    public final void addAdsLoadedListener(AdsLoader.AdsLoadedListener adsLoadedListener) {
        this.zzf.add(adsLoadedListener);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsLoader
    public final void contentComplete() {
        this.zzc.zzp(new JavaScriptMessage(JavaScriptMessage.MsgChannel.adsLoader, JavaScriptMessage.MsgType.contentComplete, "*", null));
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsLoader
    public final ImaSdkSettings getSettings() {
        return this.zzj;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsLoader
    public final void release() {
        this.zzk.destroy();
        zzav zzavVar = this.zzc;
        if (zzavVar != null) {
            zzavVar.zzm();
        }
        this.zzg.clear();
        this.zzf.clear();
        this.zze.zzb();
        this.zzh.clear();
        this.zzp.zza();
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsLoader
    public final void removeAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener) {
        this.zze.zzd(adErrorListener);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsLoader
    public final void removeAdsLoadedListener(AdsLoader.AdsLoadedListener adsLoadedListener) {
        this.zzf.remove(adsLoadedListener);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsLoader
    public final void requestAds(final AdsRequest adsRequest) {
        final String strZzw = zzw();
        this.zzp.zzg(zzby.EVENT_NATIVE_API_ADSLOADER_REQUEST_START, strZzw);
        this.zzb.zzm(new Runnable() { // from class: com.google.ads.interactivemedia.v3.impl.zzl
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzq(adsRequest, strZzw);
            }
        }, this.zzo);
        this.zzp.zzg(zzby.EVENT_NATIVE_API_ADSLOADER_REQUEST_END, strZzw);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsLoader
    public final String requestStream(final StreamRequest streamRequest) {
        final String strZzw = zzw();
        this.zzp.zzg(zzby.EVENT_NATIVE_API_ADSLOADER_REQUEST_START, strZzw);
        this.zzb.zzm(new Runnable() { // from class: com.google.ads.interactivemedia.v3.impl.zzi
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzi(streamRequest, strZzw);
            }
        }, this.zzo);
        this.zzp.zzg(zzby.EVENT_NATIVE_API_ADSLOADER_REQUEST_END, strZzw);
        return strZzw;
    }

    public final /* synthetic */ zzt zzc(BaseRequest baseRequest, zzta zztaVar, String str, zzta zztaVar2, zzta zztaVar3, zzta zztaVar4) throws Exception {
        SecureSignals secureSignals = baseRequest.getSecureSignals();
        List list = (List) zzs(zztaVar, new ArrayList());
        if (secureSignals != null) {
            list.add(zzcq.createBy1stPartyData(secureSignals));
        }
        this.zzp.zzg(zzby.EVENT_NATIVE_SIGNAL_COLLECTION_ALL_SIGNALS_READY, str);
        com.google.ads.interactivemedia.v3.impl.data.zzbv zzbvVar = (com.google.ads.interactivemedia.v3.impl.data.zzbv) zzsr.zzb(zztaVar2);
        return new zzz(zzoy.zzg(zzbvVar), (String) zzsr.zzb(zztaVar3), zzqf.zzk(list), zzqi.zzc((Map) zzs(zztaVar4, new HashMap())));
    }

    public final /* synthetic */ String zzh(zzcf zzcfVar) throws Exception {
        return this.zzn.zza(zzcfVar.msParameterTimeoutMs);
    }

    @VisibleForTesting
    public final String zzi(final StreamRequest streamRequest, final String str) {
        zzd zzdVar;
        zzcf zzcfVar = (zzcf) zzr(this.zzb);
        if (zzcfVar == null) {
            zzdVar = new zzd(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Error initializing the SDK."), new Object());
        } else if (streamRequest == null) {
            zzdVar = new zzd(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "StreamRequest cannot be null."));
        } else {
            BaseDisplayContainer baseDisplayContainer = this.zzk;
            zzdVar = !(baseDisplayContainer instanceof StreamDisplayContainer) ? new zzd(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "AdsLoader must be constructed with StreamDisplayContainer.")) : ((StreamDisplayContainer) baseDisplayContainer).getVideoStreamPlayer() == null ? new zzd(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "Stream requests must specify a player.")) : null;
        }
        if (zzdVar != null) {
            this.zze.zzc(zzdVar);
            return str;
        }
        this.zzh.put(str, streamRequest);
        this.zzc.zzf(this.zzd, str);
        this.zzc.zze(this.zzk, str);
        final zzta zztaVarZzv = zzv(streamRequest, zzcfVar, str);
        zztaVarZzv.zzm(new Runnable() { // from class: com.google.ads.interactivemedia.v3.impl.zzj
            @Override // java.lang.Runnable
            public final void run() throws PackageManager.NameNotFoundException {
                this.zza.zzo(zztaVarZzv, streamRequest, str);
            }
        }, this.zzo);
        return str;
    }

    public final /* synthetic */ void zzm(Task task) {
        List<String> list;
        zzcf zzcfVar = (zzcf) task.l();
        this.zzp.zzh(zzcfVar.enableInstrumentation);
        Integer num = zzcfVar.espAdapterTimeoutMs;
        if (num != null && (list = zzcfVar.espAdapters) != null) {
            this.zzm.zzc(list, num);
            this.zzm.zzb();
        }
        this.zzl.zzb(zzcfVar.platformSignalCollectorTimeoutMs);
        this.zzr = new zzdy(this.zza, zzdx.zza(zzcfVar), this.zzp);
        this.zzb.zzc(zzcfVar);
        this.zzp.zzf(zzby.EVENT_NATIVE_CORE_JS_LOAD_READY);
    }

    public final /* synthetic */ void zzn(zzta zztaVar, AdDisplayContainer adDisplayContainer, AdsRequest adsRequest, String str) throws PackageManager.NameNotFoundException {
        zzt zztVar = (zzt) zzs(zztaVar, zzt.zza());
        com.google.ads.interactivemedia.v3.impl.data.zzbv zzbvVar = (com.google.ads.interactivemedia.v3.impl.data.zzbv) zztVar.zzb().zzc();
        String strZze = zztVar.zze();
        zzqf zzqfVarZzc = zztVar.zzc();
        zzqi zzqiVarZzd = zztVar.zzd();
        zzdy zzdyVar = this.zzr;
        zzdyVar.getClass();
        Map mapZza = zzdyVar.zza();
        String strZzx = zzx();
        zzcy zzcyVarZzu = zzu();
        ImaSdkSettings imaSdkSettings = this.zzj;
        zzs zzsVarZzt = zzt();
        Context context = this.zza;
        TestingConfiguration testingConfiguration = this.zzq;
        JavaScriptMessage javaScriptMessage = new JavaScriptMessage(JavaScriptMessage.MsgChannel.adsLoader, JavaScriptMessage.MsgType.requestAds, str, com.google.ads.interactivemedia.v3.impl.data.zzbr.create(adsRequest, strZzx, mapZza, zzqfVarZzc, zzqiVarZzd, "android:0", zzcyVarZzu, imaSdkSettings, zzsVarZzt, zzdt.zzc(context, testingConfiguration), zzdt.zzb(context, testingConfiguration), strZze, zzbvVar, adDisplayContainer));
        this.zzc.zzj(zzbvVar);
        this.zzc.zzp(javaScriptMessage);
        this.zzp.zzg(zzby.EVENT_NATIVE_REQUEST_START, str);
    }

    public final /* synthetic */ void zzo(zzta zztaVar, StreamRequest streamRequest, String str) throws PackageManager.NameNotFoundException {
        zzt zztVar = (zzt) zzs(zztaVar, zzt.zza());
        StreamDisplayContainer streamDisplayContainer = (StreamDisplayContainer) this.zzk;
        com.google.ads.interactivemedia.v3.impl.data.zzbv zzbvVar = (com.google.ads.interactivemedia.v3.impl.data.zzbv) zztVar.zzb().zzc();
        String strZze = zztVar.zze();
        zzqf zzqfVarZzc = zztVar.zzc();
        zzqi zzqiVarZzd = zztVar.zzd();
        zzdy zzdyVar = this.zzr;
        zzdyVar.getClass();
        Map mapZza = zzdyVar.zza();
        String strZzx = zzx();
        zzcy zzcyVarZzu = zzu();
        ImaSdkSettings imaSdkSettings = this.zzj;
        zzs zzsVarZzt = zzt();
        Context context = this.zza;
        TestingConfiguration testingConfiguration = this.zzq;
        JavaScriptMessage javaScriptMessage = new JavaScriptMessage(JavaScriptMessage.MsgChannel.adsLoader, JavaScriptMessage.MsgType.requestStream, str, com.google.ads.interactivemedia.v3.impl.data.zzbr.createFromStreamRequest(streamRequest, strZzx, mapZza, zzqfVarZzc, zzqiVarZzd, "android:0", zzcyVarZzu, imaSdkSettings, zzsVarZzt, zzdt.zzc(context, testingConfiguration), zzdt.zzb(context, testingConfiguration), strZze, zzbvVar, streamDisplayContainer));
        this.zzc.zzj(zzbvVar);
        this.zzc.zzp(javaScriptMessage);
        this.zzp.zzg(zzby.EVENT_NATIVE_REQUEST_START, str);
    }

    public final void zzp() {
        this.zzp.zzf(zzby.EVENT_NATIVE_CORE_JS_LOAD_START);
        this.zzc.zzc().b(this.zzo, new OnCompleteListener() { // from class: com.google.ads.interactivemedia.v3.impl.zzk
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.zza.zzm(task);
            }
        });
    }

    @VisibleForTesting
    public final void zzq(final AdsRequest adsRequest, final String str) {
        zzd zzdVar;
        zzcf zzcfVar = (zzcf) zzr(this.zzb);
        if (zzcfVar == null) {
            zzdVar = new zzd(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Error initializing the SDK."), new Object());
        } else if (adsRequest == null) {
            zzdVar = new zzd(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "AdsRequest cannot be null."));
        } else {
            BaseDisplayContainer baseDisplayContainer = this.zzk;
            zzdVar = !(baseDisplayContainer instanceof AdDisplayContainer) ? new zzd(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "AdsLoader must be constructed with AdDisplayContainer.")) : baseDisplayContainer.getAdContainer() == null ? new zzd(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "Ad display container must have a UI container.")) : (zzpg.zzc(adsRequest.getAdTagUrl()) && zzpg.zzc(adsRequest.getAdsResponse())) ? new zzd(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INVALID_ARGUMENTS, "Either ad tag url or ads response must non-null and non empty.")) : null;
        }
        if (zzdVar != null) {
            this.zze.zzc(zzdVar);
            return;
        }
        final AdDisplayContainer adDisplayContainer = (AdDisplayContainer) this.zzk;
        if (adDisplayContainer.getPlayer() == null) {
            this.zze.zzc(new zzd(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.ADS_PLAYER_NOT_PROVIDED, "VideoAdPlayer must be set on AdDisplayContainer before requesting ads."), new Object()));
            return;
        }
        this.zzg.put(str, adsRequest);
        this.zzc.zzf(this.zzd, str);
        this.zzc.zze(adDisplayContainer, str);
        final zzta zztaVarZzv = zzv(adsRequest, zzcfVar, str);
        zztaVarZzv.zzm(new Runnable() { // from class: com.google.ads.interactivemedia.v3.impl.zzm
            @Override // java.lang.Runnable
            public final void run() throws PackageManager.NameNotFoundException {
                this.zza.zzn(zztaVarZzv, adDisplayContainer, adsRequest, str);
            }
        }, this.zzo);
    }
}
