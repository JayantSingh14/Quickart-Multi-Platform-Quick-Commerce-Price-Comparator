package androidx.media3.extractor.mp4;

import android.support.v4.media.a;
import android.support.v4.media.b;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.metadata.id3.ApicFrame;
import androidx.media3.extractor.metadata.id3.CommentFrame;
import androidx.media3.extractor.metadata.id3.Id3Frame;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import com.google.common.collect.ImmutableList;
import com.reactnativecommunity.clipboard.ClipboardModule;

/* loaded from: classes3.dex */
final class MetadataUtil {
    public static CommentFrame a(int i2, ParsableByteArray parsableByteArray) {
        int iJ = parsableByteArray.j();
        if (parsableByteArray.j() == 1684108385) {
            parsableByteArray.K(8);
            String strT = parsableByteArray.t(iJ - 16);
            return new CommentFrame("und", strT, strT);
        }
        Log.h("MetadataUtil", "Failed to parse comment attribute: " + Atom.a(i2));
        return null;
    }

    public static ApicFrame b(ParsableByteArray parsableByteArray) {
        int iJ = parsableByteArray.j();
        if (parsableByteArray.j() != 1684108385) {
            Log.h("MetadataUtil", "Failed to parse cover art attribute");
            return null;
        }
        int iJ2 = parsableByteArray.j() & 16777215;
        String str = iJ2 == 13 ? "image/jpeg" : iJ2 == 14 ? ClipboardModule.MIMETYPE_PNG : null;
        if (str == null) {
            a.r(iJ2, "Unrecognized cover art flags: ", "MetadataUtil");
            return null;
        }
        parsableByteArray.K(4);
        int i2 = iJ - 16;
        byte[] bArr = new byte[i2];
        parsableByteArray.h(0, bArr, i2);
        return new ApicFrame(3, str, null, bArr);
    }

    public static TextInformationFrame c(int i2, ParsableByteArray parsableByteArray, String str) {
        int iJ = parsableByteArray.j();
        if (parsableByteArray.j() == 1684108385 && iJ >= 22) {
            parsableByteArray.K(10);
            int iD = parsableByteArray.D();
            if (iD > 0) {
                String strF = b.f(iD, "");
                int iD2 = parsableByteArray.D();
                if (iD2 > 0) {
                    strF = strF + "/" + iD2;
                }
                return new TextInformationFrame(str, null, ImmutableList.t(strF));
            }
        }
        Log.h("MetadataUtil", "Failed to parse index/count attribute: " + Atom.a(i2));
        return null;
    }

    public static int d(ParsableByteArray parsableByteArray) {
        int iJ = parsableByteArray.j();
        if (parsableByteArray.j() == 1684108385) {
            parsableByteArray.K(8);
            int i2 = iJ - 16;
            if (i2 == 1) {
                return parsableByteArray.x();
            }
            if (i2 == 2) {
                return parsableByteArray.D();
            }
            if (i2 == 3) {
                return parsableByteArray.A();
            }
            if (i2 == 4 && (parsableByteArray.f5723a[parsableByteArray.f5724b] & 128) == 0) {
                return parsableByteArray.B();
            }
        }
        Log.h("MetadataUtil", "Failed to parse data atom to int");
        return -1;
    }

    public static Id3Frame e(int i2, String str, ParsableByteArray parsableByteArray, boolean z, boolean z2) {
        int iD = d(parsableByteArray);
        if (z2) {
            iD = Math.min(1, iD);
        }
        if (iD >= 0) {
            return z ? new TextInformationFrame(str, null, ImmutableList.t(Integer.toString(iD))) : new CommentFrame("und", str, Integer.toString(iD));
        }
        Log.h("MetadataUtil", "Failed to parse uint8 attribute: " + Atom.a(i2));
        return null;
    }

    public static TextInformationFrame f(int i2, ParsableByteArray parsableByteArray, String str) {
        int iJ = parsableByteArray.j();
        if (parsableByteArray.j() == 1684108385) {
            parsableByteArray.K(8);
            return new TextInformationFrame(str, null, ImmutableList.t(parsableByteArray.t(iJ - 16)));
        }
        Log.h("MetadataUtil", "Failed to parse text attribute: " + Atom.a(i2));
        return null;
    }
}
