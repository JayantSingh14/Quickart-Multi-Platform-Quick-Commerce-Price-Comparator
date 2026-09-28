package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;
import java.util.Set;

/* loaded from: classes4.dex */
public interface StandardIntegrityManager {

    public static abstract class PrepareIntegrityTokenRequest {

        public static abstract class Builder {
            public abstract PrepareIntegrityTokenRequest a();

            public abstract Builder b(long j2);
        }

        public static Builder b() {
            c cVar = new c();
            cVar.f41833b = (byte) (cVar.f41833b | 2);
            return cVar;
        }

        public abstract long a();
    }

    public static abstract class StandardIntegrityToken {
        public abstract String a();
    }

    public interface StandardIntegrityTokenProvider {
        Task a(StandardIntegrityTokenRequest standardIntegrityTokenRequest);
    }

    public static abstract class StandardIntegrityTokenRequest {

        public static abstract class Builder {
            public abstract StandardIntegrityTokenRequest a();

            public abstract Builder b(String str);
        }

        public static Builder a() {
            f fVar = new f();
            com.google.android.play.integrity.internal.as asVarJ = com.google.android.play.integrity.internal.as.j();
            if (asVarJ == null) {
                throw new NullPointerException("Null verdictOptOut");
            }
            fVar.f41836b = asVarJ;
            return fVar;
        }

        public abstract String b();

        public abstract Set c();
    }

    Task a(PrepareIntegrityTokenRequest prepareIntegrityTokenRequest);
}
