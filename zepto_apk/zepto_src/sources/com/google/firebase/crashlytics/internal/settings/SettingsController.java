package com.google.firebase.crashlytics.internal.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.support.v4.media.b;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.common.SystemCurrentTimeProvider;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsTasks;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SettingsController implements SettingsProvider {

    /* renamed from: a, reason: collision with root package name */
    public final Context f44435a;

    /* renamed from: b, reason: collision with root package name */
    public final SettingsRequest f44436b;

    /* renamed from: c, reason: collision with root package name */
    public final SettingsJsonParser f44437c;

    /* renamed from: d, reason: collision with root package name */
    public final SystemCurrentTimeProvider f44438d;

    /* renamed from: e, reason: collision with root package name */
    public final CachedSettingsIo f44439e;

    /* renamed from: f, reason: collision with root package name */
    public final DefaultSettingsSpiCall f44440f;

    /* renamed from: g, reason: collision with root package name */
    public final DataCollectionArbiter f44441g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicReference f44442h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicReference f44443i;

    /* renamed from: com.google.firebase.crashlytics.internal.settings.SettingsController$1, reason: invalid class name */
    class AnonymousClass1 implements SuccessContinuation<Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CrashlyticsWorkers f44444a;

        public AnonymousClass1(CrashlyticsWorkers crashlyticsWorkers) {
            this.f44444a = crashlyticsWorkers;
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        public final Task then(Object obj) throws Throwable {
            FileWriter fileWriter;
            JSONObject jSONObject = (JSONObject) this.f44444a.f43876c.f43870a.submit(new Callable() { // from class: com.google.firebase.crashlytics.internal.settings.a
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    SettingsController settingsController = SettingsController.this;
                    DefaultSettingsSpiCall defaultSettingsSpiCall = settingsController.f44440f;
                    SettingsRequest settingsRequest = settingsController.f44436b;
                    String str = defaultSettingsSpiCall.f44420a;
                    Logger logger = Logger.f43705a;
                    CrashlyticsWorkers.b();
                    try {
                        HashMap mapB = DefaultSettingsSpiCall.b(settingsRequest);
                        HttpGetRequest httpGetRequest = new HttpGetRequest(str, mapB);
                        httpGetRequest.c("User-Agent", "Crashlytics Android SDK/19.4.4");
                        httpGetRequest.c("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
                        DefaultSettingsSpiCall.a(httpGetRequest, settingsRequest);
                        logger.b("Requesting settings from ".concat(str), null);
                        logger.e("Settings query params were: " + mapB);
                        return defaultSettingsSpiCall.c(httpGetRequest.b());
                    } catch (IOException e2) {
                        logger.c("Settings request failed.", e2);
                        return null;
                    }
                }
            }).get();
            FileWriter fileWriter2 = null;
            if (jSONObject != null) {
                SettingsController settingsController = SettingsController.this;
                Settings settingsA = settingsController.f44437c.a(jSONObject);
                long j2 = settingsA.f44423c;
                CachedSettingsIo cachedSettingsIo = settingsController.f44439e;
                cachedSettingsIo.getClass();
                Logger logger = Logger.f43705a;
                logger.e("Writing settings to cache file...");
                try {
                    jSONObject.put("expires_at", j2);
                    fileWriter = new FileWriter(cachedSettingsIo.f44419a);
                    try {
                        try {
                            fileWriter.write(jSONObject.toString());
                            fileWriter.flush();
                        } catch (Exception e2) {
                            e = e2;
                            logger.c("Failed to cache settings", e);
                            CommonUtils.b(fileWriter, "Failed to close settings writer.");
                            logger.b("Loaded settings: " + jSONObject.toString(), null);
                            String str = settingsController.f44436b.f44452f;
                            SharedPreferences.Editor editorEdit = settingsController.f44435a.getSharedPreferences("com.google.firebase.crashlytics", 0).edit();
                            editorEdit.putString("existing_instance_identifier", str);
                            editorEdit.apply();
                            settingsController.f44442h.set(settingsA);
                            ((TaskCompletionSource) settingsController.f44443i.get()).d(settingsA);
                            return Tasks.e(null);
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileWriter2 = fileWriter;
                        CommonUtils.b(fileWriter2, "Failed to close settings writer.");
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileWriter = null;
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.b(fileWriter2, "Failed to close settings writer.");
                    throw th;
                }
                CommonUtils.b(fileWriter, "Failed to close settings writer.");
                logger.b("Loaded settings: " + jSONObject.toString(), null);
                String str2 = settingsController.f44436b.f44452f;
                SharedPreferences.Editor editorEdit2 = settingsController.f44435a.getSharedPreferences("com.google.firebase.crashlytics", 0).edit();
                editorEdit2.putString("existing_instance_identifier", str2);
                editorEdit2.apply();
                settingsController.f44442h.set(settingsA);
                ((TaskCompletionSource) settingsController.f44443i.get()).d(settingsA);
            }
            return Tasks.e(null);
        }
    }

    public SettingsController(Context context, SettingsRequest settingsRequest, SystemCurrentTimeProvider systemCurrentTimeProvider, SettingsJsonParser settingsJsonParser, CachedSettingsIo cachedSettingsIo, DefaultSettingsSpiCall defaultSettingsSpiCall, DataCollectionArbiter dataCollectionArbiter) {
        AtomicReference atomicReference = new AtomicReference();
        this.f44442h = atomicReference;
        this.f44443i = new AtomicReference(new TaskCompletionSource());
        this.f44435a = context;
        this.f44436b = settingsRequest;
        this.f44438d = systemCurrentTimeProvider;
        this.f44437c = settingsJsonParser;
        this.f44439e = cachedSettingsIo;
        this.f44440f = defaultSettingsSpiCall;
        this.f44441g = dataCollectionArbiter;
        atomicReference.set(DefaultSettingsJsonTransform.b(systemCurrentTimeProvider));
    }

    public static SettingsController a(Context context, String str, IdManager idManager, HttpRequestFactory httpRequestFactory, String str2, String str3, FileStore fileStore, DataCollectionArbiter dataCollectionArbiter) throws Resources.NotFoundException {
        String strD = idManager.d();
        SystemCurrentTimeProvider systemCurrentTimeProvider = new SystemCurrentTimeProvider();
        SettingsJsonParser settingsJsonParser = new SettingsJsonParser(systemCurrentTimeProvider);
        CachedSettingsIo cachedSettingsIo = new CachedSettingsIo(fileStore);
        Locale locale = Locale.US;
        DefaultSettingsSpiCall defaultSettingsSpiCall = new DefaultSettingsSpiCall(b.D("https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/", str, "/settings"), httpRequestFactory);
        String str4 = Build.MANUFACTURER;
        String str5 = IdManager.f43825h;
        String strL = b.l(str4.replaceAll(str5, ""), "/", Build.MODEL.replaceAll(str5, ""));
        String strReplaceAll = Build.VERSION.INCREMENTAL.replaceAll(str5, "");
        String strReplaceAll2 = Build.VERSION.RELEASE.replaceAll(str5, "");
        int iE = CommonUtils.e(context, "com.google.firebase.crashlytics.mapping_file_id", "string");
        if (iE == 0) {
            iE = CommonUtils.e(context, "com.crashlytics.android.build_id", "string");
        }
        String[] strArr = {iE != 0 ? context.getResources().getString(iE) : null, str, str3, str2};
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 4; i2++) {
            String str6 = strArr[i2];
            if (str6 != null) {
                arrayList.add(str6.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        String string = sb.toString();
        return new SettingsController(context, new SettingsRequest(str, strL, strReplaceAll, strReplaceAll2, idManager, string.length() > 0 ? CommonUtils.i(string) : null, str3, str2, (strD != null ? DeliveryMechanism.APP_STORE : DeliveryMechanism.DEVELOPER).f43815a), systemCurrentTimeProvider, settingsJsonParser, cachedSettingsIo, defaultSettingsSpiCall, dataCollectionArbiter);
    }

    public final Settings b(SettingsCacheBehavior settingsCacheBehavior) throws Throwable {
        Logger logger = Logger.f43705a;
        Settings settings = null;
        try {
            if (!SettingsCacheBehavior.f44432b.equals(settingsCacheBehavior)) {
                JSONObject jSONObjectA = this.f44439e.a();
                if (jSONObjectA != null) {
                    Settings settingsA = this.f44437c.a(jSONObjectA);
                    logger.b("Loaded cached settings: " + jSONObjectA.toString(), null);
                    this.f44438d.getClass();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (!SettingsCacheBehavior.f44433c.equals(settingsCacheBehavior) && settingsA.f44423c < jCurrentTimeMillis) {
                        logger.e("Cached settings have expired.");
                        return null;
                    }
                    try {
                        logger.e("Returning cached settings.");
                        return settingsA;
                    } catch (Exception e2) {
                        e = e2;
                        settings = settingsA;
                        logger.c("Failed to get cached settings", e);
                        return settings;
                    }
                }
                logger.b("No cached settings data found.", null);
            }
            return null;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public final Task c() {
        return ((TaskCompletionSource) this.f44443i.get()).f39750a;
    }

    public final Settings d() {
        return (Settings) this.f44442h.get();
    }

    public final Task e(CrashlyticsWorkers crashlyticsWorkers) throws Throwable {
        zzw zzwVar;
        Settings settingsB;
        SettingsCacheBehavior settingsCacheBehavior = SettingsCacheBehavior.f44431a;
        boolean zEquals = this.f44435a.getSharedPreferences("com.google.firebase.crashlytics", 0).getString("existing_instance_identifier", "").equals(this.f44436b.f44452f);
        AtomicReference atomicReference = this.f44443i;
        AtomicReference atomicReference2 = this.f44442h;
        if (zEquals && (settingsB = b(settingsCacheBehavior)) != null) {
            atomicReference2.set(settingsB);
            ((TaskCompletionSource) atomicReference.get()).d(settingsB);
            return Tasks.e(null);
        }
        Settings settingsB2 = b(SettingsCacheBehavior.f44433c);
        if (settingsB2 != null) {
            atomicReference2.set(settingsB2);
            ((TaskCompletionSource) atomicReference.get()).d(settingsB2);
        }
        DataCollectionArbiter dataCollectionArbiter = this.f44441g;
        zzw zzwVar2 = dataCollectionArbiter.f43811h.f39750a;
        synchronized (dataCollectionArbiter.f43806c) {
            zzwVar = dataCollectionArbiter.f43807d.f39750a;
        }
        return CrashlyticsTasks.a(zzwVar2, zzwVar).r(crashlyticsWorkers.f43874a, new AnonymousClass1(crashlyticsWorkers));
    }
}
