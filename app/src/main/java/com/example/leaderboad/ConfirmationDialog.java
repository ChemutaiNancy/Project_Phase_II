package com.example.leaderboad;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ConfirmationDialog extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.layout_dialog, null);
        alertDialog.setView(view).setNegativeButton( "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                AlertDialog.Builder negativeDialog = new AlertDialog.Builder(getActivity());
                LayoutInflater negativeInflator = getActivity().getLayoutInflater();
                View negativeView = negativeInflator.inflate(R.layout.negative_dialog, null);
                negativeDialog.setView(negativeView);
            }
        } )
                .setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AlertDialog.Builder positiveDialog = new AlertDialog.Builder(getActivity());
                        LayoutInflater positiveInflater = getActivity().getLayoutInflater();
                        View positiveView = positiveInflater.inflate(R.layout.positive_dialog, null);
                        positiveDialog.setView(positiveView);
                    }
                } );

        return alertDialog.create();

    }

}
