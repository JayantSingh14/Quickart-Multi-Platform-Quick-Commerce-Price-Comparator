package androidx.privacysandbox.ads.adservices.measurement;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.InputEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import j$.time.Instant;
import j$.time.TimeConversions;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresExtension.Container
@Metadata
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RestrictTo
@SourceDebugExtension
/* loaded from: classes3.dex */
public class MeasurementManagerImplCommon extends MeasurementManager {

    /* renamed from: a, reason: collision with root package name */
    public final android.adservices.measurement.MeasurementManager f11268a;

    public MeasurementManagerImplCommon(android.adservices.measurement.MeasurementManager mMeasurementManager) {
        Intrinsics.checkNotNullParameter(mMeasurementManager, "mMeasurementManager");
        this.f11268a = mMeasurementManager;
    }

    @DoNotInline
    public static Object h(MeasurementManagerImplCommon measurementManagerImplCommon, DeletionRequest deletionRequest, Continuation<? super Unit> frame) throws Throwable {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(frame));
        cancellableContinuationImpl.s();
        android.adservices.measurement.MeasurementManager measurementManager = measurementManagerImplCommon.f11268a;
        deletionRequest.getClass();
        android.adservices.measurement.DeletionRequest deletionRequestBuild = androidx.privacysandbox.ads.adservices.customaudience.a.d().setDeletionMode(0).setMatchBehavior(0).setStart(TimeConversions.convert((Instant) null)).setEnd(TimeConversions.convert((Instant) null)).setDomainUris(null).setOriginUris(null).build();
        Intrinsics.checkNotNullExpressionValue(deletionRequestBuild, "Builder()\n            .s…ris)\n            .build()");
        measurementManager.deleteRegistrations(deletionRequestBuild, new androidx.arch.core.executor.a(1), OutcomeReceiverKt.a(cancellableContinuationImpl));
        Object objR = cancellableContinuationImpl.r();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (objR == coroutineSingletons) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return objR == coroutineSingletons ? objR : Unit.f53572a;
    }

    @RequiresPermission
    @DoNotInline
    public static Object i(MeasurementManagerImplCommon measurementManagerImplCommon, Continuation<? super Integer> frame) throws Throwable {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(frame));
        cancellableContinuationImpl.s();
        measurementManagerImplCommon.f11268a.getMeasurementApiStatus(new androidx.arch.core.executor.a(1), OutcomeReceiverKt.a(cancellableContinuationImpl));
        Object objR = cancellableContinuationImpl.r();
        if (objR == CoroutineSingletons.f53689a) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return objR;
    }

    @RequiresPermission
    @DoNotInline
    public static Object j(MeasurementManagerImplCommon measurementManagerImplCommon, Uri uri, InputEvent inputEvent, Continuation<? super Unit> frame) throws Throwable {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(frame));
        cancellableContinuationImpl.s();
        measurementManagerImplCommon.f11268a.registerSource(uri, inputEvent, new androidx.arch.core.executor.a(1), OutcomeReceiverKt.a(cancellableContinuationImpl));
        Object objR = cancellableContinuationImpl.r();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (objR == coroutineSingletons) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return objR == coroutineSingletons ? objR : Unit.f53572a;
    }

    @RequiresPermission
    @DoNotInline
    @ExperimentalFeatures.RegisterSourceOptIn
    public static Object k(MeasurementManagerImplCommon measurementManagerImplCommon, SourceRegistrationRequest sourceRegistrationRequest, Continuation<? super Unit> continuation) {
        Object objC = CoroutineScopeKt.c(new MeasurementManagerImplCommon$registerSource$4(measurementManagerImplCommon, sourceRegistrationRequest, null), continuation);
        return objC == CoroutineSingletons.f53689a ? objC : Unit.f53572a;
    }

    @RequiresPermission
    @DoNotInline
    public static Object l(MeasurementManagerImplCommon measurementManagerImplCommon, Uri uri, Continuation<? super Unit> frame) throws Throwable {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(frame));
        cancellableContinuationImpl.s();
        measurementManagerImplCommon.f11268a.registerTrigger(uri, new androidx.arch.core.executor.a(1), OutcomeReceiverKt.a(cancellableContinuationImpl));
        Object objR = cancellableContinuationImpl.r();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (objR == coroutineSingletons) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return objR == coroutineSingletons ? objR : Unit.f53572a;
    }

    @RequiresPermission
    @DoNotInline
    public static Object m(MeasurementManagerImplCommon measurementManagerImplCommon, WebSourceRegistrationRequest webSourceRegistrationRequest, Continuation<? super Unit> continuation) {
        new CancellableContinuationImpl(1, IntrinsicsKt.b(continuation)).s();
        android.adservices.measurement.MeasurementManager measurementManager = measurementManagerImplCommon.f11268a;
        webSourceRegistrationRequest.getClass();
        androidx.privacysandbox.ads.adservices.customaudience.a.B();
        Intrinsics.checkNotNullParameter(null, "request");
        new ArrayList();
        throw null;
    }

    @RequiresPermission
    @DoNotInline
    public static Object n(MeasurementManagerImplCommon measurementManagerImplCommon, WebTriggerRegistrationRequest webTriggerRegistrationRequest, Continuation<? super Unit> continuation) {
        new CancellableContinuationImpl(1, IntrinsicsKt.b(continuation)).s();
        android.adservices.measurement.MeasurementManager measurementManager = measurementManagerImplCommon.f11268a;
        webTriggerRegistrationRequest.getClass();
        androidx.privacysandbox.ads.adservices.customaudience.a.D();
        Intrinsics.checkNotNullParameter(null, "request");
        new ArrayList();
        throw null;
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @DoNotInline
    @Nullable
    public Object a(@NotNull DeletionRequest deletionRequest, @NotNull Continuation<? super Unit> continuation) {
        return h(this, deletionRequest, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @RequiresPermission
    @DoNotInline
    @Nullable
    public Object b(@NotNull Continuation<? super Integer> continuation) {
        return i(this, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @RequiresPermission
    @DoNotInline
    @Nullable
    public Object c(@NotNull Uri uri, @Nullable InputEvent inputEvent, @NotNull Continuation<? super Unit> continuation) {
        return j(this, uri, inputEvent, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @Nullable
    @RequiresPermission
    @DoNotInline
    @ExperimentalFeatures.RegisterSourceOptIn
    public Object d(@NotNull SourceRegistrationRequest sourceRegistrationRequest, @NotNull Continuation<? super Unit> continuation) {
        return k(this, sourceRegistrationRequest, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @RequiresPermission
    @DoNotInline
    @Nullable
    public Object e(@NotNull Uri uri, @NotNull Continuation<? super Unit> continuation) {
        return l(this, uri, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @RequiresPermission
    @DoNotInline
    @Nullable
    public Object f(@NotNull WebSourceRegistrationRequest webSourceRegistrationRequest, @NotNull Continuation<? super Unit> continuation) {
        return m(this, webSourceRegistrationRequest, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @RequiresPermission
    @DoNotInline
    @Nullable
    public Object g(@NotNull WebTriggerRegistrationRequest webTriggerRegistrationRequest, @NotNull Continuation<? super Unit> continuation) {
        return n(this, webTriggerRegistrationRequest, continuation);
    }
}
