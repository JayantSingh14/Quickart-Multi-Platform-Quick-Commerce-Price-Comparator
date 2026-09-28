package androidx.media3.exoplayer.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.text.SubtitleDecoderFactory;
import androidx.media3.extractor.text.CueDecoder;
import androidx.media3.extractor.text.SubtitleDecoder;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import androidx.media3.extractor.text.SubtitleOutputBuffer;
import com.google.common.collect.ImmutableList;
import java.util.Objects;

@UnstableApi
/* loaded from: classes3.dex */
public final class TextRenderer extends BaseRenderer implements Handler.Callback {
    public SubtitleOutputBuffer A;
    public int B;
    public final Handler C;
    public final TextOutput D;
    public final FormatHolder E;
    public boolean F;
    public boolean G;
    public Format H;
    public long I;
    public long J;
    public long K;
    public final CueDecoder r;
    public final DecoderInputBuffer s;
    public CuesResolver t;
    public final SubtitleDecoderFactory u;
    public boolean v;
    public int w;
    public SubtitleDecoder x;
    public SubtitleInputBuffer y;
    public SubtitleOutputBuffer z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextRenderer(TextOutput textOutput, Looper looper) {
        Handler handler;
        super(3);
        SubtitleDecoderFactory subtitleDecoderFactory = SubtitleDecoderFactory.f7956a;
        this.D = textOutput;
        if (looper == null) {
            handler = null;
        } else {
            int i2 = Util.f5744a;
            handler = new Handler(looper, this);
        }
        this.C = handler;
        this.u = subtitleDecoderFactory;
        this.r = new CueDecoder();
        this.s = new DecoderInputBuffer(1);
        this.E = new FormatHolder();
        this.K = -9223372036854775807L;
        this.I = -9223372036854775807L;
        this.J = -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void G() {
        this.H = null;
        this.K = -9223372036854775807L;
        Q();
        this.I = -9223372036854775807L;
        this.J = -9223372036854775807L;
        if (this.x != null) {
            T();
            SubtitleDecoder subtitleDecoder = this.x;
            subtitleDecoder.getClass();
            subtitleDecoder.release();
            this.x = null;
            this.w = 0;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0089  */
    @Override // androidx.media3.exoplayer.BaseRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void I(long r6, boolean r8) {
        /*
            r5 = this;
            r8 = 1
            r0 = 0
            r5.J = r6
            androidx.media3.exoplayer.text.CuesResolver r6 = r5.t
            if (r6 == 0) goto Lb
            r6.clear()
        Lb:
            r5.Q()
            r5.F = r0
            r5.G = r0
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5.K = r6
            androidx.media3.common.Format r6 = r5.H
            if (r6 == 0) goto Lcc
            java.lang.String r6 = r6.f5225m
            java.lang.String r7 = "application/x-media3-cues"
            boolean r6 = java.util.Objects.equals(r6, r7)
            if (r6 != 0) goto Lcc
            int r6 = r5.w
            if (r6 == 0) goto Lbc
            r5.T()
            androidx.media3.extractor.text.SubtitleDecoder r6 = r5.x
            r6.getClass()
            r6.release()
            r6 = 0
            r5.x = r6
            r5.w = r0
            r5.v = r8
            androidx.media3.common.Format r6 = r5.H
            r6.getClass()
            androidx.media3.exoplayer.text.SubtitleDecoderFactory r7 = r5.u
            androidx.media3.exoplayer.text.SubtitleDecoderFactory$1 r7 = (androidx.media3.exoplayer.text.SubtitleDecoderFactory.AnonymousClass1) r7
            r7.getClass()
            java.lang.String r1 = r6.f5225m
            if (r1 == 0) goto L89
            int r2 = r6.F
            r3 = -1
            int r4 = r1.hashCode()
            switch(r4) {
                case 930165504: goto L6d;
                case 1566015601: goto L64;
                case 1566016562: goto L59;
                default: goto L57;
            }
        L57:
            r8 = r3
            goto L77
        L59:
            java.lang.String r8 = "application/cea-708"
            boolean r8 = r1.equals(r8)
            if (r8 != 0) goto L62
            goto L57
        L62:
            r8 = 2
            goto L77
        L64:
            java.lang.String r0 = "application/cea-608"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L77
            goto L57
        L6d:
            java.lang.String r8 = "application/x-mp4-cea-608"
            boolean r8 = r1.equals(r8)
            if (r8 != 0) goto L76
            goto L57
        L76:
            r8 = r0
        L77:
            switch(r8) {
                case 0: goto L83;
                case 1: goto L83;
                case 2: goto L7b;
                default: goto L7a;
            }
        L7a:
            goto L89
        L7b:
            androidx.media3.extractor.text.cea.Cea708Decoder r7 = new androidx.media3.extractor.text.cea.Cea708Decoder
            java.util.List r6 = r6.p
            r7.<init>(r2, r6)
            goto La8
        L83:
            androidx.media3.extractor.text.cea.Cea608Decoder r7 = new androidx.media3.extractor.text.cea.Cea608Decoder
            r7.<init>(r1, r2)
            goto La8
        L89:
            androidx.media3.extractor.text.DefaultSubtitleParserFactory r7 = r7.f7957b
            boolean r8 = r7.b(r6)
            if (r8 == 0) goto Lb0
            androidx.media3.extractor.text.SubtitleParser r6 = r7.c(r6)
            androidx.media3.exoplayer.text.DelegatingSubtitleDecoder r7 = new androidx.media3.exoplayer.text.DelegatingSubtitleDecoder
            java.lang.Class r8 = r6.getClass()
            java.lang.String r8 = r8.getSimpleName()
            java.lang.String r0 = "Decoder"
            java.lang.String r8 = r8.concat(r0)
            r7.<init>(r8, r6)
        La8:
            r5.x = r7
            long r0 = r5.f6123l
            r7.d(r0)
            return
        Lb0:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Attempted to create decoder for unsupported MIME type: "
            java.lang.String r7 = android.support.v4.media.b.C(r7, r1)
            r6.<init>(r7)
            throw r6
        Lbc:
            r5.T()
            androidx.media3.extractor.text.SubtitleDecoder r6 = r5.x
            r6.getClass()
            r6.flush()
            long r7 = r5.f6123l
            r6.d(r7)
        Lcc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.text.TextRenderer.I(long, boolean):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006a  */
    @Override // androidx.media3.exoplayer.BaseRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void N(androidx.media3.common.Format[] r4, long r5, long r7) {
        /*
            r3 = this;
            r5 = 1
            r3.I = r7
            r6 = 0
            r4 = r4[r6]
            r3.H = r4
            java.lang.String r4 = r4.f5225m
            java.lang.String r7 = "application/x-media3-cues"
            boolean r4 = java.util.Objects.equals(r4, r7)
            if (r4 != 0) goto L9d
            r3.P()
            androidx.media3.extractor.text.SubtitleDecoder r4 = r3.x
            if (r4 == 0) goto L1c
            r3.w = r5
            return
        L1c:
            r3.v = r5
            androidx.media3.common.Format r4 = r3.H
            r4.getClass()
            androidx.media3.exoplayer.text.SubtitleDecoderFactory r7 = r3.u
            androidx.media3.exoplayer.text.SubtitleDecoderFactory$1 r7 = (androidx.media3.exoplayer.text.SubtitleDecoderFactory.AnonymousClass1) r7
            r7.getClass()
            java.lang.String r8 = r4.f5225m
            if (r8 == 0) goto L6a
            int r0 = r4.F
            r1 = -1
            int r2 = r8.hashCode()
            switch(r2) {
                case 930165504: goto L4e;
                case 1566015601: goto L45;
                case 1566016562: goto L3a;
                default: goto L38;
            }
        L38:
            r5 = r1
            goto L58
        L3a:
            java.lang.String r5 = "application/cea-708"
            boolean r5 = r8.equals(r5)
            if (r5 != 0) goto L43
            goto L38
        L43:
            r5 = 2
            goto L58
        L45:
            java.lang.String r6 = "application/cea-608"
            boolean r6 = r8.equals(r6)
            if (r6 != 0) goto L58
            goto L38
        L4e:
            java.lang.String r5 = "application/x-mp4-cea-608"
            boolean r5 = r8.equals(r5)
            if (r5 != 0) goto L57
            goto L38
        L57:
            r5 = r6
        L58:
            switch(r5) {
                case 0: goto L64;
                case 1: goto L64;
                case 2: goto L5c;
                default: goto L5b;
            }
        L5b:
            goto L6a
        L5c:
            androidx.media3.extractor.text.cea.Cea708Decoder r5 = new androidx.media3.extractor.text.cea.Cea708Decoder
            java.util.List r4 = r4.p
            r5.<init>(r0, r4)
            goto L89
        L64:
            androidx.media3.extractor.text.cea.Cea608Decoder r5 = new androidx.media3.extractor.text.cea.Cea608Decoder
            r5.<init>(r8, r0)
            goto L89
        L6a:
            androidx.media3.extractor.text.DefaultSubtitleParserFactory r5 = r7.f7957b
            boolean r6 = r5.b(r4)
            if (r6 == 0) goto L91
            androidx.media3.extractor.text.SubtitleParser r4 = r5.c(r4)
            androidx.media3.exoplayer.text.DelegatingSubtitleDecoder r5 = new androidx.media3.exoplayer.text.DelegatingSubtitleDecoder
            java.lang.Class r6 = r4.getClass()
            java.lang.String r6 = r6.getSimpleName()
            java.lang.String r7 = "Decoder"
            java.lang.String r6 = r6.concat(r7)
            r5.<init>(r6, r4)
        L89:
            r3.x = r5
            long r6 = r3.f6123l
            r5.d(r6)
            return
        L91:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Attempted to create decoder for unsupported MIME type: "
            java.lang.String r5 = android.support.v4.media.b.C(r5, r8)
            r4.<init>(r5)
            throw r4
        L9d:
            androidx.media3.common.Format r4 = r3.H
            int r4 = r4.G
            if (r4 != r5) goto La9
            androidx.media3.exoplayer.text.MergingCuesResolver r4 = new androidx.media3.exoplayer.text.MergingCuesResolver
            r4.<init>()
            goto Lae
        La9:
            androidx.media3.exoplayer.text.ReplacingCuesResolver r4 = new androidx.media3.exoplayer.text.ReplacingCuesResolver
            r4.<init>()
        Lae:
            r3.t = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.text.TextRenderer.N(androidx.media3.common.Format[], long, long):void");
    }

    public final void P() {
        Assertions.f("Legacy decoding is disabled, can't handle " + this.H.f5225m + " samples (expected application/x-media3-cues).", Objects.equals(this.H.f5225m, "application/cea-608") || Objects.equals(this.H.f5225m, "application/x-mp4-cea-608") || Objects.equals(this.H.f5225m, "application/cea-708"));
    }

    public final void Q() {
        CueGroup cueGroup = new CueGroup(S(this.J), ImmutableList.r());
        Handler handler = this.C;
        if (handler != null) {
            handler.obtainMessage(1, cueGroup).sendToTarget();
            return;
        }
        TextOutput textOutput = this.D;
        textOutput.k(cueGroup.f5641a);
        textOutput.e1(cueGroup);
    }

    public final long R() {
        if (this.B == -1) {
            return Long.MAX_VALUE;
        }
        this.z.getClass();
        if (this.B >= this.z.d()) {
            return Long.MAX_VALUE;
        }
        return this.z.c(this.B);
    }

    public final long S(long j2) {
        Assertions.g(j2 != -9223372036854775807L);
        Assertions.g(this.I != -9223372036854775807L);
        return j2 - this.I;
    }

    public final void T() {
        this.y = null;
        this.B = -1;
        SubtitleOutputBuffer subtitleOutputBuffer = this.z;
        if (subtitleOutputBuffer != null) {
            subtitleOutputBuffer.i();
            this.z = null;
        }
        SubtitleOutputBuffer subtitleOutputBuffer2 = this.A;
        if (subtitleOutputBuffer2 != null) {
            subtitleOutputBuffer2.i();
            this.A = null;
        }
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final boolean a() {
        return true;
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public final int b(Format format) {
        if (!Objects.equals(format.f5225m, "application/x-media3-cues")) {
            SubtitleDecoderFactory.AnonymousClass1 anonymousClass1 = (SubtitleDecoderFactory.AnonymousClass1) this.u;
            anonymousClass1.getClass();
            if (!anonymousClass1.f7957b.b(format)) {
                String str = format.f5225m;
                if (!Objects.equals(str, "application/cea-608") && !Objects.equals(str, "application/x-mp4-cea-608") && !Objects.equals(str, "application/cea-708")) {
                    return MimeTypes.n(str) ? RendererCapabilities.h(1, 0, 0, 0) : RendererCapabilities.h(0, 0, 0, 0);
                }
            }
        }
        return RendererCapabilities.h(format.J == 0 ? 4 : 2, 0, 0, 0);
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.Renderer
    public final boolean c() {
        return this.G;
    }

    @Override // androidx.media3.exoplayer.Renderer, androidx.media3.exoplayer.RendererCapabilities
    public final String getName() {
        return "TextRenderer";
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 1) {
            throw new IllegalStateException();
        }
        CueGroup cueGroup = (CueGroup) message.obj;
        ImmutableList immutableList = cueGroup.f5641a;
        TextOutput textOutput = this.D;
        textOutput.k(immutableList);
        textOutput.e1(cueGroup);
        return true;
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:493)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:496)
        */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01bd  */
    @Override // androidx.media3.exoplayer.Renderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(long r25, long r27) {
        /*
            Method dump skipped, instructions count: 1220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.text.TextRenderer.i(long, long):void");
    }
}
