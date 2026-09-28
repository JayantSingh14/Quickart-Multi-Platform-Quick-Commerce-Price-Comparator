package androidx.privacysandbox.ads.adservices.java.topics;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import androidx.privacysandbox.ads.adservices.topics.TopicsManager;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public abstract class TopicsManagerFutures {

    @Metadata
    public static final class CommonApiJavaImpl extends TopicsManagerFutures {

        /* renamed from: a, reason: collision with root package name */
        public final TopicsManager f11263a;

        public CommonApiJavaImpl(TopicsManager mTopicsManager) {
            Intrinsics.checkNotNullParameter(mTopicsManager, "mTopicsManager");
            this.f11263a = mTopicsManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures
        @RequiresPermission
        @DoNotInline
        @NotNull
        public ListenableFuture<GetTopicsResponse> b(@NotNull GetTopicsRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            DefaultScheduler defaultScheduler = Dispatchers.f54091a;
            return CoroutineAdapterKt.a(BuildersKt.a(CoroutineScopeKt.a(MainDispatcherLoader.f55099a), null, new TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1(this, request, null), 3));
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }

    public static final TopicsManagerFutures a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        TopicsManager topicsManagerA = TopicsManager.Companion.a(context);
        if (topicsManagerA != null) {
            return new CommonApiJavaImpl(topicsManagerA);
        }
        return null;
    }

    public abstract ListenableFuture b(GetTopicsRequest getTopicsRequest);
}
