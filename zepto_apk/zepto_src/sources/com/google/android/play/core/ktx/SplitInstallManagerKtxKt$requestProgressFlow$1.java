package com.google.android.play.core.ktx;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.ProducerScope;

@Metadata
@DebugMetadata(c = "com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestProgressFlow$1", f = "SplitInstallManagerKtx.kt", l = {84}, m = "invokeSuspend")
/* loaded from: classes4.dex */
final class SplitInstallManagerKtxKt$requestProgressFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super SplitInstallSessionState>, Continuation<? super Unit>, Object> {

    @Metadata
    /* renamed from: com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestProgressFlow$1$1, reason: invalid class name */
    final class AnonymousClass1<TResult> implements OnSuccessListener {
        @Override // com.google.android.gms.tasks.OnSuccessListener
        public final void onSuccess(Object obj) {
            List sessionList = (List) obj;
            Intrinsics.checkNotNullParameter(sessionList, "sessionList");
            ArrayList arrayList = new ArrayList();
            Iterator it = sessionList.iterator();
            if (it.hasNext()) {
                ((SplitInstallSessionState) it.next()).g();
                throw null;
            }
            Iterator it2 = arrayList.iterator();
            if (it2.hasNext()) {
                Intrinsics.checkNotNullParameter(null, "<this>");
                throw null;
            }
        }
    }

    @Metadata
    /* renamed from: com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestProgressFlow$1$2, reason: invalid class name */
    final class AnonymousClass2 implements OnFailureListener {
        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(Exception exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            throw null;
        }
    }

    @Metadata
    /* renamed from: com.google.android.play.core.ktx.SplitInstallManagerKtxKt$requestProgressFlow$1$3, reason: invalid class name */
    final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            throw null;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        throw null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        new LinkedHashSet();
        throw null;
    }
}
