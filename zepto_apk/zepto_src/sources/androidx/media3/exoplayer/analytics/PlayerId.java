package androidx.media3.exoplayer.analytics;

import android.media.metrics.LogSessionId;
import androidx.annotation.RequiresApi;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.Objects;

@UnstableApi
/* loaded from: classes3.dex */
public final class PlayerId {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f6436d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final String f6437a;

    /* renamed from: b, reason: collision with root package name */
    public final LogSessionIdApi31 f6438b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f6439c;

    @RequiresApi
    public static final class LogSessionIdApi31 {

        /* renamed from: b, reason: collision with root package name */
        public static final LogSessionIdApi31 f6440b = new LogSessionIdApi31(LogSessionId.LOG_SESSION_ID_NONE);

        /* renamed from: a, reason: collision with root package name */
        public final LogSessionId f6441a;

        public LogSessionIdApi31(LogSessionId logSessionId) {
            this.f6441a = logSessionId;
        }
    }

    static {
        if (Util.f5744a < 31) {
            new PlayerId("");
        } else {
            new PlayerId(LogSessionIdApi31.f6440b, "");
        }
    }

    public PlayerId(String str) {
        Assertions.g(Util.f5744a < 31);
        this.f6437a = str;
        this.f6438b = null;
        this.f6439c = new Object();
    }

    public final LogSessionId a() {
        LogSessionIdApi31 logSessionIdApi31 = this.f6438b;
        logSessionIdApi31.getClass();
        return logSessionIdApi31.f6441a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerId)) {
            return false;
        }
        PlayerId playerId = (PlayerId) obj;
        return Objects.equals(this.f6437a, playerId.f6437a) && Objects.equals(this.f6438b, playerId.f6438b) && Objects.equals(this.f6439c, playerId.f6439c);
    }

    public final int hashCode() {
        return Objects.hash(this.f6437a, this.f6438b, this.f6439c);
    }

    public PlayerId(LogSessionId logSessionId, String str) {
        this(new LogSessionIdApi31(logSessionId), str);
    }

    public PlayerId(LogSessionIdApi31 logSessionIdApi31, String str) {
        this.f6438b = logSessionIdApi31;
        this.f6437a = str;
        this.f6439c = new Object();
    }
}
