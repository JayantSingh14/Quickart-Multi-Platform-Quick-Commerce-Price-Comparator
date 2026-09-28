package androidx.media3.extractor.flv;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.DiscardingTrackOutput;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/* loaded from: classes3.dex */
final class ScriptTagPayloadReader extends TagPayloadReader {

    /* renamed from: b, reason: collision with root package name */
    public long f8729b;

    /* renamed from: c, reason: collision with root package name */
    public long[] f8730c;

    /* renamed from: d, reason: collision with root package name */
    public long[] f8731d;

    public ScriptTagPayloadReader() {
        super(new DiscardingTrackOutput());
        this.f8729b = -9223372036854775807L;
        this.f8730c = new long[0];
        this.f8731d = new long[0];
    }

    public static Serializable a(int i2, ParsableByteArray parsableByteArray) {
        if (i2 == 0) {
            return Double.valueOf(Double.longBitsToDouble(parsableByteArray.r()));
        }
        if (i2 == 1) {
            return Boolean.valueOf(parsableByteArray.x() == 1);
        }
        if (i2 == 2) {
            return c(parsableByteArray);
        }
        if (i2 != 3) {
            if (i2 == 8) {
                return b(parsableByteArray);
            }
            if (i2 != 10) {
                if (i2 != 11) {
                    return null;
                }
                Date date = new Date((long) Double.longBitsToDouble(parsableByteArray.r()));
                parsableByteArray.K(2);
                return date;
            }
            int iB = parsableByteArray.B();
            ArrayList arrayList = new ArrayList(iB);
            for (int i3 = 0; i3 < iB; i3++) {
                Serializable serializableA = a(parsableByteArray.x(), parsableByteArray);
                if (serializableA != null) {
                    arrayList.add(serializableA);
                }
            }
            return arrayList;
        }
        HashMap map = new HashMap();
        while (true) {
            String strC = c(parsableByteArray);
            int iX = parsableByteArray.x();
            if (iX == 9) {
                return map;
            }
            Serializable serializableA2 = a(iX, parsableByteArray);
            if (serializableA2 != null) {
                map.put(strC, serializableA2);
            }
        }
    }

    public static HashMap b(ParsableByteArray parsableByteArray) {
        int iB = parsableByteArray.B();
        HashMap map = new HashMap(iB);
        for (int i2 = 0; i2 < iB; i2++) {
            String strC = c(parsableByteArray);
            Serializable serializableA = a(parsableByteArray.x(), parsableByteArray);
            if (serializableA != null) {
                map.put(strC, serializableA);
            }
        }
        return map;
    }

    public static String c(ParsableByteArray parsableByteArray) {
        int iD = parsableByteArray.D();
        int i2 = parsableByteArray.f5724b;
        parsableByteArray.K(iD);
        return new String(parsableByteArray.f5723a, i2, iD);
    }
}
