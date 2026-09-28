package com.facebook.hermes.intl;

import com.amazon.identity.auth.device.authorization.RegionUtil;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public interface IPlatformNumberFormatter {

    /* renamed from: com.facebook.hermes.intl.IPlatformNumberFormatter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17573a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f17574b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f17575c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f17576d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int[] f17577e;

        /* renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int[] f17578f;

        /* renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int[] f17579g;

        static {
            int[] iArr = new int[CurrencySign.values().length];
            f17579g = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17579g[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[CurrencyDisplay.values().length];
            f17578f = iArr2;
            try {
                iArr2[0] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17578f[1] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17578f[2] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17578f[3] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[UnitDisplay.values().length];
            f17577e = iArr3;
            try {
                iArr3[0] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17577e[1] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17577e[2] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr4 = new int[SignDisplay.values().length];
            f17576d = iArr4;
            try {
                iArr4[0] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f17576d[1] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f17576d[2] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f17576d[3] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            int[] iArr5 = new int[CompactDisplay.values().length];
            f17575c = iArr5;
            try {
                iArr5[0] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f17575c[1] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr6 = new int[Notation.values().length];
            f17574b = iArr6;
            try {
                iArr6[0] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f17574b[1] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f17574b[2] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f17574b[3] = 4;
            } catch (NoSuchFieldError unused19) {
            }
            int[] iArr7 = new int[Style.values().length];
            f17573a = iArr7;
            try {
                iArr7[0] = 1;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f17573a[1] = 2;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f17573a[2] = 3;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f17573a[3] = 4;
            } catch (NoSuchFieldError unused23) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class CompactDisplay {

        /* renamed from: a, reason: collision with root package name */
        public static final CompactDisplay f17580a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ CompactDisplay[] f17581b;

        static {
            CompactDisplay compactDisplay = new CompactDisplay("SHORT", 0);
            f17580a = compactDisplay;
            f17581b = new CompactDisplay[]{compactDisplay, new CompactDisplay("LONG", 1)};
        }

        public static CompactDisplay valueOf(String str) {
            return (CompactDisplay) Enum.valueOf(CompactDisplay.class, str);
        }

        public static CompactDisplay[] values() {
            return (CompactDisplay[]) f17581b.clone();
        }

        @Override // java.lang.Enum
        public final String toString() {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return "short";
            }
            if (iOrdinal == 1) {
                return "long";
            }
            throw new IllegalArgumentException();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class CurrencyDisplay {

        /* renamed from: a, reason: collision with root package name */
        public static final CurrencyDisplay f17582a;

        /* renamed from: b, reason: collision with root package name */
        public static final CurrencyDisplay f17583b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ CurrencyDisplay[] f17584c;

        static {
            CurrencyDisplay currencyDisplay = new CurrencyDisplay("SYMBOL", 0);
            f17582a = currencyDisplay;
            CurrencyDisplay currencyDisplay2 = new CurrencyDisplay("NARROWSYMBOL", 1);
            CurrencyDisplay currencyDisplay3 = new CurrencyDisplay("CODE", 2);
            f17583b = currencyDisplay3;
            f17584c = new CurrencyDisplay[]{currencyDisplay, currencyDisplay2, currencyDisplay3, new CurrencyDisplay("NAME", 3)};
        }

        public static CurrencyDisplay valueOf(String str) {
            return (CurrencyDisplay) Enum.valueOf(CurrencyDisplay.class, str);
        }

        public static CurrencyDisplay[] values() {
            return (CurrencyDisplay[]) f17584c.clone();
        }

        @Override // java.lang.Enum
        public final String toString() {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return "symbol";
            }
            if (iOrdinal == 1) {
                return "narrowSymbol";
            }
            if (iOrdinal == 2) {
                return "code";
            }
            if (iOrdinal == 3) {
                return CLConstants.FIELD_PAY_INFO_NAME;
            }
            throw new IllegalArgumentException();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class CurrencySign {

        /* renamed from: a, reason: collision with root package name */
        public static final CurrencySign f17585a;

        /* renamed from: b, reason: collision with root package name */
        public static final CurrencySign f17586b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ CurrencySign[] f17587c;

        static {
            CurrencySign currencySign = new CurrencySign("STANDARD", 0);
            f17585a = currencySign;
            CurrencySign currencySign2 = new CurrencySign("ACCOUNTING", 1);
            f17586b = currencySign2;
            f17587c = new CurrencySign[]{currencySign, currencySign2};
        }

        public static CurrencySign valueOf(String str) {
            return (CurrencySign) Enum.valueOf(CurrencySign.class, str);
        }

        public static CurrencySign[] values() {
            return (CurrencySign[]) f17587c.clone();
        }

        @Override // java.lang.Enum
        public final String toString() {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return "standard";
            }
            if (iOrdinal == 1) {
                return "accounting";
            }
            throw new IllegalArgumentException();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Notation {

        /* renamed from: a, reason: collision with root package name */
        public static final Notation f17588a;

        /* renamed from: b, reason: collision with root package name */
        public static final Notation f17589b;

        /* renamed from: c, reason: collision with root package name */
        public static final Notation f17590c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ Notation[] f17591d;

        /* JADX INFO: Fake field, exist only in values array */
        Notation EF0;

        static {
            Notation notation = new Notation("STANDARD", 0);
            Notation notation2 = new Notation("SCIENTIFIC", 1);
            f17588a = notation2;
            Notation notation3 = new Notation("ENGINEERING", 2);
            f17589b = notation3;
            Notation notation4 = new Notation("COMPACT", 3);
            f17590c = notation4;
            f17591d = new Notation[]{notation, notation2, notation3, notation4};
        }

        public static Notation valueOf(String str) {
            return (Notation) Enum.valueOf(Notation.class, str);
        }

        public static Notation[] values() {
            return (Notation[]) f17591d.clone();
        }

        @Override // java.lang.Enum
        public final String toString() {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return "standard";
            }
            if (iOrdinal == 1) {
                return "scientific";
            }
            if (iOrdinal == 2) {
                return "engineering";
            }
            if (iOrdinal == 3) {
                return "compact";
            }
            throw new IllegalArgumentException();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class RoundingType {

        /* renamed from: a, reason: collision with root package name */
        public static final RoundingType f17592a;

        /* renamed from: b, reason: collision with root package name */
        public static final RoundingType f17593b;

        /* renamed from: c, reason: collision with root package name */
        public static final RoundingType f17594c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ RoundingType[] f17595d;

        static {
            RoundingType roundingType = new RoundingType("SIGNIFICANT_DIGITS", 0);
            f17592a = roundingType;
            RoundingType roundingType2 = new RoundingType("FRACTION_DIGITS", 1);
            f17593b = roundingType2;
            RoundingType roundingType3 = new RoundingType("COMPACT_ROUNDING", 2);
            f17594c = roundingType3;
            f17595d = new RoundingType[]{roundingType, roundingType2, roundingType3};
        }

        public static RoundingType valueOf(String str) {
            return (RoundingType) Enum.valueOf(RoundingType.class, str);
        }

        public static RoundingType[] values() {
            return (RoundingType[]) f17595d.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class SignDisplay {

        /* renamed from: a, reason: collision with root package name */
        public static final SignDisplay f17596a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ SignDisplay[] f17597b;

        static {
            SignDisplay signDisplay = new SignDisplay(RegionUtil.REGION_STRING_AUTO, 0);
            f17596a = signDisplay;
            f17597b = new SignDisplay[]{signDisplay, new SignDisplay("ALWAYS", 1), new SignDisplay("NEVER", 2), new SignDisplay("EXCEPTZERO", 3)};
        }

        public static SignDisplay valueOf(String str) {
            return (SignDisplay) Enum.valueOf(SignDisplay.class, str);
        }

        public static SignDisplay[] values() {
            return (SignDisplay[]) f17597b.clone();
        }

        @Override // java.lang.Enum
        public final String toString() {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return "auto";
            }
            if (iOrdinal == 1) {
                return "always";
            }
            if (iOrdinal == 2) {
                return "never";
            }
            if (iOrdinal == 3) {
                return "exceptZero";
            }
            throw new IllegalArgumentException();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Style {

        /* renamed from: a, reason: collision with root package name */
        public static final Style f17598a;

        /* renamed from: b, reason: collision with root package name */
        public static final Style f17599b;

        /* renamed from: c, reason: collision with root package name */
        public static final Style f17600c;

        /* renamed from: d, reason: collision with root package name */
        public static final Style f17601d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ Style[] f17602e;

        static {
            Style style = new Style("DECIMAL", 0);
            f17598a = style;
            Style style2 = new Style("PERCENT", 1);
            f17599b = style2;
            Style style3 = new Style("CURRENCY", 2);
            f17600c = style3;
            Style style4 = new Style("UNIT", 3);
            f17601d = style4;
            f17602e = new Style[]{style, style2, style3, style4};
        }

        public static Style valueOf(String str) {
            return (Style) Enum.valueOf(Style.class, str);
        }

        public static Style[] values() {
            return (Style[]) f17602e.clone();
        }

        @Override // java.lang.Enum
        public final String toString() {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return "decimal";
            }
            if (iOrdinal == 1) {
                return "percent";
            }
            if (iOrdinal == 2) {
                return "currency";
            }
            if (iOrdinal == 3) {
                return "unit";
            }
            throw new IllegalArgumentException();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class UnitDisplay {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UnitDisplay[] f17603a = {new UnitDisplay("SHORT", 0), new UnitDisplay("NARROW", 1), new UnitDisplay("LONG", 2)};

        /* JADX INFO: Fake field, exist only in values array */
        UnitDisplay EF5;

        public static UnitDisplay valueOf(String str) {
            return (UnitDisplay) Enum.valueOf(UnitDisplay.class, str);
        }

        public static UnitDisplay[] values() {
            return (UnitDisplay[]) f17603a.clone();
        }

        @Override // java.lang.Enum
        public final String toString() {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return "short";
            }
            if (iOrdinal == 1) {
                return "narrow";
            }
            if (iOrdinal == 2) {
                return "long";
            }
            throw new IllegalArgumentException();
        }
    }
}
