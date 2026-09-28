package ch.qos.logback.core.subst;

import ch.qos.logback.core.subst.Token;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class Tokenizer {

    /* renamed from: a, reason: collision with root package name */
    public final String f13781a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13782b;

    /* renamed from: c, reason: collision with root package name */
    public TokenizerState f13783c = TokenizerState.f13786a;

    /* renamed from: d, reason: collision with root package name */
    public int f13784d = 0;

    /* renamed from: ch.qos.logback.core.subst.Tokenizer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13785a;

        static {
            int[] iArr = new int[TokenizerState.values().length];
            f13785a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13785a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13785a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class TokenizerState {

        /* renamed from: a, reason: collision with root package name */
        public static final TokenizerState f13786a;

        /* renamed from: b, reason: collision with root package name */
        public static final TokenizerState f13787b;

        /* renamed from: c, reason: collision with root package name */
        public static final TokenizerState f13788c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ TokenizerState[] f13789d;

        static {
            TokenizerState tokenizerState = new TokenizerState("LITERAL_STATE", 0);
            f13786a = tokenizerState;
            TokenizerState tokenizerState2 = new TokenizerState("START_STATE", 1);
            f13787b = tokenizerState2;
            TokenizerState tokenizerState3 = new TokenizerState("DEFAULT_VAL_STATE", 2);
            f13788c = tokenizerState3;
            f13789d = new TokenizerState[]{tokenizerState, tokenizerState2, tokenizerState3};
        }

        public static TokenizerState valueOf(String str) {
            return (TokenizerState) Enum.valueOf(TokenizerState.class, str);
        }

        public static TokenizerState[] values() {
            return (TokenizerState[]) f13789d.clone();
        }
    }

    public Tokenizer(String str) {
        this.f13781a = str;
        this.f13782b = str.length();
    }

    public static void a(ArrayList arrayList, StringBuilder sb) {
        if (sb.length() == 0) {
            return;
        }
        arrayList.add(new Token(Token.Type.f13775a, sb.toString()));
    }
}
