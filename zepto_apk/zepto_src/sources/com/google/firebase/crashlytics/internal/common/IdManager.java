package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.InstallIdProvider;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class IdManager implements InstallIdProvider {

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f43824g = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: h, reason: collision with root package name */
    public static final String f43825h = Pattern.quote("/");

    /* renamed from: a, reason: collision with root package name */
    public final InstallerPackageNameProvider f43826a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f43827b;

    /* renamed from: c, reason: collision with root package name */
    public final String f43828c;

    /* renamed from: d, reason: collision with root package name */
    public final FirebaseInstallationsApi f43829d;

    /* renamed from: e, reason: collision with root package name */
    public final DataCollectionArbiter f43830e;

    /* renamed from: f, reason: collision with root package name */
    public InstallIdProvider.InstallIds f43831f;

    public IdManager(Context context, String str, FirebaseInstallationsApi firebaseInstallationsApi, DataCollectionArbiter dataCollectionArbiter) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.f43827b = context;
        this.f43828c = str;
        this.f43829d = firebaseInstallationsApi;
        this.f43830e = dataCollectionArbiter;
        this.f43826a = new InstallerPackageNameProvider();
    }

    public final synchronized String a(SharedPreferences sharedPreferences, String str) {
        String lowerCase;
        lowerCase = f43824g.matcher(UUID.randomUUID().toString()).replaceAll("").toLowerCase(Locale.US);
        Logger.f43705a.e("Created new Crashlytics installation ID: " + lowerCase + " for FID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", lowerCase).putString("firebase.installation.id", str).apply();
        return lowerCase;
    }

    public final FirebaseInstallationId b(boolean z) {
        String strA;
        CrashlyticsWorkers.c();
        Logger logger = Logger.f43705a;
        FirebaseInstallationsApi firebaseInstallationsApi = this.f43829d;
        String str = null;
        if (z) {
            try {
                strA = ((InstallationTokenResult) Tasks.b(firebaseInstallationsApi.a(), 10000L, TimeUnit.MILLISECONDS)).a();
            } catch (Exception e2) {
                logger.f("Error getting Firebase authentication token.", e2);
            }
        } else {
            strA = null;
        }
        try {
            str = (String) Tasks.b(firebaseInstallationsApi.getId(), 10000L, TimeUnit.MILLISECONDS);
        } catch (Exception e3) {
            logger.f("Error getting Firebase installation id.", e3);
        }
        return new FirebaseInstallationId(str, strA);
    }

    public final synchronized InstallIdProvider.InstallIds c() {
        String str;
        InstallIdProvider.InstallIds installIds = this.f43831f;
        if (installIds != null && (((AutoValue_InstallIdProvider_InstallIds) installIds).f43728b != null || !this.f43830e.b())) {
            return this.f43831f;
        }
        Logger logger = Logger.f43705a;
        logger.e("Determining Crashlytics installation ID...");
        SharedPreferences sharedPreferences = this.f43827b.getSharedPreferences("com.google.firebase.crashlytics", 0);
        String string = sharedPreferences.getString("firebase.installation.id", null);
        logger.e("Cached Firebase Installation ID: " + string);
        if (this.f43830e.b()) {
            FirebaseInstallationId firebaseInstallationIdB = b(false);
            logger.e("Fetched Firebase Installation ID: " + firebaseInstallationIdB.f43822a);
            if (firebaseInstallationIdB.f43822a == null) {
                if (string == null) {
                    str = "SYN_" + UUID.randomUUID().toString();
                } else {
                    str = string;
                }
                firebaseInstallationIdB = new FirebaseInstallationId(str, null);
            }
            if (Objects.equals(firebaseInstallationIdB.f43822a, string)) {
                this.f43831f = new AutoValue_InstallIdProvider_InstallIds(sharedPreferences.getString("crashlytics.installation.id", null), firebaseInstallationIdB.f43822a, firebaseInstallationIdB.f43823b);
            } else {
                this.f43831f = new AutoValue_InstallIdProvider_InstallIds(a(sharedPreferences, firebaseInstallationIdB.f43822a), firebaseInstallationIdB.f43822a, firebaseInstallationIdB.f43823b);
            }
        } else if (string == null || !string.startsWith("SYN_")) {
            this.f43831f = new AutoValue_InstallIdProvider_InstallIds(a(sharedPreferences, "SYN_" + UUID.randomUUID().toString()), null, null);
        } else {
            this.f43831f = new AutoValue_InstallIdProvider_InstallIds(sharedPreferences.getString("crashlytics.installation.id", null), null, null);
        }
        logger.e("Install IDs: " + this.f43831f);
        return this.f43831f;
    }

    public final String d() {
        String str;
        InstallerPackageNameProvider installerPackageNameProvider = this.f43826a;
        Context context = this.f43827b;
        synchronized (installerPackageNameProvider) {
            try {
                if (installerPackageNameProvider.f43832a == null) {
                    String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                    if (installerPackageName == null) {
                        installerPackageName = "";
                    }
                    installerPackageNameProvider.f43832a = installerPackageName;
                }
                str = "".equals(installerPackageNameProvider.f43832a) ? null : installerPackageNameProvider.f43832a;
            } finally {
            }
        }
        return str;
    }
}
