package androidx.media3.session;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import androidx.media3.common.util.Assertions;
import coil3.util.UtilsKt;
import com.google.common.base.Supplier;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final /* synthetic */ class i2 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10390a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10391b;

    public /* synthetic */ i2(Object obj, int i2) {
        this.f10390a = i2;
        this.f10391b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws IOException {
        Object obj = this.f10391b;
        switch (this.f10390a) {
            case 0:
                Supplier supplier = SimpleBitmapLoader.f10289b;
                byte[] bArr = (byte[]) obj;
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                Assertions.b(bitmapDecodeByteArray != null, "Could not decode image data");
                return bitmapDecodeByteArray;
            default:
                Supplier supplier2 = SimpleBitmapLoader.f10289b;
                Uri uri = (Uri) obj;
                if (UtilsKt.SCHEME_FILE.equals(uri.getScheme())) {
                    String path = uri.getPath();
                    if (path == null) {
                        throw new IllegalArgumentException("Could not read image from file");
                    }
                    Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(path);
                    if (bitmapDecodeFile != null) {
                        return bitmapDecodeFile;
                    }
                    throw new IllegalArgumentException("Could not read image from file");
                }
                URLConnection uRLConnectionOpenConnection = new URL(uri.toString()).openConnection();
                if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                    throw new UnsupportedOperationException("Unsupported scheme: " + uri.getScheme());
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    throw new IOException(android.support.v4.media.b.f(responseCode, "Invalid response status code: "));
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    byte[] bArrC = ByteStreams.c(inputStream);
                    Bitmap bitmapDecodeByteArray2 = BitmapFactory.decodeByteArray(bArrC, 0, bArrC.length);
                    if (bitmapDecodeByteArray2 == null) {
                        z = false;
                    }
                    Assertions.b(z, "Could not decode image data");
                    inputStream.close();
                    return bitmapDecodeByteArray2;
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
        }
    }
}
