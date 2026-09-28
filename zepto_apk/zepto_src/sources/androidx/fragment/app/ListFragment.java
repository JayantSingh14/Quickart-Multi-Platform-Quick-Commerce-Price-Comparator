package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class ListFragment extends Fragment {
    public View A0;
    public TextView B0;
    public View C0;
    public View D0;
    public boolean E0;
    public final Handler Q = new Handler();
    public final Runnable X = new Runnable() { // from class: androidx.fragment.app.ListFragment.1
        @Override // java.lang.Runnable
        public final void run() {
            ListView listView = ListFragment.this.Z;
            listView.focusableViewAvailable(listView);
        }
    };
    public final AdapterView.OnItemClickListener Y = new AdapterView.OnItemClickListener() { // from class: androidx.fragment.app.ListFragment.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
            ListFragment.this.getClass();
        }
    };
    public ListView Z;

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context contextRequireContext = requireContext();
        FrameLayout frameLayout = new FrameLayout(contextRequireContext);
        LinearLayout linearLayout = new LinearLayout(contextRequireContext);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(contextRequireContext, null, R.attr.progressBarStyleLarge), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(contextRequireContext);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(contextRequireContext);
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(contextRequireContext);
        listView.setId(R.id.list);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        this.Q.removeCallbacks(this.X);
        this.Z = null;
        this.E0 = false;
        this.D0 = null;
        this.C0 = null;
        this.A0 = null;
        this.B0 = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        y();
    }

    public final void y() {
        if (this.Z != null) {
            return;
        }
        View view = getView();
        if (view == null) {
            throw new IllegalStateException("Content view not yet created");
        }
        if (view instanceof ListView) {
            this.Z = (ListView) view;
        } else {
            TextView textView = (TextView) view.findViewById(16711681);
            this.B0 = textView;
            if (textView == null) {
                this.A0 = view.findViewById(R.id.empty);
            } else {
                textView.setVisibility(8);
            }
            this.C0 = view.findViewById(16711682);
            this.D0 = view.findViewById(16711683);
            View viewFindViewById = view.findViewById(R.id.list);
            if (!(viewFindViewById instanceof ListView)) {
                if (viewFindViewById != null) {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
            }
            ListView listView = (ListView) viewFindViewById;
            this.Z = listView;
            View view2 = this.A0;
            if (view2 != null) {
                listView.setEmptyView(view2);
            }
        }
        this.E0 = true;
        this.Z.setOnItemClickListener(this.Y);
        if (this.C0 != null) {
            y();
            View view3 = this.C0;
            if (view3 == null) {
                throw new IllegalStateException("Can't be used with a custom content view");
            }
            if (this.E0) {
                this.E0 = false;
                view3.clearAnimation();
                this.D0.clearAnimation();
                this.C0.setVisibility(0);
                this.D0.setVisibility(8);
            }
        }
        this.Q.post(this.X);
    }
}
