package coil3.network;

import coil3.annotation.ExperimentalCoilApi;
import coil3.network.internal.DefaultCacheStrategy;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@ExperimentalCoilApi
/* loaded from: classes.dex */
public interface CacheStrategy {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @JvmField
    @NotNull
    public static final CacheStrategy DEFAULT = new DefaultCacheStrategy();

    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    @Nullable
    Object read(@NotNull NetworkResponse networkResponse, @NotNull NetworkRequest networkRequest, @NotNull Options options, @NotNull Continuation<? super ReadResult> continuation);

    @Nullable
    Object write(@Nullable NetworkResponse networkResponse, @NotNull NetworkRequest networkRequest, @NotNull NetworkResponse networkResponse2, @NotNull Options options, @NotNull Continuation<? super WriteResult> continuation);

    @Metadata
    public static final class WriteResult {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @JvmField
        @NotNull
        public static final WriteResult DISABLED = new WriteResult();

        @Nullable
        private final NetworkResponse response;

        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public WriteResult(@NotNull NetworkResponse networkResponse) {
            this.response = networkResponse;
        }

        @Nullable
        public final NetworkResponse getResponse() {
            return this.response;
        }

        public WriteResult() {
            this.response = null;
        }
    }

    @Metadata
    public static final class ReadResult {

        @Nullable
        private final NetworkRequest request;

        @Nullable
        private final NetworkResponse response;

        public ReadResult(@NotNull NetworkRequest networkRequest) {
            this.request = networkRequest;
            this.response = null;
        }

        @Nullable
        public final NetworkRequest getRequest() {
            return this.request;
        }

        @Nullable
        public final NetworkResponse getResponse() {
            return this.response;
        }

        public ReadResult(@NotNull NetworkResponse networkResponse) {
            this.request = null;
            this.response = networkResponse;
        }
    }
}
