package androidx.media3.datasource.cache;

import androidx.media3.common.util.UnstableApi;
import com.google.common.base.Charsets;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UnstableApi
/* loaded from: classes3.dex */
public final class DefaultContentMetadata implements ContentMetadata {

    /* renamed from: c, reason: collision with root package name */
    public static final DefaultContentMetadata f6018c = new DefaultContentMetadata(Collections.EMPTY_MAP);

    /* renamed from: a, reason: collision with root package name */
    public int f6019a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f6020b;

    public DefaultContentMetadata() {
        this(Collections.EMPTY_MAP);
    }

    public static boolean c(Map map, Map map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!Arrays.equals((byte[]) entry.getValue(), (byte[]) map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public final DefaultContentMetadata a(ContentMetadataMutations contentMetadataMutations) {
        byte[] bytes;
        Map map = this.f6020b;
        HashMap map2 = new HashMap(map);
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(contentMetadataMutations.f6017b));
        for (int i2 = 0; i2 < listUnmodifiableList.size(); i2++) {
            map2.remove(listUnmodifiableList.get(i2));
        }
        HashMap map3 = new HashMap(contentMetadataMutations.f6016a);
        for (Map.Entry entry : map3.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        for (Map.Entry entry2 : Collections.unmodifiableMap(map3).entrySet()) {
            String str = (String) entry2.getKey();
            Object value2 = entry2.getValue();
            if (value2 instanceof Long) {
                bytes = ByteBuffer.allocate(8).putLong(((Long) value2).longValue()).array();
            } else if (value2 instanceof String) {
                bytes = ((String) value2).getBytes(Charsets.f42260c);
            } else {
                if (!(value2 instanceof byte[])) {
                    throw new IllegalArgumentException();
                }
                bytes = (byte[]) value2;
            }
            map2.put(str, bytes);
        }
        return c(map, map2) ? this : new DefaultContentMetadata(map2);
    }

    public final long b() {
        byte[] bArr = (byte[]) this.f6020b.get("exo_len");
        if (bArr != null) {
            return ByteBuffer.wrap(bArr).getLong();
        }
        return -1L;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DefaultContentMetadata.class != obj.getClass()) {
            return false;
        }
        return c(this.f6020b, ((DefaultContentMetadata) obj).f6020b);
    }

    public final int hashCode() {
        if (this.f6019a == 0) {
            int iHashCode = 0;
            for (Map.Entry entry : this.f6020b.entrySet()) {
                iHashCode += Arrays.hashCode((byte[]) entry.getValue()) ^ ((String) entry.getKey()).hashCode();
            }
            this.f6019a = iHashCode;
        }
        return this.f6019a;
    }

    public DefaultContentMetadata(Map map) {
        this.f6020b = Collections.unmodifiableMap(map);
    }
}
