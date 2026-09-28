package com.facebook.react.devsupport;

import android.net.Uri;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import coil3.util.UtilsKt;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.StackFrame;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class RedBoxContentView extends LinearLayout implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public RedBoxHandler f18868a;

    /* renamed from: b, reason: collision with root package name */
    public DevSupportManager f18869b;

    /* renamed from: c, reason: collision with root package name */
    public ListView f18870c;

    /* renamed from: d, reason: collision with root package name */
    public Button f18871d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f18872e;

    /* renamed from: f, reason: collision with root package name */
    public ProgressBar f18873f;

    /* renamed from: g, reason: collision with root package name */
    public View f18874g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f18875h;

    /* renamed from: i, reason: collision with root package name */
    public RedBoxHandler.ReportCompletedListener f18876i;

    /* renamed from: j, reason: collision with root package name */
    public View.OnClickListener f18877j;

    /* renamed from: com.facebook.react.devsupport.RedBoxContentView$1, reason: invalid class name */
    public class AnonymousClass1 implements RedBoxHandler.ReportCompletedListener {
    }

    public static class OpenStackFrameTask extends AsyncTask<StackFrame, Void, Void> {

        /* renamed from: b, reason: collision with root package name */
        public static final MediaType f18881b;

        /* renamed from: a, reason: collision with root package name */
        public final DevSupportManager f18882a;

        static {
            Pattern pattern = MediaType.f56278d;
            f18881b = MediaType.Companion.b("application/json; charset=utf-8");
        }

        public OpenStackFrameTask(DevSupportManager devSupportManager) {
            this.f18882a = devSupportManager;
        }

        @Override // android.os.AsyncTask
        public final Void doInBackground(StackFrame[] stackFrameArr) {
            StackFrame[] stackFrameArr2 = stackFrameArr;
            try {
                String string = Uri.parse(this.f18882a.m()).buildUpon().path("/open-stack-frame").query(null).build().toString();
                OkHttpClient okHttpClient = new OkHttpClient();
                for (StackFrame stackFrame : stackFrameArr2) {
                    RequestBody body = RequestBody.create(f18881b, new JSONObject(MapBuilder.b(UtilsKt.SCHEME_FILE, stackFrame.getFile(), "methodName", stackFrame.l(), "lineNumber", Integer.valueOf(stackFrame.m()), "column", Integer.valueOf(stackFrame.getColumn()))).toString());
                    Request.Builder builder = new Request.Builder();
                    builder.i(string);
                    Intrinsics.checkNotNullParameter(body, "body");
                    builder.f("POST", body);
                    okHttpClient.a(builder.b()).d();
                }
            } catch (Exception e2) {
                FLog.h("ReactNative", "Could not open stack frame", e2);
            }
            return null;
        }
    }

    public static class StackAdapter extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final String f18883a;

        /* renamed from: b, reason: collision with root package name */
        public final StackFrame[] f18884b;

        public static class FrameViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public final TextView f18885a;

            /* renamed from: b, reason: collision with root package name */
            public final TextView f18886b;

            public FrameViewHolder(View view) {
                this.f18885a = (TextView) view.findViewById(R.id.rn_frame_method);
                this.f18886b = (TextView) view.findViewById(R.id.rn_frame_file);
            }
        }

        public StackAdapter(String str, StackFrame[] stackFrameArr) {
            this.f18883a = str;
            this.f18884b = stackFrameArr;
            Assertions.c(str);
            Assertions.c(stackFrameArr);
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public final boolean areAllItemsEnabled() {
            return false;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            return this.f18884b.length + 1;
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i2) {
            if (i2 == 0) {
                return this.f18883a;
            }
            return this.f18884b[i2 - 1];
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public final int getItemViewType(int i2) {
            return i2 == 0 ? 0 : 1;
        }

        @Override // android.widget.Adapter
        public final View getView(int i2, View view, ViewGroup viewGroup) {
            if (i2 == 0) {
                TextView textView = view != null ? (TextView) view : (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.redbox_item_title, viewGroup, false);
                String str = this.f18883a;
                if (str == null) {
                    str = "<unknown title>";
                }
                textView.setText(str.replaceAll("\\x1b\\[[0-9;]*m", ""));
                return textView;
            }
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.redbox_item_frame, viewGroup, false);
                view.setTag(new FrameViewHolder(view));
            }
            StackFrame stackFrame = this.f18884b[i2 - 1];
            FrameViewHolder frameViewHolder = (FrameViewHolder) view.getTag();
            frameViewHolder.f18885a.setText(stackFrame.l());
            int i3 = StackTraceHelper.f18896a;
            StringBuilder sb = new StringBuilder();
            sb.append(stackFrame.n());
            int iM = stackFrame.m();
            if (iM > 0) {
                sb.append(":");
                sb.append(iM);
                int column = stackFrame.getColumn();
                if (column > 0) {
                    sb.append(":");
                    sb.append(column);
                }
            }
            String string = sb.toString();
            TextView textView2 = frameViewHolder.f18886b;
            textView2.setText(string);
            frameViewHolder.f18885a.setTextColor(-1);
            textView2.setTextColor(-5000269);
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public final int getViewTypeCount() {
            return 2;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public final boolean isEnabled(int i2) {
            return i2 > 0;
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        DevSupportManager devSupportManager = this.f18869b;
        Assertions.c(devSupportManager);
        new OpenStackFrameTask(devSupportManager).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (StackFrame) this.f18870c.getAdapter().getItem(i2));
    }
}
