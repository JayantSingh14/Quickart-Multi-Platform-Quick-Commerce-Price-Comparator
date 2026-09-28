package in.juspay.hypersdk.mystique;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import in.juspay.hypersdk.core.DuiCallback;
import in.juspay.hypersdk.core.Renderer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class ListAdapter extends BaseAdapter {
    private Context context;
    private float density;
    private final DuiCallback duiCallback;
    private JSONArray holderData;
    private JSONObject itemView;
    private Renderer renderer;
    private JSONArray rowData;
    private BitmapCache bitmapCache = BitmapCache.getInstance();
    private LruCache<String, Integer> colorCache = new LruCache<>(20);
    private LruCache<String, Drawable> drawableCache = new LruCache<>(50);
    private LruCache<String, Typeface> typefaceCache = new LruCache<>(20);
    private LruCache<String, Integer> typefaceWeightCache = new LruCache<>(20);

    public class Holder {
        View[] views;

        public Holder(View view) throws JSONException {
            this.views = new View[ListAdapter.this.holderData.length()];
            for (int i2 = 0; i2 < ListAdapter.this.holderData.length(); i2++) {
                try {
                    this.views[i2] = view.findViewById(ListAdapter.this.holderData.getJSONObject(i2).getInt(CLConstants.SHARED_PREFERENCE_ITEM_ID));
                } catch (JSONException unused) {
                }
            }
        }
    }

    public ListAdapter(Context context, Renderer renderer, JSONObject jSONObject, JSONArray jSONArray, JSONArray jSONArray2, DuiCallback duiCallback) {
        this.renderer = renderer;
        this.rowData = jSONArray2;
        this.itemView = jSONObject;
        this.holderData = jSONArray;
        this.duiCallback = duiCallback;
        this.context = context;
        this.density = context.getResources().getDisplayMetrics().density;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void applyUpdate(android.view.View r8, org.json.JSONObject r9, org.json.JSONObject r10, int r11) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.mystique.ListAdapter.applyUpdate(android.view.View, org.json.JSONObject, org.json.JSONObject, int):void");
    }

    private View createView() {
        try {
            return this.renderer.createView(this.itemView);
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONArray getArray(JSONObject jSONObject, String str, JSONArray jSONArray) {
        try {
            return jSONObject.getJSONArray(str);
        } catch (Exception unused) {
            return jSONArray;
        }
    }

    private float[] getCorners(String[] strArr) throws NumberFormatException {
        float[] fArr = new float[8];
        int i2 = 0;
        float f2 = Float.parseFloat(strArr[0]);
        for (int i3 = 1; i3 < strArr.length; i3++) {
            if (Boolean.parseBoolean(strArr[i3])) {
                int i4 = i2 + 1;
                fArr[i2] = f2;
                i2 += 2;
                fArr[i4] = f2;
            } else {
                i2 += 2;
            }
        }
        return fArr;
    }

    private String getDefault(String str, String str2) {
        if (str.equals("onClick")) {
            return str2;
        }
        return null;
    }

    private String getString(JSONObject jSONObject, String str, String str2) {
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return str2;
        }
    }

    private void setAlpha(View view, String str) {
        view.setAlpha(Float.parseFloat(str));
    }

    private void setBackground(View view, String str) {
        if (str == null) {
            if (view.getBackground() instanceof GradientDrawable) {
                ((GradientDrawable) view.getBackground()).setColor(0);
            } else {
                view.setBackgroundDrawable(null);
            }
            view.setBackgroundDrawable(null);
            return;
        }
        Integer numValueOf = this.colorCache.get(str);
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(Color.parseColor(str));
            this.colorCache.put(str, numValueOf);
        }
        Drawable background = view.getBackground();
        if (background == null || ((background instanceof ColorDrawable) && ((ColorDrawable) background).getColor() != numValueOf.intValue())) {
            view.setBackgroundColor(numValueOf.intValue());
        } else if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(numValueOf.intValue());
        }
    }

    private void setClickListener(View view, final String str, final int i2) {
        view.setOnClickListener(new View.OnClickListener() { // from class: in.juspay.hypersdk.mystique.ListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ListAdapter.this.duiCallback.addJsToWebView("window.callUICallback('" + str + "'," + i2 + ");");
            }
        });
    }

    private void setCornerRadius(View view, String str) {
        GradientDrawable gradientDrawable;
        if (str != null) {
            String[] strArrSplit = str.split(",");
            float[] corners = new float[8];
            if (strArrSplit.length > 0) {
                try {
                    if (strArrSplit.length == 1) {
                        corners[0] = Float.parseFloat(strArrSplit[0]);
                    } else {
                        corners = getCorners(strArrSplit);
                    }
                    Drawable background = view.getBackground();
                    if (background instanceof ColorDrawable) {
                        gradientDrawable = new GradientDrawable();
                        gradientDrawable.setColor(((ColorDrawable) background).getColor());
                        view.setBackground(gradientDrawable);
                    } else {
                        gradientDrawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
                    }
                    if (gradientDrawable != null) {
                        if (strArrSplit.length == 1) {
                            gradientDrawable.setCornerRadius(corners[0]);
                        } else {
                            gradientDrawable.setCornerRadii(corners);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010f A[Catch: Exception -> 0x0036, TryCatch #0 {Exception -> 0x0036, blocks: (B:5:0x000e, B:7:0x0026, B:10:0x002e, B:14:0x0039, B:17:0x003f, B:19:0x0047, B:21:0x0053, B:82:0x0189, B:84:0x0190, B:86:0x019d, B:43:0x0097, B:64:0x00d2, B:65:0x00de, B:66:0x00e8, B:50:0x00ab, B:53:0x00b5, B:56:0x00bf, B:67:0x00f1, B:69:0x00f9, B:70:0x0104, B:71:0x010f, B:73:0x0115, B:74:0x0126, B:76:0x012e, B:78:0x0156, B:80:0x0162, B:28:0x006e, B:31:0x0078, B:34:0x0082, B:81:0x016d), top: B:90:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0190 A[Catch: Exception -> 0x0036, TryCatch #0 {Exception -> 0x0036, blocks: (B:5:0x000e, B:7:0x0026, B:10:0x002e, B:14:0x0039, B:17:0x003f, B:19:0x0047, B:21:0x0053, B:82:0x0189, B:84:0x0190, B:86:0x019d, B:43:0x0097, B:64:0x00d2, B:65:0x00de, B:66:0x00e8, B:50:0x00ab, B:53:0x00b5, B:56:0x00bf, B:67:0x00f1, B:69:0x00f9, B:70:0x0104, B:71:0x010f, B:73:0x0115, B:74:0x0126, B:76:0x012e, B:78:0x0156, B:80:0x0162, B:28:0x006e, B:31:0x0078, B:34:0x0082, B:81:0x016d), top: B:90:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x019d A[Catch: Exception -> 0x0036, TRY_LEAVE, TryCatch #0 {Exception -> 0x0036, blocks: (B:5:0x000e, B:7:0x0026, B:10:0x002e, B:14:0x0039, B:17:0x003f, B:19:0x0047, B:21:0x0053, B:82:0x0189, B:84:0x0190, B:86:0x019d, B:43:0x0097, B:64:0x00d2, B:65:0x00de, B:66:0x00e8, B:50:0x00ab, B:53:0x00b5, B:56:0x00bf, B:67:0x00f1, B:69:0x00f9, B:70:0x0104, B:71:0x010f, B:73:0x0115, B:74:0x0126, B:76:0x012e, B:78:0x0156, B:80:0x0162, B:28:0x006e, B:31:0x0078, B:34:0x0082, B:81:0x016d), top: B:90:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setFontStyle(android.view.View r13, java.lang.String r14) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 431
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.mystique.ListAdapter.setFontStyle(android.view.View, java.lang.String):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0117 A[Catch: Exception -> 0x01c3, TryCatch #3 {Exception -> 0x01c3, blocks: (B:74:0x01b4, B:76:0x01bd, B:51:0x00e9, B:52:0x00f5, B:54:0x0103, B:55:0x0117, B:57:0x0120, B:63:0x0148, B:64:0x0155, B:66:0x015f, B:68:0x0177, B:70:0x018c, B:72:0x01a7, B:69:0x0182), top: B:87:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b4 A[Catch: Exception -> 0x01c3, TryCatch #3 {Exception -> 0x01c3, blocks: (B:74:0x01b4, B:76:0x01bd, B:51:0x00e9, B:52:0x00f5, B:54:0x0103, B:55:0x0117, B:57:0x0120, B:63:0x0148, B:64:0x0155, B:66:0x015f, B:68:0x0177, B:70:0x018c, B:72:0x01a7, B:69:0x0182), top: B:87:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v13, types: [in.juspay.hypersdk.mystique.ListAdapter] */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setImage(android.view.View r14, java.lang.String r15) throws android.content.res.Resources.NotFoundException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 463
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.mystique.ListAdapter.setImage(android.view.View, java.lang.String):void");
    }

    private void setPackageIcon(View view, String str) {
        PackageManager packageManager = this.context.getPackageManager();
        ((ImageView) view).setImageDrawable(packageManager.getApplicationInfo(str, 0).loadIcon(packageManager));
    }

    private void setText(View view, String str) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (textView.getText().equals(str)) {
                return;
            }
            textView.setText(str);
        }
    }

    private void setTextColor(View view, String str) {
        if (view instanceof TextView) {
            if (str == null) {
                ((TextView) view).setTextColor(-16777216);
                return;
            }
            Integer numValueOf = this.colorCache.get(str);
            if (numValueOf == null) {
                numValueOf = Integer.valueOf(Color.parseColor(str));
                this.colorCache.put(str, numValueOf);
            }
            ((TextView) view).setTextColor(numValueOf.intValue());
        }
    }

    private void setTextSize(View view, String str) {
        if (view instanceof TextView) {
            float f2 = Integer.parseInt(str) * this.density;
            TextView textView = (TextView) view;
            if (textView.getTextSize() != f2) {
                textView.setTextSize(0, f2);
            }
        }
    }

    private void setVisibility(View view, String str) {
        view.setVisibility(str.equalsIgnoreCase("gone") ? 8 : str.equalsIgnoreCase("invisible") ? 4 : 0);
    }

    private void updateView(View view, int i2) throws JSONException {
        if (view.getTag() == null) {
            return;
        }
        Holder holder = (Holder) view.getTag();
        this.duiCallback.setInGlobalState("cellContentView_" + i2, view);
        int i3 = 0;
        while (true) {
            View[] viewArr = holder.views;
            if (i3 >= viewArr.length) {
                return;
            }
            View view2 = viewArr[i3];
            if (view2 != null) {
                applyUpdate(view2, this.holderData.getJSONObject(i3), this.rowData.getJSONObject(i2), i2);
            }
            i3++;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.rowData.length();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = createView();
            if (view == null) {
                return new View(this.context);
            }
            view.setTag(new Holder(view));
        }
        try {
            updateView(view, i2);
        } catch (Exception unused) {
        }
        return view;
    }

    public void updateRowData(JSONArray jSONArray) {
        this.rowData = jSONArray;
    }
}
