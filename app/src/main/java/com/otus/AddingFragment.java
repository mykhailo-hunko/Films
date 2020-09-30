package com.otus;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;




public class AddingFragment extends Fragment {

    private TextInputEditText editTitle;
    private TextInputEditText editDesc;
    private MaterialButton mButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_adding, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ddd", "onCreateAdding");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("ddd", "onDestroyAdding");

    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        editDesc = v.findViewById(R.id.edit_desc_two);
        editTitle = v.findViewById(R.id.edit_title_two);
        mButton = v.findViewById(R.id.adding);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putString(MainFragment.title, editTitle.getText().toString());
                bundle.putString(MainFragment.desc, editDesc.getText().toString());
                getParentFragmentManager().setFragmentResult(MainFragment.code, bundle);
               Toast.makeText(getContext(), "Успешно добавлено",Toast.LENGTH_SHORT).show();

            }
        });

    }
}


