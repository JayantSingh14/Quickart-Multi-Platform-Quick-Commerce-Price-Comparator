package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.analytics.connector.internal.zzg;
import com.google.firebase.events.Subscriber;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class AnalyticsConnectorImpl implements AnalyticsConnector {

    /* renamed from: c, reason: collision with root package name */
    public static volatile AnalyticsConnectorImpl f43537c;

    /* renamed from: a, reason: collision with root package name */
    public final AppMeasurementSdk f43538a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f43539b;

    /* renamed from: com.google.firebase.analytics.connector.AnalyticsConnectorImpl$1, reason: invalid class name */
    class AnonymousClass1 implements AnalyticsConnector.AnalyticsConnectorHandle {
    }

    public AnalyticsConnectorImpl(AppMeasurementSdk appMeasurementSdk) {
        Preconditions.checkNotNull(appMeasurementSdk);
        this.f43538a = appMeasurementSdk;
        this.f43539b = new ConcurrentHashMap();
    }

    public static AnalyticsConnector d(FirebaseApp firebaseApp, Context context, Subscriber subscriber) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(subscriber);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (f43537c == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                try {
                    if (f43537c == null) {
                        Bundle bundle = new Bundle(1);
                        firebaseApp.a();
                        if ("[DEFAULT]".equals(firebaseApp.f43490b)) {
                            subscriber.d(zzb.f43551a, zza.f43550a);
                            bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.j());
                        }
                        f43537c = new AnalyticsConnectorImpl(zzfb.m(context, bundle).f36946c);
                    }
                } finally {
                }
            }
        }
        return f43537c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a2  */
    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r7, java.lang.String r8, android.os.Bundle r9) {
        /*
            r6 = this;
            com.google.common.collect.ImmutableList r0 = com.google.firebase.analytics.connector.internal.zzc.f43543c
            boolean r0 = r0.contains(r7)
            if (r0 == 0) goto La
            goto L95
        La:
            com.google.common.collect.ImmutableList r0 = com.google.firebase.analytics.connector.internal.zzc.f43542b
            boolean r0 = r0.contains(r8)
            if (r0 == 0) goto L14
            goto L95
        L14:
            com.google.common.collect.ImmutableList r0 = com.google.firebase.analytics.connector.internal.zzc.f43544d
            int r1 = r0.size()
            r2 = 0
            r3 = r2
        L1c:
            if (r3 >= r1) goto L2e
            java.lang.Object r4 = r0.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = r9.containsKey(r4)
            int r3 = r3 + 1
            if (r4 == 0) goto L1c
            goto L95
        L2e:
            java.lang.String r0 = "_cmp"
            boolean r0 = r0.equals(r8)
            r1 = 1
            if (r0 != 0) goto L39
            goto La7
        L39:
            com.google.common.collect.ImmutableList r0 = com.google.firebase.analytics.connector.internal.zzc.f43543c
            boolean r0 = r0.contains(r7)
            if (r0 == 0) goto L42
            goto L95
        L42:
            com.google.common.collect.ImmutableList r0 = com.google.firebase.analytics.connector.internal.zzc.f43544d
            int r3 = r0.size()
            r4 = r2
        L49:
            if (r4 >= r3) goto L5a
            java.lang.Object r5 = r0.get(r4)
            java.lang.String r5 = (java.lang.String) r5
            boolean r5 = r9.containsKey(r5)
            int r4 = r4 + 1
            if (r5 == 0) goto L49
            goto L95
        L5a:
            int r0 = r7.hashCode()
            r3 = 101200(0x18b50, float:1.41811E-40)
            r4 = 2
            if (r0 == r3) goto L83
            r2 = 101230(0x18b6e, float:1.41853E-40)
            if (r0 == r2) goto L79
            r2 = 3142703(0x2ff42f, float:4.403865E-39)
            if (r0 == r2) goto L6f
            goto L8c
        L6f:
            java.lang.String r0 = "fiam"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L8c
            r2 = r4
            goto L8d
        L79:
            java.lang.String r0 = "fdl"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L8c
            r2 = r1
            goto L8d
        L83:
            java.lang.String r0 = "fcm"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L8c
            goto L8d
        L8c:
            r2 = -1
        L8d:
            java.lang.String r0 = "_cis"
            if (r2 == 0) goto La2
            if (r2 == r1) goto L9c
            if (r2 == r4) goto L96
        L95:
            return
        L96:
            java.lang.String r2 = "fiam_integration"
            r9.putString(r0, r2)
            goto La7
        L9c:
            java.lang.String r2 = "fdl_integration"
            r9.putString(r0, r2)
            goto La7
        La2:
            java.lang.String r2 = "fcm_integration"
            r9.putString(r0, r2)
        La7:
            java.lang.String r0 = "clx"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto Lbe
            java.lang.String r0 = "_ae"
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto Lbe
            java.lang.String r0 = "_r"
            r2 = 1
            r9.putLong(r0, r2)
        Lbe:
            com.google.android.gms.measurement.api.AppMeasurementSdk r0 = r6.f43538a
            com.google.android.gms.internal.measurement.zzfb r0 = r0.f38652a
            r0.l(r9, r7, r8, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.analytics.connector.AnalyticsConnectorImpl.a(java.lang.String, java.lang.String, android.os.Bundle):void");
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public final void b(String str) {
        if (zzc.f43543c.contains("fcm")) {
            return;
        }
        this.f43538a.f38652a.p("fcm", "_ln", str, true);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public final AnalyticsConnector.AnalyticsConnectorHandle c(String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        Preconditions.checkNotNull(analyticsConnectorListener);
        if (!zzc.f43543c.contains(str)) {
            boolean zIsEmpty = str.isEmpty();
            ConcurrentHashMap concurrentHashMap = this.f43539b;
            if (zIsEmpty || !concurrentHashMap.containsKey(str) || concurrentHashMap.get(str) == null) {
                boolean zEquals = "fiam".equals(str);
                AppMeasurementSdk appMeasurementSdk = this.f43538a;
                com.google.firebase.analytics.connector.internal.zza zzeVar = zEquals ? new zze(appMeasurementSdk, analyticsConnectorListener) : "clx".equals(str) ? new zzg(appMeasurementSdk, analyticsConnectorListener) : null;
                if (zzeVar != null) {
                    concurrentHashMap.put(str, zzeVar);
                    return new AnonymousClass1();
                }
            }
        }
        return null;
    }
}
