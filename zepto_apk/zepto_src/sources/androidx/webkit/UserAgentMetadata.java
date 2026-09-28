package androidx.webkit;

import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class UserAgentMetadata {

    public static final class BrandVersion {

        public static final class Builder {
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BrandVersion)) {
                return false;
            }
            ((BrandVersion) obj).getClass();
            return true;
        }

        public final int hashCode() {
            return Objects.hash(null, null, null);
        }

        public final String toString() {
            return "null,null,null";
        }
    }

    public static final class Builder {
        public Builder() {
            new ArrayList();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserAgentMetadata)) {
            return false;
        }
        ((UserAgentMetadata) obj).getClass();
        return true;
    }

    public final int hashCode() {
        Boolean bool = Boolean.FALSE;
        return Objects.hash(null, null, null, null, null, null, bool, 0, bool);
    }
}
