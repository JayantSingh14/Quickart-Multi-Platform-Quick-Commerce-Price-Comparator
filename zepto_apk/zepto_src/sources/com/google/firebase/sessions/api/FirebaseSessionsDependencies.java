package com.google.firebase.sessions.api;

import android.util.Log;
import com.google.firebase.crashlytics.internal.common.CrashlyticsAppQualitySessionsSubscriber;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.MutexImpl;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class FirebaseSessionsDependencies {

    /* renamed from: a, reason: collision with root package name */
    public static final FirebaseSessionsDependencies f45125a = new FirebaseSessionsDependencies();

    /* renamed from: b, reason: collision with root package name */
    public static final Map f45126b = Collections.synchronizedMap(new LinkedHashMap());

    @Metadata
    public static final class Dependency {

        /* renamed from: a, reason: collision with root package name */
        public final MutexImpl f45127a;

        /* renamed from: b, reason: collision with root package name */
        public CrashlyticsAppQualitySessionsSubscriber f45128b;

        public Dependency(MutexImpl mutex) {
            Intrinsics.checkNotNullParameter(mutex, "mutex");
            this.f45127a = mutex;
            this.f45128b = null;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Dependency)) {
                return false;
            }
            Dependency dependency = (Dependency) obj;
            return this.f45127a.equals(dependency.f45127a) && Intrinsics.b(this.f45128b, dependency.f45128b);
        }

        public final int hashCode() {
            int iHashCode = this.f45127a.hashCode() * 31;
            CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber = this.f45128b;
            return iHashCode + (crashlyticsAppQualitySessionsSubscriber == null ? 0 : crashlyticsAppQualitySessionsSubscriber.hashCode());
        }

        public final String toString() {
            return "Dependency(mutex=" + this.f45127a + ", subscriber=" + this.f45128b + ')';
        }
    }

    public static final void a() {
        SessionSubscriber.Name subscriberName = SessionSubscriber.Name.f45138a;
        Intrinsics.checkNotNullParameter(subscriberName, "subscriberName");
        Map dependencies = f45126b;
        if (dependencies.containsKey(subscriberName)) {
            Log.d("SessionsDependencies", "Dependency " + subscriberName + " already added.");
            return;
        }
        Intrinsics.checkNotNullExpressionValue(dependencies, "dependencies");
        dependencies.put(subscriberName, new Dependency(new MutexImpl(true)));
        Log.d("SessionsDependencies", "Dependency to " + subscriberName + " added.");
    }

    public static Dependency b(SessionSubscriber.Name name) {
        Map dependencies = f45126b;
        Intrinsics.checkNotNullExpressionValue(dependencies, "dependencies");
        Object obj = dependencies.get(name);
        if (obj != null) {
            Intrinsics.checkNotNullExpressionValue(obj, "dependencies.getOrElse(s…load time.\"\n      )\n    }");
            return (Dependency) obj;
        }
        throw new IllegalStateException("Cannot get dependency " + name + ". Dependencies should be added at class load time.");
    }

    public static final void d(CrashlyticsAppQualitySessionsSubscriber subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        SessionSubscriber.Name name = SessionSubscriber.Name.f45138a;
        Dependency dependencyB = b(name);
        if (dependencyB.f45128b != null) {
            Log.d("SessionsDependencies", "Subscriber " + name + " already registered.");
            return;
        }
        dependencyB.f45128b = subscriber;
        Log.d("SessionsDependencies", "Subscriber " + name + " registered.");
        dependencyB.f45127a.b(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a7 A[Catch: all -> 0x00c0, TRY_ENTER, TryCatch #0 {all -> 0x00c0, blocks: (B:22:0x0092, B:25:0x00a7, B:26:0x00bf), top: B:31:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0090 -> B:21:0x0091). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(kotlin.coroutines.jvm.internal.ContinuationImpl r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1
            if (r0 == 0) goto L13
            r0 = r11
            com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1 r0 = (com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1) r0
            int r1 = r0.f45137i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f45137i = r1
            goto L18
        L13:
            com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1 r0 = new com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.f45135g
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f45137i
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r2 = r0.f45134f
            java.util.Map r4 = r0.f45133e
            kotlinx.coroutines.sync.Mutex r5 = r0.f45132d
            com.google.firebase.sessions.api.SessionSubscriber$Name r6 = r0.f45131c
            java.util.Iterator r7 = r0.f45130b
            java.util.Map r8 = r0.f45129a
            kotlin.ResultKt.b(r11)
            goto L91
        L33:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L3b:
            kotlin.ResultKt.b(r11)
            java.util.Map r11 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.f45126b
            java.lang.String r2 = "dependencies"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r2)
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            int r4 = r11.size()
            int r4 = kotlin.collections.MapsKt.f(r4)
            r2.<init>(r4)
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
            r7 = r11
            r4 = r2
        L5c:
            boolean r11 = r7.hasNext()
            if (r11 == 0) goto Lc5
            java.lang.Object r11 = r7.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r2 = r11.getKey()
            java.lang.Object r5 = r11.getKey()
            r6 = r5
            com.google.firebase.sessions.api.SessionSubscriber$Name r6 = (com.google.firebase.sessions.api.SessionSubscriber.Name) r6
            java.lang.Object r11 = r11.getValue()
            com.google.firebase.sessions.api.FirebaseSessionsDependencies$Dependency r11 = (com.google.firebase.sessions.api.FirebaseSessionsDependencies.Dependency) r11
            kotlinx.coroutines.sync.MutexImpl r5 = r11.f45127a
            r0.f45129a = r4
            r0.f45130b = r7
            r0.f45131c = r6
            r0.f45132d = r5
            r0.f45133e = r4
            r0.f45134f = r2
            r0.f45137i = r3
            java.lang.Object r11 = r5.c(r0)
            if (r11 != r1) goto L90
            return r1
        L90:
            r8 = r4
        L91:
            r11 = 0
            java.lang.String r9 = "subscriberName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r9)     // Catch: java.lang.Throwable -> Lc0
            com.google.firebase.sessions.api.FirebaseSessionsDependencies$Dependency r9 = b(r6)     // Catch: java.lang.Throwable -> Lc0
            com.google.firebase.crashlytics.internal.common.CrashlyticsAppQualitySessionsSubscriber r9 = r9.f45128b     // Catch: java.lang.Throwable -> Lc0
            if (r9 == 0) goto La7
            r5.b(r11)
            r4.put(r2, r9)
            r4 = r8
            goto L5c
        La7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lc0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r2 = "Subscriber "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lc0
            r1.append(r6)     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r2 = " has not been registered."
            r1.append(r2)     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lc0
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Lc0
            throw r0     // Catch: java.lang.Throwable -> Lc0
        Lc0:
            r0 = move-exception
            r5.b(r11)
            throw r0
        Lc5:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.api.FirebaseSessionsDependencies.c(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
