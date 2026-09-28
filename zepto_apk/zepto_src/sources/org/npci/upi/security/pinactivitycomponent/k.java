package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public class k {
    private static ByteArrayOutputStream a(ByteArrayOutputStream byteArrayOutputStream, InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArrayOutputStream;
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    public static byte[] a(String str, Context context) {
        try {
            return a(new ByteArrayOutputStream(), context.getAssets().open(CLConstants.ASSET_FILE_PATH + str)).toByteArray();
        } catch (FileNotFoundException e2) {
            throw new RuntimeException(e2);
        } catch (IOException e3) {
            throw new RuntimeException(e3);
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }
}
