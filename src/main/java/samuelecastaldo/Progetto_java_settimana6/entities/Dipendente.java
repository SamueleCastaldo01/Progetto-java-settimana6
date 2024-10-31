package samuelecastaldo.Progetto_java_settimana6.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "dipendenti")
public class Dipendente {
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    @Column(name = "avatar_url")
    private String avatarUrl;

    public Dipendente() {}

    public Dipendente(String username, String nome, String cognome, String email, String avatarUrl) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.avatarUrl = avatarUrl;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "Dipendente{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
