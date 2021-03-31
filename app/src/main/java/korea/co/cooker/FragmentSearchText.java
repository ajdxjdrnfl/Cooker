package korea.co.cooker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class FragmentSearchText extends Fragment {
    RecyclerView recyclerView;
    SearchTextAdapter adapter;
    FragmentSearchResult fragmentSearchResult;
    SearchActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (SearchActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_searchtext, container, false);
        recyclerView =  rootView.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false);

        adapter = new SearchTextAdapter(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.addItem(new SearchText("박보영"));
        adapter.addItem(new SearchText("박보영 프로필"));
        adapter.addItem(new SearchText("박보영 나이"));
        adapter.addItem(new SearchText("박보영 소속사"));

        adapter.setOnItemClickListener(new SearchTextListener() {
            @Override
            public void onItemClick(View v, int position) {
                fragmentSearchResult = new FragmentSearchResult();
                Bundle result = new Bundle();
                result.putString("result",adapter.getItem(position).getText());
                activity.replaceResultFragment();
            }
        });

        return rootView;
    }

}
