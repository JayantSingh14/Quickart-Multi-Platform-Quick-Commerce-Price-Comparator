package androidx.privacysandbox.ads.adservices.adselection;

import android.annotation.SuppressLint;
import android.view.InputEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.arch.core.executor.a;
import androidx.core.os.OutcomeReceiverKt;
import androidx.core.os.b;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
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
public class AdSelectionManagerImplCommon extends AdSelectionManager {

    /* renamed from: a, reason: collision with root package name */
    public final android.adservices.adselection.AdSelectionManager f11164a;

    @RequiresExtension.Container
    @Metadata
    public static final class Ext10Impl {

        /* renamed from: a, reason: collision with root package name */
        public static final Companion f11165a = new Companion();

        @Metadata
        @SourceDebugExtension
        public static final class Companion {
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @androidx.annotation.RequiresPermission
            @androidx.annotation.DoNotInline
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(@org.jetbrains.annotations.NotNull android.adservices.adselection.AdSelectionManager r5, @org.jetbrains.annotations.NotNull androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataRequest r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataOutcome> r7) {
                /*
                    r4 = this;
                    boolean r0 = r7 instanceof androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1
                    if (r0 == 0) goto L13
                    r0 = r7
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1 r0 = (androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1) r0
                    int r1 = r0.f11169d
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f11169d = r1
                    goto L18
                L13:
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1 r0 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1
                    r0.<init>(r4, r7)
                L18:
                    java.lang.Object r7 = r0.f11167b
                    kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                    int r1 = r0.f11169d
                    r2 = 1
                    if (r1 == 0) goto L3d
                    if (r1 != r2) goto L35
                    java.lang.Object r5 = r0.f11166a
                    androidx.privacysandbox.ads.adservices.adid.a.A(r5)
                    kotlin.ResultKt.b(r7)
                    android.adservices.adselection.GetAdSelectionDataOutcome r5 = androidx.core.os.b.b(r7)
                    androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataOutcome r6 = new androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataOutcome
                    r6.<init>(r5)
                    return r6
                L35:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L3d:
                    kotlin.ResultKt.b(r7)
                    r0.f11166a = r5
                    r0.f11169d = r2
                    kotlinx.coroutines.CancellableContinuationImpl r5 = new kotlinx.coroutines.CancellableContinuationImpl
                    kotlin.coroutines.Continuation r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.b(r0)
                    r5.<init>(r2, r7)
                    r5.s()
                    r6.getClass()
                    int r5 = androidx.privacysandbox.ads.adservices.internal.AdServicesInfo.a()
                    r7 = 0
                    java.lang.String r0 = "request"
                    r1 = 12
                    if (r5 >= r1) goto L6c
                    int r5 = androidx.privacysandbox.ads.adservices.internal.AdServicesInfo.b()
                    if (r5 < r1) goto L65
                    goto L6c
                L65:
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                    androidx.core.os.b.z()
                    throw r7
                L6c:
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                    androidx.core.os.b.z()
                    throw r7
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon.Ext10Impl.Companion.a(android.adservices.adselection.AdSelectionManager, androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataRequest, kotlin.coroutines.Continuation):java.lang.Object");
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @androidx.annotation.RequiresPermission
            @androidx.annotation.DoNotInline
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object b(@org.jetbrains.annotations.NotNull android.adservices.adselection.AdSelectionManager r5, @org.jetbrains.annotations.NotNull androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome> r7) throws java.lang.Throwable {
                /*
                    r4 = this;
                    boolean r0 = r7 instanceof androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$persistAdSelectionResult$1
                    if (r0 == 0) goto L13
                    r0 = r7
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$persistAdSelectionResult$1 r0 = (androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$persistAdSelectionResult$1) r0
                    int r1 = r0.f11173d
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f11173d = r1
                    goto L18
                L13:
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$persistAdSelectionResult$1 r0 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$persistAdSelectionResult$1
                    r0.<init>(r4, r7)
                L18:
                    java.lang.Object r7 = r0.f11171b
                    kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                    int r2 = r0.f11173d
                    r3 = 1
                    if (r2 == 0) goto L34
                    if (r2 != r3) goto L2c
                    java.lang.Object r5 = r0.f11170a
                    androidx.privacysandbox.ads.adservices.adid.a.A(r5)
                    kotlin.ResultKt.b(r7)
                    goto L7e
                L2c:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L34:
                    kotlin.ResultKt.b(r7)
                    r0.f11170a = r5
                    r0.f11173d = r3
                    kotlinx.coroutines.CancellableContinuationImpl r7 = new kotlinx.coroutines.CancellableContinuationImpl
                    kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.b(r0)
                    r7.<init>(r3, r2)
                    r7.s()
                    r6.getClass()
                    android.adservices.adselection.PersistAdSelectionResultRequest$Builder r6 = androidx.core.os.b.c()
                    android.adservices.adselection.PersistAdSelectionResultRequest$Builder r6 = androidx.core.os.b.d(r6)
                    android.adservices.adselection.PersistAdSelectionResultRequest$Builder r6 = androidx.core.os.b.x(r6)
                    android.adservices.adselection.PersistAdSelectionResultRequest$Builder r6 = androidx.core.os.b.A(r6)
                    android.adservices.adselection.PersistAdSelectionResultRequest r6 = androidx.core.os.b.e(r6)
                    java.lang.String r2 = "Builder()\n            .s…ult)\n            .build()"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
                    androidx.arch.core.executor.a r2 = new androidx.arch.core.executor.a
                    r3 = 1
                    r2.<init>(r3)
                    android.os.OutcomeReceiver r3 = androidx.core.os.OutcomeReceiverKt.a(r7)
                    androidx.core.os.b.s(r5, r6, r2, r3)
                    java.lang.Object r7 = r7.r()
                    if (r7 != r1) goto L7b
                    java.lang.String r5 = "frame"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r5)
                L7b:
                    if (r7 != r1) goto L7e
                    return r1
                L7e:
                    android.adservices.adselection.AdSelectionOutcome r5 = androidx.privacysandbox.ads.adservices.adid.a.m(r7)
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome r6 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome
                    r6.<init>(r5)
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon.Ext10Impl.Companion.b(android.adservices.adselection.AdSelectionManager, androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest, kotlin.coroutines.Continuation):java.lang.Object");
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @androidx.annotation.RequiresPermission
            @androidx.annotation.DoNotInline
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object c(@org.jetbrains.annotations.NotNull android.adservices.adselection.AdSelectionManager r5, @org.jetbrains.annotations.NotNull androidx.privacysandbox.ads.adservices.adselection.AdSelectionFromOutcomesConfig r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome> r7) {
                /*
                    r4 = this;
                    boolean r0 = r7 instanceof androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1
                    if (r0 == 0) goto L13
                    r0 = r7
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1 r0 = (androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1) r0
                    int r1 = r0.f11177d
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f11177d = r1
                    goto L18
                L13:
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1 r0 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1
                    r0.<init>(r4, r7)
                L18:
                    java.lang.Object r7 = r0.f11175b
                    kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                    int r1 = r0.f11177d
                    r2 = 1
                    if (r1 == 0) goto L3d
                    if (r1 != r2) goto L35
                    java.lang.Object r5 = r0.f11174a
                    androidx.privacysandbox.ads.adservices.adid.a.A(r5)
                    kotlin.ResultKt.b(r7)
                    android.adservices.adselection.AdSelectionOutcome r5 = androidx.privacysandbox.ads.adservices.adid.a.m(r7)
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome r6 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome
                    r6.<init>(r5)
                    return r6
                L35:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L3d:
                    kotlin.ResultKt.b(r7)
                    r0.f11174a = r5
                    r0.f11177d = r2
                    kotlinx.coroutines.CancellableContinuationImpl r5 = new kotlinx.coroutines.CancellableContinuationImpl
                    kotlin.coroutines.Continuation r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.b(r0)
                    r5.<init>(r2, r7)
                    r5.s()
                    r6.getClass()
                    androidx.core.os.b.r()
                    r5 = 0
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon.Ext10Impl.Companion.c(android.adservices.adselection.AdSelectionManager, androidx.privacysandbox.ads.adservices.adselection.AdSelectionFromOutcomesConfig, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }
    }

    @RequiresExtension.Container
    @Metadata
    public static final class Ext8Impl {

        /* renamed from: a, reason: collision with root package name */
        public static final Companion f11178a = new Companion();

        @Metadata
        @SourceDebugExtension
        public static final class Companion {
            @RequiresPermission
            @DoNotInline
            @Nullable
            public final Object a(@NotNull android.adservices.adselection.AdSelectionManager adSelectionManager, @NotNull ReportEventRequest request, @NotNull Continuation<? super Unit> frame) throws Throwable {
                android.adservices.adselection.ReportEventRequest reportEventRequestBuild;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(frame));
                cancellableContinuationImpl.s();
                request.getClass();
                if (AdServicesInfo.a() >= 10 || AdServicesInfo.b() >= 10) {
                    Intrinsics.checkNotNullParameter(request, "request");
                    b.B();
                    reportEventRequestBuild = b.f().setInputEvent((InputEvent) null).build();
                    Intrinsics.checkNotNullExpressionValue(reportEventRequestBuild, "Builder(\n               …                 .build()");
                } else {
                    Intrinsics.checkNotNullParameter(request, "request");
                    b.B();
                    reportEventRequestBuild = b.f().build();
                    Intrinsics.checkNotNullExpressionValue(reportEventRequestBuild, "Builder(\n               …                 .build()");
                }
                adSelectionManager.reportEvent(reportEventRequestBuild, new a(1), OutcomeReceiverKt.a(cancellableContinuationImpl));
                Object objR = cancellableContinuationImpl.r();
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
                if (objR == coroutineSingletons) {
                    Intrinsics.checkNotNullParameter(frame, "frame");
                }
                return objR == coroutineSingletons ? objR : Unit.f53572a;
            }

            @RequiresPermission
            @DoNotInline
            @Nullable
            public final Object b(@NotNull android.adservices.adselection.AdSelectionManager adSelectionManager, @NotNull UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest, @NotNull Continuation<? super Unit> continuation) {
                new CancellableContinuationImpl(1, IntrinsicsKt.b(continuation)).s();
                updateAdCounterHistogramRequest.getClass();
                b.C();
                throw null;
            }
        }
    }

    public AdSelectionManagerImplCommon(android.adservices.adselection.AdSelectionManager mAdSelectionManager) {
        Intrinsics.checkNotNullParameter(mAdSelectionManager, "mAdSelectionManager");
        this.f11164a = mAdSelectionManager;
    }

    @RequiresPermission
    @DoNotInline
    public static /* synthetic */ Object b(AdSelectionManagerImplCommon adSelectionManagerImplCommon, GetAdSelectionDataRequest getAdSelectionDataRequest, Continuation<? super GetAdSelectionDataOutcome> continuation) {
        if (AdServicesInfo.a() >= 10 || AdServicesInfo.b() >= 10) {
            return Ext10Impl.f11165a.a(adSelectionManagerImplCommon.f11164a, getAdSelectionDataRequest, continuation);
        }
        throw new UnsupportedOperationException("API is not available. Min version is API 31 ext 10");
    }

    @RequiresPermission
    @DoNotInline
    public static /* synthetic */ Object d(AdSelectionManagerImplCommon adSelectionManagerImplCommon, PersistAdSelectionResultRequest persistAdSelectionResultRequest, Continuation<? super AdSelectionOutcome> continuation) {
        if (AdServicesInfo.a() >= 10 || AdServicesInfo.b() >= 10) {
            return Ext10Impl.f11165a.b(adSelectionManagerImplCommon.f11164a, persistAdSelectionResultRequest, continuation);
        }
        throw new UnsupportedOperationException("API is not available. Min version is API 31 ext 10");
    }

    @RequiresPermission
    @DoNotInline
    public static Object f(AdSelectionManagerImplCommon adSelectionManagerImplCommon, ReportEventRequest reportEventRequest, Continuation<? super Unit> continuation) throws Throwable {
        if (AdServicesInfo.a() < 8 && AdServicesInfo.b() < 9) {
            throw new UnsupportedOperationException("API is unsupported. Min version is API 33 ext 8 or API 31/32 ext 9");
        }
        Object objA = Ext8Impl.f11178a.a(adSelectionManagerImplCommon.f11164a, reportEventRequest, continuation);
        return objA == CoroutineSingletons.f53689a ? objA : Unit.f53572a;
    }

    @RequiresPermission
    @DoNotInline
    public static Object h(AdSelectionManagerImplCommon adSelectionManagerImplCommon, ReportImpressionRequest request, Continuation<? super Unit> frame) throws Throwable {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(frame));
        cancellableContinuationImpl.s();
        android.adservices.adselection.AdSelectionManager adSelectionManager = adSelectionManagerImplCommon.f11164a;
        request.getClass();
        if (AdServicesInfo.a() < 10 && AdServicesInfo.b() < 10) {
            Intrinsics.checkNotNullParameter(request, "request");
            if (Intrinsics.b(null, AdSelectionConfig.f11158f)) {
                throw new UnsupportedOperationException("adSelectionConfig is mandatory forAPI versions lower than ext 10");
            }
            androidx.privacysandbox.ads.adservices.adid.a.v();
            throw null;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        if (!Intrinsics.b(null, AdSelectionConfig.f11158f)) {
            androidx.privacysandbox.ads.adservices.adid.a.v();
            throw null;
        }
        androidx.privacysandbox.ads.adservices.adid.a.v();
        adSelectionManager.reportImpression(b.i(), new a(1), OutcomeReceiverKt.a(cancellableContinuationImpl));
        Object objR = cancellableContinuationImpl.r();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (objR == coroutineSingletons) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return objR == coroutineSingletons ? objR : Unit.f53572a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.annotation.RequiresPermission
    @androidx.annotation.DoNotInline
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object k(androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon r9, androidx.privacysandbox.ads.adservices.adselection.AdSelectionConfig r10, kotlin.coroutines.Continuation<? super androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome> r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11 instanceof androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$selectAds$1
            if (r0 == 0) goto L13
            r0 = r11
            androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$selectAds$1 r0 = (androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$selectAds$1) r0
            int r1 = r0.f11181c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f11181c = r1
            goto L18
        L13:
            androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$selectAds$1 r0 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$selectAds$1
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.f11179a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f11181c
            r3 = 1
            if (r2 == 0) goto L30
            if (r2 != r3) goto L28
            kotlin.ResultKt.b(r11)
            goto Lf3
        L28:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L30:
            kotlin.ResultKt.b(r11)
            r10.getClass()
            android.adservices.adselection.AdSelectionConfig$Builder r11 = androidx.privacysandbox.ads.adservices.adid.a.e()
            android.adservices.common.AdSelectionSignals r2 = androidx.privacysandbox.ads.adservices.adid.a.p()
            java.lang.String r4 = "fromString(signals)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            android.adservices.adselection.AdSelectionConfig$Builder r11 = androidx.privacysandbox.ads.adservices.adid.a.g(r11, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            kotlin.collections.EmptyList r5 = r10.f11160b
            r5.getClass()
            kotlin.collections.EmptyIterator r5 = kotlin.collections.EmptyIterator.f53608a
            r5.getClass()
            android.adservices.adselection.AdSelectionConfig$Builder r11 = androidx.privacysandbox.ads.adservices.adid.a.i(r11, r2)
            android.net.Uri r2 = android.net.Uri.EMPTY
            android.adservices.adselection.AdSelectionConfig$Builder r11 = androidx.privacysandbox.ads.adservices.adid.a.f(r11)
            android.adservices.common.AdTechIdentifier r2 = androidx.privacysandbox.ads.adservices.adid.a.q()
            java.lang.String r5 = "fromString(identifier)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            android.adservices.adselection.AdSelectionConfig$Builder r11 = androidx.privacysandbox.ads.adservices.adid.a.h(r11, r2)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.Map r10 = r10.f11163e
            java.util.Set r6 = r10.keySet()
            java.util.Iterator r6 = r6.iterator()
        L7c:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto La7
            java.lang.Object r7 = r6.next()
            androidx.privacysandbox.ads.adservices.common.AdTechIdentifier r7 = (androidx.privacysandbox.ads.adservices.common.AdTechIdentifier) r7
            r7.getClass()
            android.adservices.common.AdTechIdentifier r8 = androidx.privacysandbox.ads.adservices.adid.a.q()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)
            java.lang.Object r7 = r10.get(r7)
            androidx.privacysandbox.ads.adservices.common.AdSelectionSignals r7 = (androidx.privacysandbox.ads.adservices.common.AdSelectionSignals) r7
            if (r7 == 0) goto La2
            android.adservices.common.AdSelectionSignals r7 = androidx.privacysandbox.ads.adservices.adid.a.p()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            goto La3
        La2:
            r7 = 0
        La3:
            r2.put(r8, r7)
            goto L7c
        La7:
            android.adservices.adselection.AdSelectionConfig$Builder r10 = androidx.privacysandbox.ads.adservices.adid.a.j(r11, r2)
            android.adservices.common.AdSelectionSignals r11 = androidx.privacysandbox.ads.adservices.adid.a.p()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r4)
            android.adservices.adselection.AdSelectionConfig$Builder r10 = androidx.privacysandbox.ads.adservices.adid.a.D(r10, r11)
            android.net.Uri r11 = android.net.Uri.EMPTY
            android.adservices.adselection.AdSelectionConfig$Builder r10 = androidx.privacysandbox.ads.adservices.adid.a.C(r10)
            android.adservices.adselection.AdSelectionConfig r10 = androidx.privacysandbox.ads.adservices.adid.a.k(r10)
            java.lang.String r11 = "Builder()\n            .s…Uri)\n            .build()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            r0.f11181c = r3
            r9.getClass()
            kotlinx.coroutines.CancellableContinuationImpl r11 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.b(r0)
            r11.<init>(r3, r2)
            r11.s()
            android.adservices.adselection.AdSelectionManager r9 = r9.f11164a
            androidx.arch.core.executor.a r2 = new androidx.arch.core.executor.a
            r3 = 1
            r2.<init>(r3)
            android.os.OutcomeReceiver r3 = androidx.core.os.OutcomeReceiverKt.a(r11)
            androidx.privacysandbox.ads.adservices.adid.a.x(r9, r10, r2, r3)
            java.lang.Object r11 = r11.r()
            if (r11 != r1) goto Lf0
            java.lang.String r9 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r9)
        Lf0:
            if (r11 != r1) goto Lf3
            return r1
        Lf3:
            android.adservices.adselection.AdSelectionOutcome r9 = androidx.privacysandbox.ads.adservices.adid.a.m(r11)
            androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome r10 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome
            r10.<init>(r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon.k(androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon, androidx.privacysandbox.ads.adservices.adselection.AdSelectionConfig, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @RequiresPermission
    @DoNotInline
    public static /* synthetic */ Object l(AdSelectionManagerImplCommon adSelectionManagerImplCommon, AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig, Continuation<? super AdSelectionOutcome> continuation) {
        if (AdServicesInfo.a() >= 10 || AdServicesInfo.b() >= 10) {
            return Ext10Impl.f11165a.c(adSelectionManagerImplCommon.f11164a, adSelectionFromOutcomesConfig, continuation);
        }
        throw new UnsupportedOperationException("API is not available. Min version is API 31 ext 10");
    }

    @RequiresPermission
    @DoNotInline
    public static Object n(AdSelectionManagerImplCommon adSelectionManagerImplCommon, UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest, Continuation<? super Unit> continuation) {
        if (AdServicesInfo.a() < 8 && AdServicesInfo.b() < 9) {
            throw new UnsupportedOperationException("API is unsupported. Min version is API 33 ext 8 or API 31/32 ext 9");
        }
        Object objB = Ext8Impl.f11178a.b(adSelectionManagerImplCommon.f11164a, updateAdCounterHistogramRequest, continuation);
        return objB == CoroutineSingletons.f53689a ? objB : Unit.f53572a;
    }

    @RequiresPermission
    @DoNotInline
    @Nullable
    public Object a(@NotNull GetAdSelectionDataRequest getAdSelectionDataRequest, @NotNull Continuation<? super GetAdSelectionDataOutcome> continuation) {
        return b(this, getAdSelectionDataRequest, continuation);
    }

    @RequiresPermission
    @DoNotInline
    @Nullable
    public Object c(@NotNull PersistAdSelectionResultRequest persistAdSelectionResultRequest, @NotNull Continuation<? super AdSelectionOutcome> continuation) {
        return d(this, persistAdSelectionResultRequest, continuation);
    }

    @RequiresPermission
    @DoNotInline
    @Nullable
    public Object e(@NotNull ReportEventRequest reportEventRequest, @NotNull Continuation<? super Unit> continuation) {
        return f(this, reportEventRequest, continuation);
    }

    @RequiresPermission
    @DoNotInline
    @Nullable
    public Object g(@NotNull ReportImpressionRequest reportImpressionRequest, @NotNull Continuation<? super Unit> continuation) {
        return h(this, reportImpressionRequest, continuation);
    }

    @RequiresPermission
    @DoNotInline
    @Nullable
    public Object i(@NotNull AdSelectionConfig adSelectionConfig, @NotNull Continuation<? super AdSelectionOutcome> continuation) {
        return k(this, adSelectionConfig, continuation);
    }

    @RequiresPermission
    @DoNotInline
    @Nullable
    public Object j(@NotNull AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig, @NotNull Continuation<? super AdSelectionOutcome> continuation) {
        return l(this, adSelectionFromOutcomesConfig, continuation);
    }

    @RequiresPermission
    @DoNotInline
    @Nullable
    public Object m(@NotNull UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest, @NotNull Continuation<? super Unit> continuation) {
        return n(this, updateAdCounterHistogramRequest, continuation);
    }
}
