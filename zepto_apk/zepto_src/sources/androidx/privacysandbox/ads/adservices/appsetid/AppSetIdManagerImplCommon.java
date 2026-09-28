package androidx.privacysandbox.ads.adservices.appsetid;

import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresExtension.Container
@Metadata
@SuppressLint({"ClassVerificationFailure", "NewApi"})
@RestrictTo
@SourceDebugExtension
/* loaded from: classes3.dex */
public class AppSetIdManagerImplCommon extends AppSetIdManager {

    /* renamed from: a, reason: collision with root package name */
    public final android.adservices.appsetid.AppSetIdManager f11188a;

    public AppSetIdManagerImplCommon(android.adservices.appsetid.AppSetIdManager mAppSetIdManager) {
        Intrinsics.checkNotNullParameter(mAppSetIdManager, "mAppSetIdManager");
        this.f11188a = mAppSetIdManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.annotation.DoNotInline
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object b(androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon r6, kotlin.coroutines.Continuation<? super androidx.privacysandbox.ads.adservices.appsetid.AppSetId> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1 r0 = (androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1) r0
            int r1 = r0.f11192d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f11192d = r1
            goto L18
        L13:
            androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1 r0 = new androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f11190b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f11192d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon r6 = r0.f11189a
            kotlin.ResultKt.b(r7)
            goto L64
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            kotlin.ResultKt.b(r7)
            r0.f11189a = r6
            r0.f11192d = r3
            r6.getClass()
            kotlinx.coroutines.CancellableContinuationImpl r7 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.b(r0)
            r7.<init>(r3, r2)
            r7.s()
            android.adservices.appsetid.AppSetIdManager r2 = r6.f11188a
            androidx.arch.core.executor.a r4 = new androidx.arch.core.executor.a
            r5 = 1
            r4.<init>(r5)
            android.os.OutcomeReceiver r5 = androidx.core.os.OutcomeReceiverKt.a(r7)
            androidx.privacysandbox.ads.adservices.adid.a.z(r2, r4, r5)
            java.lang.Object r7 = r7.r()
            if (r7 != r1) goto L61
            java.lang.String r2 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
        L61:
            if (r7 != r1) goto L64
            return r1
        L64:
            android.adservices.appsetid.AppSetId r7 = androidx.privacysandbox.ads.adservices.adid.a.n(r7)
            r6.getClass()
            int r6 = androidx.privacysandbox.ads.adservices.adid.a.a(r7)
            java.lang.String r0 = "response.id"
            if (r6 != r3) goto L80
            androidx.privacysandbox.ads.adservices.appsetid.AppSetId r6 = new androidx.privacysandbox.ads.adservices.appsetid.AppSetId
            java.lang.String r7 = androidx.privacysandbox.ads.adservices.adid.a.u(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            r6.<init>(r7, r3)
            return r6
        L80:
            androidx.privacysandbox.ads.adservices.appsetid.AppSetId r6 = new androidx.privacysandbox.ads.adservices.appsetid.AppSetId
            java.lang.String r7 = androidx.privacysandbox.ads.adservices.adid.a.u(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            r0 = 2
            r6.<init>(r7, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon.b(androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @DoNotInline
    @Nullable
    public Object a(@NotNull Continuation<? super AppSetId> continuation) {
        return b(this, continuation);
    }
}
