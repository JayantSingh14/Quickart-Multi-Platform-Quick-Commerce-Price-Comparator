package androidx.media3.extractor.mp4;

import android.support.v4.media.a;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import java.nio.ByteBuffer;
import java.util.UUID;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@UnstableApi
/* loaded from: classes3.dex */
public final class PsshAtomUtil {

    public static final class PsshAtom {

        /* renamed from: a, reason: collision with root package name */
        public final UUID f9054a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9055b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f9056c;

        public PsshAtom(UUID uuid, int i2, byte[] bArr) {
            this.f9054a = uuid;
            this.f9055b = i2;
            this.f9056c = bArr;
        }
    }

    public static byte[] a(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length);
        byteBufferAllocate.putInt(1886614376);
        byteBufferAllocate.putInt(uuidArr != null ? 16777216 : 0);
        byteBufferAllocate.putLong(uuid.getMostSignificantBits());
        byteBufferAllocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            byteBufferAllocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                byteBufferAllocate.putLong(uuid2.getMostSignificantBits());
                byteBufferAllocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr == null || bArr.length == 0) {
            byteBufferAllocate.putInt(0);
        } else {
            byteBufferAllocate.putInt(bArr.length);
            byteBufferAllocate.put(bArr);
        }
        return byteBufferAllocate.array();
    }

    public static PsshAtom b(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        if (parsableByteArray.f5725c < 32) {
            return null;
        }
        parsableByteArray.J(0);
        int iA = parsableByteArray.a();
        int iJ = parsableByteArray.j();
        if (iJ != iA) {
            Log.h("PsshAtomUtil", "Advertised atom size (" + iJ + ") does not match buffer size: " + iA);
            return null;
        }
        int iJ2 = parsableByteArray.j();
        if (iJ2 != 1886614376) {
            a.r(iJ2, "Atom type is not pssh: ", "PsshAtomUtil");
            return null;
        }
        int iB = Atom.b(parsableByteArray.j());
        if (iB > 1) {
            a.r(iB, "Unsupported pssh version: ", "PsshAtomUtil");
            return null;
        }
        UUID uuid = new UUID(parsableByteArray.r(), parsableByteArray.r());
        if (iB == 1) {
            int iB2 = parsableByteArray.B();
            UUID[] uuidArr = new UUID[iB2];
            for (int i2 = 0; i2 < iB2; i2++) {
                uuidArr[i2] = new UUID(parsableByteArray.r(), parsableByteArray.r());
            }
        }
        int iB3 = parsableByteArray.B();
        int iA2 = parsableByteArray.a();
        if (iB3 == iA2) {
            byte[] bArr2 = new byte[iB3];
            parsableByteArray.h(0, bArr2, iB3);
            return new PsshAtom(uuid, iB, bArr2);
        }
        Log.h("PsshAtomUtil", "Atom data size (" + iB3 + ") does not match the bytes left: " + iA2);
        return null;
    }

    public static byte[] c(UUID uuid, byte[] bArr) {
        PsshAtom psshAtomB = b(bArr);
        if (psshAtomB == null) {
            return null;
        }
        UUID uuid2 = psshAtomB.f9054a;
        if (uuid.equals(uuid2)) {
            return psshAtomB.f9056c;
        }
        Log.h("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + uuid2 + CLConstants.DOT_SALT_DELIMETER);
        return null;
    }
}
