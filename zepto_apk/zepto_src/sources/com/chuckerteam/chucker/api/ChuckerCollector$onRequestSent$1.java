package com.chuckerteam.chucker.api;

import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import com.chuckerteam.chucker.internal.data.repository.HttpTransactionDatabaseRepository;
import com.chuckerteam.chucker.internal.data.repository.HttpTransactionRepository;
import com.chuckerteam.chucker.internal.data.repository.RepositoryProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.api.ChuckerCollector$onRequestSent$1", f = "ChuckerCollector.kt", l = {53, 60}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class ChuckerCollector$onRequestSent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f16600a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ChuckerCollector f16601b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HttpTransaction f16602c;

    @Metadata
    @DebugMetadata(c = "com.chuckerteam.chucker.api.ChuckerCollector$onRequestSent$1$1", f = "ChuckerCollector.kt", l = {54}, m = "invokeSuspend")
    /* renamed from: com.chuckerteam.chucker.api.ChuckerCollector$onRequestSent$1$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f16603a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HttpTransaction f16604b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(HttpTransaction httpTransaction, Continuation continuation) {
            super(2, continuation);
            this.f16604b = httpTransaction;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f16604b, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f16603a;
            if (i2 == 0) {
                ResultKt.b(obj);
                HttpTransactionRepository httpTransactionRepositoryB = RepositoryProvider.b();
                this.f16603a = 1;
                if (((HttpTransactionDatabaseRepository) httpTransactionRepositoryB).d(this.f16604b, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f53572a;
        }
    }

    @Metadata
    @DebugMetadata(c = "com.chuckerteam.chucker.api.ChuckerCollector$onRequestSent$1$2", f = "ChuckerCollector.kt", l = {61}, m = "invokeSuspend")
    /* renamed from: com.chuckerteam.chucker.api.ChuckerCollector$onRequestSent$1$2, reason: invalid class name */
    final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f16605a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChuckerCollector f16606b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ChuckerCollector chuckerCollector, Continuation continuation) {
            super(2, continuation);
            this.f16606b = chuckerCollector;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f16606b, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f16605a;
            if (i2 == 0) {
                ResultKt.b(obj);
                RetentionManager retentionManager = this.f16606b.f16597b;
                this.f16605a = 1;
                if (retentionManager.a(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f53572a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChuckerCollector$onRequestSent$1(ChuckerCollector chuckerCollector, HttpTransaction httpTransaction, Continuation continuation) {
        super(2, continuation);
        this.f16601b = chuckerCollector;
        this.f16602c = httpTransaction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ChuckerCollector$onRequestSent$1(this.f16601b, this.f16602c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ChuckerCollector$onRequestSent$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
    
        if (kotlinx.coroutines.BuildersKt.e(r1, r2, r6) == r0) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r6.f16600a
            com.chuckerteam.chucker.internal.data.entity.HttpTransaction r2 = r6.f16602c
            r3 = 0
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L1f
            if (r1 == r5) goto L1b
            if (r1 != r4) goto L13
            kotlin.ResultKt.b(r7)
            goto L51
        L13:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1b:
            kotlin.ResultKt.b(r7)
            goto L34
        L1f:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.scheduling.DefaultScheduler r7 = kotlinx.coroutines.Dispatchers.f54091a
            kotlinx.coroutines.scheduling.DefaultIoScheduler r7 = kotlinx.coroutines.scheduling.DefaultIoScheduler.f55150b
            com.chuckerteam.chucker.api.ChuckerCollector$onRequestSent$1$1 r1 = new com.chuckerteam.chucker.api.ChuckerCollector$onRequestSent$1$1
            r1.<init>(r2, r3)
            r6.f16600a = r5
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.e(r7, r1, r6)
            if (r7 != r0) goto L34
            goto L50
        L34:
            com.chuckerteam.chucker.api.ChuckerCollector r7 = r6.f16601b
            boolean r1 = r7.f16596a
            if (r1 == 0) goto L3f
            com.chuckerteam.chucker.internal.support.NotificationHelper r1 = r7.f16598c
            r1.a(r2)
        L3f:
            kotlinx.coroutines.scheduling.DefaultScheduler r1 = kotlinx.coroutines.Dispatchers.f54091a
            kotlinx.coroutines.scheduling.DefaultIoScheduler r1 = kotlinx.coroutines.scheduling.DefaultIoScheduler.f55150b
            com.chuckerteam.chucker.api.ChuckerCollector$onRequestSent$1$2 r2 = new com.chuckerteam.chucker.api.ChuckerCollector$onRequestSent$1$2
            r2.<init>(r7, r3)
            r6.f16600a = r4
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.e(r1, r2, r6)
            if (r7 != r0) goto L51
        L50:
            return r0
        L51:
            kotlin.Unit r7 = kotlin.Unit.f53572a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuckerteam.chucker.api.ChuckerCollector$onRequestSent$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
