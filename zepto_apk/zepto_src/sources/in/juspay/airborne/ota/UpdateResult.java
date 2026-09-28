package in.juspay.airborne.ota;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes4.dex */
public interface UpdateResult {

    @Metadata
    public interface Error extends UpdateResult {

        @Metadata
        public static final class RCFetchError implements Error {

            @NotNull
            public static final RCFetchError INSTANCE = new RCFetchError();

            private RCFetchError() {
            }
        }

        @Metadata
        public static final class Unknown implements Error {

            @NotNull
            public static final Unknown INSTANCE = new Unknown();

            private Unknown() {
            }
        }
    }

    @Metadata
    public static final class NA implements UpdateResult {

        @NotNull
        public static final NA INSTANCE = new NA();

        private NA() {
        }
    }

    @Metadata
    public static final class Ok implements UpdateResult {

        @NotNull
        private final ReleaseConfig releaseConfig;

        public Ok(@NotNull ReleaseConfig releaseConfig) {
            Intrinsics.checkNotNullParameter(releaseConfig, "releaseConfig");
            this.releaseConfig = releaseConfig;
        }

        public static /* synthetic */ Ok copy$default(Ok ok, ReleaseConfig releaseConfig, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                releaseConfig = ok.releaseConfig;
            }
            return ok.copy(releaseConfig);
        }

        @NotNull
        public final ReleaseConfig component1() {
            return this.releaseConfig;
        }

        @NotNull
        public final Ok copy(@NotNull ReleaseConfig releaseConfig) {
            Intrinsics.checkNotNullParameter(releaseConfig, "releaseConfig");
            return new Ok(releaseConfig);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Ok) && Intrinsics.b(this.releaseConfig, ((Ok) obj).releaseConfig);
        }

        @NotNull
        public final ReleaseConfig getReleaseConfig() {
            return this.releaseConfig;
        }

        public int hashCode() {
            return this.releaseConfig.hashCode();
        }

        @NotNull
        public String toString() {
            return "Ok(releaseConfig=" + this.releaseConfig + ')';
        }
    }

    @Metadata
    public static final class PackageUpdateTimeout implements UpdateResult {

        @Nullable
        private final ReleaseConfig releaseConfig;

        public PackageUpdateTimeout(@Nullable ReleaseConfig releaseConfig) {
            this.releaseConfig = releaseConfig;
        }

        public static /* synthetic */ PackageUpdateTimeout copy$default(PackageUpdateTimeout packageUpdateTimeout, ReleaseConfig releaseConfig, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                releaseConfig = packageUpdateTimeout.releaseConfig;
            }
            return packageUpdateTimeout.copy(releaseConfig);
        }

        @Nullable
        public final ReleaseConfig component1() {
            return this.releaseConfig;
        }

        @NotNull
        public final PackageUpdateTimeout copy(@Nullable ReleaseConfig releaseConfig) {
            return new PackageUpdateTimeout(releaseConfig);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PackageUpdateTimeout) && Intrinsics.b(this.releaseConfig, ((PackageUpdateTimeout) obj).releaseConfig);
        }

        @Nullable
        public final ReleaseConfig getReleaseConfig() {
            return this.releaseConfig;
        }

        public int hashCode() {
            ReleaseConfig releaseConfig = this.releaseConfig;
            if (releaseConfig == null) {
                return 0;
            }
            return releaseConfig.hashCode();
        }

        @NotNull
        public String toString() {
            return "PackageUpdateTimeout(releaseConfig=" + this.releaseConfig + ')';
        }
    }

    @Metadata
    public static final class ReleaseConfigFetchTimeout implements UpdateResult {

        @NotNull
        public static final ReleaseConfigFetchTimeout INSTANCE = new ReleaseConfigFetchTimeout();

        private ReleaseConfigFetchTimeout() {
        }
    }
}
