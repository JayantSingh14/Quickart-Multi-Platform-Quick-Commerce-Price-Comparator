package com.google.common.reflect;

import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class ClassPath {

    public static final class ClassInfo extends ResourceInfo {
        @Override // com.google.common.reflect.ClassPath.ResourceInfo
        public final String toString() {
            return null;
        }
    }

    public static final class LocationInfo {
        public final boolean equals(Object obj) {
            if (!(obj instanceof LocationInfo)) {
                return false;
            }
            ((LocationInfo) obj).getClass();
            throw null;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }

    public static class ResourceInfo {
        public final boolean equals(Object obj) {
            if (!(obj instanceof ResourceInfo)) {
                return false;
            }
            ((ResourceInfo) obj).getClass();
            throw null;
        }

        public final int hashCode() {
            throw null;
        }

        public String toString() {
            return null;
        }
    }

    static {
        Logger.getLogger(ClassPath.class.getName());
        StringUtils.SPACE.charAt(0);
    }
}
