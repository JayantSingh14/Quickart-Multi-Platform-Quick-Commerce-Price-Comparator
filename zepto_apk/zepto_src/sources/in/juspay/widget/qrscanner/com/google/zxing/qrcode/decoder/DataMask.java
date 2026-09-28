package in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder;

import in.juspay.widget.qrscanner.com.google.zxing.common.BitMatrix;

/* loaded from: classes4.dex */
enum DataMask {
    DATA_MASK_000 { // from class: in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.DataMask.1
        @Override // in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.DataMask
        public boolean a(int i2, int i3) {
            return ((i2 + i3) & 1) == 0;
        }
    },
    DATA_MASK_001 { // from class: in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.DataMask.2
        @Override // in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.DataMask
        public boolean a(int i2, int i3) {
            return (i2 & 1) == 0;
        }
    },
    DATA_MASK_010 { // from class: in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.DataMask.3
        @Override // in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.DataMask
        public boolean a(int i2, int i3) {
            return i3 % 3 == 0;
        }
    },
    DATA_MASK_011 { // from class: in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.DataMask.4
        @Override // in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.DataMask
        public boolean a(int i2, int i3) {
            return (i2 + i3) % 3 == 0;
        }
    },
    DATA_MASK_100 { // from class: in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.DataMask.5
        @Override // in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.DataMask
        public boolean a(int i2, int i3) {
            return (((i3 / 3) + (i2 / 2)) & 1) == 0;
        }
    },
    DATA_MASK_101 { // from class: in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.DataMask.6
        @Override // in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.DataMask
        public boolean a(int i2, int i3) {
            return (i2 * i3) % 6 == 0;
        }
    },
    DATA_MASK_110 { // from class: in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.DataMask.7
        @Override // in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.DataMask
        public boolean a(int i2, int i3) {
            return (i2 * i3) % 6 < 3;
        }
    },
    DATA_MASK_111 { // from class: in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.DataMask.8
        @Override // in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.DataMask
        public boolean a(int i2, int i3) {
            return ((((i2 * i3) % 3) + (i2 + i3)) & 1) == 0;
        }
    };

    public final void a(BitMatrix bitMatrix, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (a(i3, i4)) {
                    bitMatrix.flip(i4, i3);
                }
            }
        }
    }

    public abstract boolean a(int i2, int i3);
}
