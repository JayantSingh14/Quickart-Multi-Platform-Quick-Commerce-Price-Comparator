package androidx.appcompat.widget;

import android.R;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.k;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {
    public static final PreQAutoCompleteTextViewReflector U0;
    public final Rect A;
    public View.OnClickListener A0;
    public final int[] B;
    public boolean B0;
    public final int[] C;
    public boolean C0;
    public final ImageView D;
    public CursorAdapter D0;
    public final Drawable E;
    public boolean E0;
    public final int F;
    public CharSequence F0;
    public final int G;
    public boolean G0;
    public final Intent H;
    public boolean H0;
    public final Intent I;
    public int I0;
    public final CharSequence J;
    public boolean J0;
    public OnQueryTextListener K;
    public String K0;
    public OnCloseListener L;
    public CharSequence L0;
    public View.OnFocusChangeListener M;
    public boolean M0;
    public int N0;
    public SearchableInfo O0;
    public Bundle P0;
    public OnSuggestionListener Q;
    public final Runnable Q0;
    public final Runnable R0;
    public final WeakHashMap S0;
    public final View.OnClickListener T0;
    public final SearchAutoComplete p;
    public final View q;
    public final View r;
    public final View s;
    public final ImageView t;
    public final ImageView u;
    public final ImageView v;
    public final ImageView w;
    public final View x;
    public UpdatableTouchDelegate y;
    public final Rect z;

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        @DoNotInline
        public static void b(SearchAutoComplete searchAutoComplete, int i2) {
            searchAutoComplete.setInputMethodMode(i2);
        }
    }

    @RequiresApi
    @RestrictTo
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1118a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f1119b;

        /* renamed from: c, reason: collision with root package name */
        public int f1120c;

        /* renamed from: d, reason: collision with root package name */
        public int f1121d;

        /* renamed from: e, reason: collision with root package name */
        public int f1122e;

        public final void mapProperties(PropertyMapper propertyMapper) {
            this.f1119b = propertyMapper.mapInt("imeOptions", R.attr.imeOptions);
            this.f1120c = propertyMapper.mapInt("maxWidth", R.attr.maxWidth);
            this.f1121d = propertyMapper.mapBoolean("iconifiedByDefault", androidx.appcompat.R.attr.iconifiedByDefault);
            this.f1122e = propertyMapper.mapObject("queryHint", androidx.appcompat.R.attr.queryHint);
            this.f1118a = true;
        }

        public final void readProperties(Object obj, PropertyReader propertyReader) {
            SearchView searchView = (SearchView) obj;
            if (!this.f1118a) {
                throw k.e();
            }
            propertyReader.readInt(this.f1119b, searchView.getImeOptions());
            propertyReader.readInt(this.f1120c, searchView.getMaxWidth());
            propertyReader.readBoolean(this.f1121d, searchView.B0);
            propertyReader.readObject(this.f1122e, searchView.getQueryHint());
        }
    }

    public interface OnCloseListener {
        boolean b();
    }

    public interface OnQueryTextListener {
        void onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    public interface OnSuggestionListener {
        boolean a();

        boolean b();
    }

    public static class PreQAutoCompleteTextViewReflector {

        /* renamed from: a, reason: collision with root package name */
        public Method f1123a;

        /* renamed from: b, reason: collision with root package name */
        public Method f1124b;

        /* renamed from: c, reason: collision with root package name */
        public Method f1125c;

        public static void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: c, reason: collision with root package name */
        public boolean f1126c;

        /* renamed from: androidx.appcompat.widget.SearchView$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1126c = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public final String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1126c + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeValue(Boolean.valueOf(this.f1126c));
        }
    }

    @RestrictTo
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* renamed from: e, reason: collision with root package name */
        public int f1127e;

        /* renamed from: f, reason: collision with root package name */
        public SearchView f1128f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f1129g;

        /* renamed from: h, reason: collision with root package name */
        public final Runnable f1130h;

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, androidx.appcompat.R.attr.autoCompleteTextViewStyle);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i2 = configuration.screenWidthDp;
            int i3 = configuration.screenHeightDp;
            if (i2 >= 960 && i3 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i2 < 600) {
                return (i2 < 640 || i3 < 480) ? 160 : 192;
            }
            return 192;
        }

        public final void a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (Build.VERSION.SDK_INT >= 29) {
                Api29Impl.b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            PreQAutoCompleteTextViewReflector preQAutoCompleteTextViewReflector = SearchView.U0;
            preQAutoCompleteTextViewReflector.getClass();
            PreQAutoCompleteTextViewReflector.a();
            Method method = preQAutoCompleteTextViewReflector.f1125c;
            if (method != null) {
                try {
                    method.invoke(this, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final boolean enoughToFilter() {
            return this.f1127e <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f1129g) {
                Runnable runnable = this.f1130h;
                removeCallbacks(runnable);
                post(runnable);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public final void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onFocusChanged(boolean z, int i2, Rect rect) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onFocusChanged(z, i2, rect);
            SearchView searchView = this.f1128f;
            searchView.z(searchView.C0);
            searchView.post(searchView.Q0);
            if (searchView.p.hasFocus()) {
                searchView.n();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
            if (i2 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1128f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i2, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onWindowFocusChanged(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onWindowFocusChanged(z);
            if (z && this.f1128f.hasFocus() && getVisibility() == 0) {
                this.f1129g = true;
                Context context = getContext();
                PreQAutoCompleteTextViewReflector preQAutoCompleteTextViewReflector = SearchView.U0;
                if (context.getResources().getConfiguration().orientation == 2) {
                    a();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public final void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            Runnable runnable = this.f1130h;
            if (!z) {
                this.f1129g = false;
                removeCallbacks(runnable);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f1129g = true;
                    return;
                }
                this.f1129g = false;
                removeCallbacks(runnable);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f1128f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i2) {
            super.setThreshold(i2);
            this.f1127e = i2;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.f1130h = new Runnable() { // from class: androidx.appcompat.widget.SearchView.SearchAutoComplete.1
                @Override // java.lang.Runnable
                public final void run() {
                    SearchAutoComplete searchAutoComplete = SearchAutoComplete.this;
                    if (searchAutoComplete.f1129g) {
                        ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
                        searchAutoComplete.f1129g = false;
                    }
                }
            };
            this.f1127e = getThreshold();
        }
    }

    public static class UpdatableTouchDelegate extends TouchDelegate {

        /* renamed from: a, reason: collision with root package name */
        public final View f1132a;

        /* renamed from: b, reason: collision with root package name */
        public final Rect f1133b;

        /* renamed from: c, reason: collision with root package name */
        public final Rect f1134c;

        /* renamed from: d, reason: collision with root package name */
        public final Rect f1135d;

        /* renamed from: e, reason: collision with root package name */
        public final int f1136e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f1137f;

        public UpdatableTouchDelegate(View view, Rect rect, Rect rect2) {
            super(rect, view);
            int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f1136e = scaledTouchSlop;
            Rect rect3 = new Rect();
            this.f1133b = rect3;
            Rect rect4 = new Rect();
            this.f1135d = rect4;
            Rect rect5 = new Rect();
            this.f1134c = rect5;
            rect3.set(rect);
            rect4.set(rect);
            int i2 = -scaledTouchSlop;
            rect4.inset(i2, i2);
            rect5.set(rect2);
            this.f1132a = view;
        }

        @Override // android.view.TouchDelegate
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            boolean z2;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z3 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z2 = this.f1137f;
                    if (z2 && !this.f1135d.contains(x, y)) {
                        z3 = z2;
                        z = false;
                    }
                } else {
                    if (action == 3) {
                        z2 = this.f1137f;
                        this.f1137f = false;
                    }
                    z = true;
                    z3 = false;
                }
                z3 = z2;
                z = true;
            } else if (this.f1133b.contains(x, y)) {
                this.f1137f = true;
                z = true;
            } else {
                z = true;
                z3 = false;
            }
            if (!z3) {
                return false;
            }
            Rect rect = this.f1134c;
            View view = this.f1132a;
            if (!z || rect.contains(x, y)) {
                motionEvent.setLocation(x - rect.left, y - rect.top);
            } else {
                motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
            }
            return view.dispatchTouchEvent(motionEvent);
        }
    }

    static {
        PreQAutoCompleteTextViewReflector preQAutoCompleteTextViewReflector = null;
        if (Build.VERSION.SDK_INT < 29) {
            PreQAutoCompleteTextViewReflector preQAutoCompleteTextViewReflector2 = new PreQAutoCompleteTextViewReflector();
            preQAutoCompleteTextViewReflector2.f1123a = null;
            preQAutoCompleteTextViewReflector2.f1124b = null;
            preQAutoCompleteTextViewReflector2.f1125c = null;
            PreQAutoCompleteTextViewReflector.a();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                preQAutoCompleteTextViewReflector2.f1123a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                preQAutoCompleteTextViewReflector2.f1124b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                preQAutoCompleteTextViewReflector2.f1125c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
            preQAutoCompleteTextViewReflector = preQAutoCompleteTextViewReflector2;
        }
        U0 = preQAutoCompleteTextViewReflector;
    }

    public SearchView(@NonNull Context context) {
        this(context, null);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(androidx.appcompat.R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(androidx.appcompat.R.dimen.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        SearchAutoComplete searchAutoComplete = this.p;
        searchAutoComplete.setText(charSequence);
        searchAutoComplete.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public final void b() {
        if (this.M0) {
            return;
        }
        this.M0 = true;
        SearchAutoComplete searchAutoComplete = this.p;
        int imeOptions = searchAutoComplete.getImeOptions();
        this.N0 = imeOptions;
        searchAutoComplete.setImeOptions(imeOptions | 33554432);
        searchAutoComplete.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        this.H0 = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.p;
        searchAutoComplete.clearFocus();
        searchAutoComplete.setImeVisibility(false);
        this.H0 = false;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public final void e() {
        t("");
        clearFocus();
        z(true);
        this.p.setImeOptions(this.N0);
        this.M0 = false;
    }

    public int getImeOptions() {
        return this.p.getImeOptions();
    }

    public int getInputType() {
        return this.p.getInputType();
    }

    public int getMaxWidth() {
        return this.I0;
    }

    public CharSequence getQuery() {
        return this.p.getText();
    }

    @Nullable
    public CharSequence getQueryHint() {
        CharSequence charSequence = this.F0;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.O0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.J : getContext().getText(this.O0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.G;
    }

    public int getSuggestionRowLayout() {
        return this.F;
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.D0;
    }

    public final Intent l(String str, Uri uri, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.L0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.P0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.O0.getSearchActivity());
        return intent;
    }

    public final Intent m(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.P0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final void n() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i2 = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.p;
        if (i2 >= 29) {
            Api29Impl.a(searchAutoComplete);
            return;
        }
        PreQAutoCompleteTextViewReflector preQAutoCompleteTextViewReflector = U0;
        preQAutoCompleteTextViewReflector.getClass();
        PreQAutoCompleteTextViewReflector.a();
        Method method = preQAutoCompleteTextViewReflector.f1123a;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, null);
            } catch (Exception unused) {
            }
        }
        preQAutoCompleteTextViewReflector.getClass();
        PreQAutoCompleteTextViewReflector.a();
        Method method2 = preQAutoCompleteTextViewReflector.f1124b;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete, null);
            } catch (Exception unused2) {
            }
        }
    }

    public final void o() {
        SearchAutoComplete searchAutoComplete = this.p;
        if (!TextUtils.isEmpty(searchAutoComplete.getText())) {
            searchAutoComplete.setText("");
            searchAutoComplete.requestFocus();
            searchAutoComplete.setImeVisibility(true);
        } else if (this.B0) {
            OnCloseListener onCloseListener = this.L;
            if (onCloseListener == null || !onCloseListener.b()) {
                clearFocus();
                z(true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.Q0);
        post(this.R0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            int[] iArr = this.B;
            SearchAutoComplete searchAutoComplete = this.p;
            searchAutoComplete.getLocationInWindow(iArr);
            int[] iArr2 = this.C;
            getLocationInWindow(iArr2);
            int i6 = iArr[1] - iArr2[1];
            int i7 = iArr[0] - iArr2[0];
            int width = searchAutoComplete.getWidth() + i7;
            int height = searchAutoComplete.getHeight() + i6;
            Rect rect = this.z;
            rect.set(i7, i6, width, height);
            int i8 = rect.left;
            int i9 = rect.right;
            int i10 = i5 - i3;
            Rect rect2 = this.A;
            rect2.set(i8, 0, i9, i10);
            UpdatableTouchDelegate updatableTouchDelegate = this.y;
            if (updatableTouchDelegate == null) {
                UpdatableTouchDelegate updatableTouchDelegate2 = new UpdatableTouchDelegate(searchAutoComplete, rect2, rect);
                this.y = updatableTouchDelegate2;
                setTouchDelegate(updatableTouchDelegate2);
            } else {
                updatableTouchDelegate.f1133b.set(rect2);
                Rect rect3 = updatableTouchDelegate.f1135d;
                rect3.set(rect2);
                int i11 = -updatableTouchDelegate.f1136e;
                rect3.inset(i11, i11);
                updatableTouchDelegate.f1134c.set(rect);
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i2, int i3) {
        int i4;
        if (this.C0) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            int i5 = this.I0;
            size = i5 > 0 ? Math.min(i5, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.I0;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i4 = this.I0) > 0) {
            size = Math.min(i4, size);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f3321a);
        z(savedState.f1126c);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1126c = this.C0;
        return savedState;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        post(this.Q0);
    }

    public final boolean p(int i2) {
        int position;
        String strL;
        OnSuggestionListener onSuggestionListener = this.Q;
        if (onSuggestionListener != null && onSuggestionListener.b()) {
            return false;
        }
        Cursor cursor = this.D0.f3305c;
        if (cursor != null && cursor.moveToPosition(i2)) {
            Intent intentL = null;
            try {
                int i3 = SuggestionsAdapter.y;
                String strL2 = SuggestionsAdapter.l(cursor, cursor.getColumnIndex("suggest_intent_action"));
                if (strL2 == null) {
                    strL2 = this.O0.getSuggestIntentAction();
                }
                if (strL2 == null) {
                    strL2 = "android.intent.action.SEARCH";
                }
                String strL3 = SuggestionsAdapter.l(cursor, cursor.getColumnIndex("suggest_intent_data"));
                if (strL3 == null) {
                    strL3 = this.O0.getSuggestIntentData();
                }
                if (strL3 != null && (strL = SuggestionsAdapter.l(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) != null) {
                    strL3 = strL3 + "/" + Uri.encode(strL);
                }
                intentL = l(strL2, strL3 == null ? null : Uri.parse(strL3), SuggestionsAdapter.l(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), SuggestionsAdapter.l(cursor, cursor.getColumnIndex("suggest_intent_query")));
            } catch (RuntimeException e2) {
                try {
                    position = cursor.getPosition();
                } catch (RuntimeException unused) {
                    position = -1;
                }
                Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e2);
            }
            if (intentL != null) {
                try {
                    getContext().startActivity(intentL);
                } catch (RuntimeException e3) {
                    Log.e("SearchView", "Failed launch activity: " + intentL, e3);
                }
            }
        }
        SearchAutoComplete searchAutoComplete = this.p;
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
        return true;
    }

    public final void q(int i2) {
        OnSuggestionListener onSuggestionListener = this.Q;
        if (onSuggestionListener == null || !onSuggestionListener.a()) {
            Editable text = this.p.getText();
            Cursor cursor = this.D0.f3305c;
            if (cursor == null) {
                return;
            }
            if (!cursor.moveToPosition(i2)) {
                setQuery(text);
                return;
            }
            String strC = this.D0.c(cursor);
            if (strC != null) {
                setQuery(strC);
            } else {
                setQuery(text);
            }
        }
    }

    public final void r(CharSequence charSequence) {
        setQuery(charSequence);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i2, Rect rect) {
        if (this.H0 || !isFocusable()) {
            return false;
        }
        if (this.C0) {
            return super.requestFocus(i2, rect);
        }
        boolean zRequestFocus = this.p.requestFocus(i2, rect);
        if (zRequestFocus) {
            z(false);
        }
        return zRequestFocus;
    }

    public final void s() {
        SearchAutoComplete searchAutoComplete = this.p;
        Editable text = searchAutoComplete.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        OnQueryTextListener onQueryTextListener = this.K;
        if (onQueryTextListener == null || !onQueryTextListener.onQueryTextSubmit(text.toString())) {
            if (this.O0 != null) {
                getContext().startActivity(l("android.intent.action.SEARCH", null, null, text.toString()));
            }
            searchAutoComplete.setImeVisibility(false);
            searchAutoComplete.dismissDropDown();
        }
    }

    @RestrictTo
    public void setAppSearchData(Bundle bundle) {
        this.P0 = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            o();
            return;
        }
        z(false);
        SearchAutoComplete searchAutoComplete = this.p;
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
        View.OnClickListener onClickListener = this.A0;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.B0 == z) {
            return;
        }
        this.B0 = z;
        z(z);
        w();
    }

    public void setImeOptions(int i2) {
        this.p.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.p.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.I0 = i2;
        requestLayout();
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.L = onCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.M = onFocusChangeListener;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.K = onQueryTextListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.A0 = onClickListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.Q = onSuggestionListener;
    }

    public void setQueryHint(@Nullable CharSequence charSequence) {
        this.F0 = charSequence;
        w();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.G0 = z;
        CursorAdapter cursorAdapter = this.D0;
        if (cursorAdapter instanceof SuggestionsAdapter) {
            ((SuggestionsAdapter) cursorAdapter).q = z ? 2 : 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setSearchableInfo(android.app.SearchableInfo r7) {
        /*
            r6 = this;
            r6.O0 = r7
            r0 = 0
            r1 = 1
            androidx.appcompat.widget.SearchView$SearchAutoComplete r2 = r6.p
            if (r7 == 0) goto L65
            int r7 = r7.getSuggestThreshold()
            r2.setThreshold(r7)
            android.app.SearchableInfo r7 = r6.O0
            int r7 = r7.getImeOptions()
            r2.setImeOptions(r7)
            android.app.SearchableInfo r7 = r6.O0
            int r7 = r7.getInputType()
            r3 = r7 & 15
            if (r3 != r1) goto L31
            r3 = -65537(0xfffffffffffeffff, float:NaN)
            r7 = r7 & r3
            android.app.SearchableInfo r3 = r6.O0
            java.lang.String r3 = r3.getSuggestAuthority()
            if (r3 == 0) goto L31
            r3 = 589824(0x90000, float:8.2652E-40)
            r7 = r7 | r3
        L31:
            r2.setInputType(r7)
            androidx.cursoradapter.widget.CursorAdapter r7 = r6.D0
            if (r7 == 0) goto L3b
            r7.a(r0)
        L3b:
            android.app.SearchableInfo r7 = r6.O0
            java.lang.String r7 = r7.getSuggestAuthority()
            if (r7 == 0) goto L62
            androidx.appcompat.widget.SuggestionsAdapter r7 = new androidx.appcompat.widget.SuggestionsAdapter
            android.content.Context r3 = r6.getContext()
            android.app.SearchableInfo r4 = r6.O0
            java.util.WeakHashMap r5 = r6.S0
            r7.<init>(r3, r6, r4, r5)
            r6.D0 = r7
            r2.setAdapter(r7)
            androidx.cursoradapter.widget.CursorAdapter r7 = r6.D0
            androidx.appcompat.widget.SuggestionsAdapter r7 = (androidx.appcompat.widget.SuggestionsAdapter) r7
            boolean r3 = r6.G0
            if (r3 == 0) goto L5f
            r3 = 2
            goto L60
        L5f:
            r3 = r1
        L60:
            r7.q = r3
        L62:
            r6.w()
        L65:
            android.app.SearchableInfo r7 = r6.O0
            r3 = 0
            if (r7 == 0) goto L98
            boolean r7 = r7.getVoiceSearchEnabled()
            if (r7 == 0) goto L98
            android.app.SearchableInfo r7 = r6.O0
            boolean r7 = r7.getVoiceSearchLaunchWebSearch()
            if (r7 == 0) goto L7b
            android.content.Intent r0 = r6.H
            goto L85
        L7b:
            android.app.SearchableInfo r7 = r6.O0
            boolean r7 = r7.getVoiceSearchLaunchRecognizer()
            if (r7 == 0) goto L85
            android.content.Intent r0 = r6.I
        L85:
            if (r0 == 0) goto L98
            android.content.Context r7 = r6.getContext()
            android.content.pm.PackageManager r7 = r7.getPackageManager()
            r4 = 65536(0x10000, float:9.18355E-41)
            android.content.pm.ResolveInfo r7 = r7.resolveActivity(r0, r4)
            if (r7 == 0) goto L98
            goto L99
        L98:
            r1 = r3
        L99:
            r6.J0 = r1
            if (r1 == 0) goto La2
            java.lang.String r7 = "nm"
            r2.setPrivateImeOptions(r7)
        La2:
            boolean r7 = r6.C0
            r6.z(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.setSearchableInfo(android.app.SearchableInfo):void");
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.E0 = z;
        z(this.C0);
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.D0 = cursorAdapter;
        this.p.setAdapter(cursorAdapter);
    }

    public final void t(String str) {
        SearchAutoComplete searchAutoComplete = this.p;
        searchAutoComplete.setText(str);
        if (str != null) {
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.L0 = str;
        }
    }

    public final void u() {
        boolean zIsEmpty = TextUtils.isEmpty(this.p.getText());
        int i2 = (!zIsEmpty || (this.B0 && !this.M0)) ? 0 : 8;
        ImageView imageView = this.v;
        imageView.setVisibility(i2);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setState(!zIsEmpty ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public final void v() {
        int[] iArr = this.p.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.r.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.s.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final void w() {
        Drawable drawable;
        CharSequence queryHint = getQueryHint();
        if (queryHint == null) {
            queryHint = "";
        }
        boolean z = this.B0;
        SearchAutoComplete searchAutoComplete = this.p;
        if (z && (drawable = this.E) != null) {
            int textSize = (int) (searchAutoComplete.getTextSize() * 1.25d);
            drawable.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
            spannableStringBuilder.append(queryHint);
            queryHint = spannableStringBuilder;
        }
        searchAutoComplete.setHint(queryHint);
    }

    public final void x() {
        this.s.setVisibility(((this.E0 || this.J0) && !this.C0 && (this.u.getVisibility() == 0 || this.w.getVisibility() == 0)) ? 0 : 8);
    }

    public final void y(boolean z) {
        boolean z2 = this.E0;
        this.u.setVisibility((!z2 || !(z2 || this.J0) || this.C0 || !hasFocus() || (!z && this.J0)) ? 8 : 0);
    }

    public final void z(boolean z) {
        this.C0 = z;
        int i2 = 8;
        int i3 = z ? 0 : 8;
        boolean zIsEmpty = TextUtils.isEmpty(this.p.getText());
        this.t.setVisibility(i3);
        y(!zIsEmpty);
        this.q.setVisibility(z ? 8 : 0);
        ImageView imageView = this.D;
        imageView.setVisibility((imageView.getDrawable() == null || this.B0) ? 8 : 0);
        u();
        if (this.J0 && !this.C0 && zIsEmpty) {
            this.u.setVisibility(8);
            i2 = 0;
        }
        this.w.setVisibility(i2);
        x();
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.searchViewStyle);
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.z = new Rect();
        this.A = new Rect();
        this.B = new int[2];
        this.C = new int[2];
        this.Q0 = new Runnable() { // from class: androidx.appcompat.widget.SearchView.1
            @Override // java.lang.Runnable
            public final void run() {
                SearchView.this.v();
            }
        };
        this.R0 = new Runnable() { // from class: androidx.appcompat.widget.SearchView.2
            @Override // java.lang.Runnable
            public final void run() {
                CursorAdapter cursorAdapter = SearchView.this.D0;
                if (cursorAdapter instanceof SuggestionsAdapter) {
                    cursorAdapter.a(null);
                }
            }
        };
        this.S0 = new WeakHashMap();
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: androidx.appcompat.widget.SearchView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                SearchView searchView = SearchView.this;
                ImageView imageView = searchView.t;
                SearchAutoComplete searchAutoComplete = searchView.p;
                if (view == imageView) {
                    searchView.z(false);
                    searchAutoComplete.requestFocus();
                    searchAutoComplete.setImeVisibility(true);
                    View.OnClickListener onClickListener2 = searchView.A0;
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(searchView);
                        return;
                    }
                    return;
                }
                if (view == searchView.v) {
                    searchView.o();
                    return;
                }
                if (view == searchView.u) {
                    searchView.s();
                    return;
                }
                if (view != searchView.w) {
                    if (view == searchAutoComplete) {
                        searchView.n();
                        return;
                    }
                    return;
                }
                SearchableInfo searchableInfo = searchView.O0;
                if (searchableInfo == null) {
                    return;
                }
                try {
                    if (!searchableInfo.getVoiceSearchLaunchWebSearch()) {
                        if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                            searchView.getContext().startActivity(searchView.m(searchView.I, searchableInfo));
                        }
                    } else {
                        Intent intent = new Intent(searchView.H);
                        ComponentName searchActivity = searchableInfo.getSearchActivity();
                        intent.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
                        searchView.getContext().startActivity(intent);
                    }
                } catch (ActivityNotFoundException unused) {
                    Log.w("SearchView", "Could not find voice search activity");
                }
            }
        };
        this.T0 = onClickListener;
        View.OnKeyListener onKeyListener = new View.OnKeyListener() { // from class: androidx.appcompat.widget.SearchView.6
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i3, KeyEvent keyEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                SearchView searchView = SearchView.this;
                if (searchView.O0 != null) {
                    SearchAutoComplete searchAutoComplete = searchView.p;
                    if (!searchAutoComplete.isPopupShowing() || searchAutoComplete.getListSelection() == -1) {
                        if (TextUtils.getTrimmedLength(searchAutoComplete.getText()) != 0 && keyEvent.hasNoModifiers() && keyEvent.getAction() == 1 && i3 == 66) {
                            view.cancelLongPress();
                            searchView.getContext().startActivity(searchView.l("android.intent.action.SEARCH", null, null, searchAutoComplete.getText().toString()));
                            return true;
                        }
                    } else if (searchView.O0 != null && searchView.D0 != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
                        if (i3 == 66 || i3 == 84 || i3 == 61) {
                            return searchView.p(searchAutoComplete.getListSelection());
                        }
                        if (i3 == 21 || i3 == 22) {
                            searchAutoComplete.setSelection(i3 == 21 ? 0 : searchAutoComplete.length());
                            searchAutoComplete.setListSelection(0);
                            searchAutoComplete.clearListSelection();
                            searchAutoComplete.a();
                            return true;
                        }
                        if (i3 == 19) {
                            searchAutoComplete.getListSelection();
                            return false;
                        }
                    }
                }
                return false;
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: androidx.appcompat.widget.SearchView.7
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                SearchView.this.s();
                return true;
            }
        };
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.SearchView.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i3, long j2) {
                SearchView.this.p(i3);
            }
        };
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.SearchView.9
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public final void onItemSelected(AdapterView adapterView, View view, int i3, long j2) {
                SearchView.this.q(i3);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public final void onNothingSelected(AdapterView adapterView) {
            }
        };
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.appcompat.widget.SearchView.10
            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                SearchView searchView = SearchView.this;
                Editable text = searchView.p.getText();
                searchView.L0 = text;
                boolean zIsEmpty = TextUtils.isEmpty(text);
                searchView.y(!zIsEmpty);
                int i6 = 8;
                if (searchView.J0 && !searchView.C0 && zIsEmpty) {
                    searchView.u.setVisibility(8);
                    i6 = 0;
                }
                searchView.w.setVisibility(i6);
                searchView.u();
                searchView.x();
                if (searchView.K != null && !TextUtils.equals(charSequence, searchView.K0)) {
                    searchView.K.onQueryTextChange(charSequence.toString());
                }
                searchView.K0 = charSequence.toString();
            }
        };
        TintTypedArray tintTypedArrayF = TintTypedArray.f(context, attributeSet, androidx.appcompat.R.styleable.SearchView, i2);
        ViewCompat.y(this, context, androidx.appcompat.R.styleable.SearchView, attributeSet, tintTypedArrayF.f1185b, i2, 0);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        int i3 = androidx.appcompat.R.styleable.SearchView_layout;
        int i4 = androidx.appcompat.R.layout.abc_search_view;
        TypedArray typedArray = tintTypedArrayF.f1185b;
        layoutInflaterFrom.inflate(typedArray.getResourceId(i3, i4), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(androidx.appcompat.R.id.search_src_text);
        this.p = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.q = findViewById(androidx.appcompat.R.id.search_edit_frame);
        View viewFindViewById = findViewById(androidx.appcompat.R.id.search_plate);
        this.r = viewFindViewById;
        View viewFindViewById2 = findViewById(androidx.appcompat.R.id.submit_area);
        this.s = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(androidx.appcompat.R.id.search_button);
        this.t = imageView;
        ImageView imageView2 = (ImageView) findViewById(androidx.appcompat.R.id.search_go_btn);
        this.u = imageView2;
        ImageView imageView3 = (ImageView) findViewById(androidx.appcompat.R.id.search_close_btn);
        this.v = imageView3;
        ImageView imageView4 = (ImageView) findViewById(androidx.appcompat.R.id.search_voice_btn);
        this.w = imageView4;
        ImageView imageView5 = (ImageView) findViewById(androidx.appcompat.R.id.search_mag_icon);
        this.D = imageView5;
        viewFindViewById.setBackground(tintTypedArrayF.b(androidx.appcompat.R.styleable.SearchView_queryBackground));
        viewFindViewById2.setBackground(tintTypedArrayF.b(androidx.appcompat.R.styleable.SearchView_submitBackground));
        imageView.setImageDrawable(tintTypedArrayF.b(androidx.appcompat.R.styleable.SearchView_searchIcon));
        imageView2.setImageDrawable(tintTypedArrayF.b(androidx.appcompat.R.styleable.SearchView_goIcon));
        imageView3.setImageDrawable(tintTypedArrayF.b(androidx.appcompat.R.styleable.SearchView_closeIcon));
        imageView4.setImageDrawable(tintTypedArrayF.b(androidx.appcompat.R.styleable.SearchView_voiceIcon));
        imageView5.setImageDrawable(tintTypedArrayF.b(androidx.appcompat.R.styleable.SearchView_searchIcon));
        this.E = tintTypedArrayF.b(androidx.appcompat.R.styleable.SearchView_searchHintIcon);
        TooltipCompat.a(imageView, getResources().getString(androidx.appcompat.R.string.abc_searchview_description_search));
        this.F = typedArray.getResourceId(androidx.appcompat.R.styleable.SearchView_suggestionRowLayout, androidx.appcompat.R.layout.abc_search_dropdown_item_icons_2line);
        this.G = typedArray.getResourceId(androidx.appcompat.R.styleable.SearchView_commitIcon, 0);
        imageView.setOnClickListener(onClickListener);
        imageView3.setOnClickListener(onClickListener);
        imageView2.setOnClickListener(onClickListener);
        imageView4.setOnClickListener(onClickListener);
        searchAutoComplete.setOnClickListener(onClickListener);
        searchAutoComplete.addTextChangedListener(textWatcher);
        searchAutoComplete.setOnEditorActionListener(onEditorActionListener);
        searchAutoComplete.setOnItemClickListener(onItemClickListener);
        searchAutoComplete.setOnItemSelectedListener(onItemSelectedListener);
        searchAutoComplete.setOnKeyListener(onKeyListener);
        searchAutoComplete.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: androidx.appcompat.widget.SearchView.3
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                SearchView searchView = SearchView.this;
                View.OnFocusChangeListener onFocusChangeListener = searchView.M;
                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChange(searchView, z);
                }
            }
        });
        setIconifiedByDefault(typedArray.getBoolean(androidx.appcompat.R.styleable.SearchView_iconifiedByDefault, true));
        int dimensionPixelSize = typedArray.getDimensionPixelSize(androidx.appcompat.R.styleable.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.J = typedArray.getText(androidx.appcompat.R.styleable.SearchView_defaultQueryHint);
        this.F0 = typedArray.getText(androidx.appcompat.R.styleable.SearchView_queryHint);
        int i5 = typedArray.getInt(androidx.appcompat.R.styleable.SearchView_android_imeOptions, -1);
        if (i5 != -1) {
            setImeOptions(i5);
        }
        int i6 = typedArray.getInt(androidx.appcompat.R.styleable.SearchView_android_inputType, -1);
        if (i6 != -1) {
            setInputType(i6);
        }
        setFocusable(typedArray.getBoolean(androidx.appcompat.R.styleable.SearchView_android_focusable, true));
        tintTypedArrayF.g();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.H = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.I = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.x = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.appcompat.widget.SearchView.4
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
                    SearchView searchView = SearchView.this;
                    View view2 = searchView.x;
                    if (view2.getWidth() > 1) {
                        Resources resources = searchView.getContext().getResources();
                        int paddingLeft = searchView.r.getPaddingLeft();
                        Rect rect = new Rect();
                        boolean z = ViewUtils.f1266a;
                        boolean z2 = searchView.getLayoutDirection() == 1;
                        int dimensionPixelSize2 = searchView.B0 ? resources.getDimensionPixelSize(androidx.appcompat.R.dimen.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(androidx.appcompat.R.dimen.abc_dropdownitem_icon_width) : 0;
                        SearchAutoComplete searchAutoComplete2 = searchView.p;
                        searchAutoComplete2.getDropDownBackground().getPadding(rect);
                        searchAutoComplete2.setDropDownHorizontalOffset(z2 ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize2));
                        searchAutoComplete2.setDropDownWidth((((view2.getWidth() + rect.left) + rect.right) + dimensionPixelSize2) - paddingLeft);
                    }
                }
            });
        }
        z(this.B0);
        w();
    }
}
