package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.util.SparseArray;
import android.view.KeyEvent;
import androidx.annotation.AnyThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.PaintCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.MetadataRepo;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.util.Iterator;
import java.util.Set;

@AnyThread
@RequiresApi
@RestrictTo
/* loaded from: classes3.dex */
final class EmojiProcessor {

    /* renamed from: a, reason: collision with root package name */
    public final EmojiCompat.DefaultSpanFactory f4317a;

    /* renamed from: b, reason: collision with root package name */
    public final MetadataRepo f4318b;

    /* renamed from: c, reason: collision with root package name */
    public final EmojiCompat.GlyphChecker f4319c;

    @RequiresApi
    public static final class CodepointIndexFinder {
    }

    public static class EmojiProcessAddSpanCallback implements EmojiProcessCallback<UnprecomputeTextOnModificationSpannable> {

        /* renamed from: a, reason: collision with root package name */
        public UnprecomputeTextOnModificationSpannable f4320a;

        /* renamed from: b, reason: collision with root package name */
        public final EmojiCompat.DefaultSpanFactory f4321b;

        public EmojiProcessAddSpanCallback(UnprecomputeTextOnModificationSpannable unprecomputeTextOnModificationSpannable, EmojiCompat.DefaultSpanFactory defaultSpanFactory) {
            this.f4320a = unprecomputeTextOnModificationSpannable;
            this.f4321b = defaultSpanFactory;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public final Object a() {
            return this.f4320a;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public final boolean b(CharSequence charSequence, int i2, int i3, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            if ((typefaceEmojiRasterizer.f4357c & 4) > 0) {
                return true;
            }
            if (this.f4320a == null) {
                this.f4320a = new UnprecomputeTextOnModificationSpannable(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
            }
            this.f4321b.getClass();
            this.f4320a.setSpan(new TypefaceEmojiSpan(typefaceEmojiRasterizer), i2, i3, 33);
            return true;
        }
    }

    public interface EmojiProcessCallback<T> {
        Object a();

        boolean b(CharSequence charSequence, int i2, int i3, TypefaceEmojiRasterizer typefaceEmojiRasterizer);
    }

    public static class EmojiProcessLookupCallback implements EmojiProcessCallback<EmojiProcessLookupCallback> {
        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public final Object a() {
            return this;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public final boolean b(CharSequence charSequence, int i2, int i3, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            return (i2 > 0 || i3 <= 0) && i3 <= 0;
        }
    }

    public static class MarkExclusionCallback implements EmojiProcessCallback<MarkExclusionCallback> {

        /* renamed from: a, reason: collision with root package name */
        public final String f4322a;

        public MarkExclusionCallback(String str) {
            this.f4322a = str;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public final Object a() {
            return this;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public final boolean b(CharSequence charSequence, int i2, int i3, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            if (!TextUtils.equals(charSequence.subSequence(i2, i3), this.f4322a)) {
                return true;
            }
            typefaceEmojiRasterizer.f4357c = (typefaceEmojiRasterizer.f4357c & 3) | 4;
            return false;
        }
    }

    public static final class ProcessorSm {

        /* renamed from: a, reason: collision with root package name */
        public int f4323a = 1;

        /* renamed from: b, reason: collision with root package name */
        public final MetadataRepo.Node f4324b;

        /* renamed from: c, reason: collision with root package name */
        public MetadataRepo.Node f4325c;

        /* renamed from: d, reason: collision with root package name */
        public MetadataRepo.Node f4326d;

        /* renamed from: e, reason: collision with root package name */
        public int f4327e;

        /* renamed from: f, reason: collision with root package name */
        public int f4328f;

        public ProcessorSm(MetadataRepo.Node node) {
            this.f4324b = node;
            this.f4325c = node;
        }

        public final void a() {
            this.f4323a = 1;
            this.f4325c = this.f4324b;
            this.f4328f = 0;
        }

        public final boolean b() {
            MetadataItem metadataItemB = this.f4325c.f4349b.b();
            int iA = metadataItemB.a(6);
            return !(iA == 0 || metadataItemB.f4386b.get(iA + metadataItemB.f4385a) == 0) || this.f4327e == 65039;
        }
    }

    public EmojiProcessor(MetadataRepo metadataRepo, EmojiCompat.DefaultSpanFactory defaultSpanFactory, EmojiCompat.GlyphChecker glyphChecker, Set set) {
        this.f4317a = defaultSpanFactory;
        this.f4318b = metadataRepo;
        this.f4319c = glyphChecker;
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            f(str, 0, str.length(), 1, true, new MarkExclusionCallback(str));
        }
    }

    public static boolean a(Editable editable, KeyEvent keyEvent, boolean z) {
        EmojiSpan[] emojiSpanArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (emojiSpanArr = (EmojiSpan[]) editable.getSpans(selectionStart, selectionEnd, EmojiSpan.class)) != null && emojiSpanArr.length > 0) {
                for (EmojiSpan emojiSpan : emojiSpanArr) {
                    int spanStart = editable.getSpanStart(emojiSpan);
                    int spanEnd = editable.getSpanEnd(emojiSpan);
                    if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0045, code lost:
    
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0082, code lost:
    
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006c A[EDGE_INSN: B:92:0x006c->B:46:0x006c BREAK  A[LOOP:2: B:47:0x006e->B:58:0x0085], EDGE_INSN: B:93:0x006c->B:46:0x006c BREAK  A[LOOP:2: B:47:0x006e->B:58:0x0085, LOOP_LABEL: LOOP:2: B:47:0x006e->B:58:0x0085]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a2 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(android.view.inputmethod.InputConnection r7, android.text.Editable r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.EmojiProcessor.b(android.view.inputmethod.InputConnection, android.text.Editable, int, int, boolean):boolean");
    }

    public static boolean c(Editable editable, int i2, KeyEvent keyEvent) {
        if (!(i2 != 67 ? i2 != 112 ? false : a(editable, keyEvent, true) : a(editable, keyEvent, false))) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    public final boolean d(CharSequence charSequence, int i2, int i3, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        if ((typefaceEmojiRasterizer.f4357c & 3) == 0) {
            EmojiCompat.GlyphChecker glyphChecker = this.f4319c;
            MetadataItem metadataItemB = typefaceEmojiRasterizer.b();
            int iA = metadataItemB.a(8);
            if (iA != 0) {
                metadataItemB.f4386b.getShort(iA + metadataItemB.f4385a);
            }
            DefaultGlyphChecker defaultGlyphChecker = (DefaultGlyphChecker) glyphChecker;
            defaultGlyphChecker.getClass();
            ThreadLocal threadLocal = DefaultGlyphChecker.f4291b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i2 < i3) {
                sb.append(charSequence.charAt(i2));
                i2++;
            }
            boolean zA = PaintCompat.a(defaultGlyphChecker.f4292a, sb.toString());
            int i4 = typefaceEmojiRasterizer.f4357c & 4;
            typefaceEmojiRasterizer.f4357c = zA ? i4 | 2 : i4 | 1;
        }
        return (typefaceEmojiRasterizer.f4357c & 3) == 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0046 A[Catch: all -> 0x0037, TRY_ENTER, TryCatch #0 {all -> 0x0037, blocks: (B:7:0x000f, B:10:0x0014, B:12:0x0018, B:14:0x0025, B:22:0x0046, B:24:0x0050, B:26:0x0053, B:28:0x0056, B:30:0x0066, B:31:0x0069), top: B:59:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056 A[Catch: all -> 0x0037, TryCatch #0 {all -> 0x0037, blocks: (B:7:0x000f, B:10:0x0014, B:12:0x0018, B:14:0x0025, B:22:0x0046, B:24:0x0050, B:26:0x0053, B:28:0x0056, B:30:0x0066, B:31:0x0069), top: B:59:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0078 A[Catch: all -> 0x00ac, TRY_ENTER, TryCatch #2 {all -> 0x00ac, blocks: (B:35:0x0078, B:38:0x0080, B:20:0x003c), top: B:63:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.CharSequence e(java.lang.CharSequence r10, int r11, int r12, boolean r13) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r1 = r10 instanceof androidx.emoji2.text.SpannableBuilder
            if (r1 == 0) goto La
            r0 = r10
            androidx.emoji2.text.SpannableBuilder r0 = (androidx.emoji2.text.SpannableBuilder) r0
            r0.a()
        La:
            r0 = 0
            java.lang.Class<androidx.emoji2.text.EmojiSpan> r2 = androidx.emoji2.text.EmojiSpan.class
            if (r1 != 0) goto L3c
            boolean r3 = r10 instanceof android.text.Spannable     // Catch: java.lang.Throwable -> L37
            if (r3 == 0) goto L14
            goto L3c
        L14:
            boolean r3 = r10 instanceof android.text.Spanned     // Catch: java.lang.Throwable -> L37
            if (r3 == 0) goto L3a
            r3 = r10
            android.text.Spanned r3 = (android.text.Spanned) r3     // Catch: java.lang.Throwable -> L37
            int r4 = r11 + (-1)
            int r5 = r12 + 1
            int r3 = r3.nextSpanTransition(r4, r5, r2)     // Catch: java.lang.Throwable -> L37
            if (r3 > r12) goto L3a
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r3 = new androidx.emoji2.text.UnprecomputeTextOnModificationSpannable     // Catch: java.lang.Throwable -> L37
            r3.<init>()     // Catch: java.lang.Throwable -> L37
            r3.f4359a = r0     // Catch: java.lang.Throwable -> L37
            android.text.SpannableString r4 = new android.text.SpannableString     // Catch: java.lang.Throwable -> L37
            r4.<init>(r10)     // Catch: java.lang.Throwable -> L37
            r3.f4360b = r4     // Catch: java.lang.Throwable -> L37
            goto L44
        L34:
            r3 = r10
            goto Lb3
        L37:
            r0 = move-exception
            r11 = r0
            goto L34
        L3a:
            r3 = 0
            goto L44
        L3c:
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r3 = new androidx.emoji2.text.UnprecomputeTextOnModificationSpannable     // Catch: java.lang.Throwable -> Lac
            r4 = r10
            android.text.Spannable r4 = (android.text.Spannable) r4     // Catch: java.lang.Throwable -> Lac
            r3.<init>(r4)     // Catch: java.lang.Throwable -> Lac
        L44:
            if (r3 == 0) goto L74
            android.text.Spannable r4 = r3.f4360b     // Catch: java.lang.Throwable -> L37
            java.lang.Object[] r2 = r4.getSpans(r11, r12, r2)     // Catch: java.lang.Throwable -> L37
            androidx.emoji2.text.EmojiSpan[] r2 = (androidx.emoji2.text.EmojiSpan[]) r2     // Catch: java.lang.Throwable -> L37
            if (r2 == 0) goto L74
            int r4 = r2.length     // Catch: java.lang.Throwable -> L37
            if (r4 <= 0) goto L74
            int r4 = r2.length     // Catch: java.lang.Throwable -> L37
        L54:
            if (r0 >= r4) goto L74
            r5 = r2[r0]     // Catch: java.lang.Throwable -> L37
            android.text.Spannable r6 = r3.f4360b     // Catch: java.lang.Throwable -> L37
            int r6 = r6.getSpanStart(r5)     // Catch: java.lang.Throwable -> L37
            android.text.Spannable r7 = r3.f4360b     // Catch: java.lang.Throwable -> L37
            int r7 = r7.getSpanEnd(r5)     // Catch: java.lang.Throwable -> L37
            if (r6 == r12) goto L69
            r3.removeSpan(r5)     // Catch: java.lang.Throwable -> L37
        L69:
            int r11 = java.lang.Math.min(r6, r11)     // Catch: java.lang.Throwable -> L37
            int r12 = java.lang.Math.max(r7, r12)     // Catch: java.lang.Throwable -> L37
            int r0 = r0 + 1
            goto L54
        L74:
            r4 = r11
            r5 = r12
            if (r4 == r5) goto L7e
            int r11 = r10.length()     // Catch: java.lang.Throwable -> Lac
            if (r4 < r11) goto L80
        L7e:
            r3 = r10
            goto Laf
        L80:
            androidx.emoji2.text.EmojiProcessor$EmojiProcessAddSpanCallback r8 = new androidx.emoji2.text.EmojiProcessor$EmojiProcessAddSpanCallback     // Catch: java.lang.Throwable -> Lac
            androidx.emoji2.text.EmojiCompat$DefaultSpanFactory r11 = r9.f4317a     // Catch: java.lang.Throwable -> Lac
            r8.<init>(r3, r11)     // Catch: java.lang.Throwable -> Lac
            r6 = 2147483647(0x7fffffff, float:NaN)
            r2 = r9
            r3 = r10
            r7 = r13
            java.lang.Object r10 = r2.f(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> La9
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r10 = (androidx.emoji2.text.UnprecomputeTextOnModificationSpannable) r10     // Catch: java.lang.Throwable -> La9
            if (r10 == 0) goto La0
            android.text.Spannable r10 = r10.f4360b     // Catch: java.lang.Throwable -> La9
            if (r1 == 0) goto L9f
            r11 = r3
            androidx.emoji2.text.SpannableBuilder r11 = (androidx.emoji2.text.SpannableBuilder) r11
            r11.b()
        L9f:
            return r10
        La0:
            if (r1 == 0) goto La8
        La2:
            r10 = r3
            androidx.emoji2.text.SpannableBuilder r10 = (androidx.emoji2.text.SpannableBuilder) r10
            r10.b()
        La8:
            return r3
        La9:
            r0 = move-exception
        Laa:
            r11 = r0
            goto Lb3
        Lac:
            r0 = move-exception
            r3 = r10
            goto Laa
        Laf:
            if (r1 == 0) goto Lb2
            goto La2
        Lb2:
            return r3
        Lb3:
            if (r1 == 0) goto Lbb
            r10 = r3
            androidx.emoji2.text.SpannableBuilder r10 = (androidx.emoji2.text.SpannableBuilder) r10
            r10.b()
        Lbb:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.EmojiProcessor.e(java.lang.CharSequence, int, int, boolean):java.lang.CharSequence");
    }

    public final Object f(CharSequence charSequence, int i2, int i3, int i4, boolean z, EmojiProcessCallback emojiProcessCallback) {
        int i5;
        char c2;
        ProcessorSm processorSm = new ProcessorSm(this.f4318b.f4346c);
        int iCodePointAt = Character.codePointAt(charSequence, i2);
        boolean zB = true;
        int i6 = 0;
        int iCharCount = i2;
        loop0: while (true) {
            i5 = iCharCount;
            while (iCharCount < i3 && i6 < i4 && zB) {
                SparseArray sparseArray = processorSm.f4325c.f4348a;
                MetadataRepo.Node node = sparseArray == null ? null : (MetadataRepo.Node) sparseArray.get(iCodePointAt);
                if (processorSm.f4323a == 2) {
                    if (node != null) {
                        processorSm.f4325c = node;
                        processorSm.f4328f++;
                    } else {
                        if (iCodePointAt == 65038) {
                            processorSm.a();
                        } else if (iCodePointAt != 65039) {
                            MetadataRepo.Node node2 = processorSm.f4325c;
                            if (node2.f4349b != null) {
                                if (processorSm.f4328f != 1) {
                                    processorSm.f4326d = node2;
                                    processorSm.a();
                                } else if (processorSm.b()) {
                                    processorSm.f4326d = processorSm.f4325c;
                                    processorSm.a();
                                } else {
                                    processorSm.a();
                                }
                                c2 = 3;
                            } else {
                                processorSm.a();
                            }
                        }
                        c2 = 1;
                    }
                    c2 = 2;
                } else if (node == null) {
                    processorSm.a();
                    c2 = 1;
                } else {
                    processorSm.f4323a = 2;
                    processorSm.f4325c = node;
                    processorSm.f4328f = 1;
                    c2 = 2;
                }
                processorSm.f4327e = iCodePointAt;
                if (c2 == 1) {
                    iCharCount = Character.charCount(Character.codePointAt(charSequence, i5)) + i5;
                    if (iCharCount < i3) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                    }
                } else if (c2 == 2) {
                    int iCharCount2 = Character.charCount(iCodePointAt) + iCharCount;
                    if (iCharCount2 < i3) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount2);
                    }
                    iCharCount = iCharCount2;
                } else if (c2 == 3) {
                    if (z || !d(charSequence, i5, iCharCount, processorSm.f4326d.f4349b)) {
                        zB = emojiProcessCallback.b(charSequence, i5, iCharCount, processorSm.f4326d.f4349b);
                        i6++;
                    }
                }
            }
            break loop0;
        }
        if (processorSm.f4323a == 2 && processorSm.f4325c.f4349b != null && ((processorSm.f4328f > 1 || processorSm.b()) && i6 < i4 && zB && (z || !d(charSequence, i5, iCharCount, processorSm.f4325c.f4349b)))) {
            emojiProcessCallback.b(charSequence, i5, iCharCount, processorSm.f4325c.f4349b);
        }
        return emojiProcessCallback.a();
    }
}
