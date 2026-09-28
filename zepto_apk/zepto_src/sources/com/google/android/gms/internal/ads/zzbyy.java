package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.IOUtils;
import java.io.DataOutputStream;
import java.io.IOException;

@SafeParcelable.Class(creator = "LargeParcelTeleporterCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class zzbyy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbyy> CREATOR = new zzbyz();

    /* renamed from: a, reason: collision with root package name */
    public ParcelFileDescriptor f25717a;

    /* renamed from: b, reason: collision with root package name */
    public Parcelable f25718b = null;

    /* renamed from: c, reason: collision with root package name */
    public boolean f25719c = true;

    public zzbyy(ParcelFileDescriptor parcelFileDescriptor) {
        this.f25717a = parcelFileDescriptor;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) throws IOException {
        final ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe;
        if (this.f25717a == null) {
            Parcel parcelObtain = Parcel.obtain();
            try {
                this.f25718b.writeToParcel(parcelObtain, 0);
                final byte[] bArrMarshall = parcelObtain.marshall();
                parcelObtain.recycle();
                ParcelFileDescriptor parcelFileDescriptor = null;
                try {
                    parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
                    autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptorArrCreatePipe[1]);
                } catch (IOException e2) {
                    e = e2;
                    autoCloseOutputStream = null;
                }
                try {
                    ((zzcdn) zzcdo.f25982a).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbyx
                        @Override // java.lang.Runnable
                        public final void run() throws Throwable {
                            DataOutputStream dataOutputStream;
                            Parcelable.Creator<zzbyy> creator = zzbyy.CREATOR;
                            byte[] bArr = bArrMarshall;
                            ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream2 = autoCloseOutputStream;
                            DataOutputStream dataOutputStream2 = null;
                            try {
                                try {
                                    dataOutputStream = new DataOutputStream(autoCloseOutputStream2);
                                } catch (IOException e3) {
                                    e = e3;
                                }
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                dataOutputStream.writeInt(bArr.length);
                                dataOutputStream.write(bArr);
                                IOUtils.closeQuietly(dataOutputStream);
                            } catch (IOException e4) {
                                e = e4;
                                dataOutputStream2 = dataOutputStream;
                                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                                com.google.android.gms.ads.internal.util.client.zzo.d("Error transporting the ad response", e);
                                com.google.android.gms.ads.internal.zzt.C.f21684h.d("LargeParcelTeleporter.pipeData.1", e);
                                if (dataOutputStream2 == null) {
                                    IOUtils.closeQuietly(autoCloseOutputStream2);
                                } else {
                                    IOUtils.closeQuietly(dataOutputStream2);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                dataOutputStream2 = dataOutputStream;
                                if (dataOutputStream2 == null) {
                                    IOUtils.closeQuietly(autoCloseOutputStream2);
                                } else {
                                    IOUtils.closeQuietly(dataOutputStream2);
                                }
                                throw th;
                            }
                        }
                    });
                    parcelFileDescriptor = parcelFileDescriptorArrCreatePipe[0];
                } catch (IOException e3) {
                    e = e3;
                    int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.d("Error transporting the ad response", e);
                    com.google.android.gms.ads.internal.zzt.C.f21684h.d("LargeParcelTeleporter.pipeData.2", e);
                    IOUtils.closeQuietly(autoCloseOutputStream);
                    this.f25717a = parcelFileDescriptor;
                    int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
                    SafeParcelWriter.writeParcelable(parcel, 2, this.f25717a, i2, false);
                    SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
                }
                this.f25717a = parcelFileDescriptor;
            } catch (Throwable th) {
                parcelObtain.recycle();
                throw th;
            }
        }
        int iBeginObjectHeader2 = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f25717a, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader2);
    }
}
