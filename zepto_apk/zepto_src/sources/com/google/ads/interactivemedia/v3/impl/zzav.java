package com.google.ads.interactivemedia.v3.impl;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.media.b;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.fragment.app.e;
import androidx.webkit.WebViewFeature;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.BaseDisplayContainer;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.impl.JavaScriptMessage;
import com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration;
import com.google.ads.interactivemedia.v3.impl.data.zzcf;
import com.google.ads.interactivemedia.v3.internal.zzek;
import com.google.ads.interactivemedia.v3.internal.zzeo;
import com.google.ads.interactivemedia.v3.internal.zzop;
import com.google.ads.interactivemedia.v3.internal.zzoq;
import com.google.ads.interactivemedia.v3.internal.zzqi;
import com.google.ads.interactivemedia.v3.internal.zzqs;
import com.google.ads.interactivemedia.v3.internal.zzty;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import in.juspay.airborne.ota.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes3.dex */
public final class zzav implements zzaz, zzba {
    private final Context zzg;
    private final String zzh;
    private final zzbc zzi;
    private final float zzk;
    private final ExecutorService zzl;

    @Nullable
    private final TestingConfiguration zzm;

    @Nullable
    private zzbk zzp;

    @Nullable
    private zzau zzq;
    private long zzr;
    private final Map zza = new HashMap();
    private final Set zzb = new HashSet();
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private final Map zze = new HashMap();
    private final Map zzf = new HashMap();
    private final Queue zzj = new ConcurrentLinkedQueue();
    private final TaskCompletionSource zzn = new TaskCompletionSource();
    private final TaskCompletionSource zzo = new TaskCompletionSource();
    private boolean zzs = false;

    @UiThread
    public zzav(zzbc zzbcVar, Context context, Uri uri, ImaSdkSettings imaSdkSettings, ExecutorService executorService) {
        this.zzg = context;
        this.zzk = context.getResources().getDisplayMetrics().density;
        boolean zA = WebViewFeature.a("WEB_MESSAGE_LISTENER");
        Uri.Builder builderAppendQueryParameter = uri.buildUpon().appendQueryParameter("sdk_version", "a.3.33.0").appendQueryParameter("hl", imaSdkSettings.getLanguage()).appendQueryParameter("omv", "1.4.10-google_20240110").appendQueryParameter(Constants.APP_DIR, context.getApplicationContext().getPackageName());
        builderAppendQueryParameter.appendQueryParameter("mt", true != zA ? "0" : "4");
        if (imaSdkSettings.getTestingConfig() != null) {
            zzty zztyVar = new zzty();
            zztyVar.zzc(new zzoq());
            zztyVar.zzd(new zzop());
            builderAppendQueryParameter.appendQueryParameter(TestingConfiguration.PARAMETER_KEY, zztyVar.zza().zzf(imaSdkSettings.getTestingConfig()));
        }
        this.zzh = builderAppendQueryParameter.build().toString();
        this.zzm = imaSdkSettings.getTestingConfig();
        this.zzi = zzbcVar;
        zzbcVar.zzh(this);
        this.zzl = executorService;
    }

    @Nullable
    private final zzat zzq(JavaScriptMessage.MsgType msgType, String str) {
        zzat zzatVar = (zzat) this.zze.get(str);
        if (zzatVar != null) {
            return zzatVar;
        }
        zzeo.zzd("Received manager message: " + String.valueOf(msgType) + " for invalid session id: " + str);
        return null;
    }

    private static String zzr(String str, String str2) {
        return (str2 == null || str2.length() == 0) ? str : b.l(str, " Caused by: ", str2);
    }

    private final void zzs(JavaScriptMessage.MsgChannel msgChannel, JavaScriptMessage.MsgType msgType, String str, zzcf zzcfVar) {
        zzbv zzbvVar = (zzbv) this.zzf.get(str);
        if (zzbvVar != null) {
            zzbvVar.zzf(msgChannel, msgType, zzcfVar);
            return;
        }
        StringBuilder sbV = e.v("Received ", String.valueOf(msgChannel), " message: ", String.valueOf(msgType), " for invalid session id: ");
        sbV.append(str);
        zzeo.zzd(sbV.toString());
    }

    private static final void zzt(String str, JavaScriptMessage.MsgType msgType) {
        zzeo.zzc("Illegal message type " + String.valueOf(msgType) + " received for " + str + " channel");
    }

    public final WebView zza() {
        return this.zzi.zza();
    }

    @Nullable
    public final TestingConfiguration zzb() {
        return this.zzm;
    }

    @UiThread
    public final Task zzc() {
        Tasks.h(this.zzo.f39750a, this.zzn.f39750a).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.ads.interactivemedia.v3.impl.zzap
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.zza.zzk(task);
            }
        });
        this.zzr = SystemClock.elapsedRealtime();
        this.zzi.zzf(this.zzh);
        return this.zzo.f39750a;
    }

    public final void zzd(zzaq zzaqVar, String str) {
        this.zza.put(str, zzaqVar);
    }

    public final void zze(BaseDisplayContainer baseDisplayContainer, String str) {
        this.zzc.put(str, baseDisplayContainer);
    }

    public final void zzf(zzar zzarVar, String str) {
        this.zzd.put(str, zzarVar);
    }

    public final void zzg(zzat zzatVar, String str) {
        this.zze.put(str, zzatVar);
    }

    public final void zzh(zzau zzauVar) {
        this.zzq = zzauVar;
    }

    public final void zzi(zzbv zzbvVar, String str) {
        this.zzf.put(str, zzbvVar);
    }

    public final void zzj(com.google.ads.interactivemedia.v3.impl.data.zzbv zzbvVar) {
        this.zzn.d(zzbvVar);
    }

    public final void zzk(Task task) {
        zzcf zzcfVar = (zzcf) this.zzo.f39750a.l();
        com.google.ads.interactivemedia.v3.impl.data.zzbv zzbvVar = (com.google.ads.interactivemedia.v3.impl.data.zzbv) this.zzn.f39750a.l();
        boolean z = zzcfVar.enableGks;
        Context context = this.zzg;
        this.zzp = new zzbk(context, this, this.zzl, z ? new zzbj(context, zzbvVar) : new zzbh(null));
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzaz
    public final void zzl(JavaScriptMessage javaScriptMessage) {
        com.google.ads.interactivemedia.v3.impl.data.zzc zzcVar;
        Map<String, com.google.ads.interactivemedia.v3.impl.data.zzbk> map;
        String str;
        String str2;
        zzcf zzcfVar = (zzcf) javaScriptMessage.zzc();
        String strZzd = javaScriptMessage.zzd();
        JavaScriptMessage.MsgType msgTypeZzb = javaScriptMessage.zzb();
        zzeo.zzc("Received js message: " + javaScriptMessage.zza().name() + " [" + msgTypeZzb.name() + "]");
        switch (javaScriptMessage.zza()) {
            case activityMonitor:
                if (!this.zzb.contains(strZzd)) {
                    zzaq zzaqVar = (zzaq) this.zza.get(strZzd);
                    if (zzaqVar == null) {
                        zzeo.zzd("Received monitor message: " + String.valueOf(msgTypeZzb) + " for invalid session id: " + strZzd);
                        break;
                    } else if (zzcfVar == null) {
                        zzeo.zzd("Received monitor message: " + String.valueOf(msgTypeZzb) + " for session id: " + strZzd + " with no data");
                        break;
                    } else if (msgTypeZzb.ordinal() != 37) {
                        zzt(JavaScriptMessage.MsgChannel.activityMonitor.toString(), msgTypeZzb);
                        break;
                    } else {
                        zzaqVar.zzh(zzcfVar.queryId, zzcfVar.eventId);
                        break;
                    }
                }
                break;
            case adsLoader:
                zzar zzarVar = (zzar) this.zzd.get(strZzd);
                if (zzarVar == null) {
                    zzeo.zza("Received request message: " + String.valueOf(msgTypeZzb) + " for invalid session id: " + strZzd);
                    break;
                } else {
                    int iOrdinal = msgTypeZzb.ordinal();
                    if (iOrdinal != 11) {
                        if (iOrdinal != 31) {
                            if (iOrdinal != 71) {
                                zzt(JavaScriptMessage.MsgChannel.adsLoader.toString(), msgTypeZzb);
                                break;
                            } else {
                                zzarVar.zzd(strZzd, zzcfVar.streamId, zzcfVar.monitorAppLifecycle);
                                zzeo.zzc("Stream initialized with streamId: ".concat(String.valueOf(zzcfVar.streamId)));
                                break;
                            }
                        } else {
                            zzarVar.zza(strZzd, AdError.AdErrorType.LOAD, zzcfVar.errorCode, zzr(zzcfVar.errorMessage, zzcfVar.innerError));
                            break;
                        }
                    } else if (zzcfVar == null) {
                        zzarVar.zzb(strZzd, AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "adsLoaded message did not contain cue points.");
                        break;
                    } else {
                        zzarVar.zzc(strZzd, zzcfVar.adCuePoints, zzcfVar.internalCuePoints, zzcfVar.monitorAppLifecycle);
                        break;
                    }
                }
            case adsManager:
                zzat zzatVarZzq = zzq(msgTypeZzb, strZzd);
                if (zzatVarZzq != null) {
                    if (zzcfVar != null) {
                        zzcVar = zzcfVar.adData;
                        if (zzcVar == null) {
                            zzcVar = null;
                        }
                    } else {
                        zzcVar = null;
                        zzcfVar = null;
                    }
                    int iOrdinal2 = msgTypeZzb.ordinal();
                    if (iOrdinal2 != 20) {
                        if (iOrdinal2 != 21) {
                            if (iOrdinal2 != 31) {
                                if (iOrdinal2 != 32) {
                                    if (iOrdinal2 != 78) {
                                        if (iOrdinal2 != 79) {
                                            switch (iOrdinal2) {
                                                case 1:
                                                    zzatVarZzq.zzc(new zzas(AdEvent.AdEventType.AD_BREAK_ENDED, zzcVar));
                                                    break;
                                                case 2:
                                                    zzas zzasVar = new zzas(AdEvent.AdEventType.AD_BREAK_FETCH_ERROR, null);
                                                    zzasVar.zzc = zzqi.zze("adBreakTime", zzcfVar.adBreakTime);
                                                    zzatVarZzq.zzc(zzasVar);
                                                    break;
                                                case 3:
                                                    zzas zzasVar2 = new zzas(AdEvent.AdEventType.AD_BREAK_READY, null);
                                                    zzasVar2.zzc = zzqi.zze("adBreakTime", zzcfVar.adBreakTime);
                                                    zzatVarZzq.zzc(zzasVar2);
                                                    break;
                                                case 4:
                                                    zzatVarZzq.zzc(new zzas(AdEvent.AdEventType.AD_BREAK_STARTED, zzcVar));
                                                    break;
                                                case 5:
                                                    zzatVarZzq.zzc(new zzas(AdEvent.AdEventType.AD_BUFFERING, null));
                                                    break;
                                                case 6:
                                                case 7:
                                                    break;
                                                case 8:
                                                    zzatVarZzq.zzc(new zzas(AdEvent.AdEventType.AD_PERIOD_ENDED, null));
                                                    break;
                                                case 9:
                                                    zzatVarZzq.zzc(new zzas(AdEvent.AdEventType.AD_PERIOD_STARTED, null));
                                                    break;
                                                case 10:
                                                    zzas zzasVar3 = new zzas(AdEvent.AdEventType.AD_PROGRESS, zzcVar);
                                                    zzasVar3.zze = new zzh(zzcfVar.currentTime, zzcfVar.duration, zzcfVar.adPosition, zzcfVar.totalAds, zzcfVar.adBreakDuration, zzcfVar.adPeriodDuration, zzcfVar.adsDurationsMs);
                                                    zzatVarZzq.zzc(zzasVar3);
                                                    break;
                                                default:
                                                    switch (iOrdinal2) {
                                                        case 12:
                                                            zzatVarZzq.zzc(new zzas(AdEvent.AdEventType.ALL_ADS_COMPLETED, null));
                                                            break;
                                                        case 16:
                                                            zzatVarZzq.zzc(new zzas(AdEvent.AdEventType.CLICKED, zzcVar));
                                                            break;
                                                        case 18:
                                                            zzatVarZzq.zzc(new zzas(AdEvent.AdEventType.COMPLETED, zzcVar));
                                                            break;
                                                        case 25:
                                                            zzas zzasVar4 = new zzas(AdEvent.AdEventType.CUEPOINTS_CHANGED, null);
                                                            zzasVar4.zzd = new ArrayList();
                                                            for (com.google.ads.interactivemedia.v3.impl.data.zzbl zzblVar : zzcfVar.cuepoints) {
                                                                zzasVar4.zzd.add(new zzaj(zzblVar.start(), zzblVar.end(), zzblVar.played()));
                                                            }
                                                            zzatVarZzq.zzc(zzasVar4);
                                                            break;
                                                        case 40:
                                                            zzatVarZzq.zzc(new zzas(AdEvent.AdEventType.ICON_FALLBACK_IMAGE_CLOSED, null));
                                                            break;
                                                        case 42:
                                                        case 76:
                                                        case WKSRecord.Service.HOSTS2_NS /* 81 */:
                                                            break;
                                                        case 46:
                                                            if (zzcVar != null) {
                                                                zzatVarZzq.zzc(new zzas(AdEvent.AdEventType.LOADED, zzcVar));
                                                                break;
                                                            } else {
                                                                zzeo.zza("Ad loaded message requires adData");
                                                                zzatVarZzq.zzf(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Ad loaded message did not contain adData.");
                                                                break;
                                                            }
                                                        case 55:
                                                            zzatVarZzq.zzc(new zzas(AdEvent.AdEventType.PAUSED, zzcVar));
                                                            break;
                                                        case 64:
                                                            zzatVarZzq.zzc(new zzas(AdEvent.AdEventType.RESUMED, zzcVar));
                                                            break;
                                                        case WKSRecord.Service.NETRJS_2 /* 72 */:
                                                            zzatVarZzq.zzc(new zzas(AdEvent.AdEventType.THIRD_QUARTILE, zzcVar));
                                                            break;
                                                        default:
                                                            switch (iOrdinal2) {
                                                                case Type.DNSKEY /* 48 */:
                                                                    zzas zzasVar5 = new zzas(AdEvent.AdEventType.LOG, zzcVar);
                                                                    zzasVar5.zzc = zzcfVar.logData.constructMap();
                                                                    zzatVarZzq.zzc(zzasVar5);
                                                                    break;
                                                                case 49:
                                                                    zzatVarZzq.zzc(new zzas(AdEvent.AdEventType.MIDPOINT, zzcVar));
                                                                    break;
                                                                case 50:
                                                                    break;
                                                                case 51:
                                                                    zzatVarZzq.zzi(zzcfVar.url);
                                                                    break;
                                                                default:
                                                                    switch (iOrdinal2) {
                                                                        case WKSRecord.Protocol.RVD /* 66 */:
                                                                            zzas zzasVar6 = new zzas(AdEvent.AdEventType.SKIPPED, null);
                                                                            zzasVar6.zzg = zzcfVar.seekTime;
                                                                            zzatVarZzq.zzc(zzasVar6);
                                                                            break;
                                                                        case 67:
                                                                            zzatVarZzq.zzc(new zzas(AdEvent.AdEventType.SKIPPABLE_STATE_CHANGED, zzcVar));
                                                                            break;
                                                                        case WKSRecord.Service.BOOTPC /* 68 */:
                                                                            zzatVarZzq.zzc(new zzas(AdEvent.AdEventType.STARTED, zzcVar));
                                                                            break;
                                                                        default:
                                                                            zzt(JavaScriptMessage.MsgChannel.adsManager.toString(), msgTypeZzb);
                                                                            break;
                                                                    }
                                                            }
                                                    }
                                            }
                                        } else {
                                            zzas zzasVar7 = new zzas(AdEvent.AdEventType.ICON_TAPPED, null);
                                            if (zzcfVar != null) {
                                                zzasVar7.zzf = zzcfVar.iconClickFallbackImages;
                                            }
                                            zzatVarZzq.zzc(zzasVar7);
                                            break;
                                        }
                                    } else {
                                        zzatVarZzq.zzc(new zzas(AdEvent.AdEventType.TAPPED, zzcVar));
                                        break;
                                    }
                                } else {
                                    zzatVarZzq.zzc(new zzas(AdEvent.AdEventType.FIRST_QUARTILE, zzcVar));
                                    break;
                                }
                            } else {
                                zzatVarZzq.zze(AdError.AdErrorType.PLAY, zzcfVar.errorCode, zzr(zzcfVar.errorMessage, zzcfVar.innerError));
                                break;
                            }
                        } else {
                            zzatVarZzq.zzc(new zzas(AdEvent.AdEventType.CONTENT_RESUME_REQUESTED, null));
                            break;
                        }
                    } else {
                        zzatVarZzq.zzc(new zzas(AdEvent.AdEventType.CONTENT_PAUSE_REQUESTED, null));
                        break;
                    }
                }
                break;
            case contentTimeUpdate:
            case userInteraction:
            default:
                zzeo.zza("Unknown message channel: ".concat(String.valueOf(javaScriptMessage.zza())));
                break;
            case displayContainer:
                zzab zzabVar = (zzab) this.zzc.get(strZzd);
                zzat zzatVarZzq2 = zzq(msgTypeZzb, strZzd);
                zzbv zzbvVar = (zzbv) this.zzf.get(strZzd);
                if (zzabVar == null || zzatVarZzq2 == null || zzbvVar == null) {
                    zzeo.zza("Received displayContainer message: " + String.valueOf(msgTypeZzb) + " for invalid session id: " + strZzd);
                    break;
                } else {
                    int iOrdinal3 = msgTypeZzb.ordinal();
                    if (iOrdinal3 == 28) {
                        if (zzcfVar != null && (map = zzcfVar.companions) != null) {
                            Set<String> setKeySet = map.keySet();
                            HashMap mapZzb = zzqs.zzb(setKeySet.size());
                            for (String str3 : setKeySet) {
                                CompanionAdSlot companionAdSlot = (CompanionAdSlot) zzabVar.zza().get(str3);
                                ViewGroup container = companionAdSlot != null ? companionAdSlot.getContainer() : null;
                                if (container != null) {
                                    mapZzb.put(str3, container);
                                } else {
                                    zzatVarZzq2.zzf(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Display requested for invalid companion slot.");
                                }
                            }
                            for (String str4 : mapZzb.keySet()) {
                                zzat zzatVar = zzatVarZzq2;
                                zzatVar.zzj((ViewGroup) mapZzb.get(str4), zzcfVar.companions.get(str4), strZzd, (CompanionAdSlot) zzabVar.zza().get(str4), this, new zzek(this.zzl, this.zzk));
                                zzatVarZzq2 = zzatVar;
                            }
                            break;
                        } else {
                            zzatVarZzq2.zzf(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Display companions message requires companions in data.");
                            break;
                        }
                    } else if (iOrdinal3 != 38 && iOrdinal3 != 65) {
                        if (iOrdinal3 != 62) {
                            if (iOrdinal3 != 63) {
                                zzt(JavaScriptMessage.MsgChannel.displayContainer.toString(), msgTypeZzb);
                                break;
                            } else {
                                zzatVarZzq2.zzl();
                                break;
                            }
                        } else {
                            zzatVarZzq2.zzk(zzcfVar.resizeAndPositionVideo);
                            break;
                        }
                    }
                }
                break;
            case log:
            case webViewLoaded:
                int iOrdinal4 = msgTypeZzb.ordinal();
                if (iOrdinal4 != 44) {
                    if (iOrdinal4 != 48) {
                        zzt("other", msgTypeZzb);
                        break;
                    } else if (zzcfVar.ln != null && (str = zzcfVar.n) != null && (str2 = zzcfVar.f20500m) != null) {
                        String strP = e.p("JsMessage (", str, "): ", str2);
                        char cCharAt = zzcfVar.ln.charAt(0);
                        if (cCharAt != 'D') {
                            if (cCharAt != 'E') {
                                if (cCharAt != 'I') {
                                    if (cCharAt != 'S') {
                                        if (cCharAt != 'V') {
                                            if (cCharAt != 'W') {
                                                zzeo.zzd("Unrecognized log level: ".concat(String.valueOf(zzcfVar.ln)));
                                                zzeo.zzd(strP);
                                                break;
                                            } else {
                                                zzeo.zzd(strP);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            zzeo.zza(strP);
                            break;
                        }
                        zzeo.zzc(strP);
                        break;
                    } else {
                        zzeo.zza("Invalid logging message data: ".concat(String.valueOf(zzcfVar)));
                        break;
                    }
                } else {
                    this.zzo.d(zzcfVar);
                    this.zzs = true;
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - this.zzr;
                    HashMap mapZzb2 = zzqs.zzb(1);
                    mapZzb2.put("webViewLoadingTime", Long.valueOf(jElapsedRealtime));
                    zzp(new JavaScriptMessage(JavaScriptMessage.MsgChannel.webViewLoaded, JavaScriptMessage.MsgType.csi, strZzd, mapZzb2));
                    break;
                }
            case nativeUi:
                zzat zzatVarZzq3 = zzq(msgTypeZzb, strZzd);
                if (zzatVarZzq3 != null) {
                    ArrayList arrayList = new ArrayList();
                    com.google.ads.interactivemedia.v3.impl.data.zzbu zzbuVar = zzcfVar.iconsView;
                    if (zzbuVar != null && zzbuVar.icons() != null) {
                        Iterator<com.google.ads.interactivemedia.v3.impl.data.zzbt> it = zzcfVar.iconsView.icons().iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next());
                        }
                    }
                    zzatVarZzq3.zzm(new com.google.ads.interactivemedia.v3.impl.data.zze(this, arrayList, strZzd));
                    break;
                }
                break;
            case nativeXhr:
                zzbk zzbkVar = this.zzp;
                if (zzbkVar != null) {
                    zzbkVar.zzc(msgTypeZzb, strZzd, zzcfVar.networkRequest);
                    break;
                } else {
                    zzeo.zza("Native network handler not initialized.");
                    break;
                }
            case omid:
                if (this.zzq == null) {
                    zzeo.zza("Null 'omidManagerListener': cannot send 'onOmidMessage'.");
                    break;
                } else {
                    int iOrdinal5 = msgTypeZzb.ordinal();
                    if (iOrdinal5 == 53) {
                        this.zzq.zza();
                        break;
                    } else if (iOrdinal5 == 54) {
                        this.zzq.zzb();
                        break;
                    }
                }
                break;
            case videoDisplay1:
                zzs(JavaScriptMessage.MsgChannel.videoDisplay1, msgTypeZzb, strZzd, zzcfVar);
                break;
            case videoDisplay2:
                zzs(JavaScriptMessage.MsgChannel.videoDisplay2, msgTypeZzb, strZzd, zzcfVar);
                break;
        }
    }

    public final void zzm() {
        this.zzi.zzc();
    }

    public final void zzn(String str) {
        this.zza.remove(str);
        this.zzb.add(str);
    }

    public final void zzo(String str) {
        this.zzd.remove(str);
        this.zze.remove(str);
        this.zzc.remove(str);
        this.zzf.remove(str);
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzba
    public final void zzp(JavaScriptMessage javaScriptMessage) {
        zzeo.zzc("Sending js message: " + javaScriptMessage.zza().name() + " [" + javaScriptMessage.zzb().name() + "]");
        this.zzj.add(javaScriptMessage);
        if (this.zzs) {
            JavaScriptMessage javaScriptMessage2 = (JavaScriptMessage) this.zzj.poll();
            while (javaScriptMessage2 != null) {
                this.zzi.zzi(javaScriptMessage2);
                javaScriptMessage2 = (JavaScriptMessage) this.zzj.poll();
            }
        }
    }
}
