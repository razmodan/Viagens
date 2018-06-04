package br.com.raniel.viagens.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.com.raniel.viagens.R;
import br.com.raniel.viagens.dao.PacoteDAO;
import br.com.raniel.viagens.model.Pacote;
import br.com.raniel.viagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(TITULO_APPBAR);

        configuraLista();

        Intent intent = new Intent(this, ResumoPacoteActivity.class);
        startActivity(intent);
    }

    private void configuraLista() {
        ListView listaPacotes = findViewById(R.id.lista_pacotes_listview);

        List<Pacote> pacotes = new PacoteDAO().lista();

        listaPacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }
}
