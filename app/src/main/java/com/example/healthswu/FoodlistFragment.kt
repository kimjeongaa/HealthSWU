package com.example.healthswu

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FoodlistFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FoodlistFragment : Fragment() {
    lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // 2. Context를 Activity로 형변환하여 할당
        mainActivity = context as MainActivity
    }

    private var gender: Int = 1
    private var weight: Int = 50
    private var type: Int = 1
    private val food_DataArray:ArrayList<FoodData> = ArrayList()
    lateinit var recyclerView1: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onStart() {
        super.onStart()
        var cal = mainActivity.findViewById<TextView>(R.id.edtCal)
        when (type) {
            1 -> cal.text = (30 * weight).toString() +"kcal"
            2 -> cal.text = (40 * weight).toString() +"kcal"
            else -> cal.text = "50"
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_foodlist, container, false)
        food_DataArray.add(FoodData("food01", "그릭요거트", "150kcal"))
        food_DataArray.add(FoodData("food02", "두부쌈밥", "200kcal"))
        food_DataArray.add(FoodData("food03", "닭가슴살 겨자냉채", "320kcal"))

        recyclerView1 = rootView.findViewById(R.id.mRecyclerView) as RecyclerView
        recyclerView1.layoutManager = LinearLayoutManager(requireContext())
        recyclerView1.adapter=FoodAdapter(requireContext(),food_DataArray)
        // Inflate the layout for this fragment
        return rootView
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FoodlistFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FoodlistFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}