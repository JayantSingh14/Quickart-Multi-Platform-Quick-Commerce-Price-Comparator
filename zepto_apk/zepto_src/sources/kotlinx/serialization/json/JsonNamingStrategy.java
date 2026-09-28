package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata
@ExperimentalSerializationApi
/* loaded from: classes3.dex */
public interface JsonNamingStrategy {

    @Metadata
    @ExperimentalSerializationApi
    @SourceDebugExtension
    public static final class Builtins {
        public static final String a(String str, char c2) {
            StringBuilder sb = new StringBuilder(str.length() * 2);
            Character chValueOf = null;
            int i2 = 0;
            for (int i3 = 0; i3 < str.length(); i3++) {
                char cCharAt = str.charAt(i3);
                if (Character.isUpperCase(cCharAt)) {
                    if (i2 == 0 && sb.length() > 0 && StringsKt.A(sb) != c2) {
                        sb.append(c2);
                    }
                    if (chValueOf != null) {
                        sb.append(chValueOf.charValue());
                    }
                    i2++;
                    chValueOf = Character.valueOf(Character.toLowerCase(cCharAt));
                } else {
                    if (chValueOf != null) {
                        if (i2 > 1 && Character.isLetter(cCharAt)) {
                            sb.append(c2);
                        }
                        sb.append(chValueOf);
                        chValueOf = null;
                        i2 = 0;
                    }
                    sb.append(cCharAt);
                }
            }
            if (chValueOf != null) {
                sb.append(chValueOf);
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }

    String a(SerialDescriptor serialDescriptor, String str);
}
