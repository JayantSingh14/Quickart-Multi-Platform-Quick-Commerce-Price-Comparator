package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;

@RestrictTo
/* loaded from: classes3.dex */
public class ListMenuItemView extends LinearLayout implements MenuView.ItemView, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a, reason: collision with root package name */
    public MenuItemImpl f575a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f576b;

    /* renamed from: c, reason: collision with root package name */
    public RadioButton f577c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f578d;

    /* renamed from: e, reason: collision with root package name */
    public CheckBox f579e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f580f;

    /* renamed from: g, reason: collision with root package name */
    public ImageView f581g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f582h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f583i;

    /* renamed from: j, reason: collision with root package name */
    public final Drawable f584j;

    /* renamed from: k, reason: collision with root package name */
    public final int f585k;

    /* renamed from: l, reason: collision with root package name */
    public final Context f586l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f587m;
    public final Drawable n;
    public final boolean o;
    public LayoutInflater p;
    public boolean q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listMenuViewStyle);
    }

    private LayoutInflater getInflater() {
        if (this.p == null) {
            this.p = LayoutInflater.from(getContext());
        }
        return this.p;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.f581g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f582h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f582h.getLayoutParams();
        rect.top = this.f582h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005e  */
    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(androidx.appcompat.view.menu.MenuItemImpl r11) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.c(androidx.appcompat.view.menu.MenuItemImpl):void");
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.f575a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.f584j);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f578d = textView;
        int i2 = this.f585k;
        if (i2 != -1) {
            textView.setTextAppearance(this.f586l, i2);
        }
        this.f580f = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f581g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.n);
        }
        this.f582h = (ImageView) findViewById(R.id.group_divider);
        this.f583i = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        if (this.f576b != null && this.f587m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f576b.getLayoutParams();
            int i4 = layoutParams.height;
            if (i4 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i4;
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        View view;
        if (!z && this.f577c == null && this.f579e == null) {
            return;
        }
        if ((this.f575a.x & 4) != 0) {
            if (this.f577c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f577c = radioButton;
                LinearLayout linearLayout = this.f583i;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f577c;
            view = this.f579e;
        } else {
            if (this.f579e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f579e = checkBox;
                LinearLayout linearLayout2 = this.f583i;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f579e;
            view = this.f577c;
        }
        if (z) {
            compoundButton.setChecked(this.f575a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.f579e;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.f577c;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if ((this.f575a.x & 4) != 0) {
            if (this.f577c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f577c = radioButton;
                LinearLayout linearLayout = this.f583i;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f577c;
        } else {
            if (this.f579e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f579e = checkBox;
                LinearLayout linearLayout2 = this.f583i;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f579e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.q = z;
        this.f587m = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.f582h;
        if (imageView != null) {
            imageView.setVisibility((this.o || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        this.f575a.n.getClass();
        boolean z = this.q;
        if (z || this.f587m) {
            ImageView imageView = this.f576b;
            if (imageView == null && drawable == null && !this.f587m) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.f576b = imageView2;
                LinearLayout linearLayout = this.f583i;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.f587m) {
                this.f576b.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f576b;
            if (!z) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f576b.getVisibility() != 0) {
                this.f576b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f578d.getVisibility() != 8) {
                this.f578d.setVisibility(8);
            }
        } else {
            this.f578d.setText(charSequence);
            if (this.f578d.getVisibility() != 0) {
                this.f578d.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        TintTypedArray tintTypedArrayF = TintTypedArray.f(getContext(), attributeSet, R.styleable.MenuView, i2);
        this.f584j = tintTypedArrayF.b(R.styleable.MenuView_android_itemBackground);
        int i3 = R.styleable.MenuView_android_itemTextAppearance;
        TypedArray typedArray = tintTypedArrayF.f1185b;
        this.f585k = typedArray.getResourceId(i3, -1);
        this.f587m = typedArray.getBoolean(R.styleable.MenuView_preserveIconSpacing, false);
        this.f586l = context;
        this.n = tintTypedArrayF.b(R.styleable.MenuView_subMenuArrow);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.o = typedArrayObtainStyledAttributes.hasValue(0);
        tintTypedArrayF.g();
        typedArrayObtainStyledAttributes.recycle();
    }
}
