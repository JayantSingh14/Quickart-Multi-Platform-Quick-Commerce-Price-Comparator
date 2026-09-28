package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.facebook.react.modules.dialog.AlertFragment;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class AlertController {
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final boolean E;
    public final Handler F;

    /* renamed from: a, reason: collision with root package name */
    public final Context f244a;

    /* renamed from: b, reason: collision with root package name */
    public final AlertDialog f245b;

    /* renamed from: c, reason: collision with root package name */
    public final Window f246c;

    /* renamed from: d, reason: collision with root package name */
    public CharSequence f247d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f248e;

    /* renamed from: f, reason: collision with root package name */
    public RecycleListView f249f;

    /* renamed from: g, reason: collision with root package name */
    public View f250g;

    /* renamed from: i, reason: collision with root package name */
    public Button f252i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f253j;

    /* renamed from: k, reason: collision with root package name */
    public Message f254k;

    /* renamed from: l, reason: collision with root package name */
    public Button f255l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f256m;
    public Message n;
    public Button o;
    public CharSequence p;
    public Message q;
    public NestedScrollView r;
    public Drawable s;
    public ImageView t;
    public TextView u;
    public TextView v;
    public View w;
    public ListAdapter x;
    public final int z;

    /* renamed from: h, reason: collision with root package name */
    public boolean f251h = false;
    public int y = -1;
    public final View.OnClickListener G = new View.OnClickListener() { // from class: androidx.appcompat.app.AlertController.1
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            Message messageObtain = (view != alertController.f252i || (message3 = alertController.f254k) == null) ? (view != alertController.f255l || (message2 = alertController.n) == null) ? (view != alertController.o || (message = alertController.q) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            alertController.F.obtainMessage(1, alertController.f245b).sendToTarget();
        }
    };

    /* renamed from: androidx.appcompat.app.AlertController$2, reason: invalid class name */
    class AnonymousClass2 implements NestedScrollView.OnScrollChangeListener {
        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public final void a(NestedScrollView nestedScrollView) {
            throw null;
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$4, reason: invalid class name */
    class AnonymousClass4 implements AbsListView.OnScrollListener {
        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            throw null;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScrollStateChanged(AbsListView absListView, int i2) {
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$5, reason: invalid class name */
    class AnonymousClass5 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    public static class AlertParams {

        /* renamed from: a, reason: collision with root package name */
        public final ContextThemeWrapper f258a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f259b;

        /* renamed from: c, reason: collision with root package name */
        public Drawable f260c;

        /* renamed from: d, reason: collision with root package name */
        public CharSequence f261d;

        /* renamed from: e, reason: collision with root package name */
        public View f262e;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f263f;

        /* renamed from: g, reason: collision with root package name */
        public CharSequence f264g;

        /* renamed from: h, reason: collision with root package name */
        public DialogInterface.OnClickListener f265h;

        /* renamed from: i, reason: collision with root package name */
        public CharSequence f266i;

        /* renamed from: j, reason: collision with root package name */
        public DialogInterface.OnClickListener f267j;

        /* renamed from: k, reason: collision with root package name */
        public String f268k;

        /* renamed from: l, reason: collision with root package name */
        public AlertFragment f269l;

        /* renamed from: m, reason: collision with root package name */
        public DialogInterface.OnKeyListener f270m;
        public CharSequence[] n;
        public Object o;
        public DialogInterface.OnClickListener p;
        public View q;
        public boolean[] r;
        public boolean s;
        public boolean t;
        public int u = -1;
        public DialogInterface.OnMultiChoiceClickListener v;

        /* renamed from: androidx.appcompat.app.AlertController$AlertParams$2, reason: invalid class name */
        class AnonymousClass2 extends CursorAdapter {
            @Override // android.widget.CursorAdapter
            public final void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(0));
                cursor.getPosition();
                cursor.getInt(0);
                throw null;
            }

            @Override // android.widget.CursorAdapter
            public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                throw null;
            }
        }

        public interface OnPrepareListViewListener {
        }

        public AlertParams(ContextThemeWrapper contextThemeWrapper) {
            this.f258a = contextThemeWrapper;
            this.f259b = (LayoutInflater) contextThemeWrapper.getSystemService("layout_inflater");
        }
    }

    public static final class ButtonHandler extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference f278a;

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == -3 || i2 == -2 || i2 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f278a.get(), message.what);
            } else {
                if (i2 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public final boolean hasStableIds() {
            return true;
        }
    }

    public static class RecycleListView extends ListView {

        /* renamed from: a, reason: collision with root package name */
        public final int f279a;

        /* renamed from: b, reason: collision with root package name */
        public final int f280b;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.RecycleListView);
            this.f280b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f279a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    public AlertController(Context context, AlertDialog alertDialog, Window window) {
        this.f244a = context;
        this.f245b = alertDialog;
        this.f246c = window;
        ButtonHandler buttonHandler = new ButtonHandler();
        buttonHandler.f278a = new WeakReference(alertDialog);
        this.F = buttonHandler;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, androidx.appcompat.R.styleable.AlertDialog, androidx.appcompat.R.attr.alertDialogStyle, 0);
        this.z = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_android_layout, 0);
        typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.A = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_listLayout, 0);
        this.B = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.C = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.D = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_listItemLayout, 0);
        this.E = typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AlertDialog_showTitle, true);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.AlertDialog_buttonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        alertDialog.c().w(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static ViewGroup b(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void c(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Message messageObtainMessage = onClickListener != null ? this.F.obtainMessage(i2, onClickListener) : null;
        if (i2 == -3) {
            this.p = charSequence;
            this.q = messageObtainMessage;
        } else if (i2 == -2) {
            this.f256m = charSequence;
            this.n = messageObtainMessage;
        } else {
            if (i2 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f253j = charSequence;
            this.f254k = messageObtainMessage;
        }
    }
}
