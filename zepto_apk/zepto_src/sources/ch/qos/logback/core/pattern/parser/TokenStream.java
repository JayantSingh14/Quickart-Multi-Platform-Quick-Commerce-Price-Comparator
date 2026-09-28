package ch.qos.logback.core.pattern.parser;

import ch.qos.logback.core.pattern.util.IEscapeUtil;
import ch.qos.logback.core.pattern.util.RestrictedEscapeUtil;
import ch.qos.logback.core.spi.ScanException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
class TokenStream {

    /* renamed from: a, reason: collision with root package name */
    public final String f13689a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13690b;

    /* renamed from: c, reason: collision with root package name */
    public final IEscapeUtil f13691c;

    /* renamed from: d, reason: collision with root package name */
    public TokenizerState f13692d;

    /* renamed from: e, reason: collision with root package name */
    public int f13693e;

    /* renamed from: ch.qos.logback.core.pattern.parser.TokenStream$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13694a;

        static {
            int[] iArr = new int[TokenizerState.values().length];
            f13694a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13694a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13694a[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13694a[2] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13694a[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class TokenizerState {

        /* renamed from: a, reason: collision with root package name */
        public static final TokenizerState f13695a;

        /* renamed from: b, reason: collision with root package name */
        public static final TokenizerState f13696b;

        /* renamed from: c, reason: collision with root package name */
        public static final TokenizerState f13697c;

        /* renamed from: d, reason: collision with root package name */
        public static final TokenizerState f13698d;

        /* renamed from: e, reason: collision with root package name */
        public static final TokenizerState f13699e;

        /* renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ TokenizerState[] f13700f;

        static {
            TokenizerState tokenizerState = new TokenizerState("LITERAL_STATE", 0);
            f13695a = tokenizerState;
            TokenizerState tokenizerState2 = new TokenizerState("FORMAT_MODIFIER_STATE", 1);
            f13696b = tokenizerState2;
            TokenizerState tokenizerState3 = new TokenizerState("KEYWORD_STATE", 2);
            f13697c = tokenizerState3;
            TokenizerState tokenizerState4 = new TokenizerState("OPTION_STATE", 3);
            f13698d = tokenizerState4;
            TokenizerState tokenizerState5 = new TokenizerState("RIGHT_PARENTHESIS_STATE", 4);
            f13699e = tokenizerState5;
            f13700f = new TokenizerState[]{tokenizerState, tokenizerState2, tokenizerState3, tokenizerState4, tokenizerState5};
        }

        public static TokenizerState valueOf(String str) {
            return (TokenizerState) Enum.valueOf(TokenizerState.class, str);
        }

        public static TokenizerState[] values() {
            return (TokenizerState[]) f13700f.clone();
        }
    }

    public TokenStream(String str, IEscapeUtil iEscapeUtil) {
        new RestrictedEscapeUtil();
        this.f13692d = TokenizerState.f13695a;
        this.f13693e = 0;
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("null or empty pattern string not allowed");
        }
        this.f13689a = str;
        this.f13690b = str.length();
        this.f13691c = iEscapeUtil;
    }

    public static void a(int i2, StringBuffer stringBuffer, ArrayList arrayList) {
        if (stringBuffer.length() > 0) {
            arrayList.add(new Token(i2, stringBuffer.toString()));
            stringBuffer.setLength(0);
        }
    }

    public final ArrayList b() throws ScanException {
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int i2 = this.f13693e;
            Token token = Token.f13684c;
            int i3 = this.f13690b;
            if (i2 >= i3) {
                int iOrdinal = this.f13692d.ordinal();
                if (iOrdinal == 0) {
                    a(1000, stringBuffer, arrayList);
                    return arrayList;
                }
                if (iOrdinal != 1) {
                    if (iOrdinal == 2) {
                        arrayList.add(new Token(1004, stringBuffer.toString()));
                        return arrayList;
                    }
                    if (iOrdinal != 3) {
                        if (iOrdinal != 4) {
                            return arrayList;
                        }
                        arrayList.add(token);
                        return arrayList;
                    }
                }
                throw new ScanException("Unexpected end of pattern string");
            }
            String str = this.f13689a;
            char cCharAt = str.charAt(i2);
            this.f13693e++;
            int iOrdinal2 = this.f13692d.ordinal();
            TokenizerState tokenizerState = TokenizerState.f13699e;
            TokenizerState tokenizerState2 = TokenizerState.f13696b;
            Token token2 = Token.f13686e;
            IEscapeUtil iEscapeUtil = this.f13691c;
            if (iOrdinal2 != 0) {
                TokenizerState tokenizerState3 = TokenizerState.f13695a;
                if (iOrdinal2 != 1) {
                    TokenizerState tokenizerState4 = TokenizerState.f13698d;
                    if (iOrdinal2 != 2) {
                        if (iOrdinal2 == 3) {
                            OptionTokenizer optionTokenizer = new OptionTokenizer(this);
                            StringBuffer stringBuffer2 = new StringBuffer();
                            ArrayList arrayList2 = new ArrayList();
                            while (true) {
                                TokenStream tokenStream = optionTokenizer.f13675b;
                                int i4 = tokenStream.f13693e;
                                int i5 = optionTokenizer.f13677d;
                                if (i4 < i5) {
                                    int i6 = optionTokenizer.f13679f;
                                    String str2 = optionTokenizer.f13676c;
                                    if (i6 != 0) {
                                        if (i6 != 1) {
                                            if (i6 == 2) {
                                                char c2 = optionTokenizer.f13678e;
                                                if (cCharAt == c2) {
                                                    arrayList2.add(stringBuffer2.toString());
                                                    stringBuffer2.setLength(0);
                                                    optionTokenizer.f13679f = 0;
                                                } else if (cCharAt == '\\') {
                                                    String.valueOf(c2);
                                                    int i7 = tokenStream.f13693e;
                                                    if (i7 < i5) {
                                                        tokenStream.f13693e = i7 + 1;
                                                        char cCharAt2 = str2.charAt(i7);
                                                        optionTokenizer.f13674a.getClass();
                                                        stringBuffer2.append("\\");
                                                        stringBuffer2.append(cCharAt2);
                                                    }
                                                } else {
                                                    stringBuffer2.append(cCharAt);
                                                }
                                            }
                                        } else if (cCharAt == ',') {
                                            arrayList2.add(stringBuffer2.toString().trim());
                                            stringBuffer2.setLength(0);
                                            optionTokenizer.f13679f = 0;
                                        } else {
                                            if (cCharAt == '}') {
                                                arrayList2.add(stringBuffer2.toString().trim());
                                                optionTokenizer.a(arrayList, arrayList2);
                                                break;
                                            }
                                            stringBuffer2.append(cCharAt);
                                        }
                                        cCharAt = str2.charAt(tokenStream.f13693e);
                                        tokenStream.f13693e++;
                                    } else {
                                        if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                                            if (cCharAt != '\"' && cCharAt != '\'') {
                                                if (cCharAt != ',') {
                                                    if (cCharAt == '}') {
                                                        optionTokenizer.a(arrayList, arrayList2);
                                                        break;
                                                    }
                                                    stringBuffer2.append(cCharAt);
                                                    optionTokenizer.f13679f = 1;
                                                } else {
                                                    continue;
                                                }
                                            } else {
                                                optionTokenizer.f13679f = 2;
                                                optionTokenizer.f13678e = cCharAt;
                                            }
                                        }
                                        cCharAt = str2.charAt(tokenStream.f13693e);
                                        tokenStream.f13693e++;
                                    }
                                } else {
                                    if (cCharAt != '}') {
                                        throw new ScanException("Unexpected end of pattern string in OptionTokenizer");
                                    }
                                    int i8 = optionTokenizer.f13679f;
                                    if (i8 == 0) {
                                        optionTokenizer.a(arrayList, arrayList2);
                                    } else {
                                        if (i8 != 1) {
                                            throw new ScanException("Unexpected end of pattern string in OptionTokenizer");
                                        }
                                        arrayList2.add(stringBuffer2.toString().trim());
                                        optionTokenizer.a(arrayList, arrayList2);
                                    }
                                }
                            }
                        } else if (iOrdinal2 == 4) {
                            arrayList.add(token);
                            if (cCharAt != ')') {
                                if (cCharAt == '\\') {
                                    int i9 = this.f13693e;
                                    if (i9 < i3) {
                                        this.f13693e = i9 + 1;
                                        iEscapeUtil.a("%{}", stringBuffer, str.charAt(i9), this.f13693e);
                                    }
                                    this.f13692d = tokenizerState3;
                                } else if (cCharAt != '{') {
                                    stringBuffer.append(cCharAt);
                                    this.f13692d = tokenizerState3;
                                } else {
                                    this.f13692d = tokenizerState4;
                                }
                            }
                        }
                    } else if (Character.isJavaIdentifierPart(cCharAt)) {
                        stringBuffer.append(cCharAt);
                    } else if (cCharAt == '{') {
                        a(1004, stringBuffer, arrayList);
                        this.f13692d = tokenizerState4;
                    } else if (cCharAt == '(') {
                        a(1005, stringBuffer, arrayList);
                        this.f13692d = tokenizerState3;
                    } else if (cCharAt == '%') {
                        a(1004, stringBuffer, arrayList);
                        arrayList.add(token2);
                        this.f13692d = tokenizerState2;
                    } else if (cCharAt == ')') {
                        a(1004, stringBuffer, arrayList);
                        this.f13692d = tokenizerState;
                    } else {
                        a(1004, stringBuffer, arrayList);
                        if (cCharAt == '\\') {
                            int i10 = this.f13693e;
                            if (i10 < i3) {
                                this.f13693e = i10 + 1;
                                iEscapeUtil.a("%()", stringBuffer, str.charAt(i10), this.f13693e);
                            }
                        } else {
                            stringBuffer.append(cCharAt);
                        }
                        this.f13692d = tokenizerState3;
                    }
                } else if (cCharAt == '(') {
                    a(1002, stringBuffer, arrayList);
                    arrayList.add(Token.f13685d);
                    this.f13692d = tokenizerState3;
                } else if (Character.isJavaIdentifierStart(cCharAt)) {
                    a(1002, stringBuffer, arrayList);
                    this.f13692d = TokenizerState.f13697c;
                    stringBuffer.append(cCharAt);
                } else {
                    stringBuffer.append(cCharAt);
                }
            } else if (cCharAt == '%') {
                a(1000, stringBuffer, arrayList);
                arrayList.add(token2);
                this.f13692d = tokenizerState2;
            } else if (cCharAt == ')') {
                a(1000, stringBuffer, arrayList);
                this.f13692d = tokenizerState;
            } else if (cCharAt != '\\') {
                stringBuffer.append(cCharAt);
            } else {
                int i11 = this.f13693e;
                if (i11 < i3) {
                    this.f13693e = i11 + 1;
                    iEscapeUtil.a("%()", stringBuffer, str.charAt(i11), this.f13693e);
                }
            }
        }
    }
}
