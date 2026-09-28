package io.ktor.client.plugins.cookies;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class AcceptAllCookiesStorage implements CookiesStorage {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f49880a = new ArrayList();

    @NotNull
    private volatile /* synthetic */ long oldestCookie = 0;

    /* renamed from: b, reason: collision with root package name */
    public final MutexImpl f49881b = MutexKt.a();

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(final io.ktor.http.Url r8, final io.ktor.http.Cookie r9, kotlin.coroutines.jvm.internal.ContinuationImpl r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1 r0 = (io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1) r0
            int r1 = r0.f49888g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49888g = r1
            goto L18
        L13:
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1 r0 = new io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.f49886e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f49888g
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            kotlinx.coroutines.sync.MutexImpl r8 = r0.f49885d
            io.ktor.http.Cookie r9 = r0.f49884c
            io.ktor.http.Url r1 = r0.f49883b
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage r0 = r0.f49882a
            kotlin.ResultKt.b(r10)
            r10 = r8
            r8 = r1
            goto L50
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            kotlin.ResultKt.b(r10)
            kotlinx.coroutines.sync.MutexImpl r10 = r7.f49881b
            r0.f49882a = r7
            r0.f49883b = r8
            r0.f49884c = r9
            r0.f49885d = r10
            r0.f49888g = r3
            java.lang.Object r0 = r10.c(r0)
            if (r0 != r1) goto L4f
            return r1
        L4f:
            r0 = r7
        L50:
            r1 = 0
            java.lang.String r2 = r9.f50132a     // Catch: java.lang.Throwable -> Lb0
            boolean r2 = kotlin.text.StringsKt.z(r2)     // Catch: java.lang.Throwable -> Lb0
            if (r2 != 0) goto Lb2
            java.util.ArrayList r2 = r0.f49880a     // Catch: java.lang.Throwable -> Lb0
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$2$2 r4 = new io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$2$2     // Catch: java.lang.Throwable -> Lb0
            r4.<init>()     // Catch: java.lang.Throwable -> Lb0
            kotlin.collections.CollectionsKt.N(r2, r4)     // Catch: java.lang.Throwable -> Lb0
            java.util.ArrayList r2 = r0.f49880a     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r4 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r4)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r4 = "requestUrl"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r4)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r4 = r9.f50138g     // Catch: java.lang.Throwable -> Lb0
            if (r4 == 0) goto L7e
            java.lang.String r5 = "/"
            r6 = 0
            boolean r4 = kotlin.text.StringsKt.O(r4, r5, r6)     // Catch: java.lang.Throwable -> Lb0
            if (r4 != r3) goto L7e
            r3 = r9
            goto L8c
        L7e:
            kotlin.Lazy r3 = r8.f50269j     // Catch: java.lang.Throwable -> Lb0
            java.lang.Object r3 = r3.getValue()     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> Lb0
            r4 = 959(0x3bf, float:1.344E-42)
            io.ktor.http.Cookie r3 = io.ktor.http.Cookie.a(r9, r1, r3, r4)     // Catch: java.lang.Throwable -> Lb0
        L8c:
            java.lang.String r4 = r3.f50137f     // Catch: java.lang.Throwable -> Lb0
            if (r4 == 0) goto L96
            boolean r4 = kotlin.text.StringsKt.z(r4)     // Catch: java.lang.Throwable -> Lb0
            if (r4 == 0) goto L9e
        L96:
            java.lang.String r8 = r8.f50261b     // Catch: java.lang.Throwable -> Lb0
            r4 = 991(0x3df, float:1.389E-42)
            io.ktor.http.Cookie r3 = io.ktor.http.Cookie.a(r3, r8, r1, r4)     // Catch: java.lang.Throwable -> Lb0
        L9e:
            r2.add(r3)     // Catch: java.lang.Throwable -> Lb0
            io.ktor.util.date.GMTDate r8 = r9.f50136e     // Catch: java.lang.Throwable -> Lb0
            if (r8 == 0) goto Lb2
            long r8 = r8.f50543i     // Catch: java.lang.Throwable -> Lb0
            long r2 = r0.oldestCookie     // Catch: java.lang.Throwable -> Lb0
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 <= 0) goto Lb2
            r0.oldestCookie = r8     // Catch: java.lang.Throwable -> Lb0
            goto Lb2
        Lb0:
            r8 = move-exception
            goto Lba
        Lb2:
            kotlin.Unit r8 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> Lb0
            r10.b(r1)
            kotlin.Unit r8 = kotlin.Unit.f53572a
            return r8
        Lba:
            r10.b(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.a(io.ktor.http.Url, io.ktor.http.Cookie, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(io.ktor.http.Url r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1 r0 = (io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1) r0
            int r1 = r0.f49897f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49897f = r1
            goto L1a
        L13:
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1 r0 = new io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1
            kotlin.coroutines.jvm.internal.ContinuationImpl r9 = (kotlin.coroutines.jvm.internal.ContinuationImpl) r9
            r0.<init>(r7, r9)
        L1a:
            java.lang.Object r9 = r0.f49895d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f49897f
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlinx.coroutines.sync.MutexImpl r8 = r0.f49894c
            io.ktor.http.Url r1 = r0.f49893b
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage r0 = r0.f49892a
            kotlin.ResultKt.b(r9)
            goto L4e
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.b(r9)
            kotlinx.coroutines.sync.MutexImpl r9 = r7.f49881b
            r0.f49892a = r7
            r0.f49893b = r8
            r0.f49894c = r9
            r0.f49897f = r3
            java.lang.Object r0 = r9.c(r0)
            if (r0 != r1) goto L4b
            return r1
        L4b:
            r0 = r7
            r1 = r8
            r8 = r9
        L4e:
            r9 = 0
            java.util.TimeZone r2 = io.ktor.util.date.DateJvmKt.f50534a     // Catch: java.lang.Throwable -> Lab
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lab
            long r4 = r0.oldestCookie     // Catch: java.lang.Throwable -> Lab
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 < 0) goto L89
            java.util.ArrayList r4 = r0.f49880a     // Catch: java.lang.Throwable -> Lab
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$cleanup$1 r5 = new io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$cleanup$1     // Catch: java.lang.Throwable -> Lab
            r5.<init>()     // Catch: java.lang.Throwable -> Lab
            kotlin.collections.CollectionsKt.N(r4, r5)     // Catch: java.lang.Throwable -> Lab
            java.util.ArrayList r2 = r0.f49880a     // Catch: java.lang.Throwable -> Lab
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> Lab
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L70:
            boolean r5 = r2.hasNext()     // Catch: java.lang.Throwable -> Lab
            if (r5 == 0) goto L87
            java.lang.Object r5 = r2.next()     // Catch: java.lang.Throwable -> Lab
            io.ktor.http.Cookie r5 = (io.ktor.http.Cookie) r5     // Catch: java.lang.Throwable -> Lab
            io.ktor.util.date.GMTDate r5 = r5.f50136e     // Catch: java.lang.Throwable -> Lab
            if (r5 == 0) goto L70
            long r5 = r5.f50543i     // Catch: java.lang.Throwable -> Lab
            long r3 = java.lang.Math.min(r3, r5)     // Catch: java.lang.Throwable -> Lab
            goto L70
        L87:
            r0.oldestCookie = r3     // Catch: java.lang.Throwable -> Lab
        L89:
            java.util.ArrayList r0 = r0.f49880a     // Catch: java.lang.Throwable -> Lab
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lab
            r2.<init>()     // Catch: java.lang.Throwable -> Lab
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> Lab
        L94:
            boolean r3 = r0.hasNext()     // Catch: java.lang.Throwable -> Lab
            if (r3 == 0) goto Lad
            java.lang.Object r3 = r0.next()     // Catch: java.lang.Throwable -> Lab
            r4 = r3
            io.ktor.http.Cookie r4 = (io.ktor.http.Cookie) r4     // Catch: java.lang.Throwable -> Lab
            boolean r4 = io.ktor.client.plugins.cookies.CookiesStorageKt.a(r4, r1)     // Catch: java.lang.Throwable -> Lab
            if (r4 == 0) goto L94
            r2.add(r3)     // Catch: java.lang.Throwable -> Lab
            goto L94
        Lab:
            r0 = move-exception
            goto Lb1
        Lad:
            r8.b(r9)
            return r2
        Lb1:
            r8.b(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.b(io.ktor.http.Url, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
