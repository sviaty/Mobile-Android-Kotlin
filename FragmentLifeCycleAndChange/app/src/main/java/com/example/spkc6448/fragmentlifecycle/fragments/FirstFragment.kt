package com.example.spkc6448.fragmentlifecycle.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spkc6448.fragmentlifecycle.R
import com.example.spkc6448.fragmentlifecycle.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    companion object {
        fun newInstance(): FirstFragment {
            return FirstFragment()
        }
    }

    // Appelée en premier, même avant la méthode onCreate ().
    // Cette méthode nous a permis de savoir que notre Fragment était associé à une activité.
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d("Fragment life cycle ", "onAttach")
    }

    // Appelé lors de la création du fragment. Cela signifie qu’une nouvelle instance de fragment s’initialise,
    // ce qui se produit toujours après l’attachement à l’hôte.
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
        Log.d("Fragment life cycle ", "onCreateView")

        setupListenner()
    }

    // Appelé lorsqu'il sera temps pour le fragment de dessiner son interface utilisateur (interface utilisateur) pour la première fois.
    // Pour dessiner une interface utilisateur pour notre fragment, nous devons renvoyer un composant View de cette méthode qui constitue
    // la racine de la présentation de notre fragment.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Fragment life cycle ", "onViewCreated")
    }

    // Appelée après la méthode onCreateView () lors de la création de l'activité de l'hôte.
    // Cette méthode indique que l'activité onCreate () est terminée.
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("Fragment life cycle ", "onActivityCreated")
    }

    // Appelée une fois que le fragment est visible.
    override fun onStart() {
        super.onStart()
        Log.d("Fragment life cycle ", "onStart")
    }

    // Appelée lorsque le fragment est visible et que l'utilisateur peut intéragir avec.
    override fun onResume() {
        super.onResume()
        Log.d("Fragment life cycle ", "onResume")
    }

    // Appelée quand l'utilisateur quitte le fragment actuel ou que le fragment n'est plus interagissable.
    // Cela se produit lorsqu'une transformation de fragment ou un fragment est supprimé.
    override fun onPause() {
        super.onPause()
        Log.d("Fragment life cycle ", "onPause")
    }

    // Appelée après la méthode onPause (). Un fragment doit être arrêté en appelant onStop ().
    // Cette méthode appelle lorsque le fragment n'est plus visible.
    override fun onStop() {
        super.onStop()
        Log.d("Fragment life cycle ", "onStop")
    }

    // Appelée lorsque la vue et les autres ressources associées créées dans la méthode onCreateView ()
    // sont supprimées de la hiérarchie de la vue de l'activité et détruites.
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Fragment life cycle ", "onDestroyView")
    }

    // Appelée pour effectuer le nettoyage final de l'état du fragment, mais il n'est pas garanti qu'elle soit
    // appelée par la plateforme Android. Cette méthode a appelé la méthode onDestroyView ().
    override fun onDestroy() {
        super.onDestroy()
        Log.d("Fragment life cycle ", "onDestroy")
    }

    // Appelée après la méthode onDestroy () pour notifier que le fragment a été dissocié de son activité
    // d’hébergement signifie que Fragment est détaché de son activité hôte.
    override fun onDetach() {
        super.onDetach()
        Log.d("Fragment life cycle ", "onDetach")
    }

    private fun setupListenner(){
        btn_go_to_second_frgmt.setOnClickListener {
            goToSecondFragment()
        }
    }

    private fun goToSecondFragment(){
        val secondFrgmt = SecondFragment.newInstance()
        val activity = this.activity as MainActivity
        activity.changeFragment(secondFrgmt)
    }
}