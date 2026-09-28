package com.appsflyer.internal;

import com.google.android.gms.common.api.Api;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.xbill.DNS.dnssec.ValidatingResolver;

/* loaded from: classes.dex */
public final class AFk1vSDK extends FilterInputStream {
    private final int AFAdRevenueData;
    private int areAllFieldsValid;
    private byte[] component1;
    private int[] component2;
    private byte[] component3;
    private byte[] component4;
    private int copydefault;
    private final int getCurrencyIso4217Code;
    private final int getMediationNetwork;
    private AFk1sSDK getMonetizationNetwork;
    private int getRevenue;
    private int hashCode;
    private int toString;

    public AFk1vSDK(InputStream inputStream, int[] iArr, byte[] bArr, int i2, boolean z, int i3) throws IOException {
        this(inputStream, iArr, bArr, i2, false, i3, (byte) 0);
    }

    private int AFAdRevenueData() throws IOException {
        if (this.hashCode == Integer.MAX_VALUE) {
            this.hashCode = ((FilterInputStream) this).in.read();
        }
        if (this.areAllFieldsValid == 8) {
            byte[] bArr = this.component4;
            int i2 = this.hashCode;
            bArr[0] = (byte) i2;
            if (i2 < 0) {
                throw new IllegalStateException("unexpected block size");
            }
            int i3 = 1;
            do {
                int i4 = ((FilterInputStream) this).in.read(this.component4, i3, 8 - i3);
                if (i4 <= 0) {
                    break;
                }
                i3 += i4;
            } while (i3 < 8);
            if (i3 < 8) {
                throw new IllegalStateException("unexpected block size");
            }
            int i5 = this.getMediationNetwork;
            if (i5 == this.AFAdRevenueData) {
                getCurrencyIso4217Code();
            } else {
                if (this.getRevenue <= i5) {
                    getCurrencyIso4217Code();
                }
                int i6 = this.getRevenue;
                if (i6 < this.AFAdRevenueData) {
                    this.getRevenue = i6 + 1;
                } else {
                    this.getRevenue = 1;
                }
            }
            int i7 = ((FilterInputStream) this).in.read();
            this.hashCode = i7;
            this.areAllFieldsValid = 0;
            this.toString = i7 < 0 ? 8 - (this.component4[7] & 255) : 8;
        }
        return this.toString;
    }

    private void getCurrencyIso4217Code() {
        if (this.copydefault == 2) {
            byte[] bArr = this.component4;
            System.arraycopy(bArr, 0, this.component3, 0, bArr.length);
        }
        byte[] bArr2 = this.component4;
        int i2 = ((bArr2[0] << 24) & (-16777216)) + ((bArr2[1] << 16) & 16711680) + ((bArr2[2] << 8) & ValidatingResolver.VALIDATION_REASON_QCLASS) + (bArr2[3] & 255);
        int i3 = ((-16777216) & (bArr2[4] << 24)) + (16711680 & (bArr2[5] << 16)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255);
        int i4 = this.getCurrencyIso4217Code;
        AFk1sSDK aFk1sSDK = this.getMonetizationNetwork;
        AFk1tSDK.AFAdRevenueData(i2, i3, false, i4, aFk1sSDK.getCurrencyIso4217Code, aFk1sSDK.getRevenue, this.component2);
        int[] iArr = this.component2;
        int i5 = iArr[0];
        int i6 = iArr[1];
        byte[] bArr3 = this.component4;
        bArr3[0] = (byte) (i5 >> 24);
        bArr3[1] = (byte) (i5 >> 16);
        bArr3[2] = (byte) (i5 >> 8);
        bArr3[3] = (byte) i5;
        bArr3[4] = (byte) (i6 >> 24);
        bArr3[5] = (byte) (i6 >> 16);
        bArr3[6] = (byte) (i6 >> 8);
        bArr3[7] = (byte) i6;
        if (this.copydefault == 2) {
            for (int i7 = 0; i7 < 8; i7++) {
                byte[] bArr4 = this.component4;
                bArr4[i7] = (byte) (bArr4[i7] ^ this.component1[i7]);
            }
            byte[] bArr5 = this.component3;
            System.arraycopy(bArr5, 0, this.component1, 0, bArr5.length);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        AFAdRevenueData();
        return this.toString - this.areAllFieldsValid;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        AFAdRevenueData();
        int i2 = this.areAllFieldsValid;
        if (i2 >= this.toString) {
            return -1;
        }
        byte[] bArr = this.component4;
        this.areAllFieldsValid = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j2) throws IOException {
        long j3 = 0;
        while (j3 < j2 && read() != -1) {
            j3++;
        }
        return j3;
    }

    private AFk1vSDK(InputStream inputStream, int[] iArr, byte[] bArr, int i2, boolean z, int i3, byte b2) throws IOException {
        super(new BufferedInputStream(inputStream, 4096));
        this.getRevenue = 1;
        this.hashCode = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int iMin = Math.min(Math.max(i2, 3), 16);
        this.getCurrencyIso4217Code = iMin;
        this.component4 = new byte[8];
        byte[] bArr2 = new byte[8];
        this.component1 = bArr2;
        this.component3 = new byte[8];
        this.component2 = new int[2];
        this.areAllFieldsValid = 8;
        this.toString = 8;
        this.copydefault = i3;
        if (i3 == 2) {
            System.arraycopy(bArr, 0, bArr2, 0, 8);
        }
        this.getMonetizationNetwork = new AFk1sSDK(iArr, iMin, true, false);
        this.getMediationNetwork = 100;
        this.AFAdRevenueData = 100;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = i2 + i3;
        for (int i5 = i2; i5 < i4; i5++) {
            AFAdRevenueData();
            int i6 = this.areAllFieldsValid;
            if (i6 >= this.toString) {
                if (i5 == i2) {
                    return -1;
                }
                return i3 - (i4 - i5);
            }
            byte[] bArr2 = this.component4;
            this.areAllFieldsValid = i6 + 1;
            bArr[i5] = bArr2[i6];
        }
        return i3;
    }
}
