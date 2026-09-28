package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;

/* loaded from: classes3.dex */
public class AlertDialog extends AppCompatDialog implements DialogInterface {

    /* renamed from: f, reason: collision with root package name */
    public final AlertController f281f;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final AlertController.AlertParams f282a;

        /* renamed from: b, reason: collision with root package name */
        public final int f283b;

        public Builder(Context context) {
            this(context, AlertDialog.g(0, context));
        }

        public Builder a(Drawable drawable) {
            this.f282a.f260c = drawable;
            return this;
        }

        public void b(CharSequence charSequence) {
            this.f282a.f263f = charSequence;
        }

        public Builder c(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f282a;
            alertParams.f266i = charSequence;
            alertParams.f267j = onClickListener;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v17, types: [android.widget.ListAdapter] */
        /* JADX WARN: Type inference failed for: r1v26, types: [androidx.appcompat.app.AlertController$AlertParams$1] */
        @NonNull
        public AlertDialog create() {
            ?? r1;
            final AlertController.AlertParams alertParams = this.f282a;
            AlertDialog alertDialog = new AlertDialog(alertParams.f258a, this.f283b);
            View view = alertParams.f262e;
            final AlertController alertController = alertDialog.f281f;
            if (view != null) {
                alertController.w = view;
            } else {
                CharSequence charSequence = alertParams.f261d;
                if (charSequence != null) {
                    alertController.f247d = charSequence;
                    TextView textView = alertController.u;
                    if (textView != null) {
                        textView.setText(charSequence);
                    }
                }
                Drawable drawable = alertParams.f260c;
                if (drawable != null) {
                    alertController.s = drawable;
                    ImageView imageView = alertController.t;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        alertController.t.setImageDrawable(drawable);
                    }
                }
            }
            CharSequence charSequence2 = alertParams.f263f;
            if (charSequence2 != null) {
                alertController.f248e = charSequence2;
                TextView textView2 = alertController.v;
                if (textView2 != null) {
                    textView2.setText(charSequence2);
                }
            }
            CharSequence charSequence3 = alertParams.f264g;
            if (charSequence3 != null) {
                alertController.c(-1, charSequence3, alertParams.f265h);
            }
            CharSequence charSequence4 = alertParams.f266i;
            if (charSequence4 != null) {
                alertController.c(-2, charSequence4, alertParams.f267j);
            }
            String str = alertParams.f268k;
            if (str != null) {
                alertController.c(-3, str, alertParams.f269l);
            }
            if (alertParams.n != null || alertParams.o != null) {
                final AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) alertParams.f259b.inflate(alertController.A, (ViewGroup) null);
                boolean z = alertParams.s;
                final ContextThemeWrapper contextThemeWrapper = alertParams.f258a;
                if (z) {
                    final CharSequence[] charSequenceArr = alertParams.n;
                    final int i2 = alertController.B;
                    r1 = new ArrayAdapter<CharSequence>(contextThemeWrapper, i2, charSequenceArr) { // from class: androidx.appcompat.app.AlertController.AlertParams.1

                        /* renamed from: a */
                        public final /* synthetic */ RecycleListView f271a;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(final ContextThemeWrapper contextThemeWrapper2, final int i22, final CharSequence[] charSequenceArr2, final RecycleListView recycleListView2) {
                            super(contextThemeWrapper2, i22, R.id.text1, charSequenceArr2);
                            recycleListView = recycleListView2;
                        }

                        @Override // android.widget.ArrayAdapter, android.widget.Adapter
                        public final View getView(int i3, View view2, ViewGroup viewGroup) {
                            View view3 = super.getView(i3, view2, viewGroup);
                            boolean[] zArr = AlertParams.this.r;
                            if (zArr != null && zArr[i3]) {
                                recycleListView.setItemChecked(i3, true);
                            }
                            return view3;
                        }
                    };
                } else {
                    int i3 = alertParams.t ? alertController.C : alertController.D;
                    Object obj = alertParams.o;
                    Object checkedItemAdapter = obj;
                    if (obj == null) {
                        checkedItemAdapter = new AlertController.CheckedItemAdapter(contextThemeWrapper2, i3, R.id.text1, alertParams.n);
                    }
                    r1 = checkedItemAdapter;
                }
                alertController.x = r1;
                alertController.y = alertParams.u;
                if (alertParams.p != null) {
                    recycleListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.AlertParams.3

                        /* renamed from: a */
                        public final /* synthetic */ AlertController f273a;

                        public AnonymousClass3(final AlertController alertController2) {
                            alertController = alertController2;
                        }

                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView adapterView, View view2, int i4, long j2) {
                            AlertParams alertParams2 = AlertParams.this;
                            DialogInterface.OnClickListener onClickListener = alertParams2.p;
                            AlertController alertController2 = alertController;
                            onClickListener.onClick(alertController2.f245b, i4);
                            if (alertParams2.t) {
                                return;
                            }
                            alertController2.f245b.dismiss();
                        }
                    });
                } else if (alertParams.v != null) {
                    recycleListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.AlertParams.4

                        /* renamed from: a */
                        public final /* synthetic */ RecycleListView f275a;

                        /* renamed from: b */
                        public final /* synthetic */ AlertController f276b;

                        public AnonymousClass4(final RecycleListView recycleListView2, final AlertController alertController2) {
                            recycleListView = recycleListView2;
                            alertController = alertController2;
                        }

                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView adapterView, View view2, int i4, long j2) {
                            AlertParams alertParams2 = AlertParams.this;
                            boolean[] zArr = alertParams2.r;
                            RecycleListView recycleListView2 = recycleListView;
                            if (zArr != null) {
                                zArr[i4] = recycleListView2.isItemChecked(i4);
                            }
                            alertParams2.v.onClick(alertController.f245b, i4, recycleListView2.isItemChecked(i4));
                        }
                    });
                }
                if (alertParams.t) {
                    recycleListView2.setChoiceMode(1);
                } else if (alertParams.s) {
                    recycleListView2.setChoiceMode(2);
                }
                alertController2.f249f = recycleListView2;
            }
            View view2 = alertParams.q;
            if (view2 != null) {
                alertController2.f250g = view2;
                alertController2.f251h = false;
            }
            alertDialog.setCancelable(true);
            alertDialog.setCanceledOnTouchOutside(true);
            alertDialog.setOnCancelListener(null);
            alertDialog.setOnDismissListener(null);
            DialogInterface.OnKeyListener onKeyListener = alertParams.f270m;
            if (onKeyListener != null) {
                alertDialog.setOnKeyListener(onKeyListener);
            }
            return alertDialog;
        }

        public Builder d(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f282a;
            alertParams.f264g = charSequence;
            alertParams.f265h = onClickListener;
            return this;
        }

        @NonNull
        public Context getContext() {
            return this.f282a.f258a;
        }

        public Builder setNegativeButton(@StringRes int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f282a;
            alertParams.f266i = alertParams.f258a.getText(i2);
            alertParams.f267j = onClickListener;
            return this;
        }

        public Builder setPositiveButton(@StringRes int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f282a;
            alertParams.f264g = alertParams.f258a.getText(i2);
            alertParams.f265h = onClickListener;
            return this;
        }

        public Builder setTitle(@Nullable CharSequence charSequence) {
            this.f282a.f261d = charSequence;
            return this;
        }

        public Builder setView(View view) {
            this.f282a.q = view;
            return this;
        }

        public Builder(@NonNull Context context, @StyleRes int i2) {
            this.f282a = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.g(i2, context)));
            this.f283b = i2;
        }
    }

    public AlertDialog(ContextThemeWrapper contextThemeWrapper, int i2) {
        super(contextThemeWrapper, g(i2, contextThemeWrapper));
        this.f281f = new AlertController(getContext(), this, getWindow());
    }

    public static int g(int i2, Context context) {
        if (((i2 >>> 24) & 255) >= 1) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public final AlertController.RecycleListView f() {
        return this.f281f.f249f;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        int i2;
        ListAdapter listAdapter;
        View viewFindViewById;
        super.onCreate(bundle);
        AlertController alertController = this.f281f;
        alertController.f245b.setContentView(alertController.z);
        int i3 = androidx.appcompat.R.id.parentPanel;
        Window window = alertController.f246c;
        View viewFindViewById2 = window.findViewById(i3);
        View viewFindViewById3 = viewFindViewById2.findViewById(androidx.appcompat.R.id.topPanel);
        View viewFindViewById4 = viewFindViewById2.findViewById(androidx.appcompat.R.id.contentPanel);
        View viewFindViewById5 = viewFindViewById2.findViewById(androidx.appcompat.R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById2.findViewById(androidx.appcompat.R.id.customPanel);
        View view = alertController.f250g;
        if (view == null) {
            view = null;
        }
        boolean z = view != null;
        if (!z || !AlertController.a(view)) {
            window.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) window.findViewById(androidx.appcompat.R.id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (alertController.f251h) {
                frameLayout.setPadding(0, 0, 0, 0);
            }
            if (alertController.f249f != null) {
                ((LinearLayout.LayoutParams) ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View viewFindViewById6 = viewGroup.findViewById(androidx.appcompat.R.id.topPanel);
        View viewFindViewById7 = viewGroup.findViewById(androidx.appcompat.R.id.contentPanel);
        View viewFindViewById8 = viewGroup.findViewById(androidx.appcompat.R.id.buttonPanel);
        ViewGroup viewGroupB = AlertController.b(viewFindViewById6, viewFindViewById3);
        ViewGroup viewGroupB2 = AlertController.b(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupB3 = AlertController.b(viewFindViewById8, viewFindViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(androidx.appcompat.R.id.scrollView);
        alertController.r = nestedScrollView;
        nestedScrollView.setFocusable(false);
        alertController.r.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroupB2.findViewById(R.id.message);
        alertController.v = textView;
        if (textView != null) {
            CharSequence charSequence = alertController.f248e;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                alertController.r.removeView(alertController.v);
                if (alertController.f249f != null) {
                    ViewGroup viewGroup2 = (ViewGroup) alertController.r.getParent();
                    int iIndexOfChild = viewGroup2.indexOfChild(alertController.r);
                    viewGroup2.removeViewAt(iIndexOfChild);
                    viewGroup2.addView(alertController.f249f, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    viewGroupB2.setVisibility(8);
                }
            }
        }
        Button button = (Button) viewGroupB3.findViewById(R.id.button1);
        alertController.f252i = button;
        View.OnClickListener onClickListener = alertController.G;
        button.setOnClickListener(onClickListener);
        if (TextUtils.isEmpty(alertController.f253j)) {
            alertController.f252i.setVisibility(8);
            i2 = 0;
        } else {
            alertController.f252i.setText(alertController.f253j);
            alertController.f252i.setVisibility(0);
            i2 = 1;
        }
        Button button2 = (Button) viewGroupB3.findViewById(R.id.button2);
        alertController.f255l = button2;
        button2.setOnClickListener(onClickListener);
        if (TextUtils.isEmpty(alertController.f256m)) {
            alertController.f255l.setVisibility(8);
        } else {
            alertController.f255l.setText(alertController.f256m);
            alertController.f255l.setVisibility(0);
            i2 |= 2;
        }
        Button button3 = (Button) viewGroupB3.findViewById(R.id.button3);
        alertController.o = button3;
        button3.setOnClickListener(onClickListener);
        if (TextUtils.isEmpty(alertController.p)) {
            alertController.o.setVisibility(8);
        } else {
            alertController.o.setText(alertController.p);
            alertController.o.setVisibility(0);
            i2 |= 4;
        }
        TypedValue typedValue = new TypedValue();
        alertController.f244a.getTheme().resolveAttribute(androidx.appcompat.R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (i2 == 1) {
                Button button4 = alertController.f252i;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button4.getLayoutParams();
                layoutParams.gravity = 1;
                layoutParams.weight = 0.5f;
                button4.setLayoutParams(layoutParams);
            } else if (i2 == 2) {
                Button button5 = alertController.f255l;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button5.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button5.setLayoutParams(layoutParams2);
            } else if (i2 == 4) {
                Button button6 = alertController.o;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button6.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button6.setLayoutParams(layoutParams3);
            }
        }
        if (i2 == 0) {
            viewGroupB3.setVisibility(8);
        }
        if (alertController.w != null) {
            viewGroupB.addView(alertController.w, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(androidx.appcompat.R.id.title_template).setVisibility(8);
        } else {
            alertController.t = (ImageView) window.findViewById(R.id.icon);
            if (TextUtils.isEmpty(alertController.f247d) || !alertController.E) {
                window.findViewById(androidx.appcompat.R.id.title_template).setVisibility(8);
                alertController.t.setVisibility(8);
                viewGroupB.setVisibility(8);
            } else {
                TextView textView2 = (TextView) window.findViewById(androidx.appcompat.R.id.alertTitle);
                alertController.u = textView2;
                textView2.setText(alertController.f247d);
                Drawable drawable = alertController.s;
                if (drawable != null) {
                    alertController.t.setImageDrawable(drawable);
                } else {
                    alertController.u.setPadding(alertController.t.getPaddingLeft(), alertController.t.getPaddingTop(), alertController.t.getPaddingRight(), alertController.t.getPaddingBottom());
                    alertController.t.setVisibility(8);
                }
            }
        }
        boolean z2 = viewGroup.getVisibility() != 8;
        int i4 = (viewGroupB == null || viewGroupB.getVisibility() == 8) ? 0 : 1;
        boolean z3 = viewGroupB3.getVisibility() != 8;
        if (!z3 && (viewFindViewById = viewGroupB2.findViewById(androidx.appcompat.R.id.textSpacerNoButtons)) != null) {
            viewFindViewById.setVisibility(0);
        }
        if (i4 != 0) {
            NestedScrollView nestedScrollView2 = alertController.r;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View viewFindViewById9 = (alertController.f248e == null && alertController.f249f == null) ? null : viewGroupB.findViewById(androidx.appcompat.R.id.titleDividerNoCustom);
            if (viewFindViewById9 != null) {
                viewFindViewById9.setVisibility(0);
            }
        } else {
            View viewFindViewById10 = viewGroupB2.findViewById(androidx.appcompat.R.id.textSpacerNoTitle);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        }
        AlertController.RecycleListView recycleListView = alertController.f249f;
        if (recycleListView != null && (!z3 || i4 == 0)) {
            recycleListView.setPadding(recycleListView.getPaddingLeft(), i4 != 0 ? recycleListView.getPaddingTop() : recycleListView.f279a, recycleListView.getPaddingRight(), z3 ? recycleListView.getPaddingBottom() : recycleListView.f280b);
        }
        if (!z2) {
            ViewGroup viewGroup3 = alertController.f249f;
            if (viewGroup3 == null) {
                viewGroup3 = alertController.r;
            }
            if (viewGroup3 != null) {
                int i5 = z3 ? 2 : 0;
                View viewFindViewById11 = window.findViewById(androidx.appcompat.R.id.scrollIndicatorUp);
                View viewFindViewById12 = window.findViewById(androidx.appcompat.R.id.scrollIndicatorDown);
                ViewCompat.K(viewGroup3, i4 | i5);
                if (viewFindViewById11 != null) {
                    viewGroupB2.removeView(viewFindViewById11);
                }
                if (viewFindViewById12 != null) {
                    viewGroupB2.removeView(viewFindViewById12);
                }
            }
        }
        AlertController.RecycleListView recycleListView2 = alertController.f249f;
        if (recycleListView2 == null || (listAdapter = alertController.x) == null) {
            return;
        }
        recycleListView2.setAdapter(listAdapter);
        int i6 = alertController.y;
        if (i6 > -1) {
            recycleListView2.setItemChecked(i6, true);
            recycleListView2.setSelection(i6);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f281f.r;
        if (nestedScrollView == null || !nestedScrollView.c(keyEvent)) {
            return super.onKeyDown(i2, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f281f.r;
        if (nestedScrollView == null || !nestedScrollView.c(keyEvent)) {
            return super.onKeyUp(i2, keyEvent);
        }
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        AlertController alertController = this.f281f;
        alertController.f247d = charSequence;
        TextView textView = alertController.u;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
