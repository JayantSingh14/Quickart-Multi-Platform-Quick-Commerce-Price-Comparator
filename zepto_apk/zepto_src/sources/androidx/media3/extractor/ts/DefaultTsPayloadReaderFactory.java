package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class DefaultTsPayloadReaderFactory implements TsPayloadReader.Factory {

    /* renamed from: a, reason: collision with root package name */
    public final int f9538a;

    /* renamed from: b, reason: collision with root package name */
    public final List f9539b;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public DefaultTsPayloadReaderFactory() {
        this(0);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.media3.extractor.ts.TsPayloadReader a(int r5, androidx.media3.extractor.ts.TsPayloadReader.EsInfo r6) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.DefaultTsPayloadReaderFactory.a(int, androidx.media3.extractor.ts.TsPayloadReader$EsInfo):androidx.media3.extractor.ts.TsPayloadReader");
    }

    public final List b(TsPayloadReader.EsInfo esInfo) {
        String str;
        int i2;
        boolean zC = c(32);
        List list = this.f9539b;
        if (zC) {
            return list;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(esInfo.f9809d);
        while (parsableByteArray.a() > 0) {
            int iX = parsableByteArray.x();
            int iX2 = parsableByteArray.f5724b + parsableByteArray.x();
            if (iX == 134) {
                ArrayList arrayList = new ArrayList();
                int iX3 = parsableByteArray.x() & 31;
                for (int i3 = 0; i3 < iX3; i3++) {
                    String strV = parsableByteArray.v(3, Charsets.f42260c);
                    int iX4 = parsableByteArray.x();
                    boolean z = (iX4 & 128) != 0;
                    if (z) {
                        i2 = iX4 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i2 = 1;
                    }
                    byte bX = (byte) parsableByteArray.x();
                    parsableByteArray.K(1);
                    List listSingletonList = z ? Collections.singletonList((bX & 64) != 0 ? new byte[]{1} : new byte[]{0}) : null;
                    Format.Builder builder = new Format.Builder();
                    builder.f5237l = MimeTypes.p(str);
                    builder.f5229d = strV;
                    builder.E = i2;
                    builder.o = listSingletonList;
                    arrayList.add(new Format(builder));
                }
                list = arrayList;
            }
            parsableByteArray.J(iX2);
        }
        return list;
    }

    public final boolean c(int i2) {
        return (i2 & this.f9538a) != 0;
    }

    public DefaultTsPayloadReaderFactory(int i2) {
        this(0, ImmutableList.r());
    }

    public DefaultTsPayloadReaderFactory(int i2, List list) {
        this.f9538a = i2;
        this.f9539b = list;
    }
}
