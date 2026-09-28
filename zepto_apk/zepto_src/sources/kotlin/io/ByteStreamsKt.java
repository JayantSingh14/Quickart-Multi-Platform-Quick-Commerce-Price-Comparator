package kotlin.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.xbill.DNS.KEYRecord;

@Metadata
@JvmName
/* loaded from: classes3.dex */
public final class ByteStreamsKt {
    public static long a(InputStream inputStream, OutputStream out) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        byte[] bArr = new byte[KEYRecord.Flags.FLAG2];
        int i2 = inputStream.read(bArr);
        long j2 = 0;
        while (i2 >= 0) {
            out.write(bArr, 0, i2);
            j2 += i2;
            i2 = inputStream.read(bArr);
        }
        return j2;
    }
}
