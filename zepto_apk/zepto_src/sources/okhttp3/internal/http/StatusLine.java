package okhttp3.internal.http;

import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Protocol;

@Metadata
/* loaded from: classes.dex */
public final class StatusLine {

    /* renamed from: a, reason: collision with root package name */
    public final Protocol f56591a;

    /* renamed from: b, reason: collision with root package name */
    public final int f56592b;

    /* renamed from: c, reason: collision with root package name */
    public final String f56593c;

    @Metadata
    public static final class Companion {
        public static StatusLine a(String statusLine) throws ProtocolException, NumberFormatException {
            int i2;
            String strSubstring;
            Intrinsics.checkNotNullParameter(statusLine, "statusLine");
            boolean zO = StringsKt.O(statusLine, "HTTP/1.", false);
            Protocol protocol = Protocol.HTTP_1_0;
            if (zO) {
                i2 = 9;
                if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
                int iCharAt = statusLine.charAt(7) - '0';
                if (iCharAt != 0) {
                    if (iCharAt != 1) {
                        throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                    }
                    protocol = Protocol.HTTP_1_1;
                }
            } else {
                if (!StringsKt.O(statusLine, "ICY ", false)) {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
                i2 = 4;
            }
            int i3 = i2 + 3;
            if (statusLine.length() < i3) {
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
            try {
                String strSubstring2 = statusLine.substring(i2, i3);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                int i4 = Integer.parseInt(strSubstring2);
                if (statusLine.length() <= i3) {
                    strSubstring = "";
                } else {
                    if (statusLine.charAt(i3) != ' ') {
                        throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                    }
                    strSubstring = statusLine.substring(i2 + 4);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                }
                return new StatusLine(protocol, i4, strSubstring);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
        }
    }

    public StatusLine(Protocol protocol, int i2, String message) {
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(message, "message");
        this.f56591a = protocol;
        this.f56592b = i2;
        this.f56593c = message;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f56591a == Protocol.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.f56592b);
        sb.append(' ');
        sb.append(this.f56593c);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
