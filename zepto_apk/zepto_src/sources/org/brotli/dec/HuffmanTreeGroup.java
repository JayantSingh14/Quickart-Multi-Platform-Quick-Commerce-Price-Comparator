package org.brotli.dec;

/* loaded from: classes5.dex */
final class HuffmanTreeGroup {

    /* renamed from: a, reason: collision with root package name */
    public int f57417a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f57418b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f57419c;

    public static void a(HuffmanTreeGroup huffmanTreeGroup, BitReader bitReader) {
        int length = huffmanTreeGroup.f57419c.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            huffmanTreeGroup.f57419c[i3] = i2;
            Decode.e(huffmanTreeGroup.f57417a, huffmanTreeGroup.f57418b, i2, bitReader);
            i2 += 1080;
        }
    }
}
