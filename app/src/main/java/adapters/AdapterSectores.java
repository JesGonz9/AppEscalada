package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escalada.R;

import java.util.ArrayList;

import elements.Sector;


public class AdapterSectores extends RecyclerView.Adapter<AdapterSectores.ViewHolderSectores> {

    // Lista de los sectores a mostrar
    private ArrayList<Sector> sectores;

    // Constructor
    public AdapterSectores(ArrayList<Sector> sectores) {
        this.sectores = sectores;
    }

    // Metodo que enlaza este adaptador con el archivo XML que define la estructura
    @NonNull
    @Override
    public AdapterSectores.ViewHolderSectores onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Inflamos la vista con el XML de la estructura
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_sectores, null, false);

        // Se devuelve la vista
        return new ViewHolderSectores(view);
    }

    // Establece la comunicacion entre el adaptador y la clase ViewHolderSectores
    @Override
    public void onBindViewHolder(@NonNull AdapterSectores.ViewHolderSectores holder, int position) {
        holder.tvNombre.setText(sectores.get(position).getNombre());
        holder.tvGrado.setText(sectores.get(position).getRangoGrado());
        holder.tvTipoEscalada.setText(sectores.get(position).getTipoEscalada());
        holder.tvNumVias.setText(String.valueOf((sectores.get(position).getTotalVias())));
    }

    @Override
    public int getItemCount() {
        return sectores.size();
    }

    // Instanciar los elementos de cada item del RecyclerView
    class ViewHolderSectores extends RecyclerView.ViewHolder {

        TextView tvNombre;
        TextView tvGrado;
        TextView tvTipoEscalada;
        TextView tvNumVias;

        public ViewHolderSectores(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.itemSectoresTvnom);
            tvTipoEscalada = itemView.findViewById(R.id.itemSectoresTvTipoEscalada);
            tvGrado = itemView.findViewById(R.id.itemSectoresTvGrado); // Se calculara en la clase Sector getRangoGrado();
            tvNumVias = itemView.findViewById(R.id.itemSectoresTvVias);
        }
    }
}
