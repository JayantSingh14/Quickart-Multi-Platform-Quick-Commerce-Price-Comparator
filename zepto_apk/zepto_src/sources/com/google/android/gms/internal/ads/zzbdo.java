package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import androidx.annotation.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@VisibleForTesting
/* loaded from: classes4.dex */
final class zzbdo {

    /* renamed from: a, reason: collision with root package name */
    public ByteArrayOutputStream f24804a = new ByteArrayOutputStream(4096);

    /* renamed from: b, reason: collision with root package name */
    public Base64OutputStream f24805b = new Base64OutputStream(this.f24804a, 10);

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() throws IOException {
        String string;
        try {
            this.f24805b.close();
        } catch (IOException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("HashManager: Unable to convert to Base64.", e2);
        }
        try {
            try {
                this.f24804a.close();
                string = this.f24804a.toString();
            } catch (IOException e3) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.d("HashManager: Unable to convert to Base64.", e3);
                string = "";
            }
            return string;
        } finally {
            this.f24804a = null;
            this.f24805b = null;
        }
    }
}
