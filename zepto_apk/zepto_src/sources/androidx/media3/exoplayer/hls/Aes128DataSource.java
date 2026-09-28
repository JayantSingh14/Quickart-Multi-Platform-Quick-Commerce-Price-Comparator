package androidx.media3.exoplayer.hls;

import android.net.Uri;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceInputStream;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
class Aes128DataSource implements DataSource {

    /* renamed from: a, reason: collision with root package name */
    public final DataSource f6963a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f6964b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f6965c;

    /* renamed from: d, reason: collision with root package name */
    public CipherInputStream f6966d;

    public Aes128DataSource(DataSource dataSource, byte[] bArr, byte[] bArr2) {
        this.f6963a = dataSource;
        this.f6964b = bArr;
        this.f6965c = bArr2;
    }

    @Override // androidx.media3.datasource.DataSource
    public final void a(TransferListener transferListener) {
        transferListener.getClass();
        this.f6963a.a(transferListener);
    }

    @Override // androidx.media3.datasource.DataSource
    public final Map c() {
        return this.f6963a.c();
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
        if (this.f6966d != null) {
            this.f6966d = null;
            this.f6963a.close();
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final long j(DataSpec dataSpec) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                cipher.init(2, new SecretKeySpec(this.f6964b, CLConstants.AES_KEY_VAULT_KEY), new IvParameterSpec(this.f6965c));
                DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(this.f6963a, dataSpec);
                this.f6966d = new CipherInputStream(dataSourceInputStream, cipher);
                if (dataSourceInputStream.f5849d) {
                    return -1L;
                }
                dataSourceInputStream.f5846a.j(dataSourceInputStream.f5847b);
                dataSourceInputStream.f5849d = true;
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri k() {
        return this.f6963a.k();
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        this.f6966d.getClass();
        int i4 = this.f6966d.read(bArr, i2, i3);
        if (i4 < 0) {
            return -1;
        }
        return i4;
    }
}
