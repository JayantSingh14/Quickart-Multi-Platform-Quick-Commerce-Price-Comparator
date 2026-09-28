package io.sentry.clientreport;

import io.sentry.util.Objects;
import java.util.Arrays;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
final class ClientReportKey {

    /* renamed from: a, reason: collision with root package name */
    public final String f52715a;

    /* renamed from: b, reason: collision with root package name */
    public final String f52716b;

    public ClientReportKey(String str, String str2) {
        this.f52715a = str;
        this.f52716b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientReportKey)) {
            return false;
        }
        ClientReportKey clientReportKey = (ClientReportKey) obj;
        return Objects.a(this.f52715a, clientReportKey.f52715a) && Objects.a(this.f52716b, clientReportKey.f52716b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f52715a, this.f52716b});
    }
}
