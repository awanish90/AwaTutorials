package awa.com.awatutorials.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;

import awa.com.awatutorials.R;

/**
 * Created by ${Awanish} on 19/04/18.
 */

public class PlayerInputDetailFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.add_new_player_dialog,null));
        return super.onCreateDialog(savedInstanceState);
    }
}
