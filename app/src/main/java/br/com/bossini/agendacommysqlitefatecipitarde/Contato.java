package br.com.bossini.agendacommysqlitefatecipitarde;

/**
 * Created by rodrigo on 11/05/18.
 */

public class Contato {

    private String nome, fone, email;

    public Contato (){

    }

    public Contato (String nome, String fone, String email){
        setNome(nome);
        setFone(fone);
        setEmail(email);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", fone='" + fone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
