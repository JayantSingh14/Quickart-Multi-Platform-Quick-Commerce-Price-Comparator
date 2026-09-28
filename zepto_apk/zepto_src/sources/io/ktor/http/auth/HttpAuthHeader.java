package io.ktor.http.auth;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes3.dex */
public abstract class HttpAuthHeader {

    @Metadata
    public static final class Companion {
    }

    @Metadata
    @SourceDebugExtension
    public static final class Parameterized extends HttpAuthHeader {

        @Metadata
        public /* synthetic */ class WhenMappings {
            static {
                int[] iArr = new int[HeaderValueEncoding.values().length];
                try {
                    iArr[0] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[1] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[2] = 3;
                } catch (NoSuchFieldError unused3) {
                }
            }
        }

        @Override // io.ktor.http.auth.HttpAuthHeader
        public final String a() {
            Intrinsics.checkNotNullParameter(null, "encoding");
            throw null;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Parameterized)) {
                return false;
            }
            Parameterized parameterized = (Parameterized) obj;
            parameterized.getClass();
            parameterized.getClass();
            return true;
        }

        public final int hashCode() {
            Locale locale = Locale.ROOT;
            throw null;
        }
    }

    @Metadata
    public static final class Parameters {
    }

    @Metadata
    public static final class Single extends HttpAuthHeader {
        @Override // io.ktor.http.auth.HttpAuthHeader
        public final String a() {
            return "null null";
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Single)) {
                return false;
            }
            Single single = (Single) obj;
            single.getClass();
            single.getClass();
            return true;
        }

        public final int hashCode() {
            Locale locale = Locale.ROOT;
            throw null;
        }
    }

    public abstract String a();

    public final String toString() {
        return a();
    }
}
