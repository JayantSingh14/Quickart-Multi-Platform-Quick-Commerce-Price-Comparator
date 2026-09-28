package androidx.media3.extractor;

import android.util.Base64;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.metadata.flac.PictureFrame;
import androidx.media3.extractor.metadata.vorbis.VorbisComment;
import com.google.common.base.Charsets;
import java.util.ArrayList;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class VorbisUtil {

    public static final class CommentHeader {

        /* renamed from: a, reason: collision with root package name */
        public final String[] f8629a;

        public CommentHeader(String[] strArr) {
            this.f8629a = strArr;
        }
    }

    public static final class Mode {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f8630a;

        public Mode(boolean z) {
            this.f8630a = z;
        }
    }

    public static final class VorbisIdHeader {

        /* renamed from: a, reason: collision with root package name */
        public final int f8631a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8632b;

        /* renamed from: c, reason: collision with root package name */
        public final int f8633c;

        /* renamed from: d, reason: collision with root package name */
        public final int f8634d;

        /* renamed from: e, reason: collision with root package name */
        public final int f8635e;

        /* renamed from: f, reason: collision with root package name */
        public final int f8636f;

        /* renamed from: g, reason: collision with root package name */
        public final byte[] f8637g;

        public VorbisIdHeader(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f8631a = i2;
            this.f8632b = i3;
            this.f8633c = i4;
            this.f8634d = i5;
            this.f8635e = i6;
            this.f8636f = i7;
            this.f8637g = bArr;
        }
    }

    public static int a(int i2) {
        int i3 = 0;
        while (i2 > 0) {
            i3++;
            i2 >>>= 1;
        }
        return i3;
    }

    public static Metadata b(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = (String) list.get(i2);
            int i3 = Util.f5744a;
            String[] strArrSplit = str.split("=", 2);
            if (strArrSplit.length != 2) {
                Log.h("VorbisUtil", "Failed to parse Vorbis comment: ".concat(str));
            } else if (strArrSplit[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(PictureFrame.a(new ParsableByteArray(Base64.decode(strArrSplit[1], 0))));
                } catch (RuntimeException e2) {
                    Log.i("VorbisUtil", "Failed to parse vorbis picture", e2);
                }
            } else {
                arrayList.add(new VorbisComment(strArrSplit[0], strArrSplit[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static CommentHeader c(ParsableByteArray parsableByteArray, boolean z, boolean z2) throws ParserException {
        if (z) {
            d(3, parsableByteArray, false);
        }
        parsableByteArray.v((int) parsableByteArray.o(), Charsets.f42260c);
        long jO = parsableByteArray.o();
        String[] strArr = new String[(int) jO];
        for (int i2 = 0; i2 < jO; i2++) {
            strArr[i2] = parsableByteArray.v((int) parsableByteArray.o(), Charsets.f42260c);
        }
        if (z2 && (parsableByteArray.x() & 1) == 0) {
            throw ParserException.a(null, "framing bit expected to be set");
        }
        return new CommentHeader(strArr);
    }

    public static boolean d(int i2, ParsableByteArray parsableByteArray, boolean z) throws ParserException {
        if (parsableByteArray.a() < 7) {
            if (z) {
                return false;
            }
            throw ParserException.a(null, "too short header: " + parsableByteArray.a());
        }
        if (parsableByteArray.x() != i2) {
            if (z) {
                return false;
            }
            throw ParserException.a(null, "expected header type " + Integer.toHexString(i2));
        }
        if (parsableByteArray.x() == 118 && parsableByteArray.x() == 111 && parsableByteArray.x() == 114 && parsableByteArray.x() == 98 && parsableByteArray.x() == 105 && parsableByteArray.x() == 115) {
            return true;
        }
        if (z) {
            return false;
        }
        throw ParserException.a(null, "expected characters 'vorbis'");
    }
}
