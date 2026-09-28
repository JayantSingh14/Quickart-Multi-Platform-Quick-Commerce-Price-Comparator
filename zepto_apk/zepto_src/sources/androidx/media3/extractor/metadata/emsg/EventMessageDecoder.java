package androidx.media3.extractor.metadata.emsg;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.extractor.metadata.SimpleMetadataDecoder;
import java.nio.ByteBuffer;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class EventMessageDecoder extends SimpleMetadataDecoder {
    public static EventMessage c(ParsableByteArray parsableByteArray) {
        String strS = parsableByteArray.s();
        strS.getClass();
        String strS2 = parsableByteArray.s();
        strS2.getClass();
        return new EventMessage(strS, strS2, parsableByteArray.r(), parsableByteArray.r(), Arrays.copyOfRange(parsableByteArray.f5723a, parsableByteArray.f5724b, parsableByteArray.f5725c));
    }

    @Override // androidx.media3.extractor.metadata.SimpleMetadataDecoder
    public final Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        return new Metadata(c(new ParsableByteArray(byteBuffer.array(), byteBuffer.limit())));
    }
}
