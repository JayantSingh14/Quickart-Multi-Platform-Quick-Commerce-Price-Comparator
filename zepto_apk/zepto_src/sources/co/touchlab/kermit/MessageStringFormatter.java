package co.touchlab.kermit;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;

@Metadata
/* loaded from: classes.dex */
public interface MessageStringFormatter {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static String a(MessageStringFormatter messageStringFormatter, Severity severity, String str, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            if (severity == null && str == null) {
                return message;
            }
            StringBuilder sb = new StringBuilder();
            if (severity != null) {
                sb.append(messageStringFormatter.c(severity));
                sb.append(StringUtils.SPACE);
            }
            if (str != null && str.length() > 0) {
                sb.append(messageStringFormatter.b(str));
                sb.append(StringUtils.SPACE);
            }
            sb.append(message);
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        public static String b(Severity severity) {
            Intrinsics.checkNotNullParameter(severity, "severity");
            StringBuilder sb = new StringBuilder();
            sb.append(severity);
            sb.append(':');
            return sb.toString();
        }

        public static String c(String tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            return "(" + tag + ')';
        }
    }

    String a(Severity severity, String str, String str2);

    String b(String str);

    String c(Severity severity);
}
