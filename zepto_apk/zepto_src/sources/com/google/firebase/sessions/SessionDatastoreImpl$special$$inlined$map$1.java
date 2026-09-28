package com.google.firebase.sessions;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class SessionDatastoreImpl$special$$inlined$map$1 implements Flow<FirebaseSessionsData> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 f45033a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SessionDatastoreImpl f45034b;

    @Metadata
    @SourceDebugExtension
    /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2, reason: invalid class name */
    public final class AnonymousClass2<T> implements FlowCollector {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowCollector f45035a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SessionDatastoreImpl f45036b;

        @Metadata
        @DebugMetadata(c = "com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2", f = "SessionDatastore.kt", l = {223}, m = "emit")
        @SourceDebugExtension
        /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2$1, reason: invalid class name */
        public final class AnonymousClass1 extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f45037a;

            /* renamed from: b, reason: collision with root package name */
            public int f45038b;

            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f45037a = obj;
                this.f45038b |= Integer.MIN_VALUE;
                return AnonymousClass2.this.a(null, this);
            }
        }

        public AnonymousClass2(FlowCollector flowCollector, SessionDatastoreImpl sessionDatastoreImpl) {
            this.f45035a = flowCollector;
            this.f45036b = sessionDatastoreImpl;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                if (r0 == 0) goto L13
                r0 = r6
                com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2$1 r0 = (com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                int r1 = r0.f45038b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f45038b = r1
                goto L18
            L13:
                com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2$1 r0 = new com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2$1
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.f45037a
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                int r2 = r0.f45038b
                r3 = 1
                if (r2 == 0) goto L2f
                if (r2 != r3) goto L27
                kotlin.ResultKt.b(r6)
                goto L51
            L27:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L2f:
                kotlin.ResultKt.b(r6)
                androidx.datastore.preferences.core.Preferences r5 = (androidx.datastore.preferences.core.Preferences) r5
                com.google.firebase.sessions.SessionDatastoreImpl r6 = r4.f45036b
                r6.getClass()
                com.google.firebase.sessions.FirebaseSessionsData r6 = new com.google.firebase.sessions.FirebaseSessionsData
                androidx.datastore.preferences.core.Preferences$Key r2 = com.google.firebase.sessions.SessionDatastoreImpl.FirebaseSessionDataKeys.f45043a
                java.lang.Object r5 = r5.b(r2)
                java.lang.String r5 = (java.lang.String) r5
                r6.<init>(r5)
                r0.f45038b = r3
                kotlinx.coroutines.flow.FlowCollector r5 = r4.f45035a
                java.lang.Object r5 = r5.a(r6, r0)
                if (r5 != r1) goto L51
                return r1
            L51:
                kotlin.Unit r5 = kotlin.Unit.f53572a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1.AnonymousClass2.a(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    public SessionDatastoreImpl$special$$inlined$map$1(FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1, SessionDatastoreImpl sessionDatastoreImpl) {
        this.f45033a = flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
        this.f45034b = sessionDatastoreImpl;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object c(FlowCollector flowCollector, Continuation continuation) {
        Object objC = this.f45033a.c(new AnonymousClass2(flowCollector, this.f45034b), continuation);
        return objC == CoroutineSingletons.f53689a ? objC : Unit.f53572a;
    }
}
