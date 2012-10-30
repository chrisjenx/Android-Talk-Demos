package couk.jenxsol.fragment.demo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import couk.jenxsol.fragment.demo.R;
import couk.jenxsol.fragment.demo.fragments.dialogs.AlertDialogFragment;

public class Welcome2Fragment extends Fragment implements OnClickListener
{

    private Button mClickMeButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_welcome2, container, false);
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState)
    {
        super.onViewCreated(v, savedInstanceState);

        mClickMeButton = (Button) v.findViewById(R.id.welcome_button);
        mClickMeButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.welcome_button:
                openDialog();
                break;

            default:
                break;
        }
    }

    private void openDialog()
    {
        AlertDialogFragment.newInstance().show(getFragmentManager(), null);
    }

}
