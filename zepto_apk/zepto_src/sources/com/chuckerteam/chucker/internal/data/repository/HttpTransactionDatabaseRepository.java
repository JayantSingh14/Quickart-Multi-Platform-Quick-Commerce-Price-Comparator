package com.chuckerteam.chucker.internal.data.repository;

import android.support.v4.media.b;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.chuckerteam.chucker.internal.data.room.ChuckerDatabase;
import com.chuckerteam.chucker.internal.support.LiveDataUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class HttpTransactionDatabaseRepository implements HttpTransactionRepository {

    /* renamed from: a, reason: collision with root package name */
    public final ChuckerDatabase f16717a;

    public HttpTransactionDatabaseRepository(ChuckerDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        this.f16717a = database;
    }

    public final Object a(SuspendLambda suspendLambda) {
        Object objG = this.f16717a.q().g(suspendLambda);
        return objG == CoroutineSingletons.f53689a ? objG : Unit.f53572a;
    }

    public final LiveData b(String code, String path) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(path, "path");
        String strD = path.length() > 0 ? b.D("%", path, "%") : "%";
        return this.f16717a.q().a(code + "%", strD, strD);
    }

    public final MediatorLiveData c(long j2) {
        return LiveDataUtilsKt.b(this.f16717a.q().c(j2), new a(0));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(com.chuckerteam.chucker.internal.data.entity.HttpTransaction r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.chuckerteam.chucker.internal.data.repository.HttpTransactionDatabaseRepository$insertTransaction$1
            if (r0 == 0) goto L13
            r0 = r6
            com.chuckerteam.chucker.internal.data.repository.HttpTransactionDatabaseRepository$insertTransaction$1 r0 = (com.chuckerteam.chucker.internal.data.repository.HttpTransactionDatabaseRepository$insertTransaction$1) r0
            int r1 = r0.f16721d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f16721d = r1
            goto L18
        L13:
            com.chuckerteam.chucker.internal.data.repository.HttpTransactionDatabaseRepository$insertTransaction$1 r0 = new com.chuckerteam.chucker.internal.data.repository.HttpTransactionDatabaseRepository$insertTransaction$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f16719b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f16721d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            com.chuckerteam.chucker.internal.data.entity.HttpTransaction r5 = r0.f16718a
            kotlin.ResultKt.b(r6)
            goto L45
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r6)
            com.chuckerteam.chucker.internal.data.room.ChuckerDatabase r6 = r4.f16717a
            com.chuckerteam.chucker.internal.data.room.HttpTransactionDao r6 = r6.q()
            r0.f16718a = r5
            r0.f16721d = r3
            java.lang.Object r6 = r6.b(r5, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            java.lang.Long r6 = (java.lang.Long) r6
            if (r6 == 0) goto L4e
            long r0 = r6.longValue()
            goto L50
        L4e:
            r0 = 0
        L50:
            r5.setId(r0)
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuckerteam.chucker.internal.data.repository.HttpTransactionDatabaseRepository.d(com.chuckerteam.chucker.internal.data.entity.HttpTransaction, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
