package androidx.privacysandbox.ads.adservices.java.customaudience;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.customaudience.FetchAndJoinCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.customaudience.JoinCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.customaudience.LeaveCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public abstract class CustomAudienceManagerFutures {

    @Metadata
    public static final class Api33Ext4JavaImpl extends CustomAudienceManagerFutures {
        @RequiresPermission
        @DoNotInline
        @NotNull
        public ListenableFuture<Unit> a(@NotNull FetchAndJoinCustomAudienceRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            return CoroutineAdapterKt.a(BuildersKt.a(CoroutineScopeKt.a(Dispatchers.f54091a), null, new CustomAudienceManagerFutures$Api33Ext4JavaImpl$fetchAndJoinCustomAudienceAsync$1(this, request, null), 3));
        }

        @RequiresPermission
        @DoNotInline
        @NotNull
        public ListenableFuture<Unit> b(@NotNull JoinCustomAudienceRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            return CoroutineAdapterKt.a(BuildersKt.a(CoroutineScopeKt.a(Dispatchers.f54091a), null, new CustomAudienceManagerFutures$Api33Ext4JavaImpl$joinCustomAudienceAsync$1(this, request, null), 3));
        }

        @RequiresPermission
        @DoNotInline
        @NotNull
        public ListenableFuture<Unit> c(@NotNull LeaveCustomAudienceRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            return CoroutineAdapterKt.a(BuildersKt.a(CoroutineScopeKt.a(Dispatchers.f54091a), null, new CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1(this, request, null), 3));
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }
}
