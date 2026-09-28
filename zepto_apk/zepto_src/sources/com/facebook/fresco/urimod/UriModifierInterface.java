package com.facebook.fresco.urimod;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public interface UriModifierInterface {

    @Metadata
    public static final class DefaultImpls {
    }

    @Metadata
    public static abstract class ModificationResult {

        @Metadata
        public static final class Disabled extends ModificationResult {
        }

        @Metadata
        public static final class FallbackToMbpDiskCache extends ModificationResult {
            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof FallbackToMbpDiskCache)) {
                    return false;
                }
                ((FallbackToMbpDiskCache) obj).getClass();
                return true;
            }

            public final int hashCode() {
                return Boolean.hashCode(false);
            }

            @Override // com.facebook.fresco.urimod.UriModifierInterface.ModificationResult
            public final String toString() {
                return "FallbackToMbpDiskCache(isBestSize=false)";
            }
        }

        @Metadata
        public static final class FallbackToMbpMemoryCache extends ModificationResult {
            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof FallbackToMbpMemoryCache)) {
                    return false;
                }
                ((FallbackToMbpMemoryCache) obj).getClass();
                return true;
            }

            public final int hashCode() {
                throw null;
            }

            @Override // com.facebook.fresco.urimod.UriModifierInterface.ModificationResult
            public final String toString() {
                return "FallbackToMbpMemoryCache(isBestSize=null)";
            }
        }

        @Metadata
        public static final class FallbackToOriginalUrl extends ModificationResult {
            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof FallbackToOriginalUrl)) {
                    return false;
                }
                ((FallbackToOriginalUrl) obj).getClass();
                return true;
            }

            public final int hashCode() {
                return 0;
            }

            @Override // com.facebook.fresco.urimod.UriModifierInterface.ModificationResult
            public final String toString() {
                return "FallbackToOriginalUrl(bestAllowlistedSize=null)";
            }
        }

        @Metadata
        public static abstract class Modified extends ModificationResult {

            @Metadata
            public static final class ModifiedToAllowlistedSize extends Modified {
            }

            @Metadata
            public static final class ModifiedToMaxDimens extends Modified {
            }
        }

        @Metadata
        public static final class Unmodified extends ModificationResult {
            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Unmodified)) {
                    return false;
                }
                ((Unmodified) obj).getClass();
                return true;
            }

            public final int hashCode() {
                throw null;
            }

            @Override // com.facebook.fresco.urimod.UriModifierInterface.ModificationResult
            public final String toString() {
                return "Unmodified(reason=null, bestAllowlistedSize=null)";
            }
        }

        public String toString() {
            return null;
        }
    }
}
