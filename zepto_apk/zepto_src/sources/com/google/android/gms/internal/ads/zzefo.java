package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.util.IOUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
final /* synthetic */ class zzefo implements zzgxu {
    @Override // com.google.android.gms.internal.ads.zzgxu
    public final ListenableFuture zza(Object obj) throws IOException {
        final InputStream inputStream = (InputStream) obj;
        ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
        ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorArrCreatePipe[0];
        final ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptorArrCreatePipe[1];
        ((zzcdn) zzcdo.f25982a).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfjk
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() throws IOException {
                ParcelFileDescriptor parcelFileDescriptor3 = parcelFileDescriptor2;
                InputStream inputStream2 = inputStream;
                try {
                    try {
                        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptor3);
                        try {
                            IOUtils.copyStream(inputStream2, autoCloseOutputStream);
                            autoCloseOutputStream.close();
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                        } finally {
                        }
                    } finally {
                    }
                } catch (IOException unused) {
                }
            }
        });
        return zzgym.a(parcelFileDescriptor);
    }
}
