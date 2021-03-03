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
import co.edu.reto1.model.Cancion;


public class ArtistFragment extends Fragment {

    @BindView(R.id.listViewArtistas)
    ListView listViewArtistas;

    @BindView(R.id.editTextArtistas)
    EditText editTextArtistas;

    ArtistaAdapter artistaAdapter;

    private List<Artista> artistas;
    private Cancion cancionArtista1=new Cancion(R.raw.colors,"Colors","Black Pumas");
    private Cancion cancionArtista2=new Cancion(R.raw.contra,"contrapunto para humano y computadora","jueves no viernes");
    private Cancion cancionArtista3=new Cancion(R.raw.soda,"En la Ciudad de la Furia","Soda Stero");
    private Cancion cancionArtista4=new Cancion(R.raw.song,"Little black submarines","El camino");
    private Cancion cancionArtista5=new Cancion(R.raw.link,"no more sorrow","Minutes to Midnigth");

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
        artistas.add(new Artista(R.drawable.black_pumas,getString(R.string.nombre_black_pumas),getString(R.string.descripcion_Black_Pumas),cancionArtista1));
        artistas.add(new Artista(R.drawable.el_cuarteto_de_nos,getString(R.string.nombre_cuarteto_de_nos),getString(R.string.descripcion_cuarteto_de_nos),cancionArtista2));
        artistas.add(new Artista(R.drawable.soda_stereo,getString(R.string.nombre_soda_stero),getString(R.string.descripcion_soda_stero),cancionArtista3));
        artistas.add(new Artista(R.drawable.black_keys,getString(R.string.nombre_black_keys),getString(R.string.descripcion_black_keys),cancionArtista4));
        artistas.add(new Artista(R.drawable.linking_park,getString(R.string.nombre_linking_park),getString(R.string.descripcion_linking_park),cancionArtista5));
    return artistas;
    }







}