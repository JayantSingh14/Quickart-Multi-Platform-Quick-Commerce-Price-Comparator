package androidx.media3.datasource;

import android.net.Uri;
import android.util.Base64;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Charsets;
import java.net.URLDecoder;

@UnstableApi
/* loaded from: classes3.dex */
public final class DataSchemeDataSource extends BaseDataSource {

    /* renamed from: e, reason: collision with root package name */
    public DataSpec f5837e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f5838f;

    /* renamed from: g, reason: collision with root package name */
    public int f5839g;

    /* renamed from: h, reason: collision with root package name */
    public int f5840h;

    public DataSchemeDataSource() {
        super(false);
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
        if (this.f5838f != null) {
            this.f5838f = null;
            m();
        }
        this.f5837e = null;
    }

    @Override // androidx.media3.datasource.DataSource
    public final long j(DataSpec dataSpec) throws ParserException, DataSourceException {
        n(dataSpec);
        this.f5837e = dataSpec;
        Uri uriNormalizeScheme = dataSpec.f5851a.normalizeScheme();
        String scheme = uriNormalizeScheme.getScheme();
        Assertions.b("data".equals(scheme), "Unsupported scheme: " + scheme);
        String schemeSpecificPart = uriNormalizeScheme.getSchemeSpecificPart();
        int i2 = Util.f5744a;
        String[] strArrSplit = schemeSpecificPart.split(",", -1);
        if (strArrSplit.length != 2) {
            throw new ParserException(android.support.v4.media.a.l(uriNormalizeScheme, "Unexpected URI format: "), null, true, 0);
        }
        String str = strArrSplit[1];
        if (strArrSplit[0].contains(";base64")) {
            try {
                this.f5838f = Base64.decode(str, 0);
            } catch (IllegalArgumentException e2) {
                throw new ParserException(android.support.v4.media.b.C("Error while parsing Base64 encoded string: ", str), e2, true, 0);
            }
        } else {
            this.f5838f = URLDecoder.decode(str, Charsets.f42258a.name()).getBytes(Charsets.f42260c);
        }
        byte[] bArr = this.f5838f;
        long length = bArr.length;
        long j2 = dataSpec.f5856f;
        if (j2 > length) {
            this.f5838f = null;
            throw new DataSourceException(2008);
        }
        int i3 = (int) j2;
        this.f5839g = i3;
        int length2 = bArr.length - i3;
        this.f5840h = length2;
        long j3 = dataSpec.f5857g;
        if (j3 != -1) {
            this.f5840h = (int) Math.min(length2, j3);
        }
        o(dataSpec);
        return j3 != -1 ? j3 : this.f5840h;
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri k() {
        DataSpec dataSpec = this.f5837e;
        if (dataSpec != null) {
            return dataSpec.f5851a;
        }
        return null;
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        int i4 = this.f5840h;
        if (i4 == 0) {
            return -1;
        }
        int iMin = Math.min(i3, i4);
        byte[] bArr2 = this.f5838f;
        int i5 = Util.f5744a;
        System.arraycopy(bArr2, this.f5839g, bArr, i2, iMin);
        this.f5839g += iMin;
        this.f5840h -= iMin;
        l(iMin);
        return iMin;
    }
}
