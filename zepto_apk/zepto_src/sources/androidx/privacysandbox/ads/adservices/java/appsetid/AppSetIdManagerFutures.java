package androidx.privacysandbox.ads.adservices.java.appsetid;

import androidx.annotation.DoNotInline;
import androidx.privacysandbox.ads.adservices.appsetid.AppSetId;
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
public abstract class AppSetIdManagerFutures {

    @Metadata
    public static final class Api33Ext4JavaImpl extends AppSetIdManagerFutures {
        @DoNotInline
        @NotNull
        public ListenableFuture<AppSetId> a() {
            return CoroutineAdapterKt.a(BuildersKt.a(CoroutineScopeKt.a(Dispatchers.f54091a), null, new AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1(this, null), 3));
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }
}
