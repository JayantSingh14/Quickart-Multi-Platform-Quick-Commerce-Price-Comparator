package androidx.privacysandbox.ads.adservices.customaudience;

import android.adservices.common.AdSelectionSignals;
import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import j$.time.Instant;
import j$.time.TimeConversions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresExtension.Container
@Metadata
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RestrictTo
@SourceDebugExtension
/* loaded from: classes3.dex */
public class CustomAudienceManagerImplCommon extends CustomAudienceManager {

    /* renamed from: a, reason: collision with root package name */
    public final android.adservices.customaudience.CustomAudienceManager f11197a;

    @RequiresExtension.Container
    @Metadata
    public static final class Ext10Impl {

        /* renamed from: a, reason: collision with root package name */
        public static final Companion f11198a = new Companion();

        @Metadata
        @SourceDebugExtension
        public static final class Companion {
            @RequiresPermission
            @DoNotInline
            @Nullable
            public final Object a(@NotNull android.adservices.customaudience.CustomAudienceManager customAudienceManager, @NotNull FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest, @NotNull Continuation<? super Unit> frame) throws Throwable {
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(frame));
                cancellableContinuationImpl.s();
                fetchAndJoinCustomAudienceRequest.getClass();
                android.adservices.customaudience.FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequestBuild = androidx.core.os.b.j().setName((String) null).setActivationTime(TimeConversions.convert((Instant) null)).setExpirationTime(TimeConversions.convert((Instant) null)).setUserBiddingSignals((AdSelectionSignals) null).build();
                Intrinsics.checkNotNullExpressionValue(fetchAndJoinCustomAudienceRequestBuild, "Builder(fetchUri)\n      …s())\n            .build()");
                customAudienceManager.fetchAndJoinCustomAudience(fetchAndJoinCustomAudienceRequestBuild, new androidx.arch.core.executor.a(1), OutcomeReceiverKt.a(cancellableContinuationImpl));
                Object objR = cancellableContinuationImpl.r();
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
                if (objR == coroutineSingletons) {
                    Intrinsics.checkNotNullParameter(frame, "frame");
                }
                return objR == coroutineSingletons ? objR : Unit.f53572a;
            }
        }
    }

    public CustomAudienceManagerImplCommon(android.adservices.customaudience.CustomAudienceManager customAudienceManager) {
        Intrinsics.checkNotNullParameter(customAudienceManager, "customAudienceManager");
        this.f11197a = customAudienceManager;
    }

    @RequiresPermission
    @DoNotInline
    public static Object b(CustomAudienceManagerImplCommon customAudienceManagerImplCommon, FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest, Continuation<? super Unit> continuation) throws Throwable {
        if (AdServicesInfo.a() < 10 && AdServicesInfo.b() < 10) {
            throw new UnsupportedOperationException("API is not available. Min version is API 31 ext 10");
        }
        Object objA = Ext10Impl.f11198a.a(customAudienceManagerImplCommon.f11197a, fetchAndJoinCustomAudienceRequest, continuation);
        return objA == CoroutineSingletons.f53689a ? objA : Unit.f53572a;
    }

    @RequiresPermission
    @DoNotInline
    public static Object d(CustomAudienceManagerImplCommon customAudienceManagerImplCommon, JoinCustomAudienceRequest joinCustomAudienceRequest, Continuation<? super Unit> continuation) {
        new CancellableContinuationImpl(1, IntrinsicsKt.b(continuation)).s();
        android.adservices.customaudience.CustomAudienceManager customAudienceManager = customAudienceManagerImplCommon.f11197a;
        a.z();
        joinCustomAudienceRequest.getClass();
        a.c();
        throw null;
    }

    @RequiresPermission
    @DoNotInline
    public static Object f(CustomAudienceManagerImplCommon customAudienceManagerImplCommon, LeaveCustomAudienceRequest leaveCustomAudienceRequest, Continuation<? super Unit> continuation) {
        new CancellableContinuationImpl(1, IntrinsicsKt.b(continuation)).s();
        android.adservices.customaudience.CustomAudienceManager customAudienceManager = customAudienceManagerImplCommon.f11197a;
        a.r();
        leaveCustomAudienceRequest.getClass();
        throw null;
    }

    @RequiresPermission
    @DoNotInline
    @Nullable
    public Object a(@NotNull FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest, @NotNull Continuation<? super Unit> continuation) {
        return b(this, fetchAndJoinCustomAudienceRequest, continuation);
    }

    @RequiresPermission
    @DoNotInline
    @Nullable
    public Object c(@NotNull JoinCustomAudienceRequest joinCustomAudienceRequest, @NotNull Continuation<? super Unit> continuation) {
        return d(this, joinCustomAudienceRequest, continuation);
    }

    @RequiresPermission
    @DoNotInline
    @Nullable
    public Object e(@NotNull LeaveCustomAudienceRequest leaveCustomAudienceRequest, @NotNull Continuation<? super Unit> continuation) {
        return f(this, leaveCustomAudienceRequest, continuation);
    }
}
