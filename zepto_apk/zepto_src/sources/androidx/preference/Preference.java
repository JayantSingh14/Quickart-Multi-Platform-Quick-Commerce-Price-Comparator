package androidx.preference;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.common.api.Api;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class Preference implements Comparable<Preference> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f11080a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11081b;

    /* renamed from: c, reason: collision with root package name */
    public final CharSequence f11082c;

    /* renamed from: d, reason: collision with root package name */
    public final CharSequence f11083d;

    /* renamed from: e, reason: collision with root package name */
    public final int f11084e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f11085f;

    /* renamed from: g, reason: collision with root package name */
    public final String f11086g;

    /* renamed from: h, reason: collision with root package name */
    public final String f11087h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f11088i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f11089j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f11090k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f11091l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f11092m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public final boolean t;
    public final int u;
    public final int v;
    public PreferenceGroupAdapter w;
    public OnPreferenceCopyListener x;
    public SummaryProvider y;
    public final View.OnClickListener z;

    public static class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new AnonymousClass1();

        /* renamed from: androidx.preference.Preference$BaseSavedState$1, reason: invalid class name */
        public static class AnonymousClass1 implements Parcelable.Creator<BaseSavedState> {
            @Override // android.os.Parcelable.Creator
            public final BaseSavedState createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final BaseSavedState[] newArray(int i2) {
                return new BaseSavedState[i2];
            }
        }

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }
    }

    public interface OnPreferenceChangeInternalListener {
    }

    public interface OnPreferenceChangeListener {
    }

    public interface OnPreferenceClickListener {
    }

    public static class OnPreferenceCopyListener implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final Preference f11094a;

        public OnPreferenceCopyListener(Preference preference) {
            this.f11094a = preference;
        }

        @Override // android.view.View.OnCreateContextMenuListener
        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            Preference preference = this.f11094a;
            CharSequence charSequenceB = preference.b();
            if (!preference.s || TextUtils.isEmpty(charSequenceB)) {
                return;
            }
            contextMenu.setHeaderTitle(charSequenceB);
            contextMenu.add(0, 0, 0, R.string.copy).setOnMenuItemClickListener(this);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            Preference preference = this.f11094a;
            ClipboardManager clipboardManager = (ClipboardManager) preference.f11080a.getSystemService("clipboard");
            CharSequence charSequenceB = preference.b();
            clipboardManager.setPrimaryClip(ClipData.newPlainText("Preference", charSequenceB));
            Context context = preference.f11080a;
            Toast.makeText(context, context.getString(R.string.preference_copied, charSequenceB), 0).show();
            return true;
        }
    }

    public interface SummaryProvider<T extends Preference> {
        CharSequence a(Preference preference);
    }

    public Preference(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f11081b = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f11088i = true;
        this.f11089j = true;
        this.f11091l = true;
        this.f11092m = true;
        this.n = true;
        this.o = true;
        this.q = true;
        this.t = true;
        this.u = R.layout.preference;
        this.z = new View.OnClickListener() { // from class: androidx.preference.Preference.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Preference.this.n(view);
            }
        };
        this.f11080a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Preference, i2, 0);
        this.f11084e = typedArrayObtainStyledAttributes.getResourceId(R.styleable.Preference_icon, typedArrayObtainStyledAttributes.getResourceId(R.styleable.Preference_android_icon, 0));
        int i4 = R.styleable.Preference_key;
        int i5 = R.styleable.Preference_android_key;
        String string = typedArrayObtainStyledAttributes.getString(i4);
        this.f11086g = string == null ? typedArrayObtainStyledAttributes.getString(i5) : string;
        int i6 = R.styleable.Preference_title;
        int i7 = R.styleable.Preference_android_title;
        CharSequence text = typedArrayObtainStyledAttributes.getText(i6);
        this.f11082c = text == null ? typedArrayObtainStyledAttributes.getText(i7) : text;
        int i8 = R.styleable.Preference_summary;
        int i9 = R.styleable.Preference_android_summary;
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(i8);
        this.f11083d = text2 == null ? typedArrayObtainStyledAttributes.getText(i9) : text2;
        this.f11081b = typedArrayObtainStyledAttributes.getInt(R.styleable.Preference_order, typedArrayObtainStyledAttributes.getInt(R.styleable.Preference_android_order, Api.BaseClientBuilder.API_PRIORITY_OTHER));
        int i10 = R.styleable.Preference_fragment;
        int i11 = R.styleable.Preference_android_fragment;
        String string2 = typedArrayObtainStyledAttributes.getString(i10);
        this.f11087h = string2 == null ? typedArrayObtainStyledAttributes.getString(i11) : string2;
        this.u = typedArrayObtainStyledAttributes.getResourceId(R.styleable.Preference_layout, typedArrayObtainStyledAttributes.getResourceId(R.styleable.Preference_android_layout, R.layout.preference));
        this.v = typedArrayObtainStyledAttributes.getResourceId(R.styleable.Preference_widgetLayout, typedArrayObtainStyledAttributes.getResourceId(R.styleable.Preference_android_widgetLayout, 0));
        this.f11088i = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Preference_enabled, typedArrayObtainStyledAttributes.getBoolean(R.styleable.Preference_android_enabled, true));
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Preference_selectable, typedArrayObtainStyledAttributes.getBoolean(R.styleable.Preference_android_selectable, true));
        this.f11089j = z;
        typedArrayObtainStyledAttributes.getBoolean(R.styleable.Preference_persistent, typedArrayObtainStyledAttributes.getBoolean(R.styleable.Preference_android_persistent, true));
        int i12 = R.styleable.Preference_dependency;
        int i13 = R.styleable.Preference_android_dependency;
        if (typedArrayObtainStyledAttributes.getString(i12) == null) {
            typedArrayObtainStyledAttributes.getString(i13);
        }
        int i14 = R.styleable.Preference_allowDividerAbove;
        this.n = typedArrayObtainStyledAttributes.getBoolean(i14, typedArrayObtainStyledAttributes.getBoolean(i14, z));
        int i15 = R.styleable.Preference_allowDividerBelow;
        this.o = typedArrayObtainStyledAttributes.getBoolean(i15, typedArrayObtainStyledAttributes.getBoolean(i15, z));
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.Preference_defaultValue)) {
            this.f11090k = i(typedArrayObtainStyledAttributes, R.styleable.Preference_defaultValue);
        } else if (typedArrayObtainStyledAttributes.hasValue(R.styleable.Preference_android_defaultValue)) {
            this.f11090k = i(typedArrayObtainStyledAttributes, R.styleable.Preference_android_defaultValue);
        }
        this.t = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Preference_shouldDisableView, typedArrayObtainStyledAttributes.getBoolean(R.styleable.Preference_android_shouldDisableView, true));
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R.styleable.Preference_singleLineTitle);
        this.p = zHasValue;
        if (zHasValue) {
            this.q = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Preference_singleLineTitle, typedArrayObtainStyledAttributes.getBoolean(R.styleable.Preference_android_singleLineTitle, true));
        }
        this.r = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Preference_iconSpaceReserved, typedArrayObtainStyledAttributes.getBoolean(R.styleable.Preference_android_iconSpaceReserved, false));
        int i16 = R.styleable.Preference_isPreferenceVisible;
        typedArrayObtainStyledAttributes.getBoolean(i16, typedArrayObtainStyledAttributes.getBoolean(i16, true));
        int i17 = R.styleable.Preference_enableCopying;
        this.s = typedArrayObtainStyledAttributes.getBoolean(i17, typedArrayObtainStyledAttributes.getBoolean(i17, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void p(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                p(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    public long a() {
        return 0L;
    }

    public CharSequence b() {
        SummaryProvider summaryProvider = this.y;
        return summaryProvider != null ? summaryProvider.a(this) : this.f11083d;
    }

    public boolean c() {
        return this.f11088i && this.f11091l && this.f11092m;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Preference preference) {
        Preference preference2 = preference;
        int i2 = this.f11081b;
        int i3 = preference2.f11081b;
        if (i2 != i3) {
            return i2 - i3;
        }
        CharSequence charSequence = this.f11082c;
        CharSequence charSequence2 = preference2.f11082c;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference2.f11082c.toString());
    }

    public void d() {
        if (this.w != null) {
            throw null;
        }
    }

    public void e(boolean z) {
    }

    public void g(PreferenceViewHolder preferenceViewHolder) {
        Integer numValueOf;
        View.OnClickListener onClickListener = this.z;
        View view = preferenceViewHolder.f11653a;
        view.setOnClickListener(onClickListener);
        view.setId(0);
        TextView textView = (TextView) preferenceViewHolder.q(android.R.id.summary);
        if (textView != null) {
            CharSequence charSequenceB = b();
            if (TextUtils.isEmpty(charSequenceB)) {
                textView.setVisibility(8);
                numValueOf = null;
            } else {
                textView.setText(charSequenceB);
                textView.setVisibility(0);
                numValueOf = Integer.valueOf(textView.getCurrentTextColor());
            }
        } else {
            numValueOf = null;
        }
        TextView textView2 = (TextView) preferenceViewHolder.q(android.R.id.title);
        boolean z = this.f11089j;
        if (textView2 != null) {
            CharSequence charSequence = this.f11082c;
            if (TextUtils.isEmpty(charSequence)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(charSequence);
                textView2.setVisibility(0);
                if (this.p) {
                    textView2.setSingleLine(this.q);
                }
                if (!z && c() && numValueOf != null) {
                    textView2.setTextColor(numValueOf.intValue());
                }
            }
        }
        ImageView imageView = (ImageView) preferenceViewHolder.q(android.R.id.icon);
        boolean z2 = this.r;
        if (imageView != null) {
            int i2 = this.f11084e;
            if (i2 != 0 || this.f11085f != null) {
                if (this.f11085f == null) {
                    this.f11085f = AppCompatResources.b(i2, this.f11080a);
                }
                Drawable drawable = this.f11085f;
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
            }
            if (this.f11085f != null) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(z2 ? 4 : 8);
            }
        }
        View viewQ = preferenceViewHolder.q(R.id.icon_frame);
        if (viewQ == null) {
            viewQ = preferenceViewHolder.q(android.R.id.icon_frame);
        }
        if (viewQ != null) {
            if (this.f11085f != null) {
                viewQ.setVisibility(0);
            } else {
                viewQ.setVisibility(z2 ? 4 : 8);
            }
        }
        if (this.t) {
            p(view, c());
        } else {
            p(view, true);
        }
        view.setFocusable(z);
        view.setClickable(z);
        preferenceViewHolder.v = this.n;
        preferenceViewHolder.w = this.o;
        boolean z3 = this.s;
        if (z3 && this.x == null) {
            this.x = new OnPreferenceCopyListener(this);
        }
        view.setOnCreateContextMenuListener(z3 ? this.x : null);
        view.setLongClickable(z3);
        if (!z3 || z) {
            return;
        }
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        view.setBackground(null);
    }

    public void h() {
    }

    public Object i(TypedArray typedArray, int i2) {
        return null;
    }

    public void l(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public void n(View view) {
        if (c() && this.f11089j) {
            h();
        }
    }

    public boolean q() {
        return !c();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequence = this.f11082c;
        if (!TextUtils.isEmpty(charSequence)) {
            sb.append(charSequence);
            sb.append(' ');
        }
        CharSequence charSequenceB = b();
        if (!TextUtils.isEmpty(charSequenceB)) {
            sb.append(charSequenceB);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public Preference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R.attr.preferenceStyle, android.R.attr.preferenceStyle));
    }
}
