package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdf;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.measurement.internal.zzlj;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class FirebaseAnalytics {

    /* renamed from: c, reason: collision with root package name */
    public static volatile FirebaseAnalytics f43526c;

    /* renamed from: a, reason: collision with root package name */
    public final zzfb f43527a;

    /* renamed from: b, reason: collision with root package name */
    public ExecutorService f43528b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes4.dex */
    public static final class ConsentStatus {

        /* renamed from: a, reason: collision with root package name */
        public static final ConsentStatus f43529a;

        /* renamed from: b, reason: collision with root package name */
        public static final ConsentStatus f43530b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ ConsentStatus[] f43531c;

        static {
            ConsentStatus consentStatus = new ConsentStatus("GRANTED", 0);
            f43529a = consentStatus;
            ConsentStatus consentStatus2 = new ConsentStatus("DENIED", 1);
            f43530b = consentStatus2;
            f43531c = new ConsentStatus[]{consentStatus, consentStatus2};
        }

        @NonNull
        public static ConsentStatus valueOf(@NonNull String str) {
            return (ConsentStatus) Enum.valueOf(ConsentStatus.class, str);
        }

        @NonNull
        public static ConsentStatus[] values() {
            return (ConsentStatus[]) f43531c.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes4.dex */
    public static final class ConsentType {

        /* renamed from: a, reason: collision with root package name */
        public static final ConsentType f43532a;

        /* renamed from: b, reason: collision with root package name */
        public static final ConsentType f43533b;

        /* renamed from: c, reason: collision with root package name */
        public static final ConsentType f43534c;

        /* renamed from: d, reason: collision with root package name */
        public static final ConsentType f43535d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ ConsentType[] f43536e;

        static {
            ConsentType consentType = new ConsentType("AD_STORAGE", 0);
            f43532a = consentType;
            ConsentType consentType2 = new ConsentType("ANALYTICS_STORAGE", 1);
            f43533b = consentType2;
            ConsentType consentType3 = new ConsentType("AD_USER_DATA", 2);
            f43534c = consentType3;
            ConsentType consentType4 = new ConsentType("AD_PERSONALIZATION", 3);
            f43535d = consentType4;
            f43536e = new ConsentType[]{consentType, consentType2, consentType3, consentType4};
        }

        @NonNull
        public static ConsentType valueOf(@NonNull String str) {
            return (ConsentType) Enum.valueOf(ConsentType.class, str);
        }

        @NonNull
        public static ConsentType[] values() {
            return (ConsentType[]) f43536e.clone();
        }
    }

    /* loaded from: classes4.dex */
    public static class Event {
    }

    /* loaded from: classes4.dex */
    public static class Param {
    }

    /* loaded from: classes4.dex */
    public static class UserProperty {
    }

    public FirebaseAnalytics(zzfb zzfbVar) {
        Preconditions.checkNotNull(zzfbVar);
        this.f43527a = zzfbVar;
    }

    @NonNull
    @RequiresPermission
    @Keep
    public static FirebaseAnalytics getInstance(@NonNull Context context) {
        if (f43526c == null) {
            synchronized (FirebaseAnalytics.class) {
                try {
                    if (f43526c == null) {
                        f43526c = new FirebaseAnalytics(zzfb.m(context, null));
                    }
                } finally {
                }
            }
        }
        return f43526c;
    }

    @Nullable
    @Keep
    public static zzlj getScionFrontendApiImplementation(Context context, @Nullable Bundle bundle) {
        zzfb zzfbVarM = zzfb.m(context, bundle);
        if (zzfbVarM == null) {
            return null;
        }
        return new zzd(zzfbVarM);
    }

    public final Task a() {
        try {
            return Tasks.c(new zzb(this), c());
        } catch (RuntimeException e2) {
            this.f43527a.d("Failed to schedule task for getAppInstanceId", null);
            return Tasks.d(e2);
        }
    }

    public final Task b() {
        try {
            return Tasks.c(new zzc(this), c());
        } catch (RuntimeException e2) {
            this.f43527a.d("Failed to schedule task for getSessionId", null);
            return Tasks.d(e2);
        }
    }

    public final ExecutorService c() {
        ExecutorService executorService;
        synchronized (FirebaseAnalytics.class) {
            try {
                if (this.f43528b == null) {
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    this.f43528b = new zza(this, new ArrayBlockingQueue(100));
                }
                executorService = this.f43528b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return executorService;
    }

    @NonNull
    @Keep
    public String getFirebaseInstanceId() {
        try {
            Object obj = FirebaseInstallations.f44568m;
            FirebaseApp firebaseAppD = FirebaseApp.d();
            Preconditions.checkArgument(true, "Null is not a valid value of FirebaseApp.");
            return (String) Tasks.b(((FirebaseInstallations) firebaseAppD.b(FirebaseInstallationsApi.class)).getId(), 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            throw new IllegalStateException(e2);
        } catch (ExecutionException e3) {
            throw new IllegalStateException(e3.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    @Keep
    @MainThread
    @Deprecated
    public void setCurrentScreen(@NonNull Activity activity, @Nullable @Size String str, @Nullable @Size String str2) {
        this.f43527a.u(zzdf.b(activity), str, str2);
    }
}
