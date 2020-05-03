package br.inpe.dpi.terrabrasilis.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "metadata")
public class Metadata {
    
    @Id
    private String id;
    private String projecao;
    private String datumHorizontal;
    private String fonte;
    private String autor;
    private String informacoesAdicionais; 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjecao() {
        return projecao;
    }

    public void setProjecao(String projecao) {
        this.projecao = projecao;
    }

    public String getDatumHorizontal() {
        return datumHorizontal;
    }

    public void setDatumHorizontal(String datumHorizontal) {
        this.datumHorizontal = datumHorizontal;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }
}
