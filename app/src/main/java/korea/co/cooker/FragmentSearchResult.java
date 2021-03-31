package korea.co.cooker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class FragmentSearchResult extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_searchresult, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        SearchResultAdapter adapter = new SearchResultAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        adapter.addItem(new SearchResult("제육볶음","한정훈", "2021-03-30",0));
        adapter.addItem(new SearchResult("김치찜", "한정훈", "2020-09-23", 0));
        adapter.addItem(new SearchResult("계란말이", "박보영", "2021-03-30", 0));
        return rootView;
    }
}
