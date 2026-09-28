package com.cardreader.card_reader_lib.xutils;

import com.cardreader.card_reader_lib.enumModel.CommandEnum;

/* loaded from: classes3.dex */
public class CommandApdu {

    /* renamed from: a, reason: collision with root package name */
    public final int f16561a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16562b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16563c;

    /* renamed from: d, reason: collision with root package name */
    public final int f16564d;

    /* renamed from: e, reason: collision with root package name */
    public final int f16565e;

    /* renamed from: f, reason: collision with root package name */
    public final byte[] f16566f;

    /* renamed from: g, reason: collision with root package name */
    public final int f16567g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f16568h;

    public CommandApdu(CommandEnum commandEnum, byte[] bArr) {
        this.f16565e = 0;
        this.f16566f = new byte[0];
        this.f16567g = 0;
        this.f16568h = false;
        this.f16561a = commandEnum.f16544a;
        this.f16562b = commandEnum.f16545b;
        this.f16563c = commandEnum.f16546c;
        this.f16564d = 0;
        this.f16565e = bArr == null ? 0 : bArr.length;
        this.f16566f = bArr;
        this.f16567g = 0;
        this.f16568h = true;
    }

    public final byte[] a() {
        byte[] bArr = this.f16566f;
        int length = 4;
        int length2 = (bArr == null || bArr.length == 0) ? 4 : bArr.length + 5;
        boolean z = this.f16568h;
        if (z) {
            length2++;
        }
        byte[] bArr2 = new byte[length2];
        bArr2[0] = (byte) this.f16561a;
        bArr2[1] = (byte) this.f16562b;
        bArr2[2] = (byte) this.f16563c;
        bArr2[3] = (byte) this.f16564d;
        if (bArr != null && bArr.length != 0) {
            bArr2[4] = (byte) this.f16565e;
            System.arraycopy(bArr, 0, bArr2, 5, bArr.length);
            length = 5 + bArr.length;
        }
        if (z) {
            bArr2[length] = (byte) (bArr2[length] + ((byte) this.f16567g));
        }
        return bArr2;
    }

    public CommandApdu(int i2, int i3, int i4) {
        this.f16565e = 0;
        this.f16566f = new byte[0];
        this.f16561a = 0;
        this.f16562b = 178;
        this.f16563c = i2;
        this.f16564d = i3;
        this.f16567g = i4;
        this.f16568h = true;
    }
}
