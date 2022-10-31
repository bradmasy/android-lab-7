package brad.masciotra.lab7.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import brad.masciotra.lab7.ItemClickListener;
import brad.masciotra.lab7.MyRecyclerViewAdapter;
import brad.masciotra.lab7.R;

public class SeafoodFragment extends Fragment implements ItemClickListener {

    RecyclerView recyclerView;
    String[] seafoodArray;
    int[] seafoodImages = {R.drawable.clam,R.drawable.crab,R.drawable.fillet,
            R.drawable.mussel,R.drawable.salmon,R.drawable.shrimp, R.drawable.squid};

    public SeafoodFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.seafood_fragment,container,false);
        recyclerView = view.findViewById(R.id.recyclerView);
        seafoodArray = getResources().getStringArray(R.array.seafood);

        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(getActivity(), seafoodArray, seafoodImages);
        myRecyclerViewAdapter.setClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(myRecyclerViewAdapter);

        return view;
    }

    public static VeggiesFragment newInstance(){
        VeggiesFragment veggiesFragment = new VeggiesFragment();
        Bundle bundle = new Bundle();
        return veggiesFragment;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View view, int position) {

    }
}
