package com.google.firebase.sessions;

import kotlin.Metadata;

@Metadata
/* loaded from: classes4.dex */
public final class InstallationId {

    /* renamed from: c, reason: collision with root package name */
    public static final Companion f45013c = new Companion();

    /* renamed from: a, reason: collision with root package name */
    public final String f45014a;

    /* renamed from: b, reason: collision with root package name */
    public final String f45015b;

    @Metadata
    public static final class Companion {
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0084, code lost:
        
            if (r10 == r1) goto L33;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r9v13, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r9v16 */
        /* JADX WARN: Type inference failed for: r9v17 */
        /* JADX WARN: Type inference failed for: r9v3 */
        /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r9v8 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(com.google.firebase.installations.FirebaseInstallationsApi r9, kotlin.coroutines.jvm.internal.ContinuationImpl r10) {
            /*
                r8 = this;
                boolean r0 = r10 instanceof com.google.firebase.sessions.InstallationId$Companion$create$1
                if (r0 == 0) goto L13
                r0 = r10
                com.google.firebase.sessions.InstallationId$Companion$create$1 r0 = (com.google.firebase.sessions.InstallationId$Companion$create$1) r0
                int r1 = r0.f45019d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f45019d = r1
                goto L18
            L13:
                com.google.firebase.sessions.InstallationId$Companion$create$1 r0 = new com.google.firebase.sessions.InstallationId$Companion$create$1
                r0.<init>(r8, r10)
            L18:
                java.lang.Object r10 = r0.f45017b
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                int r2 = r0.f45019d
                java.lang.String r3 = ""
                java.lang.String r4 = "InstallationId"
                r5 = 2
                r6 = 1
                if (r2 == 0) goto L46
                if (r2 == r6) goto L3c
                if (r2 != r5) goto L34
                java.lang.Object r9 = r0.f45016a
                java.lang.String r9 = (java.lang.String) r9
                kotlin.ResultKt.b(r10)     // Catch: java.lang.Exception -> L32
                goto L87
            L32:
                r10 = move-exception
                goto L90
            L34:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L3c:
                java.lang.Object r9 = r0.f45016a
                com.google.firebase.installations.FirebaseInstallationsApi r9 = (com.google.firebase.installations.FirebaseInstallationsApi) r9
                kotlin.ResultKt.b(r10)     // Catch: java.lang.Exception -> L44
                goto L5d
            L44:
                r10 = move-exception
                goto L6c
            L46:
                kotlin.ResultKt.b(r10)
                com.google.android.gms.tasks.Task r10 = r9.a()     // Catch: java.lang.Exception -> L44
                java.lang.String r2 = "firebaseInstallations.getToken(false)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r2)     // Catch: java.lang.Exception -> L44
                r0.f45016a = r9     // Catch: java.lang.Exception -> L44
                r0.f45019d = r6     // Catch: java.lang.Exception -> L44
                java.lang.Object r10 = kotlinx.coroutines.tasks.TasksKt.a(r10, r0)     // Catch: java.lang.Exception -> L44
                if (r10 != r1) goto L5d
                goto L86
            L5d:
                com.google.firebase.installations.InstallationTokenResult r10 = (com.google.firebase.installations.InstallationTokenResult) r10     // Catch: java.lang.Exception -> L44
                java.lang.String r10 = r10.a()     // Catch: java.lang.Exception -> L44
                java.lang.String r2 = "{\n          firebaseInst…).await().token\n        }"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r2)     // Catch: java.lang.Exception -> L44
                r7 = r10
                r10 = r9
                r9 = r7
                goto L73
            L6c:
                java.lang.String r2 = "Error getting authentication token."
                android.util.Log.w(r4, r2, r10)
                r10 = r9
                r9 = r3
            L73:
                com.google.android.gms.tasks.Task r10 = r10.getId()     // Catch: java.lang.Exception -> L32
                java.lang.String r2 = "firebaseInstallations.id"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r2)     // Catch: java.lang.Exception -> L32
                r0.f45016a = r9     // Catch: java.lang.Exception -> L32
                r0.f45019d = r5     // Catch: java.lang.Exception -> L32
                java.lang.Object r10 = kotlinx.coroutines.tasks.TasksKt.a(r10, r0)     // Catch: java.lang.Exception -> L32
                if (r10 != r1) goto L87
            L86:
                return r1
            L87:
                java.lang.String r0 = "{\n          firebaseInst…ions.id.await()\n        }"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)     // Catch: java.lang.Exception -> L32
                java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Exception -> L32
                r3 = r10
                goto L95
            L90:
                java.lang.String r0 = "Error getting Firebase installation id ."
                android.util.Log.w(r4, r0, r10)
            L95:
                com.google.firebase.sessions.InstallationId r10 = new com.google.firebase.sessions.InstallationId
                r10.<init>(r3, r9)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.InstallationId.Companion.a(com.google.firebase.installations.FirebaseInstallationsApi, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
        }
    }

    public InstallationId(String str, String str2) {
        this.f45014a = str;
        this.f45015b = str2;
    }

    public final String a() {
        return this.f45014a;
    }
}
