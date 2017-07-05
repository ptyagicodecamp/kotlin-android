package org.pcc.kotlinandroid;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.pcc.startup.model.CardViewModel;

import static org.pcc.kotlin.DefiningFunctionsKt.executeDefiningFunctions1;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FullDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FullDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FullDetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM_TITLE = "title";
    private static final String ARG_PARAM_DESC = "description";
    private static final String ARG_PARAM_CODE_HREF = "codeHref";
    private static final String ARG_PARAM_CODE_TAG = "codeTag";
    private static final String ARG_PARAM_HREF = "href";


    // TODO: Rename and change types of parameters
    private String mTitle;
    private String mDesciption;
    private String mCodeHref;
    private String mCodeTag;
    private String mHref;

    private OnFragmentInteractionListener mListener;

    public FullDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FullDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FullDetailsFragment newInstance(CardViewModel cardItem) {
        FullDetailsFragment fragment = new FullDetailsFragment();
        Bundle args = new Bundle();

        String title = cardItem.getTitle();
        String description = cardItem.getDescription();
        String codeHref = cardItem.getCodeHref();
        String codeTag = cardItem.getCodeTag();
        String href = cardItem.getHref();

        args.putString(ARG_PARAM_TITLE, title);
        args.putString(ARG_PARAM_DESC, description);
        args.putString(ARG_PARAM_CODE_HREF, codeHref);
        args.putString(ARG_PARAM_CODE_TAG, codeTag);
        args.putString(ARG_PARAM_HREF, href);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(ARG_PARAM_TITLE);
            mDesciption = getArguments().getString(ARG_PARAM_DESC);
            mCodeHref = getArguments().getString(ARG_PARAM_CODE_HREF);
            mCodeTag = getArguments().getString(ARG_PARAM_CODE_TAG);
            mHref = getArguments().getString(ARG_PARAM_HREF);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_full_details, container, false);

        TextView tvTitle = (TextView) root.findViewById(R.id.leafTitle);
        TextView tvDesc = (TextView) root.findViewById(R.id.leafDesc);
        WebView codeWebview = (WebView) root.findViewById(R.id.codeWebview);
        final TextView codeOutput = (TextView) root.findViewById(R.id.codeOutput);
        Button runCode = (Button) root.findViewById(R.id.runCode);
        TextView tvRef = (TextView) root.findViewById(R.id.href);
        tvRef.setMovementMethod(LinkMovementMethod.getInstance());

        tvTitle.setText(mTitle);
        tvDesc.setText(mDesciption);
        codeWebview.getSettings().setJavaScriptEnabled(true);
        codeWebview.loadUrl(mCodeHref);

        tvRef.setText(Html.fromHtml("<a href=\"" + mHref + "\">More...</a>"));

        runCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Executing highlighted code block", Toast.LENGTH_SHORT).show();
                codeOutput.setText("Code output: " + executeCodeTag());
            }
        });

        return root;
    }

    /**
     * This method holds the mapping of codeTag and the functions/methods to be executed at run time
     * @return
     */
    public String executeCodeTag() {
        String output = "";
        if (mCodeTag != null && !mCodeTag.isEmpty() &&
                mCodeTag.equals("executeDefiningFunctions1")) {
            output = String.valueOf(executeDefiningFunctions1());
        }
        return output;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
