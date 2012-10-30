package couk.jenxsol.fragment.demo.fragments.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class AlertDialogFragment extends DialogFragment
{

    private String virtualRef = "SomeValue";

    public static AlertDialogFragment newInstance()
    {
        return new AlertDialogFragment();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        b.setTitle("My Alert Dialog");
        b.setMessage("Some alert dialog descrioption text");
        b.setPositiveButton(android.R.string.ok, null);
        return b.create();
    }

}
