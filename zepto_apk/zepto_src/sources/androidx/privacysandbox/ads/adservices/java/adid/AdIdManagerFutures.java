package androidx.privacysandbox.ads.adservices.java.adid;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.adid.AdId;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public abstract class AdIdManagerFutures {

    @Metadata
    public static final class Api33Ext4JavaImpl extends AdIdManagerFutures {
        @RequiresPermission
        @DoNotInline
        @NotNull
        public ListenableFuture<AdId> a() {
            return CoroutineAdapterKt.a(BuildersKt.a(CoroutineScopeKt.a(Dispatchers.f54091a), null, new AdIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1(this, null), 3));
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }
}
