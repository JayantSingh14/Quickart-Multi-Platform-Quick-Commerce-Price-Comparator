package androidx.privacysandbox.ads.adservices.adid;

import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
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
public class AdIdManagerImplCommon extends AdIdManager {

    /* renamed from: a, reason: collision with root package name */
    public final android.adservices.adid.AdIdManager f11153a;

    public AdIdManagerImplCommon(android.adservices.adid.AdIdManager mAdIdManager) {
        Intrinsics.checkNotNullParameter(mAdIdManager, "mAdIdManager");
        this.f11153a = mAdIdManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.annotation.RequiresPermission
    @androidx.annotation.DoNotInline
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object b(androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon r5, kotlin.coroutines.Continuation<? super androidx.privacysandbox.ads.adservices.adid.AdId> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon$getAdId$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon$getAdId$1 r0 = (androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon$getAdId$1) r0
            int r1 = r0.f11157d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f11157d = r1
            goto L18
        L13:
            androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon$getAdId$1 r0 = new androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon$getAdId$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f11155b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f11157d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon r5 = r0.f11154a
            kotlin.ResultKt.b(r6)
            goto L64
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r6)
            r0.f11154a = r5
            r0.f11157d = r3
            r5.getClass()
            kotlinx.coroutines.CancellableContinuationImpl r6 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.b(r0)
            r6.<init>(r3, r2)
            r6.s()
            android.adservices.adid.AdIdManager r2 = r5.f11153a
            androidx.arch.core.executor.a r3 = new androidx.arch.core.executor.a
            r4 = 1
            r3.<init>(r4)
            android.os.OutcomeReceiver r4 = androidx.core.os.OutcomeReceiverKt.a(r6)
            androidx.privacysandbox.ads.adservices.adid.a.w(r2, r3, r4)
            java.lang.Object r6 = r6.r()
            if (r6 != r1) goto L61
            java.lang.String r2 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
        L61:
            if (r6 != r1) goto L64
            return r1
        L64:
            android.adservices.adid.AdId r6 = androidx.privacysandbox.ads.adservices.adid.a.c(r6)
            r5.getClass()
            androidx.privacysandbox.ads.adservices.adid.AdId r5 = new androidx.privacysandbox.ads.adservices.adid.AdId
            java.lang.String r0 = androidx.privacysandbox.ads.adservices.adid.a.t(r6)
            java.lang.String r1 = "response.adId"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r6 = androidx.privacysandbox.ads.adservices.adid.a.B(r6)
            r5.<init>(r0, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon.b(androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @RequiresPermission
    @DoNotInline
    @Nullable
    public Object a(@NotNull Continuation<? super AdId> continuation) {
        return b(this, continuation);
    }
}
