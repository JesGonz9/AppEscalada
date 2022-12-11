package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escalada.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

import elements.Escuela;

public class AdapterEscuelas extends RecyclerView.Adapter<AdapterEscuelas.ViewHolderEscuelas> {

    // Lista de escuelas que se mostraran
    ArrayList<Escuela> escuelas = new ArrayList<>();

    // Constructor
    public AdapterEscuelas(ArrayList<Escuela> escuelas) {
        this.escuelas = escuelas;
    }

    // Metodo que asocia el adapter con el archivo XML que contiene la estructura de cada item
    @NonNull
    @Override
    public AdapterEscuelas.ViewHolderEscuelas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Inflar la vista con el layout personalizado para cada item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_escuelas, null, false);

        // Devolvemos el adapter con la vista creada
        return new AdapterEscuelas.ViewHolderEscuelas(view);
    }

    // Metodo que relaciona el adaptador con la clase ViewHolder
    @Override
    public void onBindViewHolder(@NonNull AdapterEscuelas.ViewHolderEscuelas holder, int position) {

        // Añadir el contenido a las vistas de cada item
        holder.tvNombre.setText(escuelas.get(position).getNombre());
        holder.tvTipoRoca.setText(escuelas.get(position).getTipoRoca());
        holder.tvProvincia.setText(escuelas.get(position).getProvincia());
        holder.tvNumSectores.setText(String.valueOf(escuelas.get(position).getNumSectores()));
    }

    // Devuelve el tamaño de la lista mostrada
    @Override
    public int getItemCount() {
        return escuelas.size();
    }

    // Instancia los elementos de cada item que contiene el recyclerView
    class ViewHolderEscuelas extends RecyclerView.ViewHolder {

        // Elementos de la vista
        TextView tvNombre;
        TextView tvTipoRoca;
        TextView tvProvincia;
        TextView tvNumSectores;

        public ViewHolderEscuelas(@NonNull View itemView) {
            super(itemView);

            // Instanciar elementos
            tvNombre = itemView.findViewById(R.id.itemEscuelasTvNombre);
            tvTipoRoca = itemView.findViewById(R.id.itemEscuelasTvTipoRoca);
            tvProvincia = itemView.findViewById(R.id.itemEscuelasTvProvincia);
            tvNumSectores = itemView.findViewById(R.id.itemEscuelasTvNumSectores);
        }
    }
}
