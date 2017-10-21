package tw.skyarrow.ehreader.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import tw.skyarrow.ehreader.R;

/**
 * Created by apple on 2017/10/20.
 */

public class ExHentaiHepler {

    private static ExHentaiHepler instance;
    private Context context;
    private SharedPreferences preferences;
    private String PREF_INTO_EX;


    private ExHentaiHepler(Context context) {
        this.context = context;
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        PREF_INTO_EX = context.getString(R.string.pref_into_ex);

        setIsEx(false);
    }

    public static ExHentaiHepler getInstance(Context context) {
        if (instance == null) {
            instance = new ExHentaiHepler(context);
        }
        return instance;
    }

    public boolean isEx() {
        return preferences.getBoolean(PREF_INTO_EX, false);
    }

    public void setIsEx(boolean isEx) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(PREF_INTO_EX, isEx);
        editor.apply();
        Log.d("Set isEx to ", isEx + "");
    }
}
