package com.w3g.calculaimc;

public class IMC {
 

    private String classificacao;
    private String img;
    private final float peso;
    private final float altura;
    private float resultado;


    
    public IMC(float peso, float altura) {
        this.peso = peso;
        this.altura = altura;
    }
    public float getResultado() {
        return resultado;
    }

    public String getImg() {
        return img;
    }

    public void CalculaIMC (){
        this.resultado = this.peso/(this.altura*this.altura);
    }
    public  void classificar(){
         if ( this.resultado >= 18.5 && this.resultado
                <= 24.9    ) {
            this.classificacao = "Peso Normal";
            this.img = "pesonormal";

        }  else if ( this.resultado >= 25 && this.resultado
                <= 29.9    ) {
            this.classificacao = "Sobrepeso";
            this.img = "acimapeso";
        }  else if ( this.resultado >= 30 && this.resultado
                <= 34.9    ) {
            this.classificacao = "Obesidade grau I";
            this.img = "obesidade1";

        }  else if ( this.resultado >= 35 && this.resultado
                <= 39.9    ) {
            this.classificacao = "Obesidade grau II";
            this.img = "obesidade2";
        }  else if ( this.resultado > 40) {
            this.classificacao = "Obesidade grau III";
            this.img = "obesidade3";
        }
    }


    public String getClassificacao() {
        return this.classificacao;
    }
}
