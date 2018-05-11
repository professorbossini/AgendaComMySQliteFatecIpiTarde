package br.com.bossini.agendacommysqlitefatecipitarde;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rodrigo on 11/05/18.
 */

public class ContatoDAO {

    private Context context;

    public ContatoDAO(Context context){
        this.context = context;
    }

    public void inserir (Contato contato){
        ContentValues cv = new ContentValues();
        cv.put("nome", contato.getNome());
        cv.put("fone", contato.getFone());
        cv.put ("email", contato.getEmail());
        DBHelper helper =  new DBHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.insert("contato", null, cv);
        db.close();
        helper.close();
    }

    public List <Contato> listar (){
        List <Contato> contatos = new ArrayList <>();
        DBHelper helper = new DBHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        //String [] colunas = {"nome", "fone", "email"};
        Cursor cursor = db.query("contato", null, null, null, null, null, null);
        while (cursor.moveToNext()){
            String nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"));
            String fone = cursor.getString(cursor.getColumnIndexOrThrow("fone"));
            String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));
            Contato contato = new Contato (nome, fone, email);
            contatos.add(contato);
        }
        cursor.close();
        db.close();
        helper.close();
        return contatos;
    }
}
