package co.edu.reto1.ui.artist;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.edu.reto1.R;
import co.edu.reto1.adapter.ArtistaAdapter;
import co.edu.reto1.model.Artista;


public class ArtistFragment extends Fragment {

    @BindView(R.id.listViewArtistas)
    ListView listViewArtistas;

    @BindView(R.id.editTextArtistas)
    EditText editTextArtistas;

    ArtistaAdapter artistaAdapter;

    private List<Artista> artistas;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_artist, container, false);
        ButterKnife.bind(this,root);
        loadInformation();
        artistaAdapter=new ArtistaAdapter(getContext(),artistas);
        listViewArtistas.setAdapter(artistaAdapter);
        setEditTextWatcher();

        return root;
    }

    private void setEditTextWatcher(){
        editTextArtistas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                artistaAdapter.getFilter().filter(s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                artistaAdapter.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void loadInformation() {
        cargarLista();   }

    public List<Artista> cargarLista(){
        artistas=new ArrayList<>();
        artistas.add(new Artista(R.drawable.black_pumas,getString(R.string.nombre_black_pumas),getString(R.string.descripcion_Black_Pumas)));
        artistas.add(new Artista(R.drawable.el_cuarteto_de_nos,getString(R.string.nombre_cuarteto_de_nos),getString(R.string.descripcion_cuarteto_de_nos)));
        artistas.add(new Artista(R.drawable.soda_stereo,getString(R.string.nombre_soda_stero),getString(R.string.descripcion_soda_stero)));
        artistas.add(new Artista(R.drawable.black_keys,getString(R.string.nombre_black_keys),getString(R.string.descripcion_black_keys)));
        artistas.add(new Artista(R.drawable.linking_park,getString(R.string.nombre_linking_park),getString(R.string.descripcion_linking_park)));
    return artistas;
    }







}