package okhttp3.internal.ws;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class WebSocketExtensions {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f56857a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f56858b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f56859c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f56860d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f56861e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f56862f;

    @Metadata
    public static final class Companion {
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.f56857a == webSocketExtensions.f56857a && Intrinsics.b(this.f56858b, webSocketExtensions.f56858b) && this.f56859c == webSocketExtensions.f56859c && Intrinsics.b(this.f56860d, webSocketExtensions.f56860d) && this.f56861e == webSocketExtensions.f56861e && this.f56862f == webSocketExtensions.f56862f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        boolean z = this.f56857a;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = i2 * 31;
        Integer num = this.f56858b;
        int iHashCode = (i3 + (num == null ? 0 : num.hashCode())) * 31;
        boolean z2 = this.f56859c;
        int i4 = z2;
        if (z2 != 0) {
            i4 = 1;
        }
        int i5 = (iHashCode + i4) * 31;
        Integer num2 = this.f56860d;
        int iHashCode2 = (i5 + (num2 != null ? num2.hashCode() : 0)) * 31;
        boolean z3 = this.f56861e;
        int i6 = z3;
        if (z3 != 0) {
            i6 = 1;
        }
        int i7 = (iHashCode2 + i6) * 31;
        boolean z4 = this.f56862f;
        return i7 + (z4 ? 1 : z4 ? 1 : 0);
    }

    public final String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.f56857a + ", clientMaxWindowBits=" + this.f56858b + ", clientNoContextTakeover=" + this.f56859c + ", serverMaxWindowBits=" + this.f56860d + ", serverNoContextTakeover=" + this.f56861e + ", unknownValues=" + this.f56862f + ')';
    }

    public WebSocketExtensions(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4) {
        this.f56857a = z;
        this.f56858b = num;
        this.f56859c = z2;
        this.f56860d = num2;
        this.f56861e = z3;
        this.f56862f = z4;
    }
}
