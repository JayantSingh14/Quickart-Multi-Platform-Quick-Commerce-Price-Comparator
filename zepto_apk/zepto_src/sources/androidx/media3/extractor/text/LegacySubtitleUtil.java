package androidx.media3.extractor.text;

import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.UnstableApi;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public class LegacySubtitleUtil {
    public static void a(Subtitle subtitle, int i2, Consumer consumer) {
        long jC = subtitle.c(i2);
        List listB = subtitle.b(jC);
        if (listB.isEmpty()) {
            return;
        }
        if (i2 == subtitle.d() - 1) {
            throw new IllegalStateException();
        }
        long jC2 = subtitle.c(i2 + 1) - subtitle.c(i2);
        if (jC2 > 0) {
            consumer.accept(new CuesWithTiming(listB, jC, jC2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(androidx.media3.extractor.text.Subtitle r12, androidx.media3.extractor.text.SubtitleParser.OutputOptions r13, androidx.media3.common.util.Consumer r14) {
        /*
            long r0 = r13.f9181a
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r5 = 0
            if (r4 != 0) goto Le
            r4 = r5
            goto L27
        Le:
            int r4 = r12.a(r0)
            r6 = -1
            if (r4 != r6) goto L19
            int r4 = r12.d()
        L19:
            if (r4 <= 0) goto L27
            int r6 = r4 + (-1)
            long r6 = r12.c(r6)
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 != 0) goto L27
            int r4 = r4 + (-1)
        L27:
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L51
            int r2 = r12.d()
            if (r4 >= r2) goto L51
            java.util.List r7 = r12.b(r0)
            long r2 = r12.c(r4)
            boolean r6 = r7.isEmpty()
            if (r6 != 0) goto L51
            long r8 = r13.f9181a
            int r6 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r6 >= 0) goto L51
            androidx.media3.extractor.text.CuesWithTiming r6 = new androidx.media3.extractor.text.CuesWithTiming
            long r10 = r2 - r8
            r6.<init>(r7, r8, r10)
            r14.accept(r6)
            r2 = 1
            goto L52
        L51:
            r2 = r5
        L52:
            r3 = r4
        L53:
            int r6 = r12.d()
            if (r3 >= r6) goto L5f
            a(r12, r3, r14)
            int r3 = r3 + 1
            goto L53
        L5f:
            boolean r13 = r13.f9182b
            if (r13 == 0) goto L87
            if (r2 == 0) goto L67
            int r4 = r4 + (-1)
        L67:
            if (r5 >= r4) goto L6f
            a(r12, r5, r14)
            int r5 = r5 + 1
            goto L67
        L6f:
            if (r2 == 0) goto L87
            androidx.media3.extractor.text.CuesWithTiming r6 = new androidx.media3.extractor.text.CuesWithTiming
            java.util.List r7 = r12.b(r0)
            long r8 = r12.c(r4)
            long r12 = r12.c(r4)
            long r10 = r0 - r12
            r6.<init>(r7, r8, r10)
            r14.accept(r6)
        L87:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.LegacySubtitleUtil.b(androidx.media3.extractor.text.Subtitle, androidx.media3.extractor.text.SubtitleParser$OutputOptions, androidx.media3.common.util.Consumer):void");
    }
}
