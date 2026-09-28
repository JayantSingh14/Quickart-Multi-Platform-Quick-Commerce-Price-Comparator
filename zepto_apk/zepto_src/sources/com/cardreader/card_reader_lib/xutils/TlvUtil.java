package com.cardreader.card_reader_lib.xutils;

import android.support.v4.media.b;
import com.cardreader.card_reader_lib.enumModel.TagValueTypeEnum;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.apache.commons.lang3.StringUtils;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes3.dex */
public final class TlvUtil {
    public static boolean a(Object[] objArr, ITag iTag) {
        int i2;
        if (iTag == null) {
            i2 = 0;
            while (i2 < objArr.length) {
                if (objArr[i2] == null) {
                    break;
                }
                i2++;
            }
            i2 = -1;
        } else if (objArr.getClass().getComponentType().isInstance(iTag)) {
            for (int i3 = 0; i3 < objArr.length; i3++) {
                if (iTag.equals(objArr[i3])) {
                    i2 = i3;
                    break;
                }
            }
            i2 = -1;
        } else {
            i2 = -1;
        }
        return i2 != -1;
    }

    public static TLV b(ByteArrayInputStream byteArrayInputStream) {
        byte[] bArr;
        if (byteArrayInputStream.available() < 2) {
            throw new TlvException("Error parsing data. Available bytes < 2 . Length=" + byteArrayInputStream.available());
        }
        byteArrayInputStream.mark(0);
        int i2 = byteArrayInputStream.read();
        while (true) {
            byte b2 = (byte) i2;
            if (i2 == -1 || !(b2 == -1 || b2 == 0)) {
                break;
            }
            byteArrayInputStream.mark(0);
            i2 = byteArrayInputStream.read();
        }
        byteArrayInputStream.reset();
        if (byteArrayInputStream.available() < 2) {
            throw new TlvException("Error parsing data. Available bytes < 2 . Length=" + byteArrayInputStream.available());
        }
        byte[] bArrE = e(byteArrayInputStream);
        byteArrayInputStream.mark(0);
        int iAvailable = byteArrayInputStream.available();
        int iF = f(byteArrayInputStream);
        int iAvailable2 = byteArrayInputStream.available();
        byteArrayInputStream.reset();
        int i3 = iAvailable - iAvailable2;
        byte[] bArr2 = new byte[i3];
        int i4 = 1;
        if (i3 < 1 || i3 > 4) {
            throw new TlvException(b.f(i3, "Number of length bytes must be from 1 to 4. Found "));
        }
        byteArrayInputStream.read(bArr2, 0, i3);
        if (i3 <= 0 || i3 > 4) {
            throw new IllegalArgumentException(b.f(i3, "Length must be between 1 and 4. Length = "));
        }
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            i5 += (bArr2[i6] & 255) << (((i3 - i6) - 1) * 8);
        }
        LinkedHashMap linkedHashMap = EmvTags.f16569a;
        bArrE.getClass();
        ITag tagImpl = (ITag) linkedHashMap.get(new ByteArrayWrapper(bArrE));
        if (tagImpl == null) {
            tagImpl = new TagImpl(bArrE, TagValueTypeEnum.f16550a, "[UNKNOWN TAG]");
        }
        if (i5 == 128) {
            byteArrayInputStream.mark(0);
            int i7 = 0;
            while (true) {
                int i8 = i7 + 1;
                int i9 = byteArrayInputStream.read();
                if (i9 < 0) {
                    throw new TlvException("Error parsing data. TLV length byte indicated indefinite length, but EOS was reached before 0x0000 was found" + byteArrayInputStream.available());
                }
                if (i4 == 0 && i9 == 0) {
                    iF = i7 - 1;
                    bArr = new byte[iF];
                    byteArrayInputStream.reset();
                    byteArrayInputStream.read(bArr, 0, iF);
                    break;
                }
                i7 = i8;
                i4 = i9;
            }
        } else {
            if (byteArrayInputStream.available() < iF) {
                StringBuilder sbU = b.u(iF, "Length byte(s) indicated ", " value bytes, but only ");
                sbU.append(byteArrayInputStream.available());
                sbU.append(StringUtils.SPACE);
                throw new TlvException(b.r(sbU, byteArrayInputStream.available() > 1 ? "are" : "is", " available"));
            }
            bArr = new byte[iF];
            byteArrayInputStream.read(bArr, 0, iF);
        }
        byteArrayInputStream.mark(0);
        int i10 = byteArrayInputStream.read();
        while (true) {
            byte b3 = (byte) i10;
            if (i10 == -1 || !(b3 == -1 || b3 == 0)) {
                break;
            }
            byteArrayInputStream.mark(0);
            i10 = byteArrayInputStream.read();
        }
        byteArrayInputStream.reset();
        TLV tlv = new TLV();
        if (iF != bArr.length) {
            throw new IllegalArgumentException("length != bytes.length");
        }
        tlv.f16585a = tagImpl;
        tlv.f16586b = bArr;
        return tlv;
    }

    public static byte[] c(byte[] bArr, ITag... iTagArr) {
        byte[] bArr2 = null;
        if (bArr != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            while (byteArrayInputStream.available() > 0) {
                TLV tlvB = b(byteArrayInputStream);
                ITag iTag = tlvB.f16585a;
                boolean zA = a(iTagArr, iTag);
                byte[] bArr3 = tlvB.f16586b;
                if (zA) {
                    return bArr3;
                }
                if (iTag.b()) {
                    byte[] bArrC = c(bArr3, iTagArr);
                    if (bArrC != null) {
                        return bArrC;
                    }
                    bArr2 = bArrC;
                }
            }
        }
        return bArr2;
    }

    public static ArrayList d(byte[] bArr, ITag... iTagArr) {
        ArrayList arrayList = new ArrayList();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        while (byteArrayInputStream.available() > 0) {
            TLV tlvB = b(byteArrayInputStream);
            ITag iTag = tlvB.f16585a;
            if (a(iTagArr, iTag)) {
                arrayList.add(tlvB);
            } else if (iTag.b()) {
                arrayList.addAll(d(tlvB.f16586b, iTagArr));
            }
        }
        return arrayList;
    }

    public static byte[] e(ByteArrayInputStream byteArrayInputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte b2 = (byte) byteArrayInputStream.read();
        byteArrayOutputStream.write(b2);
        if ((b2 & 31) == 31) {
            while (true) {
                int i2 = byteArrayInputStream.read();
                if (i2 < 0) {
                    break;
                }
                byte b3 = (byte) i2;
                byteArrayOutputStream.write(b3);
                if (!BytesUtils.c(b3, 7) || (BytesUtils.c(b3, 7) && (b3 & 127) == 0)) {
                    break;
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static int f(ByteArrayInputStream byteArrayInputStream) {
        int i2 = byteArrayInputStream.read();
        if (i2 < 0) {
            throw new TlvException(b.f(i2, "Negative length: "));
        }
        if (i2 <= 127 || i2 == 128) {
            return i2;
        }
        int i3 = i2 & WKSRecord.Service.LOCUS_CON;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = byteArrayInputStream.read();
            if (i6 < 0) {
                throw new TlvException("EOS when reading length bytes");
            }
            i4 = (i4 << 8) | i6;
        }
        return i4;
    }
}
