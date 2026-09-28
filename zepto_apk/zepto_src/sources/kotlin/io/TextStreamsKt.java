package kotlin.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.SequencesKt;
import org.xbill.DNS.KEYRecord;

@Metadata
@JvmName
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TextStreamsKt {
    public static final ConstrainedOnceSequence a(BufferedReader bufferedReader) {
        Intrinsics.checkNotNullParameter(bufferedReader, "<this>");
        return SequencesKt.d(new LinesSequence(bufferedReader));
    }

    public static final String b(Reader reader) throws IOException {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        StringWriter out = new StringWriter();
        Intrinsics.checkNotNullParameter(reader, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        char[] cArr = new char[KEYRecord.Flags.FLAG2];
        int i2 = reader.read(cArr);
        while (i2 >= 0) {
            out.write(cArr, 0, i2);
            i2 = reader.read(cArr);
        }
        String string = out.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
