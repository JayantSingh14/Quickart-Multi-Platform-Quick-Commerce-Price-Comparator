package org.brotli.dec;

import okio.RealBufferedSource$inputStream$1;

/* loaded from: classes5.dex */
final class State {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public byte[] G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public byte[] Y;

    /* renamed from: b, reason: collision with root package name */
    public int f57431b;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f57433d;

    /* renamed from: g, reason: collision with root package name */
    public int f57436g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f57437h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f57438i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f57439j;
    public int v;
    public int w;
    public int x;
    public byte[] y;
    public byte[] z;

    /* renamed from: a, reason: collision with root package name */
    public int f57430a = 0;

    /* renamed from: c, reason: collision with root package name */
    public final BitReader f57432c = new BitReader();

    /* renamed from: e, reason: collision with root package name */
    public final int[] f57434e = new int[3240];

    /* renamed from: f, reason: collision with root package name */
    public final int[] f57435f = new int[3240];

    /* renamed from: k, reason: collision with root package name */
    public final HuffmanTreeGroup f57440k = new HuffmanTreeGroup();

    /* renamed from: l, reason: collision with root package name */
    public final HuffmanTreeGroup f57441l = new HuffmanTreeGroup();

    /* renamed from: m, reason: collision with root package name */
    public final HuffmanTreeGroup f57442m = new HuffmanTreeGroup();
    public final int[] n = new int[3];
    public final int[] o = new int[3];
    public final int[] p = new int[6];
    public final int[] q = {16, 15, 11, 4};
    public int r = 0;
    public int s = 0;
    public int t = 0;
    public boolean u = false;
    public int P = 0;
    public long Q = 0;
    public final byte[] R = new byte[0];
    public int S = 0;

    public static void a(State state, RealBufferedSource$inputStream$1 realBufferedSource$inputStream$1) {
        int i2;
        if (state.f57430a != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        BitReader bitReader = state.f57432c;
        if (bitReader.f57398d != null) {
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
        byte[] bArr = bitReader.f57395a;
        IntReader intReader = bitReader.f57397c;
        intReader.f57420a = bArr;
        intReader.f57421b = bitReader.f57396b;
        bitReader.f57398d = realBufferedSource$inputStream$1;
        bitReader.f57400f = 0L;
        bitReader.f57401g = 64;
        bitReader.f57402h = 1024;
        bitReader.f57399e = false;
        BitReader.e(bitReader);
        BitReader.a(bitReader, false);
        BitReader.b(bitReader);
        BitReader.b(bitReader);
        if (BitReader.d(bitReader, 1) == 0) {
            i2 = 16;
        } else {
            int iD = BitReader.d(bitReader, 3);
            i2 = 17;
            if (iD != 0) {
                i2 = 17 + iD;
            } else {
                int iD2 = BitReader.d(bitReader, 3);
                if (iD2 != 0) {
                    i2 = iD2 + 8;
                }
            }
        }
        if (i2 == 9) {
            throw new BrotliRuntimeException("Invalid 'windowBits' code");
        }
        int i3 = 1 << i2;
        state.O = i3;
        state.N = i3 - 16;
        state.f57430a = 1;
    }
}
