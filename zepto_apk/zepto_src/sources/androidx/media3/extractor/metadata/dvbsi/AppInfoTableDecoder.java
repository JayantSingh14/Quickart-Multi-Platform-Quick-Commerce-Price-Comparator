package androidx.media3.extractor.metadata.dvbsi;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.extractor.metadata.SimpleMetadataDecoder;
import com.google.common.base.Charsets;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;

@UnstableApi
/* loaded from: classes3.dex */
public final class AppInfoTableDecoder extends SimpleMetadataDecoder {
    @Override // androidx.media3.extractor.metadata.SimpleMetadataDecoder
    public final Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            ParsableBitArray parsableBitArray = new ParsableBitArray(byteBuffer.array(), byteBuffer.limit());
            parsableBitArray.o(12);
            int iD = (parsableBitArray.d() + parsableBitArray.g(12)) - 4;
            parsableBitArray.o(44);
            parsableBitArray.p(parsableBitArray.g(12));
            parsableBitArray.o(16);
            ArrayList arrayList = new ArrayList();
            while (parsableBitArray.d() < iD) {
                parsableBitArray.o(48);
                int iG = parsableBitArray.g(8);
                parsableBitArray.o(4);
                int iD2 = parsableBitArray.d() + parsableBitArray.g(12);
                String str = null;
                String str2 = null;
                while (parsableBitArray.d() < iD2) {
                    int iG2 = parsableBitArray.g(8);
                    int iG3 = parsableBitArray.g(8);
                    int iD3 = parsableBitArray.d() + iG3;
                    if (iG2 == 2) {
                        int iG4 = parsableBitArray.g(16);
                        parsableBitArray.o(8);
                        if (iG4 == 3) {
                            while (parsableBitArray.d() < iD3) {
                                int iG5 = parsableBitArray.g(8);
                                Charset charset = Charsets.f42258a;
                                byte[] bArr = new byte[iG5];
                                parsableBitArray.j(iG5, bArr);
                                str = new String(bArr, charset);
                                int iG6 = parsableBitArray.g(8);
                                for (int i2 = 0; i2 < iG6; i2++) {
                                    parsableBitArray.p(parsableBitArray.g(8));
                                }
                            }
                        }
                    } else if (iG2 == 21) {
                        Charset charset2 = Charsets.f42258a;
                        byte[] bArr2 = new byte[iG3];
                        parsableBitArray.j(iG3, bArr2);
                        str2 = new String(bArr2, charset2);
                    }
                    parsableBitArray.m(iD3 * 8);
                }
                parsableBitArray.m(iD2 * 8);
                if (str != null && str2 != null) {
                    arrayList.add(new AppInfoTable(iG, str.concat(str2)));
                }
            }
            if (!arrayList.isEmpty()) {
                return new Metadata(arrayList);
            }
        }
        return null;
    }
}
