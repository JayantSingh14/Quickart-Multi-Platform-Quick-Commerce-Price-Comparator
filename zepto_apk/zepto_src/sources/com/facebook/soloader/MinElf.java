package com.facebook.soloader;

import android.util.Log;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedByInterruptException;

/* loaded from: classes.dex */
public final class MinElf {

    @DoNotStripAny
    public static class ElfError extends UnsatisfiedLinkError {
    }

    /* loaded from: classes3.dex */
    public interface ISA {
    }

    public static String[] a(ElfByteChannel elfByteChannel) throws ClosedByInterruptException {
        if (!(elfByteChannel instanceof ElfFileChannel)) {
            return b(elfByteChannel);
        }
        ElfFileChannel elfFileChannel = (ElfFileChannel) elfByteChannel;
        int i2 = 0;
        while (true) {
            try {
                return b(elfFileChannel);
            } catch (ClosedByInterruptException e2) {
                i2++;
                if (i2 > 4) {
                    throw e2;
                }
                Thread.interrupted();
                Log.e("MinElf", "retrying extract_DT_NEEDED due to ClosedByInterruptException", e2);
                FileInputStream fileInputStream = new FileInputStream(elfFileChannel.f20257a);
                elfFileChannel.f20258b = fileInputStream;
                elfFileChannel.f20259c = fileInputStream.getChannel();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0244 A[LOOP:1: B:49:0x00f6->B:133:0x0244, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String[] b(com.facebook.soloader.ElfByteChannel r37) {
        /*
            Method dump skipped, instructions count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.MinElf.b(com.facebook.soloader.ElfByteChannel):java.lang.String[]");
    }

    public static long c(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j2) {
        d(elfByteChannel, byteBuffer, 4, j2);
        return byteBuffer.getInt() & 4294967295L;
    }

    public static void d(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, int i2, long j2) {
        int iR;
        byteBuffer.position(0);
        byteBuffer.limit(i2);
        while (byteBuffer.remaining() > 0 && (iR = elfByteChannel.R(byteBuffer, j2)) != -1) {
            j2 += iR;
        }
        if (byteBuffer.remaining() > 0) {
            throw new ElfError("ELF file truncated");
        }
        byteBuffer.position(0);
    }
}
