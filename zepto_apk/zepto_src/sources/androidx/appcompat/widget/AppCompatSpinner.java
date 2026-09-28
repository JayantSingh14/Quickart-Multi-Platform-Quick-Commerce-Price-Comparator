package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.activity.k;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.TintableBackgroundView;
import java.util.Objects;

/* loaded from: classes3.dex */
public class AppCompatSpinner extends Spinner implements TintableBackgroundView {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f909i = {R.attr.spinnerMode};

    /* renamed from: a, reason: collision with root package name */
    public final AppCompatBackgroundHelper f910a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f911b;

    /* renamed from: c, reason: collision with root package name */
    public final ForwardingListener f912c;

    /* renamed from: d, reason: collision with root package name */
    public SpinnerAdapter f913d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f914e;

    /* renamed from: f, reason: collision with root package name */
    public final SpinnerPopup f915f;

    /* renamed from: g, reason: collision with root package name */
    public int f916g;

    /* renamed from: h, reason: collision with root package name */
    public final Rect f917h;

    @RequiresApi
    public static final class Api23Impl {
        @DoNotInline
        public static void a(@NonNull android.widget.ThemedSpinnerAdapter themedSpinnerAdapter, @Nullable Resources.Theme theme) {
            if (Objects.equals(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                return;
            }
            themedSpinnerAdapter.setDropDownViewTheme(theme);
        }
    }

    @VisibleForTesting
    public class DialogPopup implements SpinnerPopup, DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public AlertDialog f921a;

        /* renamed from: b, reason: collision with root package name */
        public ListAdapter f922b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f923c;

        public DialogPopup() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final boolean b() {
            AlertDialog alertDialog = this.f921a;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final int c() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void dismiss() {
            AlertDialog alertDialog = this.f921a;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f921a = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void e(int i2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final CharSequence f() {
            return this.f923c;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final Drawable g() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void h(CharSequence charSequence) {
            this.f923c = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void i(int i2) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void j(int i2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void k(int i2, int i3) {
            if (this.f922b == null) {
                return;
            }
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            AlertDialog.Builder builder = new AlertDialog.Builder(appCompatSpinner.getPopupContext());
            CharSequence charSequence = this.f923c;
            if (charSequence != null) {
                builder.setTitle(charSequence);
            }
            ListAdapter listAdapter = this.f922b;
            int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
            AlertController.AlertParams alertParams = builder.f282a;
            alertParams.o = listAdapter;
            alertParams.p = this;
            alertParams.u = selectedItemPosition;
            alertParams.t = true;
            AlertDialog alertDialogCreate = builder.create();
            this.f921a = alertDialogCreate;
            AlertController.RecycleListView recycleListViewF = alertDialogCreate.f();
            recycleListViewF.setTextDirection(i2);
            recycleListViewF.setTextAlignment(i3);
            this.f921a.show();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final int l() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void n(ListAdapter listAdapter) {
            this.f922b = listAdapter;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            appCompatSpinner.setSelection(i2);
            if (appCompatSpinner.getOnItemClickListener() != null) {
                appCompatSpinner.performItemClick(null, i2, this.f922b.getItemId(i2));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void p(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }
    }

    public static class DropDownAdapter implements ListAdapter, SpinnerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public SpinnerAdapter f925a;

        /* renamed from: b, reason: collision with root package name */
        public ListAdapter f926b;

        @Override // android.widget.ListAdapter
        public final boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f926b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            SpinnerAdapter spinnerAdapter = this.f925a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public final View getDropDownView(int i2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f925a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i2, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i2) {
            SpinnerAdapter spinnerAdapter = this.f925a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i2);
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i2) {
            SpinnerAdapter spinnerAdapter = this.f925a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i2);
        }

        @Override // android.widget.Adapter
        public final int getItemViewType(int i2) {
            return 0;
        }

        @Override // android.widget.Adapter
        public final View getView(int i2, View view, ViewGroup viewGroup) {
            return getDropDownView(i2, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public final int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public final boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f925a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public final boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public final boolean isEnabled(int i2) {
            ListAdapter listAdapter = this.f926b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i2);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f925a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f925a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    @VisibleForTesting
    public class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        public CharSequence C;
        public ListAdapter D;
        public final Rect E;
        public int F;

        public DropdownPopup(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.E = new Rect();
            this.o = AppCompatSpinner.this;
            this.y = true;
            this.z.setFocusable(true);
            this.p = new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i3, long j2) {
                    DropdownPopup dropdownPopup = DropdownPopup.this;
                    AppCompatSpinner.this.setSelection(i3);
                    if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                        AppCompatSpinner.this.performItemClick(view, i3, dropdownPopup.D.getItemId(i3));
                    }
                    dropdownPopup.dismiss();
                }
            };
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final CharSequence f() {
            return this.C;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void h(CharSequence charSequence) {
            this.C = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void j(int i2) {
            this.F = i2;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void k(int i2, int i3) {
            ViewTreeObserver viewTreeObserver;
            PopupWindow popupWindow = this.z;
            boolean zIsShowing = popupWindow.isShowing();
            s();
            this.z.setInputMethodMode(2);
            a();
            DropDownListView dropDownListView = this.f1074c;
            dropDownListView.setChoiceMode(1);
            dropDownListView.setTextDirection(i2);
            dropDownListView.setTextAlignment(i3);
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
            DropDownListView dropDownListView2 = this.f1074c;
            if (popupWindow.isShowing() && dropDownListView2 != null) {
                dropDownListView2.setListSelectionHidden(false);
                dropDownListView2.setSelection(selectedItemPosition);
                if (dropDownListView2.getChoiceMode() != 0) {
                    dropDownListView2.setItemChecked(selectedItemPosition, true);
                }
            }
            if (zIsShowing || (viewTreeObserver = appCompatSpinner.getViewTreeObserver()) == null) {
                return;
            }
            final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    DropdownPopup dropdownPopup = DropdownPopup.this;
                    AppCompatSpinner appCompatSpinner2 = AppCompatSpinner.this;
                    dropdownPopup.getClass();
                    if (!appCompatSpinner2.isAttachedToWindow() || !appCompatSpinner2.getGlobalVisibleRect(dropdownPopup.E)) {
                        dropdownPopup.dismiss();
                    } else {
                        dropdownPopup.s();
                        dropdownPopup.a();
                    }
                }
            };
            viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            this.z.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    ViewTreeObserver viewTreeObserver2 = AppCompatSpinner.this.getViewTreeObserver();
                    if (viewTreeObserver2 != null) {
                        viewTreeObserver2.removeGlobalOnLayoutListener(onGlobalLayoutListener);
                    }
                }
            });
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void n(ListAdapter listAdapter) {
            super.n(listAdapter);
            this.D = listAdapter;
        }

        public final void s() {
            int i2;
            PopupWindow popupWindow = this.z;
            Drawable background = popupWindow.getBackground();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            Rect rect = appCompatSpinner.f917h;
            if (background != null) {
                background.getPadding(rect);
                boolean z = ViewUtils.f1266a;
                i2 = appCompatSpinner.getLayoutDirection() == 1 ? rect.right : -rect.left;
            } else {
                i2 = 0;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = appCompatSpinner.getPaddingLeft();
            int paddingRight = appCompatSpinner.getPaddingRight();
            int width = appCompatSpinner.getWidth();
            int i3 = appCompatSpinner.f916g;
            if (i3 == -2) {
                int iA = appCompatSpinner.a((SpinnerAdapter) this.D, popupWindow.getBackground());
                int i4 = (appCompatSpinner.getContext().getResources().getDisplayMetrics().widthPixels - rect.left) - rect.right;
                if (iA > i4) {
                    iA = i4;
                }
                r(Math.max(iA, (width - paddingLeft) - paddingRight));
            } else if (i3 == -1) {
                r((width - paddingLeft) - paddingRight);
            } else {
                r(i3);
            }
            boolean z2 = ViewUtils.f1266a;
            this.f1077f = appCompatSpinner.getLayoutDirection() == 1 ? (((width - paddingRight) - this.f1076e) - this.F) + i2 : paddingLeft + this.F + i2;
        }
    }

    @RequiresApi
    @RestrictTo
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* renamed from: a, reason: collision with root package name */
        public boolean f931a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f932b;

        /* renamed from: c, reason: collision with root package name */
        public int f933c;

        public final void mapProperties(PropertyMapper propertyMapper) {
            this.f932b = propertyMapper.mapObject("backgroundTint", androidx.appcompat.R.attr.backgroundTint);
            this.f933c = propertyMapper.mapObject("backgroundTintMode", androidx.appcompat.R.attr.backgroundTintMode);
            this.f931a = true;
        }

        public final void readProperties(Object obj, PropertyReader propertyReader) {
            AppCompatSpinner appCompatSpinner = (AppCompatSpinner) obj;
            if (!this.f931a) {
                throw k.e();
            }
            propertyReader.readObject(this.f932b, appCompatSpinner.getBackgroundTintList());
            propertyReader.readObject(this.f933c, appCompatSpinner.getBackgroundTintMode());
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public boolean f934a;

        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                SavedState savedState = new SavedState(parcel);
                savedState.f934a = parcel.readByte() != 0;
                return savedState;
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f934a ? (byte) 1 : (byte) 0);
        }
    }

    @VisibleForTesting
    public interface SpinnerPopup {
        boolean b();

        int c();

        void dismiss();

        void e(int i2);

        CharSequence f();

        Drawable g();

        void h(CharSequence charSequence);

        void i(int i2);

        void j(int i2);

        void k(int i2, int i3);

        int l();

        void n(ListAdapter listAdapter);

        void p(Drawable drawable);
    }

    public AppCompatSpinner(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.spinnerStyle);
    }

    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        Rect rect = this.f917h;
        drawable.getPadding(rect);
        return rect.left + rect.right + iMax2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f910a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        SpinnerPopup spinnerPopup = this.f915f;
        return spinnerPopup != null ? spinnerPopup.c() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        SpinnerPopup spinnerPopup = this.f915f;
        return spinnerPopup != null ? spinnerPopup.l() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f915f != null ? this.f916g : super.getDropDownWidth();
    }

    @VisibleForTesting
    public final SpinnerPopup getInternalPopup() {
        return this.f915f;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        SpinnerPopup spinnerPopup = this.f915f;
        return spinnerPopup != null ? spinnerPopup.g() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f911b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        SpinnerPopup spinnerPopup = this.f915f;
        return spinnerPopup != null ? spinnerPopup.f() : super.getPrompt();
    }

    @Nullable
    @RestrictTo
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f910a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.b();
        }
        return null;
    }

    @Nullable
    @RestrictTo
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f910a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SpinnerPopup spinnerPopup = this.f915f;
        if (spinnerPopup == null || !spinnerPopup.b()) {
            return;
        }
        spinnerPopup.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f915f == null || View.MeasureSpec.getMode(i2) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.f934a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
                if (!appCompatSpinner.getInternalPopup().b()) {
                    appCompatSpinner.f915f.k(appCompatSpinner.getTextDirection(), appCompatSpinner.getTextAlignment());
                }
                ViewTreeObserver viewTreeObserver2 = appCompatSpinner.getViewTreeObserver();
                if (viewTreeObserver2 != null) {
                    viewTreeObserver2.removeOnGlobalLayoutListener(this);
                }
            }
        });
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SpinnerPopup spinnerPopup = this.f915f;
        savedState.f934a = spinnerPopup != null && spinnerPopup.b();
        return savedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener forwardingListener = this.f912c;
        if (forwardingListener == null || !forwardingListener.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        SpinnerPopup spinnerPopup = this.f915f;
        if (spinnerPopup == null) {
            return super.performClick();
        }
        if (spinnerPopup.b()) {
            return true;
        }
        this.f915f.k(getTextDirection(), getTextAlignment());
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f910a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        super.setBackgroundResource(i2);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f910a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i2) {
        SpinnerPopup spinnerPopup = this.f915f;
        if (spinnerPopup == null) {
            super.setDropDownHorizontalOffset(i2);
        } else {
            spinnerPopup.j(i2);
            spinnerPopup.e(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i2) {
        SpinnerPopup spinnerPopup = this.f915f;
        if (spinnerPopup != null) {
            spinnerPopup.i(i2);
        } else {
            super.setDropDownVerticalOffset(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i2) {
        if (this.f915f != null) {
            this.f916g = i2;
        } else {
            super.setDropDownWidth(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        SpinnerPopup spinnerPopup = this.f915f;
        if (spinnerPopup != null) {
            spinnerPopup.p(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(@DrawableRes int i2) {
        setPopupBackgroundDrawable(AppCompatResources.b(i2, getPopupContext()));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        SpinnerPopup spinnerPopup = this.f915f;
        if (spinnerPopup != null) {
            spinnerPopup.h(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @RestrictTo
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f910a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.h(colorStateList);
        }
    }

    @RestrictTo
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f910a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(mode);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AppCompatSpinner(@androidx.annotation.NonNull android.content.Context r10, @androidx.annotation.Nullable android.util.AttributeSet r11, int r12) throws java.lang.Throwable {
        /*
            r9 = this;
            r9.<init>(r10, r11, r12)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r9.f917h = r0
            android.content.Context r0 = r9.getContext()
            androidx.appcompat.widget.ThemeUtils.a(r0, r9)
            int[] r0 = androidx.appcompat.R.styleable.Spinner
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.f(r10, r11, r0, r12)
            androidx.appcompat.widget.AppCompatBackgroundHelper r1 = new androidx.appcompat.widget.AppCompatBackgroundHelper
            r1.<init>(r9)
            r9.f910a = r1
            int r1 = androidx.appcompat.R.styleable.Spinner_popupTheme
            android.content.res.TypedArray r2 = r0.f1185b
            r3 = 0
            int r1 = r2.getResourceId(r1, r3)
            if (r1 == 0) goto L31
            androidx.appcompat.view.ContextThemeWrapper r4 = new androidx.appcompat.view.ContextThemeWrapper
            r4.<init>(r10, r1)
            r9.f911b = r4
            goto L33
        L31:
            r9.f911b = r10
        L33:
            r1 = -1
            r4 = 0
            int[] r5 = androidx.appcompat.widget.AppCompatSpinner.f909i     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            android.content.res.TypedArray r5 = r10.obtainStyledAttributes(r11, r5, r12, r3)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            boolean r6 = r5.hasValue(r3)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L4a
            if (r6 == 0) goto L4c
            int r1 = r5.getInt(r3, r3)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L4a
            goto L4c
        L46:
            r10 = move-exception
            r4 = r5
            goto Ld8
        L4a:
            r3 = move-exception
            goto L55
        L4c:
            r5.recycle()
            goto L5f
        L50:
            r10 = move-exception
            goto Ld8
        L53:
            r3 = move-exception
            r5 = r4
        L55:
            java.lang.String r6 = "AppCompatSpinner"
            java.lang.String r7 = "Could not read android:spinnerMode"
            android.util.Log.i(r6, r7, r3)     // Catch: java.lang.Throwable -> L46
            if (r5 == 0) goto L5f
            goto L4c
        L5f:
            r3 = 1
            if (r1 == 0) goto L9d
            if (r1 == r3) goto L65
            goto Lac
        L65:
            androidx.appcompat.widget.AppCompatSpinner$DropdownPopup r1 = new androidx.appcompat.widget.AppCompatSpinner$DropdownPopup
            android.content.Context r5 = r9.f911b
            r1.<init>(r5, r11, r12)
            android.content.Context r5 = r9.f911b
            int[] r6 = androidx.appcompat.R.styleable.Spinner
            androidx.appcompat.widget.TintTypedArray r5 = androidx.appcompat.widget.TintTypedArray.f(r5, r11, r6, r12)
            int r6 = androidx.appcompat.R.styleable.Spinner_android_dropDownWidth
            android.content.res.TypedArray r7 = r5.f1185b
            r8 = -2
            int r6 = r7.getLayoutDimension(r6, r8)
            r9.f916g = r6
            int r6 = androidx.appcompat.R.styleable.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r6 = r5.b(r6)
            r1.p(r6)
            int r6 = androidx.appcompat.R.styleable.Spinner_android_prompt
            java.lang.String r6 = r2.getString(r6)
            r1.C = r6
            r5.g()
            r9.f915f = r1
            androidx.appcompat.widget.AppCompatSpinner$1 r5 = new androidx.appcompat.widget.AppCompatSpinner$1
            r5.<init>(r9)
            r9.f912c = r5
            goto Lac
        L9d:
            androidx.appcompat.widget.AppCompatSpinner$DialogPopup r1 = new androidx.appcompat.widget.AppCompatSpinner$DialogPopup
            r1.<init>()
            r9.f915f = r1
            int r5 = androidx.appcompat.R.styleable.Spinner_android_prompt
            java.lang.String r5 = r2.getString(r5)
            r1.f923c = r5
        Lac:
            int r1 = androidx.appcompat.R.styleable.Spinner_android_entries
            java.lang.CharSequence[] r1 = r2.getTextArray(r1)
            if (r1 == 0) goto Lc4
            android.widget.ArrayAdapter r2 = new android.widget.ArrayAdapter
            r5 = 17367048(0x1090008, float:2.5162948E-38)
            r2.<init>(r10, r5, r1)
            int r10 = androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            r2.setDropDownViewResource(r10)
            r9.setAdapter(r2)
        Lc4:
            r0.g()
            r9.f914e = r3
            android.widget.SpinnerAdapter r10 = r9.f913d
            if (r10 == 0) goto Ld2
            r9.setAdapter(r10)
            r9.f913d = r4
        Ld2:
            androidx.appcompat.widget.AppCompatBackgroundHelper r10 = r9.f910a
            r10.d(r11, r12)
            return
        Ld8:
            if (r4 == 0) goto Ldd
            r4.recycle()
        Ldd:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f914e) {
            this.f913d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        SpinnerPopup spinnerPopup = this.f915f;
        if (spinnerPopup != null) {
            Context context = this.f911b;
            if (context == null) {
                context = getContext();
            }
            Resources.Theme theme = context.getTheme();
            DropDownAdapter dropDownAdapter = new DropDownAdapter();
            dropDownAdapter.f925a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                dropDownAdapter.f926b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (spinnerAdapter instanceof android.widget.ThemedSpinnerAdapter) {
                    Api23Impl.a((android.widget.ThemedSpinnerAdapter) spinnerAdapter, theme);
                } else if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() == null) {
                        themedSpinnerAdapter.b();
                    }
                }
            }
            spinnerPopup.n(dropDownAdapter);
        }
    }
}
