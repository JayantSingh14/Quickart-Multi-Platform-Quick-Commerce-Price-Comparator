package androidx.privacysandbox.ads.adservices.topics;

import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresExtension.Container
@Metadata
@SuppressLint({"NewApi"})
@RestrictTo
@SourceDebugExtension
/* loaded from: classes3.dex */
public class TopicsManagerImplCommon extends TopicsManager {

    /* renamed from: a, reason: collision with root package name */
    public final android.adservices.topics.TopicsManager f11284a;

    public TopicsManagerImplCommon(android.adservices.topics.TopicsManager mTopicsManager) {
        Intrinsics.checkNotNullParameter(mTopicsManager, "mTopicsManager");
        this.f11284a = mTopicsManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.annotation.RequiresPermission
    @androidx.annotation.DoNotInline
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object d(androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon r5, androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest r6, kotlin.coroutines.Continuation<? super androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon$getTopics$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon$getTopics$1 r0 = (androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon$getTopics$1) r0
            int r1 = r0.f11288d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f11288d = r1
            goto L18
        L13:
            androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon$getTopics$1 r0 = new androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon$getTopics$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f11286b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f11288d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon r5 = r0.f11285a
            kotlin.ResultKt.b(r7)
            goto L65
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r7)
            android.adservices.topics.GetTopicsRequest r6 = r5.b(r6)
            r0.f11285a = r5
            r0.f11288d = r3
            kotlinx.coroutines.CancellableContinuationImpl r7 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.b(r0)
            r7.<init>(r3, r2)
            r7.s()
            android.adservices.topics.TopicsManager r2 = r5.f11284a
            androidx.arch.core.executor.a r3 = new androidx.arch.core.executor.a
            r4 = 1
            r3.<init>(r4)
            android.os.OutcomeReceiver r4 = androidx.core.os.OutcomeReceiverKt.a(r7)
            androidx.privacysandbox.ads.adservices.customaudience.a.w(r2, r6, r3, r4)
            java.lang.Object r7 = r7.r()
            if (r7 != r1) goto L62
            java.lang.String r6 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r6)
        L62:
            if (r7 != r1) goto L65
            return r1
        L65:
            android.adservices.topics.GetTopicsResponse r6 = androidx.privacysandbox.ads.adservices.customaudience.a.l(r7)
            androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse r5 = r5.c(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon.d(androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon, androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.privacysandbox.ads.adservices.topics.TopicsManager
    @RequiresPermission
    @DoNotInline
    @Nullable
    public Object a(@NotNull GetTopicsRequest getTopicsRequest, @NotNull Continuation<? super GetTopicsResponse> continuation) {
        return d(this, getTopicsRequest, continuation);
    }

    public android.adservices.topics.GetTopicsRequest b(GetTopicsRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(request, "request");
        android.adservices.topics.GetTopicsRequest getTopicsRequestBuild = androidx.privacysandbox.ads.adservices.customaudience.a.h().setAdsSdkName(request.f11275a).build();
        Intrinsics.checkNotNullExpressionValue(getTopicsRequestBuild, "Builder()\n            .s…ame)\n            .build()");
        return getTopicsRequestBuild;
    }

    public GetTopicsResponse c(android.adservices.topics.GetTopicsResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(response, "response");
        ArrayList arrayList = new ArrayList();
        Iterator it = response.getTopics().iterator();
        while (it.hasNext()) {
            android.adservices.topics.Topic topicM = androidx.privacysandbox.ads.adservices.customaudience.a.m(it.next());
            arrayList.add(new Topic(topicM.getTaxonomyVersion(), topicM.getModelVersion(), topicM.getTopicId()));
        }
        return new GetTopicsResponse(arrayList);
    }
}
