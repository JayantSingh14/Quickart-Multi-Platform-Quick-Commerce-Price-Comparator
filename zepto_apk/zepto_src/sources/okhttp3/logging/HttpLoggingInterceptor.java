package okhttp3.logging;

import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.internal.platform.Platform;

@Metadata
/* loaded from: classes3.dex */
public final class HttpLoggingInterceptor implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    public final Logger f56887a;

    /* renamed from: b, reason: collision with root package name */
    public volatile EmptySet f56888b;

    /* renamed from: c, reason: collision with root package name */
    public volatile Level f56889c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class Level {

        /* renamed from: a, reason: collision with root package name */
        public static final Level f56890a;

        /* renamed from: b, reason: collision with root package name */
        public static final Level f56891b;

        /* renamed from: c, reason: collision with root package name */
        public static final Level f56892c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ Level[] f56893d;

        static {
            Level level = new Level("NONE", 0);
            f56890a = level;
            Level level2 = new Level("BASIC", 1);
            Level level3 = new Level("HEADERS", 2);
            f56891b = level3;
            Level level4 = new Level("BODY", 3);
            f56892c = level4;
            f56893d = new Level[]{level, level2, level3, level4};
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) f56893d.clone();
        }
    }

    @Metadata
    public interface Logger {

        /* renamed from: a, reason: collision with root package name */
        public static final Logger f56894a = new Companion.DefaultLogger();

        @Metadata
        public static final class Companion {

            @Metadata
            public static final class DefaultLogger implements Logger {
                @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
                public final void a(String message) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    Platform platform = Platform.f56791a;
                    Platform.j(Platform.f56791a, message, 6);
                }
            }
        }

        void a(String str);
    }

    @JvmOverloads
    public HttpLoggingInterceptor() {
        Logger logger = Logger.f56894a;
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f56887a = logger;
        this.f56888b = EmptySet.f53611a;
        this.f56889c = Level.f56890a;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00f8 A[LOOP:0: B:45:0x00f6->B:46:0x00f8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0104  */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final okhttp3.Response a(okhttp3.internal.http.RealInterceptorChain r24) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 953
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.logging.HttpLoggingInterceptor.a(okhttp3.internal.http.RealInterceptorChain):okhttp3.Response");
    }

    public final void b(Headers headers, int i2) {
        this.f56888b.contains(headers.f(i2));
        String strM = headers.m(i2);
        this.f56887a.a(headers.f(i2) + ": " + strM);
    }
}
