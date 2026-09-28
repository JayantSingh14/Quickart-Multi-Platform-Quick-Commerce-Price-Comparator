package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo
/* loaded from: classes4.dex */
public final class BadgeState {

    /* renamed from: a, reason: collision with root package name */
    public final State f39926a;

    /* renamed from: b, reason: collision with root package name */
    public final State f39927b;

    /* renamed from: c, reason: collision with root package name */
    public final float f39928c;

    /* renamed from: d, reason: collision with root package name */
    public final float f39929d;

    /* renamed from: e, reason: collision with root package name */
    public final float f39930e;

    /* renamed from: f, reason: collision with root package name */
    public final float f39931f;

    /* renamed from: g, reason: collision with root package name */
    public final float f39932g;

    /* renamed from: h, reason: collision with root package name */
    public final float f39933h;

    /* renamed from: i, reason: collision with root package name */
    public final int f39934i;

    /* renamed from: j, reason: collision with root package name */
    public final int f39935j;

    /* renamed from: k, reason: collision with root package name */
    public final int f39936k;

    public static final class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new AnonymousClass1();
        public Integer A;
        public Integer B;
        public Integer C;
        public Boolean D;

        /* renamed from: a, reason: collision with root package name */
        public int f39937a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f39938b;

        /* renamed from: c, reason: collision with root package name */
        public Integer f39939c;

        /* renamed from: d, reason: collision with root package name */
        public Integer f39940d;

        /* renamed from: e, reason: collision with root package name */
        public Integer f39941e;

        /* renamed from: f, reason: collision with root package name */
        public Integer f39942f;

        /* renamed from: g, reason: collision with root package name */
        public Integer f39943g;

        /* renamed from: h, reason: collision with root package name */
        public Integer f39944h;

        /* renamed from: j, reason: collision with root package name */
        public String f39946j;
        public Locale n;
        public String o;
        public CharSequence p;
        public int q;
        public int r;
        public Integer s;
        public Integer u;
        public Integer v;
        public Integer w;
        public Integer x;
        public Integer y;
        public Integer z;

        /* renamed from: i, reason: collision with root package name */
        public int f39945i = 255;

        /* renamed from: k, reason: collision with root package name */
        public int f39947k = -2;

        /* renamed from: l, reason: collision with root package name */
        public int f39948l = -2;

        /* renamed from: m, reason: collision with root package name */
        public int f39949m = -2;
        public Boolean t = Boolean.TRUE;

        /* renamed from: com.google.android.material.badge.BadgeState$State$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<State> {
            @Override // android.os.Parcelable.Creator
            public final State createFromParcel(Parcel parcel) {
                State state = new State();
                state.f39945i = 255;
                state.f39947k = -2;
                state.f39948l = -2;
                state.f39949m = -2;
                state.t = Boolean.TRUE;
                state.f39937a = parcel.readInt();
                state.f39938b = (Integer) parcel.readSerializable();
                state.f39939c = (Integer) parcel.readSerializable();
                state.f39940d = (Integer) parcel.readSerializable();
                state.f39941e = (Integer) parcel.readSerializable();
                state.f39942f = (Integer) parcel.readSerializable();
                state.f39943g = (Integer) parcel.readSerializable();
                state.f39944h = (Integer) parcel.readSerializable();
                state.f39945i = parcel.readInt();
                state.f39946j = parcel.readString();
                state.f39947k = parcel.readInt();
                state.f39948l = parcel.readInt();
                state.f39949m = parcel.readInt();
                state.o = parcel.readString();
                state.p = parcel.readString();
                state.q = parcel.readInt();
                state.s = (Integer) parcel.readSerializable();
                state.u = (Integer) parcel.readSerializable();
                state.v = (Integer) parcel.readSerializable();
                state.w = (Integer) parcel.readSerializable();
                state.x = (Integer) parcel.readSerializable();
                state.y = (Integer) parcel.readSerializable();
                state.z = (Integer) parcel.readSerializable();
                state.C = (Integer) parcel.readSerializable();
                state.A = (Integer) parcel.readSerializable();
                state.B = (Integer) parcel.readSerializable();
                state.t = (Boolean) parcel.readSerializable();
                state.n = (Locale) parcel.readSerializable();
                state.D = (Boolean) parcel.readSerializable();
                return state;
            }

            @Override // android.os.Parcelable.Creator
            public final State[] newArray(int i2) {
                return new State[i2];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f39937a);
            parcel.writeSerializable(this.f39938b);
            parcel.writeSerializable(this.f39939c);
            parcel.writeSerializable(this.f39940d);
            parcel.writeSerializable(this.f39941e);
            parcel.writeSerializable(this.f39942f);
            parcel.writeSerializable(this.f39943g);
            parcel.writeSerializable(this.f39944h);
            parcel.writeInt(this.f39945i);
            parcel.writeString(this.f39946j);
            parcel.writeInt(this.f39947k);
            parcel.writeInt(this.f39948l);
            parcel.writeInt(this.f39949m);
            String str = this.o;
            parcel.writeString(str != null ? str.toString() : null);
            CharSequence charSequence = this.p;
            parcel.writeString(charSequence != null ? charSequence.toString() : null);
            parcel.writeInt(this.q);
            parcel.writeSerializable(this.s);
            parcel.writeSerializable(this.u);
            parcel.writeSerializable(this.v);
            parcel.writeSerializable(this.w);
            parcel.writeSerializable(this.x);
            parcel.writeSerializable(this.y);
            parcel.writeSerializable(this.z);
            parcel.writeSerializable(this.C);
            parcel.writeSerializable(this.A);
            parcel.writeSerializable(this.B);
            parcel.writeSerializable(this.t);
            parcel.writeSerializable(this.n);
            parcel.writeSerializable(this.D);
        }
    }

    public BadgeState(Context context, State state) throws XmlPullParserException, Resources.NotFoundException, IOException {
        AttributeSet attributeSetAsAttributeSet;
        int styleAttribute;
        int next;
        int i2 = BadgeDrawable.o;
        int i3 = BadgeDrawable.n;
        this.f39927b = new State();
        state = state == null ? new State() : state;
        int i4 = state.f39937a;
        boolean z = true;
        if (i4 != 0) {
            try {
                XmlResourceParser xml = context.getResources().getXml(i4);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                if (!TextUtils.equals(xml.getName(), "badge")) {
                    throw new XmlPullParserException("Must have a <" + ((Object) "badge") + "> start tag");
                }
                attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                styleAttribute = attributeSetAsAttributeSet.getStyleAttribute();
            } catch (IOException | XmlPullParserException e2) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i4));
                notFoundException.initCause(e2);
                throw notFoundException;
            }
        } else {
            attributeSetAsAttributeSet = null;
            styleAttribute = 0;
        }
        TypedArray typedArrayD = ThemeEnforcement.d(context, attributeSetAsAttributeSet, R.styleable.Badge, i2, styleAttribute == 0 ? i3 : styleAttribute, new int[0]);
        Resources resources = context.getResources();
        this.f39928c = typedArrayD.getDimensionPixelSize(R.styleable.Badge_badgeRadius, -1);
        this.f39934i = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_horizontal_edge_offset);
        this.f39935j = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_text_horizontal_edge_offset);
        this.f39929d = typedArrayD.getDimensionPixelSize(R.styleable.Badge_badgeWithTextRadius, -1);
        this.f39930e = typedArrayD.getDimension(R.styleable.Badge_badgeWidth, resources.getDimension(R.dimen.m3_badge_size));
        this.f39932g = typedArrayD.getDimension(R.styleable.Badge_badgeWithTextWidth, resources.getDimension(R.dimen.m3_badge_with_text_size));
        this.f39931f = typedArrayD.getDimension(R.styleable.Badge_badgeHeight, resources.getDimension(R.dimen.m3_badge_size));
        this.f39933h = typedArrayD.getDimension(R.styleable.Badge_badgeWithTextHeight, resources.getDimension(R.dimen.m3_badge_with_text_size));
        this.f39936k = typedArrayD.getInt(R.styleable.Badge_offsetAlignmentMode, 1);
        State state2 = this.f39927b;
        int i5 = state.f39945i;
        state2.f39945i = i5 == -2 ? 255 : i5;
        int i6 = state.f39947k;
        if (i6 != -2) {
            state2.f39947k = i6;
        } else if (typedArrayD.hasValue(R.styleable.Badge_number)) {
            this.f39927b.f39947k = typedArrayD.getInt(R.styleable.Badge_number, 0);
        } else {
            this.f39927b.f39947k = -1;
        }
        String str = state.f39946j;
        if (str != null) {
            this.f39927b.f39946j = str;
        } else if (typedArrayD.hasValue(R.styleable.Badge_badgeText)) {
            this.f39927b.f39946j = typedArrayD.getString(R.styleable.Badge_badgeText);
        }
        State state3 = this.f39927b;
        state3.o = state.o;
        CharSequence charSequence = state.p;
        state3.p = charSequence == null ? context.getString(R.string.mtrl_badge_numberless_content_description) : charSequence;
        State state4 = this.f39927b;
        int i7 = state.q;
        state4.q = i7 == 0 ? R.plurals.mtrl_badge_content_description : i7;
        int i8 = state.r;
        state4.r = i8 == 0 ? R.string.mtrl_exceed_max_badge_number_content_description : i8;
        Boolean bool = state.t;
        if (bool != null && !bool.booleanValue()) {
            z = false;
        }
        state4.t = Boolean.valueOf(z);
        State state5 = this.f39927b;
        int i9 = state.f39948l;
        state5.f39948l = i9 == -2 ? typedArrayD.getInt(R.styleable.Badge_maxCharacterCount, -2) : i9;
        State state6 = this.f39927b;
        int i10 = state.f39949m;
        state6.f39949m = i10 == -2 ? typedArrayD.getInt(R.styleable.Badge_maxNumber, -2) : i10;
        State state7 = this.f39927b;
        Integer num = state.f39941e;
        state7.f39941e = Integer.valueOf(num == null ? typedArrayD.getResourceId(R.styleable.Badge_badgeShapeAppearance, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : num.intValue());
        State state8 = this.f39927b;
        Integer num2 = state.f39942f;
        state8.f39942f = Integer.valueOf(num2 == null ? typedArrayD.getResourceId(R.styleable.Badge_badgeShapeAppearanceOverlay, 0) : num2.intValue());
        State state9 = this.f39927b;
        Integer num3 = state.f39943g;
        state9.f39943g = Integer.valueOf(num3 == null ? typedArrayD.getResourceId(R.styleable.Badge_badgeWithTextShapeAppearance, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : num3.intValue());
        State state10 = this.f39927b;
        Integer num4 = state.f39944h;
        state10.f39944h = Integer.valueOf(num4 == null ? typedArrayD.getResourceId(R.styleable.Badge_badgeWithTextShapeAppearanceOverlay, 0) : num4.intValue());
        State state11 = this.f39927b;
        Integer num5 = state.f39938b;
        state11.f39938b = Integer.valueOf(num5 == null ? MaterialResources.a(context, typedArrayD, R.styleable.Badge_backgroundColor).getDefaultColor() : num5.intValue());
        State state12 = this.f39927b;
        Integer num6 = state.f39940d;
        state12.f39940d = Integer.valueOf(num6 == null ? typedArrayD.getResourceId(R.styleable.Badge_badgeTextAppearance, R.style.TextAppearance_MaterialComponents_Badge) : num6.intValue());
        Integer num7 = state.f39939c;
        if (num7 != null) {
            this.f39927b.f39939c = num7;
        } else if (typedArrayD.hasValue(R.styleable.Badge_badgeTextColor)) {
            this.f39927b.f39939c = Integer.valueOf(MaterialResources.a(context, typedArrayD, R.styleable.Badge_badgeTextColor).getDefaultColor());
        } else {
            this.f39927b.f39939c = Integer.valueOf(new TextAppearance(context, this.f39927b.f39940d.intValue()).f40877j.getDefaultColor());
        }
        State state13 = this.f39927b;
        Integer num8 = state.s;
        state13.s = Integer.valueOf(num8 == null ? typedArrayD.getInt(R.styleable.Badge_badgeGravity, 8388661) : num8.intValue());
        State state14 = this.f39927b;
        Integer num9 = state.u;
        state14.u = Integer.valueOf(num9 == null ? typedArrayD.getDimensionPixelSize(R.styleable.Badge_badgeWidePadding, resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding)) : num9.intValue());
        State state15 = this.f39927b;
        Integer num10 = state.v;
        state15.v = Integer.valueOf(num10 == null ? typedArrayD.getDimensionPixelSize(R.styleable.Badge_badgeVerticalPadding, resources.getDimensionPixelSize(R.dimen.m3_badge_with_text_vertical_padding)) : num10.intValue());
        State state16 = this.f39927b;
        Integer num11 = state.w;
        state16.w = Integer.valueOf(num11 == null ? typedArrayD.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0) : num11.intValue());
        State state17 = this.f39927b;
        Integer num12 = state.x;
        state17.x = Integer.valueOf(num12 == null ? typedArrayD.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0) : num12.intValue());
        State state18 = this.f39927b;
        Integer num13 = state.y;
        state18.y = Integer.valueOf(num13 == null ? typedArrayD.getDimensionPixelOffset(R.styleable.Badge_horizontalOffsetWithText, state18.w.intValue()) : num13.intValue());
        State state19 = this.f39927b;
        Integer num14 = state.z;
        state19.z = Integer.valueOf(num14 == null ? typedArrayD.getDimensionPixelOffset(R.styleable.Badge_verticalOffsetWithText, state19.x.intValue()) : num14.intValue());
        State state20 = this.f39927b;
        Integer num15 = state.C;
        state20.C = Integer.valueOf(num15 == null ? typedArrayD.getDimensionPixelOffset(R.styleable.Badge_largeFontVerticalOffsetAdjustment, 0) : num15.intValue());
        State state21 = this.f39927b;
        Integer num16 = state.A;
        state21.A = Integer.valueOf(num16 == null ? 0 : num16.intValue());
        State state22 = this.f39927b;
        Integer num17 = state.B;
        state22.B = Integer.valueOf(num17 == null ? 0 : num17.intValue());
        State state23 = this.f39927b;
        Boolean bool2 = state.D;
        state23.D = Boolean.valueOf(bool2 == null ? typedArrayD.getBoolean(R.styleable.Badge_autoAdjustToWithinGrandparentBounds, false) : bool2.booleanValue());
        typedArrayD.recycle();
        Locale locale = state.n;
        if (locale == null) {
            this.f39927b.n = Locale.getDefault(Locale.Category.FORMAT);
        } else {
            this.f39927b.n = locale;
        }
        this.f39926a = state;
    }
}
