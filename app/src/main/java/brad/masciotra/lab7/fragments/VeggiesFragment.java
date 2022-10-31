package brad.masciotra.lab7.fragments;

import android.os.Bundle;
import android.util.Log;
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

public class VeggiesFragment extends Fragment implements ItemClickListener {

    RecyclerView recyclerView;
    String[] veggieArray;
    String[] prices;
    int[] veggieImages = {R.drawable.cabbage,R.drawable.carrot,R.drawable.cauliflower,
            R.drawable.lettuce,R.drawable.mushroom,R.drawable.onion, R.drawable.spinach,
            R.drawable.tomatoes};

    public VeggiesFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.veggie_fragment,container,false);
        recyclerView = view.findViewById(R.id.recyclerView);
        veggieArray = getResources().getStringArray(R.array.vegetables);
        prices = getResources().getStringArray(R.array.vegetables_prices);

        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(getActivity(),veggieArray,prices,veggieImages);
        myRecyclerViewAdapter.setClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(myRecyclerViewAdapter);

        return view;
    //    return inflater.inflate(R.layout.veggie_fragment,container,false);
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
